package com.seohan1010.ch8_4.service;

import com.seohan1010.ch8_4.to.BoardDto;
import com.seohan1010.ch8_4.to.PageHandler;
import com.seohan1010.ch8_4.to.SearchCondition;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

public interface BoardService {

    public abstract int getCount() throws Exception;

    public abstract List<BoardDto> searchBoardList(SearchCondition searchCondition) throws Exception;

    public abstract int searchBoardListCnt(SearchCondition searchCondition) throws Exception;

    public abstract List<BoardDto> findBoardList(Map map) throws Exception;

    public abstract void registerBoard(BoardDto boardDto) throws Exception;

    public abstract BoardDto findBoardDetail(Long bno) throws Exception;

    public abstract void modifyBoard(BoardDto boardDto) throws Exception;

    public abstract void modifyBoardLike(Long bno) throws Exception;

    public abstract void removeBoardDetail(Long bno) throws Exception;
}
