package org.example.demo_transaction_bank.service;

import org.example.demo_transaction_bank.model.TransferInfo;
import org.example.demo_transaction_bank.repository.ITransferRepository;
import org.example.demo_transaction_bank.repository.TransferRepository;

public class TransferService implements ITransferService{
    private ITransferRepository transferRepository =new TransferRepository();
    @Override
    public String transfer(TransferInfo transferInfo) {
        return transferRepository.transfer(transferInfo);
    }
}
