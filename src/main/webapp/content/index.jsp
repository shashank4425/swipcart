<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <jsp:include page="header.jsp"></jsp:include>
    <link href="css/common.css" rel="stylesheet">
    <link href="css/index.css" rel="stylesheet">
    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <link rel="stylesheet" href="css/owl.theme.default.min.css">

    <link rel="stylesheet" href="css/slick.css">
    <link rel="stylesheet" href="css/slick-theme.css">

    <script src="js/jquery.min.js"></script>
    <script src="js/owl.carousel.min.js"></script>
    <meta charset="ISO-8859-1">
    <title>Swipe Cart Products</title>
</head>

<body>
    <div class="container">
       <div id="productDetails">
        <div id="sw-prod_li_hp">
         <div class="product_desc">
                    <h1>Latest in Audio & Laptop</h1>
                    <div class="view_all_pd"><a href="products?All_brand_products_id=4010" target="_blank">View All</a></div>
                </div>
           <div class="electronics responsive">
            <ul class="electronic-product-list-items">
            <a href="/accessories?attr_brand_new_id=225" target="_blank" tabindex="0"><div class="prod_img_elc">
                <img data-lazy="http://localhost:8081/content/resource/103-wireless-boat-original.jpeg/"></div>
                <li id="PT_spec">BOAT</li>
                <li id="POfFP_spec"><i class="rupee">&#8377;</i> 7,49</li>
            </a>
            </ul>
            <ul class="electronic-product-list-items">
                <a href="/accessories?attr_brand_new_id=230" target="_blank" tabindex="0">
                    <div class="prod_img_elc">
                    <img data-lazy="http://localhost:8081/content/resource/boat-rockerz-400-extra-bass-headp.jpeg/"></div>
                    <li id="PT_spec">BOAT</li>
                    <li id="POfFP_spec"><i class="rupee">&#8377;</i> 7,49</li>
                </a>
            </ul>
            <ul class="electronic-product-list-items">
            <a href="/accessories?attr_brand_new_id=228" target="_blank" tabindex="0"><div class="prod_img_elc">
                <img data-lazy="http://localhost:8081/content/resource/boat-225-with-carrying-case-original.jpeg/"></div>
                <li id="PT_spec">BOAT</li>
                <li id="POfFP_spec"><i class="rupee">&#8377;</i> 4,69</li>
            </a>
            </ul>
            <ul class="electronic-product-list-items">
            <a href="/accessories?attr_brand_new_id=226" target="_blank" tabindex="0"><div class="prod_img_elc">
                <img data-lazy="http://localhost:8081/content/resource/235-fast-charging-boat-original.jpeg/"></div>
                <li id="PT_spec">BOAT</li>
                <li id="POfFP_spec"><i class="rupee">&#8377;</i> 8,99</li>
            </a>
            </ul>
            <ul class="electronic-product-list-items">
            <a href="/accessories?attr_brand_new_id=233" target="_blank" tabindex="0"><div class="prod_img_elc">
                <img data-lazy="http://localhost:8081/content/resource/rockerz-335-boat-original-red.jpeg/"></div>
                <li id="PT_spec">BOAT</li>
                <li id="POfFP_spec"><i class="rupee">&#8377;</i> 4,99</li>
            </a>
            </ul>
            <ul class="electronic-product-list-items">
            <a href="/accessories?attr_brand_new_id=235" target="_blank" tabindex="0"><div class="prod_img_elc">
                <img data-lazy="http://localhost:8081/content/resource/rockerz-450-boat-original-headp.jpeg/"></div>
                <li id="PT_spec">BOAT</li>
                <li id="POfFP_spec"><i class="rupee">&#8377;</i> 6,90</li>
            </a>
            </ul>
           </div>      
          </div>
         </div>
            <div id="sw-prod_li">
                <div class="product_desc">
                    <h1>Best in Mobile Phones</h1>
                    <div class="view_all_pd"><a href="smartphones?brand_products_id=5010" target="_blank">View All</a></div>
                </div>
                <section class="sec-list-product">
                    <div class="headphones responsive">
                        <div class="hp-list-items">
                            <div class="list-items-secondary"><a href="http://localhost:8081/smartphone?brand_new_id=612"
                                    target="_blank">
                                    <div class="prod_img"><img
                                            data-lazy="http://localhost:8081/content/resource/vivo-y91i-16gb-ocean-blue-2gb.jpg/">
                                    </div>
                                    <div id="tr_prod_spec">
                                        <li id="PT_spec">Y91i 16 GB Blue</li>
                                        <li id="POfFP_spec"><i class="rupee">&#8377;</i> 8,000</li>
                                        <li id="PC_spec">13MP Rear Camera</li>
                                    </div>
                                </a>
                            </div>
                        </div>
                        <div class="hp-list-items">
                            <div class="list-items-secondary"><a href="http://localhost:8081/smartphone?brand_new_id=513"
                                    target="_blank">
                                    <div class="prod_img"><img
                                            data-lazy="http://localhost:8081/content/resource/samsung-galexy-m01-red.png/">
                                    </div>
                                    <div id="tr_prod_spec">
                                        <li id="PT_spec">Galexy M01 Red</li>
                                        <li id="POfFP_spec"><i class="rupee">&#8377;</i> 9,999</li>
                                        <li id="PC_spec">13MP + 2MP Rear Camera</li>
                                    </div>
                                </a></div>
                        </div>
                        <div class="hp-list-items">
                            <div class="list-items-secondary"><a href="http://localhost:8081/smartphone?brand_new_id=615"
                                    target="_blank">
                                    <div class="prod_img"><img
                                            data-lazy="http://localhost:8081/content/resource/vivo-v11-starrynight-black-6gb.jpg/">
                                    </div>
                                    <div id="tr_prod_spec">
                                        <li id="PT_spec">V11 64 GB Black</li>
                                        <li id="POfFP_spec"><i class="rupee">&#8377;</i> 19,990</li>
                                        <li id="PC_spec">16 MP + 5 MP Rear Camera</li>
                                    </div>
                                </a></div>
                        </div>
                        <div class="hp-list-items">
                            <div class="list-items-secondary"><a href="http://localhost:8081/smartphone?brand_new_id=613"
                                    target="_blank">
                                    <div class="prod_img"><img
                                            data-lazy="http://localhost:8081/content/resource/vivo-y91i-32gb-ocean-blue-2gb.jpg/">
                                    </div>
                                    <div id="tr_prod_spec">
                                        <li id="PT_spec">Y91i 32 GB Fusion</li>
                                        <li id="POfFP_spec"><i class="rupee">&#8377;</i> 9,290</li>
                                        <li id="PC_spec">13MP Rear Camera</li>
                                    </div>
                                </a></div>
                        </div>
                             <div class="hp-list-items">
                            <div class="list-items-secondary"><a href="http://localhost:8081/smartphone?brand_new_id=612"
                                    target="_blank">
                                    <div class="prod_img"><img
                                            data-lazy="http://localhost:8081/content/resource/vivo-y91i-16gb-ocean-blue-2gb.jpg/">
                                    </div>
                                    <div id="tr_prod_spec">
                                        <li id="PT_spec">Y91i 16 GB Blue</li>
                                        <li id="POfFP_spec"><i class="rupee">&#8377;</i> 8,000</li>
                                        <li id="PC_spec">13MP Rear Camera</li>
                                    </div>
                                </a>
                            </div>
                        </div>
                        <div class="hp-list-items">
                            <div class="list-items-secondary"><a href="http://localhost:8081/smartphone?brand_new_id=514" target="_blank">
                                <div class="prod_img"><img data-lazy="http://localhost:8081/content/resource/samsung-galexy-m11-voilet.png/">
                                </div>
                                <div id="tr_prod_spec">
                                    <li id="PT_spec">Galexy M11 Voilet</li>
                                    <li id="POfFP_spec"><i class="rupee">&#8377;</i> 11,600</li>
                                    <li id="PC_spec">13MP + 8MP + 5MP + 2MP Rear Camera</li>
                                </div>
                            </a></div>
                        </div>
                    </div>
                </section>
            </div>
        </div>
    </div>
    <script type="text/javascript" src="/js/slick.min.js"></script>
    <script type="text/javascript" src="/js/index.js"></script>
    <script type="text/javascript" src="/js/common.js"></script>
    <jsp:include page="footer.jsp"></jsp:include>
</body>

</html>