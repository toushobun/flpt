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

	<table style="padding-top: 30px; margin: auto; text-align: center;">
		<tr>
			<td rowspan="4"><img alt="" width="250" height="250"
				src="logos/${sessionScope.user.uidphoto}" /></td>
		</tr>
		<tr>
			<th>考生姓名</th>
			<td>${sessionScope.user.uname }</td>
		</tr>
		<tr>
			<th>身份证号</th>
			<td>${sessionScope.user.uidnum }</td>
		</tr>
		<tr>
			<th>操作</th>
			<td>&nbsp;<a
				href="userReginfo/selectReginfo?user_id=${sessionScope.user.user_id }">查看全部报名信息</a>
				&nbsp;<a href="userCenter/toUpdateIdphoto">修改照片</a> &nbsp;<a
				href="userCenter/toUpdatePwd">修改密码</a> &nbsp;<a
				onclick="return confirmDelDouble();"
				href="userCenter/deleteUser?user_id=${sessionScope.user.user_id }">销毁用户</a>
			</td>
		</tr>
	</table>
	<c:if test="${msg != null }">
		<script type="text/javascript">
			alert("${msg}");
		</script>
	</c:if>
</body>
</html>