package cn.lantian.ssm.controller;


import cn.lantian.ssm.model.*;
import cn.lantian.ssm.service.impl.serviceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

/**
 * Created by Lzbin、LANTIAN on 2017/10/6.
 *
 * @version 1.0
 * @PACKAGE_NAME cn.lantian.ssm.controller
 * @Dercripton
 * @Time 16:46
 */
@Controller
public class homeController {
    /**
     * ----------Dragon be here!----------/
     * 　　 ┏┓　  ┏┓
     * 　　┏┛┻━━━┛━┻┓
     * 　　┃　　　　  ┃
     * 　　┃    ━　  ┃
     * 　　┃　┳┛　┗┳ ┃
     * 　　┃　　　　　┃
     * 　　┃　　　┻　 ┃
     * 　　┃　　　　　┃
     * 　　┗━┓　　　┏━┛
     * 　　　　┃　　　┃神兽保佑
     * 　　　　┃　　　┃代码无BUG！
     * 　　　　┃　　　┗━━━┓
     * 　　　　┃　　　　　　　┣┓
     * 　　　　┃　　　　　　　┏┛
     * 　　　　┗┓┓┏━┳┓┏┛
     * 　　　　　┃┫┫　┃┫┫
     * 　　　　　┗┻┛　┗┻┛
     * ━━━━━━神兽出没━━━━━━by:lantian
     */
    @Resource
    private serviceImpl service;


    //用于执行exe文件
    final Runtime runtime = Runtime.getRuntime();

    //final File txtPath = new File("input.txt");


    //返回生成报价单(具体一条）
    //返回报价记录（多条）


