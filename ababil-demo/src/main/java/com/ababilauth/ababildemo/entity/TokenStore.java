package com.ababilauth.ababildemo.entity;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "token_store",
        catalog = "ababil_auth_db"
)
public class TokenStore implements Serializable {
    private long id;
    private String accessToken;
    private String fToken;
    private String tokenType;
    private String refreshToken;
    private Date expiresAt;
    private int isExpired;

    public TokenStore() {
    }

    public TokenStore(long id, String accessToken, String fToken, String tokenType, String refreshToken, Date expiresAt, int isExpired) {
        this.id = id;
        this.accessToken = accessToken;
        this.fToken = fToken;
        this.tokenType = tokenType;
        this.refreshToken = refreshToken;
        this.expiresAt = expiresAt;
        this.isExpired = isExpired;
    }
    @Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name = "id", unique = true, nullable = false)
    public long getId() {
        return id;
    }

    @Column(name="ACCESS_TOKEN")
    public String getAccessToken() {
        return accessToken;
    }
    @Column(name="F_TOKEN")
    public String getfToken() {
        return fToken;
    }
    @Column(name="TOKEN_TYPE")
    public String getTokenType() {
        return tokenType;
    }
    @Column(name="REFRESH_TOKEN")
    public String getRefreshToken() {
        return refreshToken;
    }
    @Column(name="EXPIRES_AT")
    public Date getExpiresAt() {
        return expiresAt;
    }
    @Column(name="IS_EXPIRED")
    public int getIsExpired() {
        return isExpired;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public void setfToken(String fToken) {
        this.fToken = fToken;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public void setExpiresAt(Date expiresAt) {
        this.expiresAt = expiresAt;
    }

    public void setIsExpired(int isExpires) {
        this.isExpired = isExpires;
    }
}
