package com.service.admin;

import org.springframework.ui.Model;

public interface AdminReginfoService {

	public String selectReginfo(Model model);

	public String deleteReginfo(Integer reginfo_id, Model model);

}
