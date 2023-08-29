package web.booking.service;

import core.coreService.CoreService;
import web.booking.vo.BookingListVo;

import java.sql.Date;
import java.util.List;

public interface BookListService extends CoreService {
    List<BookingListVo> getAllBookingList();

    BookingListVo insert(BookingListVo bookingListVo);
}
