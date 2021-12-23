package com.dao;

import org.springframework.ui.Model;

public interface AdminReginfoDao {
	
	public String selectReginfo(Model model);

	public String deleteReginfo(Integer reginfo_id, Model model);
	
}