package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.entity.Reginfo;

@Repository("reginfoDao")
@Mapper
public interface ReginfoDao {

	public List<Reginfo> selectReginfoByKwargs(Reginfo reginfo); // 查询准考证

	public void addReginfo(Reginfo reginfo); // 添加准考证

	public void deleteReginfoByReginfo_id(Integer reginfo_id); // 通过id删除准考证

	public void updateReginfo(Reginfo reginfo); // 修改准考证

	public List<Reginfo> selectReginfoFuzzily(Reginfo reginfo); // 模糊查询准考证

}
