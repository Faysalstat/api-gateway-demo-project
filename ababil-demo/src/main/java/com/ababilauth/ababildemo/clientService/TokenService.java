package com.ababilauth.ababildemo.clientService;

import com.ababilauth.ababildemo.entity.TokenStore;
import com.ababilauth.ababildemo.model.AuthResponse;

import java.util.List;

public interface TokenService {
    public void save(AuthResponse authResponse);
    public List<TokenStore> findByExpiresAtGreaterThan(Integer present);
}
