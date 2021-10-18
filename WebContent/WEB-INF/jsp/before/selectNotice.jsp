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
</head>
<body>
	<c:if test="${allNotices.size() == 0 }">
		还没有发布公告通知。
	</c:if>
	<c:if test="${allNotices.size() != 0 }">
		<table id="table">
			<tr>
				<th width="300px">标题</th>
				<th width="100px">详情</th>
			</tr>
			<c:forEach items="${allNotices }" var="notice">
				<tr>
					<td>${notice.ntitle }</td>
					<td><a href="selectANotice?notice_id=${notice.notice_id }" target="center">详情</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>