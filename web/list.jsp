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
        #add-customer{
            text-align: center;
        }
    </style>

</head>
<body>
<div class="container">
    <h3>用户信息列表</h3>
    <table class="table table-bordered table-hover">
        <tr>
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
                <td>${c.count}</td>
                <td>${customer.name}</td>
                <td>${customer.gender}</td>
                <td>${customer.age}</td>
                <td>${customer.address}</td>
                <td>${customer.qq}</td>
                <td>${customer.email}</td>
                <td><a class="btn btn-default btn-sm btn-warning" href="update.html" role="button">修改</a>
                    <a class="btn btn-default btn-sm btn-danger" href="#" role="button">删除</a>
                </td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="8" id="add-customer"><a class="btn btn-primary" href="add.html" role="button">添加用户信息</a></td>
        </tr>
    </table>
</div>
</body>
</html>