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
<body>
	<form:form action="adminTestinfo/addTestinfo" method="post"
		onsubmit="return checkTestinfoRoom(this);" modelAttribute="testinfoRoom">
		<div style="display: none">
			<form:input path="test_id" value="${testinfoRoom.test_id }"></form:input>
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
			<caption>考场名额配置</caption>
			<tr>
				<td>
					<table id="roomAddSelect">
						<tr>
							<td><c:forEach items="${selectedRoomList }" var="room">
									<tr>
										<form:hidden path="room_ids" value="${room.room_id }" />
										<td>${room.rname }<font color="red">*</font></td>
										<td><form:input path="room_rquotas"
												placeholder="请输入该考场可报名名额" value="300" /></td>
									</tr>
								</c:forEach></td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td style="text-align: left"><input type="button"
					onclick="window.history.back()" value="返回" /></td>
				<td style="text-align: right"><input type="submit" value="提交" />
				</td>
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