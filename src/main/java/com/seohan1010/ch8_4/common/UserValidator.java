package com.seohan1010.ch8_4.common;

import com.seohan1010.ch8_4.to.UserDto;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;



public class UserValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return UserDto.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto)target;

        System.out.println("UserValidator has been called!!!");

       String email = userDto.getEmail();
       String password = userDto.getPassword();

        //		if(id==null || "".equals(id.trim())) {
        //			errors.rejectValue("id", "required");
        //		}
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email",  "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required");

        if(email==null||"".equals(email.trim())) {
            errors.rejectValue("email", "invalid Email");
        }else if(password == null||password.length() <7 ){
            errors.rejectValue("password","invalid password");
        }


    }
}
