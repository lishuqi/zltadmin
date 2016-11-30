
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Login</title>
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<meta name="keywords" content="Flat Dark Web Login Form Responsive Templates, Iphone Widget Template, Smartphone login forms,Login form, Widget Template, Responsive Templates, a Ipad 404 Templates, Flat Responsive Templates" />
<link href="<%=basePath %>static/login/css/style.css" rel='stylesheet' type='text/css' />
<script src="<%=basePath %>static/jquery/jquery-1.9.1.js"></script>
</head>
<body>
<script>
$(function(){
	$('.close').on('click', function(c){
		$('.login-form').fadeOut('slow', function(c){
	  		$('.login-form').remove();
		});
	});	
});
	  
</script>
 <!--SIGN UP-->
 <h1>klasikal Login Form</h1>
<div class="login-form">
	<div class="close"> </div>
		<div class="head-info">
			<label class="lbl-1"> </label>
			<label class="lbl-2"> </label>
			<label class="lbl-3"> </label>
		</div>
			<div class="clear"> </div>
	<div class="avtar">
		<img src="<%=basePath %>static/login/images/avtar.png" />
	</div>
			<form method="post" id="loginform">
					<input type="text" class="text" name="username" value="" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '';}" >
						<div class="key">
					<input type="password" name = "password" value="" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '';}">
						</div>
			</form>
	<div class="signin">
		<input type="submit"value="Login" onclick="loginsubmit()" >
	</div>
</div>
<div class="copy-rights">
	<p>ljy &copy; 2016.10.19</p>
</div>
<script>
///登录提示方法
function loginsubmit() {
	$("#loginform").submit();
}
</script>

</body>
</html>