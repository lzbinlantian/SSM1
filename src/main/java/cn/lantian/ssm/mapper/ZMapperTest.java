package cn.lantian.ssm.mapper;

import cn.lantian.ssm.model.*;
import cn.lantian.ssm.service.impl.serviceImpl;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.io.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;

/**
 * Created by Lzbin、LANTIAN on 2017/9/25.
 *
 * @version 1.0
 * @PACKAGE_NAME cn.lantian.ssm.mapper
 * @Dercripton
 * @Time 12:49
 */
@RunWith(SpringJUnit4ClassRunner.class)//表示整合JUnit4进行测试
@ContextConfiguration(locations = {"classpath:spring/applicationContext-dao.xml"})//加载spring配置文件
public class ZMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private logMapper logMapper;

    @Resource
    private serviceImpl service;

    @Test
    public void finduserByPhone() throws Exception {
        User user = userMapper.findUserByPhone("18038060732");
        System.out.println(user.getPassword());
    }

    final Runtime runtime = Runtime.getRuntime();

    @Test
    public void testruntime() throws IOException {
        try {
            long start = System.currentTimeMillis();
            String path = "cmd /cC:\\Users\\hasee\\IdeaProjects\\TheChallengeCup\\cal.exe";
            Process pro = Runtime.getRuntime().exec(path);
            long end = System.currentTimeMillis();
            System.out.println(end - start);
            BufferedReader br = new BufferedReader(new InputStreamReader(pro.getInputStream()));

            String str;
            while ((str = br.readLine()) != null) {
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void fun1() {
        Date time = new Date(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String current = sdf.format(time);
        System.out.println(current);
        logMapper.addlog(new log("18038060732", "管理员测试"));
    }


    @Test
    public void fun2() {
        DetailMateriel detailMateriel = new DetailMateriel();
        detailMateriel.setSort("字壳");
        detailMateriel.setIndex(0);
        detailMateriel.setPageSize(10);
        System.out.println(service.findAllDetailMateriel(detailMateriel));
    }

    /**
     * truncate table thechallengecup.log 清空表数据、自动从1开始
     */
    @Test
    public void fun3() {
        Date time = new Date(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //时间的字符串
        String current = sdf.format(time);
        System.out.println(current);

        //详细赋值
        DetailOrder detailOrder = new DetailOrder();
        detailOrder.setZikename("zikename");
        detailOrder.setZikemidu("zikemidu");
        detailOrder.setZikehoudu("zikehoudu");
        detailOrder.setZikes("mianji");
        detailOrder.setZikejijia("1");
        detailOrder.setZikedanjia(55.25f);
        detailOrder.setZikep(66f);

        detailOrder.setDikename("dikename");
        detailOrder.setDikemidu("dikemidu");
        detailOrder.setDikehoudu("dikehoudu");
        detailOrder.setDikes("mianji");
        detailOrder.setDikejijia("1");
        detailOrder.setDikedanjia(55.25f);
        detailOrder.setDikep(55f);


        detailOrder.setShuzhiname("shuzhiname");
        detailOrder.setShuzhimidu("shuzhimidu");
        detailOrder.setShuzhihoudu("shuzhihoudu");
        detailOrder.setShuzhis("mianji");
        detailOrder.setShuzhidanjia(55f);
        detailOrder.setShuzhip(66f);

        detailOrder.setYakeliname("yakeliname");
        detailOrder.setYakelimidu("yakelimidu");
        detailOrder.setYakelihoudu("yakelihoudu");
        detailOrder.setYakelis("yakelimianji");
        detailOrder.setYakelidanjia(55f);
        detailOrder.setYakelip(66f);

        detailOrder.setDengname("dengban");
        detailOrder.setDenggonglv("55w");
        detailOrder.setDengjijia("1");
        detailOrder.setDengdanjia(66f);
        detailOrder.setDengzongjia(66f);

        detailOrder.setDianyuanzonggonglv("55w");
        detailOrder.setDianyuanzongjia(66f);

        detailOrder.setRengongname("shixiong");
        detailOrder.setRengongzhanbi("66");
        detailOrder.setRengongzongjia(66f);

        detailOrder.setInputpic("input");
        detailOrder.setResultpic("output");


        //订单赋值
        Order order = new Order();
        order.setCustomer("lantian");
        order.setCount(112f);
        order.setCreatetime(current);

        //生成uuid
        String uuid = String.valueOf(UUID.randomUUID().toString().replaceAll("-", "").replaceAll("[a-z\\sA-Z]", "0"));
        detailOrder.setUuid(uuid);


        //进行返回
        DetailOrderAndOrder detailOrderAndOrder = new DetailOrderAndOrder(detailOrder, order, uuid);
        service.createDetailOrderAndOrder(detailOrderAndOrder);
    }

    @Test
    public void writeTest() {

    }

    /*
字壳面积和总价 101452.93 202.91
底壳面积和总价 23959.50 28.75
树脂面积和总价 23959.50 724.54
亚克力面积和总价 23959.50 155.26
灯的总价 826.00
电源总功率和总价 495.60 540.00
人工总价 337.83
价格合计 2815.28

***** 以下部分都为注释，不会被程序输出，每次输出该文件覆盖全部内容 *****
*/
    @Test
    public void readLinesTest() throws InterruptedException, IOException {
        Runtime.getRuntime().exec("cmd /cC:\\Users\\hasee\\IdeaProjects\\TheChallengeCup\\cal.exe");
        try {
            Thread.sleep(1000);
            BufferedReader is = new BufferedReader(new InputStreamReader(

                    new FileInputStream("C:\\Users\\hasee\\IdeaProjects\\TheChallengeCup\\result.txt"), "GBK"));
            List<String> lines = IOUtils.readLines(is);
            String[] zikeresult = lines.get(0).split(" ");
            String[] dikeresult = lines.get(1).split(" ");
            String[] shuzhiresult = lines.get(2).split(" ");
            String[] yakeliresult = lines.get(3).split(" ");
            String dengresult = lines.get(4);
            String[] dianyuanresult = lines.get(5).split(" ");
            String rengongresult = lines.get(6);
            String count = lines.get(7);

            System.out.println(dengresult);
            System.out.println(rengongresult);
            System.out.println(count);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void startProgram() throws IOException {
        User user = new User();
        user.setGrant("管理员");
        user.setPageSize(10);
        user.setIndex(1);
        userMapper.findUserByGrant(user);

    }


}


