// package com.seohan1010.ch8_4.mapper;

// import com.seohan1010.ch8_4.service.BoardService;
// import com.seohan1010.ch8_4.service.BoardServiceImpl;
// import com.seohan1010.ch8_4.to.BoardDto;
// import com.seohan1010.ch8_4.to.PageHandler;
// import com.seohan1010.ch8_4.to.SearchCondition;
// import org.junit.jupiter.api.DisplayName;
// import org.junit.jupiter.api.Test;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;


// import java.util.HashMap;
// import java.util.List;
// import java.util.Map;

// import static org.junit.jupiter.api.Assertions.*;


// @SpringBootTest
// class BoardMapperTest {

//     @Autowired
//     BoardMapper boardMapper;
//     @Autowired
//     BoardService boardService;

// //    @Test
// //    public void selectTest(){
// //       BoardDto dto= boardMapper.selectTest();
// //        System.out.println("dto = " + dto);
// //    }
// //
// //    // 테스트 성공
// //    @Test
// //    public void test() {
// //        System.out.println("<<<<< boardMapper = " + boardMapper);
// //    }
// //
// //    @Test
// //    public void selectAllTest() throws Exception {
// //
// //        List<BoardDto> boardDtoList = boardMapper.selectAll();
// //        assertTrue(boardDtoList.size() != 0);
// //        System.out.println("<<<<<<< boardDtoList = " + boardDtoList);
// //
// //    }

//     @Test
//     public void testData() throws Exception {

//         for (int i = 0; i < 255; i++) {
//             BoardDto b = new BoardDto();
//             b.setTitle("test title" + i);
//             b.setWriter("test writer");
//             b.setContent("test content" + i);
//             boardService.registerBoard(b);

//         }

//     }


// //    @Test
// //    @DisplayName("searchBoardList")
// //    public void searchBoardList() throws Exception {
// //
// //        String keyword = "writer1";
// //        String option = "W";
// //        SearchCondition sc = new SearchCondition();
// //        sc.setKeyword(keyword);
// //        sc.setOption(option);
// //        sc.setPage(10);
// //        sc.setPageSize(10);
// //        List<BoardDto> list = boardMapper.searchBoardList(sc);
// //
// //        System.out.println(list == null ? "<<<<<<<<<<<<<< no data found" : list);
// //        System.out.println("<<<<<<<<<<<<<<<<<< ");
// //        assertNotNull(list);
// //        list.forEach(System.out::println);
// //        System.out.println(">>>>>>>>>>>>>>>>>> ");
// //
// //    }


// //    @Test
// //    public void searchBoardListCnt()throws Exception{
// //
// //        String option = "A";
// //        String keyWord = "1";
// //
// //        SearchCondition sc = new SearchCondition();
// //        sc.setOption(option);
// //        sc.setKeyword(keyWord);
// //
// ////       int cnt = boardMapper.searchBoardListCnt(sc);
// ////       System.out.println("<<<<< cnt = " + cnt);
// //
// //    }



//     // 테스트 성공
// //    @Test
// //    @DisplayName("select BoardList test")
// //    public void selectBoardListTest() throws Exception {
// //
// //        int offset = 0;
// //        int pageSize = 10;
// //
// //        Map map = new HashMap();
// //        map.put("offset", offset);
// //        map.put("pageSize", pageSize);
// //
// //        List<BoardDto> list = boardMapper.selectBoardList(map);
// //        assertNotNull(list);
// //        list.forEach(System.out::println);
// //
// //    }

// //    // 값이 DB에 안들어간다. ---> 내가 쿼리문을 잘못 작성했다.
// //    @Test
// //    public void insertTest() throws Exception {
// //
// //        String title = "test title";
// //        String writer = "test writer";
// //        String content = "test content";
// //
// //        BoardDto b = new BoardDto();
// //        b.setTitle(title);
// //        b.setWriter(writer);
// //        b.setContent(content);
// //        System.out.println("<<<<<<<<<<<<<<<<< b.getTitle() = " + b.getTitle());
// //        boardMapper.insertBoard(b);
// //
// //    }
// //
// //    // 테스트 성공
// //    @Test
// //    public void selectBoardDetailTest() throws Exception {
// //
// //        Long bno = 5618L;
// //
// //        BoardDto b = boardMapper.selectBoardDetail(bno);
// //
// //        assertNotNull(b);
// //        System.out.println(b == null ? "<<<<<<< there is no data" : b);
// //
// //    }

