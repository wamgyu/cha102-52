package web.booking.service;

import org.hibernate.SessionFactory;
import web.booking.dao.BookingListDao;
import web.booking.dao.BookingListDaoImpl;
import web.booking.vo.BookingListVo;

import java.sql.Date;
import java.util.List;

public class BookListServiceImpl implements BookListService{
    private SessionFactory sessionFactory;
    private BookingListDao listDao;

    public BookListServiceImpl(){
        listDao = new BookingListDaoImpl();
    }
    @Override
    public List<BookingListVo>getAllBookingList(){
        beginTransaction();
        List<BookingListVo> result = listDao.selectAll();
        commit();
        return result;
    }

    @Override
    public BookingListVo insert (BookingListVo bookingListVo){
        beginTransaction();
        if (bookingListVo.getTableno() == null){
            bookingListVo.setMessage("tableno can't be empty");
            bookingListVo.setSuccessful(false);
            rollback();
            return bookingListVo;
        }
        if (bookingListVo.getPeriodtime() == null){
            bookingListVo.setMessage("period can't be empty");
            bookingListVo.setSuccessful(false);
            rollback();
            return bookingListVo;
        }

        final int result = listDao.insert(bookingListVo);
        if (result < 1) {
            bookingListVo.setMessage("fail");
            bookingListVo.setSuccessful(false);
            rollback();
        }
        bookingListVo.setMessage("ok");
        bookingListVo.setSuccessful(true);

        System.out.println(bookingListVo);
        System.out.println(result);
        commit();
        return bookingListVo;
    }
}
