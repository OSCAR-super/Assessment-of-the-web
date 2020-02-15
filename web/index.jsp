<%@ page import="pojo.User" %><%--
  Created by IntelliJ IDEA.
  User: Oscar
  Date: 2019/12/15
  Time: 20:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html >
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>用户信息管理系统</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>
    <script type="text/javascript">
        window.onload=function () {
            document.getElementById("chkAll").onclick=function () {
                var chkAll=document.getElementById("chkAll");
                var chk=document.getElementsByName("chk");
                for (var i=0;i<chk.length;i++){
                    chk[i].checked=chkAll.checked;};

            }
            document.getElementById("delSelected").onclick=function () {
                var flag=false;
                var chk= document.getElementsByName("chk");
                for (var i=0;i<chk.length;i++){
                    if (chk[i].checked){
                        flag=true;

                    }
                }
                if (flag=true){
                    document.getElementById("form1").submit();
                }
            }
        }

    </script>
</head>
<body>
<%
    if (session.getAttribute("user")==null){
    response.sendRedirect(request.getContextPath()+"/homepage.jsp");
}else {
    User u=(User)session.getAttribute("user");
    out.print(u.getUsername());
}

%>
<form class="form-inline" action="${pageContext.request.contextPath}/FindUserByConditionServlet" method="post">
    <div class="form-group">
        <label for="exampleInputName2">姓名</label>
        <input type="text" name="name" value="${condition.name[0]}" class="form-control" id="exampleInputName2">
    </div>
    <div class="form-group">
        <label for="exampleInputName3">用户名</label>
        <input type="text" name="username" value="${condition.username[0]}" class="form-control" id="exampleInputName3">
    </div>
    <div class="form-group">
        <label for="exampleInputEmail2">密码</label>
        <input type="text" name="password" value="${condition.password[0]}" class="form-control" id="exampleInputEmail2">
    </div>

    <button type="submit" class="btn btn-default">查询</button>
</form>
<a class="btn bg-primary"href="${pageContext.request.contextPath}/add.jsp">添加管理员</a>
<a class="btn bg-primary" href="javascript:void (0);" id="delSelected">删除选中</a>
<form action="${pageContext.request.contextPath}/delSelectedServlet" method="post" id="form1">
<div class="container">
    <h3 style="text-align: center">管理员信息列表</h3>
    <table border="1" class="table table-bordered table-hover">
        <tr class="success">
            <th><input type="checkbox" id="chkAll"></th>
            <th>编号</th>
            <th>姓名</th>
            <th>用户名</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${pb.list}" var="user">
            <tr>
                <td><input type="checkbox" name="chk" value="${user.id}"></td>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.username}</td>

                <td><a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/updateUserServlet?id=${user.id}">修改</a>&nbsp;<a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/delUserServlet?id=${user.id}">删除</a></td>
            </tr>
        </c:forEach>

        <tr>
            <td colspan="8" align="center"><a class="btn btn-primary" href="${pageContext.request.contextPath}/add.jsp">添加管理员</a></td>
        </tr>
    </table>

    <div>
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <c:if test="${pb.currentPage==1}">
                <li class="disabled">
                    </c:if>
                <c:if test="${pb.currentPage!=1}">
                <li>
                    </c:if>
                    <a href="${pageContext.request.contextPath}/FindUserByConditionServlet?currentPage=${pb.currentPage-1}&rows=5&username=${condition.username[0]}&name=${condition.name[0]}&password=${condition.password[0]}"aria-label="Previous" ;>
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
                <c:forEach begin="1" end="${pb.totalPage}" var="i">
                    <c:if test="${pb.currentPage==i}">
                        <li class="active"><a href="${pageContext.request.contextPath}/FindUserByConditionServlet?currentPage=${i}"&rows=5&username=${condition.username[0]}&name=${condition.name[0]}&password=${condition.password[0]}";>${i}</a> </li>
                    </c:if>
                    <c:if test="${pb.currentPage!=i}">
                        <li><a href="${pageContext.request.contextPath}/FindUserByConditionServlet?currentPage=${i}"&rows=5&username=${condition.username[0]}&name=${condition.name[0]}&password=${condition.password[0]}";>${i}</a> </li>
                    </c:if>

                </c:forEach>
                <li>
                    <a href="${pageContext.request.contextPath}/FindUserByConditionServlet?currentPage=${pb.currentPage+1}&rows=5&username=${condition.username[0]}&name=${condition.name[0]}&password=${condition.password[0]}"aria-label="Previous" ;>
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
                <span style="">
                    共${pb.totalCount}条记录，共${pb.totalPage}页
                </span>


            </ul>
        </nav>
    </div>
</div>
</form>
</body>
</html>
