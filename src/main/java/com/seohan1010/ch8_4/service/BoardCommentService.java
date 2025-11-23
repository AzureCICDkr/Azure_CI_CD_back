package com.seohan1010.ch8_4.service;

import com.seohan1010.ch8_4.to.BoardCommentDto;

import java.util.List;

public interface BoardCommentService {
    void registerBoardComment(BoardCommentDto boardCommentDto) throws Exception;

    void modifyBoardComment(BoardCommentDto boardCommentDto) throws Exception;

    List<BoardCommentDto> findBoardComment(Long pcno) throws Exception;
    void deleteBoardCommentByPcno(Long pcno)throws Exception;

    void removeBoardComment(Long cno) throws Exception;
}
