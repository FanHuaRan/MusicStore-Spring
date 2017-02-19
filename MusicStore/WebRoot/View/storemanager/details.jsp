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
    
	<h2>Details</h2>
	
	<div>
	    <h4>Album</h4>
		<hr />
	    <dl class="dl-horizontal">
	        <dt>Artist:</dt>
	        <dd>${album.getArtist().getName()}</dd>
	        
	        <dt>Genre:</dt>
	        <dd>${album.getGenre().getName()}</dd>
	        
	        <dt>title</dt>
	        <dd>${album.getTitle()}
	        
	        <dt>Price:</dt>
	        <dd>${album.getPrice()}
	    
	        <dt>Album Art Url</dt>
	        <dd>${album.getAlbumArtUrl()}</dd>
	    </dl>
	</div>
	<p>
	    <a href="../StoreManager/Edit?id=${album.getAlbumId()}">Edit</a>
	     <a href="../StoreManager">Back to List</a>
	</p>
    <jsp:include page="../footer.jsp"/>
  </body>
</html>
