package cn.lantian.ssm.mapper;


import cn.lantian.ssm.model.DetailOrderAndOrder;
import cn.lantian.ssm.model.Order;

import java.util.List;

public interface DetailOrderMapper {


    //一次录入订单详细
    public void createDetailOrder(DetailOrderAndOrder detailOrderAndOrder);

    //查询uuid的详细订单信息
    public List<Order> findDetailOrderById(String id);
}