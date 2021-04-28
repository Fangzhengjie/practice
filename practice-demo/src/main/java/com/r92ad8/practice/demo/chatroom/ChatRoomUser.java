package com.r92ad8.practice.demo.chatroom;

//用户信息类
public class ChatRoomUser{
    private String name;
    private String ip;

    public ChatRoomUser(String name, String ip) {
        this.name = name;
        this.ip = ip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}