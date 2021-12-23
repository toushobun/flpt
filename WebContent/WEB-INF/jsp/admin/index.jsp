<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<title>后台主页面</title>
</head>
<body>
	欢迎${auser.aname}进入后台管理系统！
	<a href="exit">安全退出</a>
	<p>管理员：${auser.aname}</p>
	<ul>
		<li><label>考试管理</label>
			<ul>
				<li><a href="adminTest/selectTest" target="center">考试列表</a></li>
				<li><a href="adminTest/toAddTest" target="center">添加考试</a></li>
			</ul></li>
		<li><label>考场管理</label>
			<ul>
				<li><a href="adminRoom/selectRoom" target="center">考场列表</a></li>
				<li><a href="adminRoom/toAddRoom" target="center">添加考场</a></li>
			</ul></li>
		<li><label>考试发布管理</label>
			<ul>
				<li><a href="adminTestinfo/selectTestinfo" target="center">已发布考试列表</a></li>
				<li><a href="adminTestinfo/toAddTestinfo" target="center">发布新考试</a></li>
			</ul></li>
		<li><label>公告管理</label>
			<ul>
				<li><a href="adminNotice/selectNotice" target="center">公告列表</a></li>
				<li><a href="adminNotice/toAddNotice" target="center">发布新公告</a></li>
			</ul></li>
		<li><label>考生用户管理</label>
			<ul>
				<li><a href="adminUser/selectUser" target="center">考生列表</a></li>
			</ul></li>
		<li><label>报名信息管理</label>
			<ul>
				<li><a href="adminReginfo/selectReginfo" target="center">报名信息列表</a></li>
			</ul></li>
	</ul>
	<!-- <iframe src="adminExaminfo/selectExaminfo" name="center" frameborder="0"></iframe> -->
	©版权属于大连外国语大学18级软件7班邓淞文
</body>
</html>