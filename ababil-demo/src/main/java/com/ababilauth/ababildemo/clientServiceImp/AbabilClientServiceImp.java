package com.ababilauth.ababildemo.clientServiceImp;

import com.ababilauth.ababildemo.clientService.AbabilClientService;
import com.ababilauth.ababildemo.domain.AccountDomain;
import com.ababilauth.ababildemo.model.AccountDetails;
import com.ababilauth.ababildemo.model.AuthResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Service
public class AbabilClientServiceImp implements AbabilClientService {

    @Override
    public AuthResponse getAuthentication(Map<String, String> map) {
        RestTemplate template = new RestTemplate();

        return template.postForObject("http://192.168.1.140:3030/oauth/token",map, AuthResponse.class);
    }

    @Override
    public AccountDomain getDemandDepositAccount(String accountNumber, AuthResponse authResponse) {
        RestTemplate template = new RestTemplate();
        List<AccountDetails> list = new ArrayList();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        headers.set("Authorization", "bearer "+authResponse.getAccess_token());
        HttpEntity entity = new HttpEntity(headers);

        ResponseEntity<AccountDetails> response = template.exchange(
                "http://192.168.1.140:3030/ababil-deposit/api/demand-deposit-accounts/"+accountNumber, HttpMethod.GET, entity, AccountDetails.class);
        AccountDomain account = new AccountDomain();
        account.setStatus("Success");
        list.add(response.getBody());
        account.setAccountList(list);
        ObjectMapper mapper = new ObjectMapper();
        return account;
    }
}
