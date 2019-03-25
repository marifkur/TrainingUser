package trainingusers.traininguser.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="role")
public class Role implements Serializable{

    @NotEmpty
    @Id
    private String idRole;

    @NotEmpty
    private String nameRole;

    private boolean status;

    @OneToMany(mappedBy = "role")
    private List<RolePermission> rolePermissions = new ArrayList<>();

    public Role() {

    }

    public Role(String idRole, String nameRole) {
        this.idRole = idRole;
        this.nameRole = nameRole;
        this.status=false;
    }

    public String getIdRole() {
        return idRole;
    }

    public void setIdRole(String idRole) {
        this.idRole = idRole;
    }

    public String getNameRole() {
        return nameRole;
    }

    public void setNameRole(String nameRole) {
        this.nameRole = nameRole;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<RolePermission> getRolePermissions() {
        return rolePermissions;
    }

    public void setRolePermissions(List<RolePermission> rolePermissions) {
        this.rolePermissions = rolePermissions;
    }

    public String getNamePermission(){
        StringBuilder sb=new StringBuilder();
        for (RolePermission r: rolePermissions){
            sb.append(r.getPermission().getNamePermission());
            sb.append(", ");
        }
        return sb.toString();
    }
    @Override
    public String toString() {
        return "Role{" +
                "idRole='" + idRole + '\'' +
                ", nameRole='" + nameRole + '\'' +
                ", status=" + status +
                '}';
    }
}
