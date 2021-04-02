<%--
  Created by IntelliJ IDEA.
  User: 123
  Date: 2021/3/25
  Time: 20:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        .container{
            width: 500px;
        }
        h3{
            text-align: center;
            font-size: 20px;
            color: #2aabd2;
        }
        #add-bottom{
            text-align: center;
        }
    </style>
</head>
<body>
<div class="container">
    <h3>添加用户信息页面</h3>
    <form action="${pageContext.request.contextPath}/addCustomerServlet" method="post">
        <div class="form-group">
            <label for="inputname">姓名</label>
            <input type="text" class="form-control" id="inputname" name="name" placeholder="请输入姓名">
        </div>
        <div class="form-group">
            <label>性别</label>
            <input type="radio" name="gender" value="男" checked="checked"/>男
            <input type="radio" name="gender" value="女"/>女
        </div>
        <div class="form-group">
            <label for="inputage">年龄</label>
            <input type="text" class="form-control" id="inputage" name="age" placeholder="请输入年龄">
        </div>
        <div class="form-group">
            <label for="inputaddress">籍贯</label>
            <select id="inputaddress" class="form-control" name="address">
                <option value="北京">北京</option>
                <option value="上海">上海</option>
                <option value="广州">广州</option>
                <option value="深圳">深圳</option>
                <option value="杭州">杭州</option>
            </select>
        </div>


        <div class="form-group">
            <label for="inputQQ">QQ</label>
            <input type="text" class="form-control" id="inputQQ" name="qq" placeholder="请输入QQ">
        </div>
        <div class="form-group">
            <label for="inputEmail">邮箱</label>
            <input type="text" class="form-control" id="inputEmail" name="email" placeholder="请输入邮箱">
        </div>
        <div id="add-bottom" class="form-group">
            <input type="submit" class="btn btn-primary"  value="提交">
            <input type="reset" class="btn btn-default"  value="重置">
            <input type="button" class="btn btn-default"  value="返回">
        </div>

    </form>
</div>
</body>
</html>