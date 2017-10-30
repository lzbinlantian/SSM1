package cn.lantian.ssm.model;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * Created by Lzbin、LANTIAN on 2017/10/10.
 *
 * @version 1.0
 * @PACKAGE_NAME cn.lantian.ssm.model
 * @Dercripton
 * @Time 10:25
 */
public class log {
    private String createtime;
    private String phone;
    private String record;

    //每一页的数据行数
    private int pageSize;
    //第几页
    private int pageIndex;

    private int index;

    private String grant;


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

    public log(String phone, String record) {
        Date time = new Date(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String current = sdf.format(time);
        this.createtime = current;
        this.phone = phone;
        this.record = record;
    }

    public log() {

    }

    public String getCreatetime() {

        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRecord() {
        return record;
    }

    @Override
    public String toString() {
        return "log{" +
                "createtime='" + createtime + '\'' +
                ", phone='" + phone + '\'' +
                ", record='" + record + '\'' +
                ", pageSize=" + pageSize +
                ", pageIndex=" + pageIndex +
                ", index=" + index +
                ", grant='" + grant + '\'' +
                '}';
    }

    public void setRecord(String record) {
        this.record = record;
    }
}
