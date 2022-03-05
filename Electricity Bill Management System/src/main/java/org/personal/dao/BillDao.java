package org.personal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.personal.connectionFactory.ConnectionFactory;
import org.personal.bean.Bill;

public class BillDao {
	private static Connection connection;
	private static PreparedStatement preparedStatement;

	public void insertBill(Bill bill) throws SQLException, ClassNotFoundException {
		try {
			final String QUERY = "INSERT INTO bill" + "  (username, month, total_amount, is_paid) VALUES " + " (?, ?, ?, ?);";
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement(QUERY);
			preparedStatement.setString(1, bill.getUsername());
			preparedStatement.setString(2, bill.getMonth());
			preparedStatement.setString(3, bill.getTotalAmount());
			preparedStatement.setString(4, bill.getStatus());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Bill selectBill(String userName) throws ClassNotFoundException {
		Bill bill = null;
		try {
			final String QUERY = "select username, month, total_amount, is_paid from bill where username =?";
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement(QUERY);
			preparedStatement.setString(1, userName);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String username = rs.getString("username");
				String month = rs.getString("month");
				String totalAmount = rs.getString("total_amount");
				String isPaid = rs.getString("is_paid");
				bill = new Bill(username, month, totalAmount, isPaid);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bill;
	}

	public List<Bill> selectAllBills() throws ClassNotFoundException {
		List<Bill> bills = new ArrayList<>();
		try {
			final String QUERY = "select * from bill";
			connection = ConnectionFactory.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String username = rs.getString("username");
				String month = rs.getString("month");
				String totalAmount = rs.getString("total_amount");
				String isPaid = rs.getString("is_paid");
				bills.add(new Bill(id, username, month, totalAmount, isPaid));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bills;
	}

	public boolean deleteBill(String username) throws SQLException, ClassNotFoundException {
		boolean rowDeleted;
		final String QUERY = "delete from bill where username = ?";
		connection = ConnectionFactory.getConnection();
		preparedStatement = connection.prepareStatement(QUERY);
		preparedStatement.setString(1, username);
		rowDeleted = preparedStatement.executeUpdate() > 0;
		return rowDeleted;
	}

	public boolean updateBill(Bill bill) throws SQLException, ClassNotFoundException {
		boolean rowUpdated;
		final String QUERY = "UPDATE bill set month= ?, total_amount = ?, is_paid = ? WHERE username = ? ";
		connection = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(QUERY);     
        preparedStatement.setString(1, bill.getMonth());
        preparedStatement.setString(2, bill.getTotalAmount());
        preparedStatement.setString(3, bill.getStatus());
        preparedStatement.setString(4, bill.getUsername());
       
		rowUpdated = preparedStatement.executeUpdate() > 0;
		return rowUpdated;

	}

}
