package com.king.myweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.king.myweb.domain.BoardVO;
import com.king.myweb.domain.Criteria;
import com.king.myweb.domain.SearchCriteria;
import com.king.myweb.persistence.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardDAO dao;
	
	public void write(BoardVO vo) throws Exception {
		dao.write(vo);
	};
	@Override
	public List<BoardVO> list() throws Exception {
		return dao.list();
	}
	
	@Override
	public List<BoardVO> listPage(Criteria cri) throws Exception {
		return dao.listPage(cri);
	}
	@Override
	public int listCount() throws Exception {
		return dao.listCount();
	}
	
	@Override
	public BoardVO read(int bno) throws Exception {
		return dao.read(bno);
	}
	@Override
	public List<BoardVO> listSearch(SearchCriteria scri) throws Exception {
		return dao.listSearch(scri);
	}
	@Override
	public void update(BoardVO vo) throws Exception {
		dao.update(vo);
	}
	@Override
	public void delete(int bno) throws Exception {
		dao.delete(bno);
	}
	
}
