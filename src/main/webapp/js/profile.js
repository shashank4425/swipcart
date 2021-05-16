var validAlpha = /^[a-zA-Z ]*$/;
    var validNumeric = /^[0-9]+$/;
    var validMobile = /^[6-9]\d{9}$/;
    var validEmail = /^([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
$(document).ready(function(){
    var path=location.search;
	var i=0;
	var url=path.split("?")
    $.ajax({
              type: "GET",
               url: url[1],
               data: {},
               success: function (response) {
            	   $('.fn-sec [name="firstname"]').val(response.details.firstname);
            	   $('.fn-sec [name="lastname"]').val(response.details.lastname);
            	   $('.fn-sec [name="emailid"]').val(response.details.emailId).attr('disabled','disabled');
            	   $('.fn-sec [name="mobnum"]').val(response.details.mobNumber);
            	   $('.fn-sec [name="fladdress"]').val(response.details.firstLineAddress);
            	   $('.fn-sec [name="lladdress"]').val(response.details.lastLineAddress);
            	  
               },
               error: function (e) {
                   console.log("Error Occurred ");
               },
           });
    });