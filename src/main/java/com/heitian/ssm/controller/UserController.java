package com.heitian.ssm.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.heitian.ssm.model.User;
import com.heitian.ssm.service.UserService;
import com.heitian.ssm.utils.HttpRequest;
import com.heitian.ssm.utils.JsonConvert;
import com.heitian.ssm.utils.WeChatUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * Created by win on 2017/8/25.
 */

@Controller
@RequestMapping("/user")
public class UserController {

    private Logger log = Logger.getLogger(UserController.class);


    @Resource
    private UserService userService;

    @RequestMapping(path = {"/login"}, method = {RequestMethod.POST,RequestMethod.GET},produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String userLogin(HttpServletRequest request,@RequestParam String code,@RequestParam String phone
                           ){
        log.info("**用户登录时间: " + new Date());
        log.info("**用户传入数据: cede: " + code + ", phone: " + phone );
        User user = new User();
        user.setCode(code);
        user.setPhone(Byte.decode(phone));
        user.setName("dd");
        int a = userService.insert(user);
        log.info(user.getPhone());

        User user1 = userService.getUserByOpenId("aa");
        log.info(user1.getPhone());
        //获取access_token
        //String result = WeChatUtils.getAccessToken(user.getCode());
        //Map<String,String> map = (Map<String,String>)JSON.parse(result);
        //String refreshToken = map.get("refresheh_token");
        //String openID = map.get("openid");
        String refreshToken = "qLa7IDfWkBPg2z8bQNLhzkkKm_rD4NbEGCEE_qFcxz4_Fyd0NqeYMUi-EXHHl1GKtXeV0R0cA4cteTXfcoAq6g";
        String openID = "ouoV41qvtWo0o414MLnFYrFIiZMg";
        //刷新access_token
//        String resultNew = WeChatUtils.refreshAccessToken(refreshToken);
//        Map<String,String> mapNew = (Map<String,String>)JSON.parse(resultNew);
//        String accessToken = mapNew.get("access_token");
//        log.info(accessToken);
        //获取用户信息
//        String resultMessage = WeChatUtils.getUserInfo(accessToken,openID);
//        log.info(resultMessage);
//        Map<String,String> userInfo = (Map<String,String>)JSON.parse(resultMessage);
//        try {

            //String nickName = new String(userInfo.get("nickname").getBytes("ISO-8859-1"),"UTF-8");
//        }catch (Exception e){

//        }
//        user.setUserName(userInfo.get("nickname"));
//        user.setUserLogo(userInfo.get("headimgurl"));
//        user.setDiamondCount(Integer.valueOf(0));
//        user.setGoldCount(Integer.valueOf(0));
//        user.setUserId("11050");
        Map<String,Object> jsonMap = new HashMap<String,Object>();
        jsonMap.put("code","0");
        jsonMap.put("token","大家看法");
//        jsonMap.put("result",user);
        log.info("**响应的信息" + JSON.toJSONString(jsonMap));
        return JSON.toJSONString(jsonMap);
    }

    @RequestMapping(path = {"/addRoom"}, method = {RequestMethod.POST,RequestMethod.GET},produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String userAddRoom(@RequestParam String userId,@RequestParam String roomId
    ){
        log.info("**用户加入房间: " + new Date());
        log.info("**用户传入数据: userId: " + userId + ", roomId: " + roomId );
        Map<String,Object> jsonMap = new HashMap<String,Object>();
        List<User> users = new ArrayList<User>();
        jsonMap.put("code","0");
        jsonMap.put("token","大家看法");
        //jsonMap.put("result",users);
        jsonMap.put("result","详细信息");
        log.info("**响应的信息" + JSON.toJSONString(jsonMap));
        return JSON.toJSONString(jsonMap);
    }

    @RequestMapping(path = {"/exit"}, method = {RequestMethod.POST,RequestMethod.GET},produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String userExitRoom(@RequestParam String userId,@RequestParam String roomId
    ){
        log.info("**用户退出房间: " + new Date());
        log.info("**用户传入数据: userId: " + userId + ", roomId: " + roomId );
        Map<String,Object> jsonMap = new HashMap<String,Object>();
        List<User> users = new ArrayList<User>();
        jsonMap.put("code","0");
        jsonMap.put("token","你退出成功了");
        //jsonMap.put("result",users);
        jsonMap.put("result","用户的详细信息");
        log.info("**响应的信息" + JSON.toJSONString(jsonMap));
        return JSON.toJSONString(jsonMap);
    }

    @RequestMapping(path = {"/dissolve"}, method = {RequestMethod.POST,RequestMethod.GET},produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String userDissolveRoom(@RequestParam String userId,@RequestParam String roomId
    ){
        log.info("**用户解散房间: " + new Date());
        log.info("**用户传入数据: userId: " + userId + ", roomId: " + roomId );
        Map<String,Object> jsonMap = new HashMap<String,Object>();
        List<User> users = new ArrayList<User>();
        jsonMap.put("code","0");
        jsonMap.put("token","解散了");
        //jsonMap.put("result",users);
        jsonMap.put("result","用户的详细信息");
        log.info("**响应的信息" + JSON.toJSONString(jsonMap));
        return JSON.toJSONString(jsonMap);
    }

}
