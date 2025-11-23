//package com.seohan1010.ch8_4.to;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//
//@SpringBootTest
//class PageHandlerTest {
//
//
//    @Test
//    public void test(){
//
//        PageHandler ph = new PageHandler(250,new SearchCondition());
//        ph.print();
//        System.out.println("<<<<<<< ph = " + ph);
//        assertTrue(ph.getBeginPage()==1);
//
//    }
//
//    @Test
//    public void test2(){
//        SearchCondition sc = new SearchCondition();
//
//
//        PageHandler ph = new PageHandler(255,sc);
//
//        ph.print();
//        System.out.println("ph = "+ph);
//        assertTrue(ph.getBeginPage() == 21);
//        assertTrue(ph.getEndPage() == 26);
//
//    }
//
//}