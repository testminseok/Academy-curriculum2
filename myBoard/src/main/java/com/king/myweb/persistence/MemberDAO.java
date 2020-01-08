package com.king.myweb.persistence;

import com.king.myweb.domain.MemberVO;

public interface MemberDAO {
	
	//회원가입
	public void register(MemberVO vo) throws Exception;
	//로그인
	public MemberVO login(MemberVO vo) throws Exception;
	//회원정보수정
	public void modify(MemberVO vo) throws Exception;
	//회원 탈퇴
	public void withdrawal(MemberVO vo) throws Exception;
}
