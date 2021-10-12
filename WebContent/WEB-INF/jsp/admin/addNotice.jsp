<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<title>Insert title here</title>
</head>
<body>
	<form:form action="adminNotice/addNotice" method="post" modelAttribute="notice">
		<table id="table3">
			<caption>发布公告</caption>
			<tr>
				<td>标题<font color="red">*</font></td>
				<td>
					<input type="text" name="ntitle"/>
				</td>
			</tr>
			<tr>
				<td>内容<font color="red">*</font></td>
				<td>
					<textarea name="ncontent"/></textarea>
				</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td style="text-align: right">
					<input type="submit" value="提交"/>
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>
