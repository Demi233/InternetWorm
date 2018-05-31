<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<script type="text/javascript" src="plugins/jquery/jquery.min.js"></script>
	<title>织巢信息管理平台</title>
	<script type="text/javascript">
		function afterLoad(msg){
			var redirection = document.getElementById("redirect")
			var redirect = redirection ? (redirection.value || "").replace(/\s+/gi , "") : "";
			
			if(msg!=''&&msg!=null){
				alert(msg);
			}
			
			var authPage = document.getElementById("authPage");
			if (redirect && authPage) {
				authPage.submit();
			}
			else {
				window.top.location='m/index';
			}
		};
	</script>
	</head>
	<body onload="afterLoad('${msg}');">
		<form id="authPage" action="m/index" method="post">
			<input type="hidden" id="redirect" name="redirect" value='<c:out value="${redirect}"></c:out>' />
		</form>
	</body>
</html>
