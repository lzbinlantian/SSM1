package cn.lantian.ssm.mapper;


import cn.lantian.ssm.model.DetailOrder;
import cn.lantian.ssm.model.DetailOrderAndOrder;
import cn.lantian.ssm.model.Order;

import java.util.List;

public interface OrderMapper {
    public List<Order> findAllOrder(Order order);

    public void createOrder(DetailOrderAndOrder detailOrderAndOrder);

    public int findCount();

    //通过时间查询相关订单信息
    public List<Order> findOrderByTime(Order order);

    public DetailOrder findDetailOrderById(String id);

    public Order findOrderById(String id);

    public int countOrderByTime(Order order);
}