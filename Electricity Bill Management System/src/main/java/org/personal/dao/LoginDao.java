package org.personal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.personal.bean.LoginBean;
import org.personal.connectionFactory.ConnectionFactory;

public class LoginDao {

    private static Connection connection;
    private static PreparedStatement preparedStatement;

    public boolean validate(LoginBean loginBean) throws ClassNotFoundException {
        boolean status = false;

        try {
            final String QUERY = "select * from user where username = ? and password = ? and role = ? ";
            connection = ConnectionFactory.getConnection();
            preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setString(1, loginBean.getUsername());
            preparedStatement.setString(2, loginBean.getPassword());
            preparedStatement.setString(3, loginBean.getRole());
            ResultSet rs = preparedStatement.executeQuery();
            status = rs.next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

}
