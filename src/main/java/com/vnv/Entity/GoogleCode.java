package com.vnv.Entity;

public class GoogleCode {

    private String code;
    private String redirectUri;
    private String client_id;
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

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
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
                ", client_id='" + client_id + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
