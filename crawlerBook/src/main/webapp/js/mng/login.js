/**
 * 登录页面
 * mike
 * 2017年8月16日
 */
$(function() {
	changeWebCode();
	$(".layui-tab-title li").click(function() {
		$(".layui-tab-title li").removeClass("layui-this");
		$(this).addClass("layui-this");
		$(".layui-tab-content .layui-tab-item").removeClass("layui-show");
		var index = $(this).index();
		if (index == 0) {
			$("#weixinContent").addClass("layui-show");
		} else {
			$("#loginContent").addClass("layui-show");
		}
	});
	
	$("#login_web").keydown(function(e){
		var ev = document.all ? window.event : e;
		if(ev.keyCode==13) {
			var bootstrapValidator = $("#login_web").data('bootstrapValidator');
			   bootstrapValidator.validate();
			   if(bootstrapValidator.isValid())
			     submit();
			   else return;
		}
	});
	
	$("#submit").on("click", function(){
		//验证form表单内容合法性
	   var bootstrapValidator = $("#login_web").data('bootstrapValidator');
	   bootstrapValidator.validate();
	   if(bootstrapValidator.isValid())
	     submit();
	   else return;

	});

	$('#login_web').bootstrapValidator({
		fields : {
			account : {
				validators : {
					notEmpty : {
						message : '请输入登录账号'
					}
				}
			},
			password : {
				validators : {
					notEmpty : {
						message : '请输入登录密码'
					}
				}
			},
			verifyCode : {
				validators : {
					notEmpty : {
						message : '请输入验证码'
					}
				}
			}
		}
	});
});

// 处理验证码
function changeWebCode() {
	$("#verifcode").val('');
	$("#verifycodeImg").attr("src", "").attr("src",
			"verifycode/getVerifyCode.action?t=" + new Date().getTime());
};

function submit() {
	var userParam = {
		account : $.trim($("#account").val()),
		password : $.trim($("#password").val()),
		code : $.trim($("#verifyCode").val())
	}
	$.ajax({
		url : 'w/login',
		type : 'post',
		cache : false,
		data : userParam,
		dataType : "JSON",
		success : function(response) {
			$("#password").val('');
			if(response.code == 1){
				$("#redirection").attr("action", response.url).submit();
			}else{
			//	changeWebCode();
				layer.msg(response.message);
			}
			
		},
		error : function() {
			layer.msg("用户名或者密码错误，请重新输入");
		}
	})
};