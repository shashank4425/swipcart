var validAlpha = /^[a-zA-Z ]*$/;
    var validNumeric = /^[0-9]+$/;
    var validMobile = /^[6-9]\d{9}$/;
    var validEmail = /^([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
$("#reg_link").click(function(){
  $('.user-auth-tag').css('display','none');
  $('#left-brand-des #log-tag').text("Looks like you're new here!");
  $('#left-brand-des #title-tag').text("Sign up with your email id to get started");
  $('.user-auth-tag-on').css('display','block');
  })
  $("#log_link").click(function(){ 
  $('.user-auth-tag-on').css('display','none');
  $('#left-brand-des #log-tag').text("Login");
  $('#left-brand-des #title-tag').text("Get Access To your orders, and many more");
  $('.user-auth-tag').css('display','block');
  })
  var emailId="",Password="",confirmPassword="";
  $('.signup-btn').on('click',function(){
    emailId=$('.user-auth-tag-on input[name=emailId]').val(); 
    Password=$('.user-auth-tag-on input[name=password]').val(); 
    confirmPassword=$('.user-auth-tag-on input[name=confirmpassword]').val();
  if(emailId=='' || validEmail.test(emailId)==false){
       $('.user-auth-tag-on .emailerror').show();
     }
  if(Password=='' || Password.length >5 ){
       $('.user-auth-tag-on .passerror').show();
     }
  if(confirmPassword=='' || confirmPassword.length>5){
       $('.user-auth-tag-on .cpasserror').show();
       }	
  if(validEmail.test(emailId)==true){
	  $('.user-auth-tag-on .emailerror').hide();
  }
 if(Password.length >5){
	 $('.user-auth-tag-on .passerror').hide();
  }
 if(confirmPassword.length>5){
	 $('.user-auth-tag-on .cpasserror').hide(); 
 }
  if(Password== confirmPassword &&  Password.length >5 && confirmPassword.length>5 && validEmail.test(emailId)==true){
    $('.emailerror').hide();$('.passerror').hide(); $('.cpasserror').hide();
    $.ajax({
         type: "POST",
         url: "/api-user_reg",
         data: {"emailId":emailId,"password":Password,"confirmpassword":confirmPassword},
         success: function (response) {
          $('.user-auth-tag-on').hide();
          $('#right-sec-login').append('<div class="user-auth-tag-otp-on"><div class="resMess"><p id="mess">'+response.resMess+'</p><div class="otpfield"><input type="text" name="otp" placeholder="Enter OTP"></div><div class="signup_form_btn"><button type="submit" class="varify-btn">Verify OTP</button></div></div></div>')
         },
         error: function (e) {
             console.log("Error Occurred ");
         },
     });
    }
  });
 $(document).on('click','.varify-btn',function(){
   var otp=$('.user-auth-tag-otp-on input[name=otp]').val(); 
    $.ajax({
     type: "POST",
     url: "/api-varification_user_auth",
     data: {"emailId":emailId,"password":Password,"confirmpassword":confirmPassword,"otp":otp},
      success: function (response) {
    	  if(response.resCode=='1'){
    		if($('.Otperror').length==0){
    		  $("<p class='Otperror'>"+response.resMess+"</p>").insertBefore('.signup_form_btn');
    	   }
          }
    	  else{
           location.href="/";
    	  }
        //  $(".BrandName #prodName").text("All Brands | " +response.trendingProducts.length+ " Produts ")
    },
    error: function (e) {
        console.log("Error Occurred ");
    },
});
});
  $('.user-auth-tag .login-btn').on('click',function(){ 
  emailId=$('.user-auth-tag input[name=emailId]').val(); 
    Password=$('.user-auth-tag input[name=Password]').val(); 
  if(emailId=='' || validEmail.test(emailId)==false){
      $('.user-auth-tag .emailerror').show();
    }
 if(Password=='' || Password.length >5 ){
      $('.user-auth-tag .passerror').show();
    }
 if(validEmail.test(emailId)==true){
	  $('.user-auth-tag .emailerror').hide();
 }
if(Password.length >5){
	 $('.user-auth-tag .passerror').hide();
 }
 if(Password!='' && Password.length >5 && validEmail.test(emailId)==true){
    $.ajax({
         type: "POST",
         url: "/api-user_logauth",
         data: {"emailId":emailId,"Password":Password},
         success: function (response) {
           if(response.resCode=='1'){
             if($('.auth-error').length==0){
             $("<span class='auth-error'>"+response.errMess+"</span>").insertBefore($(".login_form_btn"));
             }
           }
           else{
            location.href="/";
           }
             //  $(".BrandName #prodName").text("All Brands | " +response.trendingProducts.length+ " Produts ")
           
         },
         error: function (e) {
             console.log("Error Occurred ");
         },
     });
  }
});