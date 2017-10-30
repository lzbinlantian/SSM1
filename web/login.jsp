<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--

Created by IntelliJ IDEA.
User: LANTIAN
Date: 2017/10/3
Time: 23:49
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

<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>登陆界面</title>

    <link href="css/style2.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css"/>
    <script type="text/javascript" src="jquery/jquery-3.1.1.min.js" ></script>
    <script src="js/jquery.login.js"></script>
    <script src="js/logo.js"></script>
</head>

<body style="background-color:ghostwhite">
<form action="<c:url value="/login"/>" method="post" id="vail" onsubmit="return checkUser();">
    <div class="login_m">
        <div class="login_boder">
            <div class="login">
                <img src="images/beijing2.jpg"></img>
                <div class="wenzi">
                    <h5>快速开始您的报价</h5>
                </div>
            </div>
            <div class="prompting">
                <p>${msg}</p>
            </div>
            <div class="login_padding">
                <input name="phone" id="phone" class="txt_input txt_input2" placeholder="请输入您的手机号">
                <input type="password" name="password" id="userpwd" class="txt_input" placeholder="请输入您的密码">
            </div>

            <div class="rem_sub_l">
                <label>
                    <input type="checkbox" name="checkbox" id="save_me" class="pull-left">
                    <p class="pull-right jizhumima">记住密码</p>
                </label>
            </div>

            <div class="rem_sub">

                <div class="right">

                    <!--<input type="reset" class="btn btn-primary " name="" id="" value="重置" style="opacity: 0.7;">-->

                    <button class="btn btn-primary  btn-block" type="submit">立即登陆</button>

                </div>

            </div>
        </div>

    </div>
    </div>
</form>

</body>

</html>