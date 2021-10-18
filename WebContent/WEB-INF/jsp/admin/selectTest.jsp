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
	<form action="adminTest/searchTest" method="post">
		<input type="text" name="keyWord"/>
		<input type="submit" value="搜索"/>
	</form>
	<c:if test="${allTest.size() == 0 }">
		未查询到结果
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
					<td style="display: none;">${test.test_id }</td>
					<td>${test.tname }</td>
					<td>${test.tsubject }</td>
					<td>${test.torganizer }</td>
					<c:if test="${test.status != 0 }"><td>是</td></c:if>
					<c:if test="${test.status == 0 }"><td>否</td></c:if>
					<td>
						<a href="adminTest/toUpdateTest?test_id=${test.test_id }">修改</a>
						<a onclick="return checkDel();" href="adminTest/deleteTest?test_id=${test.test_id }">删除</a>
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