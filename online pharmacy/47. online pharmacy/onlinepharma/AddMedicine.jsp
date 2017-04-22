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
	alert("Please Enter Medicine Name");
	formObj.t1.focus();
	return false;
	}
	if(formObj.t2.value.length==0)
	{
	alert("Please Enter Quantity");
	formObj.t2.focus();
	return false;
	}
	if(formObj.t3.value.length==0)
	{
	alert("Please Enter Expiry date");
	formObj.t3.focus();
	return false;
	}
	if(formObj.t4.value.length==0)
	{
	alert("Please Enter price");
	formObj.t4.focus();
	return false;
	}
	if(formObj.t5.value.length==0)
	{
	alert("Please Enter manufacturer");
	formObj.t5.focus();
	return false;
	}
	if(formObj.t6.value.length==0)
	{
	alert("Please enter supplier);
	formObj.t6.focus();
	return false;
	}
	formObj.actionUpdateData.value="update";
	return true;
	}
	</script>
	 <script language="javascript" type="text/javascript" src="datetimepicker.js">
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
            <li><a href="AddMedicine.jsp"  class="current">Add Medicines</a></li>
			<li><a href="ExpiredMedicine.jsp">Expired Medicines</a></li>
			<li><a href="ViewOrder.jsp">View Order</a></li>
			<li><a href="Logout.jsp" class="last">Logout</a></li>                
        </ul> 
</div> <!-- end of menu -->
<br/>
	<center>
<form name="f1" method="post" action="AddMedicine" onsubmit="return validate(this);"><br/>
   <h2><b>Add Medicine Screen</b></h2>
   <br/>
	<%
	String res = request.getParameter("t1");
	if(res != null){
		out.println("<center><font face=verdana color=red>"+res+"</center></font>");
	}%>
						
						<table align="center" width="40" >
			 <tr><td><b>Medicine&nbsp;Name</b></td><td><input type="text" name="t1" style="font-family: Comic Sans MS" size=30/></td></tr>
         
		  <tr><td><b>Quantity</b></td><td><input type="text" name="t2" style="font-family: Comic Sans MS" size=30/></td></tr>

		  <tr><td><b>Expired&nbsp;Date</b></td><td><input type="text" name="t3" style="font-family: Comic Sans MS" size="20" id="demo1"/>
		  <a href="javascript:NewCal('demo1','ddmmmyyyy',true,24)"><img src="cal.gif" width="16" height="16" border="0" alt="Pick a date"></a>
	  		<span class="descriptions"></span>
		  </td></tr>

		  <tr><td><b>Price</b></td><td><input type="text" name="t4" style="font-family: Comic Sans MS" size=30/></td></tr>

		  <tr><td><b>Manufacturer</b></td><td><input type="text" name="t5" style="font-family: Comic Sans MS" size=30/></td></tr>

		  <tr><td><b>Supplier</b></td><td><input type="text" name="t6" style="font-family: Comic Sans MS" size=30/></td></tr>
         
			<tr><td></td><td><input type="submit" value="Add Medicine"></td>
			</table>
				</div>	
					
				</div>
				
</body>
</html>