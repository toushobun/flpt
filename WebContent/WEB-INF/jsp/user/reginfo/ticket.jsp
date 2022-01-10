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
</head>
<body id="ticket">
    <table border="1" style="border-collapse:collapse">
        <caption>${reginfo.tname }准考证</caption>
        <tr>
            <th>准考证号</th>
			<td>${reginfo.ticketnum }</td>
            <td rowspan="4"><img width="120px" height="180px" src="logos/${sessionScope.user.uidphoto}" /></td>
		</tr>
		<tr>
            <th>考生姓名</th>
			<td>${sessionScope.user.uname }</td>
		</tr>
		<tr>
            <th>证件号码</th>
			<td>${sessionScope.user.uidnum }</td>
		</tr>
		<tr>
            <th>考点名称</th>
			<td>${reginfo.rname }</td>
		</tr>
		<tr>
            <th>考场地址</th>
			<td colspan="2">${reginfo.raddress }</td>
		</tr>
		<tr>
			<td>考试时间</td>
			<td colspan="2">${reginfo.test_time }</td>
		</tr>
	</table>
	<c:if test="${msg != null }">
		<script type="text/javascript">
			alert("${msg}");
		</script>
	</c:if>
</body>
</html>