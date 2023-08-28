package Bookinglist;

import java.util.List;

import Testtablebooking.TablebookingVO;

public interface Bookinglist_interface {

	public void insert(BookinglistVO bookinglistVO);
    public void update(BookinglistVO bookinglistVO);
    public void delete(Integer BOOKING_NO);
    public BookinglistVO findByPrimaryKey(Integer BOOKING_NO);
    public List<BookinglistVO> getAll();
    
}
