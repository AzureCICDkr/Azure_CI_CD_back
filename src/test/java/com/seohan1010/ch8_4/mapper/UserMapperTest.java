//package com.seohan1010.ch8_4.mapper;
//
//import com.seohan1010.ch8_4.to.UserDto;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.time.LocalDate;
//import java.util.HashMap;
//import java.util.Map;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//
//@SpringBootTest
//class UserMapperTest {
//
//@Autowired
//UserMapper userMapper;
//
//
//
////테스트 성공
//@Test
//    public void test(){
//    System.out.println("<<<<<<<<<<<<< userMapper = " + userMapper);
//}
//
//
////테스트 성공
//@Test
//    public void selectUserTest()throws Exception{
//
//    String email = "aaa@aaa.com";
//   UserDto user =userMapper.selectUser(email);
//   assertNotNull(user);
//    System.out.println("<<<<<<<<<<<<<<< user = " + user);
//
//}
//
//// 테스트 성공
//@Test
//    public void insertTest()throws Exception{
//
//    String email = "aaa@aaa.com";
//    String name = "admin";
//    String password = "111111";
//    LocalDate birthDate = LocalDate.now();
//    String sns = "test sns";
//
//    UserDto user = new UserDto();
//    user.setEmail(email);
//    user.setName(name);
//    user.setPassword(password);
//    userMapper.insertUser(user);
//    UserDto user2 = userMapper.selectUser(email);
//    assertNotNull(user2);
//    System.out.println("<<<<<<<<<<<<<<  user2 = " + user2);
//
//
//}
//
////테스트 성공
//@Test
//    public void updateUserTest()throws Exception{
//
//        String email = "test email";
//        String name = "modified test name";
//        String password = "modified test password";
//        String sns ="modified sns";
//        LocalDate birthDate = LocalDate.now();
//
//        UserDto user = new UserDto();
//        user.setEmail(email);
//        user.setName(name);
//        user.setPassword(password);
//        user.setSns(sns);
//        user.setBirthDate(birthDate);
//        userMapper.updateUser(user);
//       UserDto user2 = userMapper.selectUser(email);
//       assertEquals(user2.getName(),name);
//
//}
//
////테스트 성공
//@Test
//    public void deleteTest()throws Exception{
//    String email = "test email";
//    Map<String, Object> map = new HashMap<>();
//    map.put("email",email);
//    userMapper.deleteUser(map);
//    UserDto user= userMapper.selectUser(email);
//    assertNull(user);
//    System.out.println("user = " + user);
//}
//
//
//}