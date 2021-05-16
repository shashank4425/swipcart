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
          	$("#total_prod").append('Best Selling Products <p>'+response.electronic.countItem+' Items</p>');
          	for(i=0;i<response.electronic.products.length;i++){
                for(j=0;j<response.electronic.products[i][0].tabs[0].columns.length;j++){
                $("#sw-prod_li").append('<ul class="prod_path product-list-items"><a href=' + response.electronic.products[i][0].tabs[0].columns[j].url + ' target="_blank"><div class="products-elec"><div class="prod_img_list"><img class="lazy" src='
                +response.electronic.products[i][0].tabs[0].columns[j].prodPath+'/></div><section class="heading"><div class="pricehead"><p id="prodTitle">'+response.electronic.products[i][0].tabs[0].columns[j].title+'</p></div><div class="priceTagsec"><li id="POfFP_spec"><i class="rupee">&#8377;</i> '+response.electronic.products[i][0].tabs[0].columns[j].prodOfferPrice+'</li></div><div class="pord_spec"><li class="SPEC">'+response.electronic.products[i][0].tabs[0].columns[j].color+'</li></div></section></div></a></ul>')
            }
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
   var name=$(this).val();
   if(name!='4010'){
    $.ajax({
        type: "GET",
         url: "api-brand-elec-name="+name,
         data: {},
         success: function (response) {

             $("#sw-prod_li").empty();
             $("#total_prod p").text(response.length+' Items');
             for(i=0;i<response.length;i++){
                    $("#sw-prod_li").append('<ul class="prod_path product-list-items"><a href=' + response[i].url + ' target="_blank"><div class="products-elec"><div class="prod_img_list"><img class="lazy" src='
                    +response[i].prodPath+'/></div><section class="heading"><div class="pricehead"><p id="prodTitle">'+response[i].title+'</p></div><div id="priceTagsec"><li id="POfFP_spec"><i class="rupee">&#8377;</i> '+response[i].prodOfferPrice+'</li></div><div class="pord_spec"><li class="SPEC">'+response[i].color+'</li></div></section></div></a></ul>')
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
