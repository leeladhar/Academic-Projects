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
public class Finish extends HttpServlet {
public void doGet(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
	try{
	response.setContentType("text/html");
	HttpSession session=request.getSession();
	PrintWriter out = response.getWriter();
	String uname=session.getAttribute("user").toString().trim();
	ArrayList<String> list = (ArrayList<String>)session.getAttribute("carts");
	StringBuilder sb = new StringBuilder();
	double total = 0;
	for(String str : list){
		String arr[] = str.split("#");
		total = total + Double.parseDouble(arr[3]);
		sb.append(arr[0]+"#"+arr[1]+"#"+arr[2]+"#"+arr[3]+"\n");
	}
	list.clear();
	String msg = DBCon.addPurchase(uname,sb.toString(),total);
	if(msg.equals("success")){
		RequestDispatcher rd=request.getRequestDispatcher("UserScreen.jsp?t1=Order completed");
		rd.forward(request, response);
	}else{
		RequestDispatcher rd=request.getRequestDispatcher("UserScreen.jsp?t1=Error in completing Order");
		rd.forward(request, response);
	}
	}catch(Exception e){
		e.printStackTrace();
	}
}

}