    //返回报价记录（多条）
    @RequestMapping("/findAllOrder")
    public @ResponseBody
    OrderAndCount findAllOrder(Order order) {
        OrderAndCount orderAndCount = null;
        try {
            order.setIndex((order.getPageIndex() - 1) * order.getPageSize());
            orderAndCount = new OrderAndCount(service.findAllOrder(order), service.findCount());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return orderAndCount;
    }

    //添加材料管理
    @RequestMapping("/addMateriel")
    public @ResponseBody
    DetailMateriel addMateriel(DetailMateriel detailMateriel, HttpSession session) {
        User admin = (User) session.getAttribute("user");
        //截取百分号
        if (detailMateriel.getDensity().contains("%")) {
            detailMateriel.setDensity(detailMateriel.getDensity().substring(0, detailMateriel.getDensity().length() - 1));
        }
        try {

            service.addMateriel(detailMateriel);
            detailMateriel.setMessage("1");
        } catch (Exception e) {
            detailMateriel.setMessage("0");
        }
        service.addlog(new log(admin.getPhone(), admin.getName() + "新添了" + detailMateriel.getName() + "材料"));
        return detailMateriel;
    }


    //删除材料
    @RequestMapping("/deleteMateriel")
    public @ResponseBody
    User
    deleteDetailMateriel(@RequestParam(value = "detail_Materiel_IdList[]") String[] detail_Materiel_IdList, HttpSession session) {
        User admin = (User) session.getAttribute("user");
        try {
            admin.setMessage("删除成功");
            service.deleteMateriel(Arrays.asList(detail_Materiel_IdList));
        } catch (Exception e) {
            admin.setMessage("删除成功");
            e.printStackTrace();
        }
        service.addlog(new log(admin.getPhone(), admin.getName() + "删除了" + Arrays.toString(detail_Materiel_IdList) + "材料"));
        return admin;
    }

    //修改数据
    @RequestMapping("/updateMateriel")
    public @ResponseBody
    DetailMateriel updateMateriel(DetailMateriel detailMateriel, HttpSession session) {
        User admin = (User) session.getAttribute("user");
        //截取百分号
        if (detailMateriel.getDensity().contains("%")) {
            detailMateriel.setDensity(detailMateriel.getDensity().substring(0, detailMateriel.getDensity().length() - 1));
        }

        try {
            detailMateriel.setMessage("修改成功");
            service.updateMateriel(detailMateriel);
        } catch (Exception e) {
            detailMateriel.setMessage("修改成功");
        }
        service.addlog(new log(admin.getPhone(), admin.getName() + "修改了" + detailMateriel.getDetail_Materiel_Id() + "材料"));
        return detailMateriel;
    }


    //返回材料记录
    //detailMateriel.setIndex((detailMateriel.getPageIndex() - 1) * detailMateriel.getPageSize());
    @RequestMapping("/findDetailMateriel")
    public @ResponseBody
    DetailMaterielAndCount findDetailMateriel(DetailMateriel detailMateriel) {
        detailMateriel.setIndex((detailMateriel.getPageIndex() - 1) * detailMateriel.getPageSize());
        return new DetailMaterielAndCount(service.findAllDetailMateriel(detailMateriel), service.countDetailMateriel(detailMateriel));
    }

    //setIndex((order.getPageIndex() - 1) * order.getPageSize());
    @RequestMapping("/createUser")
    public @ResponseBody
    User createUser(User user, HttpSession session) {
        User admin = (User) session.getAttribute("user");
        try {
            user.setMessage("添加成功");
            service.createUser(user);

        } catch (Exception e) {
            user.setMessage("添加成功");
        }

        service.addlog(new log(user.getPhone(), admin.getName() + "新添加了" + user.getPhone() + "并赋予" + user.getGrant() + "权限"));
        return user;
    }


    @RequestMapping("/dropUser")
    public @ResponseBody
    User
    dropUser(@RequestParam(value = "phoneList[]") String[] phone, HttpSession session) {
        User user1 = new User();
        User admin = (User) session.getAttribute("user");
        try {
            user1.setMessage("删除成功");
            service.dropUser(Arrays.asList(phone));

        } catch (Exception e) {
            e.printStackTrace();
            user1.setMessage("删除成功");
        }
        service.addlog(new log(admin.getPhone(), admin.getName() + "删除了" + Arrays.toString(phone) + "账号"));
        return user1;
    }


    @RequestMapping("/grant")
    public @ResponseBody
    User
    grantAll(User user, HttpSession session) {
        User admin = (User) session.getAttribute("user");
        try {
            user.setMessage("授权成功");
            service.grantAll(user);
        } catch (Exception e) {
            user.setMessage("授权成功");
        }
        service.addlog(new log(admin.getPhone(), admin.getName() + "将" + user.getPhone() + "权限变更为" + user.getGrant() + "操作"));

        return user;
    }

    //修改密码
    @RequestMapping("/updatePassword")
    public @ResponseBody
    User
    updatePassword(User user, HttpSession session) {
        User admin = (User) session.getAttribute("user");
        try {
            user.setMessage("修改成功");
            service.updatePassword(user);
        } catch (Exception e) {
            user.setMessage("修改成功");
        }
        service.addlog(new log(admin.getPhone(), admin.getName() + "修改了" + user.getPhone() + "的密码"));
        return user;
    }

    //查询全部用户
    @RequestMapping("/selectAll")
    public @ResponseBody
    UserAndCount selectAll(User user) {
        user.setIndex((user.getPageIndex() - 1) * user.getPageSize());
        return new UserAndCount(service.selectAll(user), service.countnum());
    }

    //日志查询
    @RequestMapping("/findAllLog")
    public @ResponseBody
    logAndCount findAllLog(log log) {
        log.setIndex((log.getPageIndex() - 1) * log.getPageSize());
        logAndCount logAndCount = new logAndCount(service.findAllLog(log), service.findAllLogNum());
        return logAndCount;
    }


    //异步图片上传


    ///跳转WEB-INF/jsp/accountManagement.jsp
    @RequestMapping("/accountManagement")
    public String toAccountManagement() {
        return "accountManagement";
    }

    ///跳转WEB-INF/jsp/eventLog.jsp
    @RequestMapping("/eventLog")
    public String toEventLog() {
        return "eventLog";
    }

    ///跳转WEB-INF/jsp/homepage.jsp
    @RequestMapping("/homepage")
    public String toHomePage() {
        return "homepage";
    }

    ///跳转WEB-INF/jsp/materialManagement.jsp
    @RequestMapping("/materialManagement")
    public String toMaterialManagement() {
        return "materialManagement";
    }

    ///跳转WEB-INF/jsp/quotationRecord.jsp
    @RequestMapping("/quotationRecord")
    public String toQuotationRecord() {
        return "quotationRecord";
    }


}
