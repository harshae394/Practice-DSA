package javaproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.DatabaseMetaData;

public class JDBCTest {

    public static void main(String[] args) {
	{
	        Connection connection = null;
	        try {
	            // below two lines are used for connectivity.
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            connection = DriverManager.getConnection(
	                "jdbc:mysql://10.1.240.118:3306/b2dspace",
	                "b2duser", "b2duser");
	 
	            // mydb is database
	            // mydbuser is name of database
	            // mydbuser is password of database
	            System.out.println("Connection is created succcessfully:");
	            ResultSet rs = null;
	            DatabaseMetaData meta = (DatabaseMetaData) connection.getMetaData();
	            rs = meta.getTables(null, null, null, new String[] {
	               "TABLE"
	            });
	            int count = 0;
	            System.out.println("All table names are in test database:");
	            while (rs.next()) {
	               String tblName = rs.getString("TABLE_NAME");
	               System.out.println(tblName);
	               count++;
	            }
	            System.out.println(count + " Rows in set ");
	            connection.close();
	        }
	        catch (Exception exception) {
	            System.out.println(exception);
	        }
	    } // function ends
    }

}
