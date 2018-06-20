<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Profile</title>
<%-- <%@include file="includes/include-css.jsp"%> --%>

</head>

<body>
	<%@ include file ="includes/header.jsp" %>
	
	<div class="container"  style="padding-top: 150px;">
		<div class="row">
			<div class=" col-md-9 mx-auto">
				<h2>Update your  Job Profile</h2><br>
					<div class="myform form">
						<form id="updateJob">
							
							  <div class="form-group">
								<label for="image">Upload Picture</label>
								<input type="text" id="image" class="form-control">
							  </div> 
							  <div class="form-group">
							  	<label for="bio"> Describe your professional background </label>
							  	<textarea rows="5" cols="5" class="form-control" id="bio"></textarea>
							  </div>
							  <div class="form-group">
							  	<label for="industry">Industry</label>
							  	<select  name="industry" id="industry" class="form-control" aria-describedby="emailHelp" >
								  <option value="Accounting/Finance">Accounting/Finance</option>
								  <option value="Advertising/PR/MR/Events">Advertising/PR/MR/Events</option>
								  <option value="Architecture/Interior Designing">Architecture/Interior Designing</option>
								  <option value="Aviation/Aerospace Firms">Aviation/Aerospace Firms</option>
								  <option value="Banking/Financial Services/Broking">Banking/Financial Services/Broking</option>
								  <option value="Construction/Engineering/Cement/Metals">Construction/Engineering/Cement/Metals</option>
								  <option value="Export Import">Export Import</option>
								  <option value="Food Processing">Food Processing</option>
								  <option value="Gems and Jewellery">Gems and Jewellery</option>
								  <option value="Hotel Management">Hotel Management</option>
								  <option value="Heavy Machinery">Heavy Machinery</option>
								  <option value="Insurance">Insurance</option>
								  <option value="Internet/E-Commerce">Internet/E-Commerce</option>
								  <option value="IT- Hardware/ Software Services">IT- Hardware/ Software Services</option>
								  <option value="Leather">Leather</option>
								  <option value="Healthcare/ Medical equipments">Healthcare/ Medical equipments</option>
								  <option value="Mining">Mining</option> 
								  <option value="NGO and Social Services">NGO and Social Services</option>
								  <option value="Automation">Automation</option>
								  <option value="Security/ Law Enforcements">Security/ Law Enforcements</option>
								  <option value="Real-estate">Real-estate</option> 
								  <option value="Shipping & Marine">Shipping & Marine</option>
								  <option value="Textiles">Textiles</option>
								</select>
							  </div>
							  <div class="form-group">
							  	<label for="fuction">Functional Area </label>
							  	<select  name="area" id="area" class="form-control" aria-describedby="emailHelp">
								  <option value="Accounting/Finance/Tax">Accounting/Finance/Tax</option>
								  <option value="Agent">Agent</option>
								  <option value="Analytics/ Business Intelligence">Analytics/ Business Intelligence</option>
								  <option value="Architecture/Interior Designing">Architecture/Interior Designing</option>
								  <option value="Banking/Insurance">Banking/Insurance</option>
								  <option value="Content Journalism">Content Journalism</option>
								  <option value="Corporate Planning/ Consulting">Corporate Planning/ Consulting</option>
								  <option value="Engineering Design/ R&D">Engineering Design/ R&D</option>
								  <option value="Export/ Import/ Mechandise">Export/ Import/ Mechandise</option>
								  <option value="IT Software- Client Server">IT Software- Client Server</option>
								  <option value="IT Software- Mainframe">IT Software- Mainframe</option>
								  <option value="IT Software- Middleware">IT Software- Middleware</option>
								  <option value="IT Software- Mobile">IT Software- Mobile</option>
								  <option value="IT Software- ECommerce">IT Software- ECommerce</option>
								  <option value="Marketing/ Advertising">Marketing/ Advertising</option>
								  <option value="Legal">Legal</option>
								  <option value="Graphic Design/ Visualising">Graphic Design/ Visualising</option>
								</select>
							  </div>
							  <div class="form-group">
							  	<label for="role">Role </label>
							  	<input type="text" id="role" class="form-control">
							  </div>
							  <div class="form-group">
							  	<label for="loc">Preferred Work Location</label>
							  	<select  name="city" id="location" class="form-control" aria-describedby="emailHelp" >
								  <option value="Ahmedabad">Ahemdabad</option>
								  <option value="Bangalore">Bangalore</option>
								  <option value="Bhopal">Bhopal</option>
								  <option value="Bhubhaneshwar">Bhubhaneshawar</option>
								  <option value="Chennai">Chennai</option>
								  <option value=" New Delhi">New Delhi</option>
								  <option value="Gurgaon">Gurgaon</option>
								  <option value="Guwahati">Guwahati</option>
								  <option value="Hyderabad">Hyderabad</option>
								  <option value="Indore">Indore</option>
								  <option value="Jaipur">Jaipur</option>
								  <option value="Kolkata">Koltata</option>
								  <option value="Lucknow">Lucknow</option>
								  <option value="Mumbai">Mumbai</option>
								  <option value="Noida">Noida</option>
								  <option value="Patna">Patna</option>
								  <option value="Pune">Pune</option> 
								  <option value="Srinagar">Srinagar</option>
								</select>
							  </div>
							  <div class="form-group">
							  	<label for="type_job">Desired Job Type</label><br>
							  	<input type="radio" name="jobtype"> Permanent
							  	<input type="radio" name="jobtype"> Temporary/ Contract
							  	<input type="radio" name="jobtype"> Both
							  </div>
							  <div class="form-group">
							  	<label for="type_employ">Desired Employment Type</label><br>
							  	<input type="radio" name="emptype"> Full-Time
							  	<input type="radio" name="emptype"> Part-Time
							  	<input type="radio" name="emptype"> Both
							  </div>
							  <div class="form-group">
							  	<label for="skills">Skills</label>
							  	<textarea rows="5" cols="5" class="form-control" id="skills"></textarea>
							  </div>
							  <div class="form-group">
							  	<label for="status">Marital Status</label>
							  	<select name="status" id="status" class="form-control">
							  		<option value="Married">Married</option>
							  		<option value="Single">Single</option>
							  		<option value="Widowed">Widowed</option>
							  		<option value="Divorced">Divorced</option>
							  	</select>
							  </div>
							  <div class="form-group">
							  	<label for="aadhar">Upload Aadhar Card</label>
							  	<input type="text" id="aadhar" class="form-control">
							  </div>
							  <div class="form-group">
							  	<label for="passport">Upload Passport</label>
							  	<input type="text" id="passport" class="form-control">
							  </div>
							  <div class="form-group">
							  	<label for="resume">Upload Resume</label>
							  	<input type="text" id="resume" class="form-control">
							  </div>
							  <hr>
							  <div class="form-group">
							  	<b><input type="submit" class="form-control" value="Submit and view Profile"></b>
							  </div>
							  <br>
						</form>
					</div>
			</div>
		</div>
	</div>
	
	
	
	
	<%@ include file ="includes/footer.jsp" %>
	<%@include file="includes/include-js.jsp"%> 
	
</body>
</html>