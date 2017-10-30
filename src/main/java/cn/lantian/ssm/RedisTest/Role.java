package cn.lantian.ssm.RedisTest;

import java.io.Serializable;

/**
 * Created by Lzbin、LANTIAN on 2017/10/12.
 *
 * @version 1.0
 * @PACKAGE_NAME cn.lantian.ssm.RedisTest
 * @Dercripton
 * @Time 16:51
 */
public class Role implements Serializable {
    private long id;
    private String roleName;



    private String note;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
