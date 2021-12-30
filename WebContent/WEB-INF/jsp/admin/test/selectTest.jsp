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
	<form:form id="searchForm" action="adminTest/searchTest" method="post"
		modelAttribute="test">
		<form:input path="tname" placeholder="输入考试名" value="${test.tname }" />
		<form:input path="tsubject" placeholder="输入考试科目"
			value="${test.tsubject }" />
		<form:input path="torganizer" placeholder="主考单位"
			value="${test.torganizer }" />
		<form:select path="status">
			<form:option value="" label="是否发布"/>
			<form:option value="1" label="是"/>
			<form:option value="0" label="否"/>
		</form:select>
		<input type="submit" value="搜索" />
		<input type="button" value="清空" onclick="emptyInput('searchForm');" />
	</form:form>
	<c:if test="${testList.size() == 0 }">
		未查询到结果
	</c:if>
	<c:if test="${testList.size() != 0 }">
		<table id="table">
			<tr>
				<th width="25%">考试名</th>
				<th width="10%">考试科目</th>
				<th width="25%">主考单位</th>
				<th width="10%">是否已发布</th>
				<th width="20%">操作</th>
			</tr>
			<c:forEach items="${testList }" var="test">
				<tr>
					<td>${test.tname }</td>
					<td>${test.tsubject }</td>
					<td>${test.torganizer }</td>
					<c:if test="${test.status != 0 }">
						<td>是</td>
					</c:if>
					<c:if test="${test.status == 0 }">
						<td>否</td>
					</c:if>
					<td><a href="adminTest/toUpdateTest?test_id=${test.test_id }">修改</a>
						<a onclick="return confirmDel();"
						href="adminTest/deleteTest?test_id=${test.test_id }">删除</a></td>
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