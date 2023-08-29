package web.booking.service;

import org.hibernate.SessionFactory;
import web.booking.dao.BookingDao;
import web.booking.dao.BookingDaoImpl;
import web.booking.vo.BookingVo;
import web.booking.vo.TableBookingVo;

import java.sql.Date;
import java.util.List;

public class BookingServiceImpl implements BookingService {
    private SessionFactory sessionFactory;

    private BookingDao Dao;
    public BookingServiceImpl(){
        Dao = new BookingDaoImpl();
    }
    @Override
    public List<BookingVo>getAllBooking(){
        return  Dao.selectAll();
    }
    //已預約狀態查詢
    @Override
    public List<BookingVo> selectone(Integer state) {
        if(state == 1){
            return  Dao.selectById(1);
        } else if (state == 0) {
            return  Dao.selectById(0);
        }else if (state == 2) {
            return Dao.selectAll();
        }
        return null;
    }
    //用預約狀態以及日期條件查詢
    @Override
    public List<BookingVo> selectdate(int state, Date startDate, Date endDate){
            beginTransaction();
            List<BookingVo> result = Dao.selectByDate(state, startDate, endDate);
            commit();
            return result;
    }
    @Override
    public BookingVo cancelBooking(Integer bookno, Integer newState){
        return Dao.cancel(bookno, newState);
    }


    @Override
    public boolean remove(Integer bookingno) {
        return Dao.deleteById(bookingno) > 0;
    }

    @Override
    public boolean save(BookingVo booking) {
        return Dao.update(booking) > 0;
    }
}
