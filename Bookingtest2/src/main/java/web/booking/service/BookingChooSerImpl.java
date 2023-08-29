package web.booking.service;

import org.hibernate.SessionFactory;
import web.booking.dao.TableBookingDao;
import web.booking.dao.TableBookingImpl;
import web.booking.vo.TableBookingVo;

import java.sql.Date;
import java.util.List;

public class BookingChooSerImpl implements BookingChooseService{
    private SessionFactory sessionFactory;
    private TableBookingDao Dao;
    public BookingChooSerImpl(){
        Dao = new TableBookingImpl();
    }
    @Override
    public List<TableBookingVo> selectByDate(Date date, int tableno){
        beginTransaction();
        List<TableBookingVo> result = Dao.SelectByChoose(date, tableno);
        commit();
        return result;
    }
    //改變狀態
    public TableBookingVo selectByState(Integer stateNo,Date bookDate,Integer tableNo){
        return Dao.updateByState(stateNo, bookDate, tableNo);
    }

}
