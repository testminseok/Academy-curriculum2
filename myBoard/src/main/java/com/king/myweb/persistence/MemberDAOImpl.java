package com.king.myweb.persistence;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.king.myweb.domain.MemberVO;

@Service
public class MemberDAOImpl implements MemberDAO{

	//마이바티스
	@Autowired 
	private SqlSession sql;
	
	//mapper private static String namespace = "com.king.myweb.mappers.memberMapper"
	
	//회원가입
	public void register(MemberVO vo) throws Exception {
		sql.insert("member.register",vo); //sql.insert(namespace+".register",vo);
	}

	public MemberVO login(MemberVO vo) throws Exception {
		return sql.selectOne("member.login",vo);
	}
	@Override
	public void modify(MemberVO vo) throws Exception {
		sql.update("member.modify",vo);
	}
	public void withdrawal(MemberVO vo) throws Exception {
		sql.delete("member.withdrawal",vo);
	}

	
}
