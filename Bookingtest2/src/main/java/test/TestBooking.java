package test;
//
//import core.util.HibernateUtil;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import web.booking.vo.BookingVo;
//
//public class TestBooking {
//    public static void main(String[] args) {
//    TestBooking app = new TestBooking();
//    BookingVo booking = new BookingVo();
//
//    }
//        public Integer insert(BookingVo book) {
//            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//            Session session = sessionFactory.openSession();
//            try {
//                Transaction transaction = session.beginTransaction();
//                session.persist(book);
//                transaction.commit();
//                System.out.println("成功");
//                return book.getBookingno();
//
//            } catch (Exception e) {
//
//                e.printStackTrace();
//                session.getTransaction().rollback();
//                return null;
//            }
//        }
//
//
//}
//======================================
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import core.util.HibernateUtil;
//import web.booking.vo.BookingVo;
//
//import java.sql.Date;

//public class TestBooking {
//    public static void main(String[] args) {
//        // 初始化 HibernateUtil（确保配置正确）
//        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//        Session session = sessionFactory.openSession();
//        Transaction transaction = session.beginTransaction();

//        try {
//            // 获取数据库中的已存在的 BookingVo 对象
//            BookingVo booking = session.get(BookingVo.class, 1);
//
//            if (booking != null) {
//                // 修改属性
//                booking.setBookingno(1);
//                booking.setBookingstate(3);
//                booking.setBookingdate(Date.valueOf("2023-08-17"));
//
//                // 持久化更新后的 BookingVo 对象
//                session.update(booking);
//
//                transaction.commit();
//                System.out.println("成功");
//            } else {
//                System.out.println("未找到 BookingVo 对象");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            transaction.rollback();
//        } finally {
//            session.close();
//        }
//    }
//}
//================
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import core.util.HibernateUtil;
import web.booking.vo.BookingVo;

import java.sql.Date;

public class TestBooking {
    public static void main(String[] args) {
        TestBooking app = new TestBooking();

    }
}

