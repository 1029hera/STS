package com.lec.sts10_request.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/member")  //→ /member 로 시작하는 request 만 
public class MemberController {     //    처리하는 컨트롤러 클래스

	@RequestMapping(value = "/save") // URL → /member + /save 
	public String saveMember() {     //        = /member/save
		return "member/save";
	}
	
	@RequestMapping(value = "/load")   //   /member/load
	public String loadMember() {
		return "member/load";
	}
	
	// url mapping 중복되면 에러 
//	@RequestMapping(value = "/search")   // /member/search
//	public String searchMember() {
//		return "member/search";
//	}
	
	// 핸들러 리턴값이 void 이면
	// mapping 되는 url문자열에 해당하는 .jsp 파일로 forwarding 된다
	// (일반적으로 많이 사용)
	@RequestMapping("/remove")
	public void removeMember() {   // URL -> /member/remove
		                           // JSP -> /member/remove.jsp
	}
	
	
}


















