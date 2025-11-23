package com.seohan1010.ch8_4.mapper;


import com.seohan1010.ch8_4.to.BoardCommentDto;
import com.seohan1010.ch8_4.to.BoardDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardCommentMapper {


    public abstract void insertBoardComment(BoardCommentDto boardCommentDto)throws Exception;

    public abstract void updateBoardComment(BoardCommentDto boardCommentDto)throws Exception;


    // 아래는 테스트 쿼리문으로  board 쿼리문으로 사용할 것이다.
    public abstract List<BoardCommentDto> selectBoardComment(Long pcno)throws Exception;

    public abstract void deleteBoardCommentByPcno(Long pcno)throws Exception;
    public abstract void deleteBoardComment(Long cno)throws Exception;






}
