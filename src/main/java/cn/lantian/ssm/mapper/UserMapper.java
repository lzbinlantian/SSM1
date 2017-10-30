package cn.lantian.ssm.mapper;

import cn.lantian.ssm.model.Order;
import cn.lantian.ssm.model.User;

import java.util.List;

public interface UserMapper {
    //登录
    public User findUserByPhone(String phone);

    //创建用户
    public void createUser(User user);

    //删除用户
    public void dropUser(List<String> phoneList);

    //权限修改
    public void grantAll(User user);

    //查看用户
    public List<User> selectAll(User user);

    //查看多少个用户
    public int countnum();

    //修改密码
    public void updatePassword(User user);

    public List<User> findUserByGrant(User user);

    public int countUserByGrant(User user);
}