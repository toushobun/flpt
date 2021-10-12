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
<script src="js/formCheck.js" type="text/javascript"></script>
</head>
<body>
	<c:if test="${allRoom.size() == 0 }">
		还没有登记考场。
	</c:if>
	<c:if test="${allRoom.size() != 0 }">
		<table border=1>
			<tr>
				<th width="10%">ID</th>
				<th width="25%">考场名</th>
				<th width="10%">考场地址</th>
				<th width="25%">考场联系电话</th>
				<th width="10%">邮编</th>
				<th width="20%">操作</th>
			</tr>
			<c:forEach items="${allRoom }" var="room">
				<tr>
					<td>${room.id }</td>
					<td>${room.rname }</td>
					<td>${room.raddress }</td>
					<td>${room.rtelnum }</td>
					<td>${room.rpostcode }</td>
					<td>
						<a href="adminRoom/toUpdateRoom?id=${room.id }">修改</a>
						<a onclick="return checkDel();" href="adminRoom/deleteRoom?id=${room.id }">删除</a>
					</td>
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