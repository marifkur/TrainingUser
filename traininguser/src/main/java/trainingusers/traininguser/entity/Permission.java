package trainingusers.traininguser.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "permission")
public class Permission implements Serializable {

    @NotEmpty
    @Id
    private String idPermission;

    @NotEmpty
    private String namePermission;

    private boolean status;

    public Permission() {
    }

    public Permission(String idPermission, String namePermission) {
        this.idPermission = idPermission;
        this.namePermission = namePermission;
        this.status = false;
    }

    public String getIdPermission() {
        return idPermission;
    }

    public void setIdPermission(String idPermission) {
        this.idPermission = idPermission;
    }

    public String getNamePermission() {
        return namePermission;
    }

    public void setNamePermission(String namePermission) {
        this.namePermission = namePermission;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "idPermission='" + idPermission + '\'' +
                ", namePermission='" + namePermission + '\'' +
                ", status=" + status +
                '}';
    }
}
