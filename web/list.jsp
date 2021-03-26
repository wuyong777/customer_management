<%--
  Created by IntelliJ IDEA.
  User: 123
  Date: 2021/3/24
  Time: 17:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>用户管理系统</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="js/jquery-3.2.1.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="js/bootstrap.min.js"></script>
    <style>
        h3 {
            text-align: center;
        }
        table th,td{
            text-align: center;
        }
        table th{
            background-color: #67b168;
        }
        #add_delete_button{
            float: right;
            margin: 5px;
        }
        #query_button{
            float: left;
            margin: 5px;
        }
        #page_nav{
            text-align: center;
        }
        #count_number{
            font-size: 25px;
            margin-left: 10px;
        }
        .navbar-fixed-bottom{
            margin-bottom: 50px;
        }
    </style>
<script>
    function deleteCustomer(id) {
        if(confirm("您确定要删除该用户吗?")){
            location.href = "${pageContext.request.contextPath}/deleteCustomerServlet?id="+id;
        }
    }

    window.onload = function () {
        document.getElementById("delSelected").onclick = function () {
            if (confirm("您确定要删除选中的用户吗？")){
                var flag = false;
                var cids = document.getElementsByName("cid");
                for (var i = 0; i < cids.length; i++) {
                    if (cids[i].checked) {
                        flag = true;
                        break;
                    }
                }
                if (flag){
                    document.getElementById("selectedform").submit();
                }
            }
        }

        document.getElementById("firstCheckbox").onclick = function () {
            var cids = document.getElementsByName("cid");
            for (var i = 0; i < cids.length; i++) {
                cids[i].checked = this.checked;
            }
        }
    }
</script>
</head>
<body>
<div class="container">
    <h3>用户信息列表</h3>
    <div id="query_button">
        <form class="form-inline" action="${pageContext.request.contextPath}/findCustomerByPageServlet" method="post">
            <div class="form-group">
                <label for="exampleInputName">姓名</label>
                <input type="text" name="name" value="${condition.name[0]}" class="form-control" id="exampleInputName">
            </div>
            <div class="form-group">
                <label for="exampleInputAddress">籍贯</label>
                <input type="text" name="address" value="${condition.address[0]}" class="form-control" id="exampleInputAddress">
            </div>
            <div class="form-group">
                <label for="exampleInputEmail">邮箱</label>
                <input type="text" name="email" value="${condition.email[0]}" class="form-control" id="exampleInputEmail">
            </div>
            <button type="submit" class="btn btn-primary">查询</button>
        </form>
    </div>
    <div id="add_delete_button">
        <a class="btn btn-primary" href="${pageContext.request.contextPath}/add.jsp" role="button">添加用户信息</a>
        <a class="btn btn-danger" href="javascript:void(0);" id="delSelected" role="button">删除选中</a>
    </div>
    <form id="selectedform" action="${pageContext.request.contextPath}/deleteSelectedServlet" method="post">
        <table class="table table-bordered table-hover">
        <tr>
            <th><input type="checkbox" id="firstCheckbox"></th>
            <th>编号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>年龄</th>
            <th>籍贯</th>
            <th>QQ</th>
            <th>邮箱</th>
            <th>操作</th>
        </tr>
        <%--<c:forEach items="${customers}" var="customer" varStatus="c">--%>
            <c:forEach items="${pb.list}" var="customer" varStatus="c">
            <tr>
                <td><input type="checkbox" name="cid" value="${customer.id}"></td>
                <td>${c.count}</td>
                <td>${customer.name}</td>
                <td>${customer.gender}</td>
                <td>${customer.age}</td>
                <td>${customer.address}</td>
                <td>${customer.qq}</td>
                <td>${customer.email}</td>
                <td><a class="btn btn-default btn-sm btn-warning" href="${pageContext.request.contextPath}/findCustomerServlet?id=${customer.id}" role="button">修改</a>&nbsp;
                    <a class="btn btn-default btn-sm btn-danger" href="javascript:deleteCustomer(${customer.id});" role="button">删除</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    </form>
    <div id="page_nav">
        <nav aria-label="Page navigation " class="navbar-fixed-bottom">
            <ul class="pagination">
                <c:if test="${pb.currentPage == 1}">
                    <li class="disabled">
                        <a href="${pageContext.request.contextPath}/findCustomerByPageServlet?currentPage=1&rows=10&name=${condition.name[0]}&address=${condition.address[0]}&email=${condition.email[0]}" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                </c:if>
                <c:if test="${pb.currentPage > 1 && (pb.currentPage <= pb.totalPage)}">
                    <li>
                        <a href="${pageContext.request.contextPath}/findCustomerByPageServlet?currentPage=${pb.currentPage - 1}&rows=10&name=${condition.name[0]}&address=${condition.address[0]}&email=${condition.email[0]}" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                </c:if>
                <c:forEach begin="1" end="${pb.totalPage}" var="i">
                    <c:if test="${pb.currentPage == i}">
                        <li class="active"><a href="${pageContext.request.contextPath}/findCustomerByPageServlet?currentPage=${i}&rows=10&name=${condition.name[0]}&address=${condition.address[0]}&email=${condition.email[0]}">${i}</a></li>
                    </c:if>
                    <c:if test="${pb.currentPage != i}">
                        <li><a href="${pageContext.request.contextPath}/findCustomerByPageServlet?currentPage=${i}&rows=10&name=${condition.name[0]}&address=${condition.address[0]}&email=${condition.email[0]}">${i}</a></li>
                    </c:if>
                </c:forEach>
                <c:if test="${pb.currentPage >= pb.totalPage}">
                    <li class="disabled">
                        <a href="${pageContext.request.contextPath}/findCustomerByPageServlet?currentPage=${pb.totalPage}&rows=10&name=${condition.name[0]}&address=${condition.address[0]}&email=${condition.email[0]}" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </c:if>
                <c:if test="${pb.currentPage < pb.totalPage}">
                    <li>
                        <a href="${pageContext.request.contextPath}/findCustomerByPageServlet?currentPage=${pb.currentPage + 1}&rows=10&name=${condition.name[0]}&address=${condition.address[0]}&email=${condition.email[0]}" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </c:if>
                <span id="count_number">共${pb.totalCount}条记录，共${pb.totalPage}页</span>
            </ul>
        </nav>
    </div>
</div>
</body>
</html>