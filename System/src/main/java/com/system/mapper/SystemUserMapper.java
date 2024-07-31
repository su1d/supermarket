package com.system.mapper;

import com.system.pojo.SystemUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SystemUserMapper {

    List<SystemUser> getAllUsers();
}