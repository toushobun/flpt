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
<body>
	请选择支付方式：
	<p>
		<a href="userReginfo/pay?reginfo_id=${reginfo_id }">微信支付</a>
	</p>
	<p>
		<a href="userReginfo/pay?reginfo_id=${reginfo_id }">支付宝支付</a>
	</p>
	<p>
		<a href="userReginfo/pay?reginfo_id=${reginfo_id }">建设银行支付</a>
	</p>
</body>
</html>