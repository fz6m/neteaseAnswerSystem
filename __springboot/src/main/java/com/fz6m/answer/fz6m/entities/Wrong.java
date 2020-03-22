package com.fz6m.answer.fz6m.entities;

public class Wrong {

    private Integer id;

    private boolean reply;

    private String replyContent;

    private String content;

    private Integer rawAnswer;

    private Integer answer;

    private boolean attitude;

    private boolean attitudeDelete;

    private boolean delete;

    public Wrong() {
    }

    public Wrong(Integer id, boolean reply, String replyContent, String content, Integer rawAnswer, Integer answer, boolean attitude, boolean attitudeDelete, boolean delete) {
        this.id = id;
        this.reply = reply;
        this.replyContent = replyContent;
        this.content = content;
        this.rawAnswer = rawAnswer;
        this.answer = answer;
        this.attitude = attitude;
        this.attitudeDelete = attitudeDelete;
        this.delete = delete;
    }

    @Override
    public String toString() {
        return "Wrong{" +
                "id=" + id +
                ", reply=" + reply +
                ", replyContent='" + replyContent + '\'' +
                ", content='" + content + '\'' +
                ", rawAnswer=" + rawAnswer +
                ", answer=" + answer +
                ", attitude=" + attitude +
                ", attitudeDelete=" + attitudeDelete +
                ", delete=" + delete +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getRawAnswer() {
        return rawAnswer;
    }

    public void setRawAnswer(Integer rawAnswer) {
        this.rawAnswer = rawAnswer;
    }

    public Integer getAnswer() {
        return answer;
    }

    public void setAnswer(Integer answer) {
        this.answer = answer;
    }

    public boolean isAttitude() {
        return attitude;
    }

    public void setAttitude(boolean attitude) {
        this.attitude = attitude;
    }

    public boolean isAttitudeDelete() {
        return attitudeDelete;
    }

    public void setAttitudeDelete(boolean attitudeDelete) {
        this.attitudeDelete = attitudeDelete;
    }

    public boolean isDelete() {
        return delete;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }
}
