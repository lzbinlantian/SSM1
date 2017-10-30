package cn.lantian.ssm.model;

import java.util.List;

/**
 * Created by Lzbin、LANTIAN on 2017/10/10.
 *
 * @version 1.0
 * @PACKAGE_NAME cn.lantian.ssm.model
 * @Dercripton
 * @Time 0:07
 */
public class UserAndCount {
    private List<User> userList;
    private int countnum;

    @Override
    public String toString() {
        return "UserAndCount{" +
                "userList=" + userList +
                ", countnum=" + countnum +
                '}';
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public int getCountnum() {
        return countnum;
    }

    public void setCountnum(int countnum) {
        this.countnum = countnum;
    }

    public UserAndCount(List<User> userList, int countnum) {

        this.userList = userList;
        this.countnum = countnum;
    }
}
