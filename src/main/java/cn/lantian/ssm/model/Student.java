package cn.lantian.ssm.model;

/**
 * Created by Lzbin、LANTIAN on 2017/9/25.
 *
 * @version 1.0
 * @PACKAGE_NAME cn.lantian.ssm.model
 * @Dercripton
 * @Time 9:31
 */
public class Student {
    //检验名称是在1到30个字符之中、
    //message是错误提示信息
    //@NotNull(message = "不能为空")
    private String id;
    //@Size(min = 1, max = 10, message = "{Student.name.length.error}")
    private String name;

    private String datetime;

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public Student() {
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student(String id, String name) {

        this.id = id;
        this.name = name;
    }


}
