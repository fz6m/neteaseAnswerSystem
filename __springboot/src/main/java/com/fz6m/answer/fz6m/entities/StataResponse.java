package com.fz6m.answer.fz6m.entities;

import java.util.List;

public class StataResponse {

    private Integer code;

    private List<Integer> users;

    private List<Wrong> error;

    private Integer correct;

    private Integer max;

    public StataResponse() {
    }

    public StataResponse(Integer code, Integer correct, Integer max) {
        this.code = code;
        this.correct = correct;
        this.max = max;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public List<Integer> getUsers() {
        return users;
    }

    public void setUsers(List<Integer> users) {
        this.users = users;
    }

    public List<Wrong> getError() {
        return error;
    }

    public void setError(List<Wrong> error) {
        this.error = error;
    }

    public Integer getCorrect() {
        return correct;
    }

    public void setCorrect(Integer correct) {
        this.correct = correct;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    @Override
    public String toString() {
        return "StataResponse{" +
                "code=" + code +
                ", users=" + users +
                ", error=" + error +
                ", correct=" + correct +
                ", max=" + max +
                '}';
    }
}
