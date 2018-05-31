<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>爬取书籍平台登录</title>
<link rel="stylesheet" type="text/css" href="plugins/adminlte/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="plugins/adminlte/css/AdminLTE.min.css"/>
<script type="text/javascript" src="js/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="plugins/easyui/css/easyui.css"/>
<script type="text/javascript" src="plugins/easyui/js/jquery.easyui.min.js"></script>
<script type="text/javascript">
	if (window != window.parent) {
		window.parent.location.href = "m/index";
	};
 	$(function(){
		document.onkeydown = function(e){ 
			var ev = document.all ? window.event : e;
			if(ev.keyCode==13) {
				login();
			}
		};
	});
 	function login(){
 		if(!$("#account").val()){
 			$("#showMsg").text("用户名不能为空").fadeIn().fadeOut(5000);
 			return;
 		}else if(!$("#password").val()){
 			$("#showMsg").text("密码不能为空").fadeIn().fadeOut(5000);
 			return;
 		}
 		jQuery.ajax({
    	type : "post" , 
    	url : "m/login", 
    	dataType : "json" , 
    	data : $("#loginForm").serialize(),
    	success : function(obj) {
    		if(obj.data.code==1){
    			if($("#redirect").val()){
    				window.location.href = $("#redirect").val();
    			}else{
    				window.location.href = "m/main";
    			}
    		}else{
    			$("#showMsg").text("用户名或密码错误").fadeIn().fadeOut(5000);
    		}
    	}
    });
 	}
 	
 	//注册
 	function register(){
 		$("#win").window('open');
 	}
 </script>
 <style type="text/css">
 	.login-box, .register-box{
 		margin: 14% auto;
 	}
 	.form-group{
 		margin-bottom: 20px;
 	}
</style>
</head>
<body class="hold-transition login-page" style="overflow-y:hidden;background: #3c3b4d;background-repeat:repeat;">
	<div class="login-box">
		<div class="login-box-body">
			<p class="login-box-msg">爬取书籍平台登录</p>
			<div style="height: 30px;padding-bottom: 15px;text-align: center;color: red;" id="showMsg"></div>

			<form id="loginForm" action="" method="post">
				<div class="form-group has-feedback">
					<input type="text" class="form-control" name="account" id="account" value="admin"
						placeholder="用户名" /> <span class="glyphicon glyphicon-user form-control-feedback"></span>
				</div>
				<div class="form-group has-feedback">
					<input type="password" class="form-control" name="password" id="password" value="admin123"
						placeholder="密码"> <span class="glyphicon glyphicon-lock form-control-feedback"></span>
				</div>
				<div class="row">
					<div class="col-sm-offset-4 col-sm-4">
						<input type="hidden" name="redirect" id="redirect" value='<c:out value="${redirect}"></c:out>' />
					<!-- 	<button type="button" class="btn btn-primary btn-block btn-flat" onclick="register();" style="margin-left: -76px;    margin-bottom: -39px;">注册</button> -->
          				<button type="button" class="btn btn-primary btn-block btn-flat" onclick="login();" style="margin-left: 2px;">登录</button>
          				
					</div>
				</div>
			</form>
		</div>
	</div>
	
	<!-- 注册信息 -->
	<div id="win" class="easyui-window" title="用户注册" style="width:600px;height:235px"
	    data-options="iconCls:'icon-save',modal:true,closed:true">
	   <form id="register_web" class="form-horizontal" data-toggle="validator" role="form" style="width: 286px;margin-left: 85px; margin-top: 3px;">
				<div class="form-group">
					用户名：<input type="text" class="form-control" placeholder="请输入账号/手机号" onblur="isPhone()" value="admin"/>
				</div>
				<div class="form-group">
					用户密码：<input type="password" class="form-control" id="password" name="password" placeholder="请输入密码" value="admin123"/>
				</div>
				<div class="form-group" style="margin-top: 20px">
					<a id="submit" href="javascript:void(0);" class="btn btn-default">免费注册</a>
					
				</div>
				<input type="hidden" id="regtype" name="regtype" value="2" />
			</form>
	</div>
	
	
	<script src="js/mng/register.js"></script>
</body>
</html>
