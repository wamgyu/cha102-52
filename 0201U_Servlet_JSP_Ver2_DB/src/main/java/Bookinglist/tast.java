package Bookinglist;

import java.util.*;
import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.emp.model.EmpJDBCDAO;
import com.emp.model.EmpVO;

public class tast {
	public static void main(String[] args) {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/head?serverTimezone=Asia/Taipei";
		String userid = "root";
		String passwd = "0987242920";
		
		private static final String INSERT_STMT = "INSERT INTO bookinglist ( TABLE_NO, TABLE_DATE, PERIOD_TIME) VALUES ( ?, ?, ?)";
		private static final String GET_ALL_STMT = "SELECT BOOKING_NO, TABLE_NO, TABLE_DATE, BOOKING_CHECK_STATE, PERIOD_TIME FROM bookinglist order by BOOKING_NO";
		private static final String GET_ONE_STMT = "SELECT BOOKING_NO, TABLE_NO, TABLE_DATE, BOOKING_CHECK_STATE, PERIOD_TIME FROM bookinglist where BOOKING_NO = ?";
		private static final String DELETE = "DELETE FROM tablebooking where BOOKING_NO = ?";
		private static final String UPDATE = "UPDATE tablebooking set TABLE_NO=?, TABLE_DATE=?, BOOKING_CHECK_STATE=?, PERIOD_TIME=? where BOOKING_NO = ?";

		
		
		
		
		
		
		
		
		
		
		
	}
}
