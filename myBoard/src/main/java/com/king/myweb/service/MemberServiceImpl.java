package com.king.myweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.king.myweb.domain.MemberVO;
import com.king.myweb.persistence.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService{
 
	@Autowired
	private MemberDAO dao;
	
	//회원가입
	public void register(MemberVO vo) throws Exception {
		dao.register(vo);
	};
	
	//로그인
	public MemberVO login(MemberVO vo) throws Exception {
		return dao.login(vo);
	};
	public void modify(MemberVO vo) throws Exception {
		dao.modify(vo);
	}
	public void withdrawal(MemberVO vo) throws Exception {
		dao.withdrawal(vo);
	}
	
}
