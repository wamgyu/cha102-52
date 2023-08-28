package Testtablebooking;

import java.util.*;
import java.sql.*;
import java.sql.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.emp.model.EmpVO;

public class TablebookingDAO implements Tablebooking_interface {

	// 一個應用程式中,針對一個資料庫 ,共用一個DataSource即可
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Testhead");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private static final String INSERT_STMT = "INSERT INTO tablebooking ( TABLE_DATE, TABLE_NO, TABLE_MOR, TABLE_EVE, TABLE_NIGHT) VALUES ( ?, ?, ?, ?, ?)";
	private static final String GET_ALL_STMT = "SELECT TABLE_BOOK_NO, TABLE_DATE, TABLE_NO, TABLE_MOR, TABLE_EVE, TABLE_NIGHT FROM tablebooking order by TABLE_BOOK_NO";
	private static final String GET_ONE_STMT = "SELECT TABLE_BOOK_NO, TABLE_DATE, TABLE_NO, TABLE_MOR, TABLE_EVE, TABLE_NIGHT FROM tablebooking where TABLE_BOOK_NO = ?";
	private static final String DELETE = "DELETE FROM tablebooking where TABLE_BOOK_NO = ?";
	private static final String UPDATE = "UPDATE tablebooking set TABLE_DATE=?, TABLE_NO=?, TABLE_MOR=?, TABLE_EVE=?, TABLE_NIGHT=? where TABLE_BOOK_NO = ?";
	private static final String GET_TENDAY_STMT = "SELECT * FROM tablebooking WHERE TABLE_DATE BETWEEN CURDATE() AND DATE_ADD(CURDATE(), INTERVAL 10 DAY) ORDER BY TABLE_DATE";
	private static final String GET_BY_TABLE_NO = "SELECT TABLE_NO, TABLE_DATE, TABLE_MOR, TABLE_EVE, TABLE_NIGHT FROM tablebooking where TABLE_NO = ?";

	
	
	@Override
	public void insert(TablebookingVO tablebookingVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setDate(1, tablebookingVO.getTABLE_DATE());
			pstmt.setInt(2, tablebookingVO.getTABLE_NO());
			pstmt.setInt(3, tablebookingVO.getTABLE_MOR());
			pstmt.setInt(4, tablebookingVO.getTABLE_EVE());
			pstmt.setInt(5, tablebookingVO.getTABLE_NIGHT());

			pstmt.executeUpdate();

			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
	public void update(TablebookingVO tablebookingVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setDate(1, tablebookingVO.getTABLE_DATE());
			pstmt.setInt(2, tablebookingVO.getTABLE_NO());
			pstmt.setInt(3, tablebookingVO.getTABLE_MOR());
			pstmt.setInt(4, tablebookingVO.getTABLE_EVE());
			pstmt.setInt(5, tablebookingVO.getTABLE_NIGHT());
			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
	public void delete(Integer TABLE_BOOK_NO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, TABLE_BOOK_NO);
			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
	public TablebookingVO findByPrimaryKey(Integer TABLE_NO) {

		TablebookingVO tablebookingVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, TABLE_NO);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo 也稱為 Domain objects
				tablebookingVO = new TablebookingVO();
				tablebookingVO.setTABLE_BOOK_NO(rs.getInt("TABLE_NO"));
				tablebookingVO.setTABLE_DATE(rs.getDate("TABLE_DATE"));
				tablebookingVO.setTABLE_MOR(rs.getInt("TABLE_MOR"));
				tablebookingVO.setTABLE_EVE(rs.getInt("TABLE_EVE"));
				tablebookingVO.setTABLE_NIGHT(rs.getInt("TABLE_NIGHT"));

			}

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
		return tablebookingVO;
	}

	@Override
	public List<TablebookingVO> getAll() {
		List<TablebookingVO> list = new ArrayList<TablebookingVO>();
		TablebookingVO tablebookingVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVO 也稱為 Domain objects
				tablebookingVO = new TablebookingVO();
				tablebookingVO.setTABLE_BOOK_NO(rs.getInt("TABLE_BOOK_NO"));
				tablebookingVO.setTABLE_DATE(rs.getDate("TABLE_DATE"));
				tablebookingVO.setTABLE_NO(rs.getInt("TABLE_NO"));
				tablebookingVO.setTABLE_MOR(rs.getInt("TABLE_MOR"));
				tablebookingVO.setTABLE_EVE(rs.getInt("TABLE_EVE"));
				tablebookingVO.setTABLE_NIGHT(rs.getInt("TABLE_NIGHT"));
				list.add(tablebookingVO); // Store the row in the list
			}

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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

	@Override
	public List<TablebookingVO> getten() {
		List<TablebookingVO> list = new ArrayList<TablebookingVO>();
		
		TablebookingVO tablebookingVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_TENDAY_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVO 也稱為 Domain objects
				tablebookingVO = new TablebookingVO();
				tablebookingVO.setTABLE_DATE(rs.getDate("TABLE_DATE"));
				tablebookingVO.setTABLE_MOR(rs.getInt("TABLE_MOR"));
				tablebookingVO.setTABLE_EVE(rs.getInt("TABLE_EVE"));
				tablebookingVO.setTABLE_NIGHT(rs.getInt("TABLE_NIGHT"));
				list.add(tablebookingVO); // Store the row in the list
			}

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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

	public TablebookingVO getTableBookingByNo(Integer TABLE_NO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		TablebookingVO tablebookingVO = null;
		
		try {
			// 假設你有一個DataSource或者Connection可用
			con = ds.getConnection();

			pstmt = con.prepareStatement(GET_BY_TABLE_NO);
			con = ds.getConnection();
			rs = pstmt.executeQuery();

			if (rs.next()) {
				tablebookingVO = new TablebookingVO();
				tablebookingVO.setTABLE_NO(rs.getInt("TABLE_NO"));
				tablebookingVO.setTABLE_DATE(rs.getDate("TABLE_DATE"));
				tablebookingVO.setTABLE_MOR(rs.getInt("TABLE_MOR"));
				tablebookingVO.setTABLE_EVE(rs.getInt("TABLE_EVE"));
				tablebookingVO.setTABLE_NIGHT(rs.getInt("TABLE_NIGHT"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// 你可能還希望進一步處理這個例外
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		return tablebookingVO;
	}

}