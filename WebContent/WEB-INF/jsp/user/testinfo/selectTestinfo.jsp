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
<script src="js/colorControl.js" type="text/javascript"></script>
<script src="js/buttonAction.js" type="text/javascript"></script>
<script src="js/formCheck.js" type="text/javascript"></script>
<script src="js/postConfirm.js" type="text/javascript"></script>
</head>
<body>
	<form:form id="searchForm" action="userTestinfo/searchTestinfo" method="post"
		modelAttribute="testinfo">
		<form:input path="tname" placeholder="输入考试名" value="${testinfo.tname }" />
		<form:input path="tsubject" placeholder="输入考试科目"
			value="${testinfo.tsubject }" />
		<input type="submit" value="搜索" />
		<input type="button" value="清空" onclick="emptyInput('searchForm');" />
	</form:form>
	<c:if test="${testinfoList.size() == 0 }">
		未查询到结果
	</c:if>
	<c:if test="${testinfoList.size() != 0 }">
		请选择要报名的考试
		<table id="table">
			<tr>
				<th width="30%">考试名</th>
				<th width="10%">科目</th>
				<th width="30%">考试时间</th>
				<th width="10%">报名费</th>
				<th width="20%">操作</th>
			</tr>
			<c:forEach items="${testinfoList }" var="testinfo">
				<tr>
					<td>${testinfo.tname }</td>
					<td>${testinfo.tsubject }</td>
					<td>${testinfo.test_time }</td>
					<td>${testinfo.tprice }</td>
					<td>
						<c:if test="${testinfo.status == 1 }">
							<a href="userTestinfoRoom/selectTestinfoRoom?testinfo_id=${testinfo.testinfo_id }">前往报名</a>
						</c:if>
						<c:if test="${testinfo.status == 0 }">
							已报名，<a href="userReginfo/userSelectAReginfo?user_id=${sessionScope.buser.user_id }&testinfo_id=${testinfo.testinfo_id }">查看报名信息</a>
						</c:if>
					</td>
				</tr>
			</c:forEach>
		</table>
		<c:if test="${msg != null }">
			<script type="text/javascript">
				alert("${msg}");
			</script>
		</c:if>
	</c:if>
</body>
</html>