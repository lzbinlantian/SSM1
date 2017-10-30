<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--

Created by IntelliJ IDEA.
User: LANTIAN
Date: 2017/10/9
Time: 13:14
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
    <!-- 优先使用 IE 最新版本和 Chrome -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <!-- 刷新重新訪問不緩存 -->
    <meta http-equiv=Cache-Control content=no-cache/>
    <c:set var="contextPath" value="${pageContext.request.contextPath}" scope="application"/>
    <script>
        <%--JS gloable varilible--%>
        var contextPath = "${pageContext.request.contextPath}";
    </script>
    <meta charset="UTF-8">
    <title>系统日记</title>
    <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
    <meta name="description" content="Developed By M Abdur Rokib Promy">
    <meta name="keywords" content="Admin, Bootstrap 3, Template, Theme, Responsive">
    <!--bootstrtap css-->
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="bootstrap/css/bootstrap-table.css"/>
    <link rel="stylesheet" href="bootstrap/css/bootstrap-datetimepicker.min.css"/>

    <link type="text/css" rel="stylesheet" href="css/navbar.css"/>
    <link rel="stylesheet" href="css/eventLog.css"/>
    <script type="text/javascript" src="jquery/jquery-3.1.1.min.js"></script>
    <!--bootstrtap js -->
    <script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="bootstrap/js/bootstrap-table.js"></script>
    <script type="text/javascript" src="bootstrap/js/bootstrap-table-zh-CN.js"></script>
    <script type="text/javascript" src="bootstrap/js/bootstrap-datetimepicker.js"></script>
    <script type="text/javascript" src="bootstrap/js/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
    <script type="text/javascript" src="js/eventLog.js"></script>
</head>

<body>
<!--上部导航栏-->
<header class="header">
    <nav class="navbar navbar-default" role="navigation">
        <div class="container-fluid navbar-color">
            <div class="navbar-header navbar-header-logo">
                <a class="navbar-brand" href="#">
                    <div class="pull-left im"><img src="images/logo.jpg"/></div>
                    <p class="logo-text pull-left">发光字智能报价系统</p></a>
            </div>
            <ul class="nav navbar-nav navbar-right">
                <li class="identity"><span class="glyphicon glyphicon-name badge">${sessionScope.user.grant}</span></li>
                <li><span class="glyphicon glyphicon-name">${sessionScope.user.name}</span></li>
                <li>
                    <a href="<c:url value="/exit"/>"><span class="glyphicon glyphicon-log-in"></span> 退出</a>
                </li>
            </ul>
        </div>
    </nav>
</header>
<!--左边导航栏-->
<div class="subject">
    <div class="subject-left">
        <ul class="nav nav-pills nav-stacked">
            <li>
                <a href="<c:url value="/homepage"/>"><span class="glyphicon glyphicon-home"></span> 首页</a>
            </li>
            <li>
                <a href="<c:url value="/quotationRecord"/>"><span class="glyphicon glyphicon-book"></span> 报价记录</a>
            </li>
            <li>
                <a href="<c:url value="/accountManagement"/>"><span class="glyphicon glyphicon-user"></span> 账号管理</a>
            </li>
            <li>
                <a href="<c:url value="/materialManagement"/>"><span class="glyphicon glyphicon-pencil"></span> 材料管理</a>
            </li>
            <li class="active">
                <a href="<c:url value="/eventLog"/>"><span class="glyphicon glyphicon-file"></span> 系统日志</a>
            </li>
        </ul>
    </div>
    <!--内容-->
    <div class="subject-right">
        <div class="conten">
            <div class="container-top" id="time">
                <p class="pull-left">系统日记</p>

            </div>
            <div class="container-s">
                <div class="search">
                    <div class="container search-w">
                        <div class="container search-w">
                        <form action="" class="form-horizontal" role="form">
                            <fieldset>
                                <div class="form-group">
                                    <label class="control-label pull-left search-text">日期搜索</label>
                                    <div class="input-group date form_datetime pull-right search-date"
                                         data-date="2017-09-01" data-date-format="yyyy-mm-dd"
                                         data-link-field="dtp_input1">
                                        <input class="form-control" id="eventlog_searchtext" size="16" type="text" value="" readonly>
                                        <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                        <span class="input-group-addon"><span
                                                class="glyphicon glyphicon-th"></span></span>
                                    </div>
                                </div>

                            </fieldset>
                        </form>
                        </div>
                    </div>

                </div>
                <table class="table table-bordered" id="eventlogTable" data-height="550">

                </table>

            </div>

        </div>
    </div>
</div>
<footer>
    <div><p>Copyright&copy;<a>017 深信智能科技有限公司</a>,版权所有 深ICP证030173号 </p></div>
    <div class="recordcode"><a><i></i>深公网安备11000002000001号 </a></div>
</footer>
</body>

</html>