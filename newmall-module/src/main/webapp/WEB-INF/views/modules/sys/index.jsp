<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sys" tagdir="/WEB-INF/tags/sys" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>商城管理首页</title>
    <jsp:include page="../../../inclueds/header.jsp"/>
    <style>
        .load {
            cursor: pointer;
        }
    </style>

</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <sys:nav/>
    <sys:menu></sys:menu>

    <!-- 主屏幕开始 -->
    <div class="content-wrapper">


        <!-- 主页面开始 -->
        <!-- Main content -->
        <section class="content">
            <!-- 栅格系统开始 -->
            <!-- Small boxes (Stat box) -->
            <div id="content_container" class="row">


                <!-- 1.盒子结束 -->

            </div>

        </section>
        <!-- 主页面结束 -->
    </div>
    <!-- 主屏幕结束 -->


</div>

<jsp:include page="../../../inclueds/footer.jsp"/>
<jsp:include page="../../../inclueds/copyright.jsp"/>

<script>
    $(function () {
        if ("${save}" == "ok") {
            showMe($("#ok"));
        }
        else if ("${save}" == "no") {
            showMe($("#no"));
        }
    });

    function showMe(aa) {
        var path = aa.getAttribute("value");

        if (path == "admin/toTable") {

            $.ajax({
                type: 'post',
                url: 'admin/findAll',
                data:'{}',
                success: function () {
                    $("#content_container").load(path);

                }

            });
        }
        else{
            $("#content_container").load(path);
        }
    }
</script>
</body>

