package com.fz6m.answer.fz6m.entities;

public class UserShort {

    private Integer id;

    private String token;


    public UserShort() {
    }

    public UserShort(Integer id, String token) {
        this.id = id;
        this.token = token;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "UserShort{" +
                "id=" + id +
                ", token='" + token + '\'' +
                '}';
    }
}
