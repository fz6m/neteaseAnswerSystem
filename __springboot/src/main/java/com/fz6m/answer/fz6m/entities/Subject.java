package com.fz6m.answer.fz6m.entities;

import com.fz6m.answer.fz6m.mapper.UserMapper;


public class Subject {


    private Integer code;

    private boolean end;

    private Integer userId;

    private Integer number;

    private Integer max;

    private Topic info;

//    public void generateQuestion(Integer id) {
////        this.info = userMapper.getTopic(id, this.userId);
//        System.out.println(userMapper.getTopic(id, this.userId));
//        this.info.setNumber(this.number);
//        this.info.setMax(this.max);
//    }


    public Subject(Integer code, boolean end, Integer userId, Integer number, Integer max) {
        this.code = code;
        this.end = end;
        this.userId = userId;
        this.number = number;
        this.max = max;
    }

    public Subject() {
    }

    @Override
    public String toString() {
        return "Subject{" +
                "code=" + code +
                ", end=" + end +
                ", userId=" + userId +
                ", number=" + number +
                ", max=" + max +
                ", info=" + info +
                '}';
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public boolean isEnd() {
        return end;
    }

    public void setEnd(boolean end) {
        this.end = end;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public Topic getInfo() {
        return info;
    }

    public void setInfo(Topic info) {
        this.info = info;
    }
}
