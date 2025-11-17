package org.example.demo_transaction_bank.service;

import org.example.demo_transaction_bank.model.TransferInfo;

public interface ITransferService {
    String transfer(TransferInfo transferInfo);
}
