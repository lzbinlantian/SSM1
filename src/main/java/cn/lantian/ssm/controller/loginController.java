package cn.lantian.ssm.controller;

import cn.lantian.ssm.model.User;
import cn.lantian.ssm.service.impl.serviceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Lzbin、LANTIAN on 2017/10/2.
 *
 * @version 1.0
 * @PACKAGE_NAME cn.lantian.ssm.controller
 * @Dercripton
 * @Time 15:36
 */
@Controller
public class loginController {
    @Resource
    private serviceImpl service;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(User user, HttpServletRequest request) {
        String phone = user.getPhone();
        String password = user.getPassword();
        if (phone != null) {
            try {
                User trueUser = service.findUserByPhone(phone);
                if (password.equals(trueUser.getPassword())) {
                    request.getSession().setAttribute("user", trueUser);
                    return "homepage";
                } else {
                    request.setAttribute("msg", "您输入的账号或密码错误！");
                    return "forward:/login.jsp";
                }
            } catch (Exception e) {
                request.setAttribute("msg", "您输入的账号或密码错误！");
                return "forward:/login.jsp";
            }
        }
        request.setAttribute("msg", "请输入账号密码！");
        return "forward:/login.jsp";
    }


    @RequestMapping(value = "/exit", method = {RequestMethod.POST, RequestMethod.GET})
    public String exit(HttpServletRequest request) {
        request.getSession().removeAttribute("user");
        return "forward:/login.jsp";
    }


}
