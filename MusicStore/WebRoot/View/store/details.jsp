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
    <%@ include file="../header.jsp" %>
	<h2>${album.getTitle()}</h2>
	<p>
	    <img alt="${album.getTitle()}" src="../${album.getAlbumArtUrl()}"/>
	</p>
<div id="album-details">
    <p>
        <em>Genre:</em>${album.getGenre().getName()}
    </p>
    <p>
        <em>Artist:</em> ${album.getArtist().getName()}
    </p>
    <p>
        <em>Price:</em> ${album.getPrice()}
    </p>
    <p class="button">
    <a href="/MusicStore/ShoppingCart/AddToCart?id=${album.getAlbumId()}">AddToCart </a>
    </p>
</div>
    <%@ include file="../footer.jsp" %>
  </body>
</html>
