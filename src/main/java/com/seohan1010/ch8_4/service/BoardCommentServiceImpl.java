package com.seohan1010.ch8_4.service;

import com.seohan1010.ch8_4.mapper.BoardCommentMapper;
import com.seohan1010.ch8_4.to.BoardCommentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardCommentServiceImpl implements BoardCommentService {

    @Autowired
    BoardCommentMapper boardCommentMapper;


    @Override
    public void registerBoardComment(BoardCommentDto boardCommentDto)throws Exception{
        boardCommentMapper.insertBoardComment(boardCommentDto);
    }

    @Override
    public void modifyBoardComment(BoardCommentDto boardCommentDto)throws Exception{
        boardCommentMapper.updateBoardComment(boardCommentDto);
    }


    @Override
    public List<BoardCommentDto> findBoardComment(Long pcno)throws Exception{
        return boardCommentMapper.selectBoardComment(pcno);
    }

    @Override
    public void deleteBoardCommentByPcno(Long pcno)throws Exception{
        boardCommentMapper.deleteBoardCommentByPcno(pcno);
    }

    @Override
    public void removeBoardComment(Long cno)throws Exception{
        boardCommentMapper.deleteBoardComment(cno);
    }
}
