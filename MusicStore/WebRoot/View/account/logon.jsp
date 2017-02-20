<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
    <title>MusicStore</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="/MusicStore/Css/Site.css">
	<script src="/MusicStore/Scripts/jquery-1.10.2.min.js" type="text/javascript"></script>
    <script src="/MusicStore/Scripts/modernizr-2.6.2.js" type="text/javascript"></script>
  </head>
  
  <body>
    <jsp:include page="../header.jsp" />
  
    <div id="main">
		<h2>Log On</h2>
		<p>
		    Please enter your user name and password. 
		    <a href="/MusicStore/Account/Register">Register</a> if you don't have an account.
		</p>
		<form name='f' action='/MusicStore/j_spring_security_check' method='POST'>
			 <div>
		        <fieldset>
		            <legend>Account Information</legend>
		            <div class="editor-label">UserName:</div>
		            <div class="editor-field">
		                <input type='text' name='j_username' value=''/>
		            </div>
		
		            <div class="editor-label">Password:</div>
		            <div class="editor-field">
		               <input type='password' name='j_password'/>
		            </div>
		            <p>
		                <input name="submit" type="submit" value="Login"/>
		            </p>
		        </fieldset>
    		</div>
		</form>
    </div>
   
    <jsp:include page="../footer.jsp"/>
  </body>
</html>
