package com.heitian.ssm.utils;

import com.alibaba.fastjson.JSON;

import java.util.Map;

/**
 * Created by win on 2017/9/1.
 */
public class WeChatUtils {

    public static String APPID = "wx77283bee1d973479";
    public static String SECRET = "652641ed73bd1d66b2634f377d57ac0d";
    public static String ACCESS_TOKEN = null ;
    public static String REFRESH_ACCESS_TOKEN = null ;
    public static String GET_ACCESS_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/access_token";
    public static String REFRESH_ACCESS_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/refresh_token";
    public static String GET_USER_INFO_URL = "https://api.weixin.qq.com/sns/userinfo";


    /**
     *   获取access_token 和 refresh_token
     */
    public static String getAccessToken(String code){
        String param = "appid=" + APPID + "&secret=" + SECRET + "&code="
                + code + "&grant_type=authorization_code";
        String jsonString = HttpsRequest.sendGet(GET_ACCESS_TOKEN_URL,param);
        return jsonString ;
    }

    /**
     * 刷新access_token
     */
    public static String refreshAccessToken(String refreshToken){
        String param = "appid=" + APPID + "&grant_type=refresh_token"
                + "&refresh_token=" + refreshToken;
        String jsonString = HttpsRequest.sendGet(REFRESH_ACCESS_TOKEN_URL,param);
        return jsonString;
    }

    /**
     * 获取个人信息
     */
    public static String getUserInfo(String accessToken,String openID){
        String param = "access_token=" + accessToken + "&openid="
                + openID + "&lang=zh_CN";
        String jsonString = HttpsRequest.sendGet(GET_USER_INFO_URL,param);
        return jsonString;
    }

}
