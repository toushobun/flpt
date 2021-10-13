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
<script src="js/formCheck.js" type="text/javascript"></script>
</head>
<body>
	<c:if test="${allTest.size() == 0 }">
		还没有登记考试。
	</c:if>
	<c:if test="${allTest.size() != 0 }">
		<table border=1>
			<tr>
				<th style="display: none;">ID</th>
				<th width="25%">考试名</th>
				<th width="10%">考试科目</th>
				<th width="25%">主考单位</th>
				<th width="10%">是否已发布</th>
				<th width="20%">操作</th>
			</tr>
			<c:forEach items="${allTest }" var="test">
				<tr>
					<td style="display: none;">${test.id }</td>
					<td>${test.tname }</td>
					<td>${test.tsubject }</td>
					<td>${test.torganizer }</td>
					<td>${test.status }</td>
					<td>
						<a href="adminTest/toUpdateTest?id=${test.id }">修改</a>
						<a onclick="return checkDel();" href="adminTest/deleteTest?id=${test.id }">删除</a>
					</td>
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