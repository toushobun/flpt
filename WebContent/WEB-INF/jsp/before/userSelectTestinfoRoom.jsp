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
</head>
<body>
	<table border=1>
		<tr>
			<th width="25%">考场名</th>
			<th width="40%">考场地址</th>
			<th width="20%">考场联系电话</th>
			<th width="15%">操作</th>
		</tr>
		<c:forEach items="${allTestinfo__room }" var="testinfo__room">
			<tr>
				<td>${testinfo__room.rname }</td>
				<td>${testinfo__room.raddress }</td>
				<td>${testinfo__room.rtelnum }</td>
				<td>
					<c:if test="${testinfo__room.status == 1 }">
						<a href="userReginfo/userAddReginfo?testinfo__room_id=${testinfo__room.testinfo__room_id }&user_id=${sessionScope.buser.user_id }&testinfo_id=${testinfo__room.testinfo_id }&room_id=${testinfo__room.room_id}">报名</a>
					</c:if>
					<c:if test="${testinfo__room.status == 0 }">
						名额已满
					</c:if>
					<c:if test="${testinfo__room.status == -1 }">
						不在报名时间
					</c:if>
				</td>
			</tr>
		</c:forEach>
	</table>
	<c:if test="${msg != null }">
		<script type="text/javascript">
			alert("${msg}");
		</script>
	</c:if>
</body>
</html>