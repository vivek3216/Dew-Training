<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Profile</title>
<%-- <%@include file="includes/include-css.jsp"%> --%>


<style>

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
			<div class=" col-md-8 mx-auto">
			<h2>Update your Profile</h2><br>
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
							<label for="course">UG Course</label>
							<input type="text" class="form-control" id="course" placeholder="Enter your highest qualification" >
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
							<input type="text" class="form-control" id="grade" placeholder="Enter your grading system" >
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
							<input type="text" class="form-control" id="board" placeholder="Enter your board/diploma" ><br>
							<input type="text" class="form-control" id="marks" placeholder="Enter your marks" ><br>
							<input type="text" class="form-control" id="year" placeholder="Enter your passing year" ><br>
							<input type="text" class="form-control" id="medium" placeholder="Enter your medium" ><br>
						</div>
						<div class="form-group">
							<label for="class10">Class 10</label>
							<input type="text" class="form-control" id="board_m" placeholder="Enter your board/diploma" ><br>
							<input type="text" class="form-control" id="marks_m" placeholder="Enter your marks" ><br>
							<input type="text" class="form-control" id="year_m" placeholder="Enter your passing year" ><br>
							<input type="text" class="form-control" id="medium_m" placeholder="Enter your medium" ><br>
						</div>
					</div>
					</div>
				</div>
				</form>
			</div>
		</div>
	
	</div>
	<%@ include file ="includes/footer.jsp" %>
	<%@include file="includes/include-js.jsp"%>
	
</body>
</html>