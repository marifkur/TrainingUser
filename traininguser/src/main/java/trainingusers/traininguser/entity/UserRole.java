package trainingusers.traininguser.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user_role")
public class UserRole implements Serializable {

    @Id
    private String idUr;

    @OneToOne
    @JoinColumn(name="username", nullable = false)
    private User user;

    @OneToOne
    @JoinColumn(name="idRole", nullable = false)
    private Role role;

    private boolean status;

    public UserRole() {
    }

    public UserRole(User user, Role role) {
        this.user = user;
        this.role = role;
        this.status=false;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "user=" + user +
                ", role=" + role +
                ", status=" + status +
                '}';
    }
}
