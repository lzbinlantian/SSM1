package cn.lantian.ssm.mapper;

import cn.lantian.ssm.model.log;

import java.util.List;

/**
 * Created by Lzbin、LANTIAN on 2017/10/10.
 *
 * @version 1.0
 * @PACKAGE_NAME cn.lantian.ssm.mapper
 * @Dercripton
 * @Time 10:32
 */
public interface logMapper {
    //增加日志
    public void addlog(log log);

    //展示日志
    public List<log> findAll(log log);

    //查询日志数量
    public int findAllLogNum();

    public List<log> findLogByTime(log log);

    public int countfindLogByTime(log log);
}
