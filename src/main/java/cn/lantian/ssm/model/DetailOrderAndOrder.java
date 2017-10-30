package cn.lantian.ssm.model;

/**
 * Created by Lzbin、LANTIAN on 2017/10/17.
 *
 * @version 1.0
 * @PACKAGE_NAME cn.lantian.ssm.model
 * @Dercripton
 * @Time 3:50
 */
public class DetailOrderAndOrder {
    private DetailOrder detailOrder;
    private Order order;
    private String uuid;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public DetailOrderAndOrder() {
    }

    public DetailOrderAndOrder(DetailOrder detailOrder, Order order) {
        this.detailOrder = detailOrder;
        this.order = order;
    }

    public DetailOrderAndOrder(DetailOrder detailOrder, Order order, String uuid) {
        this.detailOrder = detailOrder;
        this.order = order;
        this.uuid = uuid;
    }

    public DetailOrder getDetailOrder() {
        return detailOrder;
    }

    public void setDetailOrder(DetailOrder detailOrder) {
        this.detailOrder = detailOrder;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
