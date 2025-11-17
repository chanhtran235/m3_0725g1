package org.example.demo_transaction_bank.repository;

import org.example.demo_transaction_bank.model.AccountBank;

public interface IAccountBankRepository {
    AccountBank findByUsernameAndPassword(String username, String password);
}
