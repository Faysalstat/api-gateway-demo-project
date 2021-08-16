package com.ababilauth.ababildemo.domain;



import com.ababilauth.ababildemo.model.AccountDetails;

import java.util.List;

public class AccountDomain {
    private String status;
    private List<AccountDetails> accountList;

    public String getStatus() {
        return status;
    }

    public List<AccountDetails> getAccountList() {
        return accountList;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setAccountList(List<AccountDetails> accountList) {
        this.accountList = accountList;
    }
}
