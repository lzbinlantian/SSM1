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

    <meta charset="utf-8"/>
    <title>账号管理</title>
    <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
    <meta name="description" content="Developed By M Abdur Rokib Promy">
    <meta name="keywords" content="Admin, Bootstrap 3, Template, Theme, Responsive">

    <script type="text/javascript" src="jquery/jquery-3.1.1.min.js"></script>


    <!--bootstrtap js -->
    <script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="bootstrap/js/bootstrap-table.js"></script>
    <script type="text/javascript" src="bootstrap/js/bootstrap-table-zh-CN.js"></script>
    <script type="text/javascript" src="js/accountMangement.js"></script>
    <!--bootstrtap css-->
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="bootstrap/css/bootstrap-table.css"/>

    <link type="text/css" rel="stylesheet" href="css/navbar.css"/>
    <link rel="stylesheet" href="css/accountManagement.css"/>
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
            <li class="active">
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
                <p class="pull-left">账号管理</p>
            </div>
            <div class="container-s">
                <div class="search">
                    <div class="pull-left search-w">
                        <div id="search">
                        <select name="role" required="required" class="form-control">
                            <option value="">根据权限搜索</option>
                            <option value="管理员">管理员</option>
                            <option value="员工">员工</option>
                        </select>
                        </div>
                    </div>
                    <div class="container-s-top pull-right">
                        <button type="button" class="btn btn-default btn-sm" data-toggle="modal"
                                data-target="#addUserModal"><span class="glyphicon glyphicon-plus"
                                                                  style="color: #00FF00;"></span> 添加
                        </button>
                        <button type="button" class="btn btn-default btn-sm" id="remove"><span
                                class="glyphicon glyphicon-remove"></span> 删除
                        </button>
                    </div>

                </div>
                <table class="table table-bordered" id="userTable" data-height="550">
                </table>
            </div>

        </div>
    </div>
    <footer>
        <div><p>Copyright&copy;<a>017 深信智能科技有限公司</a>,版权所有 深ICP证030173号 </p></div>
        <div class="recordcode"><a><i></i>深公网安备11000002000001号 </a></div>
    </footer>
    <!-- 模态框（Modal） -->
    <!--添加用户-->
    <div class="modal fade" id="addUserModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
         aria-hidden="true">

        <div class="modal-dialog" style="width:800px">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title">添加账号</h4>
                </div>
                <div class="modal-body">
                    <div class="alert alert-info" id="addnotice">你正在添加用户信息！</div>
                    <table class="table table-bordered">

                        <thead>
                        <tr>
                            <th>账号</th>
                            <th>昵称</th>
                            <th>密码</th>
                            <th>角色</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td><input type="text" class="form-control" name="user" id="addphone" placeholder="请输入手机号码"
                                       value=""></td>
                            <td><input type="text" class="form-control" name="user" id="addname" placeholder="请输入昵称"
                                       value=""></td>
                            <td><input type="text" class="form-control" name="password" id="addpassword"
                                       placeholder="请输入密码" value=""></td>
                            <td>
                                <select name="role" required="required" class="form-control" id="addgrant">
                                    <option value="管理员">管理员</option>
                                    <option value="员工">员工</option>
                                </select>

                            </td>
                        </tr>
                        </tbody>
                    </table>

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <button type="button" class="btn btn-primary" id="add">确定</button>
                </div>
            </div>
            <!-- /.modal-content -->
        </div>
        <!-- /.modal -->
    </div>
    <!--修改密码-->
    <input type="hidden" value="" id="user"/>
    <div class="modal fade" id="changePasswordModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
         aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        &times;
                    </button>
                    <h4 class="modal-title" id="myModalLabel">
                        修改密码
                    </h4>
                </div>
                <div class="modal-body">
                    <div class="usernotice">

                    </div>
                    <form class="form-horizontal" role="form">
                        <div class="form-group">
                            <label class="col-sm-2 control-label">新密码</label>
                            <div class="col-sm-5">
                                <input type="text" class="form-control" id="password1" placeholder="输入新密码" value="">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">确认密码</label>
                            <div class="col-sm-5">
                                <input type="text" class="form-control" id="password2" placeholder="请再输入一遍" value="">
                            </div>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消
                    </button>
                    <button type="button" class="btn btn-primary" id='confirmchangepassword'>
                        提交更改
                    </button>
                </div>
            </div>
            <!-- /.modal-content -->
        </div>
    </div>
    <!-- /.modal -->
    <!--修改权限-->
    <div class="modal fade" id="changeroleModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
         aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">

                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        &times;
                    </button>
                    <h4 class="modal-title" id="myModalLabel">
                        修改密码
                    </h4>
                </div>
                <div class="modal-body">
                    <div class="rolenotice">

                    </div>
                    <select name="role" required="required" class="form-control" id="changerole">
                        <option value="管理员">管理员</option>
                        <option value="员工">员工</option>
                    </select>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消
                    </button>
                    <button type="button" class="btn btn-primary" id='confirmchangerole'>
                        提交更改
                    </button>
                </div>
            </div>
            <!-- /.modal-content -->
        </div>
    </div>
</div>
</body>

</html>