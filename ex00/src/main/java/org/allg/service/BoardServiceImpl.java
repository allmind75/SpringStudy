package org.allg.service;

import java.util.List;

import javax.inject.Inject;

import org.allg.domain.BoardVO;
import org.allg.domain.Criteria;
import org.allg.domain.SearchCriteria;
import org.allg.persistence.BoardDAO;
import org.springframework.stereotype.Service;


@Service
public class BoardServiceImpl implements BoardService {
	
	@Inject
	private BoardDAO dao;
	
	@Override
	public void regist(BoardVO board) throws Exception {
		dao.create(board);		
		
		String[] files = board.getFiles();
		
		if(files == null) return;
		
		for(String fileName : files) {
			dao.addAttach(fileName);
		}
	}
	
	@Override
	public BoardVO read(Integer bno) throws Exception {
		return dao.read(bno);
	}
	
	@Override
	public void modify(BoardVO board) throws Exception {
		dao.update(board);
	}
	
	@Override
	public void remove(Integer bno) throws Exception {		
		dao.delete(bno);	
	}
	
	@Override
	public List<BoardVO> listAll() throws Exception {
		return dao.listAll();
	}
	
	@Override
	public List<BoardVO> listCriteria(Criteria cri) throws Exception {
		return dao.listCriteria(cri);
	}
	
	@Override
	public int listCountCriteria(Criteria cri) throws Exception {
		return dao.countPaging(cri);
	}
	
	@Override
	public List<BoardVO> listSearchCriteria(SearchCriteria cri) throws Exception {
		return dao.listSearch(cri);
	}
	
	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		return dao.listSearchCount(cri);
	}
	
	@Override
	public List<String> getAttach(Integer bno) throws Exception {
		return dao.getAttach(bno);
	}
}
