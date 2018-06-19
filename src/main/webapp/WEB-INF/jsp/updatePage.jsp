<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Profile</title>
<%-- <%@include file="includes/include-css.jsp"%> --%>


<style>

.myform {
    position: relative;
    display: -ms-flexbox;
    display: flex;
    padding: 1rem;
    -ms-flex-direction: column;
    flex-direction: column;
    width: 100%;
    pointer-events: auto;
    background-color: #fff;
    background-clip: padding-box;
    border: 1px solid rgba(0,0,0,.2);
    border-radius: 1.1rem;
    outline: 0;
}
#UG-education{
	margins: {top:2, left:2, right:2, bottom:2} !important;
	cmargins: {top:0, left:0, right:0, bottom:0} !important;
}
</style>
</head>
<body>
	<%@ include file ="includes/header.jsp" %>
	
	
	<div class="container"  style="padding-top: 150px;">
		<div class="row">
			<div class=" col-md-9 mx-auto">
			<h2>Update your Profile</h2><br>
			<div class="myform form">
			<form id="updateForm">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="text-center">Education Details</h3>
					</div>
					<div class="panel panel-default">
						<div class="panel-body" id="UG-education">
							<h4>Under-Graduate Education Details</h4>
						</div>
					<div class="panel-body">
						<div class="form-group">
							<label for="course_select">UG Course</label>
							<select  name="course" id="course_ug" class="form-control" aria-describedby="emailHelp" placeholder="Select Course">
							  <option value="B.Com">B.Com</option>
							  <option value="B.A.">B.A.</option>
							  <option value="B.Arch">B.Arch</option>
							  <option value="B.Des">B.Des</option>
							  <option value="B.Ed">B.Ed</option>
							  <option value="B.Pharma">B.Pharma</option>
							  <option value="B.Sc">B.Sc</option>
							  <option value="B.Tourism">B.Tourism</option>
							  <option value="BBA/ BBM/ BBS">BBA/ BBM/ BBS</option>
							  <option value="BCA/ BCM">BCA/ BCM</option>
							  <option value="BDS">BDS</option>
							  <option value="BE/ B.Tech">BE/ B.Tech</option>
							  <option value="BFA">BFA</option>
							  <option value="BHM">BMH</option>
							  <option value="BJMC">BJMC</option>
							  <option value="BVSc">BVSc</option>
							  <option value="Diploma">Diploma</option> 
							  <option value="LLB">LLB</option>
							  <option value="MBBS">MBBS</option>
							</select>
						</div>
						<div class="form-group">
							<label for="specialization">Specialization</label>
							<input type="text" class="form-control" id="specialization" placeholder="Enter your specialization" >
						</div>
						<div class="form-group">
							<label for="yearOfPassing">Year of Passing</label>
							<input type="date" class="form-control" id="year" placeholder="Enter your year of passing" >
						</div>
						<div class="form-group">
							<label for="grading">Grading System</label>
							<select  name="grade_sys" id="grade_sys" class="form-control" aria-describedby="emailHelp" value="Select system">
							  <option value="Scale 10 Grading System">Scale 10 Grading System</option>
							  <option value="Scale 4 Grading System">Scale 4 Grading System</option>
							  <option value="% Marks out of 100 Max">% Marks out of 100 Max</option>
							  <option value="Course requires a Pass">Course requires a Pass</option>
							  </select>
						</div>
						<div class="form-group">
							<label for="marks">Marks</label>
							<input type="text" class="form-control" id="marks" placeholder="Enter marks" >
						</div>
						<div class="form-group">
							<label for="college">College/Institute, City</label>
							<input type="text" class="form-control" id="college" placeholder="Enter college/institute" >
						</div>
					</div>
					</div>
					<div class="panel panel-default">
						<div class="panel-body" id="UG-education">
							<h4>Senior Secondary and Higher Secondary Education Details</h4>
						</div>
					<div class="panel-body">
						<div class="form-group">
							<label for="class12">Class 12</label>
							<select  name="board" id="board_tw" class="form-control" aria-describedby="emailHelp" placeholder="Select Board">
							  <option value="CBSE">CBSE</option>
							  <option value="CISCE(ICSE/ISC)">CISCE(ICSE/ISC)</option>
							  <option value="Diploma">Diploma</option>
							  <option value="National Open School">National Open School</option>
							  <option value="State Board">State Board</option>
							 </select><br>
							<input type="text" class="form-control" id="marks" placeholder="Enter your marks" ><br>
							<input type="date" class="form-control" id="year" placeholder="Enter your passing year" ><br>
							<select  name="medium" id="medium_tw" class="form-control" aria-describedby="emailHelp" placeholder="Select Medium">
							  <option value="Assamese/Asomiya">Assamese/Asomiya</option>
							  <option value="Bengali/Bangla">Bengali/Bangla</option>
							  <option value="English">English</option>
							  <option value="Gujrati">Gujrati</option>
							  <option value="Hindi">Hindi</option>
							  <option value="Kannada">Kannadaoption>
							  <option value="Kashmiri">Kashmiri</option>
							  <option value="Konkani">Konkani</option>
							  <option value="Malayalam">Malayalam</option>
							  <option value="Manipuri">Manipuri<option>
							  <option value="Marathi">Marathi</option>
							  <option value="Oriya">Oriya<option>
							  <option value="Punjabi">Punjabi</option>
							  <option value="Sanskrit">Sanskrit</option>
							  <option value="Tamil">Tamil</option>
							  <option value="Telugu">Telugu</option>
							  <option value="Urdu">Urdu</option> 
							</select><br>
						</div>
						<div class="form-group">
							<label for="class10">Class 10</label>
							<select  name="board" id="board_tw" class="form-control" aria-describedby="emailHelp" placeholder="Select Board">
							  <option value="CBSE">CBSE</option>
							  <option value="CISCE(ICSE/ISC)">CISCE(ICSE/ISC)</option>
							  <option value="Diploma">Diploma</option>
							  <option value="National Open School">National Open School</option><br>
							  <option value="State Board">State Board</option>
							 </select><br>
							<input type="text" class="form-control" id="marks_m" placeholder="Enter your marks" ><br>
							<input type="date" class="form-control" id="year_m" placeholder="Enter your passing year" ><br>
							<select  name="medium" id="medium_te" class="form-control" aria-describedby="emailHelp" placeholder="Select Medium">
							  <option value="Assamese/Asomiya">Assamese/Asomiya</option>
							  <option value="Bengali/Bangla">Bengali/Bangla</option>
							  <option value="English">English</option>
							  <option value="Gujrati">Gujrati</option>
							  <option value="Hindi">Hindi</option>
							  <option value="Kannada">Kannadaoption>
							  <option value="Kashmiri">Kashmiri</option>
							  <option value="Konkani">Konkani</option>
							  <option value="Malayalam">Malayalam</option>
							  <option value="Manipuri">Manipuri<option>
							  <option value="Marathi">Marathi</option>
							  <option value="Oriya">Oriya<option>
							  <option value="Punjabi">Punjabi</option>
							  <option value="Sanskrit">Sanskrit</option>
							  <option value="Tamil">Tamil</option>
							  <option value="Telugu">Telugu</option>
							  <option value="Urdu">Urdu</option> 
							</select><br>
						</div>
					</div>
					</div>
				</div>
				
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="text-center"> Work Preference </h3>
					</div>
					<div class="panel-body">
						<div class="form-group">
							<label for="work_pre">Specify your preference: </label>
							<label class="radio-inline"><input type="radio" name="work" value="full-time"> Full-Time</label>
							<label class="radio-inline"><input type="radio" name="work" value="part-time"> Part-Time</label>
							<label class="radio-inline"><input type="radio" name="work" value="internship"> Internship</label>
 						</div>
 						<div class="form-group">
 							<label for="start_date"> When can you start working? </label>
 							<label class="radio-inline"><input type= "radio" name="start_work" value="immediately"> Immediately</label> 
 							<label class="radio-inline"><input type="radio" name="start_work"  value="date"> Date </label>
 							<label class="radio-inline">	<input type="date" name="start_work" > </label>
 						</div>
 						<div class="form-group">
 							<label for="location"> Preferred location: </label>
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
					</div>
				</div>
				
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="text-center"> Internship Details</h3>
					</div>
					<div class="panel-body">
						<div class="form-group">
							<label for="company-name"> Company </label>
							<input type="text" id="company_name" class="form-control">
						</div>
						<div class="form-group">
							<label for="duration"> Duration </label>
							<input type= "date" id="date_start" class="form-control">
							<h5> To </h5>
							<input type="date" id="date-end" class="form-control">
						</div>
						<div class="form-group">
							<label for="details"> Details</label>
							<textarea rows="5" cols="10" class="form-control" name="details" id="details"></textarea>
						</div>
					</div>
				</div>
				<div class="panel panel-default">
					<div class="panel-body">
						<div class="form-group">
							<input type="checkbox" name="agree"> I have read and I agree to the terms and conditions.
							<br><br>
							<b><input class="form-control" type="submit" id="agreed" value="Submit and continue with registration"></b> 
						</div>
					</div>
				</div>
				</form>
				</div>
			</div>
		</div>
	
	</div>
	
	  <%@ include file ="includes/footer.jsp" %>
	<%@include file="includes/include-js.jsp"%> 
	
</body>
</html>