<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<title>考生登录</title>
<script src="js/formCheck.js" type="text/javascript"></script>
</head>
<script type="text/javascript">
	if(window.top.location.href!=location.href)    
	{       
	    window.top.location.href=location.href;    
	}
	function refreshCode(){
		document.getElementById("code").src = "validateCode?" + Math.random();
	}
</script>
<body>
	<h1>考生登录</h1>
	<form:form action="before/login" modelAttribute="buser" method="post">
		<p>证件号：<form:input path="uidnum"/></p>
		<p>密码：<input type="password" name="upwd"/></p>
		<p>验证码：<input type="text" name="code"/></p>
		<p><img id="code" src="validateCode"/><a href="javascript:refreshCode();"><font color="blue">看不清，换一个</font></a></p>
		<p><label>${msg }</label></p>
		<p><input type="submit" value="登录" ></p>
	</form:form>
</body>
</html>