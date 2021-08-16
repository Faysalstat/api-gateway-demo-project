package com.ababilauth.ababildemo.clientService;


import com.ababilauth.ababildemo.domain.AccountDomain;
import com.ababilauth.ababildemo.model.AuthResponse;

import java.util.Map;

public interface AbabilClientService {
    public AuthResponse getAuthentication(Map<String, String> map);
    public AccountDomain getDemandDepositAccount(String accountNumber, AuthResponse authResponse);
}
