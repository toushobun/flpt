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
<script src="http://libs.baidu.com/jquery/1.11.3/jquery.min.js"></script>
</head>
<body>
	<c:if test="${allTestinfo.size() == 0 }">
		还没有发布考试。
	</c:if>
	<c:if test="${allTestinfo.size() != 0 }">
		请选择要报名的考试
		<form action="userReginfo/userSearchTestinfo" method="post">
			<input type="text" name="keyWord"/>
			<input type="submit" value="搜索"/>
		</form>
		<table border=1>
			<tr>
				<th width="25%">考试名</th>
				<th width="5%">科目</th>
				<th width="25%">考试时间</th>
				<th width="5%">报名费</th>
				<th width="25%">考场名</th>
				<th width="15%">操作</th>
			</tr>
			<c:forEach items="${allTestinfo__Room }" var="testinfo__room">
				<tr>
					<td>${testinfo__room.tname }</td>
					<td>${testinfo__room.tsubject }</td>
					<td>${testinfo__room.test_time }</td>
					<td>${testinfo__room.tprice }</td>
					<td>${testinfo__room.rname }</td>
					<td>
						<c:if test="${testinfo__room.status == 1 }">
							<a href="userTicket/toAddTicket?i_id=${testinfo__room.testinfo__room_id }">报名</a>
						</c:if>
						<c:if test="${testinfo__room.status == 0 }">
							名额已满
						</c:if>
						<c:if test="${testinfo__room.status == -1 }">
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