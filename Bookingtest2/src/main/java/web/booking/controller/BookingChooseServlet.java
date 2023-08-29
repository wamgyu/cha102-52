package web.booking.controller;

import web.booking.dao.TableBookingDao;
import web.booking.vo.TableBookingVo;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import static core.util.CommonUtil.voToJson;
import static core.util.Constants.JSON_MIME_TYPE;
import static web.booking.util.BookConstants.SERVICE;
import static web.booking.util.BookConstants.SERVICETable;

@WebServlet("/tablebooking")
public class BookingChooseServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response){
        response.setContentType(JSON_MIME_TYPE);
        Date DateChooseParam = null;
        String DateChoose = request.getParameter("chooseDate");
        System.out.println(DateChoose);


        String tableParam = request.getParameter("table");
        System.out.println(tableParam);
       Integer tableno = Integer.parseInt(tableParam );

        if (DateChoose != null && !DateChoose.isEmpty()) {
            DateChooseParam = Date.valueOf(DateChoose);
        }
        System.out.println("DateChooseParam: " + DateChooseParam);

        List<TableBookingVo> tablebook = SERVICETable.selectByDate(DateChooseParam, tableno);
        voToJson(response, tablebook);
    }
public BookingChooseServlet (){
        super();
}
}
