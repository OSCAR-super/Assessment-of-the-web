<%--
  Created by IntelliJ IDEA.
  User: Oscar
  Date: 2020/1/20
  Time: 16:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>添加用户</title>
    <link href="css/a.css" rel="stylesheet" type="text/css" />
    <script src="js/bootstrap.min.js"></script>
    <script>
        function back(){
            window.history.go(-1);
        }
    </script>
</head>
<body>
<div class="container">
    <center><h3>添加管理员页面</h3></center>
    <form action="${pageContext.request.contextPath}/addUserServlet" method="post">
        <div class="div">
            <label for="name">姓名：</label><br>
            <input type="text" class="in" id="name" name="name" value="${user.name}" placeholder="请输入用户名">
        </div>
        <div class="div">
            <label for="password">密码：</label><br>
            <input type="text" class="in" id="password" name="password" value="${user.password}" placeholder="请输入用户名">
        </div>
        <div class="div">
            <label for="username">用户名：</label><br>
            <input type="text" class="in" id="username" name="username" value="${user.username}" placeholder="请输入用户名">
        </div>
        <br><br>
        <div class="" style="text-align: center">
            <input class="btn" type="submit" value="提交" />
            <input class="btn" type="reset" value="重置" />
            <input class="btn" type="button" value="返回" onclick="back()"/>
        </div>
    </form>
</div>
</body>

</html>