//     // 테스트성공
// //    @Test
// //    public void updateBoardTest() throws Exception {
// //
// //        Long bno = 767L;
// //        String title = "modified title";
// //        String content = "modified content";
// //
// //        Map<String, Object> map = new HashMap<>();
// //        map.put("bno", bno);
// //
// //        BoardDto b = new BoardDto();
// //        b.setBno(bno);
// //        b.setTitle(title);
// //        b.setContent(content);
// //
// //        boardMapper.updateBoard(b);
// //        BoardDto b2 = boardMapper.selectBoardDetail(bno);
// //        System.out.println(b2 == null ? "<<<<<<<there is no data" : b2);
// //        assertEquals(b2.getTitle(), title);
// //
// //    }

//     // 테스트 성공
// //    @Test
// //    public void deleteBoardDetailTest() throws Exception {
// //        Long bno = 767L;
// //        Map<String, Object> map = new HashMap<>();
// //        map.put("bno", bno);
// //        boardMapper.deleteBoardDetail(bno);
// //        BoardDto b = boardMapper.selectBoardDetail(bno);
// //        System.out.println(b == null ? "<<<<<<<<<<< there is no data at data base" : b);
// //        assertNull(b);
// //
// //    }

//     //-----------------------------------------------------------------

//     //BoardServiceImpl Test

// //    //테스트 성공
// //    @Test
// //    public void implTest() {
// //        System.out.println("<<<<<<<<<<<<<<<< boardService = " + boardService);
// //    }
// //
// //    //테스트 성공
// //    @Test
// //    public void serviceSelectTest() throws Exception {
// //        Map map = new HashMap();
// //
// //        List<BoardDto> b = boardService.findBoardList(map);
// //        assertNotNull(b);
// //        b.forEach(System.out::println);
// //
// //    }


// //    @Test
// //    public void serviceSelectBoardDetailTest() throws Exception {
// //
// //        Long bno = 767L;
// //        BoardDto b = boardService.findBoardDetail(bno);
// //        assertNotNull(b);
// //        System.out.println(b == null ? "<<<<<<<<<<< there is no data" : b);
// //
// //    }

// //    //테스트 성공
// //    @Test
// //    public void serviceRegisterTest() throws Exception {
// //
// //        String title = "test title";
// //        String writer = "test writer";
// //        String content = "test writer";
// //
// //        BoardDto b = new BoardDto();
// //        b.setTitle(title);
// //        b.setWriter(writer);
// //        b.setContent(content);
// //
// //        boardService.registerBoard(b);
// //
// //    }


//     //테스트 성공

// //
// //    @Test
// //    public void serviceUpdateTest() throws Exception {
// //
// //        String title = "modified title";
// //        String writer = "modified writer";
// //        String content = "modified content";
// //        Long bno = 5620L;
// //
// //        BoardDto b = new BoardDto();
// //        b.setTitle(title);
// //        b.setWriter(writer);
// //        b.setContent(content);
// //        b.setBno(bno);
// //
// //        boardService.modifyBoard(b);
// //        BoardDto b2 = boardService.findBoardDetail(bno);
// //        assertEquals(b2.getTitle(), title);
// //        System.out.println(b2 == null ? "<<<<<<< there is no data" : b2);
// //
// //    }
// //
// //
// //    //테스트 성공
// //    @Test
// //    public void serviceRemoveBoardTest() throws Exception {
// //
// //        Long bno = 5620L;
// //
// //        boardService.removeBoardDetail(bno);
// //
// //        BoardDto b = boardService.findBoardDetail(bno);
// //        assertNull(b);
// //        System.out.println(b == null ? "<<<<<<<<< there is no data" : b);
// //
// //    }


// }
