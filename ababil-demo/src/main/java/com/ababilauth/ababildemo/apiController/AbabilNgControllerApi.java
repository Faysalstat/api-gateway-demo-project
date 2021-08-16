package com.ababilauth.ababildemo.apiController;

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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/ababil")
public class AbabilNgControllerApi {
    @Autowired
    AbabilClientServiceImp ababilClientServiceImp;
    @Autowired
    private TokenRepository tokenRepository;

    @GetMapping("/{accountNumber}")
    public ResponseEntity<?> getAccountDetailsByNumber(@PathVariable String accountNumber){
        Map<String, String> map = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();
        List<TokenStore> tokenList = new ArrayList();
        tokenList= tokenRepository.findByIsExpired(1);
        map.put("grant_type", "Password");
        map.put("username", "treasury");
        map.put("password", "treasury");
        AuthResponse authResponse = ababilClientServiceImp.getAuthentication(map);
        AccountDomain accountList = ababilClientServiceImp.getDemandDepositAccount(accountNumber,authResponse);
//        Object res = mapper.readValue(response,Object.class);
        return ResponseEntity.ok(accountList);
    }
}
