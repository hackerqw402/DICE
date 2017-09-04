package com.heitian.ssm.controller;

import com.alibaba.fastjson.JSON;
import com.heitian.ssm.model.User;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by win on 2017/9/4.
 */
@Controller
@RequestMapping(value = "game")
public class GameController {

    private Logger log = Logger.getLogger(GameController.class);

    @RequestMapping(value = {"start"}, method = {RequestMethod.POST,RequestMethod.POST})
    @ResponseBody
    public String createRoom(@RequestParam String userId){
        log.info("**开始游戏");
        log.info("**userId: " + userId);
        Map<String,Object> jsonMap = new HashMap<String,Object>();
        jsonMap.put("code", "ok");
        jsonMap.put("message", "开始游戏");

        return JSON.toJSONString(jsonMap);
    }
}
