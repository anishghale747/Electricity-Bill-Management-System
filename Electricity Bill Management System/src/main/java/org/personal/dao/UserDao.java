package org.personal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.personal.bean.User;
import org.personal.connectionFactory.ConnectionFactory;

public class UserDao {
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	
	public void insertUser(User user) throws SQLException, ClassNotFoundException {
		try {
			final String QUERY = "INSERT INTO user" + "  (username, password, first_name, last_name, role) VALUES " + " (?, ?, ?, ?, ?);";
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement(QUERY);
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getFirstName());
			preparedStatement.setString(4, user.getLastName());
			preparedStatement.setString(5, user.getRole());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public User selectUser(String userName) throws ClassNotFoundException {
		User user = null;
		try {
			final String QUERY = "select username, password, first_name, last_name, role from user where username =?";
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement(QUERY);
			preparedStatement.setString(1, userName);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String username = rs.getString("username");
				String password = rs.getString("password");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				String role = rs.getString("role");
				user = new User(username, password, firstName, lastName, role);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public List<User> selectAllUsers() throws ClassNotFoundException {
		List<User> users = new ArrayList<>();
		try {
			final String QUERY = "select * from user";
			connection = ConnectionFactory.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String username = rs.getString("username");
				String password = rs.getString("password");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				String role = rs.getString("role");
				users.add(new User(username, password, firstName, lastName, role));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
	
	public boolean deleteUser(String username) throws SQLException, ClassNotFoundException {
		boolean rowDeleted;
		final String QUERY = "delete from user where username = ?";
		connection = ConnectionFactory.getConnection();
		preparedStatement = connection.prepareStatement(QUERY);
		preparedStatement.setString(1, username);
		rowDeleted = preparedStatement.executeUpdate() > 0;
		return rowDeleted;
	}
	
	public boolean updateUser(User user) throws SQLException, ClassNotFoundException {
		boolean rowUpdated;
		final String QUERY = "UPDATE user set password= ?, first_name = ?, last_name = ?, role = ? WHERE username = ?";
		connection = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(QUERY);     
        preparedStatement.setString(1, user.getPassword());
        preparedStatement.setString(2, user.getFirstName());
        preparedStatement.setString(3, user.getLastName());
        preparedStatement.setString(4, user.getRole());
        preparedStatement.setString(5, user.getUsername());
		rowUpdated = preparedStatement.executeUpdate() > 0;
		return rowUpdated;

	}
	
	
}
