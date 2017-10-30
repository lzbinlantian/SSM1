package cn.lantian.ssm.controller;

import cn.lantian.ssm.mapper.DetailMaterielMapper;
import cn.lantian.ssm.model.*;
import cn.lantian.ssm.service.impl.serviceImpl;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;

/**
 * Created by Lzbin、LANTIAN on 2017/10/15.
 *
 * @version 1.0
 * @PACKAGE_NAME cn.lantian.ssm
 * @Dercripton
 * @Time 20:25
 */
@Controller()
public class MainController {
    @Resource
    private serviceImpl service;

    Runtime runtime = Runtime.getRuntime();

    //JSONString转换为List集合
    final ObjectMapper mapper = new ObjectMapper();
    // 声明打印流对象
    PrintStream ps = null;
    String[] zikeresult = null;
    String[] dikeresult = null;
    String[] shuzhiresult = null;
    String[] yakeliresult = null;
    String dengresult = null;
    String[] dianyuanresult = null;
    String rengongresult = null;
    String count = null;

    String inputtxtpath = "D:\\input.txt";
    String inputjpgpath = "D:\\input.jpg";
    String resulttxtpath = "D:\\result.txt";
    String resultjpgpath = "D:\\result.jpg";
    String exepath = "cmd /cC:\\Users\\hasee\\IdeaProjects\\TheChallengeCup\\cal.exe";
    private File inputpic = null;
    private DetailOrderAndOrder detailOrderAndOrder = null;

    //返回材料记录
    //detailMateriel.setIndex((detailMateriel.getPageIndex() - 1) * detailMateriel.getPageSize());
    @RequestMapping("/main/findMateriel")
    public @ResponseBody
    DetailMaterielAndCount findDetailMateriel(DetailMateriel detailMateriel) {
        int count = 0;
        count = service.countDetailMateriel(detailMateriel);
        detailMateriel.setIndex(0);
        detailMateriel.setPageSize(count);
        return new DetailMaterielAndCount(service.findAllDetailMateriel(detailMateriel), count);
    }


