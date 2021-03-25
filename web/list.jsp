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
    </style>
<script>
    function deleteCustomer(id) {
        if(confirm("您确定要删除该用户吗")){
            location.href = "${pageContext.request.contextPath}/deleteCustomerServlet?id="+id;
        }
    }
</script>
</head>
<body>
<div class="container">
    <h3>用户信息列表</h3>
    <div id="query_button">
        <form class="form-inline">
            <div class="form-group">
                <label for="exampleInputName">姓名</label>
                <input type="text" class="form-control" id="exampleInputName">
            </div>
            <div class="form-group">
                <label for="exampleInputAddress">籍贯</label>
                <input type="text" class="form-control" id="exampleInputAddress">
            </div>
            <div class="form-group">
                <label for="exampleInputEmail">邮箱</label>
                <input type="text" class="form-control" id="exampleInputEmail">
            </div>
            <button type="submit" class="btn btn-primary">查询</button>
        </form>
    </div>
    <div id="add_delete_button">
        <a class="btn btn-primary" href="${pageContext.request.contextPath}/add.jsp" role="button">添加用户信息</a>
        <a class="btn btn-danger" href="#" role="button">删除选中</a>
    </div>
    <table class="table table-bordered table-hover">
        <tr>
            <th><input type="checkbox"></th>
            <th>编号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>年龄</th>
            <th>籍贯</th>
            <th>QQ</th>
            <th>邮箱</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${customers}" var="customer" varStatus="c">
            <tr>
                <td><input type="checkbox"></td>
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
    <div id="page_nav">
        <nav aria-label="Page navigation ">
            <ul class="pagination">
                <li>
                    <a href="#" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
                <li><a href="#">1</a></li>
                <li><a href="#">2</a></li>
                <li><a href="#">3</a></li>
                <li><a href="#">4</a></li>
                <li><a href="#">5</a></li>
                <li>
                    <a href="#" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
                <span id="count_number">共23条记录，共3页</span>
            </ul>
        </nav>
    </div>
</div>
</body>
</html>