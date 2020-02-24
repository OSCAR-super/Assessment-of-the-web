<%--
  Created by IntelliJ IDEA.
  User: Oscar
  Date: 2020/1/31
  Time: 16:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html lang="en">
<script type="text/javascript">
    window.onload=function () {
        document.getElementById("chkAll").onclick=function () {
            var chkAll=document.getElementById("chkAll");
            var chk=document.getElementsByName("chk");
            for (var i=0;i<chk.length;i++){
                chk[i].checked=chkAll.checked;};

        }
        document.getElementById("remove").onclick=function () {
            var flag=false;
            var chk= document.getElementsByName("chk");
            for (var i=0;i<chk.length;i++){
                if (chk[i].checked){
                    flag=true;

                }
            }
            if (flag=true){
                document.getElementById("form").submit();
            }
        }
    }
</script>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/list.css" rel="stylesheet">
    <script src="js/Jquery.js"></script>
    <script src="js/list.js"></script>
    <title>考核任务列表</title>
</head>
<%
    if (session.getAttribute("user")==null){
        response.sendRedirect(request.getContextPath()+"/homepage.jsp");
    }
%>
<body>
<a  href="${pageContext.request.contextPath}/FindUserByConditionServlet" id="admin" >管理员信息</a>
<form action="${pageContext.request.contextPath}/delListSelectedServlet" method="post" id="form">
    <div class="container">
        <h3>考核任务列表</h3>
        <table  class="table">
            <thead>

            <tr class="task">
                <th width="100px"><input type="checkbox" id="chkAll" onclick="chkall()" value="${kaohe.id}">全选</th>
                <th width="200px">考核名</th>
                <th width="120px">截止时间</th>
                <th width="120px"></th>

            </tr>
            </thead>
            <tbody id="stu">
            <c:forEach items="${pb2.list}" var="kaohe">
                <tr>
                    <td><input type="checkbox" name="chk" value="${kaohe.id}"></td>
                    <td>${kaohe.name}</td>
                    <td>${kaohe.time}</td>
                    <td><a class="search" href="${pageContext.request.contextPath}/FindKServlet?name=${kaohe.name}">查看详情</a></td>

                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div>
            <nav aria-label="Page navigation">
                <ul class="pagination">
                    <c:if test="${pb2.currentPage==1}">
                    <li class="disabled">
                        </c:if>
                        <c:if test="${pb2.currentPage!=1}">
                    <li>
                        </c:if>
                        <a href="${pageContext.request.contextPath}/FindListServlet?currentPage=${pb2.currentPage-1}&rows=5"aria-label="Previous" ;>
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                    <c:forEach begin="1" end="${pb2.totalPage}" var="i">
                        <c:if test="${pb2.currentPage==i}">
                            <li class="disabled"><a href="${pageContext.request.contextPath}/FindListServlet?currentPage=${i}"&rows=5";>${i}</a> </li>
                        </c:if>
                        <c:if test="${pb2.currentPage!=i}">
                            <li><a href="${pageContext.request.contextPath}/FindListServlet?currentPage=${i}"&rows=5";>${i}</a> </li>
                        </c:if>

                    </c:forEach>
                    <li>
                        <a href="${pageContext.request.contextPath}/FindListServlet?currentPage=${pb2.currentPage+1}&rows=5"aria-label="Previous" ;>
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                    <span style="margin-left: 10px;">
                    共${pb2.totalCount}条记录，共${pb2.totalPage}页
                </span>


                </ul>
            </nav>
        </div>
        <br><br>
        <input type="submit" id="remove"  value="删除">
        <input type="button" id="add" onclick="zj()" value="增加">

    </div>
</form>

</body>
</html>