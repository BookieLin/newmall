<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<!-- head begin -->
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <title>移动商城管理 - 登录</title>

    <jsp:include page="/WEB-INF/inclueds/header.jsp"/>
</head>
<!-- ./head end -->

<body class="hold-transition login-page">
<div class="login-box">
    <div class="login-logo">
        <a href="login.jsp"><b>移动商城管理</b></a>
    </div>

    <div class="login-box-body">
        <p class="login-box-msg">欢迎使用商城管理</p>

        <c:if test="${message != null}">
            <div class="alert alert-danger alert-dismissible">
                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                ${message}
            </div>
        </c:if>

        <form action="/login" method="post">
            <div class="form-group has-feedback">
                <input id="loginId" name="loginId" type="text" class="form-control" placeholder="用户名" value="${dto.loginId}">
                <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
            </div>

            <div class="form-group has-feedback">
                <input id="loginPwd" name="loginPwd" type="password" class="form-control" placeholder="密码" value="${dto.loginPwd}">
                <span class="glyphicon glyphicon-lock form-control-feedback"></span>
            </div>

            <div class="form-group">
                <input id="validateCode" name="validateCode" type="text" class="form-control pull-left" placeholder="验证码" style="width: 170px;">
                <img id="imgValidateCode" src="/validate/code" style="cursor: pointer;" />
            </div>

            <div class="row">
                <div class="col-xs-8">
                    <div class="checkbox icheck">
                        <label>
                            <input id="isRemember" name="isRemember" type="checkbox" ${"on" eq dto.isRemember ? "checked" : ""}> 记住我
                        </label>
                    </div>
                </div>
                <!-- /.col -->
                <div class="col-xs-4">
                    <button id="btnLogin" type="submit" class="btn btn-primary btn-block btn-flat">登录</button>
                    <a href="../../../../static/wx.html" type="button" class="btn btn-primary btn-block btn-flat">微信扫一扫</a>
                </div>
                <!-- /.col -->
            </div>
        </form>

        <a href="#">忘记密码？</a>
    </div>
</div>

<div class="modal fade" id="modal">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">温馨提示</h4>
            </div>
            <div class="modal-body">
                <p>用户名或密码不能为空，请重新输入</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">知道了</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>
<!-- /.modal -->

<jsp:include page="/WEB-INF/inclueds/footer.jsp"/>
<script>
    $(function () {
        $('input').iCheck({
            checkboxClass: 'icheckbox_square-blue',
            radioClass: 'iradio_square-blue',
            increaseArea: '20%' // optional
        });

        // 绑定事件
        bindEvent();
    });

    // 绑定事件
    function bindEvent() {
        // 绑定登录按钮的点击事件
        $("#btnLogin").bind("click", function () {
            return checkLogin();
        });

        $("#imgValidateCode").bind("click",function(){
            $("#imgValidateCode").attr("src","/validate/code?"+Math.random())
        })
    }

    // 检查登录
    function checkLogin() {
        var email = $("#loginId").val();
        var password = $("#loginPwd").val();

        if (email.length == 0 || password.length == 0) {
            $('#modal').modal("show");
            return false;
        }
    }
</script>
</body>
</html>