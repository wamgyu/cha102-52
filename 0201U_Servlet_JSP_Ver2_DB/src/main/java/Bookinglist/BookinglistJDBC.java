package Bookinglist;

import java.util.*;

import com.emp.model.EmpJDBCDAO;

import Testtablebooking.TablebookingVO;

import java.sql.*;

public class BookinglistJDBC implements Bookinglist_interface{

	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/head?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "0987242920";
	
	private static final String INSERT_STMT = "INSERT INTO bookinglist ( TABLE_NO, TABLE_DATE, PERIOD_TIME) VALUES ( ?, ?, ?)";
	private static final String GET_ALL_STMT = "SELECT BOOKING_NO, TABLE_NO, TABLE_DATE, BOOKING_CHECK_STATE, PERIOD_TIME FROM bookinglist order by BOOKING_NO";
	private static final String GET_ONE_STMT = "SELECT BOOKING_NO, TABLE_NO, TABLE_DATE, BOOKING_CHECK_STATE, PERIOD_TIME FROM bookinglist where BOOKING_NO = ?";
	private static final String DELETE = "DELETE FROM tablebooking where BOOKING_NO = ?";
	private static final String UPDATE = "UPDATE tablebooking set TABLE_NO=?, TABLE_DATE=?, BOOKING_CHECK_STATE=?, PERIOD_TIME=? where BOOKING_NO = ?";

	@Override
	public void insert(BookinglistVO bookinglistVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);
			
			pstmt.setInt(1, bookinglistVO.getTABLE_NO());
			pstmt.setDate(2, bookinglistVO.getTABLE_DATE());
			pstmt.setBytes(3, bookinglistVO.getPERIOD_TIME());
			
			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
	}
	
	@Override
	public void update(BookinglistVO bookinglistVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, bookinglistVO.getTABLE_NO());
			pstmt.setDate(2, bookinglistVO.getTABLE_DATE());
			pstmt.setBytes(3, bookinglistVO.getPERIOD_TIME());
			

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
	}
	
	@Override
	public void delete(Integer BOOKING_NO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, BOOKING_NO);

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
	}

	@Override
	public BookinglistVO findByPrimaryKey(Integer BOOKING_NO) {

		BookinglistVO bookinglistVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, BOOKING_NO);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo 也稱為 Domain objects
				bookinglistVO = new BookinglistVO();
				bookinglistVO.setBOOKING_NO(rs.getInt("BOOKING_NO"));
				bookinglistVO.setTABLE_NO(rs.getInt("TABLE_NO"));
				bookinglistVO.setTABLE_DATE(rs.getDate("TABLE_DATE"));
				bookinglistVO.setBOOKING_CHECK_STATE(rs.getBytes("BOOKING_CHECK_STATE"));
				bookinglistVO.setPERIOD_TIME(rs.getBytes("PERIOD_TIME"));
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return bookinglistVO;
	}
	
	@Override
	public List<BookinglistVO> getAll() {
		List<BookinglistVO> list = new ArrayList<BookinglistVO>();
		BookinglistVO bookinglistVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVO 也稱為 Domain objects
				bookinglistVO = new BookinglistVO();
				bookinglistVO.setBOOKING_NO(rs.getInt("BOOKING_NO"));
				bookinglistVO.setTABLE_NO(rs.getInt("TABLE_NO"));
				bookinglistVO.setTABLE_DATE(rs.getDate("TABLE_DATE"));
				bookinglistVO.setBOOKING_CHECK_STATE(rs.getBytes("BOOKING_CHECK_STATE"));
				bookinglistVO.setPERIOD_TIME(rs.getBytes("PERIOD_TIME"));
				list.add(bookinglistVO); // Store the row in the list
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return list;
	}
	public static void main(String[] args) {
	EmpJDBCDAO dao = new EmpJDBCDAO();
	
	// 新增
	BookinglistVO bookinglistVO = new BookinglistVO();
	bookinglistVO.setTABLE_NO("1");
	bookinglistVO.setTABLE_DATE("2005-01-01");
	bookinglistVO.setPERIOD_TIME(java.sql.Date.valueOf(""));
	
			dao.insert(bookinglistVO);
	}
	
}
