<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>爬取书籍平台</title>
    <%@include file="common/common.jsp"%>
    <script>
        $(function () {
            $('#wnav li a').bind('click', function() {
                var url = $(this).attr("rel");
                $('#wnav li div').removeClass("selected");
                $(this).parent().addClass("selected");
                
               	// safe-check
               	!history.pushState || history.pushState({} , 
          			"爬取书籍平台 - " + $(this).find("span.nav").text() , 
          			"m/main/" + url.replace(/[\\]+/gi,"/").replace(/[/]+/gi,"-")
             	);
               	
                $("#main_content iframe").attr("src",url);
            });
            
            $("#wnav li a").hover(function() {
                $(this).parent().addClass("hover");
            }, function() {
                $(this).parent().removeClass("hover");
            });
        });
        
        $(function(){
        	var navigator = $("#navigator").val() || "";
        	if (/^[a-zA-Z\-]+$/.test(navigator)) {
        		$('#wnav li a').filter("[rel=" + navigator.replace(/[\-]+/gi , "\\/") + "]").trigger("click");
        	}
        	else {
        		$("#wnav ul").first().find("li").first().find("a").first().trigger("click");
        	}
        })
        
        function logout(){
        	window.top.location.href = 'm/logout'; 
        }
    </script>
</head>
<body class="easyui-layout">
<!--表头begin-->
<div id="header" data-options="region:'north',border:false">
    <div class="fl">
        <a href="javascript:void(0);" class="navbar-brand">
            <small>
                	<img src="images/book.png" style="height:28px;" />
                	爬取书籍平台
            </small>
        </a>
    </div>
    
    <div class="uinfo">您好，<span>${userModel.name }</span>，欢迎您！     
        <img class="nav-user-photo" src="${userModel.image == null or userIcon eq '' ? 'images/avater.png' : userModel.image}" width="36" height="36" alt="Jason's Photo">&nbsp;&nbsp;
        <a href="javascript:void(0);" onclick="logout();">退出</a>
    </div>

</div>
<!--表头end-->
<!--菜单begin-->
<div id="l_menu" data-options="region:'west',split:true" style="width:300px;" title="功能菜单">
    <div id='wnav' class="easyui-accordion" style="overflow:auto;" fit="true" border="false">
        <!--  导航内容 -->
        <!-- 超级管理员 -->
        <input type="hidden" id="navigator" value="${nav}" />
        	<c:if test="${userModel.roleId == 2}">
		       	<!-- 管理员 -->
		        <ul>
		       		<li>
		                <div>
		                    <a href="javascript:void(0);" rel="m/bookInfo/getBookInfoHtml">
		                        <span class="icon icon-nav">&nbsp;</span>
		                        <span class="nav">爬取书籍信息</span>
		                    </a>
		                </div>
		            </li>
		        </ul>
        	</c:if>
	</div>
</div>
<!--菜单end-->

<!-- 内容begin -->
<div id="main_content" data-options="region:'center'">
    <iframe></iframe>
</div>
<!-- 内容end -->

<!--页尾begin-->
<div id="footer" data-options="region:'south',border:false">
    <p>Copyright© 2018 &nbsp;&nbsp;&nbsp;南京理工大学泰州科技学院   &nbsp;&nbsp;14计算机一班&nbsp;王梦梦&nbsp; All Rights Reserved</p>
</div>
<!--页尾end-->
</body>
</html>