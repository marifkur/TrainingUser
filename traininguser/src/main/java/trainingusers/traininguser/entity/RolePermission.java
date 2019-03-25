package trainingusers.traininguser.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "role_permission")
public class RolePermission implements Serializable{

    @Id
    private String idRp;


    @ManyToOne
    @JoinColumn(name="idRole", nullable = false)
    private Role role;

    @ManyToOne
    @JoinColumn(name="idPermission", nullable = false)
    private Permission permission;

    private boolean status;

    public RolePermission() {
    }

    public RolePermission(Role role, Permission permission) {
        this.role = role;
        this.permission = permission;
        this.status=false;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "RolePermission{" +
                "role=" + role +
                ", permission=" + permission +
                ", status=" + status +
                '}';
    }
}
