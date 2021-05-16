<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<jsp:include page="header.jsp"></jsp:include>
<link href="css/common.css" rel="stylesheet">
<link href="css/profile.css" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container">
 <section class="USP-SEC">
  <div class="prof_det">
    <div id="info-sec">
     <div class="fn-sec">
     <div class="lab-sec"><label>First Name</label></div>
      <input type="text" name="fistname" placeholder="enter first name" data-validation="required,validAlpha"/>
     </div>
     <div class="fn-sec">
      <div class="lab-sec"><label>Last Name</label></div>
      <input type="text" name="lastname" placeholder="enter first name" data-validation="required,validAlpha"/>
     </div>
     <div class="fn-sec">
      <div class="lab-sec"><label>Registerd Email Id</label></div>
      <input type="text" name="emailid" placeholder="Email Id" data-validation="required,validEmail"/>
     </div>
     <div class="fn-sec">
      <div class="lab-sec"><label>Mobile Number</label></div>
      <input type="text" name="mobnum" placeholder="Mobile number" data-validation="required,validMobile"/>
     </div>
     <div class="fn-sec">
      <div class="lab-sec"><label>First Line Address</label></div>
      <input type="text" name="fladdress" placeholder="first Line name"/>
     </div>
     <div class="fn-sec">
      <div class="lab-sec"><label>Last Line Address</label></div>
      <input type="text" name="lladdress" placeholder="Last Line name"/>
     </div>
     <div class="btn-sec">
     <button type="submit" class="update-btn">Update Profile</button>
     </div>
    </div>
  </div>
 </section>
</div>
<script type="text/javascript" src="/js/common.js"></script>
<script type="text/javascript" src="/js/profile.js"></script>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>