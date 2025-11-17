package org.example.demo_transaction_bank.service;

import org.example.demo_transaction_bank.model.AccountBank;
import org.example.demo_transaction_bank.repository.AccountBankRepository;
import org.example.demo_transaction_bank.repository.IAccountBankRepository;

public class AccountBankService implements IAccountBankService {
    private IAccountBankRepository accountBankRepository = new AccountBankRepository();
    @Override
    public AccountBank findByUsernameAndPassword(String username, String password) {
        return accountBankRepository.findByUsernameAndPassword(username,password);
    }
}
