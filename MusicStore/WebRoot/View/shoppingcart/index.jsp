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
	
	<link rel="stylesheet" type="text/css" href="../Css/Site.css">
	<script src="../Scripts/jquery-1.10.2.min.js" type="text/javascript"></script>
    <script src="../Scripts/modernizr-2.6.2.js" type="text/javascript"></script>
	<script type="text/javascript">
    $(function () {
        // Document.ready -> link up remove event handler
        $(".RemoveLink").click(function () {
            var recordDelete = $(this).attr("data-id");
            if (recordDelete != '') {
                // Perform the ajax post
                $.post("../api/Shopping/RemoveFromCart"
                      , { id: recordDelete }
                      , function (data) {
                          // Successful requests get here
                          // Update the page elements
                          console.warn(data);
                          if (data.ItemCount == 0) {
                              $('#row-' + data.DeleteId).fadeOut('slow');
                          }
                          else {
                              $('#item-count-' + data.DeleteId).text(data.ItemCount);
                          }
                          $('#cart-total').text(data.CartTotal);
                          $('#update-message').text(data.Message);
                          $('#cart-status').text('Cart (' + data.CartCount + ')');
                      });
            }
        });
    });
</script>
  </head>
  
  <body>
    <jsp:include page="../header.jsp" />
  
    <div id="main">
		<h3><em>Review</em>Your carts:</h3>
		<p class="button"><a href="/Checkout/AddressAndPayment">Check out>></a></p>
		<div id="update-message"></div>
		<table>
		    <tr>
		        <th>Album Name</th>
		        <th>Price (each)</th>
		        <th>Quantity</th>
		        <th></th>
		    </tr>
		    <c:forEach items="${viewModel.getCartItems()}" var="item">
		    	<tr id="row-@item.RecordId">
		            <td><a href="/Store/Details?id=${item.getAlbum().getAlbumId()}">${item.getAlbum().getTitle()}</a></td>
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
   
    <jsp:include page="../footer.jsp"/>
  </body>
</html>
