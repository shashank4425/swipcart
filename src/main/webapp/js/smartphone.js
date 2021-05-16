var path=location.search;
var prodId=path.split("=");
var rateAvg;
$(document).ready(function(){
	
	var i=0;
	var url=path.split("?")
	$.ajax({
	      type: "GET",
           url: url[1],
           data: {},
           success: function (response) {
          	 $("#sw-prod_li").empty();
          	document.title=response.product_Detail[i].prodTitle;
          	 for(i=0;i<response.product_Detail.length;i++){
                   $("#sele_trend_prod").append('<div class="left-sec"><div class="prod_img"><img id="prodimg" class="zoom" src='+response.product_Detail[i].prodPath+' /></div><ul class="row_btn"><button type="button" id="add_to_cart">Add to Cart</button><button type="button" id="buy-now-btn">Buy Now</button></ul></div><div class="pord_spec"><p id="prodTitle">'
                           +response.product_Detail[i].prodTitle+'</p><hr><li class="SPEC">'+response.product_Detail[i].prodCamara+'</li><li class="SPEC">'
                           +response.product_Detail[i].prodBattery+'</li><div id="priceTga"><li id="POfFP_spec" class="SPEC"><i class="rupee">&#8377;</i> '+response.product_Detail[i].prodOfferPrice+'</li><li id="PPVP_spec" class="SPEC"><i class="rupee">&#8377;</i> '
                           +response.product_Detail[i].prodPrevPrice+'</li></div><li class="SPEC">'+response.product_Detail[i].prodRam+'</li><li class="SPEC">'
                           +response.product_Detail[i].prodRom+'</li><li class="SPEC">'+response.product_Detail[i].prodDisplaySize+'</li><li class="SPEC">'+response.product_Detail[i].prodColor+'</li></div>')
                          
          	 }
          	 if(response.user_sess==null){
             	$('.user-reg').show();
             	$('.log-btn').show();
             	
             }
             else{
             	$('.log-btn').hide();
             	$('.logout-btn').show();
             }
           },
           error: function (e) {
               console.log("Error Occurred ");
           },
       });
	
	 $.ajax({
	     url: "api-get-rating",
         method: "GET",
	     data: {"id" :prodId[1]},
	     success: function (response) {
             if(response!=null){
                rateAvg=response.ratingAvg;
                $('.live-rating .rating').text(response.rateVal);
                $('.live-rating .votes').text('(' +response.noOfVotes+ ' votes)');
               $(function() {
                   $(".my-rating-9").starRating({
                       initialRating: rateAvg,
                       starSize: 25,
                       disableAfterRate: true,
                       onHover: function(currentIndex, currentRating, $el) {
                           console.log('index: ', currentIndex, 'currentRating: ', currentRating, ' DOM element ', $el);
                           $('.live-rating .rating').text(currentIndex);
                           RatingPoint=currentIndex;
                       },
                       onLeave: function(currentIndex, currentRating, $el) {
                           //console.log('index: ', currentIndex, 'currentRating: ', currentRating, ' DOM element ', $el);
                           $('.live-rating .rating').text(currentRating);
                       },
                       callback: function(currentRating){
                          
                        var formData=new FormData();
                        formData.append("rateVal",RatingPoint);
                        formData.append("id",prodId[1]);
                        formData.append("pageURL",location.href) ;
                        $.ajax({
                               url: "api-save-rating",
                               async: true,
                               method: "POST",
                               processData: false,
                               contentType: false,
                               mimeType: "multipart/form-data",
                               data: formData,
                               success: function (response) {
                               },
                               error: function (e) {
                                   console.log("Error Occurred ");
                               },
                           });
                        $('#pre-rating span').text('Thanks for Rating!');  
                    }
                      
                   });
                  });
             }
             else{
                $('.live-rating .rating').text(response.rateVal);
                $('.live-rating .votes').text('(' +response.noOfVotes+ ' votes)');
                var RatingPoint;
                $(function() {
                  $(".my-rating-9").starRating({
                      initialRating: rateAvg,
                      starSize: 25,
                      disableAfterRate: true,
                      onHover: function(currentIndex, currentRating, $el) {
                          console.log('index: ', currentIndex, 'currentRating: ', currentRating, ' DOM element ', $el);
                          $('.live-rating .rating').text(response.rateVal);
                          RatingPoint=currentIndex;
                      },
                      onLeave: function(currentIndex, currentRating, $el) {
                          //console.log('index: ', currentIndex, 'currentRating: ', currentRating, ' DOM element ', $el);
                          $('.live-rating .rating').text(response.rateVal);
                      },
                      callback: function(currentRating){
                          
                          var formData=new FormData();
                          formData.append("rateVal",RatingPoint);
                          formData.append("id",prodId[1]);
                          formData.append("pageURL",location.href) ;
                          $.ajax({
                                 url: "api-save-rating",
                                 async: true,
                                 method: "POST",
                                 processData: false,
                                 contentType: false,
                                 mimeType: "multipart/form-data",
                                 data: formData,
                                 success: function (response) {
                                 },
                                 error: function (e) {
                                     console.log("Error Occurred ");
                                 },
                             });
                          $('#pre-rating span').text('Thanks for Rating!');  
                      }
                  });
                 });
             
         }
        },
	     error: function (e) {
             
         }
	 });
     
})
