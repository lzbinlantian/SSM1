package cn.lantian.ssm.controller;

import cn.lantian.ssm.model.Student;
import cn.lantian.ssm.service.impl.serviceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Lzbin、LANTIAN on 2017/9/29.
 *
 * @version 1.0
 * @PACKAGE_NAME cn.lantian.ssm.controller
 * @Dercripton json交互测试
 * @Time 10:30
 */
@Controller
public class jsonTest {
    @Resource
    private serviceImpl service;

    //请求json 、输出json
    //@ResponseBody 对象 转 json
    //@RequestBody json 转对象
    @RequestMapping(value = "/requestJson", method = RequestMethod.POST)
    public @ResponseBody
    Student requestJson(@RequestBody Student student) {
        System.out.println(student.getName());
        return student;
    }

    /*请假key/value、输出json*/
    @RequestMapping(value = "/responseJson", method = RequestMethod.POST)
    public @ResponseBody
    Student responseJson(Student student) {
        System.out.println(student.getName());
        return student;
    }


    /*RESTful风格的传参*/
    //输出json、
    ///restfulParam/{id}/{name}  {XXX}占位符、
    //http://localhost:8080/lantian/restfulParam/1601090118/%E6%9D%8E%E6%B3%BD%E5%BD%AC
    @RequestMapping(value = "/restfulParam/{id}/{name}", method = {RequestMethod.POST, RequestMethod.GET})
    public @ResponseBody
    Student restfulParam(@PathVariable("id") String id, @PathVariable("name") String name) {
        Student student = new Student(id, name);
        return student;
    }

    /*请假key/value、输出json 请求时间*/
    @RequestMapping(value = "/requestTime", method = RequestMethod.POST)
    public @ResponseBody
    Student requestTime() {
        Student student = new Student();
        student.setDatetime(service.getTime());
        return student;
    }


}
