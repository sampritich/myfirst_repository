<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page import="com.airline.model.*"%>
	<%@ page import="java.util.*" %>
	<%@ page import="java.text.SimpleDateFormat" %>

<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

	<title>Booking Form HTML Template</title>

	<!-- Google font -->
	<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet">

	<!-- Bootstrap -->
	<link type="text/css" rel="stylesheet" href="css2/bootstrap.min.css" />

	<!-- Custom stlylesheet -->
	<link type="text/css" rel="stylesheet" href="css2/style.css" />

	<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
	<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	<!--[if lt IE 9]>
		  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
		  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
		<![endif]-->

</head>

<body>
    <form action="FlightController" method="post">
  <%
User user=new User();


user=(User)session.getAttribute("loginuser");


String name=user.getEmailId();
System.out.println(user.getEmailId()+"profile");

%>
  <%
                        Date date=new Date();
                        System.out.println(date);
                        SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
                        String d=sdf.format(date);
                        System.out.println(d);
					%>
      
     

	<div id="booking" class="section">
		<div class="section-center">
			<div class="container">
				<div class="row">
					<div class="col-md-7 col-md-push-5">
						<div class="booking-cta">
                            <div class="form-header">
                            <h1 style="color: red; padding: 15px 50px 5px 50px; float: right; font-size: 16px;">
                    Welcome  <%=name %>  </h1>
                            <br>
                           
                            <br>
							<h1>Book your flight</h1>
						</div>
							
						</div>
					</div>
					<div class="col-md-4 col-md-pull-7">
						<div class="booking-form">
							<form>
                                
								<div class="form-group">
									<span class="form-label">Departure</span>
									 <div class="form-group"> 
                              <label style="color:white" >Source</label>
								<select class="form-control" id="source" name="source">
									<option value="KOLKATA">Kolkata(CCU)</option>
									<option value="JAIPUR">Jaipur(JAI)</option>
									<option value="MUMBAI">Mumbai(BOM)</option>
								</select>
							</div>
								</div>
                                
                                <div class="form-group">
									<span class="form-label">Arrival</span>
									 <div class="form-group"> 
                              <label style="color:white" >Destination</label>
								<select class="form-control" id="source" name="destination">
									<option value="KOLKATA">Kolkata(CCU)</option>
									<option value="JAIPUR">Jaipur(JAI)</option>
									<option value="MUMBAI">Mumbai(BOM)</option>
								</select>
							</div>
								</div>
								<div class="row">
                                
                                
                                <div class="form-group">
									<span class="form-label">JourneyDate</span>
	                 <input class="form-control" type="date" name="date" placeholder=<%=d%> />
                                </div>
                                </div>
								
								<div class="row">
									
									<div class="col-sm-4">
										<div class="form-group">
											<span class="form-label">Passengers</span>
											<select class="form-control" name="passenger">
												<option>1</option>
												<option>2</option>
												<option>3</option>
                                                <option>4</option>

											</select>
											<span class="select-arrow"></span>
										</div>
									</div>
									
								</div>
                                
                                
                                
                                
                                
                                
								<div class="form-btn">
									<button class="submit-btn">Check Flight</button>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
      </div>
      </form>
</body><!-- This templates was made by Colorlib (https://colorlib.com) -->

</html>