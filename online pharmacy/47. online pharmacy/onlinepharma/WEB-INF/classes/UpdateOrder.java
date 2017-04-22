package com;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
public class UpdateOrder extends HttpServlet {
public void doGet(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
	try{
	response.setContentType("text/html");
	HttpSession session=request.getSession();
	PrintWriter out = response.getWriter();
	String user = request.getParameter("t1").trim();
	String date = request.getParameter("t2").trim();
	String msg = DBCon.updateOrder(user,date);
	if(msg.equals("success")){
		RequestDispatcher rd=request.getRequestDispatcher("ViewOrder.jsp");
		rd.forward(request, response);
	}else{
		RequestDispatcher rd=request.getRequestDispatcher("ViewOrder.jsp");
		rd.forward(request, response);
	}
	}catch(Exception e){
		e.printStackTrace();
	}
}

}
