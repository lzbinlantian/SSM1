package cn.lantian.ssm.model;

import java.util.List;

/**
 * Created by Lzbin、LANTIAN on 2017/10/9.
 *
 * @version 1.0
 * @PACKAGE_NAME cn.lantian.ssm.model
 * @Dercripton
 * @Time 23:51
 */
public class DetailMaterielAndCount {
    private List<DetailMateriel> detailMaterielList;
    private int count;

    public DetailMaterielAndCount(List<DetailMateriel> detailMaterielList, int count) {
        this.detailMaterielList = detailMaterielList;
        this.count = count;
    }

    public List<DetailMateriel> getDetailMaterielList() {
        return detailMaterielList;
    }

    public void setDetailMaterielList(List<DetailMateriel> detailMaterielList) {
        this.detailMaterielList = detailMaterielList;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
