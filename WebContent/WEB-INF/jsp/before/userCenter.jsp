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
<link href="css/before.css" rel="stylesheet" type="text/css">
</head>
<body>
	<table>
		<tr>
			<td>${sessionScope.buser.uidphoto }</td>
		</tr>
		<tr>
			<th>考生姓名</th>
			<td>${sessionScope.buser.uname }</td>
		</tr>
		<tr>
			<th>身份证号</th>
			<td>${sessionScope.buser.uidnum }</td>
		</tr>
		<tr>
			<th>操作</th>
			<td>
				<a href="userReginfo/userSelectReginfo?user_id=${sessionScope.buser.user_id }">查看全部报名信息</a>
				<c:if test="${sessionScope.buser.uidphoto == null }">
					<a href="userCenter/toUpdatePwd">上传照片</a>
				</c:if>
				<c:if test="${sessionScope.buser.uidphoto != null }">
					<a href="userCenter/toUpdatePwd">修改照片</a>
				</c:if>
				<a href="userCenter/toUpdatePwd">修改密码</a>
				<a onclick="return checkDelDouble();" href="userCenter/deleteUser?id=${sessionScope.buser.user_id }">销毁用户</a>
			</td>
		</tr>
	</table>
	<c:if test="${msg != null }">
		<script type="text/javascript">
			alert("${msg}");
		</script>
	</c:if>
</body>
</html>