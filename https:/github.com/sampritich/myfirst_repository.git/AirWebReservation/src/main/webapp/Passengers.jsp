<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
      body {
      position: relative; 
          background-image: url(images/Dolomites.jpg);
          
  }
   #section1 {padding-top:50px;height:500px;}
    
    </style>
    </head>
   <body data-spy="scroll"  >
       <form action="TicketGenerateController" method="post">
       
    <%int passenger=(Integer)session.getAttribute("passenger");
System.out.println(passenger);
%>
    <%for(int i=0;i<passenger;i++)

							{

							%>
    <div id="section1" class="container-fluid" >
         

                            
 <center>
                           <h1> <span style="color:white">Passenger <%=i+1%></span></h1>
							</center>
  <div class="form-group">
      

								<div align="center">

									<div class="form-check form-check-inline">
									
									  <input type="radio" class="form-check-input" id="salutation<%=i+1%>" name="salutation<%=i+1%>" value="Mr.">
									  <label class="form-check-label" for="materialInline" style="color:white">Mr.</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									
									
									  <input type="radio" class="form-check-input" id="salutation<%=i+1%>" name="salutation<%=i+1%>" value="Mrs.">
									  <label class="form-check-label" for="materialInline" style="color:white">Mrs.</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
																		
									
									  <input type="radio" class="form-check-input" id="salutation<%=i+1%>" name="salutation<%=i+1%>" value="Miss.">
									  <label class="form-check-label" for="materialInline" style="color:white">Miss.</label>
									  
									</div>
									
								</div>

							</div>
     

								<div class="col-md-4">

									<div class="form-group">

										<span class="form-label"><strong>FirstName</strong></span>

 										<input class="form-control" type="text" placeholder="Enter your Firstname" name="firstname<%=i+1%>">

									</div>

								</div>

								<div class="col-md-4">

									<div class="form-group">

										<span class="form-label"><strong>LastName</strong></span>

										<input class="form-control" type="text" placeholder="Enter Your Lastname" name="lastname<%=i+1%>">

									</div>

								</div>

							

							
<div class="col-md-2">
								<div class="form-group">
									<span class="form-label"><strong>Type of passenger</strong></span>
									<select class="form-control" name="passengertype<%=i+1%>">
																		<option value="select<%=i+1%>">Select </option>
									
									<option value="regular" selected>Regular </option>
									
										<option value="student">Student </option>
										<option value="handicapped">Handicapped</option>
										<option value="senior citizen">Senior citizen</option>
                                        <option value="airline staff">Airline Staff</option>
                                     <option  value="defense personnel">Defense personnel</option>


									</select>
									<span class="select-arrow"></span>
								</div>
							</div>
     
     <div class="col-md-3">
								<div class="form-group">
									<span class="form-label"><strong>Seat type 1</strong></span>
									<select class="form-control" name="seattype1<%=i+1%>">
                                        <option value="select">Select </option>
                                            <option value="window" >Window</option>
                                            <option value="aisle">Aisle</option>
                                         <option value="near emergency">Near Emergency</option>

                                            
										
									</select>
									<span class="select-arrow"></span>
								</div>
							</div>
     <div class="col-md-3">
								<div class="form-group">
									<span class="form-label"><strong>Seat type 2</strong></span>
									<select class="form-control" name="seattype2<%=i+1%>">
							<optgroup  label="Seat Location Type2">
							<option value="select">Select </option>
                                            <option value="front" >Front</option>
                                            <option value="middle" >Middle</option>
                                         <option value="back">Back</option>

                                            
                                            </optgroup>
										
                                     	
									</select>
									<span class="select-arrow"></span>
								</div>
							</div>
     <div class="col-md-3">
								<div class="form-group">
									<span class="form-label"><strong>Meal</strong></span>
									<select class="form-control" name="meal<%=i+1%>">
							<option value="select">Select </option>
                                            <option value="veg">Veg</option>
                                            <option value="nonveg">Non Veg</option>
                                        

                                            
                                               
</select>
									<span class="select-arrow"></span>
								</div>
							</div>
							<div class="col-md-2">
								<div class="form-group">
									<span class="form-label"><strong>Handicapped</strong></span>
									
									<select class="form-control" name="medical<%=i+1%>">
									<optgroup label=" Physically disabled">
									
									<option value="No"> No</option>
									</optgroup>
									<optgroup label="if handicapped">
										<option value="wheelchair">Wheelchairs</option>
										<option value="nurses">Nurses</option>
										<option value="attendants">Attendants</option>
                                        <option value="special medicines">Special Medicines</option>
                                     

</optgroup>

									</select>
									<span class="select-arrow"></span>
								</div>
							</div>
     
     

 
</div>
     <%} %>

 
      




								

								<div class="col-md-6">

 									
<center>
                                       

										<button type="submit" class="btn btn-primary btn-lg btn-block" style="background-color: red" name="Book" value="next">Next </button>
                                            </center>

									

								</div>

                                    

							
        </form>

</body>
</html>


    
    
    
    
    
    
    
    
    
    