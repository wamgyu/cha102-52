package com.blob.reader;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import com.emp.model.*;

@WebServlet("/emp/DBGifReader")
public class DBGifReaderController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		res.setContentType("image/gif");
		ServletOutputStream out = res.getOutputStream();

		try {
			Integer empno = Integer.valueOf(req.getParameter("empno"));
			EmpService empSvc = new EmpService();
			out.write(empSvc.getOneEmp(empno).getUpFiles());
		} catch (Exception e) {
			InputStream in = getServletContext().getResourceAsStream("/resources/NoData/nopic.jpg");
			byte[] buf = new byte[in.available()];
			in.read(buf);
			out.write(buf);
			in.close();

		}
	}

}
