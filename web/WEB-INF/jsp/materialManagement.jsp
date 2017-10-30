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
    <title>材料管理</title>
    <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
    <meta name="description" content="Developed By M Abdur Rokib Promy">
    <meta name="keywords" content="Admin, Bootstrap 3, Template, Theme, Responsive">

    <!--bootstrtap css-->
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="bootstrap/css/bootstrap-table.css"/>

    <link type="text/css" rel="stylesheet" href="css/navbar.css"/>
    <link rel="stylesheet" href="css/materialManagement.css"/>
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
            <li class="active">
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
                <p class="pull-left">材料管理</p>
            </div>
            <div class="container-s">
                <div class="search">
                    <div class="pull-left search-w">
                        <form class="bs-example bs-example-form" role="form" id="serch-material">
                            <div class="col-lg-12 search-pa">
                                <div class="input-group">
                                    <input type="text" class="form-control" id="searchtext" placeholder="请输入名称搜索">

                                </div>
                                <!-- /input-group -->
                            </div>
                        </form>
                    </div>
                    <div class="pull-right">
                        <button id="addmaterials" type="button" class="btn btn-default btn-sm" data-toggle="modal"
                                data-target="#addmaterialsModal"><span class="glyphicon glyphicon-plus"
                                                                       style="color: #00FF00;"></span> 添加
                        </button>
                        <button type="button" class="btn btn-default btn-sm" id="materialsremove"><span
                                class="glyphicon glyphicon-remove"></span> 删除
                        </button>
                    </div>
                </div>
                <div class="material-table">
                    <div class="pull-left material-table-t">
                        <table class="table table-bordered  table-hover">
                            <thead>
                            </thead>
                            <tbody>
                            <input type="hidden" id="sort" value="字壳"/>
                            <tr class="td-s" onclick="changesort(this)">
                                <td>字壳</td>
                            </tr>
                            <tr onclick="changesort(this)">
                                <td>底壳</td>
                            </tr>
                            <tr onclick="changesort(this)">
                                <td>树脂</td>
                            </tr>
                            <tr onclick="changesort(this)">
                                <td>亚克力</td>
                            </tr>
                            <tr onclick="changesort(this)">
                                <td>灯</td>
                            </tr>
                            <tr onclick="changesort(this)">
                                <td>人工</td>
                            </tr>
                            </tbody>
                            <tfoot>
                            </tfoot>
                        </table>
                    </div>
                    <div class="pull-right material-table-b1">
                        <table class="table table-bordered" id="materialDetail" data-height="472">
                        </table>

                    </div>
                    <div class="pull-right material-table-b2">
                        <table class="table table-bordered" id="LanternDetail" data-height="472">
                        </table>
                    </div>
                    <div class="pull-right material-table-b3">
                        <table class="table table-bordered" id="laborDetail" data-height="472">
                        </table>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>
<footer>
    <div><p>Copyright&copy;<a>017 深信智能科技有限公司</a>,版权所有 深ICP证030173号 </p></div>
    <div class="recordcode"><a><i></i>深公网安备11000002000001号 </a></div>
