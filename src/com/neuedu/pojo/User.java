package com.neuedu.pojo;

public class User {
    private String username;
    private String password;
    private String tele;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", tele='" + tele + '\'' +
                '}';
    }

    public User(String username, String password, String tele) {
        this.username = username;
        this.password = password;
        this.tele = tele;
    }

    public User() {
    }
}
