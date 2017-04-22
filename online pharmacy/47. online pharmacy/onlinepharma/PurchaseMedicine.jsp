<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="com.DBCon"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="free design template, CSS template, HTML website" />
<meta name="description" content="Free Design Template, Free CSS Website, XHTML CSS layout" />
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
<script language="javascript">
	function validate(formObj)
	{
	if(formObj.t1.value.length==0)
	{
	alert("Please Enter User ID");
	formObj.t1.focus();
	return false;
	}
	if(formObj.t3.value.length==0)
	{
	alert("Please Enter quantity");
	formObj.t3.focus();
	return false;
	}
	formObj.actionUpdateData.value="update";
	return true;
	}
	</script>
</head>
<body>
<!--  Download Free CSS Templates from www.templatemo.com  -->	
<div id="templatemo_header_panel">
	<div id="templatemo_header_section">
    	<div id="templatemo_title_section"><center>Online Pharmacy</center></div>
        <div id="tagline"></div>
    </div>
</div> <!-- end of haeder -->

<div id="templatemo_menu_panel">
    <div id="templatemo_menu_section">
       <ul>
            <li><a href="SearchMedicine.jsp"  class="current">Search&nbsp;Medicine</a></li>
			<li><a href="PurchaseMedicine.jsp">Purchase&nbsp;Medicine</a></li>
			<li><a href="TrackOrder.jsp">Track&nbsp;Order</a></li>
			<li><a href="Logout.jsp">Logout</a></li>
                             
        </ul> 
</div> <!-- end of menu -->
<br/>
	<center>
<form name="f1" method="post" action="Purchase" onsubmit="return validate(this);"><br/>
   <h2><b>Online Medicines Purchase Screen</b></h2>
   <br/>
	<%
	String user = (String)session.getAttribute("user");
	String res = request.getParameter("t1");
	if(res != null){
		out.println("<center><font face=verdana color=red>"+res+"</center></font>");
	}%>
						
						<table align="center" width="40" >
			 <tr><td><b>Username</b></td><td><input type="text" name="t1" style="font-family: Comic Sans MS" size="30" value="<%=user%>"/></td></tr>

			 <tr><td><b>Medicine&nbsp;Name</b></td><td><select name="t2">
			 <%try{
				 Connection con = DBCon.getCon();
				 Statement stmt = con.createStatement();
				 ResultSet rs = stmt.executeQuery("select medicine_name from addmedicine where expiry_status='not expired'");
				 while(rs.next()){
					 String s1 =rs.getString(1);%>
					 <option value="<%=s1%>"><%=s1%></option>
					 <%}
				 }catch(Exception e){
					 e.printStackTrace();
				 }%>
				 </select>
			 </td></tr>
         <tr><td><b>Quantity</b></td><td><input type="text" name="t3" style="font-family: Comic Sans MS" size="10" /></td></tr>
		         
			<tr><td></td><td><input type="submit" value="Add To Cart"></td></tr>
			</table>
			<br/>
			<a href="Finish">Click here to Checkout</a>
				</div>	
					
				</div>
				
</body>
</html>