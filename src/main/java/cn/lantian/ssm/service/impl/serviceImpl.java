package cn.lantian.ssm.service.impl;

import cn.lantian.ssm.mapper.*;
import cn.lantian.ssm.model.*;
import cn.lantian.ssm.service.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Lzbin、LANTIAN on 2017/9/25.
 *
 * @version 1.0
 * @PACKAGE_NAME cn.lantian.ssm.service.impl
 * @Dercripton
 * @Time 12:33
 */

@Service("service")
public class serviceImpl implements service {

    //用户查询
    @Autowired
    private UserMapper userMapper;

    //订单明细
    @Autowired
    private DetailOrderMapper detailOrderMapper;

    //订单列表
    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private DetailMaterielMapper detailMaterielMapper;

    //日志系列
    @Autowired
    private logMapper logMapper;


    @Override
    public User findUserByPhone(String phone) {
        return userMapper.findUserByPhone(phone);
    }

    @Override
    public void createUser(User user) {
        userMapper.createUser(user);
    }

    @Override
    public void dropUser(List<String> phoneList) {
        userMapper.dropUser(phoneList);
    }

    @Override
    public void grantAll(User user) {
        userMapper.grantAll(user);
    }

    @Override
    public List<User> selectAll(User user) {
        return userMapper.selectAll(user);
    }

    @Override
    public int countnum() {
        return userMapper.countnum();
    }

    @Override
    public void updatePassword(User user) {
        userMapper.updatePassword(user);
    }

    @Override
    public void createDetailOrderAndOrder(DetailOrderAndOrder detailOrderAndOrder) {
        detailOrderMapper.createDetailOrder(detailOrderAndOrder);
        orderMapper.createOrder(detailOrderAndOrder);
    }

    @Override
    public int findCount() {
        return orderMapper.findCount();
    }


    @Override
    public List<Order> findAllOrder(Order order) {
        return orderMapper.findAllOrder(order);
    }

    @Override
    public List<Order> findOrderByTime(Order order) {
        return orderMapper.findOrderByTime(order);
    }

    @Override
    public int countOrderByTime(Order order) {
        return orderMapper.countOrderByTime(order);
    }

    @Override
    public DetailOrder findDetailOrderById(String id) {
        return orderMapper.findDetailOrderById(id);
    }

    @Override
    public Order findOrderById(String id) {
        return orderMapper.findOrderById(id);
    }


    @Override
    public void addMateriel(DetailMateriel detailMateriel) {
        detailMaterielMapper.addMateriel(detailMateriel);
    }


    @Override
    public List<DetailMateriel> findAllDetailMateriel(DetailMateriel detailMateriel) {
        return detailMaterielMapper.findAllDetailMateriel(detailMateriel);
    }

    @Override
    public List<DetailMateriel> findAllDetailMaterielByName(DetailMateriel detailMateriel) {
        return detailMaterielMapper.findAllDetailMaterielByName(detailMateriel);
    }


    public int countDetailMateriel(DetailMateriel detailMateriel) {
        return detailMaterielMapper.countDetailMateriel(detailMateriel);
    }

    @Override
    public int countfindAllDetailMaterielByName(DetailMateriel detailMateriel) {
        return detailMaterielMapper.countfindAllDetailMaterielByName(detailMateriel);
    }

    @Override
    public void updateMateriel(DetailMateriel detailMateriel) {
        detailMaterielMapper.updateMateriel(detailMateriel);
    }

    @Override
    public void deleteMateriel(List<String> detail_Materiel_IdList) {
        detailMaterielMapper.deleteMateriel(detail_Materiel_IdList);
    }

    @Override
    public void addlog(log log) {
        logMapper.addlog(log);
    }

    @Override
    public List<log> findAllLog(log log) {
        return logMapper.findAll(log);
    }

    @Override
    public int findAllLogNum() {
        return logMapper.findAllLogNum();
    }

    @Override
    public String getTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = sdf.format(new Date()).toString();
        return time;
    }

    @Override
    public List<User> findUserByGrant(User user) {
        return userMapper.findUserByGrant(user);
    }

    @Override
    public int countUserByGrant(User user) {
        return userMapper.countUserByGrant(user);
    }

    @Override
    public List<log> findLogByTime(log log) {
        return logMapper.findLogByTime(log);
    }

    @Override
    public int countfindLogByTime(log log) {
        return logMapper.countfindLogByTime(log);
    }


}
