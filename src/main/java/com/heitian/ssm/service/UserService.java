package com.heitian.ssm.service;

import com.heitian.ssm.model.User;

import java.util.List;

/**
 * Created by Zhangxq on 2016/7/15.
 */
public interface UserService {

    int insert(User user);

//    List<User> getAllUser();
//
    User getUserByOpenId(String openId);
//
//    User getUserById(Long userId);
}
