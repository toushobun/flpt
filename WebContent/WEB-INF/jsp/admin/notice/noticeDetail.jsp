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
<link href="css/admin.css" type="text/css" rel="stylesheet">
<script src="js/formCheck.js" type="text/javascript"></script>
</head>
<body>
	<h3 align="center">${notice.ntitle }</h3>
	<p>&nbsp;&nbsp;&nbsp;&nbsp;${notice.ncontent }</p>
	<p align="right">${notice.ntime }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
</body>
</html>