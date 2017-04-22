package com;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.sql.Statement;
import java.util.ArrayList;
import java.io.FileWriter;
public class DBCon{
    private static Connection con;
	
public static Connection getCon()throws Exception {
   try{
		 Class.forName("com.mysql.jdbc.Driver");
		 con = DriverManager.getConnection("jdbc:mysql://localhost/onlinepharma","root","root");
     
	}catch(Exception e){
		e.printStackTrace();
	}
	return con;
}
public static String register(String[] input)throws Exception{
    String msg="no";
    boolean flag=false;
    boolean flag1=false;
    con = getCon();
	Statement stmt=con.createStatement();
    ResultSet rs=stmt.executeQuery("select username from newuser where username='"+input[0]+"'");
    if(rs.next()){
        flag=true;
        msg = "Username already exist";
    }
    stmt=con.createStatement();
    rs=stmt.executeQuery("select password from newuser where password='"+input[1]+"'");
    if(rs.next()){
        flag1=true;
        msg = "Password already exist";
    }
	if(!flag && !flag1){
		PreparedStatement stat=con.prepareStatement("insert into newuser values(?,?,?,?,?)");
		stat.setString(1,input[0]);
		stat.setString(2,input[1]);
		stat.setString(3,input[2]);
		stat.setString(4,input[3]);
		stat.setString(5,input[4]);
		int i=stat.executeUpdate();
		if(i > 0){
			msg = "success";
		}
    }
    return msg;
}
public static String addPurchase(String uname,String order,double total)throws Exception{
	String msg="no";
	String address = "";
	con = getCon();
	Statement stmt=con.createStatement();
    ResultSet rs=stmt.executeQuery("select address from newuser where username='"+uname+"'");
    if(rs.next()){
		address = rs.getString(1);
	}
	java.util.Date dd = new java.util.Date();
	java.sql.Date cd = new java.sql.Date(dd.getTime());
	PreparedStatement stat=con.prepareStatement("insert into purchase values(?,?,?,?,?,?)");
	stat.setString(1,uname);
	stat.setString(2,order);
	stat.setDouble(3,total);
	stat.setDate(4,cd);
	stat.setString(5,address);
	stat.setString(6,"pending");
	int i=stat.executeUpdate();
	if(i > 0){
		msg = "success";
	}
	return msg;
}
public static String addMedicine(String mname,int quantity,java.sql.Date dd1,String price,String manufacturer,String supplier)throws Exception{
    String msg="no";
	con = getCon();
	Statement stmt=con.createStatement();
    ResultSet rs=stmt.executeQuery("select quantity from addmedicine where medicine_name='"+mname+"'");
    if(rs.next()){
        int qty = rs.getInt(1);
		quantity = quantity + qty;
		PreparedStatement stat=con.prepareStatement("update addmedicine set quantity=?,expiry_date=?,price=?,manufacturer=?,supplier=? where medicine_name=?");
		stat.setInt(1,quantity);
		stat.setDate(2,dd1);
		stat.setDouble(3,Double.parseDouble(price));
		stat.setString(4,manufacturer);
		stat.setString(5,supplier);
		stat.setString(6,mname);
		int i=stat.executeUpdate();
		stat.close();
		if(i > 0){
			msg = "success";
		}
    }else{
		PreparedStatement stat=con.prepareStatement("insert into addmedicine values(?,?,?,?,?,?,?)");
		stat.setString(1,mname);
		stat.setInt(2,quantity);
		stat.setDate(3,dd1);
		stat.setDouble(4,Double.parseDouble(price));
		stat.setString(5,manufacturer);
		stat.setString(6,supplier);
		stat.setString(7,"not expired");
		int i=stat.executeUpdate();
		if(i > 0){
			msg = "success";
		}
    }
    return msg;
}

public static String login(String input[])throws Exception{
    String msg="invalid login";
	con = getCon();
    Statement stmt=con.createStatement();
    ResultSet rs=stmt.executeQuery("select username from newuser where username='"+input[0]+"' and password='"+input[1]+"'");
    if(rs.next()){
	    msg = "valid";
    }
    return msg;
}
public static double getPrice(String mname,String qty)throws Exception{
    double price = 0.0;
	con = getCon();
    Statement stmt=con.createStatement();
    ResultSet rs=stmt.executeQuery("select price from addmedicine where medicine_name='"+mname+"'");
    if(rs.next()){
	    price = rs.getDouble(1);
		PreparedStatement stat=con.prepareStatement("update addmedicine set quantity=quantity-"+Integer.parseInt(qty)+" where medicine_name=?");
		stat.setString(1,mname);
		stat.executeUpdate();
		stat.close();
    }
    return price;
}
public static String updateOrder(String user,String date)throws Exception{
    String msg = "no";
	con = getCon();
    PreparedStatement stat=con.prepareStatement("update purchase set status=? where username=? and order_date=?");
	stat.setString(1,"Dispatched");
	stat.setString(2,user);
	stat.setDate(3,java.sql.Date.valueOf(date));
	int i = stat.executeUpdate();
	stat.close();
    if(i > 0)
		msg = "success";
    return msg;
}
}
