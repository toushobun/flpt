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
			<th width="25%">考场名</th>
			<th width="40%">考场地址</th>
			<th width="20%">考场联系电话</th>
			<th width="15%">操作</th>
		</tr>
		<c:forEach items="${testinfoRoomList }" var="testinfoRoom">
			<tr>
				<td>${testinfoRoom.rname }</td>
				<td>${testinfoRoom.raddress }</td>
				<td>${testinfoRoom.rtelnum }</td>
				<td><c:if test="${testinfoRoom.status == 1 }">
						<a onclick="return confirmChange();"
							href="userReginfo/changeRoom?testinfoRoom_id=${testinfoRoom.testinfoRoom_id }&reginfo_id=${reginfo_id }">报名</a>
					</c:if> <c:if test="${testinfoRoom.status == -1 }">
						名额已满
					</c:if> <c:if test="${testinfoRoom.status == -2 }">
						不在报名时间
					</c:if> <c:if test="${testinfoRoom.status == -3 }">
						当前考场
					</c:if></td>
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