package com.lec.sts10_request;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/common")    //   /common 으로 request 가 들어오면
	public String cccmmm() {              //   cccmmm() 핸들러가 수행하고
		return "comn";                    //   /WEB-INF/views/comm.jsp 뷰로 response
	}
	
	@RequestMapping(value = "/member/search")
	public String searchMember() {
		return "member/search";  //   /WEB-INF/views/member/search.jsp 뷰로 response
	}
	
	@RequestMapping(value = "/member/infoView")
	public String infoMember(Model model) {
		model.addAttribute("mbAge", 30);
		model.addAttribute("mbName", "홍길동");
		return "member/info";
	}
	
	@RequestMapping(value = "/member/find")
	public ModelAndView findMember() {
		ModelAndView mv = new ModelAndView();
		
		// 데이터도 담고
		mv.addObject("mbName", "원피스");
		mv.addObject("mbDate", "2021/03/12");
		
		// '뷰' 도 지정
		mv.setViewName("member/find");
		
		return mv;
	}
	
	// 확장자 패턴 사용 가능
	@RequestMapping(value = "/member/**/*.do")
	public String doMember() {
		return "member/doMember";
	}
	
//	
}

















