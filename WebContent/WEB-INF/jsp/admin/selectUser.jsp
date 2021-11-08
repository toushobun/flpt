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
	<form action="adminUser/searchUser" method="post">
		<input type="text" name="keyWord"/>
		<input type="submit" value="搜索"/>
	</form>
	<c:if test="${allUser.size() == 0 }">
		未查询到结果
	</c:if>
	<c:if test="${allUser.size() != 0 }">
		<table border=1>
			<tr>
				<th style="display: none;">ID</th>
				<th width="30%">身份证号码</th>
				<th width="30%">密码</th>
				<th width="30%">考生姓名</th>
				<th width="10%">操作</th>
			</tr>
			<c:forEach items="${allUser }" var="buser">
				<tr>
					<td style="display: none;">${buser.user_id }</td>
					<td>${buser.uidnum }</td>
					<td>${buser.upwd }</td>
					<td>${buser.uname }</td>
					<td>
						<c:if test="${buser.uidphoto != null }">
							<a href="#">查看照片</a>
						</c:if>
						<c:if test="${buser.uidphoto == null }">
							未上传照片
						</c:if>
						<a onclick="return checkDel();" href="adminUser/deleteUser?user_id=${buser.user_id }">删除</a>
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