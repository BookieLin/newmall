<%@ tag language="java" pageEncoding="UTF-8" %>
<!-- 左任务栏 -->
<!-- Left side column. contains the logo and sidebar -->
<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
        <!-- 用户版块开始 -->
        <!-- Sidebar user panel -->
        <div class="user-panel">
            <div class="pull-left image">
                <!-- 头像 -->
                <img src="static/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">
                <!-- 姓名 -->
                <p>${admin.name}</p>
                <!-- 用户状态 -->
                <a id="zaixian" href="#"><i id="attitude" class="${attitude}"></i> ${attitude_name}</a>
            </div>
        </div>
        <!-- 用户版块结束 -->

        <!-- 搜索表单开始 -->
        <!-- search form -->
        <form action="#" method="get" class="sidebar-form">
            <div class="input-group">
                <!-- 搜索框 -->
                <input type="text" name="q" class="form-control" placeholder="Search...">
                <span class="input-group-btn">
                <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
                </button>
              </span>
            </div>
        </form>
        <!-- /.search form -->
        <!-- 搜索表单结束 -->

        <!-- sidebar menu: : style can be found in sidebar.less -->
        <ul class="sidebar-menu" data-widget="tree">
            <!-- 主菜单栏表头 -->
            <li class="header">主菜单</li>

            <!-- 用户管理开始 -->
            <li class="treeview">
                <a href="pages/widgets.html">
                    <i class="fa fa-th"></i> <span>管理员</span>
                    <span class="pull-right-container">
                                <!-- 跟新提示 -->
                              <small class="label pull-right bg-green">new</small>
                        </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="" id="no" class="load" value="admin/toEditor" onclick="showMe(this)"><i class="fa fa-circle-o"></i>添加管理员</a></li>
                    <li><a href="" id="ok" class="load" value="admin/toEditor?id=${admin.id}" onclick="showMe(this)"><i class="fa fa-circle-o"></i>修改个人信息</a></li>
                    <li><a href="" class="load" value="admin/toTable" onclick="showMe(this)"><i class="fa fa-circle-o"></i>管理员列表</a></li>
                </ul>
            </li>
            <!-- 用户管理结束-->

            <!-- 商品分类管理开始 -->
            <li class="treeview">
                <a href="#">
                    <i class="fa fa-pie-chart"></i>
                    <span>用户</span>
                    <span class="pull-right-container">
                              <i class="fa fa-angle-left pull-right"></i>
                        </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="pages/charts/chartjs.html"><i class="fa fa-circle-o"></i> 添加用户</a></li>
                    <li><a href="pages/charts/morris.html"><i class="fa fa-circle-o"></i> 用户信息修改</a></li>
                </ul>
            </li>
            <!-- 商品分类管理结束 -->

        </ul>
    </section>
</aside>
<!-- 左任务栏结束 -->