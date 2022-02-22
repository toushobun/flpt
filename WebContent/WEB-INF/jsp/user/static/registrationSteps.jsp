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
<script src="js/buttonAction.js" type="text/javascript"></script>
<script src="js/formCheck.js" type="text/javascript"></script>
<script src="js/postConfirm.js" type="text/javascript"></script>
</head>
<body>
	<h3 align="center">报名步骤详情</h3>
	<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;报名步骤如下：</p>
	<p>&nbsp;&nbsp;&nbsp;&nbsp;① 第一步，先进行登录，如果还没有用户，请先注册！</p>
	<p>&nbsp;&nbsp;&nbsp;&nbsp;注意：注册后证件号无法被更改！如需销毁用户请联系管理员！</p>
	<p>&nbsp;&nbsp;&nbsp;&nbsp;② 第二步，点击考试概况，进行考试报名，在此页可以看可以报名的考试</p>
	<p>&nbsp;&nbsp;&nbsp;&nbsp;③ 第三步，选择一个可以报名的考试，点击前往报名</p>
	<p>&nbsp;&nbsp;&nbsp;&nbsp;④ 第四步，选择一个有名额且在报名时间的考试进行报名</p>
	<p>&nbsp;&nbsp;&nbsp;&nbsp;⑤ 第五步，查看刚刚报名的考试详情，点击前往付款，选择支付方式并进行支付</p>
	<p>&nbsp;&nbsp;&nbsp;&nbsp;⑥ 第六步，此时可以查看刚刚报名的考试，生成准考证啦！</p>
	<p align="right">2022/2/21 17:22:24&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
</body>
</html>