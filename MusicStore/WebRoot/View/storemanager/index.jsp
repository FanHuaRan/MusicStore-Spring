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

  </head>
  
  <body>
    <jsp:include page="../header.jsp" />
    <h2>Index</h2>
	<p><a href="../StoreManager/Create">Create New</a></p>
	<table class="table">
    <tr>
        <th>Artist</th>
        <th>Genre</th>
        <th>Title</th>
        <th>Price</th>
        <th></th>
    </tr>
	<c:forEach items="${albums}" var="album">
	    <tr>
	        <td>${album.getArtist().getName()}</td>
	        <td>${album.getGenre().getName()}</td>
	        <td>${album.getTitle()}</td>
	        <td>${album.getPrice()}</td>
	        <td>
	        	<a href="../StoreManager/Edit?id=${album.getAlbumId()}">Edit</a>
	            <a href="../StoreManager/Details?id=${album.getAlbumId()}">Details</a>
	        	<a href="../StoreManager/Delete?id=${album.getAlbumId()}">Delete</a>
	        </td>
	    </tr>
	</c:forEach>
	</table>
    <jsp:include page="../footer.jsp"/>
  </body>
</html>
