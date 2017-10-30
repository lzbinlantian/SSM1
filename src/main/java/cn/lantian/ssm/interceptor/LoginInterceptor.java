package cn.lantian.ssm.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Lzbin、LANTIAN on 2017/9/29.
 *
 * @version 1.0
 * @PACKAGE_NAME cn.lantian.ssm.interceptor
 * @Dercripton 登录认证拦截器
 * @Time 15:22
 */
public class LoginInterceptor implements HandlerInterceptor {
    //进入handler方法之前执行
    //用于身份认证、身份授权
    //比如身份认证、如果认证不通过表示当前用户没有登录、需要此方法拦截不再向下执行
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        //return true 表示放行
        //return false 表示拦截
        String url = httpServletRequest.getRequestURI();
        //判断url是否是公开地址、实际使用的时候要配置在配置文件中
        //这里公开地址是登录体检的地址
        //这里判断是否有包括这一串东西
        if (url.indexOf("login.action") >= 0) {
            //如果进行登录提交、放行
            return true;
        }

        //判断session
        HttpSession session = httpServletRequest.getSession();
        String username = (String) session.getAttribute("username");

        if (username != null) {
            //身份信息存在、就放行
            return true;
        }

        //执行到这里表示都没放行、用户身份需要认证
        httpServletRequest.getRequestDispatcher("/userShow.jsp").forward(httpServletRequest, httpServletResponse);

        return false;
    }

    //进入handler方法之后、在返回modelAndView之前执行
    //应用场景从modelAndView出发 、将公用的模型数据（比如菜单导航）在这里传到视图、也可以在这里统一指定视图
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("HandlerInterceptor1...postHandle");
    }

    //执行Handler完成执行后此方法
    //应用场景、 统一的异常处理、统一日志处理

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("HandlerInterceptor1...afterCompletion");
    }
}
