<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Visa</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">

		<!-- LINEARICONS -->
		<link rel="stylesheet" href="fonts1/linearicons/style.css">

		<!-- MATERIAL DESIGN ICONIC FONT -->
		<link rel="stylesheet" href="fonts/material-design-iconic-font/css/material-design-iconic-font.min.css">

		<!-- DATE-PICKER -->
		<link rel="stylesheet" href="vendor/date-picker/css/datepicker.min.css">
		
		<!-- STYLE CSS -->
		<link rel="stylesheet" href="css5/style.css">
        <style>
        
        
        .checkbox {
  padding-left: 20px; }
            
            .checkbox-success input[type="checkbox"]:checked + label::before {
  background-color: #5cb85c;
  border-color: #5cb85c; }
.checkbox-success input[type="checkbox"]:checked + label::after {
  color: #fff; }

        </style>
	</head>

	<body>
<form action="TicketDisplayController" method="post">
		<div class="wrapper">
			<div class="inner">
				<form action="">
                    <h3>Enter your visa information </h3>
					<div class="form-row">
						<div class="form-wrapper">
							<label for="">  country that issued visa  *</label>
							<input type="text" class="form-control" name="country" placeholder="country">
						</div>
						<div class="form-wrapper">
							<label for="">Visa identity number *</label>
							<input type="text" class="form-control" name="number"placeholder="visa number">
						</div>
					</div>
					<div class="form-row">
						<div class="form-wrapper">
							<label for=""> Date of the visa issue *</label>
							<span class="lnr lnr-calendar-full"></span>
							<input type="date" class="form-control datepicker-here" data-language='en' name="issuedate" data-date-format="dd M yyyy" id="dp1">
						</div>
						<div class="form-wrapper">
							<label for="">Date of the visa expiry*</label>
							<span class="lnr lnr-calendar-full"></span>
							<input type="date" class="form-control datepicker-here" data-language='en' name="expirydate" data-date-format="dd M yyyy" id="dp2">
						</div>
					</div>
					
                   <div class="form-group">
    <div class="form-check">
      <input class="form-check-input" type="checkbox" value="" id="invalidCheck2" required>
      <label class="form-check-label" for="invalidCheck2">
        <a href="">Agree to terms and conditions</a>
          <br>
          <span>read terms and conditions</span>
      </label>
    </div>
  </div>
                    
                    
					
					<button data-text="Next" type="submit" name="next" value="next">
						<span>Next</span>
					</button>
				</form>
			</div>
		</div>
		
		<script src="js1/jquery-3.3.1.min.js"></script>

		<!-- DATE-PICKER -->
		<script src="vendor/date-picker/js/datepicker.js"></script>
		<script src="vendor/date-picker/js/datepicker.en.js"></script>

		<script src="js1/main.js"></script>
		</form>
	</body><!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>