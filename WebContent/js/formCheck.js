// JavaScript Document

window.onload=function() {
    var tbl = document.getElementById("table"); // 先获取table
    var rows = tbl.getElementsByTagName("tr"); // 获取里面的行tr
    rows[0].style.backgroundColor="rgba(68,114,196,0.90)";
    rows[0].style.color="#FFF";
    for(i=1;i<rows.length;i++) { // 遍历里面的行
       if(i%2==0){ // 再通过取模来设置每行显示不同的两种颜色
        rows[i].style.backgroundColor="rgba(255,255,255,0.6)";
       }else{
        rows[i].style.backgroundColor="rgba(217,226,243,0.6)";
       } 
    }
}

function testinfoConfirm(){
	var info="请最后确认信息：\n1.aaa\n2.bbb\n3.ccc"
	if(!confirm(info)){
		window.event.returnValue = false;
	}
	else{
		
	}
	document.forms[0].submit();
}

function checkDel(){
	if(!confirm("确认要删除？")){
	  	window.event.returnValue = false;
	}
}

function checkDelDouble(){
	if(!confirm("确认要彻底删除？")){
		window.event.returnValue = false;
	}
	else{
		checkDel();
	}
}

//function doInputTest(){
//	var rname = document.getElementById("rname").value;
//	var location = document.getElementById("location").value;
//	var itime = document.getElementById("itime").value;
//	var istime = document.getElementById("istime").value;
//	var ietime = document.getElementById("ietime").value;
//	var quota = document.getElementById("quota").value;
//	var rphonenumber = document.getElementById("rphonenumber").value;
//	var postcode = document.getElementById("postcode").value;
//	if(rname == "" || location == "" || itime == "" || istime == "" || ietime == "" || quota == "" || rphonenumber == "" || postcode == ""){
//		alert("带有*的内容不能为空");
//		return false;
//	}
//	else if(!isDate(itime) || !isDate(istime) || !isDate(ietime)){
//		alert("请输入正确的时间格式（如 2020-07-05 10:00:01）");
//		return false;
//	}
//	else if(!isInteger(quota)){
//		alert("请输入一个正整数名额");
//		return false;
//	}
//	return true;
//}

//function doInputBuser(){
//	var uphonenumber = document.getElementById("uphonenumber").value;
//	var uname = document.getElementById("uname").value;
//	var upwd = document.getElementById("upwd").value;
//	var upwd2 = document.getElementById("upwd2").value;
//	if(upwd!=upwd2){
//		alert("两次输入的密码不一致");
//		return false;
//	}
//	else if(uphonenumber == "" || uname == "" || upwd == "" || upwd2 == ""){
//		alert("带有*的内容不能为空");
//		return false;
//	}
//	else if(uphonenumber.length!=11){
//		alert("请输入正确的11位手机号");
//		return false;
//	}
//	return true;
//}
