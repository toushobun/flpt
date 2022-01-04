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
<title>Insert title here</title>
<link href="css/user.css" type="text/css" rel="stylesheet">
<script src="js/buttonAction.js" type="text/javascript"></script>
<script src="js/formCheck.js" type="text/javascript"></script>
<script src="js/postConfirm.js" type="text/javascript"></script>
<script src="js/colorControl.js" type="text/javascript"></script>
</head>
<body>
	<table id="table">
		<tr>
			<td><img alt="" width="250" height="250"
				src="logos/${sessionScope.user.uidphoto}" /></td>
		</tr>
		<tr>
			<td>准考证号</td>
			<td>${reginfo.ticketnum }</td>
		</tr>
		<tr>
			<td>考生姓名</td>
			<td>${sessionScope.user.uname }</td>
		</tr>
		<tr>
			<td>证件号码</td>
			<td>${sessionScope.user.uidnum }</td>
		</tr>
		<tr>
			<td>考试名称</td>
			<td>${reginfo.tname }</td>
		</tr>
		<tr>
			<td>考试时间</td>
			<td>${reginfo.test_time }</td>
		</tr>
		<tr>
			<td>考点名称</td>
			<td>${reginfo.rname }</td>
		</tr>
		<tr>
			<td>详细地址</td>
			<td>${reginfo.raddress }</td>
		</tr>
	</table>
	<c:if test="${msg != null }">
		<script type="text/javascript">
			alert("${msg}");
		</script>
	</c:if>
</body>
</html>