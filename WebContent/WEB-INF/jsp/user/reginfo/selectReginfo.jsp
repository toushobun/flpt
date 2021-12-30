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
<script src="js/buttonAction.js" type="text/javascript"></script>
<script src="js/formCheck.js" type="text/javascript"></script>
<script src="js/postConfirm.js" type="text/javascript"></script>
<script src="js/colorControl.js" type="text/javascript"></script>
</head>
<body>
	<form:form id="searchForm" action="userReginfo/searchReginfo"
		method="post" modelAttribute="reginfo">
		<form:input path="tname" placeholder="输入考试名" value="${reginfo.tname }" />
		<form:input path="uname" placeholder="输入考生姓名"
			value="${reginfo.uname }" />
		<form:input path="rname" placeholder="输入考点名" value="${reginfo.rname }" />
		<form:checkboxes path="statuss" items="${statuss}" />
		<input type="submit" value="搜索" />
		<input type="button" value="清空" onclick="emptyInput('searchForm');" />
	</form:form>
	<c:if test="${reginfoList.size() == 0 }">
		未查询到结果
	</c:if>
	<c:if test="${reginfoList.size() != 0 }">
		<table id="table">
			<tr>
				<th width="10%">考试名称</th>
				<th width="10%">准考证号</th>
				<th width="10%">考点名称</th>
				<th width="20%">考试时间</th>
				<th width="10%">报名状态</th>
				<th width="20%">报名时间</th>
				<th width="15%">操作</th>
			</tr>
			<c:forEach items="${reginfoList }" var="reginfo">
				<tr>
					<td>${reginfo.tname }</td>
					<td>${reginfo.ticketnum }</td>
					<td>${reginfo.rname }</td>
					<td>${reginfo.test_time }</td>
					<c:if test="${reginfo.status==0 }">
						<td>未支付</td>
					</c:if>
					<c:if test="${reginfo.status==1 }">
						<td>已支付</td>
					</c:if>
					<c:if test="${reginfo.status==2 }">
						<td>已取消</td>
					</c:if>
					<c:if test="${reginfo.status==3 }">
						<td>支付超时</td>
					</c:if>
					<td>${reginfo.submit_time }</td>
					<c:if test="${reginfo.status==0 || reginfo.status==1 }">
						<td><a
							href="userReginfo/selectAReginfo?reginfo_id=${reginfo.reginfo_id }">查看详情</a>&nbsp;
							<a onclick="return confirmDel();"
							href="userReginfo/deleteReginfo?reginfo_id=${reginfo.reginfo_id }&user_id=${sessionScope.user.user_id }">删除</a></td>
					</c:if>

					<c:if test="${reginfo.status==2 || reginfo.status==3 }">
						<td><a onclick="return confirmDel();"
							href="userReginfo/deleteReginfo?reginfo_id=${reginfo.reginfo_id }&user_id=${sessionScope.user.user_id }">删除</a></td>
					</c:if>
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