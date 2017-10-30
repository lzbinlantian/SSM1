<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!--

  Created by IntelliJ IDEA.
  User: LANTIAN
  Date: 2017/9/29
  Time: 0:48
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
    <title>错误提示</title>
    <!-- 声明文档使用的字符编码 -->
    <meta http-equiv="content-type" content="text/html" charset="UTF-8">

    <!-- 页面描述 -->
    <meta name="description" content="不超过150个字符"/>
    <!-- 页面关键词 -->
    <meta name="keywords" content=""/>
    <!-- 优先使用 IE 最新版本和 Chrome -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <!-- 刷新重新訪問不緩存 -->
    <meta http-equiv=Cache-Control content=no-cache/>

</head>
<body>
${message}
</body>
</html>
