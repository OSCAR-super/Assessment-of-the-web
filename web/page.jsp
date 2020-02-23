<%--
  Created by IntelliJ IDEA.
  User: Oscar
  Date: 2020/1/31
  Time: 14:45
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
</head>

<body>
<form class="form-inline" action="${pageContext.request.contextPath}/FindStudentByConditionServlet" method="post">
    <div class="form-group" style="margin-left: 10%;">
        <label for="InputName1">姓名</label>
        <input type="text" name="sname" value="${condition.sname[0]}" class="form-control" id="InputName1">
    </div>
    <div class="form-group">
        <label for="InputName2">学号</label>
        <input type="text" name="sid" value="${condition.sid[0]}" class="form-control" id="InputName2">
    </div>
    <div class="form-group">
        <label for="InputEmail">标记</label>
        <input type="text" name="gai" value="${condition.gai[0]}" class="form-control" id="InputEmail">
    </div>
    <button type="submit" class="search">查询</button>
    <c:forEach items="${pbs.list}" end="${studenst.sid}" var="students">
    <div>
        <input type="hidden" name="kaohename" value="${students.kaohename}">
    </div>
        </c:forEach>

</form>

<form action="${pageContext.request.contextPath}/delStudentSelectedServlet" method="post" id="form1">
    <div class="container">
        <h3>学生信息列表</h3>
        <table  class="table">
            <thead>

            <tr class="student">
                <th width="100px"><input type="checkbox" id="chkAll" onclick="chkall()">全选</th>
                <th width="150px">学号</th>
                <th width="120px">姓名</th>
                <th width="120px">提交时间</th>
                <th width="100px">批改人</th>
                <th width="100px">文件</th>
                <th width="100px">在线预览</th>
                <th width="100px">标记</th>
                <th width="100px">批改</th>

            </tr>
            </thead>
            <tbody id="stu">
            <c:forEach items="${pbs.list}" var="students">

            <tr >
                <td><input type="checkbox" name="chk" value="${students.sid}"></td>
                <td>${students.sid}</td>
                <td>${students.sname}</td>
                <td>${students.stime}</td>
                <td>${students.teacher}</td>
                <td><a class="search" href="${pageContext.request.contextPath}/downServlet?filename=${students.file}">${students.file}</a></td>
                <td><a class="search" href="${pageContext.request.contextPath}/viewServlet?filename=${students.file}">${students.file}</a></td>
                <td>
                        ${students.gai}

                </td>

                <td><a class="search" href="${pageContext.request.contextPath}/updateStudentServlet?sid=${students.sid}&&gai=审核中&&kaohename=${students.kaohename}">审核中</a><a class="search" href="${pageContext.request.contextPath}/updateStudentServlet?sid=${students.sid}&&gai=通过&&kaohename=${students.kaohename}">通过</a><a class="search" href="${pageContext.request.contextPath}/updateStudentServlet?sid=${students.sid}&&gai=未通过&&kaohename=${students.kaohename}">未通过</a></td>
            </tr>

            </c:forEach>
            </tbody>
        </table>

        <br><br>
        <input type="submit" id="remove"  value="删除选中">
    </div>
</form>
</body>
</html>
