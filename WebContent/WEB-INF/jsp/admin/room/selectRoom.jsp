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
<link href="css/admin.css" type="text/css" rel="stylesheet">
<script src="js/formCheck.js" type="text/javascript"></script>
</head>
<body>
	<form:form id="searchForm" action="adminRoom/searchRoom" method="post"
		modelAttribute="room">
		<form:input path="rname" placeholder="输入考试名" value="${room.rname }" />
		<form:input path="raddress" placeholder="输入考试地址"
			value="${room.raddress }" />
		<form:input path="rtelnum" placeholder="联系电话"
			value="${room.rtelnum }" />
		<form:input path="rpostcode" placeholder="邮编"
			value="${room.rpostcode }" />
		<input type="submit" value="搜索" />
		<input type="button" value="清空" onclick="emptyInput('searchForm');" />
	</form:form>
	<c:if test="${roomList.size() == 0 }">
		未查询到结果
	</c:if>
	<c:if test="${roomList.size() != 0 }">
		<table border=1>
			<tr>
				<th style="display: none;">ID</th>
				<th width="25%">考场名</th>
				<th width="40%">考场地址</th>
				<th width="20%">考场联系电话</th>
				<th width="7%">邮编</th>
				<th width="8%">操作</th>
			</tr>
			<c:forEach items="${roomList }" var="room">
				<tr>
					<td style="display: none;">${room.room_id }</td>
					<td>${room.rname }</td>
					<td>${room.raddress }</td>
					<td>${room.rtelnum }</td>
					<td>${room.rpostcode }</td>
					<td><a href="adminRoom/toUpdateRoom?room_id=${room.room_id }">修改</a>
						<a onclick="return checkDel();"
						href="adminRoom/deleteRoom?room_id=${room.room_id }">删除</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<c:if test="${msg != null }">
		<script type="text/javascript">
			alert("${msg}");
		</script>
	</c:if>
</body>
</html>