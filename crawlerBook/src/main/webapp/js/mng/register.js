/**
 * 
 */
$(function() {
	$(".sns-weixin").on("click", function() {
		toWXLogin();
	});

	$("#submit").on("click", function() {
		var bootstrapValidator = $("form").data('bootstrapValidator');
		bootstrapValidator.validate();
		if (bootstrapValidator.isValid())
			submit();
		else
			return;

	});

	$('form').bootstrapValidator({
		fields : {
			account : {
				validators : {
					regexp : {
						regexp : /^([A-Za-z0-9]{8,20})$/,
						message : '<i class="fa fa-exclamation-triangle" aria-hidden="true"></i> 请输入6-20位账号，包含字母大写、小写、数字和下划线'
					},
					remote : {
						type : 'POST',
						url : 'w/checkAccount',
						message : '<i class="fa fa-exclamation-triangle" aria-hidden="true"></i> 账号已被注册'
					}
				}
			},
			password : {
				validators : {
					regexp : {
						enabled : true,
						regexp : /^(?![A-Z]+$)(?![a-z]+$)(?!\d+$)(?![\W_]+$)\S{8,16}$/,
						message : '<i class="fa fa-exclamation-triangle" aria-hidden="true"></i> 请输入8-16位密码，包含字母、数字及特殊符号的两种及以上'
					}
				}
			},
			verifyCode : {
				validators : {
					notEmpty : {
						message : '<i class="fa fa-exclamation-triangle" aria-hidden="true"></i> 请输入验证码'
					}
				}
			}
		}
	});
});

function isPhone() {
	var phone = $("#account").val();
	if ((/^1(3|4|5|7|8)\d{9}$/.test(phone))) {
		var html = '<a class="phone-code" href="javascript:void(0);">获取验证码</a>';
		$(".d-v").html(html);
		$("#regtype").val(1);
		$(".phone-code")
				.bind(
						"click",
						function(e) {
							if ((/^1(3|4|5|7|8)\d{9}$/.test(phone))) {
								sendMsg();
							} else {
								var html = '<img id="verifycodeImg" src="verifycode/getRegisterCode.action" style="width: 100px;height: 32px">';
								$(".d-v").html(html);
								$("#regtype").val(2);
							}

						});
	} else {
		if ($(".phone-code").length > 0) {
			var html = '<img id="verifycodeImg" src="verifycode/getRegisterCode.action" style="width: 100px;height: 32px">';
			$(".d-v").html(html);
			$("#regtype").val(2);
		}
	}
}

function sendMsg() {
	var param = {
		mobile : $("#account").val()
	};
	$.ajax({
		url : 'w/sendsms',
		type : 'post',
		cache : false,
		data : param,
		dataType : "JSON",
		success : function(response) {
			if (response.code == 1) {
				countdown_time = 60;
				setInterval(countdown, 1000);
			} else {
				layer.msg(response.message);
			}
		}
	})
}

var countdown_time = 60;
function countdown() {
	var html = '<a class="phone-code disabled" href="javascript:void(0);">重新发送('
			+ countdown_time + ')</a>';
	if (countdown_time <= 0) {
		html = '<a class="phone-code" href="javascript:void(0);">获取验证码</a>';
		$(".d-v").html(html);
		$(".phone-code").bind("click", function(e) {
			sendMsg();
		});
	} else {
		$(".d-v").html(html);
		countdown_time--;
	}
}

function submit() {
	var userParam = {
		account : $.trim($("#account").val()),
		password : $.trim($("#password").val()),
		code : $.trim($("#verifyCode").val()),
		regtype : $.trim($("#regtype").val())
	}
	$.ajax({
		url : 'w/register',
		type : 'post',
		cache : false,
		data : userParam,
		dataType : "JSON",
		success : function(response) {
			changeWebCode();
			$("#password").val('');
			if (response.code == 1) {
				layer.msg("恭喜您注册成功！");
				top.location = 'w/index';
			} else {
				layer.msg(response.message);
			}
		},
		error : function() {
			changeWebCode();
		}
	})
};

function toWXLogin() {
	layer.open({
		type : 2,
		shadeClose : true,
		shade : 0.6,
		area : [ '500px', '420px' ],
		content : 'w/towxlogin'
	});
}

function toLogin() {
	layer.open({
		type : 2,
		shadeClose : true,
		shade : 0.8,
		area : [ '530px', '420px' ],
		content : 'w/tologin'
	});
}

// 处理验证码
function changeWebCode() {
	$("#verifcode").val('');
	$("#verifycodeImg").attr("src", "").attr("src",
			"verifycode/getRegisterCode.action?t=" + new Date().getTime());
};