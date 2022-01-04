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
<script src="js/formCheck.js" type="text/javascript"></script>
<script src="js/buttonAction.js" type="text/javascript"></script>
<script src="js/formCheck.js" type="text/javascript"></script>
<script src="js/postConfirm.js" type="text/javascript"></script>
</head>
<body>
	<form:form action="userCenter/updatePwd" method="post"
		modelAttribute="user">
		<table>
			<caption>修改密码</caption>
			<form:hidden path="user_id" value="${sessionScope.user.user_id}" />
			<tr>
				<td>原密码<font color="red">*</font></td>
				<td><input type="password" name="upwd" /></td>
			</tr>
			<tr>
				<td>新密码<font color="red">*</font></td>
				<td><input type="password" /></td>
			</tr>
			<tr>
				<td>再次输入密码<font color="red">*</font></td>
				<td><input type="password" name="newUpwd" /></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
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