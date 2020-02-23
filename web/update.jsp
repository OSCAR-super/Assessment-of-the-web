<%--
  Created by IntelliJ IDEA.
  User: Oscar
  Date: 2019/12/17
  Time: 19:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html >
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>修改用户</title>

    <link href="css/a.css" rel="stylesheet"  type="text/css" />
    <script src="js/jquery-2.1.0.min.js"></script>
    <script src="js/bootstrap.min.js"></script>

</head>
<body>
<div class="container">
    <center><h3>修改管理员</h3></center>
    <form action="${pageContext.request.contextPath}/updateDoServlet" method="post">
        <input type="hidden"name="id"value="${user.id}">
        <div class="div">
            <label for="name">姓名：</label><br>
            <input type="text" class="in" id="name" name="name" value="${user.name}"  placeholder="请输入姓名" />
        </div>
        <div class="div">
            <label for="username">用户名：</label><br>
            <input type="text" class="in" id="username" name="username" value="${user.username}"  placeholder="请输入用户名" />
        </div>
        <div class="div">
            <label for="password">密码：</label><br>
            <input type="text" class="in" id="password" name="name" value="${user.password}"  placeholder="请输入密码" />
        </div>

        <br><br>
        <div class="form-group" style="text-align: center">
            <input class="btn" type="submit" value="提交" />
            <input class="btn" type="reset" value="重置" />
            <input class="btn" type="button" value="返回" onclick="back()"/>
        </div>
    </form>
</div>
</body>
</html>