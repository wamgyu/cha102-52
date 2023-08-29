package web.booking.controller;

import org.jetbrains.annotations.NotNull;
import web.booking.service.BookingService;
import web.booking.service.BookingServiceImpl;
import web.booking.vo.BookingVo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
@WebServlet("/booking/BookingServlet")
public class BookingServletEE extends HttpServlet {

    //接發請求
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        doPost(req,res);
    }
    @Override
    protected void doPost (@NotNull HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        res.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        //將錯誤儲存在Map裡
        if ("getOne".equals(action)) {
            Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
            req.setAttribute("errorMsgs", errorMsgs);
            String str = req.getParameter("bookingno");
            Integer bookingno = Integer.valueOf(str);

            BookingService bookSvc = new BookingServiceImpl();
            BookingVo bookingVo = bookSvc.getAllBooking().get(bookingno);
            String url = "/WEB-INF/booking.jsp";
            RequestDispatcher successView = req.getRequestDispatcher(url);
            successView.forward(req, res);

        }
    }
}