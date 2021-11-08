<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<title>Insert title here</title>
<script src="js/formCheck.js" type="text/javascript"></script>
</head>
<script type="text/javascript">
	window.onload=function(){
		showDetail()
	}
	function showDetail(){
	    var tbl = document.getElementById("testData"); // 先获取table
	    var rows = tbl.getElementsByTagName("tr"); // 获取里面的行tr
		var detailData = new Array();
		for(i=0;i<rows.length;i++){
			detailData[i*4] = rows[i].cells[0].innerHTML;
			detailData[i*4+1] = rows[i].cells[1].innerHTML;
			detailData[i*4+2] = rows[i].cells[2].innerHTML;
			detailData[i*4+3] = rows[i].cells[3].innerHTML;
		}
		var myId = document.getElementById("test_id");
		for(i=0;i<detailData.length;i=i+4){
			if(detailData[i] == myId.value){
				window.tsubject=detailData[i+1];
				window.torganizer=detailData[i+2];
				window.tname=detailData[i+3];
			}
		}
	}
	function testinfoCheck(){
		var mssg = "请最终确认\n考试名：" + window.tname + "\n考试科目：" + window.tsubject + "\n主考单位：" + window.torganizer + "\n考试时间：${testinfo.test_time }\n报名开始时间：${testinfo.regist_start_time }\n报名截止时间：${testinfo.regist_end_time }\n报名费用：${testinfo.tprice}元"
		return confirm(mssg)
	}
</script>
<body>
	<table style="display:none;" id="testData">
		<c:forEach items="${allTest }" var="test">
			<tr>
				<td>${test.test_id }</td>
				<td>${test.tsubject }</td>
				<td>${test.torganizer }</td>
				<td>${test.tname }</td>
			</tr>
		</c:forEach>
	</table>
	<form:form action="adminTestinfo/addTestinfo" onsubmit="return testinfoCheck()" method="post" modelAttribute="testinfo">
		<input type="hidden" name="test_id" id="test_id" value="${testinfo.test_id }">
		<input type="hidden" name="tname" value="${testinfo.tname }">
		<input type="hidden" name="test_time" value="${testinfo.test_time }">
		<input type="hidden" name="regist_start_time" value="${testinfo.regist_start_time }">
		<input type="hidden" name="regist_end_time" value="${testinfo.regist_end_time }">
		<input type="hidden" name="tprice" value="${testinfo.tprice }">
		<table>
			<caption>考场名额配置</caption>
			<tr>
				<td>
					<c:forEach items="${selectedRoom }" var="room">
						<tr>
							<form:hidden path="room_ids" value="${room.room_id }"/>
							<td>${room.rname }<font color="red">*</font></td>
							<td><form:input path="room_rquotas" placeholder="请输入该考场可报名名额"/></td>
						</tr>
					</c:forEach>
				</td>
			</tr> 	
			<tr>
				<td style="text-align: left">
					<input type="button" onclick="window.history.back()" value="返回"/>
				</td>
				<td style="text-align: right">
					<input type="submit" value="提交"/>
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