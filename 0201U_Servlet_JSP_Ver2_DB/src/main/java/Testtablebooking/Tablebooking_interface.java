package Testtablebooking;

import java.sql.Date;
import java.util.List;
import java.util.Set;

import Bookinglist.BookinglistVO;
import Testgametable.GametableVO;

public interface Tablebooking_interface {
	
	public void insert(TablebookingVO tablebookingVO);
    public void update(TablebookingVO tablebookingVO);
    public void delete(Integer TABLE_BOOK_NO);
    public TablebookingVO findByPrimaryKey(Integer TABLE_BOOK_NO);
    public List<TablebookingVO> getAll();
    //查詢某部門的員工(一對多)(回傳 Set)
    public List<TablebookingVO> getten();
    public TablebookingVO getTableBookingByNo(Integer TABLE_NO);
}

