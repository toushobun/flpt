<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<title>Insert title here</title>
</head>
<body>
正在为考生：「${sessionScope.buser.uname }」　支付考试：「${reginfo.tname }」的考试费用
请选择支付方式：
<p><a href="userReginfo/userPayDone?reginfo_id=${reginfo.reginfo_id }">微信支付</a></p>
<p><a href="userReginfo/userPayDone?reginfo_id=${reginfo.reginfo_id }">支付宝支付</a></p>
<p><a href="userReginfo/userPayDone?reginfo_id=${reginfo.reginfo_id }">建设银行支付</a></p>
</body>
</html>