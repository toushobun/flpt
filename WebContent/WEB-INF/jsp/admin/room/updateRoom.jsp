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
</head>
<body>
	<form:form action="adminRoom/updateRoom"
		onsubmit="return doInputTest();" method="post" modelAttribute="room">
		<table>
			<caption>修改考场</caption>
			<form:hidden path="room_id" value="${room.room_id}" />
			<tr>
				<td>考场名<font color="red">*</font></td>
				<td><form:input path="rname" value="${room.rname}" /></td>
			</tr>
			<tr>
				<td>考场地址<font color="red">*</font></td>
				<td><form:input path="raddress" value="${room.raddress}" /></td>
			</tr>
			<tr>
				<td>考场联系电话<font color="red">*</font></td>
				<td><form:input path="rtelnum" value="${room.rtelnum}" /></td>
			</tr>
			<tr>
				<td>邮编<font color="red">*</font></td>
				<td><form:input path="rpostcode" value="${room.rpostcode}" /></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td style="text-align: right"><input type="submit" value="提交" />
				</td>
			</tr>
		</table>
		<c:if test="${msg != null }">
			<script type="text/javascript">
				alert("${msg}");
			</script>
		</c:if>
	</form:form>
</body>
</html>