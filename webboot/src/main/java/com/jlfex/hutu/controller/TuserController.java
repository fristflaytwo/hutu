package com.jlfex.hutu.controller;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jlfex.hutu.entity.Tuser;
import com.jlfex.hutu.service.TuserService;
import com.jlfex.hutu.vo.TuserForm;




@Controller
@EnableAutoConfiguration
@RequestMapping("/user")
public class TuserController {

	@Autowired
	private TuserService tuserService;
	
	/**
	 * 跳转增加用户页面
	 * @return
	 */
	@RequestMapping("/userSave_pre")
	public String userSavePre() {
		return "user_add";
	}
	
	/**
	 * 保存用户信息
	 * @return
	 */
	@RequestMapping("/userSave")
	public void userSave(TuserForm form,HttpServletResponse res) {
		try {
			this.tuserService.saveTuser(form);
			res.sendRedirect("/user/userSave_pre");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 跳转增加用户页面
	 * @return
	 */
	@RequestMapping("/userShow_pre")
	public String userShowPre(Model model) {
		Tuser user=this.tuserService.queryTuserByUserCode("444");
		TuserForm form=new TuserForm();
		BeanUtils.copyProperties(user,form);
		model.addAttribute("data", form);
		return "user_add";
	}
	
	
	/**
	 * 返回页面并传递结果值测试，采用map的方式
	 * @param model
	 * @return
	 */
	/*@RequestMapping("/test2")
	public String test2(Map<String, Object> model) {
		List<RtCusBusi> list=this.rtCusBusiService.findByDealDateAndCustId();
		model.put("data", list);
		return "rtcusbusi";
	}*/
	
	/**
	 * 返回碎片页面并返回结果值测试，采用map的方式
	 * @param model
	 * @return
	 */
	/*@RequestMapping("/test3")
	public String test3(Map<String, Object> map) {
		List<RtCusBusi> list=this.rtCusBusiService.findByDealDateAndCustIdList();
		map.put("data", list);
		return "chip/rtcusbusi_chip";
	}*/
	
	
	/**
	 * 通过request传值并返回json测试
	 * @return
	 */
	/*@RequestMapping("/test4")
	@ResponseBody
	public String test4(HttpServletRequest req) {
		String name=req.getParameter("name");
		return name;
	}*/
	
	
	/**
	 * 通过request设置值到页面此方式不行，需要用model
	 * @return
	 */
	/*@RequestMapping("/test5")
	public String test5(HttpServletRequest req,Model model) {
		List<RtCusBusi> list=this.rtCusBusiService.findByDealDateAndCustId();
		model.addAttribute("data", list);
		return "rtcusbusi";
	}*/
	
	
	/**
	 * 通过form方式从页面取值，并将值返回到碎片页面
	 * @param model
	 * @return
	 */
	/*@RequestMapping("/test6")
	public String test6(RtCusBusiForm form,Model model) {
		model.addAttribute("userInfo", form);
		return "rtcusbusi_user_info";
	}*/
	
	
	/**
	 * 测试重定向
	 * @param model
	 * @return
	 */
	/*@RequestMapping("/test7")
	public void test7(RtCusBusiForm form,Model model,HttpServletResponse res) {
		try {
			model.addAttribute("userInfo", form);
			res.sendRedirect("/user/test3");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}*/
	
	/**
	 * 表单之中存在上传文件
	 * @param model
	 * @return
	 */
	/*@RequestMapping("/test8")
	public void test8(RtCusBusiForm form,@RequestParam("file") MultipartFile file,HttpServletResponse res) {
		try {
			byte[] bytes = file.getBytes();  
			System.out.println("上传的文件大小：\t"+bytes);
			res.sendRedirect("/user/test3");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}*/

}
