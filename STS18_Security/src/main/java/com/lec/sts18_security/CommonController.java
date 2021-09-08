package com.lec.sts18_security;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CommonController {
	
	@GetMapping("/accessError")
	public void accessDenied(Authentication auth, Model model) {
		System.out.println("access Denied : " + auth);
		model.addAttribute("msg", "접근 권한 거부");
	}
	
	@GetMapping("/customLogin")
	public void loginInput(String error, String logout, Model model) {
		System.out.println("error: " + error);
		System.out.println("logout: " + logout);
		
		if(error != null) {
			model.addAttribute("error", "로그인 에러, 계정정보 확인해주삼");
		}
		
		if(logout != null) {
			model.addAttribute("logout", "로그아웃!!");
		}
	}
	
	@GetMapping("/customLogout")
	public void logoutGET() {
		System.out.println("GET: custom logout");
	}
	
	@PostMapping("/customLogout")
	public void logoutPost() {
		System.out.println("POST: custom logout");
	}
}
















