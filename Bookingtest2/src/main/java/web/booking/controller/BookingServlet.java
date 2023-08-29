package web.booking.controller;

import web.booking.service.BookingService;
import web.booking.service.BookingServiceImpl;
import web.booking.util.*;
import web.booking.vo.BookingVo;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.awt.print.Book;
import java.util.List;

import static core.util.CommonUtil.voToJson;
import static core.util.Constants.JSON_MIME_TYPE;
import static web.booking.util.BookConstants.SERVICE;


@WebServlet("/booking/test")
public class BookingServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

        response.setContentType(JSON_MIME_TYPE);

        //查全部
        List<BookingVo> booking = SERVICE.getAllBooking();
        voToJson(response, booking);



    }
}