package org.boot.city.controller;

import javax.servlet.http.HttpSession;

import org.boot.city.entity.AdminModel;
import org.boot.city.entity.Msg;
import org.boot.city.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private SysUserService userService;

	@RequestMapping("/user")
	@ResponseBody
	public AdminModel user(HttpSession session) {

		return (AdminModel) session.getAttribute("user");
	}
	
	@RequestMapping("/code")
	@ResponseBody
	public Msg code(HttpSession session,String code) {

		String verifyCode = (String) session.getAttribute("verifyCode");
		Msg msg = new Msg();
		
		if(!verifyCode.toUpperCase().equals(code.toUpperCase())) {
			msg.setCode(1);
			msg.setMsg("��֤�����");
		}else {
			msg.setCode(0);
			msg.setMsg("��֤����ȷ");
		}
		
		return msg;
	}
	
	@RequestMapping("/changePwd")
	@ResponseBody
	public Msg changePwd(String oldPassword,String repassword,HttpSession session) {
		
		AdminModel model = (AdminModel) session.getAttribute("user");
		String name = model.getData().getName();
		String pwd = userService.selectPwdByName(name);
		
		Msg msg = new Msg();
		if(oldPassword.equals(pwd)) {
			int result = userService.updatePwdByName(name, repassword);
			if(result==1) {
				msg.setCode(0);
				msg.setMsg("�޸ĳɹ�,�����µ�¼");
			}else {
				msg.setCode(1);
				msg.setMsg("�޸�ʧ��");
			}
		}else {
			msg.setCode(2);
			msg.setMsg("����������ȷ�ĵ�¼����");
		}
		
		return msg;
	}
	
	
}
