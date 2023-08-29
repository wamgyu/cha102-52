package web.booking.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jetbrains.annotations.NotNull;
import web.booking.vo.BookingListVo;

import java.util.List;

public class BookingListDaoImpl implements BookingListDao{
    @Override
    public Integer insert(BookingListVo bookinglistvo){
        Session session = getSession();
        //Transaction transaction = session.beginTransaction();
        try{
            //保留
            session.merge(bookinglistvo);
            //transaction.commit();
            //
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(bookinglistvo);
            //transaction.rollback();
            return -1;
        }

    }

    @Override
    public Integer deleteById(Integer id) {
        return null;
    }
    //沒有delete 是跟著booking走

    @Override
    public Integer update(BookingListVo bookingListVo) {
        return null;
    }

    @Override
    public Integer updateById(@NotNull BookingListVo newlist){
        Session session = getSession();
        BookingListVo oldlist = session.get(BookingListVo.class, newlist.getBookingno());
        try{
            final Integer checkst = newlist.getBookingcheckstate();
            if(checkst != null) {
                oldlist.setBookingcheckstate(checkst);
            }
            return 1;
            }catch(Exception e){
            e.printStackTrace();
            return -1;
        }

        }
    @Override
    public List<BookingListVo> selectAll(){
        final String hql = "FROM BookingListVo ORDER BY bookingno";
        return getSession().createQuery(hql, BookingListVo.class).getResultList();
    }
    @Override
    public BookingListVo selectById(Integer bookingno){
        return getSession().get(BookingListVo.class, bookingno);
    }


}
