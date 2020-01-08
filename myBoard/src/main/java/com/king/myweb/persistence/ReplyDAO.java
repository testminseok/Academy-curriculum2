package com.king.myweb.persistence;

import java.util.List;

import com.king.myweb.domain.ReplyVO;

public interface ReplyDAO {

	//댓글 조회
	public List<ReplyVO> readReply(int bno) throws Exception;
	
	//댓긋 작성
	public void writeReply(ReplyVO vo) throws Exception;

	public void replyUpdate(ReplyVO vo) throws Exception;

	public void replyDelete(ReplyVO vo) throws Exception;
	//특정 댓글 조회
	public ReplyVO readReplySelect(int rno) throws Exception;
}
