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
<script src="js/colorControl.js" type="text/javascript"></script>
<script src="js/formCheck.js" type="text/javascript"></script>
</head>
<body>
	<table border=1>
		<tr>
			<th width="19%">考场名</th>
			<th width="39%">考场地址</th>
			<th width="19%">考场联系电话</th>
			<th width="6%">邮编</th>
			<th width="5%">名额</th>
			<th width="12%">操作</th>
		</tr>
		<c:forEach items="${testinfoRoomList }" var="testinfoRoom">
			<tr>
				<td>${testinfoRoom.rname }</td>
				<td>${testinfoRoom.raddress }</td>
				<td>${testinfoRoom.rtelnum }</td>
				<td>${testinfoRoom.rpostcode }</td>
				<td>${testinfoRoom.rquota }</td>
				<td><a
					href="javascript:changeQuota('${testinfoRoom.testinfo__room_id }', '${testinfoRoom.testinfo_id }')">修改名额</a>
					<a
					href="javascript:cancelConfirm('${testinfoRoom.testinfo__room_id }', '${testinfoRoom.testinfo_id }', '${testinfoRoom.rname }', '${testinfoRoom.room_id }')">取消考场</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<form:form action="adminTestinfo/toAddTestinfoNewRoom" method="post"
		modelAttribute="testinfo">
		<input type="hidden" name="testinfo_id"
			value="${allTestinfo__room.get(0).testinfo_id }">
		<table>
			<caption>额外添加考场</caption>
			<tr>
				<td><c:forEach items="${notSelectedRoom }" var="room">
						<tr>
							<td><form:checkbox path="room_ids" value="${room.room_id }" /></td>
							<td>${room.rname }</td>
						</tr>
					</c:forEach></td>
			</tr>
			<tr>
				<td colspan="2" style="text-align: right"><input type="submit"
					value="前往为新考场配置名额" /></td>
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