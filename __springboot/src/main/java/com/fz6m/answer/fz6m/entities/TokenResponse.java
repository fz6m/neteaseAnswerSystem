package com.fz6m.answer.fz6m.entities;

public class TokenResponse {

    private Integer code;

    private String token;

    public TokenResponse() {
    }

    public TokenResponse(Integer code) {
        this.code = code;
    }

    public TokenResponse(Integer code, String token) {
        this.code = code;
        this.token = token;
    }

    @Override
    public String toString() {
        return "TokenResponse{" +
                "code=" + code +
                ", token='" + token + '\'' +
                '}';
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
