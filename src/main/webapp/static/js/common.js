$(document).ready(function(){
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

$(".contac_us_map iframe").attr("src", "https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3508.1066922049285!2d77.04326100000004!3d28.446199999999997!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x390d18429e8907e7%3A0x91f255d294730c0b!2sDew+Solutions+Private+Limited!5e0!3m2!1sen!2sin!4v1402202937655");