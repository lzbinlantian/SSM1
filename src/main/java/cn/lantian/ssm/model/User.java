package cn.lantian.ssm.model;

import java.util.List;

public class User {
    private String phone;

    private List<String> phoneList;

    public List<String> getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(List<String> phoneList) {
        this.phoneList = phoneList;
    }

    private String password;

    private String name;

    //每一页的数据行数
    private int pageSize;
    //第几页
    private int pageIndex;

    private int index;

    private String grant;

    private String message;


    @Override
    public String toString() {
        return "User{" +
                "phone='" + phone + '\'' +
                ", phoneList=" + phoneList +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", pageSize=" + pageSize +
                ", pageIndex=" + pageIndex +
                ", index=" + index +
                ", grant='" + grant + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    public User(String phone, List<String> phoneList, String password, String name, int pageSize, int pageIndex, int index, String grant, String message) {

        this.phone = phone;
        this.phoneList = phoneList;
        this.password = password;
        this.name = name;
        this.pageSize = pageSize;
        this.pageIndex = pageIndex;
        this.index = index;
        this.grant = grant;
        this.message = message;
    }

    public String getPhone() {
        return phone;

    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getGrant() {
        return grant;
    }

    public void setGrant(String grant) {
        this.grant = grant;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User() {
    }
}