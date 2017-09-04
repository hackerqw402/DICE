package com.heitian.ssm.utils;

import com.alibaba.fastjson.JSON;
import  com.heitian.ssm.model.User;

import java.util.Map;

/**
 * Created by win on 2017/9/1.
 */
public class T {

    public static void main(String[] args) {
        try {
            String jsonString = HttpsRequest.sendGet("https://api.weixin.qq.com/sns/oauth2/refresh_token", "appid=wx77283bee1d973479&grant_type=refresh_token&refresh_token=qLa7IDfWkBPg2z8bQNLhzkkKm_rD4NbEGCEE_qFcxz4_Fyd0NqeYMUi-EXHHl1GKtXeV0R0cA4cteTXfcoAq6g");
            System.out.println(jsonString);
            //Map<Object,Object> map = (Map<Object,Object>)JSON.parse(jsonString);
            User user = (User)JSON.parseArray(jsonString,User.class);
            System.out.println(user.getAccessToken());
            //System.out.println(map.get("nickname"));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
