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
<body style="text-align: center;">
	<h2 id="selectResult">请选择支付方式</h2>
	<a href="userReginfo/pay?reginfo_id=${reginfo_id }"><img
		src="img/p1.jpg" width="150px" height="150px" alt=""> </a>&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="userReginfo/pay?reginfo_id=${reginfo_id }"><img
		src="img/p2.jpg" width="150px" height="150px" alt=""> </a>
</body>
</html>