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
</head>
<body>
	<form:form action="adminRoom/addRoom" method="post"
		modelAttribute="room">
		<table>
			<caption>添加考场</caption>
			<tr>
				<td>考场名<font color="red">*</font></td>
				<td><form:input path="rname" placeholder="请填入考场名" /></td>
			</tr>
			<tr>
				<td>考场地址<font color="red">*</font></td>
				<td><form:input path="raddress" placeholder="请填入考场地址" /></td>
			</tr>
			<tr>
				<td>考场联系电话<font color="red">*</font></td>
				<td><form:input path="rtelnum" placeholder="请输入考场联系电话" /></td>
			</tr>
			<tr>
				<td>邮编<font color="red">*</font></td>
				<td><form:input path="rpostcode" placeholder="请输入邮编" /></td>
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