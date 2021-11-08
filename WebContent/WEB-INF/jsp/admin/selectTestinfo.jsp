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
	<c:if test="${allTestinfo.size() == 0 }">
		未查询到结果
	</c:if>
	<c:if test="${allTestinfo.size() != 0 }">
		<form action="adminTestinfo/searchTestinfo" method="post">
			<input type="text" name="keyWord"/>
			<input type="submit" value="搜索"/>
		</form>
		<table border=1>
			<tr>
				<th width="20%">考试名</th>
				<th width="5%">科目</th>
				<th width="28%">主考单位</th>
				<th width="9%">考试时间</th>
				<th width="9%">报名开始时间</th>
				<th width="9%">报名截止时间</th>
				<th width="5%">报名费</th>
				<th width="15%">操作</th>
			</tr>
			<c:forEach items="${allTestinfo }" var="testinfo">
				<tr>
					<td>${testinfo.tname }</td>
					<td>${testinfo.tsubject }</td>
					<td>${testinfo.torganizer }</td>
					<td>${testinfo.test_time }</td>
					<td>${testinfo.regist_start_time }</td>
					<td>${testinfo.regist_end_time }</td>
					<td>${testinfo.tprice }</td>
					<td>
						<a href="adminTestinfo/selectTestinfoRoom?testinfo_id=${testinfo.testinfo_id }">考场详情</a>
						<a href="adminTestinfo/toUpdateTestinfo?testinfo_id=${testinfo.testinfo_id }">修改</a>
						<a onclick="return checkDel();" href="adminTestinfo/deleteTestinfo?testinfo_id=${testinfo.testinfo_id }">删除</a>
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