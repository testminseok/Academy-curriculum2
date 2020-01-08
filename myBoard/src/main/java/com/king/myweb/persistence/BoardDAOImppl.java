package com.king.myweb.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.king.myweb.domain.BoardVO;
import com.king.myweb.domain.Criteria;
import com.king.myweb.domain.SearchCriteria;

@Repository
public class BoardDAOImppl implements BoardDAO{ 
	
	//마이바티스
	@Autowired
	private SqlSession sql;
	
	//매퍼
	//private static String namespace = "com.king.myweb.mappers.boardMapper";
	
	
	@Override
	public void write(BoardVO vo) throws Exception {

		sql.insert("board.write",vo);
	}
	
	@Override
	public List<BoardVO> list() throws Exception {
		return sql.selectList("board.list");
	}
	
	@Override
	public List<BoardVO> listPage(Criteria cri) throws Exception {
		return sql.selectList("board.listPage",cri);
	}
	
	@Override
	public int listCount() throws Exception {
		return sql.selectOne("board.listCount");
	}
	@Override
	public BoardVO read(int bno) {
		sql.update("board.readCnt",bno);
		return sql.selectOne("board.read",bno);
	}
	
	@Override
	public List<BoardVO> listSearch(SearchCriteria scri) throws Exception {
		return sql.selectList("board.listSearch",scri);
	}
	
	@Override
	public void update(BoardVO vo) throws Exception {
		sql.update("update",vo);
	}
	@Override
	public void delete(int bno) throws Exception {
		sql.delete("delete",bno);
	}
}
