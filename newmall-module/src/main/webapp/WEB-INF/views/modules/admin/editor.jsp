<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<div class="col-xs-12">
    <!-- general form elements -->
    <div class="box box-primary">
        <div class="box-header with-border">
            <h3 class="box-title">${admin.id==null? "添加新用户" : "修改个人信息"}</h3>
        </div>
        <!-- /.box-header -->
        <!-- form start -->

        <form:form action="admin/save" method="post" modelAttribute="admin" class="form-horizontal">
            <form:hidden path="id" value="${admin.id}"/>
            <div class="box-body">

                <div class="form-group">
                    <label path="username" class="col-sm-2 control-label">用户名</label>
                    <div class="col-sm-10">
                        <form:input path="username" class="form-control" placeholder="用户名"/>
                    </div>
                </div>

                <div class="form-group">
                    <label path="password" class="col-sm-2 control-label">密码</label>
                    <div class="col-sm-10">
                        <form:password path="password" class="form-control" placeholder="密码"/>
                    </div>
                </div>

                <div class="form-group">
                    <label path="phone" class="col-sm-2 control-label">手机号</label>
                    <div class="col-sm-10">
                        <form:input path="phone" class="form-control" placeholder="手机号"/>
                    </div>
                </div>

                <div class="form-group">
                    <label path="email" class="col-sm-2 control-label">邮箱</label>
                    <div class="col-sm-10">
                        <form:input path="email" class="form-control" placeholder="邮箱"/>
                    </div>
                </div>

            </div>
            <!-- /.box-body -->

            <div class="box-footer">
                <input id="save" type="button" value="提交" class="btn btn-default pull-right" style="background-color: #3c8dbc;border-color: #367fa9;"/>
            </div>
        </form:form>
    </div>

    <div id="add_success" class="callout callout-success" style="display: none;">
        <p>用户添加成功！！</p>
    </div>
    <div id="update_success" class="callout callout-success" style="display: none;">
        <p>用户更新成功！！</p>
    </div>
</div>


<script>
    var send=1;
    $("#save").click(function () {
        $.ajax({
            type: 'post',
            url: 'admin/save',
            contentType: 'application/json;charset=utf-8',
            beforeSend:function () {
              if(send==0){
                  $("#modal2").modal();
                  return false;
              }
            },
            data: JSON.stringify({
                id: $("#id").val(),
                username: $("#username").val(),
                password: $("#password").val(),
                phone: $("#phone").val(),
                email: $("#email").val()
            }),
            success: function (json) {
                send=0;
                setTimeout("setSend()",5000);
                ajaxConfirm().handleJson("admin",json);
                if (json == "") {

                    $("#update_success").fadeIn({
                        duration: 1000
                    });
                    $("#update_success").delay(3000).fadeOut({
                        duration: 1000
                    });
                } else if (json == "add_success") {
                    $("#add_success").fadeIn({
                        duration: 1000
                    });
                    $("#add_success").delay(3000).fadeOut({
                        duration: 1000
                    });
                }

            },
        });

    });
    function setSend(){
        send=1;
    }

</script>


