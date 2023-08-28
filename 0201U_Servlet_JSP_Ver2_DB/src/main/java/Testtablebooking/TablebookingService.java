package Testtablebooking;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import com.dept.model.DeptDAO;
import com.dept.model.DeptDAO_interface;
import com.dept.model.DeptVO;
import com.emp.model.EmpVO;

public class TablebookingService {
	private Tablebooking_interface dao;

	public TablebookingService() {
		dao = new TablebookingDAO();
	}

	public TablebookingVO addtablebooking(java.sql.Date TABLE_DATE, Integer TABLE_NO, Integer TABLE_MOR,
			Integer TABLE_EVE, Integer TABLE_NIGHT) {

		TablebookingVO tablebookingVO = new TablebookingVO();

		tablebookingVO.setTABLE_DATE(TABLE_DATE);
		tablebookingVO.setTABLE_NO(TABLE_NO);
		tablebookingVO.setTABLE_MOR(TABLE_MOR);
		tablebookingVO.setTABLE_EVE(TABLE_EVE);
		tablebookingVO.setTABLE_NIGHT(TABLE_NIGHT);
		
		dao.insert(tablebookingVO);

		return tablebookingVO;
	}

	//預留給 Struts 2 或 Spring MVC 用
	public void addtablebooking(TablebookingVO tablebookingVO) {
		dao.insert(tablebookingVO);
	}
	
	public TablebookingVO tablebookingVO(Integer TABLE_NO, Integer TABLE_MOR,
			Integer TABLE_EVE, Integer TABLE_NIGHT) {
		
		TablebookingVO tablebookingVO = new TablebookingVO();
		tablebookingVO.setTABLE_BOOK_NO(TABLE_NO);
		tablebookingVO.setTABLE_MOR(TABLE_MOR);
		tablebookingVO.setTABLE_EVE(TABLE_EVE);
		tablebookingVO.setTABLE_NIGHT(TABLE_NIGHT);
		dao.update(tablebookingVO);

		return dao.findByPrimaryKey(TABLE_NO);
	}
	
	public List<TablebookingVO> getAll() {
		return dao.getAll();
	}
	
	public List<TablebookingVO> getten() {
		return dao.getten();
	}

	public TablebookingVO getOneTablebooking(Integer TABLE_DATE) {
		return dao.findByPrimaryKey(TABLE_DATE);
	}

//	public Set<TablebookingVO> getEmpsByTABLE_DATE(Date TABLE_DATE) {
//		return dao.getOneTablebooking(TABLE_DATE);
//	}

	public void deleteblebooking(Integer TABLE_BOOK_NO) {
		dao.delete(TABLE_BOOK_NO);
	}
	
	public TablebookingVO getdayandtime(Integer TABLE_DATE) {
		return dao.findByPrimaryKey(TABLE_DATE);
	}
	
}
