package web.booking.controller;

import com.google.gson.Gson;
import org.springframework.aop.scope.ScopedProxyUtils;
import web.booking.dao.BookingDao;
import web.booking.dao.BookingDaoImpl;
import web.booking.vo.BookingVo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.nimbus.State;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Collections;
import java.util.List;

import static core.util.CommonUtil.voToJson;
import static core.util.Constants.JSON_MIME_TYPE;
import static web.booking.util.BookConstants.SERVICE;

@WebServlet("/booking/one")
public class BookingoneServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType(JSON_MIME_TYPE);

       //獲取日期參數
        String stateParam = request.getParameter("state");
        int state = Integer.parseInt(stateParam);
        System.out.println(state);

        Date startDateParam = null;
        Date endDateParam = null;

        String startDateStr = request.getParameter("startDate");
        String endDateStr =  request.getParameter("endDate");

        if (startDateStr != null && !startDateStr.isEmpty()) {
            startDateParam = Date.valueOf(startDateStr);
        }

        if (endDateStr != null && !endDateStr.isEmpty()) {
            endDateParam = Date.valueOf(endDateStr);
        }
        List<BookingVo> bookings = SERVICE.selectdate(state, startDateParam, endDateParam);
        voToJson(response, bookings);

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    public BookingoneServlet() {
        super();

    }
}





