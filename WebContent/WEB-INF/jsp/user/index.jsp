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
</head>
<body id="mainBody">
	<div id="container">
		<div id="header">
			<ul>
				<li id="headline">欢迎光临中国外国语能力考试报名网</li>
				<c:if test="${sessionScope.user != null }">
					<li class="r">
						<div id="headline">
							<div id="selectbar">
								<ul>
									<li><a>考生：${sessionScope.user.uname }</a>
										<ul>
											<li><a href="user/exit" target="center">退出登录</a></li>
										</ul></li>
								</ul>
							</div>
						</div>
					</li>
				</c:if>
				<c:if test="${sessionScope.user == null }">
					<li class="r"><a href="user/toRegister">注册</a></li>
					<li class="r"><a href="user/toLogin">登录</a></li>
				</c:if>
			</ul>
		</div>
		<div id="logo"></div>
		<div id="navigator">
			<div id="selectbar">
				<ul>
					<li><a>考试概况</a>
						<ul>
							<li><a
								href="userTestinfo/selectTestinfo?user_id=${sessionScope.user.user_id }"
								target="center">考试查询</a></li>
							<li><a
								href="userTestinfo/selectTestinfo?user_id=${sessionScope.user.user_id }"
								target="center">考试报名</a></li>
						</ul></li>
				</ul>
				<ul>
					<li><a>报名详情</a>
						<ul>
							<li><a
								href="userTestinfo/selectTestinfo?user_id=${sessionScope.user.user_id }"
								target="center">报名步骤</a></li>
							<li><a
								href="userTestinfo/selectTestinfo?user_id=${sessionScope.user.user_id }"
								target="center">考生须知</a></li>
						</ul></li>
				</ul>
				<ul>
					<li><a href="userNotice/selectNotice" target="center">查看公告</a></li>
				</ul>
				<ul>
					<li><a>个人中心</a>
						<ul>
							<li><a
								href="userTestinfo/selectTestinfo?user_id=${sessionScope.user.user_id }"
								target="center">报名记录</a></li>
							<li><a
								href="userTestinfo/selectTestinfo?user_id=${sessionScope.user.user_id }"
								target="center">修改照片</a></li>
							<li><a
								href="userTestinfo/selectTestinfo?user_id=${sessionScope.user.user_id }"
								target="center">修改密码</a></li>
							<li><a
								href="userTestinfo/selectTestinfo?user_id=${sessionScope.user.user_id }">退出登录</a></li>
						</ul></li>
				</ul>
			</div>
		</div>
		<div id="content">
			<c:if test="${sessionScope.user != null }">
				<iframe src="userCenter/center" name="center"></iframe>
			</c:if>
			<c:if test="${sessionScope.user == null }">
				<iframe src="userNotice/selectNotice" name="center"></iframe>
			</c:if>
		</div>
		<div id="footer">©版权属于大连外国语大学18级软件7班邓淞文</div>
	</div>
	<c:if test="${msg != null }">
		<script type="text/javascript">
			alert("${msg}");
		</script>
	</c:if>
</body>
</html>