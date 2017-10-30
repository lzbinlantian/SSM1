package cn.lantian.ssm.model;

import java.util.List;

/**
 * Created by Lzbin、LANTIAN on 2017/10/18.
 *
 * @version 1.0
 * @PACKAGE_NAME cn.lantian.ssm.model
 * @Dercripton
 * @Time 23:36
 */
public class OrderAndCount {
    private List<Order> order;
    private int count;



    private String phone;

    @Override
    public String toString() {
        return "OrderAndCount{" +
                "order=" + order +
                ", count=" + count +
                '}';
    }
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Order> getOrder() {
        return order;
    }

    public void setOrder(List<Order> order) {
        this.order = order;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public OrderAndCount(List<Order> order, int count) {

        this.order = order;
        this.count = count;
    }
}
