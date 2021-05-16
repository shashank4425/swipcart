<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="header.jsp"></jsp:include>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<link href="css/common.css" rel="stylesheet">
<link href="css/media.css" rel="stylesheet">
<link href="css/smartphone.css" rel="stylesheet">

<link href="/css/magnify.css" rel="stylesheet" type="text/css" media="screen"/>
<script src="/js/jquery.magnify.js" type="text/javascript"></script>
<meta charset="ISO-8859-1">

</head>
<body>
<div class="container">
 <div id="productDetails">
 <div id="sele_trend_prod">
 </div>
 <div class="star-rating-v2 section">
                    <div class="rating-div mb10">
                    <input type="hidden" name="pdid" value="112200"/>
                        <h4 id="pre-rating">
                            <b>
                                <span class="blue-title-unique">Leave a Rating!</span>
                            </b>
                        </h4>
                        <span class="my-rating-9"></span>
                        <div class="live-rating">
                            <span class="rating">4.1</span>
                            <span>
                                <span class="votes">(0 votes)</span>
                            </span>
                        </div>
                    </div>
                </div>
  </div>
  </div>
<script type="text/javascript" src="/js/smartphone.js"></script>
<script type="text/javascript" src="/js/common.js"></script>

<script type="text/javascript" src="/library/jquery.star-rating-svg.js"></script>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>