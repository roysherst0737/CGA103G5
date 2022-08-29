<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>Register</title>

    <!--用百度的静态资源库的cdn安装bootstrap环境-->
    <!-- Bootstrap 核心 CSS 文件 -->
    <link href="http://apps.bdimg.com/libs/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet">
    <!--font-awesome 核心我CSS 文件-->
    <link href="//cdn.bootcss.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
    <!-- 在bootstrap.min.js 之前引入 -->
    <script src="http://apps.bdimg.com/libs/jquery/2.0.0/jquery.min.js"></script>
    <!-- Bootstrap 核心 JavaScript 文件 -->
    <script src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>


    <!--为了保险起见，导入了本地的jquery和fontawesome    -->
    <!--jquery-->
    <script type="text/javascript" src="js/jquery.validate.min.js" ></script>
    <link rel="stylesheet" href="css/Login.css">
    <!--font-awesome    -->
    <link rel="stylesheet" href="font-awesome-4\7\0\css\font-awesome.min.css">

</head>
<body>
<div class="container">
    <div class="form row">
        <form class="form-horizontal col-sm-offset col-md-offset-3" method="post">
            <h3 class="form-title">注册</h3>
                <div class="col-sm-9 col-md-9">
                    <div class="form-group">
<!--        用户名图标和用户名输入框            -->
                        <i class="fa fa-user" aria-hidden="true"></i>
                        <input class="form-control required" type="text" name="username" id="username" placeholder="请输入用户名" required>
                    </div>

<!--        密码图标和密码输入框                -->
                    <div class="form-group">
                        <i class="fa fa-key" aria-hidden="true"></i>
                        <input class="form-control required" type="password" name="password" id="password" placeholder="请输入密码" required>
                    </div>
<!--          确认密码              -->
                    <div class="form-group">
                        <i class="fa fa-check-circle-o" aria-hidden="true"></i>
                        <input class="form-control required" type="password" name="resetpw" id="resetpw" placeholder="请确认密码" required>
                    </div>
<!--        邮箱                -->
                    <div class="form-group">
                        <i class="fa fa-envelope" aria-hidden="true"></i>
                        <input class="form-control required" type="email" name="email" id="email" placeholder="请输入邮箱" required>
                    </div>

                    <div class="form-group">
                    </div>

<!--注册按钮-->
                    <div class="form-group">
                        <input type="submit" value="注册" class="btn btn-success pull-right">
                        <input type="button" οnclick="javascrtpt:window.location.href='./Login.html'"class="btn btn-info pull-left" id="back_btn" value="返回"/>
                    </div>


                </div>
        </form>
    </div>
</div>
</body>
</html>
