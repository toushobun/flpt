<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<title>中国外国语能力考试报名网</title>
<link rel="stylesheet" type="text/css" href="css/before.css">
</head>
<body>
	<ul>
		<li>欢迎光临中国外国语能力考试报名网</li>
		<li><a href="userReginfo/userSelectTestinfo" target="center">报名考试</a></li>
        <li><a href="selectNotice" target="center">查看公告</a></li>
        <c:if test="${sessionScope.buser != null }">
	        <li><a>考生：${sessionScope.buser.uname }</a>
	        	<ul>
	        		<li><a href="userCenter/center" target="center">个人中心</a></li>
	        		<li><a href="before/exit">安全退出</a></li>
				</ul>
			</li>
        </c:if>
        <c:if test="${sessionScope.buser == null }">
	        <li><a href="toRegister">注册</a></li>
	        <li><a href="before/toLogin">登录</a></li>
        </c:if>
	</ul>
	<%-- <c:if test="${sessionScope.buser != null }">
		<iframe src="userCenter/center" name="center" frameborder="0"></iframe>
	</c:if>
	<c:if test="${sessionScope.buser == null }">
		<iframe src="selectNotice" name="center" frameborder="0"></iframe>
	</c:if> --%>
	©版权属于大连外国语大学18级软件7班邓淞文
</body>
</html>