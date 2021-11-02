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
</head>
<body>
	<c:if test="${allTestinfo.size() == 0 }">
		还没有发布考试。
	</c:if>
	<c:if test="${allTestinfo.size() != 0 }">
		请选择要报名的考试
		<table border=1 id="user_testinfo_table">
			<tr>
				<th width="30%">考试名</th>
				<th width="10%">科目</th>
				<th width="30%">考试时间</th>
				<th width="10%">报名费</th>
				<th width="20%">操作</th>
			</tr>
			<c:forEach items="${sessionScope.allTestinfo }" var="testinfo">
				<tr>
					<td>${testinfo.tname }</td>
					<td>${testinfo.tsubject }</td>
					<td>${testinfo.test_time }</td>
					<td>${testinfo.tprice }</td>
					<td>
						<c:if test="${testinfo.status == 1 }">
							<a href="userReginfo/userSelectTestinfoRoom?testinfo_id=${testinfo.testinfo_id }">前往报名</a>
						</c:if>
						<c:if test="${testinfo.status == 0 }">
							已报名，<a href="userReginfo/userSelectAReginfo?user_id=${sessionScope.buser.user_id }&testinfo_id=${testinfo.testinfo_id }">查看准考证</a>
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