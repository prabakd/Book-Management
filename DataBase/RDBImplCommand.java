/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author dhanush
 */
public abstract class RDBImplCommand {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/Library_System";

    //  Database credentials
    static final String USER = "root";
    
    static final String PASS = "000025";

    protected Object result;
    protected Connection conn;
    protected PreparedStatement statement;
    protected PreparedStatement statement1;
    protected ResultSet resultSet;
    
    public void execute() {
        try {
            connectDB();
            queryDB();
            disconnectDB();
        } catch (Exception e) {
            e.printStackTrace(System.err);
            disconnectDB();
        }
    }

    protected void connectDB() throws Exception {
        //System.out.println("Connecting MySQL DB");
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        //conn = DriverManager.getConnection("jdbc:derby://localhost:1527/advising;create=true;user=advising;password=advising");
    }

    protected void disconnectDB() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }
    }

    public Object getResult() {
        return result;
    }

    public abstract void queryDB() throws SQLException;

    public abstract void processResult();

    
}