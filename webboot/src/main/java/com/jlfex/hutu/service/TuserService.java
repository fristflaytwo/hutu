package com.jlfex.hutu.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jlfex.hutu.dao.jpa.TuserDao;
import com.jlfex.hutu.entity.Tuser;
import com.jlfex.hutu.vo.TuserForm;


@Service
public class TuserService {
	@Autowired
	private TuserDao tuserDao;
	
	/**
	 * 保存用户
	 * @param form
	 * @return
	 */
	@Transactional
	public Tuser saveTuser(TuserForm form){
		Tuser user=new Tuser();
		BeanUtils.copyProperties(form,user);
		user=this.tuserDao.save(user);
		return user;
	}
	
	/**
	 * 根据用户编号查询用户信息
	 * @param code
	 * @return
	 */
	public Tuser queryTuserByUserCode(String userCode){
		return this.tuserDao.findByUserCode(userCode);
	}
	
	
}
