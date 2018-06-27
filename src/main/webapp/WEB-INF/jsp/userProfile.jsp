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
	<div class="container">
		<center>
                    <img src="https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcRbezqZpEuwGSvitKy3wrwnth5kysKdRqBW54cAszm_wiutku3R" name="aboutme" width="140" height="140" border="0" class="img-circle"></a>
                    <h3 class="media-heading">Joe Sixpack <small>USA</small></h3>
                    <span><strong>Skills: </strong></span>
                        <span class="label label-warning">HTML5/CSS</span>
                        <span class="label label-info">Adobe CS 5.5</span>
                        <span class="label label-info">Microsoft Office</span>
                        <span class="label label-success">Windows XP, Vista, 7</span>
                    </center>
                    <hr>
<center style="padding-top: 0;">
                    <h2 class="text-left"><strong>Bio: </strong><br> </h2>
                       <p> Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut sem dui, tempor sit amet commodo a, vulputate vel tellus. </p>
                    <br>
                   <!--   <div class="panel panel-default"> -->
                    </center>
                    
                    <input type="button" value="Update Education Details" onclick="updateEducation()">
                    <h2 class="text-left"><strong>UG Education Details- </strong><br> </h2>
                    <div class="panel panel-default">
                    <p class="text-left"><strong>UG Course: </strong><br>
                       ${userInfo.graduation.name } </p>
                       <p class="text-left"><strong>Specialization </strong><br>
                       ${userInfo.graduation.specialization }) </p>
                       <p class="text-left"><strong>YearOfPassing </strong><br>
                       ${userInfo.graduation.yearOfPassing } </p>
                       <p class="text-left"><strong>Grading System</strong><br>
                       ${userInfo.graduation.educationType } </p>
                       <p class="text-left"><strong>Marks </strong><br>
                       ${userInfo.graduation.marks }</p>
                       <p class="text-left"><strong>College/Institute</strong><br>
                       ${userInfo.graduation.universityName }</p>
                       <br>
                      </div>
                       <h2 class="text-left"><strong>Senior Secondary and Higher Secondary Education Details </strong><br> </h2>
                      <div class="panel panel-default">
                       <h3 class="text-left"><strong>Class 12</strong><br> </h3>
                       <p class="text-left"><strong>Board/Diploma</strong><br>
                       ${userInfo.twelfthStandard.name }</p>
                       <p class="text-left"><strong>Marks</strong><br>
                       ${userInfo.twelfthStandard.marks }</p>
                       <p class="text-left"><strong>Passing Year</strong><br>
                       ${userInfo.twelfthStandard.yearOfPassing }</p>
                       <p class="text-left"><strong>Medium</strong><br>
                       ${userInfo.twelfthStandard.board }</p>
                       </div>
                       
                       <h3 class="text-left"><strong>Class 10 </strong><br> </h3>
                       <div class="panel panel-default">
                       <p class="text-left"><strong>Board/Diploma</strong><br>
                       ${userInfo.tenthStandard.name }</p>
                       <p class="text-left"><strong>Marks</strong><br>
                       ${userInfo.tenthStandard.marks }</p>
                       <p class="text-left"><strong>Passing Year</strong><br>
                       ${userInfo.tenthStandard.yearOfPassing }</p>
                       <p class="text-left"><strong>Medium</strong><br>
                       ${userInfo.tenthStandard.board }</p>
                       </div>
                       
                       <h2 class="text-left"><strong>Work preference- </strong><br> </h2>
                       <div class="panel panel-default">
                       <p class="text-left"><strong>Secification of Preference</strong><br>
                       ${userInfo.workExperience.preference }</p>
                       <p class="text-left"><strong>When Can I Start Working</strong><br>
                       ${userInfo.workExperience.startDate }</p>
                       <p class="text-left"><strong>Preferred Location</strong><br>
                       ${userInfo.workExperience.location }</p>
                       </div>
                       
                       <h2 class="text-left"><strong>Internship Details- </strong><br> </h2>
                       <div class="panel panel-default">
                       <p class="text-left"><strong>Company</strong><br>
                       ${userInfo.internship.company }</p>
                       <p class="text-left"><strong>Duration</strong><br>
                        ${userInfo.internship.duration_start }</p>
                       <p class="text-left"><strong>To</strong><br>
                        ${userInfo.internship.duration_end }</p>
                       <p class="text-left"><strong>Details</strong><br>
                       ${userInfo.internship.details }</p>
                       </div>
                       
                       
                       <input type="button" value="Update Job Details" onclick="updateJob()">
                       <h2 class="text-left"><strong>Job Details- </strong> </h2>
                       <div class="panel panel-default">
                       <p class="text-left"><strong>Profile Picture</strong><br>
                     <!--   <div class="fileinput fileinput-new" data-provides="fileinput"> <div class="fileinput-preview thumbnail" data-trigger="fileinput" style="width: 50px; height: 25px;"></div> <div> <span class="btn btn-default btn-file"><span class="fileinput-new">Select image</span><span class="fileinput-exists">Change</span><input type="file" name="..."></span>
                        <a href="#" class="btn btn-default fileinput-exists" data-dismiss="fileinput">Remove</a> </div> </div> -->
                       <br>
                       
                       <p class="text-left"><strong>Describe your professional background in one line</strong><br>
                       ${jobInfo.bio }</p>
                       <p class="text-left"><strong>Industry</strong><br>
                       ${jobInfo.industry }</p>
                       <p class="text-left"><strong>Functional Area</strong><br>
                       ${jobInfo.functionalArea }</p>
                       <p class="text-left"><strong>Role</strong><br>
                       ${jobInfo.role }</p>
                       <p class="text-left"><strong>Preferred Work Location</strong><br>
                       ${jobInfo.workLocation }</p>
                       <p class="text-left"><strong>Desired Job Type</strong><br>
                       ${jobInfo.jobType }</p>
                       <p class="text-left"><strong>Desired Employment Type</strong><br>
                       ${jobInfo.employmentType }</p>
                       <p class="text-left"><strong>Skills</strong><br>
                       ${jobInfo.skills }</p>
                       <p class="text-left"><strong>Marital Status</strong><br>
                       ${jobInfo.maritalStatus }</p>
                       
                       <p class="text-left"><strong>Aadhar Card</strong><br>
                      <!--   <div class="fileinput fileinput-new" data-provides="fileinput"> <div class="fileinput-preview thumbnail" data-trigger="fileinput" style="width: 50px; height: 25px;"></div> <div> <span class="btn btn-default btn-file"><span class="fileinput-new">Select image</span><span class="fileinput-exists">Change</span><input type="file" name="..."></span>
                        <a href="#" class="btn btn-default fileinput-exists" data-dismiss="fileinput">Remove</a> </div> </div> -->
                       <br>
                       <p class="text-left"><strong>Passport</strong><br>
                  <!--      <div class="fileinput fileinput-new" data-provides="fileinput"> <div class="fileinput-preview thumbnail" data-trigger="fileinput" style="width: 50px; height: 25px;"></div> <div> <span class="btn btn-default btn-file"><span class="fileinput-new">Select image</span><span class="fileinput-exists">Change</span><input type="file" name="..."></span>
                        <a href="#" class="btn btn-default fileinput-exists" data-dismiss="fileinput">Remove</a> </div> </div> -->
                        <br>
                       <p class="text-left"><strong>Resume</strong><br>
                <!--         <link rel="stylesheet" type="text/css" href="css/file-upload.css" />
                       <script src="js/file-upload.js"></script>
                                  <script type="text/javascript">
                                  $(document).ready(function() {
                                       $('.file-upload').file_upload();
                                                     });
                                        </script>
                       <form class="form-horizontal">
                            <div class="form-group">
                              <div class="col-sm-offset-0 col-sm-10">
                              <label class="file-upload btn btn-primary">
                                    Browse for file ... <input type="file" />
                              </label>
                              </div>
                            </div>
                       </form> -->
        
                       </div>
                       
                    	</div>
                    	
                    	
                    	
                    
	<%@ include file ="includes/footer.jsp" %>
	<%@include file="includes/include-js.jsp"%>
	
</body>

<script type="text/javascript">

function updateEducation(){
	
	location.href="http://localhost:8080/Dew-Training/user/addupdateProfile";
}

function updateJob(){
	
	location.href="http://localhost:8080/Dew-Training/user/addjobProfile";
}

</script>
</html>