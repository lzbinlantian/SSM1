package cn.lantian.ssm.service;

import cn.lantian.ssm.model.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Lzbin、LANTIAN on 2017/9/25.
 *
 * @version 1.0
 * @PACKAGE_NAME cn.lantian.ssm.service
 * @Dercripton
 * @Time 9:52
 */
@Transactional
public interface service {

    /**
     * User
     *
     * @param phone
     * @return
     */
    //用于账号验证、通过手机号查询相关信息
    public User findUserByPhone(String phone);

    //创建用户
    public void createUser(User user);

    //删除此用户
    public void dropUser(List<String> phoneList);

    //权限修改
    public void grantAll(User user);

    //查询多少个用户 管理员权限
    public List<User> selectAll(User user);

    public int countnum();

    public void updatePassword(User user);

    /**
     * order
     */

    //一次录入订单表和订单详细
    public void createDetailOrderAndOrder(DetailOrderAndOrder detailOrderAndOrder);

    //查询全部的详细订单信息  uuid与订单号匹配

    //查询order记录数
    public int findCount();


    //查询全部全部订单信息
    public List<Order> findAllOrder(Order order);

    //通过时间查询相关订单信息
    public List<Order> findOrderByTime(Order order);

    //通过时间查询相关订单信息
    public int countOrderByTime(Order order);

    //通过uuid查询详细订单信息
    public DetailOrder findDetailOrderById(String id);

    //通过uuid查询订单信息
    public Order findOrderById(String id);

    /**
     * materiel
     */
    //添加材料
    public void addMateriel(DetailMateriel detailMateriel);

    //修改材料
    public void updateMateriel(DetailMateriel detailMateriel);

    //删除材料
    public void deleteMateriel(List<String> detail_Materiel_IdList);

    //查询材料列表
    public List<DetailMateriel> findAllDetailMateriel(DetailMateriel detailMateriel);

    //根据材料名查询数据
    public List<DetailMateriel> findAllDetailMaterielByName(DetailMateriel detailMateriel);

    //查询材料数量
    public int countDetailMateriel(DetailMateriel detailMateriel);

    //根据材料名查询行数
    public int countfindAllDetailMaterielByName(DetailMateriel detailMateriel);


    /**
     * log系统日志
     */
    public void addlog(log log);

    public List<log> findAllLog(log log);

    public int findAllLogNum();

    /**
     * 其他
     */

    public String getTime();

    public List<User> findUserByGrant(User user);

    public int countUserByGrant(User user);

    public List<log> findLogByTime(log log);

    public int countfindLogByTime(log log);
}