</footer>
<!-- 模态框（Modal） -->
<div class="modal fade" id="addmaterialsModal" tabindex="-1" role="dialog" aria-labelledby="mymaterialModalLabel"
     aria-hidden="true">

    <div class="modal-dialog" style="width: 800px;">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="mymaterialModalLabel">添加材料</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal " role="form">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">名字</label>
                        <div class="col-sm-3 sort">
                            <select required="required" class="form-control">
                                <option value="字壳">字壳</option>
                                <option value="底壳">底壳</option>
                                <option value="树脂">树脂</option>
                                <option value="亚克力">亚克力</option>
                                <option value="灯">灯</option>
                                <option value="人工">人工</option>
                            </select>
                        </div>
                    </div>
                </form>
                <div class="addmaterialstable1">
                    <table class="table table-bordered">

                        <thead>
                        <tr>
                            <th>材料名称</th>
                            <th>材料密度</th>
                            <th>厚度</th>
                            <th style="width:150px">计价单位</th>
                            <th>单价</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td><input type="text" class="form-control" id="materialsName" placeholder="请输入名称"></td>
                            <td><input type="text" class="form-control" id="materialsDensity" placeholder="请输入密度"  onkeypress="if(!this.value.match(/^[\+\-]?\d*?\.?\d*?$/))this.value=this.t_value;else this.t_value=this.value;if(this.value.match(/^(?:[\+\-]?\d+(?:\.\d+)?)?$/))this.o_value=this.value"
                                       onkeyup="if(!this.value.match(/^[\+\-]?\d*?\.?\d*?$/))this.value=this.t_value;else this.t_value=this.value;if(this.value.match(/^(?:[\+\-]?\d+(?:\.\d+)?)?$/))this.o_value=this.value"
                                       onblur="if(!this.value.match(/^(?:[\+\-]?\d+(?:\.\d+)?|\.\d*?)?$/))this.value=this.o_value;else{if(this.value.match(/^\.\d+$/))this.value=0+this.value;if(this.value.match(/^\.$/))this.value=0;this.o_value=this.value}"></td>
                            <td><input type="text" class="form-control" id="size" placeholder="请输入厚度"  onkeypress="if(!this.value.match(/^[\+\-]?\d*?\.?\d*?$/))this.value=this.t_value;else this.t_value=this.value;if(this.value.match(/^(?:[\+\-]?\d+(?:\.\d+)?)?$/))this.o_value=this.value"
                                       onkeyup="if(!this.value.match(/^[\+\-]?\d*?\.?\d*?$/))this.value=this.t_value;else this.t_value=this.value;if(this.value.match(/^(?:[\+\-]?\d+(?:\.\d+)?)?$/))this.o_value=this.value"
                                       onblur="if(!this.value.match(/^(?:[\+\-]?\d+(?:\.\d+)?|\.\d*?)?$/))this.value=this.o_value;else{if(this.value.match(/^\.\d+$/))this.value=0+this.value;if(this.value.match(/^\.$/))this.value=0;this.o_value=this.value}"></td>

                            <td>
                                <select name="chargeunit" id="chargeunit" required="required" class="form-control">
                                    <option value="元/平方米">元/平方米</option>
                                    <option value="元/公斤">元/公斤</option>
                                </select>
                            </td>
                            <td><input type="text" class="form-control" id="unitprice" placeholder="请输入名称"
                                       onkeypress="if(!this.value.match(/^[\+\-]?\d*?\.?\d*?$/))this.value=this.t_value;else this.t_value=this.value;if(this.value.match(/^(?:[\+\-]?\d+(?:\.\d+)?)?$/))this.o_value=this.value"
                                       onkeyup="if(!this.value.match(/^[\+\-]?\d*?\.?\d*?$/))this.value=this.t_value;else this.t_value=this.value;if(this.value.match(/^(?:[\+\-]?\d+(?:\.\d+)?)?$/))this.o_value=this.value"
                                       onblur="if(!this.value.match(/^(?:[\+\-]?\d+(?:\.\d+)?|\.\d*?)?$/))this.value=this.o_value;else{if(this.value.match(/^\.\d+$/))this.value=0+this.value;if(this.value.match(/^\.$/))this.value=0;this.o_value=this.value}">
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <div class="addmaterialstable2">
                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <th style="width: 100px;">类型</th>
                            <th>名称</th>
                            <th>计价单位</th>
                            <th>单价</th>
                            <th>总功率</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr id="addLantern">
                            <td>
                                <select name="chargeunit" id="Lanternsort" required="required" class="form-control">
                                    <option value="灯带">灯带</option>
                                    <option value="灯板">灯板</option>

                                </select>
                            </td>
                            <td><input type="text" class="form-control" id="LanternName" placeholder="请输入名称"></td>
                            <td><input type="text" class="form-control" id="Lanternchargeunit" value="元/米"
                                       disabled="disabled">
                            </td>
                            <td><input type="text" class="form-control" id="Lanternunitprice" placeholder="请输入单价"
                                       onkeypress="if(!this.value.match(/^[\+\-]?\d*?\.?\d*?$/))this.value=this.t_value;else this.t_value=this.value;if(this.value.match(/^(?:[\+\-]?\d+(?:\.\d+)?)?$/))this.o_value=this.value"
                                       onkeyup="if(!this.value.match(/^[\+\-]?\d*?\.?\d*?$/))this.value=this.t_value;else this.t_value=this.value;if(this.value.match(/^(?:[\+\-]?\d+(?:\.\d+)?)?$/))this.o_value=this.value"
                                       onblur="if(!this.value.match(/^(?:[\+\-]?\d+(?:\.\d+)?|\.\d*?)?$/))this.value=this.o_value;else{if(this.value.match(/^\.\d+$/))this.value=0+this.value;if(this.value.match(/^\.$/))this.value=0;this.o_value=this.value}">
                            </td>
                            <td><input type="text" class="form-control" id="Lanternpower" placeholder="请输入总功率" value="0"
                                       disabled="disabled"onkeypress="if(!this.value.match(/^[\+\-]?\d*?\.?\d*?$/))this.value=this.t_value;else this.t_value=this.value;if(this.value.match(/^(?:[\+\-]?\d+(?:\.\d+)?)?$/))this.o_value=this.value"
                                       onkeyup="if(!this.value.match(/^[\+\-]?\d*?\.?\d*?$/))this.value=this.t_value;else this.t_value=this.value;if(this.value.match(/^(?:[\+\-]?\d+(?:\.\d+)?)?$/))this.o_value=this.value"
                                       onblur="if(!this.value.match(/^(?:[\+\-]?\d+(?:\.\d+)?|\.\d*?)?$/))this.value=this.o_value;else{if(this.value.match(/^\.\d+$/))this.value=0+this.value;if(this.value.match(/^\.$/))this.value=0;this.o_value=this.value}">
                            </td>

                        </tr>
                        </tbody>
                    </table>
                </div>
                <div class="addmaterialstable3">
                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <th>名称</th>
                            <th>占比</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr id="addlabor">
                            <td><input type="text" class="form-control" id="laborName" placeholder="请输入名称"></td>
                            <td><input type="text" class="form-control" id="laborproportion" placeholder="请输入占比"onkeypress="if(!this.value.match(/^[\+\-]?\d*?\.?\d*?$/))this.value=this.t_value;else this.t_value=this.value;if(this.value.match(/^(?:[\+\-]?\d+(?:\.\d+)?)?$/))this.o_value=this.value"
                                       onkeyup="if(!this.value.match(/^[\+\-]?\d*?\.?\d*?$/))this.value=this.t_value;else this.t_value=this.value;if(this.value.match(/^(?:[\+\-]?\d+(?:\.\d+)?)?$/))this.o_value=this.value"
                                       onblur="if(!this.value.match(/^(?:[\+\-]?\d+(?:\.\d+)?|\.\d*?)?$/))this.value=this.o_value;else{if(this.value.match(/^\.\d+$/))this.value=0+this.value;if(this.value.match(/^\.$/))this.value=0;this.o_value=this.value}"></td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary" id="addmaterial">确定</button>
            </div>
        </div>
    </div>
