package Testgametable;

import java.util.*;

import Testgametable.GametableVO;

public interface Gametable_interface {
	public void insert(GametableVO gametableVO);
    public void update(GametableVO gametableVO);
    public void delete(Integer TABLE_NO);
    public GametableVO findByPrimaryKey(Integer TABLE_NO);
    public List<GametableVO> getAll();
//    public Set<GametableVO> getEmpsByTABLE_NO(Integer TABLE_NO);
}
