// JavaScript Document

function confirmCancel(testinfoRoom_id, testinfo_id, rname, room_id) {
	if (confirm("确认要取消考场：" + rname + "？该操作会删除所有报名该考场的报名信息，是否继续？")) {
		window.location.href = "adminTestinfoRoom/cancelRoom?testinfoRoom_id="
				+ testinfoRoom_id + "&testinfo_id=" + testinfo_id + "&room_id="
				+ room_id
	}
}

function confirmDel() {
	if (!confirm("确认要删除？")) {
		window.event.returnValue = false;
	}
}

function confirmDelDouble() {
	if (!confirm("确认要彻底删除？")) {
		window.event.returnValue = false;
	} else {
		checkDel();
	}
}

function confirmDelTestinfo() {
	if (!confirm("该操作会删除所有发布考场以及考生报名信息，是否继续？")) {
		window.event.returnValue = false;
	} else {
		confirmDel();
	}
}