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
    <div id="promotion">
	</div>
	<ul id="categories"></ul>
	<div id="main">
	<h2>Music Stre Home Page</h2>
	<h3><em>Fresh</em>off the grill</h3>
	<ul>
	<c:forEach items="${albums}" var="album">
		<li>
		  <a href="Store/Details?id=${album.getAlbumId()}">
		   <img alt="${album.getTitle()}" src="${album.getAlbumArtUrl()}" />
	                <span>${album.getTitle()}</span>
		</a>
		</li>
	</c:forEach>
	</ul>
	</div>
     <%@ include file="../footer.jsp"%>
  </body>
</html>