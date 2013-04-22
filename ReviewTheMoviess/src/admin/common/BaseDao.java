package admin.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class BaseDao {

    protected Connection connection;
    protected Statement statement;
    protected ResultSet resultSet;
    protected PreparedStatement preparedStatement;
    protected String query;

    public void connect() throws Exception {
        String username = "root";
        String password = "root";
        String url = "jdbc:mysql://localhost:3306/reviewthemovie";
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
            connection.close();
            throw e;
        }

    }



    public void close(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }


}