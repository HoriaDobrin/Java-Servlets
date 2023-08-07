package com.example.servletexample.model;


public class User {
    private String username;
    private int points;
    private String userType;
    private int discount;

    public User() {
    }

    public User(String username, int points, String userType, int discount) {
        this.username = username;
        this.points = points;
        this.userType = userType;
        this.discount = discount;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public int getPoints() {
        return points;
    }


    public void setPoints(int points) {
        this.points = points;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "User{" +
                    "username='" + username + '\'' +
                ", points=" + points +
                ", userType=" + userType +
                ", discount=" + discount +
                '}';
    }
}