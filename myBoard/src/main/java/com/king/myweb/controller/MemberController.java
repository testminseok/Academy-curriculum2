package com.king.myweb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.king.myweb.domain.MemberVO;
import com.king.myweb.service.MemberService;

@Controller
@RequestMapping("/member/*")
public class MemberController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	MemberService service;
	
	//회원가입
	@RequestMapping(value="/register" , method = RequestMethod.GET)
	public void getRegister() throws Exception {
		logger.info("get register");
	}
	
	//회원가입 post
	@RequestMapping(value="/register", method= RequestMethod.POST)
	public String postRegister(MemberVO vo) throws Exception{
		logger.info("post regsister");
		
		service.register(vo);
		
		return "redirect:/";
	}
	
	//로그인
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String login(MemberVO vo, HttpServletRequest req, RedirectAttributes rttr) throws Exception {
		logger.info("post login");
		HttpSession session = req.getSession();
		MemberVO login = service.login(vo);
		
		if (login ==null) {
			session.setAttribute("member", null);
			rttr.addFlashAttribute("msg", false);
		}else { 
			session.setAttribute("member", login);
			MemberVO test = (MemberVO) session.getAttribute("member");
			System.out.println("로그인 아이디 테스트"+test.getUserId());
			System.out.println("로그인 비밀번호 테스트"+test.getUserPass());
			System.out.println("로그인 네임 테스트"+test.getUserName());
			System.out.println("로그인 날짜 테스트"+test.getRegDate());
		}
		return "redirect:/";
	}
	
	//회원정보 수정 get
	@RequestMapping(value="/modify" , method = RequestMethod.GET)
	public void getModify() throws Exception {
		logger.info("get modify");
	}
		
	//회원 정보 수정 post
	@RequestMapping(value="/modify", method = RequestMethod.POST)
	public String postModify(MemberVO vo, HttpSession session) throws Exception {
		logger.info("post Modify");
			
		service.modify(vo);
		session.invalidate();
		
		return "redirect:/";
	}
	
	//회원 탈퇴 get
	@RequestMapping(value="/withdrawal", method = RequestMethod.GET)
	public void getWithdrawal() throws Exception{
		logger.info("get withdrawal");
	}
	//회원 탈퇴 POST
	@RequestMapping(value="/withdrawal", method = RequestMethod.POST)
	public String postWithdrawal(HttpSession session, MemberVO vo, RedirectAttributes rttr) throws Exception{
		logger.info("post withdrawal");
		
		MemberVO member = (MemberVO) session.getAttribute("member");
		
		String id = member.getUserId();
		System.out.println(id);
		System.out.println(member.getUserName());
		System.out.println(member.getRegDate());
		
		String oldPass = member.getUserPass();
		System.out.println(oldPass);
		String newPass = vo.getUserPass();
		System.out.println("vo.getUserpass() = "+newPass);
		
		if (!(oldPass.equals(newPass))) { 
			rttr.addFlashAttribute("msg",false);
			return "redirect:/";
		}
		service.withdrawal(vo);
		session.invalidate();
		return "redirect:/";
	}
	//로그아웃
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logOut(HttpSession session) throws Exception{
		logger.info("get logout");
		session.invalidate();
		return "redirect:/";
	}
}
