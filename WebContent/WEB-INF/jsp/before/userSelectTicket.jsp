<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
</head>
<body>
	<table border=3px>
		<tr>
			<td>考生编号</td>
			<td>${reginfo.ticketnum }</td>
		<tr>
			<td>考生姓名</td>
			<td>${sessionScope.buser.uname }</td>
		<tr>
			<td>证件号码</td>
			<td>${sessionScope.buser.uidnum }</td>
		<tr>
			<td>考试名称</td>
			<td>${reginfo.tname }</td>
		<tr>
			<td>考试时间</td>
			<td>${reginfo.test_time }</td>
		<tr>
			<td>考点名称</td>
			<td>${reginfo.rname }</td>
		<tr>
			<td>详细地址</td>
			<td>${reginfo.raddress }</td>
		</tr>
		<tr>
	</table>
	<c:if test="${msg != null }">
		<script type="text/javascript">
			alert("${msg}");
		</script>
	</c:if>
</body>
</html>