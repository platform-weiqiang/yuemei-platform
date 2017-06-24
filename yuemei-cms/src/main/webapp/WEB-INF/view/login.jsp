<!doctype html>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html lang="en" class="fixed accounts sign-in">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <title>悦美管理系统</title>
    <link rel="apple-touch-icon" sizes="120x120" href="favicon/apple-icon-120x120.png">
    <link rel="icon" type="image/png" sizes="192x192" href="../../static/favicon/android-icon-192x192.png">
    <link rel="icon" type="image/png" sizes="32x32" href="../../static/favicon/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="16x16" href="../../static/favicon/favicon-16x16.png">
    <link rel="stylesheet" type="text/css" href="http://apps.bdimg.com/libs/bootstrap/3.3.4/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="http://cdn.bootcss.com/font-awesome/4.6.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="../../static/vendor/animate.css/animate.css">
    <link rel="stylesheet" href="../../static/stylesheets/css/style.css">
</head>
<body>
<div class="wrap">
    <div class="page-body animated slideInDown">
        <div class="logo">
            <img alt="logo" src="../../static/images/logo-dark.png" />
        </div>
        <div class="box">
            <div class="panel mb-none">
                <div class="panel-content bg-scale-0">
                    <form>
                        <div class="form-group mt-md">
                            <span class="input-with-icon">
                                    <input type="email" class="form-control" id="email" placeholder="Email">
                                    <i class="fa fa-envelope"></i>
                            </span>
                        </div>
                        <div class="form-group">
                                <span class="input-with-icon">
                                        <input type="password" class="form-control" id="password" placeholder="Password">
                                        <i class="fa fa-key"></i>
                                    </span>
                        </div>
                        <div class="form-group">
                            <div class="checkbox-custom checkbox-primary">
                                <input type="checkbox" id="remember-me" value="option1" checked>
                                <label for="remember-me">记住我</label>
                            </div>
                        </div>
                        <div class="form-group">
                            <a href="index.html" class="btn btn-primary btn-block">登陆</a>
                        </div>
                        <div class="form-group text-center">
                            <a href="pages_forgot-password.html">忘记密码</a>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
<script src="../../static/vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="../../static/vendor/nano-scroller/nano-scroller.js"></script>
<script src="../../static/javascripts/template-script.min.js"></script>
<script src="../../static/javascripts/template-init.min.js"></script>
</body>

</html>
