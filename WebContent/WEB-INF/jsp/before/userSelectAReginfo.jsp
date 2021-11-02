<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<title>Insert title here</title>
<script type="text/javascript">
function cancelConfirm(reginfo_id){
	if(confirm("确认要取消报名？")){
		window.location.href="userReginfo/userCancelReginfo?reginfo_id=" + reginfo_id
	}
}
</script>
</head>
<body>
	<table border=1>
		<tr>
			<td>考生编号</td>
			<td>${reginfo.ticketnum }</td>
		<tr>
			<td>考生姓名</td>
			<td>${sessionScope.buser.uname }</td>
		<tr>
			<td>证件号码</td>
			<td>${sessionScope.buser.uidnum }</td>
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
			<td>操作</td>
			<td>
				<c:if test="${reginfo.status == 0 }">
					<a href="userReginfo/userToPay?reginfo_id=${reginfo.reginfo_id }&tname=${reginfo.tname }">前往付款</a>&nbsp;
					<a href="javascript:cancelConfirm('${reginfo.reginfo_id}')">取消报名</a>
				</c:if>
				<c:if test="${reginfo.status == 1 }">
					<a href="userReginfo/userToChangeRoom?testinfo__room_id=${reginfo.testinfo__room_id }&reginfo_id=${reginfo.reginfo_id }">修改考场</a>&nbsp;
					<a href="#">生成准考证</a>
				</c:if>
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