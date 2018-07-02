$.fn.serializeObject = function()
{
   var o = {};
   var a = this.serializeArray();
   $.each(a, function() {
       if (o[this.name]) {
           if (!o[this.name].push) {
               o[this.name] = [o[this.name]];
           }
           o[this.name].push(this.value || '');
       } else {
           o[this.name] = this.value || '';
       }
   });
   return o;
};

$("#header").addClass('header-scrolled')
$.fn.serializeObject = function()
{
   var o = {};
   var a = this.serializeArray();
   $.each(a, function() {
       if (o[this.name]) {
           if (!o[this.name].push) {
               o[this.name] = [o[this.name]];
           }
           o[this.name].push(this.value || '');
       } else {
           o[this.name] = this.value || '';
       }
   });
   return o;
};
function submitForm(){
	var formData=$("#registerForm").serializeObject();
	console.log(formData);
	var url="http://localhost:8090/Training/register/";
	$.ajax({
        url : url,
        type : 'POST',
        data:JSON.stringify(formData),
        dataType : "json",
        contentType : "application/json",
        success : function(data) {
			console.log(data);
        }
      });
}


function doLogin(){
	var formData=$("#loginform").serializeObject();
	console.log(formData);
	var url=$("#baseUrl").val()+"/user/login/";
	$.ajax({
        url : url,
        type : 'POST',
        data:JSON.stringify(formData),
        dataType : "json",
        contentType : "application/json",
        success : function(data) {
			console.log(data);
			if(data.loggedIn){
				window.location.reload();
			}
        }
      });
}
		function openSignUp(){
		$("#first").addClass('hidden');
		$("#second").removeClass('hidden');
	}
	
	function openSignIn(){
		$("#first").removeClass('hidden');
		$("#second").addClass('hidden');
	}
	
	function openPage() {
		$("#first").addClass('hidden');
		$("#third").removeClass('hidden');
	}
function submitUserInfo(){
	var userInfo={};
	var ugData=JSON.stringify($("#ugFrm").serializeObject());
	var tenthData=JSON.stringify($("#tenthFrm").serializeObject());
	var twelfthData=JSON.stringify($("#twelfthFrm").serializeObject());
	var workData=JSON.stringify($("#workFrm").serializeObject());
	var internData=JSON.stringify($("#internFrm").serializeObject());
	userInfo.tenthStandard=tenthData;
	userInfo.twelfthStandard=twelfthData;
	userInfo.graduation=ugData;
	userInfo.workExperience=workData;
	console.log(userInfo)
	var url="http://localhost:8090/Training/updateUserInfo/";
	$.ajax({
        url : url,
        type : 'POST',
        data:JSON.stringify(userInfo),
        dataType : "json",
        contentType : "application/json",
        success : function(data) {
			console.log(data);
        }
      });
}

function initFileUpload(){
	/*data-url="../../api/uploadImages/"*/
	console.log("called")
		$('#fileupload').css("visibility", "visible");
		var intvlId;
		var id;
		$('#fileupload').fileupload({
			acceptFileTypes : /(\.|\/)(jpg|jpeg)$/i,
			dataType : 'json',
			progressInterval: 1000,
			replaceFileInput : false,
			limitMultiFileUploads : 10,
			//limitConcurrentUploads : 1,
			singleFileUploads : false,
			formData : function(form) {
				console.log(form);
				return form.serializeArray();
			},
			add : function(e, data) {
				id=$(this).attr("id");
				var fileNames = '';
				var validFiles = true;
				$.each(data.files, function(index, file) {
					fileNames += file.name + ', ';
					if (!file.name.substring(file.name.lastIndexOf(".") + 1).match(/(jpg|jpeg)/ig)) {
						validFiles = false;
					}
				});
				//alert("validFiles"+validFiles);
				if (validFiles) {
					//alert("v"+id);
					if(fileNames.length > 0){
						fileNames = fileNames.substring(0, fileNames.length-2);
					}
					$("#upload-filename").removeClass("invalid-filetype").val(fileNames);
					$("#upload-btn").show();
					$("#upload-btn").unbind('click').bind('click', function() {
						data.submit();
					});
				} else {
					alert("Please add jpg/jpeg format images only");
					$("#upload-filename").addClass("invalid-filetype").html("Please select Image files only.jpeg/jpg");
					$("#upload-btn").hide();
				}
			},
			done : function(e, data) {
				$("#successMessage"+id).show();
				$("#fileUploadDiv #"+(id)).attr("disabled","disabled");
				$("#fileUploadDiv #"+(parseInt(id)+parseInt(1))).removeAttr("disabled");
				$("#fileUploadDiv #upload-btn"+(parseInt(id)+parseInt(1))).removeAttr("disabled");
				if(id==3){
					window.location.reload();
				}
			},
			fail : function(e, data) {
				if($.browser.msie){
					//window.clearInterval(intvlId);
				}
				setTimeout(function() {
					$("#cabinet").addClass('cabinet');
					$("#cabinet").removeClass('newCabinet');
					$("#fileupload").removeAttr('disabled');
					showHide();}, 3000); 
			},
			progressall : function(e, data) {
			},
			start : function(e) {
				$("#upload-btn"+id).unbind('click').hide();
				$("#txnuploadStart").show();
			},submit:function(){
				$("#txnuploadsuccess").hide();
				$("#fileupload").attr('disabled','disabled');
				$("#cabinet").removeClass('cabinet');
				$("#cabinet").addClass('newCabinet');
			}
		});
	}


$(document).ready(function(){
	
	$("#btn-password-request").click(function(){
		var url=$("#baseUrl").val()+"/forgotPassword?email="+$("#forgot-password-email").val();
		$.ajax({
	        url : url,
	        type : 'POST',
	        dataType : "json",
	        contentType : "application/json",
	        success : function(data) {
				console.log(data);
	        }
	      });
	});
	/*carouser*/
					
					
/*toggle mobile menu*/
		$('.mobMenu_toggle').click(function(){
		  $('.mainMenu').slideToggle();
		});


	$(".tabs-menu a").click(function(event) {
        event.preventDefault();
        $(this).parent().addClass("current");
        $(this).parent().siblings().removeClass("current");
        var tab = $(this).attr("href");
        $(".tab-content").not(tab).css("display", "none");
        $(tab).fadeIn();
    });

$(window).scroll(function(){$(this).scrollTop()>100?$(".scrollup").fadeIn():$(".scrollup").fadeOut()}),$(".scrollup").click(function(){return $("html, body").animate({scrollTop:0},600),!1})
$(window).on('load resize', function(){  
   
	setTimeout(function(){
		$('.blog_sec .same_height').sameheight();
		   $('.news_sec .same_height').sameheight();
		   $('.testimonial_sec .same_height').sameheight();
		   $('.portfolio.info.same_height').sameheight();
		   $('.equ-height.info.same_height').sameheight();
		   $('.product_page .info.same_height').sameheight();
		   $('.current_opning .events_box.same_height').sameheight();
	}, 500);

});
/*	$('.same_height_2').sameheight();
	$('.same_height_3').sameheight();*/
});

function updateUserInfo(){
	var formData= $("#updateForm").searializeObject();
	
}
function loadDefaultImage(obj){
	obj.src=$("#baseUrl").val()+"/static/images/user-default.png";
}


$(".contac_us_map iframe").attr("src", "https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3508.1066922049285!2d77.04326100000004!3d28.446199999999997!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x390d18429e8907e7%3A0x91f255d294730c0b!2sDew+Solutions+Private+Limited!5e0!3m2!1sen!2sin!4v1402202937655");