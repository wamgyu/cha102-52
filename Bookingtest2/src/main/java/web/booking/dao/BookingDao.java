package web.booking.dao;

import core.coreDAO.CoreDao;
import web.booking.vo.BookingVo;
import web.mem.vo.MemVo;

import java.sql.Date;
import java.util.List;

public interface BookingDao extends CoreDao<BookingVo, Integer> {

    Integer insert(BookingVo book);

    Integer deletbyId(Integer bookingno);

    //Table booking 只會有state狀態改變
    Integer updateById(BookingVo newbook);

//    List<BookingVo> selectById(Integer bookingno);

    //查一個
    List<BookingVo> selectById(Integer state);

    //查日期
    public List<BookingVo> selectByDate(int state, Date startDate, Date endDate);

    //取消
//    Integer cancel (Integer bookno);

    BookingVo cancel(Integer bookingNo, Integer newState);
}
