<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>

<head>
	<base href="<%=basePath%>">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>LJY</title>
    <link rel="shortcut icon" href="<%=basePath %>static/index/favicon.ico">
    <link href="<%=basePath %>static/index/css/bootstrap.min.css?v=3.3.5" rel="stylesheet">
     <link href="<%=basePath %>static/index/css/bootstrap.css?v=3.3.5" rel="stylesheet">
    <link href="<%=basePath %>static/index/css/font-awesome.min.css?v=4.4.0" rel="stylesheet">
    <link href="<%=basePath %>static/index/css/animate.min.css" rel="stylesheet">
    <link href="<%=basePath %>static/index/css/style.min.css?v=4.0.0" rel="stylesheet">
    <!--[if lte IE 9]>
    <script src="http://apps.bdimg.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <script src="http://apps.bdimg.com/libs/html5shiv/3.7/html5shiv.min.js"></script>
	<![endif]-->
    <script src="<%=basePath %>static/index/js/jquery.min.js?v=2.1.4"></script>
    <script src="<%=basePath %>static/index/js/bootstrap.min.js?v=3.3.5"></script>
    <script src="<%=basePath %>static/index/js/plugins/metisMenu/jquery.metisMenu.js"></script>
    <script src="<%=basePath %>static/index/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
    <script src="<%=basePath %>static/index/js/plugins/layer/layer.min.js"></script>
    <script src="<%=basePath %>static/index/js/hplus.min.js?v=4.0.0"></script>
    <script type="text/javascript" src="<%=basePath %>static/index/js/contabs.min.js"></script>
    <script src="<%=basePath %>static/index/js/plugins/pace/pace.min.js"></script>
</head>

<body class="fixed-sidebar full-height-layout gray-bg" style="overflow:hidden;height:100%">
    <div id="wrapper">
        <!--左侧导航开始-->
        <nav class="navbar-default navbar-static-side" role="navigation">
            <div class="nav-close"><i class="fa fa-times-circle"></i>
            </div>
            <div class="sidebar-collapse">
                <ul class="nav" id="side-menu">
                    <li class="nav-header">
                        <div class="dropdown profile-element">
                            <span><img alt="image" class="img-circle" src="img/supermanage.jpg" /></span>
                            <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                                <span class="clear">
                               <span class="block m-t-xs"><strong class="font-bold">Beaut-zihan</strong></span>
                                <span class="text-muted text-xs block">超级管理员<b class="caret"></b></span>
                                </span>
                            </a>
                            <ul class="dropdown-menu animated fadeInRight m-t-xs">
                                <li><a class="J_menuItem" href="form_avatar.html">修改头像</a>
                                </li>
                                <li><a class="J_menuItem" href="profile.html">个人资料</a>
                                </li>
                                <li><a class="J_menuItem" href="contacts.html">联系我们</a>
                                </li>
                                <li><a class="J_menuItem" href="mailbox.html">信箱</a>
                                </li>
                                <li class="divider"></li>
                                <li><a href="<%=basePath %>Manage/User/logout.do">安全退出</a>
                                </li>
                            </ul>
                        </div>
                        <div class="logo-element">
                        </div>
                    </li>
                    <li>
                        <a class="J_menuItem" href="layouts.html"><i class="fa fa-home"></i> <span class="nav-label">主页</span></a>
                    </li>
                    <li>
                         <a  href="#">
                         	<i class="fa fa-columns"></i> 
                         	<span class="nav-label">权限管理</span>
                         	<span class="fa arrow"></span>
                         </a>
                        <ul class="nav nav-second-level">
                       		<!-- 给其分配角色 -->
                         	<li>
                                <a class="J_menuItem" href="<%=basePath %>Manage/User/index.do?date="+new Date()>用户管理</a>
                            </li>
                            <!-- 给其分配权限 -->
                            <li>
                                <a class="J_menuItem" href="<%=basePath %>Manage/Role/index.do?date="+new Date()>角色管理</a>
                            </li>
                            <!-- 分类管理所有的权限 -->
                            <li>
                                <a class="J_menuItem" href="<%=basePath %>Manage/Permission/index.do?date="+new Date()>权限管理</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#">
                            <i class="fa fa fa-bar-chart-o"></i>
                            <span class="nav-label">数据字典</span>
                            <span class="fa arrow"></span>
                        </a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a class="J_menuItem" href="<%=basePath %>Manage/Dictionary/index.do?date="+new Date()>基础数据字典</a>
                            </li>
                        </ul>
                    </li>
                    <!-- 根据实际业务进行封装 -->
					<li>
                        <a href="#"><i class="fa fa-table"></i> <span class="nav-label">日志管理</span><span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li><a class="J_menuItem" href="<%=basePath %>Manage/Log/system.do?date="+new Date()>系统日志</a>
                            </li>
                            <li><a class="J_menuItem" href="<%=basePath %>Manage/Log/error.do?date="+new Date()>异常日志</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="<%=basePath %>druid/weburi.html"><i class="fa fa-cutlery"></i> <span class="nav-label">性能监控 </span><span class="fa arrow"></span></a>
                    </li>

                </ul>
            </div>
        </nav>
        <!--左侧导航结束-->
        <!--右侧部分开始-->
        <div id="page-wrapper" class="gray-bg dashbard-1">
            <div class="row border-bottom">
            </div>
            <div class="row content-tabs">
                <nav class="page-tabs J_menuTabs">
                    <div class="page-tabs-content">
                        <a href="javascript:;" class="active J_menuTab" data-id="index_v1.html">首页</a>
                    </div>
                </nav>
                <div class="btn-group roll-nav roll-right">
                    <button class="dropdown J_tabClose" data-toggle="dropdown">关闭操作<span class="caret"></span>
                    </button>
                    <ul role="menu" class="dropdown-menu dropdown-menu-right">
                        <li class="divider"></li>
                        <li class="J_tabCloseAll"><a>关闭全部选项卡</a>
                        </li>
                        <li class="J_tabCloseOther"><a>关闭其他选项卡</a>
                        </li>
                    </ul>
                </div>
                <a href="login.html" class="roll-nav roll-right J_tabExit"><i class="fa fa fa-sign-out"></i> 退出</a>
            </div>
            <div class="row J_mainContent" id="content-main" style="height:100%">
                <iframe class="J_iframe" width="100%" height="150%" src="layouts.html"></iframe>
            </div>
        </div>
        <!--右侧部分结束-->
    </div>
    
</body>

</html>