<%@ tag language="java" pageEncoding="UTF-8" %><!-- 头部开始 -->
<header class="main-header">
    <!-- 商城LOGO -->
    <a href="index.jsp" class="logo">
        <!-- mini logo for sidebar mini 50x50 pixels -->
        <span class="logo-mini"><b>商</b>城</span>
        <!-- logo for regular state and mobile devices -->
        <span class="logo-lg"><b>商城</b></span>
    </a>

    <!-- Header Navbar: style can be found in header.less -->
    <nav class="navbar navbar-static//static-top">
        <!-- Sidebar toggle button-->
        <!-- LOGO边上的小工具图标 -->
        <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
            <span class="sr-only">Toggle navigation</span>
        </a>

        <!-- 邮件和头像 -->
        <div class="navbar-custom-menu">
            <!-- 图标列表 -->
            <ul class="nav navbar-nav">

                <!-- 邮件标签开始 -->
                <li class="dropdown messages-menu">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <i class="fa fa-envelope-o"></i>
                        <!-- 邮件条数 -->
                        <span class="label label-success">4</span>
                    </a>
                    <!-- 邮件下拉框 -->
                    <ul class="dropdown-menu">
                        <!-- 下拉框头部提示 -->
                        <li class="header">You have 4 messages</li>
                        <li>
                            <!-- 邮箱内容展示列表 -->
                            <!-- inner menu: contains the actual data -->
                            <ul class="menu">
                                <!-- start message -->
                                <li>
                                    <a href="#">
                                        <div class="pull-left">
                                            <!-- 图片地址 -->
                                            <img src="static/dist/img/user2-160x160.jpg"
                                                 class="img-circle"
                                                 alt="User Image">
                                        </div>
                                        <h4>
                                            Support Team
                                            <!-- 邮件多久之前发送的 -->
                                            <small><i class="fa fa-clock-o"></i> 5 mins</small>
                                        </h4>
                                        <!-- 邮件描述-->
                                        <p>Why not buy a new awesome theme?</p>
                                    </a>
                                </li>
                                <!-- end message -->


                            </ul>

                        </li>
                        <!-- 下拉框尾部提示 -->
                        <li class="footer"><a href="#">See All Messages</a></li>
                    </ul>
                </li>
                <!-- 邮件标签结束 -->

                <!-- 代办事项标签开始 -->
                <!-- Tasks: style can be found in dropdown.less -->
                <li class="dropdown tasks-menu">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <i class="fa fa-flag-o"></i>
                        <!-- 提醒条数 -->
                        <span class="label label-danger">6</span>
                    </a>
                    <ul class="dropdown-menu">
                        <!-- 下拉框头部提示 -->
                        <li class="header">You have 9 tasks</li>
                        <li>
                            <!-- inner menu: contains the actual data -->
                            <ul class="menu">
                                <li><!-- Task item -->
                                    <a href="#">
                                        <!-- 标题名 -->
                                        <h3>
                                            Design some buttons
                                            <!-- 数字显示进度 -->
                                            <small class="pull-right">80%</small>
                                        </h3>
                                        <div class="progress xs">
                                            <!-- progress-bar-aqua控制颜色 auqa20%  green 40%  red 60% yellow 80% black 100%-->
                                            <!-- style 控制进度条长度 -->
                                            <div class="progress-bar progress-bar-danger" style="width: 80%"
                                                 role="progressbar"
                                                 aria-valuenow="80" aria-valuemin="0" aria-valuemax="100">
                                                <!-- 不知道有啥用-->
                                                <span class="sr-only">80% Complete</span>
                                            </div>
                                        </div>
                                    </a>
                                </li>
                                <!-- end task item -->

                                <li><!-- Task item -->
                                    <a href="#">
                                        <h3>
                                            Make beautiful transitions
                                            <!-- 数字显示进度 -->
                                            <small class="pull-right">40%</small>
                                        </h3>
                                        <div class="progress xs">
                                            <!-- progress-bar-aqua控制颜色 auqa20%  green 40%  red 60% yellow 80% black 100%-->
                                            <!-- style 控制进度条长度 -->
                                            <div class="progress-bar progress-bar-yellow" style="width: 40%"
                                                 role="progressbar"
                                                 aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">
                                                <!-- 不知道有啥用 -->
                                                <span class="sr-only">80% Complete</span>
                                            </div>
                                        </div>
                                    </a>
                                </li>
                                <!-- end task item -->
                            </ul>
                        </li>
                        <li class="footer">
                            <a href="#">View all tasks</a>
                        </li>
                    </ul>
                    <!-- 代办事项结束 -->

                    <!-- 用户标签开始 -->
                    <!-- User Account: style can be found in dropdown.less -->
                <li class="dropdown user user-menu">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <!-- 小图标 -->
                        <img src="static/dist/img/user2-160x160.jpg" class="user-image"
                             alt="User Image">
                        <!--此处显示用户姓名 -->
                        <span class="hidden-xs">${admin.name}</span>
                    </a>

                    <!-- 用户下拉框 -->
                    <ul class="dropdown-menu">
                        <!-- User image -->
                        <li class="user-header">
                            <!-- 大图标 -->
                            <img src="static/dist/img/user2-160x160.jpg" class="img-circle"
                                 alt="User Image">

                            <p>
                                ${admin.name} - 职业
                                <small>Member since 创建日期</small>
                            </p>
                        </li>

                        <!-- Menu Footer-->
                        <li class="user-footer">
                            <!-- 注销按钮 -->
                            <div class="pull-right">
                                <a href="logout"
                                   class="btn btn-default btn-flat">注销</a>
                            </div>
                        </li>
                    </ul>
                </li>
                <!-- 用户标签结束 -->

                </li>
            </ul>
        </div>
    </nav>
</header>
<!-- 头部结束-->

<div class="modal fade" id="modal2">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">温馨提示</h4>
            </div>
            <div class="modal-body">
                <p>您的手速太快了，服务器君忙不过来。</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" data-dismiss="modal">关闭窗口</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>
<!-- /.modal -->