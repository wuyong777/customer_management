<%--
  Created by IntelliJ IDEA.
  User: 123
  Date: 2021/3/25
  Time: 14:11
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
    <script type="text/javascript">
        //切换验证码
        function refreshCode() {
            var vcode = document.getElementById("vcode");
            vcode.src = "${pageContext.request.contextPath}/checkCodeServlet?time="+new Date().getTime();
        }
    </script>
    <style>
        h2{
            text-align: center;
            color: #2aabd2;
        }
        .container{
            width: 400px;
        }
        #submit{
            text-align: center;
        }
        #verifycode{
            width: 180px;
        }
    </style>
</head>
<body>
<div>
    <div class="container">
        <h2>管理员登录</h2>
        <form action="${pageContext.request.contextPath}/loginServlet" method="post" >
            <div class="form-group">
                <label for="username">用户名</label>
                <input type="text" class="form-control" id="username" name="username" placeholder="请输入用户名">
            </div>
            <div class="form-group">
                <label for="username">密码</label>
                <input type="text" class="form-control" id="password" name="password" placeholder="请输入密码">
            </div>
            <div class="form-inline ">
                <label for="verifycode">验证码</label>
                <input type="text" class="form-control" id="verifycode" name="verifycode" placeholder="请输入验证码">
                <a href="javascript:refreshCode();">
                    <img src="${pageContext.request.contextPath}/checkCodeServlet" title="看不清，换一张" id="vcode">
                </a>
            </div>
            <br/>
            <div class="form-group" id="submit">
                <input type="submit" value="登录" class="btn btn-primary">
            </div>
            <div class="alert alert-warning alert-dismissible" role="alert">
                <button type="button" class="close" data-dismiss="alert"><span>&times;</span></button>
                <strong>${login_msg}</strong>
            </div>
        </form>
    </div>
</div>
</body>
</html>