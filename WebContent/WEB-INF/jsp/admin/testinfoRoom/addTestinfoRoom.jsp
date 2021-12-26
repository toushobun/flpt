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
<body>
	<form:form action="adminTestinfoRoom/addTestinfoRoom" method="post"
		modelAttribute="testinfoRoom">

		<input type="text" name="testinfo_id"
			value="${testinfoRoom.testinfo_id }">
		<table>
			<caption>考场名额配置</caption>
			<tr>
				<td><c:forEach items="${selectedRoomList }" var="room">
						<tr>
							<form:hidden path="room_ids" value="${room.room_id }" />
							<td>${room.rname }<font color="red">*</font></td>
							<td><form:input path="room_rquotas"
									placeholder="请输入该考场可报名名额" /></td>
						</tr>
					</c:forEach></td>
			</tr>
			<tr>
				<td style="text-align: left"><input type="button"
					onclick="window.history.back()" value="返回" /></td>
				<td style="text-align: right"><input type="submit" value="提交" />
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>