package cn.lantian.ssm.controller.exception;

/**
 * Created by Lzbin、LANTIAN on 2017/9/29.
 *
 * @version 1.0
 * @PACKAGE_NAME cn.lantian.ssm.controller.exception
 * @Dercripton 系统自定义异常、针对预期的异常，需要在程序中抛出此类的异常
 * @Time 0:00
 */
public class UserException1 extends Exception {
    //异常信息
    public String message;

    public UserException1(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
