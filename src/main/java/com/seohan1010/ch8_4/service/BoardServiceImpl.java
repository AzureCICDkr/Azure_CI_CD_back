package com.seohan1010.ch8_4.service;

import com.seohan1010.ch8_4.mapper.BoardCommentMapper;
import com.seohan1010.ch8_4.mapper.BoardMapper;
import com.seohan1010.ch8_4.to.BoardDto;
import com.seohan1010.ch8_4.to.PageHandler;
import com.seohan1010.ch8_4.to.SearchCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BoardServiceImpl implements BoardService {

    BoardMapper boardMapper;
    BoardCommentMapper boardCommentMapper;

    public BoardServiceImpl() {
    }

    @Autowired
    public BoardServiceImpl(BoardMapper boardMapper, BoardCommentMapper boardCommentMapper) {
        this.boardMapper = boardMapper;
        this.boardCommentMapper = boardCommentMapper;
    }

    @Override
    public int getCount() throws Exception {
        return boardMapper.count();
    }


    @Override
    public List<BoardDto> searchBoardList(SearchCondition searchCondition) throws Exception {

        return boardMapper.searchBoardList(searchCondition);

    }


    @Override
    public int searchBoardListCnt(SearchCondition searchCondition) throws Exception {

        return boardMapper.searchBoardListCnt(searchCondition);

    }


    @Override
    public List<BoardDto> findBoardList(Map map) throws Exception {
        return boardMapper.selectBoardList(map);
    }

    @Override
    public void registerBoard(BoardDto boardDto) throws Exception {
        boardMapper.insertBoard(boardDto);
    }

    @Override
    public BoardDto findBoardDetail(Long bno) throws Exception {
        return boardMapper.selectBoardDetail(bno);
    }


    @Override
    public void modifyBoard(BoardDto boardDto) throws Exception {
        boardMapper.updateBoard(boardDto);
    }

    @Override
    public void modifyBoardLike(Long bno) throws Exception {
        boardMapper.updateBoardLike(bno);
    }

    @Override
    public void removeBoardDetail(Long bno) throws Exception {
        boardCommentMapper.deleteBoardCommentByPcno(bno);
        boardMapper.deleteBoardDetail(bno);
    }


}
