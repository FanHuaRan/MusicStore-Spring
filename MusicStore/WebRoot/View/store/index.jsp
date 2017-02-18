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
	
	<link rel="stylesheet" type="text/css" href="Css/Site.css">
	<script src="Scripts/jquery-1.10.2.min.js" type="text/javascript"></script>
    <script src="Scripts/modernizr-2.6.2.js" type="text/javascript"></script>

  </head>
  
  <body>
    <jsp:include page="../header.jsp" />
    <h3>Browse Genres</h3>
	<p>
	    select from ${genres.size()} genres:
	</p>
	<ul>
	<c:forEach items="${genres}" var="genre">
		<li>
		  <a href="Store/Browse?genre=${genre.getName()}"> ${genre.getName()}</a>
		</li>
	</c:forEach>
	</ul>
    <jsp:include page="../footer.jsp"/>
  </body>
</html>
