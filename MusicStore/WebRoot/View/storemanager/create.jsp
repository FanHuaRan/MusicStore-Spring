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
    <div id="main">
    <h2>Create</h2> 
       <form action="../StoreManager/Create" method="POST">
       	 <div class="form-horizontal">
       	 	 <h4>Album</h4><hr />
       	 	 <div class="form-group">
             	 <label class="control-label col-md-2">Genre</label>
	             <div class="col-md-10">
	                <select id="GenreId" name="GenreId">
	                <c:forEach items="${genres}" var="genre">
						<option selected="selected" value="${genre.getGenreId()}">${genre.getName()}</option>
					</c:forEach>
					</select>
	            </div>
       	 	 </div>
       	 	  <div class="form-group">
                 <label class="control-label col-md-2">Artist</label>
	             <div class="col-md-10">
	                <select id="ArtistId" name="ArtistId">
	                <c:forEach items="${artists}" var="artist">
						<option selected="selected" value="${artist.getArtistId()}">${artist.getName()}</option>
					</c:forEach>
					</select>
	            </div>
       	 	 </div>
       	 	  <div class="form-group">
           	     <label class="control-label col-md-2">Title</label>
            	<div class="col-md-10">
                <input class="text-box single-line" data-val="true"  id="Title" name="Title" type="text"/>
                </div>
       		  </div>
       	 	  <div class="form-group">
           	    <label class="control-label col-md-2">Price</label>
            	<div class="col-md-10">
                <input class="text-box single-line" data-val="true"  id="Price" name="Price" type="text"/>
                </div>
       		  </div>
       		   <div class="form-group">
       		   <label class="control-label col-md-2">Album Art URL</label>
            	<div class="col-md-10">
                <input class="text-box single-line" data-val="true"  id="AlbumArtUrl" name="AlbumArtUrl" type="text"/>
                </div>
       		  </div>
       		  <div class="form-group">
	            <div class="col-md-offset-2 col-md-10">
	                <input type="submit" value="Save" class="btn btn-default" />
	            </div>
        	  </div>
       	 </div>
       </form>
      <div><a href="../StoreManager">Back to List</a></div>
    </div>
      
    <jsp:include page="../footer.jsp"/>
  </body>
</html>
