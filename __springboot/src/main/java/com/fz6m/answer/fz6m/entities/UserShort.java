package com.fz6m.answer.fz6m.entities;

public class UserShort {

    private Integer id;

    public UserShort() {
    }

    public UserShort(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "UserShort{" +
                "id=" + id +
                '}';
    }
}
