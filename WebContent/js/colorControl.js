// JavaScript Document

window.onload = function() {
	var tbl = document.getElementById("table"); // 先获取table
	var rows = tbl.getElementsByTagName("tr"); // 获取里面的行tr
	rows[0].style.backgroundColor = "rgba(68,114,196,0.90)";
	rows[0].style.color = "#FFF";
	for (i = 1; i < rows.length; i++) { // 遍历里面的行
		if (i % 2 == 0) { // 再通过取模来设置每行显示不同的两种颜色
			rows[i].style.backgroundColor = "rgba(255,255,255,0.6)";
		} else {
			rows[i].style.backgroundColor = "rgba(217,226,243,0.6)";
		}
	}
}