package cn.lantian.ssm.model;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Order {
    private String phone;

    private String uuid;

    private String customer;

    public Float getCount() {
        return count;
    }

    public void setCount(Float count) {
        this.count = count;
    }

    private Float count;

    private String createtime;

    private String height;

    private String size;

    //每一页的数据行数
    private int pageSize;
    //第几页
    private int pageIndex;

    private int index;

    public Order() {
        Date time = new Date(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String current = sdf.format(time);
        this.createtime = current;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getHeight() {

        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }


    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
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

    @Override
    public String toString() {
        return "Order{" +
                "phone='" + phone + '\'' +
                ", uuid='" + uuid + '\'' +
                ", customer='" + customer + '\'' +
                ", count=" + count +
                ", createtime='" + createtime + '\'' +
                ", pageSize=" + pageSize +
                ", pageIndex=" + pageIndex +
                ", index=" + index +
                '}';
    }

    public void setIndex(int index) {
        this.index = index;
    }
}