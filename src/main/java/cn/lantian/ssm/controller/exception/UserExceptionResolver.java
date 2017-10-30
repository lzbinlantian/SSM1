package cn.lantian.ssm.controller.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Lzbin、LANTIAN on 2017/9/29.
 *
 * @version 1.0
 * @PACKAGE_NAME cn.lantian.ssm.controller.exception
 * @Dercripton 全局异常从
 * @Time 0:10
 */
public class UserExceptionResolver implements HandlerExceptionResolver {
    /**
     * resolveException
     * Description:
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e 系统抛出的异常
     * @return
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        //hanler就是处理器适配器要执行的handler对象（只有method）

        //解析出异常类型行
        //如果该异常类型是系统自定义的异常信息、在错误页面展示
       /* String message = null;

        if (e instanceof UserException1) {
            message = e.getMessage();
        } else {
        //如果该 异常类型不是系统自定义异常、构造一个自定义的异常类型（信息“未知错误”）
            message = "位置错误";
        }*/


        //上边的代码变为x
        UserException1 userException1 = null;
        if (e instanceof UserException1) {
            userException1 = (UserException1) e;
        } else {
            userException1 = new UserException1("未知错误");
        }

        //错误信息
        String message = userException1.getMessage();

        ModelAndView modelAndView = new ModelAndView();

        //将错误信息传到页面
        modelAndView.addObject("message", message);
        //指向错误页面
        modelAndView.setViewName("error");
        return modelAndView;
    }


}
