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
<title>考生登录</title>
<link href="css/user.css" type="text/css" rel="stylesheet">
<script src="js/buttonAction.js" type="text/javascript"></script>
<script src="js/formCheck.js" type="text/javascript"></script>
<script src="js/postConfirm.js" type="text/javascript"></script>
</head>
<script type="text/javascript">
	if (window.top.location.href != location.href) {
		window.top.location.href = location.href;
	}
</script>
<body>
	<h1>考生登录</h1>
	<form:form action="user/login" modelAttribute="user" method="post">
		<table>
			<tr>
				<td>证件号：</td>
				<td><form:input path="uidnum" /></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type="password" name="upwd" /></td>
			</tr>
			<tr>
				<td>验证码：</td>
				<td><input type="text" name="code" /></td>
			</tr>
			<tr>
				<td><img id="code" src="validateCode" /></td>
				<td><a href="javascript:refreshCode();"><font color="blue">看不清，换一个</font></a>
				</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td><input type="submit" value="登录"></td>
			</tr>
		</table>
	</form:form>
	<c:if test="${msg != null }">
		<script type="text/javascript">
			alert("${msg}");
		</script>
	</c:if>
</body>
</html>