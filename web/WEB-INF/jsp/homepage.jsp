<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%

%>
<!--

Created by IntelliJ IDEA.
User: LANTIAN
Date: 2017/10/2
Time: 16:19
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
    <meta charset="utf-8"/>
    <title>首页</title>
    <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
    <meta name="description" content="Developed By M Abdur Rokib Promy">
    <meta name="keywords" content="Admin, Bootstrap 3, Template, Theme, Responsive">

    <!--bootstrtap css-->
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="bootstrap/css/bootstrap-table.css"/>
    <link rel="stylesheet" href="css/cropper.css">

    <link type="text/css" rel="stylesheet" href="css/navbar.css"/>
    <link rel="stylesheet" href="css/home.css"/>
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
            <li class="active">
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
            <li>
                <a href="<c:url value="/eventLog"/>"><span class="glyphicon glyphicon-file"></span> 系统日志</a>
            </li>
        </ul>
    </div>
    <!--内容-->
    <div class="subject-right">
        <div class="conten">
            <div class="container-top" id="time">
                <p class="pull-left">首页</p>
                <p class="pull-right">数据更新时间 2017-6-13 15：45</p>
            </div>
            <div class="container-conten">
                <div class="container-conten-l pull-left">
                    <input type="hidden" name="dataX" id="dataX" value="">
                    <input type="hidden" name="dataY" id="dataY" value="">
                    <input type="hidden" name="dataHeight" id="dataHeight" value="">
                    <input type="hidden" name="dataWidth" id="dataWidth" value="">
                    <div class="input-img">
                        <div class="title-l">
                            <p class="pull-left">输入图片</p>
                            <div class="bu pull-right">
                                <label id="img" class="btn btn-primary btn-upload" for="inputImage"
                                       title="Upload image file">
                                    <span class="docs-tooltip" data-toggle="tooltip"
                                          title="Import image with Blob URLs">
								             &nbsp&nbsp 选择图片&nbsp&nbsp&nbsp&nbsp&nbsp
                                    </span>

                                </label>
                            </div>
                        </div>
                        <div class="img-con">
                            <div class="img-container" id="img-container">
                                <img src="" alt="Picture" align="center" vertical-align="middle">
                            </div>
                            <div class="img-btu pull-right">
                                <div class="btn-group cropper-display">
                                    <button id="destroy" class="btn btn-primary btn-sm" data-method="destroy"
                                            type="button" title="Destroy">
                                            <span class="docs-tooltip" data-toggle="tooltip"
                                                  title="$().cropper(&quot;destroy&quot;)">
                                            </span>
                                    </button>
                                    <button id="GetData" class="btn btn-primary" data-method="getData" data-option="" data-target="#putData" type="button">
                                        <span class="docs-tooltip" data-toggle="tooltip" title="$().cropper(&quot;getData&quot;)">
                                            Get Data
                                        </span>
                                    </button>
                                </div>
                                <div class="btn-group btn-group-crop">
                                    <button id="getCroppedCanvas" class="btn btn-primary btn-upload"
                                            data-method="getCroppedCanvas" type="button">
                                            <span class="docs-tooltip " data-toggle="tooltip"
                                                  title="$().cropper(&quot;getCroppedCanvas&quot;)">
                                             &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp确定&nbsp &nbsp&nbsp&nbsp&nbsp&nbsp
                                            </span>
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <input class="form-control" id="putData" type="text" placeholder="Get data to here or set data with this value">
                    <div class="picture">
                        <div class="picture-title">
                            <p>输出图片</p>
                        </div>
                        <div class="result">
                            <div class="return-image" id="return-image" align="center">
                                <img src=""/>
                            </div>
                        </div>
                    </div>
                </div>
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
                                        <input id="Luminoush" name="Luminoush" type="text" class="form-control">
                                    </div>
                                    <span class="col-t1 pull-left">mm</span>
                                </div>
                                <label class="col-t pull-left">厚度</label>
                                <div class="col-s2 pull-left">
                                    <div class="col-s3 pull-left">
                                        <input id="HTK" name="HTK" type="text" class="form-control">
                                    </div>
                                    <span class="col-t1 pull-left">mm</span>
                                </div>
                            </div>
                            <div class="pull-right">
                                <label class="col-t pull-left">客户名</label>
                                <div class="col-s1 pull-left">
                                    <input id="Customername" name="Customername" type="text" class="form-control">
                                </div>
                            </div>

                        </div>
                        <table class="table">
                            <thead>
                            <tr>
                                <th>项目</th>
                                <th style="width: 20%;">材料</th>
                                <th>密度<span>(g/cm<sup>2</sup>)</span></th>
                                <th>厚度<span>(mm)</span></th>
                                <th>面积<span>(cm<sup>2</sup>)</span></th>
                                <th>单价</th>
                                <th>总价<span>(元)</span></th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr id="shell">
                                <td><p class="td-t">1 <span>字壳</span></p></td>
                                <td>
                                    <select name="shell" required="required" class="form-control">

                                    </select>
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
                                    <p><span></span><span></span><sup></sup></p>
                                </td>
                                <td>
                                    <p><span></span></p>
                                </td>
                                <input type="hidden" name="chargeunit">
                            </tr>
                            <tr id="Pan">
                                <td><p class="td-t">2 <span>底壳</span></p></td>
                                <td>
                                    <select name="Pan" required="required" class="form-control">

                                    </select>
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
                                    <p><span></span><span></span><sup></sup></p>

                                </td>
                                <td>
                                    <p><span></span></p>
                                </td>
                                <input type="hidden" name="chargeunit">
                            </tr>
                            <tr id="resin">
                                <td><p class="td-t">3 <span>树脂</span></p></td>
                                <td>
                                    <select name="resin" required="required" class="form-control">

                                    </select>
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
                                    <p><span></span><span></span><sup></sup></p>

                                </td>
                                <td>
                                    <p><span></span></p>
                                </td>
                                <input type="hidden" name="chargeunit">
                            </tr>
                            <tr id="PMMA">
                                <td><p class="td-t">4 <span>亚克力</span></p></td>
                                <td>
                                    <select name="PMMA" required="required" class="form-control">

                                    </select>
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
                                    <p><span></span><span></span><sup></sup></p>
                                </td>
                                <td>
                                    <p><span></span></p>
                                </td>
                                <input type="hidden" name="chargeunit">
                            </tr>
                            <tr id="Lantern">
                                <input type="hidden" name="lanternsort" id="lanternsort" value="">
                                <td><p class="td-t">5 <span>灯</span></p></td>
                                <td>
                                    <select name="Lantern" id="lanternname" required="required" class="form-control">

                                    </select>
                                </td>
                                <td>
                                </td>
                                <td>
                                </td>
                                <td>
                                </td>
                                <td>
                                    <p><span></span><span></span></p>

                                </td>
                                <td>
                                    <p><span></span></p>
                                </td>
                                <input type="hidden" name="chargeunit">
                            </tr>
                            <tr id="power">
                                <td><p class="td-t">6 <span>电源</span></p></td>
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
                            <tr id="labor">
                                <td><p class="td-t">7 <span>人工</span></p></td>
                                <td>
                                    <select name="Lantern" required="required" class="form-control">

                                    </select>
                                </td>
                                <td>
                                </td>
                                <td>
                                </td>
                                <td>
                                </td>
                                <td>
                                    <p>占比:<span></span>%</p>

                                </td>
                                <td>
                                    <p><span></span></p>
                                </td>
                                <input type="hidden" name="chargeunit">
                            </tr>
                            </tbody>
                        </table>
                    </div>
                    <div class="total">
                        <p class="pull-left">合计</p>
                        <p class="pull-right total-t"><span></span></p>
                    </div>
                    <form id="quotaform" enctype="multipart/form-data">
                        <input class="sr-only" id="inputImage" name="file" type="file" accept="image/*">
                        <input id="quotation" type="button" disabled="disabled"
                               class="btn btn-primary btn-default pull-right" value="生成报价单 "/>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<footer>
    <div><p>Copyright&copy;<a>017 蓝冰科技股份有限公司</a>,版权所有 深ICP证030173号 </p></div>
    <div class="recordcode"><a><i></i>深公网安备11000002000001号 </a></div>
</footer>
<script type="text/javascript" src="jquery/jquery-3.1.1.min.js"></script>
<!--bootstrtap js -->
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap-table.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap-table-zh-CN.js"></script>

<script src="js/cropper.js"></script>
<script type="text/javascript" src="js/home.js"></script>
</body>

</html>