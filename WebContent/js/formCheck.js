// JavaScript Document

function checkTestinfo(f) {
	var mssg = "请确认您要新增考场的考试\n考试名：" + f.tname.value + "\n考试科目："
			+ f.tsubject.value + "\n主考单位：" + f.torganizer.value + "\n考试时间："
			+ f.test_time.value + "\n报名开始时间：" + f.regist_start_time.value
			+ "\n报名截止时间：" + f.regist_end_time.value + "\n报名费用："
			+ f.tprice.value + "元\n";
	return confirm(mssg)
}

function checkBuser(f) {
	if (f.uidnum.value == "") {
		alert("身份证号码不能为空！");
		return false;
	} else if (f.uname.value == "") {
		alert("考生姓名不能为空！");
		return false;
	} else if (f.upwd.value == "" || f.upwd2.value == "") {
		alert("密码不能为空！");
		return false;
	} else if (f.logoImage.value == "") {
		alert("请上传您的照片！");
		return false;
	} else if (!/\.(gif|jpg|jpeg|png|GIF|JPG|PNG)$/.test(f.logoImage.value)) {
		alert("图片类型必须是.gif,jpeg,jpg,png中的一种");
		return false;
	}

	var mssg = "请确认您要新增考场的考试\n考试名：" + f.tname.value + "\n考试科目："
			+ f.tsubject.value + "\n主考单位：" + f.torganizer.value + "\n考试时间："
			+ f.test_time.value + "\n报名开始时间：" + f.regist_start_time.value
			+ "\n报名截止时间：" + f.regist_end_time.value + "\n报名费用："
			+ f.tprice.value + "元\n"
	return confirm(mssg)
}
