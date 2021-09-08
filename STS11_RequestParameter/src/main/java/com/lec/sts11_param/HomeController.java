package com.lec.sts11_param;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lec.beans.WriteDTO;

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
	
	// parameter 추출 가능
	// handler 메소드에 서블릿에서 보았던 HttpServletRequest, HttpServletResponse 등의 매개변수 가능
	// request → /member/delete?id=20  
	@RequestMapping(value = "/member/delete")
//	@RequestMapping(value = "/member/delete", method=RequestMethod.POST)  // POST 방식처리인데 GET 방식 request 하면 405에러
//	public void delMember(HttpServletRequest request, Model model) {
	public void delMember(Model model, HttpServletRequest request) {
		String id = request.getParameter("id"); 
		model.addAttribute("mbId", id);
	}
	
	// 기본적으로 method = RequestMethod.GET
	// 만약 method = RequestMethod.POST 로 하면 GET 방식으로는 request 불가
	// 브라우저에서 http://localhost:8080/sts10_request/member/regOk --> 405 에러
	// 콘솔에 WARN 도 뜸.
//	@RequestMapping(value = "/member/regOk", method=RequestMethod.POST)
	@PostMapping("/member/regOk")
	public void registPost() {
		System.out.println("/member/regOk : POST");
	}

//	@RequestMapping(value = "/member/regOk", method=RequestMethod.GET)
	@GetMapping("/member/regOk")
	public void registGet() {
		System.out.println("/member/regOk : GET");
	}
	
	@RequestMapping("/member/regist")
	public void registMember() {}
	
	// GET, POST 둘다 받기
	@RequestMapping(value = "/member/regOk2", method= {RequestMethod.GET, RequestMethod.POST})
	public String regOkMember2() {
		return "member/regOk";
	}
	
	@PutMapping("/member/regOk")
	public void registPut() {
		System.out.println("/member/regOk : PUT");
	}
	
	@DeleteMapping("/member/regOk")
	public void registDelete() {
		System.out.println("/member/regOk : DELETE");
	}
	
	
	// 같은 이름(name) 의 매개변수에 request parameter 를 받아옴.
	@RequestMapping("/member/find")
//	public void findMember(String id, String name, Model model) {
	
	// 매개변수 순서가 달라도 동작한다.
//	public void findMember(String name, Model model, String id) {
	
	
	// 매개변수가 숫자 타입이면 바로 parsing 하여 받을수 있다.
//	public void findMember(double id, String name, Model model) {
//		model.addAttribute("id", id);
//		model.addAttribute("name", name);
//	}
	
	// 동일한 name 의 parameter (들) --> '배열' 매개변수로 받을수 있다.
//	public void findMember(int [] id, String [] name, Model model) {
//		model.addAttribute("id", Arrays.toString(id));
//		model.addAttribute("name", Arrays.toString(name));
//	}
	
	// 만약 request parameter 의 name 과 매개변수가 같을수 없는 상황이면 
	// @RequestParam 애노테이션 사용
//	public void findMember(Model model,
//			@RequestParam("id") String userid,
//			@RequestParam("name") String username
//			) {
//		model.addAttribute("id", userid);
//		model.addAttribute("name", username);
//	}
	
	// 위의 경우 id 값이 없거나 변환 불가능하면 에러 발생한다.
	// @RequestParam(value="test", required=false, defaultValue="0") 을 이용하면 가능하긴 하다.		
	// 또한, @RequestParam 과 Map<name, value> 을 사용하면 된다. 
	public void findMember(@RequestParam Map<String, String> map, Model model) {
		model.addAttribute("id", map.get("id"));
		model.addAttribute("name", map.get("name"));
	}
	
	//---------------------------------------------------
	// 커맨드객체 (Command Object) 사용
	
	// 게시글 등록 form
	@RequestMapping("/board/write")
	public void writeBoard() {
	}
	
	@PostMapping("/board/writeOk")
	public void writeOkBoard(@ModelAttribute("DTO") WriteDTO dto) {
		System.out.println(dto);
	}
	

	// @PathVariable 사용하기
	@RequestMapping("/board/writePath/{name}/{subject}/{content}")
	public String writePathBoard(Model model,
			@PathVariable String name,
			@PathVariable String subject,
			@PathVariable String content
			) {
		
		model.addAttribute("name", name);
		model.addAttribute("subject", subject);
		model.addAttribute("content", content);	
		
		return "board/writepath";
	}
	
	// 리다이렉트 redirect: 시키기
	// handler 메소드의 리턴값 (뷰 값) 에 redirect: 사용
	// redirect는 request 를 발생시킨다 --> 크롬에서 확인 가능
	
	@RequestMapping("/member/ageCheck")
	public String chkAge(int age, RedirectAttributes redirectAttr) {
		redirectAttr.addAttribute("age", age);
		if(age < 19) {
			return "redirect:/member/underAge";
		} else {
			return "redirect:/member/adult";
		}		
	}
	
	@RequestMapping("/member/underAge")
	public String pageUnderAge(@RequestParam("age") int age, Model model) {
		model.addAttribute("age", age);
		return "member/ageUnder";
	}
	
	@RequestMapping("/member/adult")
	public String pageAdult(@RequestParam("age") int age, Model model) {
		model.addAttribute("age", age);
		return "member/ageAdult";
	}
	
	
	
	
	
	
	
}














