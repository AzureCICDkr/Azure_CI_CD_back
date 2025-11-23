package com.seohan1010.ch8_4.mapper;

import com.seohan1010.ch8_4.to.BoardDto;
import com.seohan1010.ch8_4.to.PageHandler;
import com.seohan1010.ch8_4.to.SearchCondition;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import java.util.Map;


@Mapper
public interface BoardMapper {
   public abstract BoardDto selectTest();
   public abstract List<BoardDto> selectAll()throws Exception;
   public abstract int count()throws Exception;
   // 게시판 검색으로 데이터를 가져오는 코드
   public abstract List<BoardDto> searchBoardList(SearchCondition searchCondition)throws Exception;
   public abstract int searchBoardListCnt(SearchCondition searchCondition)throws Exception;
   public abstract List<BoardDto> selectBoardList(Map map)throws Exception;
   public abstract void insertBoard(BoardDto boardDto)throws Exception;
   public abstract BoardDto selectBoardDetail(Long bno)throws Exception;
   public abstract void updateBoard(BoardDto boardDto)throws Exception;
   public abstract void updateBoardLike(Long bno)throws Exception;
   public abstract void deleteBoardDetail(Long bno)throws Exception;

}
