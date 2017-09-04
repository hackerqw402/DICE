package com.heitian.ssm.controller;

import com.alibaba.fastjson.JSON;
import com.heitian.ssm.model.User;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;
import java.util.HashMap;

/**
 * Created by win on 2017/9/3.
 */

@Controller
@RequestMapping(value = "room")
public class RoomController {

    private Logger log = Logger.getLogger(RoomController.class);

    @RequestMapping(value = {"create"}, method = {RequestMethod.POST,RequestMethod.POST})
    @ResponseBody
    public String createRoom(@RequestParam String userId){
        log.info("**创建房间");
        log.info("**userId: " + userId);
        User user = new User();
        Map<String,Object> jsonMap = new HashMap<String,Object>();
        user.setId(Integer.valueOf(userId));
        user.setLogo("logo url");
        user.setName("测试中文名字");
        user.setDiamondcount(Integer.valueOf(12));
        user.setGoldcount(Integer.valueOf(12));
        user.setRoomId(Integer.valueOf(10021));
        jsonMap.put("code", "ok");
        jsonMap.put("message", "创建成功");
        jsonMap.put("result", user);

        return JSON.toJSONString(jsonMap);
    }

    @RequestMapping(value = {"detail"}, method = {RequestMethod.POST})
    @ResponseBody
    public String searchRoom(@RequestParam String roomId){
        log.info("**创建房间");
        log.info("**roomId: " + roomId);
        User user = new User();
        Map<String,Object> jsonMap = new HashMap<String,Object>();
        user.setId(Integer.valueOf(roomId));
        user.setName("测试中文名字");
        user.setRoomId(Integer.valueOf(10021));
        jsonMap.put("code", "ok");
        jsonMap.put("message", "创建成功");
        jsonMap.put("result", user);

        return JSON.toJSONString(jsonMap);
    }
}
