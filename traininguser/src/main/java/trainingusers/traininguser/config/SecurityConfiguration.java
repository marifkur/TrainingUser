package trainingusers.traininguser.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.authentication.builders.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;

@EnableWebMvcSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource ds;

    private static final String SQL_LOGIN
            = "select username, password, status as enabled "
            +"from user where username = ? ";

    private static final String SQL_PERMISSION
            ="select u.username, r.name_role as authority "
            +"from user u join user_role ur on u.username=ur.username "
            +"join role r on ur.id_role=r.id_role "
            +"where u.username = ? ";


    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
       auth
               .jdbcAuthentication()
               .dataSource(ds)
               .usersByUsernameQuery(SQL_LOGIN)
               .authoritiesByUsernameQuery(SQL_PERMISSION);
    }

    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login/loginPage")
                .permitAll()
                .defaultSuccessUrl("/user/userPage")
                .and()
                .logout();
    }

}