</div>
<!--修改-->
<input type="hidden" value="" id="uuid"/>
<div class="modal fade" id="changematerialsModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" style="width: 800px;">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">修改材料参数</h4>
            </div>
            <div class="modal-body">
                <div class="alert alert-info" id="changematerialsnotice">你正在修改材料参数！</div>
                <div class="changematerialstable1">
                    <table class="table table-bordered">

                        <thead>
                        <tr>
                            <th>材料名称</th>
                            <th>材料密度</th>
                            <th>厚度</th>
                            <th style="width:150px">计价单位</th>
                            <th>单价</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td><input type="text" class="form-control" id="changematerialsName" placeholder="请输入名称"
                                       value=""></td>
                            <td><input type="text" class="form-control" id="changematerialsDensity" placeholder="请输入密度" onkeypress="if(!this.value.match(/^[\+\-]?\d*?\.?\d*?$/))this.value=this.t_value;else this.t_value=this.value;if(this.value.match(/^(?:[\+\-]?\d+(?:\.\d+)?)?$/))this.o_value=this.value"
                                       onkeyup="if(!this.value.match(/^[\+\-]?\d*?\.?\d*?$/))this.value=this.t_value;else this.t_value=this.value;if(this.value.match(/^(?:[\+\-]?\d+(?:\.\d+)?)?$/))this.o_value=this.value"
                                       onblur="if(!this.value.match(/^(?:[\+\-]?\d+(?:\.\d+)?|\.\d*?)?$/))this.value=this.o_value;else{if(this.value.match(/^\.\d+$/))this.value=0+this.value;if(this.value.match(/^\.$/))this.value=0;this.o_value=this.value}">
                            </td>
                            <td><input type="text" class="form-control" id="changesize" placeholder="请输入厚度" onkeypress="if(!this.value.match(/^[\+\-]?\d*?\.?\d*?$/))this.value=this.t_value;else this.t_value=this.value;if(this.value.match(/^(?:[\+\-]?\d+(?:\.\d+)?)?$/))this.o_value=this.value"
                                       onkeyup="if(!this.value.match(/^[\+\-]?\d*?\.?\d*?$/))this.value=this.t_value;else this.t_value=this.value;if(this.value.match(/^(?:[\+\-]?\d+(?:\.\d+)?)?$/))this.o_value=this.value"
                                       onblur="if(!this.value.match(/^(?:[\+\-]?\d+(?:\.\d+)?|\.\d*?)?$/))this.value=this.o_value;else{if(this.value.match(/^\.\d+$/))this.value=0+this.value;if(this.value.match(/^\.$/))this.value=0;this.o_value=this.value}"></td>
                            <td>
                                <select name="chargeunit" id="changechargeunit" required="required"
                                        class="form-control">
                                    <option value="元/平方米">元/平方米</option>
                                    <option value="元/公斤">元/公斤</option>
                                </select>
                            </td>
                            <td><input type="text" class="form-control" id="changeunitprice" placeholder="请输入名称"
                                       onkeypress="if(!this.value.match(/^[\+\-]?\d*?\.?\d*?$/))this.value=this.t_value;else this.t_value=this.value;if(this.value.match(/^(?:[\+\-]?\d+(?:\.\d+)?)?$/))this.o_value=this.value"
                                       onkeyup="if(!this.value.match(/^[\+\-]?\d*?\.?\d*?$/))this.value=this.t_value;else this.t_value=this.value;if(this.value.match(/^(?:[\+\-]?\d+(?:\.\d+)?)?$/))this.o_value=this.value"
                                       onblur="if(!this.value.match(/^(?:[\+\-]?\d+(?:\.\d+)?|\.\d*?)?$/))this.value=this.o_value;else{if(this.value.match(/^\.\d+$/))this.value=0+this.value;if(this.value.match(/^\.$/))this.value=0;this.o_value=this.value}">
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <div class="changematerialstable2">
                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <th style="width: 100px;">类型</th>
                            <th>名称</th>
                            <th>计价单位</th>
                            <th>单价</th>
                            <th>总功率</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr id="changeLantern">
                            <td>
                                <select name="chargeunit" id="changeLanternsort" required="required"
                                        class="form-control">
                                    <option value="灯板">灯板</option>
                                    <option value="灯带">灯带</option>
                                </select>
                            </td>
                            <td><input type="text" class="form-control" id="changeLanternName" placeholder="请输入名称"></td>
                            <td><input type="text" class="form-control" id="changeLanternchargeunit" value="元/个"
                                       disabled="disabled">
                            </td>
                            <td><input type="text" class="form-control" id="changeLanternunitprice" placeholder="请输入名称"
                                       onkeypress="if(!this.value.match(/^[\+\-]?\d*?\.?\d*?$/))this.value=this.t_value;else this.t_value=this.value;if(this.value.match(/^(?:[\+\-]?\d+(?:\.\d+)?)?$/))this.o_value=this.value"
                                       onkeyup="if(!this.value.match(/^[\+\-]?\d*?\.?\d*?$/))this.value=this.t_value;else this.t_value=this.value;if(this.value.match(/^(?:[\+\-]?\d+(?:\.\d+)?)?$/))this.o_value=this.value"
                                       onblur="if(!this.value.match(/^(?:[\+\-]?\d+(?:\.\d+)?|\.\d*?)?$/))this.value=this.o_value;else{if(this.value.match(/^\.\d+$/))this.value=0+this.value;if(this.value.match(/^\.$/))this.value=0;this.o_value=this.value}">
                            </td>
                            <td><input type="text" class="form-control" id="changeLanternpower" placeholder="请输入总功率"
                                       value="" disabled="disabled"  onkeypress="if(!this.value.match(/^[\+\-]?\d*?\.?\d*?$/))this.value=this.t_value;else this.t_value=this.value;if(this.value.match(/^(?:[\+\-]?\d+(?:\.\d+)?)?$/))this.o_value=this.value"
                                       onkeyup="if(!this.value.match(/^[\+\-]?\d*?\.?\d*?$/))this.value=this.t_value;else this.t_value=this.value;if(this.value.match(/^(?:[\+\-]?\d+(?:\.\d+)?)?$/))this.o_value=this.value"
                                       onblur="if(!this.value.match(/^(?:[\+\-]?\d+(?:\.\d+)?|\.\d*?)?$/))this.value=this.o_value;else{if(this.value.match(/^\.\d+$/))this.value=0+this.value;if(this.value.match(/^\.$/))this.value=0;this.o_value=this.value}">
                            </td>

                        </tr>
                        </tbody>
                    </table>
                </div>
                <div class="changematerialstable3">
                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <th>名称</th>
                            <th>占比</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr id="changelabor">
                            <td><input type="text" class="form-control" id="changelaborName" placeholder="请输入名称"></td>
                            <td><input type="text" class="form-control" id="changelaborproportion" placeholder="请输入占比" onkeypress="if(!this.value.match(/^[\+\-]?\d*?\.?\d*?$/))this.value=this.t_value;else this.t_value=this.value;if(this.value.match(/^(?:[\+\-]?\d+(?:\.\d+)?)?$/))this.o_value=this.value"
                                       onkeyup="if(!this.value.match(/^[\+\-]?\d*?\.?\d*?$/))this.value=this.t_value;else this.t_value=this.value;if(this.value.match(/^(?:[\+\-]?\d+(?:\.\d+)?)?$/))this.o_value=this.value"
                                       onblur="if(!this.value.match(/^(?:[\+\-]?\d+(?:\.\d+)?|\.\d*?)?$/))this.value=this.o_value;else{if(this.value.match(/^\.\d+$/))this.value=0+this.value;if(this.value.match(/^\.$/))this.value=0;this.o_value=this.value}">
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary" id="changematerial">确定</button>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="jquery/jquery-3.1.1.min.js"></script>

<!--bootstrtap js -->
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap-table.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap-table-zh-CN.js"></script>
<script type="text/javascript" src="js/materialManagement.js"></script>
</body>

</html>