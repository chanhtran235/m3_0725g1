package org.example.demo_transaction_bank.repository;

import org.example.demo_transaction_bank.model.AccountBank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountBankRepository implements IAccountBankRepository{
    private final String FIND_ACCOUNT="select * from account_bank where username =? and password =?;";
    @Override
    public AccountBank findByUsernameAndPassword(String username, String password) {
        Connection connection = BaseRepository.getConnectDB();
        AccountBank accountBank = null;
        try {
            PreparedStatement pre = connection.prepareStatement(FIND_ACCOUNT);
            pre.setString(1,username);
            pre.setString(2,password);
            ResultSet resultSet = pre.executeQuery();
            while (resultSet.next()){
                String user = resultSet.getString("username");
                String pass = resultSet.getString("password");
                String name = resultSet.getString("owner_name");
                String numAccount = resultSet.getString("account_number");
                double totalMoney = resultSet.getDouble("total_money");
                accountBank = new AccountBank(numAccount,user,pass,name,totalMoney);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return accountBank;
    }
}
