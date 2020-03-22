package com.fz6m.answer.fz6m.entities;

public class Topic {

    private Integer userId;

    private Integer id;

    private String suggest;

    private String name;

    private String singer;

    private String content;

    private Integer awesome;

    private Integer number;

    private boolean attitude;

    private boolean attitudeDelete;

    private boolean delete;

    private Integer max;

    private boolean reply;

    private String replyContent;

    public Topic() {
    }

    public Topic(Integer userId, Integer id, String suggest, String name, String singer, String content, Integer awesome, boolean attitude, boolean attitudeDelete, boolean delete, boolean reply, String replyContent) {
        this.userId = userId;
        this.id = id;
        this.suggest = suggest;
        this.name = name;
        this.singer = singer;
        this.content = content;
        this.awesome = awesome;
        this.attitude = attitude;
        this.attitudeDelete = attitudeDelete;
        this.delete = delete;
        this.reply = reply;
        this.replyContent = replyContent;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSuggest() {
        return suggest;
    }

    public void setSuggest(String suggest) {
        this.suggest = suggest;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getAwesome() {
        return awesome;
    }

    public void setAwesome(Integer awesome) {
        this.awesome = awesome;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public boolean isAttitude() {
        return attitude;
    }

    public void setAttitude(boolean attitude) {
        this.attitude = attitude;
    }

    public boolean isDelete() {
        return delete;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public boolean isAttitudeDelete() {
        return attitudeDelete;
    }

    public void setAttitudeDelete(boolean attitudeDelete) {
        this.attitudeDelete = attitudeDelete;
    }

    public boolean isReply() {
        return reply;
    }

    public void setReply(boolean reply) {
        this.reply = reply;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "userId=" + userId +
                ", id=" + id +
                ", suggest='" + suggest + '\'' +
                ", name='" + name + '\'' +
                ", singer='" + singer + '\'' +
                ", content='" + content + '\'' +
                ", awesome=" + awesome +
                ", number=" + number +
                ", attitude=" + attitude +
                ", attitudeDelete=" + attitudeDelete +
                ", delete=" + delete +
                ", max=" + max +
                ", reply=" + reply +
                ", replyContent='" + replyContent + '\'' +
                '}';
    }
}
