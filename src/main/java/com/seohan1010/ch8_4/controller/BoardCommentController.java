package com.seohan1010.ch8_4.controller;

import com.seohan1010.ch8_4.mapper.BoardCommentMapper;
import com.seohan1010.ch8_4.service.BoardCommentService;
import com.seohan1010.ch8_4.to.BoardCommentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000",
             methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS},
             allowCredentials = "false" )
@RequestMapping(value = "/boardcomment")
public class BoardCommentController {

    @Autowired
    BoardCommentService boardCommentService;

    // 테스트 성공
    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    public ResponseEntity<HttpStatus> registerBoardComment(@RequestBody BoardCommentDto boardCommentDto) throws Exception {
        System.out.println("boardCommentDto = " + boardCommentDto);
        try {
            boardCommentService.registerBoardComment(boardCommentDto);
            return new ResponseEntity<>(HttpStatus.OK);  // 200번 코드를 반환
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.CONFLICT);     // 409 코드를 반환

    }


    @RequestMapping(value = "/commentList", method = RequestMethod.GET)
    public ResponseEntity<List<BoardCommentDto>> findBoardCommentList(@RequestParam("pcno") Long pcno) throws Exception {
        System.out.println("boardCommentDto = " + pcno);
        List<BoardCommentDto> list=null;

        try {
          list = boardCommentService.findBoardComment(pcno);

           if(list.size()!=0)
           return new ResponseEntity<>(list,HttpStatus.OK);
           // list의 크기가 0이어도 빈배열을 반환한다.
           return new ResponseEntity<>(list,HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            list.clear();
            e.printStackTrace();
            // 예외가 발생해도 빈배열을 반환한다.
            return new ResponseEntity<>(list,HttpStatus.BAD_REQUEST);
        }


    }

        // @PathVariable이 아닌 바디에 다가 넣어서 정보를 보내야 겠다. 
    @RequestMapping(value="/comment",method=RequestMethod.PUT)
    public ResponseEntity<HttpStatus> modifyBoardComment(@RequestBody BoardCommentDto boardCommentDto)throws Exception{
        System.out.println("boardCommentDto = " + boardCommentDto);
        try{

            boardCommentService.modifyBoardComment(boardCommentDto);
            return new ResponseEntity<>(HttpStatus.OK);

        }catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        
    }

    // @PathVariable이 아닌 바디에 다가 넣어서 정보를 보내야 겠다.
    // delete 는 DB의 deleted_yn 칼럼의 정보를 'Y'로 변경한다.
    @RequestMapping(value="/comment",method=RequestMethod.DELETE)
    public ResponseEntity<HttpStatus> removeBoardComment(@RequestBody BoardCommentDto boardCommentDto)throws Exception{

        System.out.println("boardCommentDto = " + boardCommentDto);
        try{

            boardCommentService.removeBoardComment(boardCommentDto.getCno());
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(Exception e){

            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }


    }
    
    
}
