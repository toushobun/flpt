// JavaScript Document

function emptyInput(id) {
	var myForm = document.getElementById(id);
	if (myForm == undefined) {
		return;
	}
	for (var i = 0; i < myForm.elements.length; i++) {
		if (myForm.elements[i].type == "text") {
			myForm.elements[i].value = "";
		} else if (myForm.elements[i].type == "password") {
			myForm.elements[i].value = "";
		} else if (myForm.elements[i].type == "select-one") {
			myForm.elements[i].options[0].selected = true;
		}
	}
}

function changeQuota(testinfoRoom_id, testinfo_id) {
	var rquota = prompt("请输入更改的名额：")
	if (rquota.indexOf(" ") >= 0 || rquota == "") {
		alert('不能为空')
		return false
	}
	var quota = Number(rquota)
	if (isNaN(quota) || quota < 0 || parseInt(quota) - quota != 0) {
		alert("请输入一个非负整数！")
		return false
	} else {
		window.location.href = "adminTestinfoRoom/changeQuota?testinfoRoom_id="
				+ testinfoRoom_id + "&rquota=" + quota + "&testinfo_id="
				+ testinfo_id
	}
}

function cancelConfirm(testinfoRoom_id, testinfo_id, rname, room_id) {
	if (confirm("确认要取消考场：" + rname + "？")) {
		window.location.href = "adminTestinfoRoom/cancelRoom?testinfoRoom_id="
				+ testinfoRoom_id + "&testinfo_id=" + testinfo_id + "&room_id="
				+ room_id
	}
}

function testinfoCheck() {
	var tb = document.getElementById("testData"); // 先获取table
	var rows = tb.getElementsByTagName("tr"); // 获取里面的行tr
	var mssg = "请最终确认您要新增考场的考试\n考试名：" + rows[0].cells[1].innerHTML + "\n考试科目："
			+ rows[0].cells[2].innerHTML + "\n主考单位："
			+ rows[0].cells[3].innerHTML + "\n考试时间："
			+ rows[0].cells[4].innerHTML + "\n报名开始时间："
			+ rows[0].cells[5].innerHTML + "\n报名截止时间："
			+ rows[0].cells[6].innerHTML + "\n报名费用："
			+ rows[0].cells[7].innerHTML + "元\n"
	return confirm(mssg)
}

function checkDel() {
	if (!confirm("确认要删除？")) {
		window.event.returnValue = false;
	}
}

function checkDelDouble() {
	if (!confirm("确认要彻底删除？")) {
		window.event.returnValue = false;
	} else {
		checkDel();
	}
}

function refreshCode() {
	document.getElementById("code").src = "validateCode?" + Math.random();
}

// function doInputTest(){
// var rname = document.getElementById("rname").value;
// var location = document.getElementById("location").value;
// var itime = document.getElementById("itime").value;
// var istime = document.getElementById("istime").value;
// var ietime = document.getElementById("ietime").value;
// var quota = document.getElementById("quota").value;
// var rphonenumber = document.getElementById("rphonenumber").value;
// var postcode = document.getElementById("postcode").value;
// if(rname == "" || location == "" || itime == "" || istime == "" || ietime ==
// "" || quota == "" || rphonenumber == "" || postcode == ""){
// alert("带有*的内容不能为空");
// return false;
// }
// else if(!isDate(itime) || !isDate(istime) || !isDate(ietime)){
// alert("请输入正确的时间格式（如 2020-07-05 10:00:01）");
// return false;
// }
// else if(!isInteger(quota)){
// alert("请输入一个正整数名额");
// return false;
// }
// return true;
// }

// function doInputBuser(){
// var uphonenumber = document.getElementById("uphonenumber").value;
// var uname = document.getElementById("uname").value;
// var upwd = document.getElementById("upwd").value;
// var upwd2 = document.getElementById("upwd2").value;
// if(upwd!=upwd2){
// alert("两次输入的密码不一致");
// return false;
// }
// else if(uphonenumber == "" || uname == "" || upwd == "" || upwd2 == ""){
// alert("带有*的内容不能为空");
// return false;
// }
// else if(uphonenumber.length!=11){
// alert("请输入正确的11位手机号");
// return false;
// }
// return true;
// }
