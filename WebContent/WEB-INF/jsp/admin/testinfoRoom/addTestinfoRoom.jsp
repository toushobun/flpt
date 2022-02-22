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
	<form:form action="adminTestinfoRoom/addTestinfoRoom" method="post"
		onsubmit="return checkTestinfoRoom(this);" modelAttribute="testinfoRoom">
		<input type="hidden" name="testinfo_id"
			value="${testinfoRoom.testinfo_id }">
		<table style="display: none;" id="testData">
			<tr>
				<td>${testinfoRoom.testinfo_id }</td>
				<td>${testinfoRoom.tname }</td>
				<td>${testinfoRoom.tsubject }</td>
				<td>${testinfoRoom.torganizer }</td>
				<td>${testinfoRoom.test_time }</td>
				<td>${testinfoRoom.regist_start_time }</td>
				<td>${testinfoRoom.regist_end_time }</td>
				<td>${testinfoRoom.tprice }</td>
			</tr>
		</table>
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
										<td><form:input path="room_rquotas" placeholder="请输入名额"
												value="300" /></td>
									</tr>
								</c:forEach></td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td style="text-align: left"><input type="button"
					onclick="window.history.back();" value="返回" /></td>
				<td style="text-align: right"><input type="submit" value="提交" />
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>