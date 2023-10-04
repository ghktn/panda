package com.playdata.panda.repository;

import com.playdata.panda.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRepository {

    public int signUpUser(User user);


}
