package com.ababilauth.ababildemo.model;

public class AuthResponse {
    private String access_token;
    private String token_type;
    private String refresh_token;
    private Integer expires_in;
    private String f_Token;

    public String getAccess_token() {
        return access_token;
    }

    public String getToken_type() {
        return token_type;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public Integer getExpires_in() {
        return expires_in;
    }

    public String getF_Token() {
        return f_Token;
    }

    public void setF_Token(String f_Token) {
        this.f_Token = f_Token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public void setExpires_in(Integer expires_in) {
        this.expires_in = expires_in;
    }
}

