package web.booking.controller;

import core.util.CommonUtil;
import web.booking.service.BookListService;
import web.booking.service.BookListServiceImpl;
import web.booking.vo.BookingListVo;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;

import static core.util.CommonUtil.jsonToVo;
import static core.util.CommonUtil.voToJson;
import static core.util.Constants.JSON_MIME_TYPE;

@WebServlet("/booking/insert")
public class BookingInsertServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private BookListService service = new BookListServiceImpl();
    CommonUtil commonUtil = new CommonUtil();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response){
        response.setContentType(JSON_MIME_TYPE);
        BookingListVo bookingListVo = jsonToVo(request, BookingListVo.class);
        System.out.println(request.getRequestURI());
        System.out.println(bookingListVo);
        if(bookingListVo == null){
            bookingListVo = new BookingListVo();
            bookingListVo.setMessage("wrong");
            bookingListVo.setSuccessful(false);
            return;
        }
        //insert
        commonUtil.voToJson(response, service.insert(bookingListVo));

    }
}
