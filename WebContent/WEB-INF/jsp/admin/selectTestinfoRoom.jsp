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
<title>Insert title here</title>
<script src="js/formCheck.js" type="text/javascript"></script>
<script type="text/javascript">
function changeQuota(id, testinfo_id){
	var rquota = prompt("请输入更改的名额：")
	if(rquota.indexOf(" ") >= 0 || rquota == "") {
		alert('不能为空')
		return false
	}
	var quota = Number(rquota)
	if(isNaN(quota) || quota < 0 || parseInt(quota) - quota != 0) {
		alert("请输入一个非负整数！")
		return false
	}
	else{
		window.location.href="adminTestinfo/updateRoomQuota?id=" + id + "&rquota=" + quota + "&testinfo_id=" + testinfo_id
	}
}
function cancelConfirm(id, testinfo_id, rname, room_id){
	if(confirm("确认要取消考场：" + rname + "？")){
		window.location.href="adminTestinfo/cancelRoom?id=" + id + "&testinfo_id=" + testinfo_id + "&room_id=" + room_id
	}
}
</script>
</head>
<body>
	<table border=1>
		<tr>
			<th width="25%">考场名</th>
			<th width="10%">考场地址</th>
			<th width="25%">考场联系电话</th>
			<th width="10%">邮编</th>
			<th width="10%">名额</th>
			<th width="20%">操作</th>
		</tr>
		<c:forEach items="${sessionScope.allTestinfo__Room }" var="testinfo__room">
			<tr>
				<td>${testinfo__room.rname }</td>
				<td>${testinfo__room.raddress }</td>
				<td>${testinfo__room.rtelnum }</td>
				<td>${testinfo__room.rpostcode }</td>
				<td>${testinfo__room.rquota }</td>
				<td>
					<a href="javascript:changeQuota('${testinfo__room.id }', '${testinfo__room.testinfo_id }')">修改名额</a>
					<a href="javascript:cancelConfirm('${testinfo__room.id }', '${testinfo__room.testinfo_id }', '${testinfo__room.rname }', '${testinfo__room.room_id }')">取消考场</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<form:form action="adminTestinfo/toAddTestinfoNewRoom" method="post" modelAttribute="testinfo">
		<input type="hidden" name="id" value="${sessionScope.allTestinfo__Room.get(0).testinfo_id }">
		<table>
			<caption>额外添加考场</caption>
			<tr>
				<td>
					<c:forEach items="${sessionScope.notSelectedRoom }" var="room">
						<tr>
							<td><form:checkbox path="room_ids" value="${room.id }"/></td>
							<td>${room.rname }</td>
						</tr>
					</c:forEach>
				</td>
			</tr>
			<tr>
				<td colspan="2" style="text-align: right">
					<input type="submit" value="前往为新考场配置名额"/>
				</td>
			</tr>
		</table>
	</form:form>
	<c:if test="${msg != null }">
		<script type="text/javascript">
			alert("${msg}");
		</script>
	</c:if>
</body>
</html>