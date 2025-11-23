//package com.seohan1010.ch8_4.mapper;
//
//import com.seohan1010.ch8_4.to.BoardCommentDto;
//import com.seohan1010.ch8_4.to.BoardDto;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//
//@SpringBootTest
//class BoardCommentMapperTest {
//
//
//    @Autowired
//    BoardCommentMapper boardCommentMapper;
//
//    //테스트 성공
//    @Test
//    public void test(){
//        System.out.println("<<<<<<<<<<<< boardCommentMapper = " + boardCommentMapper);
//
//    }
//
//
//    //테스트 성공
//    @Test
//    public void insertTest()throws Exception{
//
//
//        Long pcno = 1L;
//        String comment = "test comment";
//        String commenter = "test commenter";
//
//
//        BoardCommentDto b = new BoardCommentDto();
//        b.setPcno(pcno);
//        b.setComment(comment);
//        b.setCommenter(commenter);
//        boardCommentMapper.insertBoardComment(b);
//
//    }
//
//
//
//
//
//
//
//
//    //테스트 성공
//    @Test
//    public void updateTest()throws Exception{
//
//            String comment ="modified comment";
//            Long cno = 3L;
//
//
//            BoardCommentDto b = new BoardCommentDto();
//            b.setComment(comment);
//            b.setCno(cno);
//
//
//            boardCommentMapper.updateBoardComment(b);
//
//
//    }
//
//    //테스트 성공
//    @Test
//    public void selectBoardCommentTest()throws Exception{
//
//        Long bno =5618L;
//
//        List<BoardCommentDto> list = boardCommentMapper.selectBoardComment(bno);
//        System.out.println("<<<<<<<<<<<<<<< list is :"+list==null?"there is no data " : list);
//        assertNotNull(list);
//
//    }
//
//    //테스트 성공
//    @Test
//    public void deleteBoardCommentTest()throws Exception{
//
//        Long cno =2L;
//
//        boardCommentMapper.deleteBoardComment(cno);
//
//
//    }
//
//
//
//}