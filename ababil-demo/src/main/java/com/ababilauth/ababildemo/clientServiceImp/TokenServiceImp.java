package com.ababilauth.ababildemo.clientServiceImp;

import com.ababilauth.ababildemo.clientService.TokenService;
import com.ababilauth.ababildemo.entity.TokenStore;
import com.ababilauth.ababildemo.model.AuthResponse;
import com.ababilauth.ababildemo.repository.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TokenServiceImp implements TokenService {
    @Autowired
    private TokenRepository tokenRepository;
    @Override
    public void save(AuthResponse authResponse) {
        Integer presentTime = Math.toIntExact(System.currentTimeMillis() / 1000);
        TokenStore token = new TokenStore();
        token.setAccessToken(authResponse.getAccess_token());
        token.setTokenType(authResponse.getToken_type());
        token.setfToken(authResponse.getF_Token());
        token.setRefreshToken(authResponse.getRefresh_token());
        token.setIsExpired(1);
        token.setExpiresAt(authResponse.getExpires_in()+presentTime);
        tokenRepository.save(token);
    }
    @Override
    public List<TokenStore> findByExpiresAtGreaterThan(Integer present){
        return tokenRepository.findByExpiresAtGreaterThan(present);
    }
}
