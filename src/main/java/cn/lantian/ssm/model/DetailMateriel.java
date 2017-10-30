package cn.lantian.ssm.model;

public class DetailMateriel {
    private Integer detail_Materiel_Id;

    //材料名字
    private String name;

    //材料密度
    private String density;

    //规格尺寸(厚度)
    private String size;

    //计价单位
    private String chargeunit;

    //单价
    private float unitprice;

    //用于接收每一页的数据行数
    private int pageSize;
    //第几页
    private int pageIndex;
    //类别  zike、亚克力
    private String sort;

    private int index;

    private String phone;

    //灯总价格
    private float totalprice;

    //灯总功率
    private String totalP;

    public float getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(float totalprice) {
        this.totalprice = totalprice;
    }

    public String getTotalP() {
        return totalP;
    }

    public void setTotalP(String totalP) {
        this.totalP = totalP;
    }

    @Override
    public String toString() {
        return "DetailMateriel{" +
                "detail_Materiel_Id=" + detail_Materiel_Id +
                ", name='" + name + '\'' +
                ", density='" + density + '\'' +
                ", size='" + size + '\'' +
                ", chargeunit='" + chargeunit + '\'' +
                ", unitprice=" + unitprice +
                ", pageSize=" + pageSize +
                ", pageIndex=" + pageIndex +
                ", sort='" + sort + '\'' +
                ", index=" + index +
                ", phone='" + phone + '\'' +
                ", totalprice=" + totalprice +
                ", totalP='" + totalP + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    //返回示意
    private String message;


    public Integer getDetail_Materiel_Id() {
        return detail_Materiel_Id;
    }

    public void setDetail_Materiel_Id(Integer detail_Materiel_Id) {
        this.detail_Materiel_Id = detail_Materiel_Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDensity() {
        return density;
    }

    public void setDensity(String density) {
        this.density = density;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getChargeunit() {
        return chargeunit;
    }

    public void setChargeunit(String chargeunit) {
        this.chargeunit = chargeunit;
    }

    public float getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(float unitprice) {
        this.unitprice = unitprice;
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

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DetailMateriel() {

    }
}

