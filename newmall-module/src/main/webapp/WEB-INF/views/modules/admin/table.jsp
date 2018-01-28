<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    input {
        border: none;
    }
</style>
<div class="col-xs-12">
    <!-- general form elements -->
    <div class="box box-primary">
        <div class="box-header with-border">
            <h3 class="box-title">管理员列表</h3>
        </div>
        <!-- /.box-header -->
        <!-- table start -->


        <div class="box-body table-responsive no-padding">
            <button id="delSelect" type="button" class="btn btn-danger btn-sm"><i class="fa fa-fw fa-remove"></i>批量删除
            </button>
            <table class="table table-hover">
                <tr>
                    <th><input id="delAll" type="checkbox">全选</th>
                    <th>用户名</th>
                    <th>姓名</th>
                    <th>邮箱</th>
                    <th>电话</th>
                    <th>操作</th>
                </tr>
                <c:forEach items="${list}" var="admin">
                    <tr id="tr${admin.id}">
                        <input id="${admin.id}" type="hidden" value="${admin.id}">
                        <td><input id="check${admin.id}" type="checkbox" class="choice"></td>
                        <td><input id="user${admin.id}" value="${admin.username}"/></td>
                        <td><input id="name${admin.id}" value="${admin.name}"/></td>
                        <td><input id="email${admin.id}" value="${admin.email}"/></td>
                        <td><input id="phone${admin.id}" value="${admin.phone}"/></td>
                        <td>
                            <button id="upd_${admin.id}" type="button" class="btn btn-primary btn-sm"
                                    onclick="updOne(this)"><i class="fa fa-fw fa-edit"></i>编辑
                            </button>
                            <button id="del_${admin.id}" type="button" class="btn btn-danger btn-sm"
                                    onclick="attention(this)"><i class="fa fa-fw fa-remove"></i>删除
                            </button>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div id="del_success" class="callout callout-success" style="display: none;">
            <p>用户删除成功！！</p>
        </div>
        <div id="update_success" class="callout callout-success" style="display: none;">
            <p>用户更新成功！！</p>
        </div>
        <div id="del_error" class="callout callout-danger" style="display: none;">
            <p>用户删除失败，用户信息不存在</p>
        </div>
        <div id="update_error" class="callout callout-danger" style="display: none;">
            <p>用户更新失败，用户信息不存在</p>
        </div>
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
            <div id="msg" class="modal-body">
                <p >确认删除该管理员吗？</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default pull-left" data-dismiss="modal">取消</button>
                <button id="del" name="del_btn" type="button" class="btn btn-primary" data-dismiss="modal"
                        onclick="delOne(this.id)">确认
                </button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>
<!-- /.modal -->


<script>
    var send = 1;
    $("#delAll").click(function () {
        var choice = $(".choice");
        var check = "checked";
        if (!$("#delAll").is(':checked')) {
            check = "";
        }
        for (var i = 0; i < choice.length; i++) {
            if (check != "") {
                choice.eq(i).prop("checked", "" + check);
            }
            else {
                choice.eq(i).prop("checked", "");
            }
        }
    });
    var id = "";
    var str = "";

    $(".choice").click(function () {
        var flag = true;
        if (this.checked == "") {
            $("#delAll").prop("checked", "");
        } else {
            $.each($(".choice"), function (index, value) {
                if (value.checked == "") {
                    $("#delAll").prop("checked", "");
                    flag = false;
                    return;
                }
            })
            if (flag) {
                $("#delAll").prop("checked", "checked");
            }
        }
    });

    function updOne(obj) {
        str = obj.id.split("_")[1] + "";
        id = $("#" + str).val();
        makeDiff(id, "update");
    }

    function delOne(obj) {
        makeDiff(obj, "del");
    }

    function attention(obj) {
        str = obj.id.split("_")[1] + "";
        id = $("#" + str).val();
        $(':button[name="del_btn"]').attr("id", id);
        $("#msg").attr("html","确认删除 id:"+obj);
        $("#modal").modal();
    }

    function makeDiff(param, method) {
        $.ajax({
            type: 'post',
            url: "admin/" + method,
            contentType: 'application/json;charset=utf-8',
            beforeSend: function () {
                if (send == 0) {
                    $("#modal2").modal();
                    return false;
                }
            },
            data: JSON.stringify({
                id: param,
                username: $("#user" + param).val(),
                name: $("#name" + param).val(),
                email: $("#email" + param).val(),
                phone: $("#phone" + param).val()
            }),
            success: function (data) {
                if (send == 1 && method == "del") {
                    $("#tr" + str).delay(1000).fadeOut({
                        duration:1000
                    });
                }
                send = 0;
                setTimeout("setSend()", 5000);
                if (data == "1") {
                    $("#" + method + "_success").fadeIn({
                        duration: 1000
                    });
                    $("#" + method + "_success").delay(3000).fadeOut({
                        duration: 1000
                    });
                } else {
                    $("#" + method + "_error").fadeIn({
                        duration: 1000
                    });
                    $("#" + method + "_error").delay(3000).fadeOut({
                        duration: 1000
                    });
                }
            },
        });
    }

    function setSend() {
        send = 1;
    }

    $("#delSelect").click(function () {
        $.each($(".choice"), function (index, value) {
            if (value.checked) {
                id=value.id.split("check")[1];
                delOne(id);
                $("#tr"+id).delay(1000).fadeOut({
                    duration:1000
                });
                send=1;
            }
        });
    });
</script>
