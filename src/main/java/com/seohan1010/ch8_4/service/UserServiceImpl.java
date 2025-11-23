package com.seohan1010.ch8_4.service;

import com.seohan1010.ch8_4.mapper.UserMapper;
import com.seohan1010.ch8_4.to.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

@Autowired
    UserMapper userMapper;

    @Override
    public UserDto findEmail(String email)throws Exception{
        return userMapper.searchEmail(email);
    }


    @Override
    public UserDto findUser(String email)throws Exception{
        return userMapper.selectUser(email);
    }

    @Override
    public void registerUser(UserDto userDto)throws Exception{
        userMapper.insertUser(userDto);
    }

    @Override
    public void modifyUser(UserDto userDto)throws Exception{
        userMapper.updateUser(userDto);
    }

    @Override
    public void removeUser(Map map)throws Exception{
        userMapper.deleteUser(map);
    }




}
