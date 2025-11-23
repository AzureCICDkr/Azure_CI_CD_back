package com.seohan1010.ch8_4.service;

import com.seohan1010.ch8_4.to.UserDto;

import java.util.Map;

public interface UserService {
    public abstract UserDto findEmail(String email)throws Exception;
    public abstract UserDto findUser(String email) throws Exception;

    public abstract void registerUser(UserDto userDto) throws Exception;

    public abstract void modifyUser(UserDto userDto) throws Exception;

    public abstract void removeUser(Map map) throws Exception;
}
