package cn.lantian.ssm.model;

import java.util.List;

/**
 * Created by Lzbin、LANTIAN on 2017/10/11.
 *
 * @version 1.0
 * @PACKAGE_NAME cn.lantian.ssm.model
 * @Dercripton
 * @Time 3:30
 */
public class logAndCount {
    private List<log> logList;
    private int num;

    public logAndCount() {
    }

    public List<log> getLogList() {
        return logList;
    }

    public void setLogList(List<log> logList) {
        this.logList = logList;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public logAndCount(List<log> logList, int num) {

        this.logList = logList;
        this.num = num;
    }
}
