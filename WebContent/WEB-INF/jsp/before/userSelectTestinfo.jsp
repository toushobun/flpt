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
		<table border=1>
			<caption>请选择要报名的考试</caption>
			<tr>
				<th width="20%">考试名</th>
				<th width="20%">考试时间</th>
				<th width="20%">报名费用</th>
				<th width="10%">操作</th>
			</tr>
			<c:forEach items="${allTestinfo }" var="testinfo">
				<tr>
					<td>${testinfo.tname }</td>
					<td><script>document.write("${testinfo.test_time}".substring(0, 19));</script></td>
					<td>${testinfo.tprice }</td>
					<td>
						<c:if test="${testinfo.status == 1 }">
							<a href="userTicket/toAddTicket?i_id=${testinfo.id }">报名</a>
						</c:if>
						<c:if test="${testinfo.status == 0 }">
							名额已满
						</c:if>
						<c:if test="${testinfo.status == -1 }">
							不在报名时间
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