package com.heitian.ssm.model;

import java.util.Date;

public class User {
    private Integer id;

    private Integer orderId;

    private Integer roomId;

    private Integer gameId;

    private Integer diceNum;

    private String openId;

    private String name;

    private Byte phone;

    private Integer diamondcount;

    private Integer goldcount;

    private String code;

    private String accessToken;

    private String refreshToken;

    private Byte type;

    private Date createTime;

    private Date modifyTime;

    private Byte isDelete;

    private String logo;

    private String message;

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo == null ? null : logo.trim();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public Integer getDiceNum() {
        return diceNum;
    }

    public void setDiceNum(Integer diceNum) {
        this.diceNum = diceNum;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Byte getPhone() {
        return phone;
    }

    public void setPhone(Byte phone) {
        this.phone = phone;
    }

    public Integer getDiamondcount() {
        return diamondcount;
    }

    public void setDiamondcount(Integer diamondcount) {
        this.diamondcount = diamondcount;
    }

    public Integer getGoldcount() {
        return goldcount;
    }

    public void setGoldcount(Integer goldcount) {
        this.goldcount = goldcount;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken == null ? null : accessToken.trim();
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken == null ? null : refreshToken.trim();
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }
}