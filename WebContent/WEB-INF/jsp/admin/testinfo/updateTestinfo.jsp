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
<link href="css/box.css" type="text/css" rel="stylesheet">
<script src="js/buttonAction.js" type="text/javascript"></script>
<script src="js/formCheck.js" type="text/javascript"></script>
<script src="js/postConfirm.js" type="text/javascript"></script>
</head>
<body>
	<form:form action="adminTestinfo/updateTestinfo" method="post"
		modelAttribute="testinfo">
		<form:hidden path="testinfo_id" />
		<table>
			<caption>修改考试信息</caption>
			<tr>
				<td colspan="2">请选择您要发布的考试<font color="red">*</font></td>
				<td><form:select path="test_id">
						<form:option label="${testinfo.tname }"
							value="${testinfo.test_id }" />
					</form:select></td>
			</tr>
			<tr>
				<td colspan="2">考试科目</td>
				<td><form:input path="tsubject" readonly="readonly" /></td>
			</tr>
			<tr>
				<td colspan="2">主考单位</td>
				<td><form:input path="torganizer" readonly="readonly" /></td>
			</tr>
			<tr>
				<td colspan="2">考试时间<font color="red">*</font></td>
				<td><form:input path="test_time" placeholder="请输入考试时间" /></td>
			</tr>
			<tr>
				<td colspan="2">报名开始时间<font color="red">*</font></td>
				<td><form:input path="regist_start_time"
						placeholder="请输入报名开始时间" /></td>
			</tr>
			<tr>
				<td colspan="2">报名截止时间<font color="red">*</font></td>
				<td><form:input path="regist_end_time" placeholder="请输入报名截止时间" />
				</td>
			</tr>
			<tr>
				<td colspan="2">报名费用<font color="red">*</font></td>
				<td><form:input path="tprice" placeholder="请输入报名费用" /></td>
			</tr>
			<tr>
				<td colspan="2">&nbsp;</td>
				<td style="text-align: right"><input type="submit" value="提交" />
				</td>
			</tr>
		</table>
		<c:if test="${msg != null }">
			<script type="text/javascript">
				alert("${msg}");
			</script>
		</c:if>
	</form:form>
</body>
</html>