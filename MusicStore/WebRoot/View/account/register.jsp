<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>   
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
     <%@ include file="../header.jsp" @%>
    <div id="main">
		<h2>Create a New Account</h2>
		<p>Use the form below to create a new account. </p>
		<form:form action="/MusicStore/Account/Register" method="POST" modelAttribute="registerViewModel">
			 <div>
		        <fieldset>
		           <legend>Account Information</legend>
		            <div class="editor-label">UserName:</div>
		            <div class="editor-field">
		                <input type='text' path='Name'/>
		            </div>
		
		            <div class="editor-label">Password:</div>
		            <div class="editor-field">
		               <input type='password' path='Password'/>
		            </div>
		            <p>
		                <input name="submit" type="submit" value=Register/>
		            </p>
		        </fieldset>
		    </div>
		</form:form>
    </div>
     <%@ include file="../footer.jsp" @%>
  </body>
</html>