    //上传文件会自动绑定到MultipartFile中
    @RequestMapping(value = "/main/createDetailOrder", method = RequestMethod.POST)
    public @ResponseBody
    DetailOrderAndOrder upload(HttpServletRequest request,
                               HttpSession httpSession,
                               @RequestParam("file") MultipartFile file,
                               @RequestParam("Luminoush") String height,
                               @RequestParam("HTK") String size,
                               @RequestParam("Customername") String customername,
                               @RequestParam("cropperdata") String cropperdata,
                               @RequestBody @RequestParam("datas") String detailOrderListStr
    ) throws Exception {


        cropperdata = cropperdata.substring(1, cropperdata.length() - 1);

        cropperdata = cropperdata.replaceAll("[a-zA-Z]", "")
                .replaceAll("\"", "").replaceAll(":", "");
        String[] cropperdatas = cropperdata.split(",");


        double x = Double.valueOf(cropperdatas[0]);
        double y = Double.valueOf(cropperdatas[1]);
        double width = Double.valueOf(cropperdatas[2]);
        double height1 = Double.valueOf(cropperdatas[3]);

        List<DetailMateriel> beanList = mapper.readValue(detailOrderListStr, new TypeReference<List<DetailMateriel>>() {
        });

        //文件读取出来之后放进去
        Order order = new Order();
        DetailOrder detailOrder = new DetailOrder();
        String uuid = String.valueOf(UUID.randomUUID().toString().replaceAll("-", "").replaceAll("[a-z\\sA-Z]", "0"));

        DetailMateriel zike = beanList.get(0);

        DetailMateriel dike = beanList.get(1);

        DetailMateriel shuzhi = beanList.get(2);

        DetailMateriel yakeli = beanList.get(3);

        DetailMateriel deng = beanList.get(4);

        DetailMateriel rengong = beanList.get(5);


        //order订单表的INPUT录入
        order.setCustomer(customername);
        //detail_materiel订单详情表的INPUT录入
        detailOrder.setZikename(zike.getName());
        detailOrder.setZikemidu(zike.getDensity());
        detailOrder.setZikehoudu(zike.getSize());
        detailOrder.setZikejijia(zike.getChargeunit());
        detailOrder.setZikedanjia(zike.getUnitprice());

        detailOrder.setDikename(dike.getName());
        detailOrder.setDikemidu(dike.getDensity());
        detailOrder.setDikehoudu(dike.getSize());
        detailOrder.setDikejijia(dike.getChargeunit());
        detailOrder.setDikedanjia(dike.getUnitprice());

        detailOrder.setShuzhiname(shuzhi.getName());
        detailOrder.setShuzhimidu(shuzhi.getDensity());
        detailOrder.setShuzhihoudu(shuzhi.getSize());
        detailOrder.setShuzhidanjia(shuzhi.getUnitprice());

        detailOrder.setYakeliname(yakeli.getName());
        detailOrder.setYakelimidu(yakeli.getDensity());
        detailOrder.setYakelihoudu(yakeli.getSize());
        detailOrder.setYakelidanjia(yakeli.getUnitprice());

        detailOrder.setDengname(deng.getName());
        detailOrder.setDenggonglv(deng.getDensity());
        detailOrder.setDengdanjia(deng.getUnitprice());
        detailOrder.setDengjijia(deng.getChargeunit());

        detailOrder.setRengongname(rengong.getName());
        detailOrder.setRengongzhanbi(String.valueOf(rengong.getUnitprice()));

        String path = request.getServletContext().getRealPath("/InOutputpic/");
        //如果文件不为空，写入上传路径
        if (!file.isEmpty()) {
            //上传文件路径
            //上传文件名
            String filename = uuid + "input.jpg";
            File filepath = new File(path, filename);
            //判断路径是否存在，如果不存在就创建一个
            if (!filepath.getParentFile().exists()) {
                filepath.getParentFile().mkdirs();
            }
            inputpic = new File(inputjpgpath);

            //再覆盖Java项目目录下INPUT
            file.transferTo(inputpic);

            /////////////////////////////////////////
            DetailOrder.cutImage(inputjpgpath, inputjpgpath, (int) Math.round(x), (int) Math.round(y), (int) Math.round(width), (int) Math.round(height1));

            //将上传文件保存到一个目标文件当中
            FileCopy.FileCopy(inputpic, new File(path + File.separator + filename));
            detailOrder.setInputpic(path + File.separator + filename);
        }


        // 如果现在是使用FileOuputStream实例化，意味着所有的输出是向文件之中
        //ps = new PrintStream(new FileOutputStream(new File("E:" + File.separator + "test.txt"))) ;
        ps = new PrintStream(new FileOutputStream(new File(inputtxtpath)));
        ps.println("发光字高度 " + height);
        ps.println("发光字厚度 " + size);
        ps.println("字壳参数 " + detailOrder.getZikemidu() + " " + detailOrder.getZikehoudu() + " " + detailOrder.getZikedanjia() + " " + detailOrder.getZikejijia());
        ps.println("底壳参数 " + detailOrder.getDikemidu() + " " + detailOrder.getDikehoudu() + " " + detailOrder.getDikedanjia() + " " + detailOrder.getDikejijia());
        ps.println("树脂参数 " + detailOrder.getShuzhimidu() + " " + detailOrder.getShuzhihoudu() + " " + detailOrder.getShuzhidanjia());
        ps.println("亚克力参数 " + detailOrder.getYakelimidu() + " " + detailOrder.getYakelihoudu() + " " + detailOrder.getYakelidanjia());
        ps.println("灯的参数 " + detailOrder.getDenggonglv() + " " + detailOrder.getDengdanjia() + " " + detailOrder.getDengjijia());
        ps.println("人工占比 " + detailOrder.getRengongzhanbi());
        ps.close();

//////////////////////////////////////////////////////////////////
        runtime.exec(exepath);
        Thread.sleep(800);
//////////////////////////////////////////////////////////////////

        BufferedReader is = new BufferedReader(new InputStreamReader(
                new FileInputStream(resulttxtpath), "GBK"));

        String resultpic = path + File.separator + uuid + "result.jpg";

        FileCopy.FileCopy(new File(resultjpgpath), new File(resultpic));
        detailOrder.setResultpic(resultpic);

        List<String> lines = IOUtils.readLines(is);
        zikeresult = lines.get(0).split(" ");
        dikeresult = lines.get(1).split(" ");
        shuzhiresult = lines.get(2).split(" ");
        yakeliresult = lines.get(3).split(" ");
        dengresult = lines.get(4);
        dianyuanresult = lines.get(5).split(" ");
        rengongresult = lines.get(6);
        count = lines.get(7);
        is.close();
        ///////////////////////////////////////////////////////////
        Date time = new Date(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //时间的字符串
        String current = sdf.format(time);
        //第二阶段赋值
        detailOrder.setZikes(zikeresult[0]);
        detailOrder.setZikep(Float.valueOf(zikeresult[1]));

        detailOrder.setDikes(dikeresult[0]);
        detailOrder.setDikep(Float.valueOf(dikeresult[1]));

        detailOrder.setShuzhis(shuzhiresult[0]);
        detailOrder.setShuzhip(Float.valueOf(shuzhiresult[1]));

        detailOrder.setYakelis(yakeliresult[0]);
        detailOrder.setYakelip(Float.valueOf(yakeliresult[1]));

        detailOrder.setDengzongjia(Float.valueOf(dengresult));

        detailOrder.setDianyuanzonggonglv(dianyuanresult[0]);
        detailOrder.setDianyuanzongjia(Float.valueOf(dianyuanresult[1]));

        detailOrder.setRengongzongjia(Float.valueOf(rengongresult));

        order.setUuid(uuid);
        order.setCreatetime(current);
        order.setCount(Float.valueOf(count));
        User user = (User) httpSession.getAttribute("user");
        order.setPhone(user.getPhone());
        order.setHeight(height);
        order.setSize(size);

        DetailOrderAndOrder detailOrderAndOrder = new DetailOrderAndOrder(detailOrder, order, uuid);


        service.createDetailOrderAndOrder(detailOrderAndOrder);

        service.addlog(new log(user.getPhone(), user.getName() + "新添了" + order.getUuid() + "订单"));


        return detailOrderAndOrder;
    }


    @RequestMapping("/findDetailOrderById")
    public @ResponseBody
    DetailOrderAndOrder findDetailOrderById(@RequestParam("id") String id) {
        return new DetailOrderAndOrder(service.findDetailOrderById(id), service.findOrderById(id));
    }


    @RequestMapping("/findOrderByTime")
    public @ResponseBody
    OrderAndCount findOrderByTime(Order order) {
        order.setIndex((order.getPageIndex() - 1) * order.getPageSize());
        return new OrderAndCount(service.findOrderByTime(order),service.countOrderByTime(order));
    }

    @RequestMapping("/findUserByGrant")
    public @ResponseBody
    UserAndCount findUserByGrant(User user) {
        user.setIndex((user.getPageIndex() - 1) * user.getPageSize());
        return new UserAndCount(service.findUserByGrant(user),service.countUserByGrant(user));
    }

    @RequestMapping("/findLogByTime")
    public @ResponseBody
    logAndCount findLogByTime(log log) {
        log.setIndex((log.getPageIndex() - 1) * log.getPageSize());
        return new logAndCount(service.findLogByTime(log),service.countfindLogByTime(log));
    }

    @RequestMapping("/findAllDetailMaterielByName")
    public @ResponseBody
    DetailMaterielAndCount findAllDetailMaterielByName(DetailMateriel detailMateriel) {
        detailMateriel.setIndex((detailMateriel.getPageIndex() - 1) * detailMateriel.getPageSize());
        return new DetailMaterielAndCount(service.findAllDetailMaterielByName(detailMateriel),service.countfindAllDetailMaterielByName(detailMateriel));
    }





}
