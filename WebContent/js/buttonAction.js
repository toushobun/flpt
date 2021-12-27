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

function refreshCode() {
	document.getElementById("code").src = "validateCode?" + Math.random();
}
