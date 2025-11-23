package com.seohan1010.ch8_4.mapper;

import com.seohan1010.ch8_4.to.UserDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface UserMapper {

    public abstract UserDto searchEmail(String email)throws Exception;
    public abstract UserDto selectUser(String email)throws Exception;
    public abstract void insertUser(UserDto userDto)throws Exception;
    public abstract void updateUser(UserDto userDto)throws Exception;
    public abstract void deleteUser(Map map)throws Exception;

}
