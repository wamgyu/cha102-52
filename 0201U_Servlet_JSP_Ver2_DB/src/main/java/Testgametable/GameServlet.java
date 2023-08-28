package Testgametable;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import Testtablebooking.TablebookingService;
import javax.servlet.annotation.MultipartConfig;

import Bookinglist.*;
import Testtablebooking.*;

public class GameServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");

		// action equals(==) insert的方法
		if ("insert".equals(action)) { // 來自addEmp.jsp的請求

			Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
			req.setAttribute("errorMsgs", errorMsgs);

			/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/

				java.sql.Date TABLE_DATE = null;
				try {
					TABLE_DATE = java.sql.Date.valueOf(req.getParameter("TABLE_DATE").trim());
				} catch (IllegalArgumentException e) {
					errorMsgs.put("TABLE_DATE", "預約日期: 請勿空白");
				}

				// 找出TABLE_NO的參數請求 沒有這段就沒有東西
				Integer TABLE_NO = null;
				try {
					TABLE_NO = Integer.valueOf(req.getParameter("TABLE_NO").trim());
					System.out.println(TABLE_NO);
				} catch (NumberFormatException e) {
					errorMsgs.put("TABLE_NO", "選一個就好");
				}

				Integer PERIOD_TIME = null;
				try {
					PERIOD_TIME = Integer.valueOf(req.getParameter("PERIOD_TIME").trim());
					System.out.println(PERIOD_TIME);
				} catch (NumberFormatException e) {
					errorMsgs.put("PERIOD_TIME", "不要亂按");
				}

				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/back-end/emp/membertest.jsp");
					failureView.forward(req, res);
					return;
				}
				// 前端的name名稱是發送請求的KEY有這個KEY才能打開servlet的大門去往後找
				String selectedDateValue = req.getParameter("selectedDate");

				/*************************** 2.開始新增資料 ***************************************/
				BookinglistService glistSvc = new BookinglistService();
				glistSvc.addBookinglist(TABLE_NO, TABLE_DATE, PERIOD_TIME);

				/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
				String url = "/back-end/emp/membertest.jsp"; // 新增成功跑到這個畫面
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉移到listAllEmp.jsp
				successView.forward(req, res);

				// ======================== 以下實現查詢出十天內的日期跟時段 ========================
		

	} else if("getTenDaysData".equals(action))

	{
		try {
			// 調用Service的方法
			TablebookingService tbService = new TablebookingService();
			List<TablebookingVO> list = tbService.getten();

			// 將數據存儲在request scope中
			req.setAttribute("tableBookingList", list);

			// 轉發到JSP頁面
			RequestDispatcher successView = req.getRequestDispatcher("/memTest1.jsp");
			successView.forward(req, res);

		} catch (Exception e) {
			e.printStackTrace();
		    req.setAttribute("errorMsgs", "數據操作出現問題，請稍後再試。");
		    RequestDispatcher failureView = req.getRequestDispatcher("/memTest1.jsp");
		    failureView.forward(req, res);
		}
	}

}

}
