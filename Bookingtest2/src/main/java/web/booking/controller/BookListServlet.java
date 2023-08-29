package web.booking.controller;

import web.booking.vo.BookingListVo;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static core.util.CommonUtil.voToJson;
import static web.booking.util.BookListContstants.SERVICE;

import java.util.List;

import static core.util.Constants.JSON_MIME_TYPE;

@WebServlet("/booking/list")
public class BookListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response){
        response.setContentType(JSON_MIME_TYPE);
        List<BookingListVo> booklist = SERVICE.getAllBookingList();
        voToJson(response,booklist);
    }
}
