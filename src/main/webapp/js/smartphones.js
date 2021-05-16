$(document).ready(function(){
	var path=location.search;
	var i=0;
	var url=path.split("?")
	$.ajax({
	      type: "GET",
           url: url[1],
           data: {},
           success: function (response) {

          	 $("#sw-prod_li").empty();
          	$("#total_prod").append('Best Selling Phones <p>'+response.trendingProducts.length+' Items</p>');
          	 for(i=0;i<response.trendingProducts.length;i++){
                   $("#sw-prod_li").append('<ul class="prod_path product-list-items"><a href=' + response.trendingProducts[i].prodUri + ' target="_blank"><div class="products"><div class="prod_img"><img class="lazy" src='+response.trendingProducts[i].prodPath+'/></div><section class="heading"><div class="top_Sec"><div class="pricehead"><p id="prodTitle">'+response.trendingProducts[i].prodTitle+'</p></div><div class="priceTagsec"><li id="POfFP_spec"><i class="rupee">&#8377;</i> '
                   +response.trendingProducts[i].prodOfferPrice+'</li></div></div><div class="pord_spec"><li id="PC_spec">'+response.trendingProducts[i].prodCamara+'</li><li id="PC_spec">'+response.trendingProducts[i].prodBattery+'</li><li id="PC_spec">'
                   +response.trendingProducts[i].prodRam+'</li><li id="PC_spec">'+response.trendingProducts[i].prodRom+'</li></div></section></div></a></ul>')
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
	$('#left-list-items input[type=checkbox]').eq(0).prop('checked',true)

});
$('#left-list-items input[type=checkbox]').on('click',function(){ 
	$('#left-list-items input[type=checkbox]').prop('checked',false)
   $(this).prop('checked',true);
   var prodName=$(this).val();
   if(prodName!='5010'){
    $.ajax({
        type: "GET",
         url: "api-brand-prod-name="+prodName,
         data: {},
         success: function (response) {

             $("#sw-prod_li").empty();
             $("#total_prod p").text(response.trendingProduct.length+' Items');
             for(i=0;i<response.trendingProduct.length;i++){
                 $("#sw-prod_li").append('<ul class="prod_path product-list-items"><a href=' + response.trendingProduct[i].prodUri + ' target="_blank"><div class="products"><div class="prod_img"><img class="lazy" src='+response.trendingProduct[i].prodPath+'/></div><section class="heading"><div class="top_Sec"><div class="pricehead"><p id="prodTitle">'
                 +response.trendingProduct[i].prodTitle+'</p></div><div class="priceTagsec"><li id="POfFP_spec"><i class="rupee">&#8377;</i> '+response.trendingProduct[i].prodOfferPrice+'</li></div></div><div class="pord_spec"><li id="PC_spec">'+response.trendingProduct[i].prodCamara+'</li><li id="PC_spec">'
                 +response.trendingProduct[i].prodBattery+'</li><li id="PC_spec">'+response.trendingProduct[i].prodRam+'</li><li id="PC_spec">'+response.trendingProduct[i].prodRom+'</li></div></div></section></div></a></ul>')
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
    }
    else{
    	location.reload();
    }
	})
	
	$(".prod_search_field").on("keyup", function (e) {
    e.preventDefault();
       var query = $(".prod_search_field").val().toLowerCase();
   
       $(".product-list-items").hide();
       $(".product-list-items").each(function() {
           var title = $(this).find('#prodTitle').text().toLowerCase();
           
           if (title.indexOf(query) > -1) {
               $(this).show();
           }
       });
    })
