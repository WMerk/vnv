package com.vnv.entity;

public class GoogleCode {

    private String code;
    private String redirectUri;
    private String clientId;
    private String state;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRedirectUri() {
        return redirectUri;
    }

    public void setRedirectUri(String redirectUri) {
        this.redirectUri = redirectUri;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "GoogleCode{" +
                "code='" + code + '\'' +
                ", redirectUri='" + redirectUri + '\'' +
                ", clientId='" + clientId + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
