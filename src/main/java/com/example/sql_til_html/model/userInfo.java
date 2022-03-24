package com.example.sql_til_html.model;

public class userInfo {
    private String userName;
    private String userMail;

    public userInfo(String userName, String userMail) {
        this.userName = userName;
        this.userMail = userMail;
    }

    public void setUserName(String userName) {this.userName = userName;}
    public void setUserMail(String userMail) {this.userMail = userMail;}

    public String getUserName() {
        return userName;
    }
    public String getUserMail() {
        return userMail;
    }

    @Override
    public String toString() {
        return "userName='" + userName
                +", userMail=" + userMail ;
    }
}
