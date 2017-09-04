package com.heitian.ssm.dao;

import com.heitian.ssm.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Zhangxq on 2016/7/15.
 */

@Repository
public interface UserDao {

    int insert(User record);

//    User selectUserById(@Param("userId") Long userId);
//
    User selectUserByOpenId(@Param("openId") String openId);
//
//    List<User> selectAllUser();
}
