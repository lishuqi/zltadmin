<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	
    <title>无权访问</title>

    <link rel="shortcut icon"> <link href="<%=basePath %>static/index/css/bootstrap.min.css?v=3.3.5" rel="stylesheet">
    <link href="<%=basePath %>static/index/css/font-awesome.min.css?v=4.4.0" rel="stylesheet">

    <link href="<%=basePath %>static/index/css/animate.min.css" rel="stylesheet">
    <link href="<%=basePath %>static/index/css/style.min.css?v=4.0.0" rel="stylesheet"><base target="_blank">

</head>

<body class="gray-bg">
    <div class="middle-box text-center animated fadeInDown">
    <br/>
           <br/>
        <h2 style="font-size:60px">无权访问</h2>
 <br/> <br/> <br/>	 <br/> <br/> <br/> <br/>
        <div class="error-desc">
           请联系管理员进行授权操作...
           <br/>
            <br/>您可以返回主页看看
            <br/><a href="<%=basePath %>Manage/index.do" class="btn btn-primary m-t">主页</a>
        </div>
    </div>
    <script src="<%=basePath %>static/index/js/jquery.min.js?v=2.1.4"></script>
    <script src="<%=basePath %>static/index/js/bootstrap.min.js?v=3.3.5"></script>
    <script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
</body>

</html>