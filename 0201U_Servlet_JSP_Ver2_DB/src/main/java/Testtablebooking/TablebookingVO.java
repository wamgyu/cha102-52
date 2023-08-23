package Testtablebooking;

import java.sql.Date;

public class TablebookingVO implements java.io.Serializable{
	
	private Integer TABLE_BOOK_NO;
	private Date TABLE_DATE;
	private Integer TABLE_NO;
	private byte [] TABLE_MOR;
	private byte [] TABLE_EVE;
	private byte [] TABLE_NIGHT;
	
	//編號
	public Integer getTABLE_BOOK_NO() {
		return TABLE_BOOK_NO;
	}
	public void setTABLE_BOOK_NO(Integer tABLE_BOOK_NO) {
		TABLE_BOOK_NO = tABLE_BOOK_NO;
	}
	
	//日期
	public Date getTABLE_DATE() {
		return TABLE_DATE;
	}
	public void setTABLE_DATE(Date tABLE_DATE) {
		TABLE_DATE = tABLE_DATE;
	}
	
	//桌型
	public Integer getTABLE_NO() {
		return TABLE_NO;
	}
	public void setTABLE_NO(Integer tABLE_NO) {
		TABLE_NO = tABLE_NO;
	}
	
	//上午(9-12)
	public byte[] getTABLE_MOR() {
		return TABLE_MOR;
	}
	public void setTABLE_MOR(byte[] tABLE_MOR) {
		TABLE_MOR = tABLE_MOR;
	}
	
	//下午(1-4)
	public byte[] getTABLE_EVE() {
		return TABLE_EVE;
	}
	public void setTABLE_EVE(byte[] tABLE_EVE) {
		TABLE_EVE = tABLE_EVE;
	}
	
	//晚上(6-8)
	public byte[] getTABLE_NIGHT() {
		return TABLE_NIGHT;
	}
	public void setTABLE_NIGHT(byte[] tABLE_NIGHT) {
		TABLE_NIGHT = tABLE_NIGHT;
	}
	
	// for join dname from Gametable從桌型的VO抓取桌型編號資料傳回來這邊調用如果欄位有別的表格要這樣叫
	public Testgametable.GametableVO getGametableVO() {
		Testgametable.GametableService tableSvc = new Testgametable.GametableService();
		Testgametable.GametableVO GametableVO = tableSvc.getOneGametable(TABLE_NO);
		return GametableVO;
	}
}
