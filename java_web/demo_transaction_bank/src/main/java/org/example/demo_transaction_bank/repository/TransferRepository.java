package org.example.demo_transaction_bank.repository;

import org.example.demo_transaction_bank.model.TransferInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransferRepository implements ITransferRepository {
    private final String GET_ACOUNT_BANK = "select * from account_bank where account_number =?;";
    //    private final String UPDATE_MONEY = "update account_bank set total_money =? where account_number=?";
    private final String MONEY_ADD = "update account_bank set total_money =((select * from (select total_money from account_bank where account_number=?)as temp)+?) where account_number=?;\n";
    private final String MONEY_SUB = "update account_bank set total_money =((select * from (select total_money from account_bank where account_number=?)as temp)-?) where account_number=?;\n";
    private final String CREATE_HISTORY = "insert into history(transfer_money,content,account_source,account_target)\n" +
            " values(?,?,?,?);";

    @Override
    public String transfer(TransferInfo transferInfo) {
        String message = "";
 
        Connection connection = BaseRepository.getConnectDB();
        try {
            connection.setAutoCommit(false);
            int rowEffect = 0; // đếm số lượt thay đổi

            // Hoạt động 1 : cộng tiền tài khoản đích
            PreparedStatement preTarget = connection.prepareStatement(MONEY_ADD);
            preTarget.setString(1, String.valueOf(transferInfo.getAccountTarget()));
            preTarget.setDouble(2, transferInfo.getMoneyTransfer());
            preTarget.setString(3, String.valueOf(transferInfo.getAccountTarget()));
            try {
                rowEffect += preTarget.executeUpdate();
                if (rowEffect == 0) {
                    message = "Sai tên tài khoản";
                }
            } catch (Exception e) {

            }

            // Hoạt động 2 : Trừ tiền tài khoản gốc
            PreparedStatement preSource = connection.prepareStatement(MONEY_SUB);
            preSource.setString(1, String.valueOf(transferInfo.getAccountSource()));
            preSource.setDouble(2, transferInfo.getMoneyTransfer());
            preSource.setString(3, String.valueOf(transferInfo.getAccountSource()));

            try {
                rowEffect += preSource.executeUpdate();
            } catch (Exception e) {
                message = "Số tiền không đủ";
            }
            // kiểm tra tất cả ok thì lưu vào db
            if (rowEffect == 2) {
                // lưu lich sử
                PreparedStatement preHistory = connection.prepareStatement(CREATE_HISTORY);
                preHistory.setDouble(1, transferInfo.getMoneyTransfer());
                preHistory.setString(2, transferInfo.getContent());
                preHistory.setString(3, String.valueOf(transferInfo.getAccountSource()));
                preHistory.setString(4, String.valueOf(transferInfo.getAccountTarget()));
                rowEffect += preHistory.executeUpdate();
                // bắt đầu lưu toàn bộ vào db
                connection.commit();
                message = "Chuyển tiền thành công";
            } else {
                connection.rollback();
            }

        } catch (SQLException e) {
            // bị lỗi bất kỳ hoạt động nào thì sẽ rollback
            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            message = "Chuyển tiền thất bại";
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return message;
    }
}
