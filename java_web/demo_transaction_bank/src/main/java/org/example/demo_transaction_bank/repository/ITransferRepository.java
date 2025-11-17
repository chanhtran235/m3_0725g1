package org.example.demo_transaction_bank.repository;

import org.example.demo_transaction_bank.model.TransferInfo;

public interface ITransferRepository {
    String transfer(TransferInfo transferInfo);
}
