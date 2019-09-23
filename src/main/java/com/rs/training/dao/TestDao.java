package com.rs.training.dao;

import java.sql.*;
import java.util.Properties;

public class TestDao {

  private Connection getConnection() throws SQLException {
    Properties connectionProps = new Properties();
    connectionProps.put("user", "training");
    connectionProps.put("password", "training");

    String url = "jdbc:postgresql://localhost:9999/training";

    Connection conn = DriverManager.getConnection(url, connectionProps);

    return conn;
  }

  public String getName(int id) throws SQLException {
    PreparedStatement preparedStatement = getConnection().prepareStatement("select name from training where id = ?");
    preparedStatement.setInt(1,id);
    boolean execute = preparedStatement.execute();
    ResultSet resultSet = preparedStatement.getResultSet();
    while (resultSet.next()){
      String string = resultSet.getString(1);
      return string;
    }
    return "";
  }


}
