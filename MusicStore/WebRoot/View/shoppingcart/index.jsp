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
	<script type="text/javascript">
    $(function () {
        // Document.ready -> link up remove event handler
        $(".RemoveLink").click(function () {
            var recordDelete = $(this).attr("data-id");
            if (recordDelete != '') {
                // Perform the ajax post
                $.post("/MusicStore/api/Shopping/RemoveFromCart"
                      , { id: recordDelete }
                      , function (data) {
                          // Successful requests get here
                          // Update the page elements
                          console.log(data);
                          if (data.itemCount == 0) {
                              $('#row-' + data.deleteId).fadeOut('slow');
                          }
                          else {
                              $('#item-count-' + data.deleteId).text(data.itemCount);
                          }
                          $('#cart-total').text(data.cartTotal);
                          $('#update-message').text(data.message);
                          $('#cart-status').text('Cart (' + data.cartCount + ')');
                      });
            }
        });
    });
</script>
  </head>
  
  <body>
    <%@ include file="../header.jsp" %>
  
    <div id="main">
		<h3><em>Review</em>Your carts:</h3>
		<p class="button"><a href="/MusicStore/Checkout">Check out>></a></p>
		<div id="update-message"></div>
		<table>
		    <tr>
		        <th>Album Name</th>
		        <th>Price (each)</th>
		        <th>Quantity</th>
		        <th></th>
		    </tr>
		    <c:forEach items="${viewModel.getCartItems()}" var="item">
		    	<tr id="row-${item.getRecordId()}">
		            <td><a href="/MusicStore/Store/Details?id=${item.getAlbum().getAlbumId()}">${item.getAlbum().getTitle()}</a></td>
		            <td> ${item.getAlbum().getPrice()} </td>
		            <td id="item-count-${item.getRecordId()}">${item.getCount()}</td>
		            <td><a href="#" class="RemoveLink" data-id="${item.getRecordId()}">remove from cart</a></td>
		        </tr>
		    </c:forEach>
		    <tr>
		        <td>Total</td>
		        <td id="cart-total">${viewModel.getCartTotal()} </td>
		    </tr>
		</table>
    </div>
   
    <%@ include file="../footer.jsp" %>
  </body>
</html>
