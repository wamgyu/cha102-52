package web.booking.dao;

import core.coreDAO.CoreDao;
import web.booking.vo.BookingListVo;
import web.booking.vo.BookingVo;

public interface BookingListDao extends CoreDao<BookingListVo, Integer> {
    Integer updateById(BookingListVo newlist);

    BookingListVo selectById(Integer bookingno);
}
