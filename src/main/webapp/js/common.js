 
$(document).ready(function(){
	$.ajax({
   type: "GET",
   url: "/user-authorisation",
   data: {},
   success: function (response) {
    if(response.sessionId==null){
    	$('#right-sec').append('<div class="ac-btn"><a href="/user-auth" class="log-btn" name="login">Login</a></div>');
    }else{
        $('#right-sec').append('<div class="ac-btn"><button class="dropbtn">Dropdown <i class="fa fa-caret-down"></i></button><div class="dropdown-content"><div class="arr"></div><a href="/profile?user-profile-authentication='+response.sessionId+'">My Profile</a><a href="/orders">View Orders</a><a href="/logout_auth">Log Out</a></div></div><div class="cart-sec"><i class="fa fa-shopping-cart"></i><span>Cart</span></div>');
    }
   },
   error: function (e) {
       console.log("Error Occurred ");
   },
});
})

$(window).scroll(function () {
         if ($(this).scrollTop() > 200) {
            $('.scrollToTop').fadeIn();
         } else {
            $('.scrollToTop').fadeOut();
         }
      });
      //Click event to scroll to top
      $('.scrollToTop').click(function () {
         $('html, body').animate({ scrollTop: 0 }, 800);
         return false;
      });
      $(window).scroll(function () {
          var sticky = $('.header-secondary'), scroll = $(window).scrollTop();
          if (scroll >= 100) {
             sticky.addClass('fixed');
          }
          else {
             sticky.removeClass('fixed');
          }
       });     