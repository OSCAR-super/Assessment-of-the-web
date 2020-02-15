<%--
  Created by IntelliJ IDEA.
  User: Oscar
  Date: 2020/2/5
  Time: 20:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html >

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>考核详情页</title>
    <link href="css/page.css" rel="stylesheet">
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js">
    </script>
    <script type="text/javascript" src="js/myJquery.js"></script>
    <script type="text/javascript" src="js/page.js"></script>
    <link href="css/xiugai.css" rel="stylesheet">
</head>

<body>
<form action="${pageContext.request.contextPath}/updateListServlet" method="post">
    <br><br>
    <div class="t">
        <label for="name">考核主题</label>
        <input type="text" id="name" class="task" name="name" onclick="edit(this,'name')" value="${kaohe.name}">
    </div>
    <br><br>
    <div class="t">
        <label for="time">截止时间</label>
        <input type="text" id="time" class="task" name="time" onclick="edit(this,'time')" value="${kaohe.time}">
    </div>
    <br><br>
    <div class="t">
        <label for="neiron">考核详情</label>
        <textarea type="text" id="neiron" name="neiron" class="task" value="${kaohe.neiron}">${kaohe.neiron}</textarea>
    </div>
    <br><br>
    <input type="submit" class="btn" style="margin-left: 45%;" value="确认修改"/>
    <div >
    <input type="hidden" name="id" value="${kaohe.id}">
    </div>

</form>
<div >

    <a class="search" href="${pageContext.request.contextPath}/fServlet?kaohename=${kaohe.id}">进入批改</a>
</div>



</body>
</html>

