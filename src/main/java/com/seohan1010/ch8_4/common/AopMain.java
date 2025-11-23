//package com.seohan1010.ch8_4.common;
//
//
//import org.springframework.transaction.annotation.Transactional;
//
//import java.lang.reflect.Method;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//
//public class AopMain {
//
//
//    public static void main(String[] args) {
//
//
//        MyAdvice myAdvice = new MyAdvice();
//        try {
//            Class clazz = Class.forName("com.seohan1010.ch8_4.common.MyClass");
//            MyClass myClass=(MyClass)clazz.newInstance();
//            for(Method m: myClass.getClass().getDeclaredMethods()){
//                myAdvice.invoke(m,myClass,null);
//            }
//            clazz.getDeclaredMethods();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//
//}
//
//
//class MyAdvice {
//
//
//    Pattern p = Pattern.compile("a.*");
//
//    boolean matches(Method m){
//        Matcher matcher = p.matcher(m.getName());
//        return matcher.matches();
//    }
//
//
//    void invoke(Method m, Object obj, Object... args)throws Exception {
//
//        if(matches(m))
//        System.out.println("[before]{");
//
//        m.invoke(obj, args);
//
//        if(matches(m))
//        System.out.println("}[after]");
//    }
//
//}
//
//
//class MyClass {
//
//
//    void aaa() {
//        System.out.println("aaa() is called");
//    }
//
//
//    void aaa2() {
//        System.out.println("aaa2() is called");
//    }
//
//
//    void bbb() {
//        System.out.println("bbb() is called");
//    }
//
//
//}
