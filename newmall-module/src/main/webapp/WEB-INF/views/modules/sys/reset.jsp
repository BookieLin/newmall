<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>找回帐号</title>
    <jsp:include page="../../../inclueds/header.jsp"/>
    <style type="text/css">
        #attention {
            display: none;
        }
    </style>
</head>
<body class="hold-transition login-page">
<div class="login-box">
    <div class="login-logo">
        <a href="login.jsp"><b>商城</b>管理</a>
    </div>
    <!-- /.sendMessage-logo -->
    <div class="login-box-body">
        <p class="login-box-msg">欢迎使用商城管理系统</p>

        <div id="attention" class="alert alert-danger alert-dismissible">
            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
            ${message}
        </div>
        <!-- 表单提交-->

        <form id="form1" action="reset" method="post">
            <input type="hidden" name="method" value="reset">
            <div class="form-group has-feedback">
                <input id="username" name="username" type="text" class="form-control" placeholder="帐号">
                <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
            </div>

            <div class="row">

                <!-- /.col -->
                <div class="col-xs-4">
                    <!-- 提交按钮-->
                    <button type="button" onclick="sendMessage()" class="btn btn-primary btn-block btn-flat">验证邮箱</button>
                </div>
                <!-- /.col -->

            </div>
        </form>


        <div class="modal fade" id="modal">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title">温馨提示</h4>
                    </div>
                    <div class="modal-body">
                        <p>帐号不存在</p>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-primary" data-dismiss="modal">确认</button>

                    </div>
                </div>
                <!-- /.modal-content -->
            </div>
            <!-- /.modal-dialog -->
        </div>
        <!-- /.modal -->

    </div>
    <!-- /.sendMessage-box-body -->
</div>
<!-- /.sendMessage-box -->

<jsp:include page="../../../inclueds/footer.jsp"/>
<script>
    $(function () {
        $('input').iCheck({
            checkboxClass: 'icheckbox_square-blue',
            radioClass: 'iradio_square-blue',
            increaseArea: '20%' // optional
        });

        if (${message!=null}) {
            $("#attention").css("display", "block");
        } else {
            $("#attention").css("display", "none");
        }
    });

    function sendMessage() {

        if ($("#username").val().match("[a-zA-Z][a-zA-Z0-9]{5,15}") != null) {

            $("#form1").submit();
        }else{

            $('#modal').modal("show");
        }

    }
</script>
</body>
</html>
