package me.jomin.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestOracleJDBC {

	 String dbUrl = "jdbc:oracle:thin:@10.25.22.227:1530:hdora";    
	    String theUser = "hduser";    
	    String thePw = "paic1234";    
	    Connection c = null;    
	    Statement conn;    
	    ResultSet rs = null;    
	     
	    public TestOracleJDBC() {    
	       try {    
	           Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();    
	           c = DriverManager.getConnection(dbUrl, theUser, thePw);    
	           conn = c.createStatement();    
	       } catch (Exception e) {    
	           e.printStackTrace();    
	       }    
	    }    
	     
	    public boolean executeUpdate(String sql) {    
	       try {    
	           conn.executeUpdate(sql);    
	           return true;    
	       } catch (SQLException e) {    
	           e.printStackTrace();    
	           return false;    
	       }    
	    }    
	     
	    public ResultSet executeQuery(String sql) {    
	       rs = null;    
	       try {    
	           rs = conn.executeQuery(sql);    
	       } catch (SQLException e) {    
	           e.printStackTrace();    
	       }    
	       return rs;    
	    }    
	     
	    public void close() {    
	       try {    
	           conn.close();    
	           c.close();    
	       } catch (Exception e) {    
	           e.printStackTrace();    
	       }    
	    }    
	     
	    public static void main(String[] args) {    
	       ResultSet rs;    
	       TestOracleJDBC conn = new TestOracleJDBC();    
	       rs = conn.executeQuery("select * from t_hdfs_table ");    
	       try {    
	           while (rs.next()) {    
	              System.out.println(rs.getString(1)+"--");    
	           }    
	       } catch (Exception e) {    
	           e.printStackTrace();    
	       }    
	    }    
}
