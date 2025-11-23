package com.seohan1010.ch8_4.common;

import com.seohan1010.ch8_4.to.UserDto;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@ControllerAdvice
public class GlobalValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return UserDto.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto)target;
        System.out.println("GlobalValidator.validate() has been called!!!");
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
