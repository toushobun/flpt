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
<title>考生注册</title>
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
<body id="mainBody">
	<div class="container">
		<div class="header">
			<h1>考生注册</h1>
		</div>
		<div class="content">
			<form:form action="user/register" method="post"
				onsubmit="return checkUser(this);" modelAttribute="user"
				enctype="multipart/form-data">
				<table>
					<tr>
						<td>证件号</td>
						<td colspan="2"><form:input path="uidnum" /></td>
					</tr>
					<tr>
						<td>姓&nbsp;&nbsp;&nbsp;名</td>
						<td colspan="2"><form:input path="uname" /></td>
					</tr>
					<tr>
						<td>密&nbsp;&nbsp;&nbsp;码</td>
						<td colspan="2"><input type="password" name="upwd" id="upwd" /></td>
					</tr>
					<tr>
						<td>确认密码</td>
						<td colspan="2"><input type="password" id="upwd2" /></td>
					</tr>
					<tr>
						<td>上传照片</td>
						<td colspan="2"><input type="file" name="logoImage" /></td>
					</tr>
					<tr>
						<td>验证码：</td>
						<td><input type="text" name="code" /></td>
						<td><a href="javascript:refreshCode();"><img id="code"
								src="validateCode" /></a></td>
					</tr>
					<tr>
                        <td colspan="2" >&nbsp;&nbsp;&nbsp;${msg }</td>
						<td align="right"><input type="submit" value="注册账号" /></td>
					</tr>
				</table>
			</form:form>
		</div>
	</div>
</body>

</html>