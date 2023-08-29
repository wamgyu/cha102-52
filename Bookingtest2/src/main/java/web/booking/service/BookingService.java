package web.booking.service;

import core.coreService.CoreService;
import web.booking.vo.BookingVo;
import web.booking.vo.TableBookingVo;

import java.sql.Date;
import java.util.List;

public interface BookingService extends CoreService {
    //查全部
    List<BookingVo> getAllBooking();

    List<BookingVo> selectone(Integer bookingState);
    List<BookingVo> selectdate(int state, Date startDate, Date endDate);

    BookingVo cancelBooking(Integer bookno, Integer newState);

    boolean remove(Integer bookingno);

    boolean save(BookingVo booking);


}
