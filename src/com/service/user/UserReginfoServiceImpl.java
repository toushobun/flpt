package com.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.dao.ReginfoDao;
import com.dao.TestinfoRoomDao;
import com.entity.Reginfo;
import com.entity.TestinfoRoom;
import com.util.MyUtil;

@Service("userReginfoService")
@Transactional
public class UserReginfoServiceImpl implements UserReginfoService {

	@Autowired
	private ReginfoDao reginfoDao;

	@Autowired
	private TestinfoRoomDao testinfoRoomDao;

	@Override
	public String addReginfo(Reginfo reginfo, Model model) {
		// TODO 不能先添加后修改准考证，要直接对准考证进行操作，同时还要减少名额
		try {
			// 如果该考生已报名此考试，则为0，否则为1
			Reginfo reginfoToSelect = new Reginfo();
			reginfoToSelect.setUser_id(reginfo.getUser_id());
			reginfoToSelect.setTestinfo_id(reginfo.getTestinfo_id());
			if (reginfoDao.selectReginfoByKwargs(reginfoToSelect).size() > 0) {
				model.addAttribute("msg", "您已报名！请勿重复操作！");
				return "forward:/userTestinfo/selectTestinfo";
			}
			// 年份后两位+绑定ID后三位+考生ID后三位+随机数四位
			String ticketnum = "";
			reginfoToSelect = new Reginfo();
			// 搜索到存在则重新生成随机数
			while (true) {
				ticketnum = MyUtil.getStringID().substring(2, 4) + String.format("%03d", reginfo.getTestinfoRoom_id())
						+ String.format("%03d", reginfo.getUser_id())
						+ String.format("%04d", Math.round(Math.random() * 9999 + 1));
				reginfoToSelect.setTicketnum(ticketnum);
				if (reginfoDao.selectReginfoByKwargs(reginfoToSelect).size() == 0) {
					break;
				}
			}
			TestinfoRoom testinfoRoomToUpdate = new TestinfoRoom();
			testinfoRoomToUpdate.setTestinfoRoom_id(reginfo.getTestinfoRoom_id());
			Integer rquota = testinfoRoomDao.selectTestinfoRoomByKwargs(testinfoRoomToUpdate).get(0).getRquota();
			if (rquota <= 0) {
				model.addAttribute("msg", "报名失败！名额已满！");
				return "forward:/userTestinfo/selectTestinfo";
			}
			testinfoRoomToUpdate.setRquota(rquota - 1);
			testinfoRoomDao.updateTestinfoRoom(testinfoRoomToUpdate);

			reginfo.setTicketnum(ticketnum);
			reginfo.setStatus(0);
			reginfoDao.addReginfo(reginfo);
			model.addAttribute("msg", "报名成功！");
			return "forward:/userTestinfo/selectTestinfo";
		} catch (Exception e) {
			model.addAttribute("msg", "报名失败！");
			return "forward:/userTestinfo/selectTestinfo";
		}
	}

}
