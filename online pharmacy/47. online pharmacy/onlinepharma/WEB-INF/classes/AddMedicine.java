package com;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class AddMedicine extends HttpServlet {
public void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	String mname=request.getParameter("t1").trim();
	String quantity=request.getParameter("t2").trim();
	String expiry=request.getParameter("t3").trim();
	String price = request.getParameter("t4").trim();
	String manufacturer = request.getParameter("t5").trim();
	String supplier = request.getParameter("t6").trim();
	try{
		java.util.Date dd = new java.util.Date(expiry);
		java.sql.Date dd1 = new java.sql.Date(dd.getTime());
		String msg = DBCon.addMedicine(mname,Integer.parseInt(quantity),dd1,price,manufacturer,supplier);
		if(msg.equals("success")){
			RequestDispatcher rd=request.getRequestDispatcher("AdminScreen.jsp?t1=Medicines details updated");
			rd.forward(request, response);
		}
		else{
			response.sendRedirect("AdminScreen.jsp?t1=Error in updating medicine details");
		}
	

	}catch(Exception e){
		e.printStackTrace();
	}
	}

}
