package cn.lantian.ssm.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Lzbin、LANTIAN on 2017/9/29.
 *
 * @version 1.0
 * @PACKAGE_NAME cn.lantian.ssm.interceptor
 * @Dercripton
 * @Time 15:22
 */
public class HandlerInterceptor1 implements HandlerInterceptor {
    //进入handler方法之前执行
    //用于身份认证、身份授权
    //比如身份认证、如果认证不通过表示当前用户没有登录、需要此方法拦截不再向下执行
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        //return true 表示放行
        //return false 表示拦截
        //System.out.println("HandlerInterceptor1...preHandle");
        System.out.println("进入过滤器....");
        String username = (String) httpServletRequest.getSession().getAttribute("username");
        if (httpServletRequest.getRequestURI().contains("/login")) {
            return true;
        } else if (username != null) {
            return true;
        } else {
            httpServletRequest.getRequestDispatcher("/login.jsp").forward(httpServletRequest, httpServletResponse);
        }
        return false;

       //return true;
    }

    //进入handler方法之后、在返回modelAndView之前执行
    //应用场景从modelAndView出发 、将公用的模型数据（比如菜单导航）在这里传到视图、也可以在这里统一指定视图
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        //System.out.println("HandlerInterceptor1...postHandle");
    }

    //执行Handler完成执行后此方法
    //应用场景、 统一的异常处理、统一日志处理

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        //System.out.println("HandlerInterceptor1...afterCompletion");

    }
}
