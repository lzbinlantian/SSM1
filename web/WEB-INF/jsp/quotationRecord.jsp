<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--

Created by IntelliJ IDEA.
User: LANTIAN
Date: 2017/10/9
Time: 13:15
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
    <title>报价记录</title>
    <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
    <meta name="description" content="Developed By M Abdur Rokib Promy">
    <meta name="keywords" content="Admin, Bootstrap 3, Template, Theme, Responsive">

    <!--bootstrtap css-->
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="bootstrap/css/bootstrap-table.css"/>

    <link rel="stylesheet" href="bootstrap/css/bootstrap-datetimepicker.min.css"/>
    <link type="text/css" rel="stylesheet" href="css/navbar.css"/>
    <link rel="stylesheet" href="css/quotationRecord.css"/>
</head>

<html>

<head>
    <c:set var="contextPath" value="${pageContext.request.contextPath}" scope="application"/>
    <script>
        <%--JS gloable varilible--%>
        var contextPath = "${pageContext.request.contextPath}";
    </script>
    <meta charset="UTF-8">
    <title>报价记录</title>
    <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
    <meta name="description" content="Developed By M Abdur Rokib Promy">
    <meta name="keywords" content="Admin, Bootstrap 3, Template, Theme, Responsive">

    <!--bootstrtap css-->
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="bootstrap/css/bootstrap-table.css"/>

    <link type="text/css" rel="stylesheet" href="css/navbar.css"/>
    <link rel="stylesheet" href="css/quotationRecord.css"/>
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
            <li class="active">
                <a href="<c:url value="/quotationRecord"/>"><span class="glyphicon glyphicon-book"></span> 报价记录</a>
            </li>
            <li>
                <a href="<c:url value="/accountManagement"/>"><span class="glyphicon glyphicon-user"></span> 账号管理</a>
            </li>
            <li>
                <a href="<c:url value="/materialManagement"/>"><span class="glyphicon glyphicon-pencil"></span> 材料管理</a>
            </li>
            <li>
                <a href="<c:url value="/eventLog"/>"><span class="glyphicon glyphicon-file"></span> 系统日志</a>
            </li>
        </ul>
    </div>
    <!--内容-->
    <div class="subject-right">
        <div class="conten">
            <div class="container-top" id="time">
                <p class="pull-left">报价记录</p>
            </div>
            <div class="container-s">
                <div class="search">
                    <div class="pull-left search-w">
                        <div class="container search-w">
                        <form action="" class="form-horizontal" role="form">
                            <fieldset>
                                <div class="form-group">
                                    <label class="control-label pull-left search-text">日期搜索</label>
                                    <div class="input-group date quotationRecord_search_datetime pull-right search-date"
                                         data-date="2017-09-01" data-date-format="yyyy-mm-dd"
                                         data-link-field="dtp_input1">
                                        <input class="form-control" id="quotationRecord_searchtext" size="16" type="text" value="" readonly>
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
                <div class="ta">
                    <table class="table table-bordered" id="recordTable">

                    </table>
                </div>
            </div>
        </div>
    </div>
    <footer>
        <div><p>Copyright&copy;<a>017 深圳市蓝冰科技信息工程股份有限公司</a>,版权所有 深ICP证030173号 </p></div>
        <div class="recordcode"><a><i></i>深公网安备11000002000001号 </a></div>
    </footer>
    <!--modal-->
    <div class="modal fade" id="Checkthedetailsmodal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
         aria-hidden="true">
        <div class="modal-dialog" style="width:1650px">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        &times;
                    </button>
                    <h4 class="modal-title" id="myModalLabel">
                        报价单详情
                    </h4>
                </div>
                <!--修改4-->
                <div class="modal-body" style="width: 1650px">

                    <div class="container-conten">
                        <div class="container-conten-l pull-left">
                            <div class="input-img">
                                <div class="title-l">
                                    <p class="pull-left">输入图片</p>

                                </div>
                                <div class="container input-image" id="historyinput-image" align="center">
                                    <img src=""/>
                                </div>
                            </div>
                            <div class="picture">
                                <div class="picture-title">
                                    <p>输出图像</p>
                                </div>
                                <div class="result">
                                    <div class="return-image" id="historyreturn-image" align="center">
                                        <img src=""/>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!--修改3-->
                        <div class="container-conten-r pull-right">
                            <div class="title-r">
                                <p>详细参数及报价</p>
                            </div>
                            <div class="table-responsive quote">
                                <div class="inputa">
                                    <div class="pull-left">
                                        <label class="col-t pull-left">高度</label>
                                        <div class="col-s2 pull-left">
                                            <div class="col-s3 pull-left">
                                                <input id="historyLuminoush" type="text" class="form-control">
                                            </div>
                                            <span class="col-t1 pull-left">mm</span>
                                        </div>
                                        <label class="col-t pull-left">厚度</label>
                                        <div class="col-s2 pull-left">
                                            <div class="col-s3 pull-left">
                                                <input id="historyHTK" name="HTK" type="text" class="form-control">
                                            </div>
                                            <span class="col-t1 pull-left">mm</span>
                                        </div>
                                    </div>
                                    <div class="pull-right">
                                        <label class="col-t pull-left">客户名</label>
                                        <div class="col-s1 pull-left">
                                            <input id="historyCustomername" type="text" class="form-control">
                                        </div>
                                    </div>
                                </div>
                                <table class="table">
                                    <thead>
                                    <tr>
                                        <th style="padding-bottom: 20px;">项目</th>
                                        <th style="width: 20%;padding-bottom: 20px;">材料</th>
                                        <th>密度(g/cm<sub>2</sub>)</th>
                                        <th>厚度(mm)</th>
                                        <th>面积(cm<sub>2</sub>)</th>
                                        <th>单价(/cm<sub>2</sub>元)</th>
                                        <th style="padding-right: 20px;">总价(元)</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr id="historyshell">
                                        <td><p class="td-t">1 字壳</p></td>
                                        <td>
                                            <p><span></span></p>
                                        </td>
                                        <td>
                                            <p><span></span></p>
                                        </td>
                                        <td>
                                            <p><span></span></p>
                                        </td>
                                        <td>
                                            <p><span></span></p>
                                        </td>
                                        <td>
                                            <p><span></span></p>
                                        </td>
                                        <td>
                                            <p><span></span></p>
                                        </td>
                                    </tr>
                                    <tr id="historyPan">
                                        <td><p class="td-t">2 底壳</p></td>
                                        <td>
                                            <p><span></span></p>
                                        </td>
                                        <td>
                                            <p><span></span></p>
                                        </td>
                                        <td>
                                            <p><span></span></p>
                                        </td>
                                        <td>
                                            <p><span></span></p>
                                        </td>
                                        <td>
                                            <p><span></span></p>
                                        </td>
                                        <td>
                                            <p><span></span></p>
                                        </td>
                                    </tr>
                                    <tr id="historyresin">
                                        <td><p class="td-t">3 树脂</p></td>
                                        <td>
                                            <p><span></span></p>
                                        </td>
                                        <td>
                                            <p><span></span></p>
                                        </td>
                                        <td>
                                            <p><span></span></p>
                                        </td>
                                        <td>
                                            <p><span></span></p>
                                        </td>
                                        <td>
                                            <p><span></span></p>
                                        </td>
                                        <td>
                                            <p><span></span></p>
                                        </td>
                                    </tr>
                                    <tr id="historyPMMA">
                                        <td><p class="td-t">4 亚克力</p></td>
                                        <td>
                                            <p><span></span></p>
                                        </td>
                                        <td>
                                            <p><span></span></p>
                                        </td>
                                        <td>
                                            <p><span></span></p>
                                        </td>
                                        <td>
                                            <p><span></span></p>
                                        </td>
                                        <td>
                                            <p><span></span></p>
                                        </td>
                                        <td>
                                            <p><span></span></p>
                                        </td>
                                    </tr>
                                    <tr id="historyLantern">
                                        <td><p class="td-t">5 灯</p></td>
                                        <td>
                                            <p><span></span></p>
                                        </td>
                                        <td>
                                        </td>
                                        <td>
                                        </td>
                                        <td>
                                        </td>
                                        <td>
                                            <p><span></span></p>
                                        </td>
                                        <td>
                                            <p><span></span></p>
                                        </td>
                                    </tr>
                                    <tr id="historypower">
                                        <td><p class="td-t">6 电源</p></td>
                                        <td>
                                            <p>总功率:<span></span>w</p>
                                        </td>
                                        <td>
                                        </td>
                                        <td>
                                        </td>
                                        <td>
                                        </td>
                                        <td>
                                        </td>
                                        <td>
                                            <p><span></span></p>
                                        </td>
                                    </tr>
                                    <tr id="historylabor">
                                        <td><p class="td-t">7 人工</p></td>
                                        <td>
                                            <p><span></span></p>
                                        </td>
                                        <td>
                                        </td>
                                        <td>
                                        </td>
                                        <td>
                                        </td>
                                        <td>
                                            <p>占比:<span></span></p>
                                        </td>
                                        <td>
                                            <p><span></span></p>
                                        </td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                            <div class="historytotal">
                                <p class="pull-left">合计</p>
                                <p class="pull-right total-t"><span></span></p>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /.modal-content -->
            </div>
        </div>
    </div>

    <script type="text/javascript " src="jquery/jquery-3.1.1.min.js "></script>
    <!--bootstrtap js -->
    <script type="text/javascript " src="bootstrap/js/bootstrap.min.js "></script>
    <script type="text/javascript " src="bootstrap/js/bootstrap-table.js "></script>
    <script type="text/javascript " src="bootstrap/js/bootstrap-table-zh-CN.js "></script>
    <script type="text/javascript" src="bootstrap/js/bootstrap-datetimepicker.js"></script>
    <script type="text/javascript" src="bootstrap/js/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
    <script type="text/javascript " src="js/quotationRecord.js "></script>
</body>

</html>
</html>