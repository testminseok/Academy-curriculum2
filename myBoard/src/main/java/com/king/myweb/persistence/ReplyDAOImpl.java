package com.king.myweb.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.king.myweb.domain.ReplyVO;

@Repository
public class ReplyDAOImpl implements ReplyDAO{
	
	//마이바티스
	@Autowired
	private SqlSession sql;
	
	//매퍼
	private static String namespace = "com.king.myweb.mappers.replyMapper";
	
	//댓글 조회
	@Override
	public List<ReplyVO> readReply(int bno) throws Exception {
		return sql.selectList(namespace+".readReply",bno);
	} 
	//댓글작성
	public void writeReply(ReplyVO vo) throws Exception {
		sql.insert(namespace+".writeReply",vo);
	};
	//댓글수정
	public void replyUpdate(ReplyVO vo) throws Exception {
		sql.update(namespace+".updateReply",vo);
	}
	//댓글 삭제
	public void replyDelete(ReplyVO vo) throws Exception {
		sql.delete(namespace+".deleteReply",vo);
	}
	public ReplyVO readReplySelect(int rno) throws Exception {
		return sql.selectOne(namespace+".readReplySelect",rno);
	}
	
}
