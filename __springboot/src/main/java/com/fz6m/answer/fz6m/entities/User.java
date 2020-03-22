package com.fz6m.answer.fz6m.entities;


public class User {

    private Integer id;

    private Integer count;

    private Integer answeringId;

    private Integer max;

    private Integer start;

    private Integer end;

    private Integer individualTopics;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", count=" + count +
                ", answeringId=" + answeringId +
                ", max=" + max +
                ", start=" + start +
                ", end=" + end +
                ", individualTopics=" + individualTopics +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getAnsweringId() {
        return answeringId;
    }

    public void setAnsweringId(Integer answeringId) {
        this.answeringId = answeringId;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getEnd() {
        return end;
    }

    public void setEnd(Integer end) {
        this.end = end;
    }

    public Integer getIndividualTopics() {
        return individualTopics;
    }

    public void setIndividualTopics(Integer individualTopics) {
        this.individualTopics = individualTopics;
    }

    public User(Integer id, Integer count, Integer answeringId, Integer max, Integer start, Integer end, Integer individualTopics) {
        this.id = id;
        this.count = count;
        this.answeringId = answeringId;
        this.max = max;
        this.start = start;
        this.end = end;
        this.individualTopics = individualTopics;
    }
}

