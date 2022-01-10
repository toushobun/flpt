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
	<c:if test="${noticeList.size() == 0 }">
        <h2 id="selectResult">未发布公告</h2>
	</c:if>
	<c:if test="${noticeList.size() != 0 }">
		<table id="table">
			<tr>
                <th width="60%">标题</th>
                <th width="30%">时间</th>
                <th width="10%">操作</th>
			</tr>
			<c:forEach items="${noticeList }" var="notice">
				<tr>
					<td>${notice.ntitle }</td>
					<td>${notice.ntime }</td>
					<td><a
						href="userNotice/selectANotice?notice_id=${notice.notice_id }">详情</a>
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