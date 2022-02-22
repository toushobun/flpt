<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<title>后台登录</title>
<link href="css/login.css" type="text/css" rel="stylesheet">
<script src="js/buttonAction.js" type="text/javascript"></script>
<script src="js/formCheck.js" type="text/javascript"></script>
<script src="js/postConfirm.js" type="text/javascript"></script>
</head>
<script>
	//登陆判断父页面是否跳转到登录页 
	if (window.top != null && window.top.document.URL != document.URL) {
		window.top.location = document.URL;
	}
</script>
<body>
<body id="mainBody">
	<div class="container">
		<div class="header">
			<h1>管理员登录</h1>
		</div>
		<div class="content">
			<form:form action="admin/login" method="post">
				<table>
					<tr>
						<td>用户名：</td>
						<td><input type="text" name="aname" /></td>
					</tr>
					<tr>
						<td>密&nbsp;&nbsp;&nbsp;码：</td>
						<td><input type="password" name="apwd" /></td>
					<tr>
					</tr>
					<tr>
						<td colspan="2"><span>${msg }</span></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="登录"></td>
					</tr>
				</table>
			</form:form>
		</div>
	</div>
</body>
</html>