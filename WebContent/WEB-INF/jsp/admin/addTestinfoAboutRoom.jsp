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
	function showDetail() {
	    var tbl = document.getElementById("testData"); // 先获取table
	    var rows = tbl.getElementsByTagName("tr"); // 获取里面的行tr
		var detailData = new Array();
		for(i=0;i<rows.length;i++){
			detailData[i*3] = rows[i].cells[0].innerHTML;
			detailData[i*3+1] = rows[i].cells[1].innerHTML;
			detailData[i*3+2] = rows[i].cells[2].innerHTML;
		}
		var myId = document.getElementById("test_id");
		for(i=0;i<detailData.length;i=i+3){
			if(detailData[i] == myId.value){
				document.getElementById('tsubject').value=detailData[i+1];
				document.getElementById('torganizer').value=detailData[i+2];
			}
		}
	}
</script>
<body>
	<table style="display:none;" id="testData">
		<c:forEach items="${sessionScope.allTest }" var="test">
			<tr>
				<td>${test.id }</td>
				<td>${test.tsubject }</td>
				<td>${test.torganizer }</td>
			</tr>
		</c:forEach>
	</table>
	<form:form action="adminTestinfo/addTestinfo" method="post" modelAttribute="testinfo">
		<table>
			<caption>考场名额配置 and 信息确认</caption>
			<tr>
				<td>您要发布的考试<font color="red">*</font></td>
				<td>
					<form:select path="test_id" onfocus="this.defaultIndex=this.selectedIndex;" onchange="this.selectedIndex=this.defaultIndex;">
         				<form:options items="${sessionScope.allTest }" itemLabel="tname" itemValue="id"/>
   					</form:select>
				</td>
			</tr>
			<tr>
				<td>考试科目</td>
				<td><input type="text" id="tsubject" readonly="readonly"></td>
			</tr>
			<tr>
				<td>主考单位</td>
				<td><input type="text" id="torganizer" readonly="readonly"></td>
			</tr>
			<tr>
				<td>考试时间<font color="red">*</font></td>
				<td>
					<input type="text" name="test_time" readonly="readonly" value="${testinfo.test_time }"/>
				</td>
			</tr>
			<tr>
				<td>报名开始时间<font color="red">*</font></td>
				<td>
					<input type="text" name="regist_start_time" readonly="readonly" value="${testinfo.regist_start_time }"/>
				</td>
			</tr>
			<tr>
				<td>报名截止时间<font color="red">*</font></td>
				<td>
					<input type="text" name="regist_end_time" readonly="readonly" value="${testinfo.regist_end_time }"/>
				</td>
			</tr>
			<tr>
				<td>报名费用<font color="red">*</font></td>
				<td>
					<input type="text" name="tprice" readonly="readonly" value="${testinfo.tprice }"/>
				</td>
			</tr>
			<tr>
				<td><br></td>
				<td><br></td>
			</tr>
			<tr>
				<td>请配置考场名额</td>
				<td>
					<c:forEach items="${selectedRoom }" var="room">
						<tr>
							<form:hidden path="room_ids" value="${room.id }"/>
							<td>${room.rname }<font color="red">*</font></td>
							<td><form:input path="room_rquotas" placeholder="请输入该考场可报名名额"/></td>
						</tr>
					</c:forEach>
				</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
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