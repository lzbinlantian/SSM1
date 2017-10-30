package cn.lantian.ssm.controller.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Lzbin、LANTIAN on 2017/9/27.
 *
 * @version 1.0
 * @PACKAGE_NAME cn.lantian.ssm.controller.converter
 * @Dercripton
 * @Time 1:24
 */
public class DateConverter implements Converter<String ,Date> {
    public Date convert(String source) {
        //實現 將日期串轉換成日期類型（yyyy-MM-dd HH:mm:ss）
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            //轉成直接返回
            return simpleDateFormat.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //如果參數綁定失敗返回null
        return null;
    }
}
