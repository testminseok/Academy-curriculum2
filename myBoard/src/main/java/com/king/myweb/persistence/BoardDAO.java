package com.king.myweb.persistence;

import java.util.List;

import com.king.myweb.domain.BoardVO;
import com.king.myweb.domain.Criteria;
import com.king.myweb.domain.SearchCriteria;

public interface BoardDAO {
	
	//작성
	public void write(BoardVO vo) throws Exception;
	
	//리스트목록
	public List<BoardVO> list() throws Exception;
	
	//리스트 목록 + 페이지
	public List<BoardVO> listPage(Criteria cri) throws Exception;
	
	//게시글 총개수
	public int listCount() throws Exception;
	
	//상세보기
	public BoardVO read(int bno);
	
	//리스트목록 + 페이지 + 검색
	public List<BoardVO> listSearch(SearchCriteria scri) throws Exception;

	public void update(BoardVO vo) throws Exception;

	public void delete(int bno) throws Exception;
	
	
}
