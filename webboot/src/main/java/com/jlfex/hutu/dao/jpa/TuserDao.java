package com.jlfex.hutu.dao.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jlfex.hutu.entity.Tuser;

@Repository
public interface TuserDao extends CrudRepository <Tuser,Integer> {
	
	/**
	 * 根据用户编号查询用户
	 * @param userCode
	 * @return
	 */
	@Query("from Tuser t where t.userCode=?1")
	public Tuser findByUserCode(String userCode);
	
	/**
	 * 根据性别查询用户集合
	 * @param userSex
	 * @return
	 */
	public List<Tuser> findByUserSex(String userSex);
	
}
