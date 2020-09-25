package com.example.demo.entity;

public class Member {
    private int userNo;
    private String userId;
    private String userPw;
    private String userName;

    public int getUserNo() { return userNo; }

    public String getUserId() { return userId; }

    public String getUserPw() { return userPw; }

    public String getUserName() { return userName; }

    public void setUserNo(int userNo) {
        this.userNo = userNo;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUserPw(String userPw) {
        this.userPw = userPw;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
