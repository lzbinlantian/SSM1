package cn.lantian.ssm.model;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class DetailOrder {
    private String uuid;

    private String zikename;

    private String zikemidu;

    private String zikehoudu;

    private String zikes;

    private String zikejijia;

    private Float zikedanjia;

    private Float zikep;

    private String dikename;

    private String dikemidu;

    private String dikehoudu;

    private String dikes;

    private String dikejijia;


    private Float dikedanjia;

    private Float dikep;

    private String shuzhiname;

    private String shuzhimidu;

    private String shuzhihoudu;

    private String shuzhis;

    private Float shuzhidanjia;

    private Float shuzhip;

    private String yakeliname;

    private String yakelimidu;

    private String yakelihoudu;

    private String yakelis;

    private Float yakelidanjia;

    private Float yakelip;

    private String dengname;

    private String denggonglv;

    private Float dengdanjia;

    private String dengjijia;

    private Float dengzongjia;

    private String rengongname;

    private String rengongzhanbi;

    private Float rengongzongjia;


    private Float dianyuanzongjia;

    private String inputpic;

    private String resultpic;

    private String dianyuanzonggonglv;

    public String getDengjijia() {
        return dengjijia;
    }



    public void setDengjijia(String dengjijia) {
        this.dengjijia = dengjijia;
    }

    public String getZikejijia() {
        return zikejijia;
    }

    public void setZikejijia(String zikejijia) {
        this.zikejijia = zikejijia;
    }

    public String getDikejijia() {
        return dikejijia;
    }

    public void setDikejijia(String dikejijia) {
        this.dikejijia = dikejijia;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public String getZikename() {
        return zikename;
    }

    public void setZikename(String zikename) {
        this.zikename = zikename == null ? null : zikename.trim();
    }

    public String getZikemidu() {
        return zikemidu;
    }

    public void setZikemidu(String zikemidu) {
        this.zikemidu = zikemidu == null ? null : zikemidu.trim();
    }

    public String getZikehoudu() {
        return zikehoudu;
    }

    public void setZikehoudu(String zikehoudu) {
        this.zikehoudu = zikehoudu == null ? null : zikehoudu.trim();
    }

    public String getZikes() {
        return zikes;
    }

    public void setZikes(String zikes) {
        this.zikes = zikes == null ? null : zikes.trim();
    }

    public Float getZikedanjia() {
        return zikedanjia;
    }

    public void setZikedanjia(Float zikedanjia) {
        this.zikedanjia = zikedanjia;
    }

    public Float getZikep() {
        return zikep;
    }

    public void setZikep(Float zikep) {
        this.zikep = zikep;
    }

    public String getDikename() {
        return dikename;
    }

    public void setDikename(String dikename) {
        this.dikename = dikename == null ? null : dikename.trim();
    }

    public String getDikemidu() {
        return dikemidu;
    }

    public void setDikemidu(String dikemidu) {
        this.dikemidu = dikemidu == null ? null : dikemidu.trim();
    }

    public String getDikehoudu() {
        return dikehoudu;
    }

    public void setDikehoudu(String dikehoudu) {
        this.dikehoudu = dikehoudu == null ? null : dikehoudu.trim();
    }

    public String getDikes() {
        return dikes;
    }

    public void setDikes(String dikes) {
        this.dikes = dikes == null ? null : dikes.trim();
    }

    public Float getDikedanjia() {
        return dikedanjia;
    }

    public void setDikedanjia(Float dikedanjia) {
        this.dikedanjia = dikedanjia;
    }

    public Float getDikep() {
        return dikep;
    }

    public void setDikep(Float dikep) {
        this.dikep = dikep;
    }

    public String getShuzhiname() {
        return shuzhiname;
    }

    public void setShuzhiname(String shuzhiname) {
        this.shuzhiname = shuzhiname == null ? null : shuzhiname.trim();
    }

    public String getShuzhimidu() {
        return shuzhimidu;
    }

    public void setShuzhimidu(String shuzhimidu) {
        this.shuzhimidu = shuzhimidu == null ? null : shuzhimidu.trim();
    }

    public String getShuzhihoudu() {
        return shuzhihoudu;
    }

    public void setShuzhihoudu(String shuzhihoudu) {
        this.shuzhihoudu = shuzhihoudu == null ? null : shuzhihoudu.trim();
    }

    public String getShuzhis() {
        return shuzhis;
    }

    public void setShuzhis(String shuzhis) {
        this.shuzhis = shuzhis == null ? null : shuzhis.trim();
    }

    public Float getShuzhidanjia() {
        return shuzhidanjia;
    }

    public void setShuzhidanjia(Float shuzhidanjia) {
        this.shuzhidanjia = shuzhidanjia;
    }

    public Float getShuzhip() {
        return shuzhip;
    }

    public void setShuzhip(Float shuzhip) {
        this.shuzhip = shuzhip;
    }

    public String getYakeliname() {
        return yakeliname;
    }

    public void setYakeliname(String yakeliname) {
        this.yakeliname = yakeliname == null ? null : yakeliname.trim();
    }

    public String getYakelimidu() {
        return yakelimidu;
    }

    public void setYakelimidu(String yakelimidu) {
        this.yakelimidu = yakelimidu == null ? null : yakelimidu.trim();
    }

    public String getYakelihoudu() {
        return yakelihoudu;
    }

    public void setYakelihoudu(String yakelihoudu) {
        this.yakelihoudu = yakelihoudu == null ? null : yakelihoudu.trim();
    }

    public String getYakelis() {
        return yakelis;
    }

    public void setYakelis(String yakelis) {
        this.yakelis = yakelis == null ? null : yakelis.trim();
    }

    public Float getYakelidanjia() {
        return yakelidanjia;
    }

    public void setYakelidanjia(Float yakelidanjia) {
        this.yakelidanjia = yakelidanjia;
    }

    public Float getYakelip() {
        return yakelip;
    }

    public void setYakelip(Float yakelip) {
        this.yakelip = yakelip;
    }

    public String getDengname() {
        return dengname;
    }

    public void setDengname(String dengname) {
        this.dengname = dengname == null ? null : dengname.trim();
    }

    public String getDenggonglv() {
        return denggonglv;
    }

    public void setDenggonglv(String denggonglv) {
        this.denggonglv = denggonglv == null ? null : denggonglv.trim();
    }

    public Float getDengdanjia() {
        return dengdanjia;
    }

    public void setDengdanjia(Float dengdanjia) {
        this.dengdanjia = dengdanjia;
    }

    public Float getDengzongjia() {
        return dengzongjia;
    }

    public void setDengzongjia(Float dengzongjia) {
        this.dengzongjia = dengzongjia;
    }

    public String getRengongname() {
        return rengongname;
    }

    public void setRengongname(String rengongname) {
        this.rengongname = rengongname == null ? null : rengongname.trim();
    }

    public String getRengongzhanbi() {
        return rengongzhanbi;
    }

    public void setRengongzhanbi(String rengongzhanbi) {
        this.rengongzhanbi = rengongzhanbi == null ? null : rengongzhanbi.trim();
    }

    public Float getRengongzongjia() {
        return rengongzongjia;
    }

    public void setRengongzongjia(Float rengongzongjia) {
        this.rengongzongjia = rengongzongjia;
    }

    public Float getDianyuanzongjia() {
        return dianyuanzongjia;
    }

    public void setDianyuanzongjia(Float dianyuanzongjia) {
        this.dianyuanzongjia = dianyuanzongjia;
    }

    public String getInputpic() {
        return inputpic;
    }

    public void setInputpic(String inputpic) {
        this.inputpic = inputpic == null ? null : inputpic.trim();
    }

    public String getResultpic() {
        return resultpic;
    }

    public void setResultpic(String resultpic) {
        this.resultpic = resultpic == null ? null : resultpic.trim();
    }

    public String getDianyuanzonggonglv() {
        return dianyuanzonggonglv;
    }

    public void setDianyuanzonggonglv(String dianyuanzonggonglv) {
        this.dianyuanzonggonglv = dianyuanzonggonglv == null ? null : dianyuanzonggonglv.trim();
    }
    /**
     * 剪切图片,没有处理图片后缀名是否正确,还有gif动态图片
     * @param sourcePath 源路径(包含图片)
     * @param targetPath 目标路径 null则默认为源路径
     * @param x 起点x坐标
     * @param y 起点y左边
     * @param width 剪切宽度
     * @param height 剪切高度
     * @return 目标路径
     * @throws IOException if sourcePath image doesn't exist
     */

    public static String cutImage(String sourcePath,String targetPath,int x,int y,int width,int height) throws IOException {
        File imageFile = new File(sourcePath);
        if(!imageFile.exists()){
            throw new IOException("Not found the images:"+sourcePath);
        }
        if(targetPath==null || targetPath.isEmpty()) targetPath = sourcePath;
        String format = sourcePath.substring(sourcePath.lastIndexOf(".")+1,sourcePath.length());
        BufferedImage image = ImageIO.read(imageFile);
        image = image.getSubimage(x, y, width, height);
        ImageIO.write(image, format, new File(targetPath));
        return targetPath;
    }
}

