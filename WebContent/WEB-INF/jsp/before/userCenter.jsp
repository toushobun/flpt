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
	<table id="table" style="width: 60%; padding-top: 60px; " >
		<tr>
			<th width="200px">考生编号</th>
			<td>${sessionScope.buser.id }</td>
		</tr>
		<tr>
			<th width="200px">手机号</th>
			<td>${sessionScope.buser.uphonenumber }</td>
		</tr>
		<tr>
			<th width="200px">考生姓名</th>
			<td>${sessionScope.buser.uname }</td>
		</tr>
		<tr>
			<th width="200px">是否已报名</th>
			<td>
				<c:if test="${sessionScope.buser.status == 0 }">否，<a href="userCenter/toChooseExaminfo?id=${sessionScope.buser.id}&status=${sessionScope.buser.status}" target="center">立即报名</a></c:if>
				<c:if test="${sessionScope.buser.status == 1 }">是，<a href="userCenter/toChooseExaminfo?id=${sessionScope.buser.id}&status=${sessionScope.buser.status}" target="center">立即查看准考证</a></c:if>
			</td>
		</tr>
		<tr>
			<th width="100px">操作</th>
			<td>
				<a href="userCenter/toUpdateBuser">修改信息</a>
				<a href="userCenter/toUpdatePwd">修改密码</a>
				<a onclick="return checkDel2();" href="userCenter/deleteUser?id=${sessionScope.buser.id }">销毁用户</a>
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