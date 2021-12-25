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
	<form:form id="searchForm" action="adminReginfo/searchReginfo"
		method="post" modelAttribute="reginfo">
		<form:input path="tname" placeholder="输入考试名" value="${reginfo.tname }" />
		<form:input path="uname" placeholder="输入考生姓名" value="${reginfo.uname }" />
		<form:input path="rname" placeholder="输入考点名" value="${reginfo.rname }" />
		<input type="submit" value="搜索" />
		<input type="button" value="清空" onclick="emptyInput('searchForm');" />
	</form:form>
	<c:if test="${reginfoList.size() == 0 }">
		未查询到结果
	</c:if>
	<c:if test="${reginfoList.size() != 0 }">
		<table border=1>
			<tr>
				<th width="15%">考试名称</th>
				<th width="15%">考生姓名</th>
				<th width="10%">准考证号</th>
				<th width="10%">身份证号</th>
				<th width="20%">考点名称</th>
				<th width="20%">考试时间</th>
				<th width="10%">操作</th>
			</tr>
			<c:forEach items="${reginfoList }" var="reginfo">
				<tr>
					<td>${reginfo.tname }</td>
					<td>${reginfo.uname }</td>
					<td>${reginfo.ticketnum }</td>
					<td>${reginfo.uidnum }</td>
					<td>${reginfo.rname }</td>
					<td>${reginfo.test_time }</td>
					<td><a onclick="return checkDel();"
						href="adminReginfo/deleteReginfo?reginfo_id=${reginfo.reginfo_id }">删除</a></td>
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