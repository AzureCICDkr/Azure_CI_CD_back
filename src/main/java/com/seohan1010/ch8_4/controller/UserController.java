package com.seohan1010.ch8_4.controller;


import com.seohan1010.ch8_4.common.GlobalValidator;
import com.seohan1010.ch8_4.common.UserValidator;
import com.seohan1010.ch8_4.service.UserService;
import com.seohan1010.ch8_4.to.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;


@RestController
@CrossOrigin(origins = "http://localhost:3000",
             methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS},
             allowCredentials = "false" )
@RequestMapping("/user")
public class UserController {


    @Autowired
    UserService userService;


    @InitBinder
    public void userValidator(WebDataBinder binder) {
        ConversionService conversionService = binder.getConversionService();
//         System.out.println("<<<<<<<<<<<<<<<<<<< conversionService = " + conversionService);

        // setValidator()를 사용하면은 GlobalValidator를 사용하지 않게 된다.
//         binder.setValidator(new UserValidator());

        binder.addValidators(new UserValidator(), new GlobalValidator());
//         binder.addValidators(new UserValidator());
        List<Validator> validatorList = binder.getValidators();
        System.out.println("<<<<<<<<<<<< validatorList = " + validatorList);

    }


    // 로그인 하려는 이메일이 이미 존재하는지의 여부를 확인하는 코드
    @RequestMapping(value = "/email", method = RequestMethod.POST)
    public ResponseEntity<HttpStatus> findEmail(@RequestBody Map<String, String> map) {
        String email = (String) map.get("email");
        UserDto userDto = null;
        try {
            userDto = userService.findEmail(email);
            // 입력한 이메일에 해당하는 유저가 존재하면은 에러코드를 보낸다.
            if (userDto != null) return new ResponseEntity<HttpStatus>(HttpStatus.CONFLICT);
            return new ResponseEntity<HttpStatus>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
        }

    }


    // 여기서  validator 로 회원가입을 정보가 유효한 값인지를 검증 
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<HttpStatus> registerUser(@RequestBody UserDto userDto, BindingResult result) {
        if ("".equals(userDto.getEmail()) || "".equals(userDto.getPassword())) {
            //이메일이나 비밀번호가 공백이면은 오류코드를 보낸다.
            return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
        }

        System.out.println("<<<<<<<<<<<<< result : " + result);

        System.out.println("<<<<<<<< userDto.getBirthDate() = " + userDto.getBirthDate());
        try {
            userService.registerUser(userDto);
            return new ResponseEntity<HttpStatus>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
        }

    }


    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ResponseEntity<UserDto> findUser(@RequestBody Map<String, String> map) {
        String email = (String) map.get("email");
        System.out.println("<<<<<<<<<<<<<<<< email = " + email);
        UserDto user = null;
        try {
            user = userService.findUser(email);
            if (user == null) return new ResponseEntity<UserDto>(user, HttpStatus.NO_CONTENT);
            return new ResponseEntity<UserDto>(user, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<UserDto>(user, HttpStatus.BAD_REQUEST);
        }


    }


    // 여기서  validator 로 수정하려는 정보가 유효한 값인지를 검증
    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public ResponseEntity<HttpStatus> modifyUser(@RequestBody UserDto userDto) {

        try {
            userService.modifyUser(userDto);
            return new ResponseEntity<HttpStatus>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
        }

    }


    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ResponseEntity<HttpStatus> removeUser(@RequestBody Map<String, String> user) {
        System.out.println("(String)user.get(\"email\") = " + user.get("email"));

        try {
            userService.removeUser(user);
            return new ResponseEntity<HttpStatus>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
        }

    }

}
