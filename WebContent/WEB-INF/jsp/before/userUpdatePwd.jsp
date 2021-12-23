<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<title>Insert title here</title>
<script src="js/formCheck.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="css/before.css">
</head>
<body>
	<form:form action="userCenter/updatePwd" method="post" modelAttribute="buser">
		<table>
			<caption>修改密码</caption>
			<form:hidden path="user_id" value="${sessionScope.buser.user_id}"/>
			<tr>
				<td>原密码<font color="red">*</font></td>
				<td><input type="password" name="upwd"/></td>
			</tr>
			<tr>
				<td>新密码<font color="red">*</font></td>
				<td><input type="password" /></td>
			</tr>
			<tr>
				<td>再次输入密码<font color="red">*</font></td>
				<td><input type="password" name="newUpwd" /></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td style="text-align: right">
					<input type="submit" value="提交"/>
				</td>
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