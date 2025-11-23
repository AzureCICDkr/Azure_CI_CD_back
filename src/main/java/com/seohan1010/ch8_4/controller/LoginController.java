package com.seohan1010.ch8_4.controller;


import com.seohan1010.ch8_4.service.UserService;
import com.seohan1010.ch8_4.to.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;

@RestController
@CrossOrigin(origins = "http://localhost:3000",
             methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS},
             allowCredentials = "false" )
@RequestMapping("/auth")
public class LoginController {

    @Autowired
    UserService userService;


    @RequestMapping(value="/logout",method=RequestMethod.GET)
    public ResponseEntity<HttpStatus> logout(HttpSession session){

        session.invalidate();
        return new ResponseEntity<HttpStatus>(HttpStatus.OK);
    }


    // 요청 헤더에 있는 데이터를 출력하는 로직
    public void getData(HttpServletRequest request){
       String auth= request.getHeader("authorization");

      Enumeration<String> headers =  request.getHeaderNames();
      while(headers.hasMoreElements()){
          System.out.println("headers.nextElement().toString() = " + headers.nextElement().toString());
      }
      
        System.out.println(" = " +"");
        System.out.println("<<<<<<<<<<<<<< auth = " + auth);
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<HttpStatus> login(@RequestBody UserDto userDto, HttpServletRequest request) {
        UserDto user = null;
        HttpSession session = request.getSession();
        getData(request);
        try {
            user = userService.findUser(userDto.getEmail());
            //이메일이 null이 아니고, 입력받은 password가 db의 password와 일치하지 않으면
            if (user == null || !user.getPassword().equals(userDto.getPassword())) {

                return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);  // 404번 코드를 반환
             }
            setUserInfo(user.getEmail(), user.getName(), user.getPassword(), session);

            return new ResponseEntity<HttpStatus>(HttpStatus.OK); // 200번 코드를 반환
        } catch (Exception ex) {

            return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST); // 400번 코드를 반환
        }

    }// login 메서드의 끝



    //login 메서드로 부터 데이터와 세션 객체를 받아와서 로그인 정보를 저장하는 메서드
    private static void setUserInfo(String email, String name, String password, HttpSession session) {

        session.setAttribute("email", email);
        session.setAttribute("name", name);
        session.setAttribute("password", password);
        String email2=(String)session.getAttribute("email");
        System.out.println("<<<<<<<<<<<<<<<<< email2 = " + email2);
        ServletContext servlet = session.getServletContext();
        System.out.println("<<<<<<<<<<<<<< servlet = " + servlet);

    }

}
