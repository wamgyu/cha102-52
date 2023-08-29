package web.booking.util;

import web.booking.service.BookingChooSerImpl;
import web.booking.service.BookingChooseService;
import web.booking.service.BookingService;
import web.booking.service.BookingServiceImpl;


public class BookConstants {
	public static final BookingService SERVICE = new BookingServiceImpl();
	public static final BookingChooseService SERVICETable = new BookingChooSerImpl();
}
