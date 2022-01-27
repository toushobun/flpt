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
<script src="js/colorControl.js" type="text/javascript"></script>
</head>
<body>
	<form:form id="searchForm" action="adminUser/searchUser"
		method="post" modelAttribute="user">
		<form:input path="uname" placeholder="输入考生姓名" value="${user.uname }" />
		<form:input path="uidnum" placeholder="输入考生证件"
			value="${user.uidnum }" />
		<input type="submit" value="搜索" />
		<input type="button" value="清空" onclick="emptyInput('searchForm');" />
	</form:form>
	<c:if test="${userList.size() == 0 }">
        <h2 id="selectResult">未查询到结果</h2>
	</c:if>
	<c:if test="${userList.size() != 0 }">
		<table id="table">
			<tr>
				<th width="30%">照片</th>
				<th width="20%">考生姓名</th>
				<th width="20%">身份证号</th>
				<th width="20%">密码</th>
				<th width="10%">操作</th>
			</tr>
			<c:forEach items="${userList }" var="user">
				<tr>
					<td><c:if test="${user.uidphoto != '' }">
							<img alt="" width="100" height="100"
								src="logos/${user.uidphoto}" />
						</c:if></td>
					<td>${user.uname }</td>
					<td>${user.uidnum }</td>
					<td>${user.upwd }</td>
					<td><a onclick="return confirmDel();"
						href="adminUser/deleteUser?user_id=${user.user_id }">删除</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<c:if test="${msg != null }">
		<script type="text/javascript">
			alert("${msg}");
		</script>
	</c:if>
</body>
</html>