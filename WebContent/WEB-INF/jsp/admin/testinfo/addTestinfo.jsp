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
</head>
<script type="text/javascript">
	window.onload = function() {
		showDetail()
	}
	function showDetail() {
		var tbl = document.getElementById("testData"); // 先获取table
		var rows = tbl.getElementsByTagName("tr"); // 获取里面的行tr
		var detailData = new Array();
		for (i = 0; i < rows.length; i++) {
			detailData[i * 4] = rows[i].cells[0].innerHTML;
			detailData[i * 4 + 1] = rows[i].cells[1].innerHTML;
			detailData[i * 4 + 2] = rows[i].cells[2].innerHTML;
			detailData[i * 4 + 3] = rows[i].cells[3].innerHTML;
		}
		var myId = document.getElementById("test_id");
		for (i = 0; i < detailData.length; i = i + 4) {
			if (detailData[i] == myId.value) {
				document.getElementById('tsubject').value = detailData[i + 1];
				document.getElementById('torganizer').value = detailData[i + 2];
				document.getElementById('tname').value = detailData[i + 3];
			}
		}
	}
</script>
<body>
	<table style="display: none;" id="testData">
		<c:forEach items="${testList }" var="test">
			<tr>
				<td>${test.test_id }</td>
				<td>${test.tsubject }</td>
				<td>${test.torganizer }</td>
				<td>${test.tname }</td>
			</tr>
		</c:forEach>
	</table>
	<form:form action="adminTestinfo/toAddTestinfoRoom" method="post"
		modelAttribute="testinfoRoom">
		<input type="hidden" id="tname" name="tname"
			value="${testList.get(0).tname }">
		<table>
			<caption>发布考试</caption>
			<tr>
				<td colspan="2">请选择您要发布的考试<font color="red">*</font></td>
				<td><form:select path="test_id" onchange="showDetail()">
						<!-- 前台选择的内容，会给test_id变量传到后台，itemLabel控制展示数据，itemValue控制传输数据 -->
						<form:options items="${testList }" itemLabel="tname"
							itemValue="test_id" />
					</form:select></td>
			</tr>
			<tr>
				<td colspan="2">考试科目</td>
				<td><form:input path="tsubject" id="tsubject"
						readonly="readonly" /></td>
			</tr>
			<tr>
				<td colspan="2">主考单位</td>
				<td><form:input path="torganizer" id="torganizer"
						readonly="readonly" /></td>
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
				<td colspan="2">请选择考场<font color="red">*</font></td>
				<td><c:forEach items="${roomList }" var="room">
						<tr>
							<td><form:checkbox path="room_ids" value="${room.room_id }" /></td>
							<td>${room.rname }</td>
						</tr>
					</c:forEach></td>
			</tr>
			<tr>
				<td colspan="2">&nbsp;</td>
				<td style="text-align: right"><input type="submit"
					value="前往为考场配置名额" /></td>
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