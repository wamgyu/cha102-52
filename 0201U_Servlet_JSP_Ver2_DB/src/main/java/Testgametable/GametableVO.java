package Testgametable;

public class GametableVO implements java.io.Serializable{
	
	private Integer TABLE_NO;
	private Integer TABLE_TYPE;
	private String TABLE_MANE;
	
	public String getTABLE_MANE() {
		return TABLE_MANE;
	}
	public void setTABLE_MANE(String tABLE_MANE) {
		TABLE_MANE = tABLE_MANE;
	}
	
	
	public Integer getTABLE_NO() {
		return TABLE_NO;
	}
	public void setTABLE_NO(Integer tABLE_NO) {
		TABLE_NO = tABLE_NO;
	}
	
	
	public Integer getTABLE_TYPE() {
		return TABLE_TYPE;
	}
	public void setTABLE_TYPE(Integer tABLE_TYPE) {
		TABLE_TYPE = tABLE_TYPE;
	}
	
	

}
