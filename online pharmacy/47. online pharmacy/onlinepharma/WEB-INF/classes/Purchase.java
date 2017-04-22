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
public class Purchase extends HttpServlet {
public void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
	response.setContentType("text/html");
	HttpSession session=request.getSession();
	PrintWriter out = response.getWriter();
	String uname=session.getAttribute("user").toString().trim();
	String mname=request.getParameter("t2").trim();
	String quantity=request.getParameter("t3").trim();
	double qty = Double.parseDouble(quantity);
	try{
	double price = DBCon.getPrice(mname,quantity);
	if(session.getAttribute("carts") == null){
		ArrayList<String> list = new ArrayList<String>();
		list.add(mname+"#"+quantity+"#"+price+"#"+(price*qty));
		session.setAttribute("carts",list);
	}else{
		ArrayList<String> list = (ArrayList<String>)session.getAttribute("carts");
		list.add(mname+"#"+quantity+"#"+price+"#"+(price*qty));
	}
	RequestDispatcher rd=request.getRequestDispatcher("PurchaseMedicine.jsp?t1="+mname+" Medicine Added");
	rd.forward(request, response);
	}catch(Exception e){
		e.printStackTrace();
	}
}

}
