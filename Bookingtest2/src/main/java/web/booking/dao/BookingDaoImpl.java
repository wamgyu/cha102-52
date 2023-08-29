package web.booking.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jetbrains.annotations.NotNull;
import web.booking.vo.BookingVo;

import javax.persistence.Query;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class BookingDaoImpl implements BookingDao{
    @Override
    public Integer insert(BookingVo bookingvo) {
        getSession().persist(bookingvo);
        return (Integer) 1;
    }

    @Override
    public Integer deleteById(Integer id) {
        return -1;
    }

    @Override
    public Integer update(BookingVo bookingVo) {
        return null;
    }

    @Override
    public Integer deletbyId(Integer bookingno) {
        BookingVo bookvo = getSession().get(BookingVo.class, bookingno);
        getSession().remove(bookvo);
        return null;
    }


    @Override

    public Integer updateById(@NotNull BookingVo newbook) {
        Session session = getSession();
        BookingVo oldbook = session.get(BookingVo.class, newbook.getBookingno());
        try {
            final Integer state = newbook.getBookingstate();
            if(state != null){
                oldbook.setBookingstate(state);
            }
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public List<BookingVo> selectAll(){
        final  String hql = "FROM BookingVo ORDER BY bookingno";
        return getSession().createQuery(hql, BookingVo.class).getResultList();
    }
    @Override
    //查一個

    public List<BookingVo> selectById(Integer state) {
        String hql = "FROM BookingVo b WHERE b.bookingstate = :state";

        return getSession().createQuery(hql, BookingVo.class)
                .setParameter("state", state)
                .getResultList();
    }
    @Override
    public List<BookingVo> selectByDate(int state, Date startDate, Date endDate){
        List<Integer> statesToQuery = new ArrayList<>();

        // 如果状态是2，将其转换为状态1和状态0
        if (state == 2) {
            statesToQuery.add(1);
            statesToQuery.add(0);
        } else {
            statesToQuery.add(state);
        }
        String hql = "FROM BookingVo WHERE 1 = 1";
        if(!statesToQuery.isEmpty()) {
            hql += " AND bookingstate IN :state";
        }
        if (startDate != null && endDate != null) {
            hql += " AND bookingdate BETWEEN :startDate AND :endDate";
        }
        Session session = getSession();
        Query query = session.createQuery(hql, BookingVo.class);
        if (!statesToQuery.isEmpty()){
            query.setParameter("state",statesToQuery);
        }
        if(state == 2){
            query.setParameter("state",1);
        }

        if (startDate != null && endDate != null){
            query.setParameter("startDate", startDate);
            query.setParameter("endDate", endDate);
        }
        List<BookingVo> bookings = query.getResultList();
        return bookings;
    }

    @Override
    public BookingVo cancel(Integer bookingNo, Integer newState){
       Session session = getSession();
       Transaction transaction = session.beginTransaction();
       try {
           String hql = "UPDATE BookingVo SET bookingstate = :newState WHERE bookingno = :bookingNo";
           Query query = session.createQuery(hql);
           query.setParameter("newState", newState);
           query.setParameter("bookingNo", bookingNo);
           int rowCount = query.executeUpdate();
           System.out.println(rowCount);
           transaction.commit();
       }catch (Exception e){
           e.printStackTrace();
           transaction.rollback();
        }

        return null;
    }


}
