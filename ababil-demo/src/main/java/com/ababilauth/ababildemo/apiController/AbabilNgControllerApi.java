package com.ababilauth.ababildemo.apiController;

import com.ababilauth.ababildemo.clientService.TokenService;
import com.ababilauth.ababildemo.clientServiceImp.AbabilClientServiceImp;
import com.ababilauth.ababildemo.domain.AccountDomain;
import com.ababilauth.ababildemo.entity.TokenStore;
import com.ababilauth.ababildemo.model.AuthResponse;
import com.ababilauth.ababildemo.repository.TokenRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.*;

@Controller
@RequestMapping("/ababil")
public class AbabilNgControllerApi {
    @Autowired
    AbabilClientServiceImp ababilClientServiceImp;
    @Autowired
    private TokenService tokenService;

    @GetMapping("/{accountNumber}")
    public ResponseEntity<?> getAccountDetailsByNumber(@PathVariable String accountNumber){
        AuthResponse authResponse = getAuthToken();
        AccountDomain accountList = ababilClientServiceImp.getDemandDepositAccount(accountNumber,authResponse);
        return ResponseEntity.ok(accountList);
    }

    private AuthResponse getAuthToken(){
        List<TokenStore> tokenList = new ArrayList();
        AuthResponse authResponse = new AuthResponse();
        tokenList = tokenService.findByExpiresAtGreaterThan(Math.toIntExact(System.currentTimeMillis() / 1000));
        if(tokenList.size() == 0){
            Map<String, String> map = new HashMap<>();
            map.put("grant_type", "Password");
            map.put("username", "treasury");
            map.put("password", "treasury");
            authResponse = ababilClientServiceImp.getAuthentication(map);
            tokenService.save(authResponse);
            return authResponse;
        }else{
            authResponse.setAccess_token(tokenList.get(0).getAccessToken());
        }
        return authResponse;
    }

}
