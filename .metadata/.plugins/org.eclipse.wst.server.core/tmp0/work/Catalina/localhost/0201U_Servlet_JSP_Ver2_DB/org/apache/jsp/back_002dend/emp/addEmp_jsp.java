/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.65
 * Generated at: 2023-08-21 14:30:07 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.back_002dend.emp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class addEmp_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("/WEB-INF/lib/standard.jar", Long.valueOf(1649830021382L));
    _jspx_dependants.put("jar:file:/C:/CHA102_WebApp/eclipse_WTP_workspace4B_To-SpringBootMVC_1-5-8U/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/0201U_Servlet_JSP_Ver2_DB/WEB-INF/lib/standard.jar!/META-INF/c.tld", Long.valueOf(1064305020000L));
    _jspx_dependants.put("/back-end/emp/included-fragment.file", Long.valueOf(1651025550912L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<meta name=\"viewport\"\r\n");
      out.write("	content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\r\n");
      out.write("<title>員工資料新增 - addEmp.jsp</title>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath());
      out.write("/resources/webjars/bootstrap/4.2.1/css/bootstrap.min.css\"/>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath());
      out.write("/resources/css/index.css\"/>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath());
      out.write("/resources/css/error.css\"/>");
      out.write("\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("button {\r\n");
      out.write("	padding: 5px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("form {\r\n");
      out.write("	display: table;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("form div {\r\n");
      out.write("	display: table-row;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("label, input, span, select {\r\n");
      out.write("	display: table-cell;\r\n");
      out.write("	margin: 5px;\r\n");
      out.write("	text-align: left;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("input[type=text], input[type=password], select, textarea {\r\n");
      out.write("	width: 200px;\r\n");
      out.write("	margin: 5px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("form div div {\r\n");
      out.write("	display: table-cell;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".center {\r\n");
      out.write("	margin-left: auto;\r\n");
      out.write("	margin-right: auto;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("	<nav\r\n");
      out.write("		class=\"navbar navbar-expand-md navbar-dark bg-success fixed-top justify-content-center\">\r\n");
      out.write("		<div align=\"center\">\r\n");
      out.write("			<h2>員工資料新增 - addEmp.jsp</h2>\r\n");
      out.write("			<h3>\r\n");
      out.write("				<a class=\"navbar-brand\"\r\n");
      out.write("					href=\"");
      out.print(request.getContextPath());
      out.write("/back-end/emp/select_page.jsp\"><img\r\n");
      out.write("					src=\"");
      out.print(request.getContextPath());
      out.write("/resources/images/back1.gif\">回查詢頁</a>\r\n");
      out.write("			</h3>\r\n");
      out.write("		</div>\r\n");
      out.write("	</nav>\r\n");
      out.write("\r\n");
      out.write("	<div align=\"center\">\r\n");
      out.write("		<h3>\r\n");
      out.write("			<b>所有欄位皆為必填欄位</b>\r\n");
      out.write("		</h3>\r\n");
      out.write("		<form action=\"");
      out.print(request.getContextPath());
      out.write("/emp/emp.do\" method=\"post\"\r\n");
      out.write("			enctype=\"multipart/form-data\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("			<div>\r\n");
      out.write("				<label for=\"ename\">員工姓名:</label>\r\n");
      out.write("				 <input id=\"ename\" name=\"ename\"type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.ename}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" />\r\n");
      out.write("				<span id=\"ename.errors\"class=\"error\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${errorMsgs.ename}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("<br /></span>\r\n");
      out.write("			</div>\r\n");
      out.write("\r\n");
      out.write("			<div>\r\n");
      out.write("				<label for=\"job\">職位:</label> <input id=\"job\" name=\"job\" type=\"text\"\r\n");
      out.write("					value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.job}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" onclick=\"hideContent('job.errors');\" /> <span\r\n");
      out.write("					id=\"job.errors\" class=\"error\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${errorMsgs.job}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</span>\r\n");
      out.write("			</div>\r\n");
      out.write("\r\n");
      out.write("			<div>\r\n");
      out.write("				<label for=\"hiredate\">雇用日期:</label> <input id=\"hiredate\"\r\n");
      out.write("					name=\"hiredate\" type=\"date\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.hiredate}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\"\r\n");
      out.write("					onclick=\"hideContent('hiredate.errors');\" /> <span\r\n");
      out.write("					id=\"hiredate.errors\" class=\"error\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${errorMsgs.hiredate}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</span>\r\n");
      out.write("			</div>\r\n");
      out.write("\r\n");
      out.write("			<div>\r\n");
      out.write("				<label for=\"sal\">薪水:</label> <input id=\"sal\" name=\"sal\" type=\"text\"\r\n");
      out.write("					value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.sal}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" onclick=\"hideContent('sal.errors');\" /> <span\r\n");
      out.write("					id=\"sal.errors\" class=\"error\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${errorMsgs.sal}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</span>\r\n");
      out.write("			</div>\r\n");
      out.write("\r\n");
      out.write("			<div>\r\n");
      out.write("				<label for=\"comm\">獎金:</label> <input id=\"comm\" name=\"comm\"\r\n");
      out.write("					type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.comm}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\"\r\n");
      out.write("					onclick=\"hideContent('comm.errors');\" /> <span id=\"comm.errors\"\r\n");
      out.write("					class=\"error\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${errorMsgs.comm}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</span>\r\n");
      out.write("			</div>\r\n");
      out.write("\r\n");
      out.write("			");
      com.dept.model.DeptService deptSvc = null;
      deptSvc = (com.dept.model.DeptService) _jspx_page_context.getAttribute("deptSvc", javax.servlet.jsp.PageContext.PAGE_SCOPE);
      if (deptSvc == null){
        deptSvc = new com.dept.model.DeptService();
        _jspx_page_context.setAttribute("deptSvc", deptSvc, javax.servlet.jsp.PageContext.PAGE_SCOPE);
      }
      out.write("\r\n");
      out.write("			<div>\r\n");
      out.write("				<label for=\"deptno\">部門:</label> <select id=\"deptno\" name=\"deptno\">\r\n");
      out.write("					");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("				</select>\r\n");
      out.write("			</div>\r\n");
      out.write("\r\n");
      out.write("			<div>\r\n");
      out.write("				<label for=\"upFiles\">照片:</label> <input id=\"upFiles\" name=\"upFiles\"\r\n");
      out.write("					type=\"file\" onclick=\"previewImage()\" multiple=\"multiple\"\r\n");
      out.write("					onchange=\"hideContent('upFiles.errors');\" /> <span\r\n");
      out.write("					id=\"upFiles.errors\" class=\"error\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${errorMsgs.upFiles}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</span>\r\n");
      out.write("				<div id=\"blob_holder\"></div>\r\n");
      out.write("			</div>\r\n");
      out.write("\r\n");
      out.write("			<div>\r\n");
      out.write("				<div></div>\r\n");
      out.write("				<input type=\"hidden\" name=\"action\" value=\"insert\">\r\n");
      out.write("				<button type=\"submit\" id=\"submit\">送出新增</button>\r\n");
      out.write("				<div></div>\r\n");
      out.write("			</div>\r\n");
      out.write("		</form>\r\n");
      out.write("	</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("	<!-- JavaScript part -->\r\n");
      out.write("	<script type=\"text/javascript\">\r\n");
      out.write("		//清除提示信息\r\n");
      out.write("		function hideContent(d) {\r\n");
      out.write("			document.getElementById(d).style.display = \"none\";\r\n");
      out.write("		}\r\n");
      out.write("\r\n");
      out.write("		//照片上傳-預覽用\r\n");
      out.write("		var filereader_support = typeof FileReader != 'undefined';\r\n");
      out.write("		if (!filereader_support) {\r\n");
      out.write("			alert(\"No FileReader support\");\r\n");
      out.write("		}\r\n");
      out.write("		acceptedTypes = {\r\n");
      out.write("			'image/png' : true,\r\n");
      out.write("			'image/jpeg' : true,\r\n");
      out.write("			'image/gif' : true\r\n");
      out.write("		};\r\n");
      out.write("		function previewImage() {\r\n");
      out.write("			var upfile1 = document.getElementById(\"upFiles\");\r\n");
      out.write("			upfile1.addEventListener(\"change\", function(event) {\r\n");
      out.write("				var files = event.target.files || event.dataTransfer.files;\r\n");
      out.write("				for (var i = 0; i < files.length; i++) {\r\n");
      out.write("					previewfile(files[i])\r\n");
      out.write("				}\r\n");
      out.write("			}, false);\r\n");
      out.write("		}\r\n");
      out.write("		function previewfile(file) {\r\n");
      out.write("			if (filereader_support === true\r\n");
      out.write("					&& acceptedTypes[file.type] === true) {\r\n");
      out.write("				var reader = new FileReader();\r\n");
      out.write("				reader.onload = function(event) {\r\n");
      out.write("					var image = new Image();\r\n");
      out.write("					image.src = event.target.result;\r\n");
      out.write("					image.width = 100;\r\n");
      out.write("					image.height = 75;\r\n");
      out.write("					image.border = 2;\r\n");
      out.write("					if (blob_holder.hasChildNodes()) {\r\n");
      out.write("						blob_holder.removeChild(blob_holder.childNodes[0]);\r\n");
      out.write("					}\r\n");
      out.write("					blob_holder.appendChild(image);\r\n");
      out.write("				};\r\n");
      out.write("				reader.readAsDataURL(file);\r\n");
      out.write("				document.getElementById('submit').disabled = false;\r\n");
      out.write("			} else {\r\n");
      out.write("				blob_holder.innerHTML = \"<div  style='text-align: left;'>\"\r\n");
      out.write("						+ \"● filename: \"\r\n");
      out.write("						+ file.name\r\n");
      out.write("						+ \"<br>\"\r\n");
      out.write("						+ \"● ContentTyp: \"\r\n");
      out.write("						+ file.type\r\n");
      out.write("						+ \"<br>\"\r\n");
      out.write("						+ \"● size: \"\r\n");
      out.write("						+ file.size\r\n");
      out.write("						+ \"bytes\"\r\n");
      out.write("						+ \"<br>\"\r\n");
      out.write("						+ \"● 上傳ContentType限制: <b> <font color=red>image/png、image/jpeg、image/gif </font></b></div>\";\r\n");
      out.write("				document.getElementById('submit').disabled = true;\r\n");
      out.write("			}\r\n");
      out.write("		}\r\n");
      out.write("	</script>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    boolean _jspx_th_c_005fforEach_005f0_reused = false;
    try {
      _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fforEach_005f0.setParent(null);
      // /back-end/emp/addEmp.jsp(114,5) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setVar("deptVO");
      // /back-end/emp/addEmp.jsp(114,5) name = items type = java.lang.Object reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${deptSvc.all}", java.lang.Object.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
      try {
        int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
        if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\r\n");
            out.write("						<option value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${deptVO.deptno}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("\"\r\n");
            out.write("							");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${(param.deptno==deptVO.deptno)? 'selected':'' }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write('>');
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${deptVO.dname}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("\r\n");
            out.write("					");
            int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return true;
        }
      } catch (java.lang.Throwable _jspx_exception) {
        while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
      } finally {
        _jspx_th_c_005fforEach_005f0.doFinally();
      }
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
      _jspx_th_c_005fforEach_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fforEach_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fforEach_005f0_reused);
    }
    return false;
  }
}
