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
	<form:form action="adminTest/addTest" method="post"
		modelAttribute="test">
		<table>
			<caption>添加考试</caption>
			<tr>
				<td>考试名<font color="red">*</font></td>
				<td><form:input path="tname" placeholder="请填入考试名" /></td>
			</tr>
			<tr>
				<td>考试科目<font color="red">*</font></td>
				<td><form:input path="tsubject" placeholder="请填入考试科目" /></td>
			</tr>
			<tr>
				<td>主考单位<font color="red">*</font></td>
				<td><form:input path="torganizer" placeholder="请输入主考单位" /></td>
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