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
<link href="css/box.css" type="text/css" rel="stylesheet">
<script src="js/buttonAction.js" type="text/javascript"></script>
<script src="js/formCheck.js" type="text/javascript"></script>
<script src="js/postConfirm.js" type="text/javascript"></script>
<script src="js/colorControl.js" type="text/javascript"></script>
</head>
<body>
	<table id="table">
		<tr>
			<th width="20%">考场名</th>
			<th width="30%">考场地址</th>
			<th width="20%">考场联系电话</th>
			<th width="8%">邮编</th>
			<th width="7%">名额</th>
			<th width="15%">操作</th>
		</tr>
		<c:forEach items="${testinfoRoomList }" var="testinfoRoom">
			<tr>
				<td>${testinfoRoom.rname }</td>
				<td>${testinfoRoom.raddress }</td>
				<td>${testinfoRoom.rtelnum }</td>
				<td>${testinfoRoom.rpostcode }</td>
				<td>${testinfoRoom.rquota }</td>
				<td><a
					href="javascript:changeQuota('${testinfoRoom.testinfoRoom_id }', '${testinfoRoom.testinfo_id }')">修改名额</a>
					<a onclick="return confirmCancelRoom('${testinfoRoom.rname }');"
					href="adminTestinfoRoom/cancelRoom?testinfoRoom_id=${testinfoRoom.testinfoRoom_id }&testinfo_id=${testinfoRoom.testinfo_id }&room_id=${testinfoRoom.room_id }">取消考场</a>
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td><c:if test="${notSelectedRoom.size() == 0 }">
			已配置全部考场
		</c:if> <c:if test="${notSelectedRoom.size() != 0 }">
					<form:form action="adminTestinfoRoom/toAddTestinfoRoom"
						method="post" onsubmit="return checkSelectRoom(this);"
						modelAttribute="testinfoRoom">
						<div style="display: none">
							<form:input path="testinfo_id"
								value="${testinfoRoomList.get(0).testinfo_id }"></form:input>
							<form:input path="tname" value="${testinfoRoom.tname }"></form:input>
							<form:input path="tsubject" value="${testinfoRoom.tsubject }"></form:input>
							<form:input path="torganizer" value="${testinfoRoom.torganizer }"></form:input>
							<form:input path="test_time" value="${testinfoRoom.test_time }"></form:input>
							<form:input path="regist_start_time"
								value="${testinfoRoom.regist_start_time }"></form:input>
							<form:input path="regist_end_time"
								value="${testinfoRoom.regist_end_time }"></form:input>
							<form:input path="tprice" value="${testinfoRoom.tprice }"></form:input>
						</div>
						<table>
							<caption>额外添加考场</caption>
							<tr>
								<td>
									<table id="roomSelect">
										<c:forEach items="${notSelectedRoom }" var="room">
											<tr>
												<td><form:checkbox path="room_ids"
														value="${room.room_id }" /></td>
												<td>${room.rname }</td>
											</tr>
										</c:forEach>
									</table>
								</td>
							</tr>
							<tr>
								<td><input type="submit" value="前往为新考场配置名额" /></td>
							</tr>
						</table>
					</form:form>
				</c:if></td>
		</tr>
	</table>
	<c:if test="${msg != null }">
		<script type="text/javascript">
			alert("${msg}");
		</script>
	</c:if>
</body>
</html>