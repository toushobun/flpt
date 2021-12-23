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
</head>
<body>
	<h1>登录到后台管理界面</h1>
	<form:form action="admin/login" method="post">
		<p>
			姓名：<input type="text" name="aname" />
		</p>
		<p>
			密码：<input type="password" name="apwd" />
		</p>
		<p>
			<label>${msg }</label>
		</p>
		<p>
			<input type="submit" value="登录">
		</p>
	</form:form>
</body>
</html>