<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<jsp:include page="user-auth-header.jsp"></jsp:include>
<link href="css/common.css" rel="stylesheet">
<link href="css/login.css" rel="stylesheet">
</head>
<body>
<section>
<div class="user-reg">
            <div id="left-brand-des">
                <h2 id="feature-tag"><span id="log-tag">Login</span><span id="title-tag">Get Access To your orders, and
                        many more</span></h2>
            </div>
            <div id="right-sec-login">
             
                <div class="user-auth-tag">
                    <input type="email" name="emailId" placeholder="Email Id" data-validation="required,validEmail">
                    <span class="emailerror">Enter Email Id</span>
                    <input type="password" name="Password" placeholder="Password">
                    <span class="passerror">Enter password</span>
                    <div class="login_form_btn"><button type="submit" class="login-btn">Login</button></div>
                    <p id="reg_link">New to SwipCard? Create an account</p>
                </div>
                
                <div class="user-auth-tag-on">
                    <input type="email" name="emailId" placeholder="Email Id" data-validation="required,validEmail">
                    <span class="emailerror">Enter Email Id</span>
                    <input type="password" name="password" placeholder="Password">
                    <span class="passerror">Enter password</span>
                    <input type="password" name="confirmpassword" placeholder="Confirm Password">
                    <span class="cpasserror">Enter confirm password</span>
                    <div class="signup_form_btn"><button type="submit" class="signup-btn">Sign up</button></div>
                    <p id="log_link">Already have an account?</p>
                </div>
             
            </div>
        </div>
        </section>
        <script type="text/javascript" src="/js/user-auth.js"></script>
        <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>