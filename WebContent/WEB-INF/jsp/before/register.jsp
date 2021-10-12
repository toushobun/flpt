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
<title>Insert title here</title>
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
	<h1>考生注册</h1>
	<form:form action="register" onsubmit="return doInputBuser();" method="post" modelAttribute="buser">
		<p>身份证号码<font color="red">*</font><form:input path="uidnum" /></p>
		<p>考生姓名<font color="red">*</font><form:input path="uname" /></p>
		<p>密码<font color="red">*</font><input type="password" name="upwd" id="upwd" /></p>
		<p>再次输入密码<font color="red">*</font><input type="password" id="upwd2"/></p>
		<p>验证码：<input type="text" name="code"/></p>
		<p><img id="code" src="validateCode"/><a href="javascript:refreshCode();"><font color="blue">看不清，换一个</font></a></p>
		<p><label>${msg }</label></p>
		<p>上传照片<font color="red">*</font><form:input path=""/></p>
		<p class="msg"><label>${msg }</label></p>
		<p class="submit"><input type="submit" value="注册账号" /></p>
	</form:form>
</body>
</html>