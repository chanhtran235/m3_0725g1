package org.example.demo_transaction_bank.service;

import org.example.demo_transaction_bank.model.AccountBank;

public interface IAccountBankService {
    AccountBank findByUsernameAndPassword(String username, String password);
}
