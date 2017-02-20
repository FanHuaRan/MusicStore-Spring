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
     <%@ include file="../header.jsp" %>
    <div id="promotion">
	</div>
	<div id="main">
		<form:form action="/MusicStore/Checkout/AddressAndPayment"
		 modelAttribute="addressAndPaymentViewModel" method="post">
		 <fieldset>  
		  <h2>Address And Payment</h2>
          <legend>Shipping Information</legend>
        	<div class="editor-label"><label for="FirstName">First Name</label></div>
			<div class="editor-field"><form:input path="FirstName" class="text-box single-line" data-val="true"  id="FirstName" name="FirstName" type="text"/> </div>

			<div class="editor-label"><label for="LastName">Last Name</label></div>
			<div class="editor-field"><form:input path="LastName" class="text-box single-line" data-val="true" id="LastName" name="LastName" type="text"/> </div>
			
			<div class="editor-label"><label for="Address">Address</label></div>
			<div class="editor-field"><form:input path="Address"  class="text-box single-line" data-val="true"  id="Address" name="Address" type="text"/></div>
			
			<div class="editor-label"><label for="City">City</label></div>
			<div class="editor-field"><form:input path="City" class="text-box single-line" data-val="true"  id="City" name="City" type="text" /> </div>

			<div class="editor-label"><label for="State">State</label></div>
			<div class="editor-field"><form:input path="State" class="text-box single-line" data-val="true"  id="State" name="State" type="text" /> </div>

			<div class="editor-label"><label for="PostalCode">Postal Code</label></div>
			<div class="editor-field"><form:input path="PostalCode" class="text-box single-line" data-val="true"  id="PostalCode" name="PostalCode" type="text" /> </div>

			<div class="editor-label"><label for="Country">Country</label></div>
			<div class="editor-field"><form:input path="Country" class="text-box single-line" data-val="true"  id="Country" name="Country" type="text" /> </div>

			<div class="editor-label"><label for="Phone">Phone</label></div>
			<div class="editor-field"><form:input path="Phone" class="text-box single-line" data-val="true"  id="Phone" name="Phone" type="text" /></div>

			<div class="editor-label"><label for="Email">Email Address</label></div>
			<div class="editor-field"><form:input path="Email" class="text-box single-line"  id="Email" name="Email" type="email"/> </div>
   		 </fieldset>
   		 <fieldset>
	       <legend>Payment</legend>
	       <p>We're running a promotion: all music is free with the promo code: "FREE"</p>
	       <div class="editor-label">
	           <label for="Promo_Code">Promo Code</label>
	       </div>
	       <div class="editor-field">
	           <form:input path="PromoCode" id="PromoCode" name="PromoCode" type="text" value="" />
	       </div>
   		 </fieldset>
    			<input type="submit" value="Submit Order" />
 		</form:form>	
	</div>
    <%@ include file="../footer.jsp" %>
  </body>
</html>
