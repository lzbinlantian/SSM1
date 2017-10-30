<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--

Created by IntelliJ IDEA.
User: LANTIAN
Date: 2017/9/29
Time: 10:04
To change this template use File | Settings | File Templates.
-->
<%--core标签库常用标签、需要導入jstl.jar standard.jar--%>
<taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"/>
<%--fmt标签库常用标签--%>
<taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"/>
<%--jstl核心函數庫--%>
<taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"/>
<%--自定義標簽庫--%>

<%--自定義函數庫--%>

<html>
<head>
    <title>hhh</title>
    <!-- 声明文档使用的字符编码 -->
    <meta http-equiv="content-type" content="text/html" charset="UTF-8">
    <!-- 优先使用 IE 最新版本和 Chrome -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <!-- 页面描述 -->
    <meta name="description" content="不超过150个字符"/>
    <!-- 页面关键词 -->
    <meta name="keywords" content=""/>
    <!-- 刷新重新訪問不緩存 -->
    <meta http-equiv=Cache-Control content=no-cache/>

    <%--请求的是json:输出的是json--%>
    <%--高大上的JQ导入--%>
    <script
            src="https://code.jquery.com/jquery-2.2.4.min.js"
            integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44="
            crossorigin="anonymous">
    </script>
    <%--放进去打酱油、有提示用--%>
    <script type="text/javascript" src="js/jquery-1.4.4.min.js"></script>

    <%--请求的是json:输出的是json--%>
    <script type="text/javascript">

        /*输入json、输出json*/
        function requestJson() {
            $.ajax({
                type: 'post',
                url: '<c:url value="/requestJson" />',
                contentType: 'application/json;charset=utf-8',
                //数据格式是json
                data: '{"id":"20","name":"蓝天"}',
                success: function (data) {//返回的json结果
                    alert(data.id);
                    alert(data.name);
                }
            });
        }

        /*请求key/value 、输出是json*/
        function responseJson() {
            $.ajax({
                type: 'post',
                url: '<c:url value="/responseJson" />',
                //数据格式是key/value
                //不需要contentType: 'application/json;charset=utf-8',
                data: 'id=1601090118&name=蓝天',
                success: function (data) {//返回的json结果
                    alert(data.name);
                }
            });
        }


        /*RESTful风格的传参*/
        //输出json、
        function restfulParam() {
            $.ajax({
                type: 'post',
                url: '<c:url value="/restfulParam/1601090118/李泽彬" />',
                //数据格式是key/value
                //不需要contentType: 'application/json;charset=utf-8',
                success: function (data) {//返回的json结果
                    alert(data.id);
                    alert(data.name);
                }
            });
        }


        function requestTime() {
            $.ajax({
                type: 'post',
                url: '<c:url value="/requestTime" />',
                success: function (data) {//返回的json结果
                   var time1 =  document.getElementById("time1");
                    alert(data.datetime);
                }
            });
        }

    </script>
</head>
<body>
<input type="button" onclick="requestJson()" value="请求json、输出json"/>
<input type="button" onclick="responseJson()" value="请求key/value、输出json"/>
<input type="button" onclick="restfulParam()" value="请求restfulParam、输出json"/>
<input type="button" onclick="requestTime()" value="请求时间"/>
<h1 id="time1"></h1>
</body>
</html>
