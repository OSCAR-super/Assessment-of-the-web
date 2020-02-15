<%--
  Created by IntelliJ IDEA.
  User: Oscar
  Date: 2020/1/29
  Time: 22:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>作业提交系统</title>
    <link href="css/s.css" rel="stylesheet" type="text/css" />
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js">
    </script>
</head>
<body>

<form class="form-inline" action="${pageContext.request.contextPath}/addStudentServlet" method="post" id="form1" enctype="multipart/form-data">

    <div class="Name">
        <p class="name">姓名：</p>
        <input type="text" placeholder="请输入真实姓名" id="name" value="" name="sname" >
    </div>

    <div class="Number">
        <p class="name">学号：</p>
        <input type="text"  placeholder="请输入九位学号" id="id"  value="" name="sid">
    </div>

    <div class="Taskname">

        <p class="name">选择考核:</p>
        <select name="kaohename" id="khname" >
            <c:forEach items="${pb2.list}" var="kaohe">
            <option value="${kaohe.id}" id="kaohename" name="kaohename">${kaohe.name}</option>
            </c:forEach>
         </select>
    </div>

    <div class="file" >
        <p class="name">提交作业：</p>
        <div id="post"  class="post" title="点击上传文件，或拖动文件到此处" >
            <input type="file" class="input" name="file">
        </div>
    </div>

    <div class="form-group" style="text-align: center;">
        <input class="tj" type="submit" value="提交">
        <input type="button" class="back" title="返回主页" onclick="back()"  value="主页">
    </div>
</form>

<script type="text/javascript" src="js/submit1.js"></script>
<script type="text/javascript" src="js/submitjquery.js"></script>
</body>
</html>

