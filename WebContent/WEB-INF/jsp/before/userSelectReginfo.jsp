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
<script type="text/javascript">
function cancelConfirm(reginfo_id){
	if(confirm("确认要取消报名？")){
		window.location.href="userReginfo/userCancelReginfo?reginfo_id=" + reginfo_id
	}
}
</script>
</head>
<body>
	<c:if test="${allReginfo.size() == 0 }">
		还没有报名考试，<a href="userReginfo/userSelectTestinfo">点击前往报名</a>
	</c:if>
	<c:if test="${allReginfo.size() != 0 }">
		<table border=1>
			<tr>
				<th width="20%">考试名称</th>
				<th width="20%">考试时间</th>
				<th width="20%">考点名称</th>
				<th width="20%">准考证号</th>
				<th width="20%">操作</th>
			</tr>
			<c:forEach items="${allReginfo }" var="reginfo">
				<tr>
					<td>${reginfo.tname }</td>
					<td>${reginfo.test_time }</td>
					<td>${reginfo.rname }</td>
					<td>${reginfo.ticketnum }</td>
					<td>
						<a href="userReginfo/userSelectAReginfo?user_id=${sessionScope.buser.user_id }&testinfo_id=${reginfo.testinfo_id }">查看详细信息</a>
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