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
<link href="css/user.css" type="text/css" rel="stylesheet">
<script src="js/buttonAction.js" type="text/javascript"></script>
<script src="js/formCheck.js" type="text/javascript"></script>
<script src="js/postConfirm.js" type="text/javascript"></script>
</head>
<body>
	<ul>
		<li>欢迎光临中国外国语能力考试报名网</li>
		<li><a href="userTestinfo/selectTestinfo?user_id=${sessionScope.user.user_id }" target="center">报名考试</a></li>
		<li><a href="userNotice/selectNotice" target="center">查看公告</a></li>
		<c:if test="${sessionScope.user != null }">
			<li><a>考生：${sessionScope.user.uname }</a>
				<ul>
					<li><a href="userCenter/center" target="center">个人中心</a></li>
					<li><a href="user/exit">安全退出</a></li>
				</ul></li>
		</c:if>
		<c:if test="${sessionScope.user == null }">
			<li><a href="user/toRegister">注册</a></li>
			<li><a href="user/toLogin">登录</a></li>
		</c:if>
	</ul>
	<%-- <c:if test="${sessionScope.user != null }">
		<iframe src="userCenter/center" name="center" frameborder="0"></iframe>
	</c:if>
	<c:if test="${sessionScope.user == null }">
		<iframe src="selectNotice" name="center" frameborder="0"></iframe>
	</c:if> --%>
	©版权属于大连外国语大学18级软件7班邓淞文
	<c:if test="${msg != null }">
		<script type="text/javascript">
			alert("${msg}");
		</script>
	</c:if>
</body>
</html>