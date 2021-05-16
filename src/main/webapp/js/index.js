$(document).ready(function () {

    /*     
      $('.owl-carousel').owlCarousel({
          loop: true,
          margin: 10,
          nav: true,
          responsive: {
              0: {
                  items: 1
              },
              600: {
                  items: 3
              },
              1000: {
                  items: 5
              }
          }
      });
      */
	
      
    /*  $.ajax({
            type: "GET",
           url: "/ProductStore/getTrendlist",
           data: {},
           success: function (response) {
  
               $("#sw-prod_li").empty();
              
                      for(j=0;j<response.electronic.products.length;j++){
                          for(k=0;k<response.electronic.products[j][0].tabs[0].columns.length;k++){
                          if(j>0){
                             $("#productDetails .electronic").append('<ul class="electronic-product-list-items"><a href='+response.electronic.products[j][0].tabs[0].columns[k].url+' target="_blank"><div class="prod_img_elc"><img src='+response.electronic.products[j][0].tabs[0].columns[k].prodPath+'/></div><li id="PT_spec">'+response.electronic.products[j][0].tabs[0].columns[k].title+'</li></a></ul>');
                          }else{
                             $("#productDetails .electronics").append('<ul class="electronic-product-list-items"><a href='+response.electronic.products[j][0].tabs[0].columns[k].url+' target="_blank"><div class="prod_img_elc"><img src='+response.electronic.products[j][0].tabs[0].columns[k].prodPath+'/></div><li id="PT_spec">'+response.electronic.products[j][0].tabs[0].columns[k].title+'</li></a></ul>');
                            }
                       }
                   }
                   
               slick_slider_Init();
        },
           error: function (e) {
               console.log("Error Occurred ");
           },
       });
      
  */
        $('.responsive').slick({
          dots: false,
          infinite: false,
          speed: 300,
          slidesToShow: 5,
          slidesToScroll: 1,
          responsive: [
            {
              breakpoint: 1024,
              settings: {
                slidesToShow: 3,
                slidesToScroll:3,
                infinite: true,
                dots: false
              }
            },
            {
              breakpoint: 600,
              settings: {
                slidesToShow: 2,
                slidesToScroll: 2
              }
            },
            {
              breakpoint: 480,
              settings: {
                slidesToShow: 1,
                slidesToScroll: 1
              }
            }
            // You can unslick at a given breakpoint now by adding:
            // settings: "unslick"
            // instead of a settings object
          ]
        });
        });
  