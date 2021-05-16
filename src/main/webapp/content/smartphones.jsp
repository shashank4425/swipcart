<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   
<!DOCTYPE html>
<html>
<head>
<jsp:include page="header.jsp"></jsp:include>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<link href="css/common.css" rel="stylesheet">
<link href="css/smartphones.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"/>
<meta charset="ISO-8859-1">
<title>Swipe Cart Products</title>
</head>
<body>
<div class="container">
 <div id="productDetails">
 <h1 id="total_prod"></h1>
 <div class="all_pd_list">
  <div class="find_pd_byname"><p id="ftitle">Find Your Products By Individual</p><hr>
   <div class="left-sec-item">
    <li id="left-list-items"> <input type="checkbox" name="5010" value="5010"><span id="list_name">All</span></li>
    <li id="left-list-items"> <input type="checkbox" name="Samsung" value="Samsung"><span id="list_name">SAMSUNG</span></li>
    <li id="left-list-items"> <input type="checkbox" name="Vivo" value="Vivo"><span id="list_name">VIVO</span></li>
    <li id="left-list-items"> <input type="checkbox" name="Xiaomi" value="Xiaomi"><span id="list_name">REDMI</span></li>
    <li id="left-list-items"> <input type="checkbox" name="Oppo" value="Oppo"><span id="list_name">APPLE</span></li>
    <li id="left-list-items"> <input type="checkbox" name="Xiaomi" value="Xiaomi"><span id="list_name">MI</span></li>
    <li id="left-list-items"> <input type="checkbox" name="Oppo" value="Oppo"><span id="list_name">OPPO</span></li>
    </div><hr>
  </div>
  </div>
  <div id="right-sw-prod_li"><div class="search_field"><input type="text" class="prod_search_field" placeholder="search.."/></div><div id="sw-prod_li"></div></div>
  </div>
  </div>
 
<script type="text/javascript" src="/js/smartphones.js"></script>
<script type="text/javascript" src="/js/common.js"></script>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>