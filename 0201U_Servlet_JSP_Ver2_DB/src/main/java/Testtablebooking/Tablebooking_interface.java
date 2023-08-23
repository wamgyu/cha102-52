package Testtablebooking;

import java.util.List;
import java.util.Set;

import Testgametable.GametableVO;

public interface Tablebooking_interface {
	
	public void insert(TablebookingVO tablebookingVO);
    public void update(TablebookingVO tablebookingVO);
    public void delete(Integer TABLE_BOOK_NO);
    public TablebookingVO findByPrimaryKey(Integer TABLE_BOOK_NO);
    public List<TablebookingVO> getAll();
    //查詢某部門的員工(一對多)(回傳 Set)
//    public Set<TablebookingVO> getEmpsByTable(Integer TABLE_BOOK_NO);
}

