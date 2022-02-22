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
	<form:form id="searchForm" action="adminTestinfo/searchTestinfo"
		method="post" modelAttribute="testinfo">
		<form:input path="tname" placeholder="输入考试名"
			value="${testinfo.tname }" />
		<form:input path="tsubject" placeholder="输入考试科目"
			value="${testinfo.tsubject }" />
		<form:input path="torganizer" placeholder="主考单位"
			value="${testinfo.torganizer }" />
		<input type="submit" value="搜索" />
		<input type="button" value="清空" onclick="emptyInput('searchForm');" />
	</form:form>
	<c:if test="${testinfoList.size() == 0 }">
        <h2 id="selectResult">未查询到结果</h2>
	</c:if>
	<c:if test="${testinfoList.size() != 0 }">
		<table id="table">
			<tr>
				<th width="18%">考试名</th>
				<th width="5%">科目</th>
				<th width="22%">主考单位</th>
				<th width="10%">考试时间</th>
				<th width="11%">报名开始时间</th>
				<th width="11%">报名截止时间</th>
				<th width="7%">报名费</th>
				<th width="16%">操作</th>
			</tr>
			<c:forEach items="${testinfoList }" var="testinfo">
				<tr>
					<td>${testinfo.tname }</td>
					<td>${testinfo.tsubject }</td>
					<td>${testinfo.torganizer }</td>
					<td>${testinfo.test_time }</td>
					<td>${testinfo.regist_start_time }</td>
					<td>${testinfo.regist_end_time }</td>
					<td>${testinfo.tprice }元</td>
					<td><a
						href="adminTestinfoRoom/selectTestinfoRoom?testinfo_id=${testinfo.testinfo_id }">考场详情</a>
						<a
						href="adminTestinfo/toUpdateTestinfo?testinfo_id=${testinfo.testinfo_id }">修改</a>
						<a onclick="return confirmDelTestinfo();"
						href="adminTestinfo/deleteTestinfo?testinfo_id=${testinfo.testinfo_id }">删除</a>
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