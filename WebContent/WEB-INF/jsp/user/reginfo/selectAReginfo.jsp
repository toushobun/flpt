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
<script src="js/colorControl.js" type="text/javascript"></script>
</head>
<body>
	<table id="table">
		<tr>
			<td>准考证号</td>
			<td>${reginfo.ticketnum }</td>
		<tr>
			<td>考生姓名</td>
			<td>${sessionScope.user.uname }</td>
		<tr>
			<td>证件号码</td>
			<td>${sessionScope.user.uidnum }</td>
		<tr>
			<td>考试名称</td>
			<td>${reginfo.tname }</td>
		<tr>
			<td>考试时间</td>
			<td>${reginfo.test_time }</td>
		<tr>
			<td>考点名称</td>
			<td>${reginfo.rname }</td>
		<tr>
			<td>详细地址</td>
			<td>${reginfo.raddress }</td>
		</tr>
		<tr>
			<th width="15%">操作</th>
			<c:if test="${reginfo.status == 0 }">
				<td><a
					href="userReginfo/userToPay?reginfo_id=${reginfo.reginfo_id }&tname=${reginfo.tname }">前往付款</a>&nbsp;
					<a onclick="return confirmCancelReg();"
					href="userReginfo/cancelReg?reginfo_id=${reginfo.reginfo_id }&user_id=${sessionScope.user.user_id }">取消报名</a>
				</td>
			</c:if>
			<c:if test="${reginfo.status == 1 }">
				<td><a
					href="userReginfo/toChangeRoom?reginfo_id=${reginfo.reginfo_id }">修改考场</a>&nbsp;
					<a
					href="userReginfo/createTicket?reginfo_id=${reginfo.reginfo_id }">生成准考证</a>
				</td>
			</c:if>
			<c:if test="${reginfo.status == 2 }">
				<td>您已取消该考试的报名，点击此处<a onclick="return confirmDel();"
					href="userReginfo/deleteReginfo?reginfo_id=${reginfo.reginfo_id }">删除</a>！
				</td>
			</c:if>
		</tr>
	</table>
	<c:if test="${msg != null }">
		<script type="text/javascript">
			alert("${msg}");
		</script>
	</c:if>
</body>
</html>