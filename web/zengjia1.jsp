<%--
  Created by IntelliJ IDEA.
  User: Oscar
  Date: 2020/2/2
  Time: 19:33
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
    <script src="js/Jquery.js"></script>
    <link href="css/xiugai.css" rel="stylesheet">
    <title>修改考核信息</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/addListServlet" method="post">
    <br><br>
    <div class="t">
        <label for="name">考核主题</label>
        <input type="text" id="name" class="task" name="name" onclick="edit(this,'name')" value=""/>
    </div>
    <br><br>
    <div class="t">
        <label for="time">截止时间</label>
        <input type="date" id="time" class="task" name="time" onblur="jiancha()" value="${kaohe.time}">
    </div>
    <br><br>
    <div class="t">
        <label for="neiron">考核详情</label>
        <textarea type="text" id="neiron" name="neiron" class="task" ></textarea>
    </div>
    <br><br>
    <input type="submit" class="btn" style="margin-left: 45%;" value="提交"/>
    <input type="reset" class="btn" style="margin-left: 25px;" value="重置"/>
    <script>
        function jiancha(){
            let time = document.getElementById("time").value;
            let date = new Date();
            let year = date.getFullYear();
            let month = ('0' + (date.getMonth() + 1)).slice(-2);
            let day = ('0' + date.getDate()).slice(-2);
            let nowDate = year + '-' + month + '-' +day;

            let ttt = new Date(time);

            if(ttt<=date)
            {
                alert("请选择正确的时间！");
                document.getElementById("time").value = nowDate;
            }

        }
    </script>
</form>
</body>
</html>
