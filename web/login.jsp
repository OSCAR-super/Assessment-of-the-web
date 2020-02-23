<%--
  Created by IntelliJ IDEA.
  User: Oscar
  Date: 2019/12/11
  Time: 0:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>管理员登录</title>
    <link href="css/l.css" rel="stylesheet">
    <script src="js/jquery-2.1.0.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript">
        function refreshCode() {
            var code=document.getElementById("vcode");
            code.src="${pageContext.request.contextPath}/CheckCodeServlet?time"+new Date().getTime();
        }
    </script>
</head>
<body>
<%
    if (session.getAttribute("user")!=null){
        response.sendRedirect(request.getContextPath()+"/FindListServlet");
    }

%>
<div class="container" >
    <center>  <h3 style="text-align: center;">管理员登录</h3></center>
    <form action="${pageContext.request.contextPath}/LoginServlet" method="post">
        <div class="div">
            <label for="user">用户名：</label><br>
            <input type="text" name="user" class="in" id="user" placeholder="请输入用户名"/>
        </div>
        <br>
        <div class="div">
            <label for="password">密码：</label><br>
            <input type="password" name="password" class="in" id="password" placeholder="请输入密码"/>
        </div>
        <br>
        <div class="div">
            <label for="vcode">验证码：</label><br>
            <input type="text" name="verifycode" class="in" id="verifycode" placeholder="请输入验证码" />
            <a href="javascript:refreshCode()"><img src="${pageContext.request.contextPath}/CheckCodeServlet" title="看不清点击刷新" id="vcode"/></a>
        </div>
        <hr/>
        是否记住密码：<input type="checkbox" name="isAutoLogin" value="true">
        <div class="form-group" style="text-align: center;">
            <br>    <input class="btn" type="submit" value="登录">
        </div>
    </form>
    <br>
    <!-- 出错显示的信息框 -->
    <div class="alert alert-warning alert-dismissible" role="alert">
        <button type="button" class="btn1" data-dismiss="alert" >
            <span>&times;</span>
        </button>
        <strong>${login_msg}</strong>
    </div>
</div>
</body>
</html>
