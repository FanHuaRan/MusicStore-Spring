<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
 <div id="header">
        <h1>Spring MVC MUSIC STORE</h1>
        <ul id="navlist">
            <li class="first">  
                <a href="/MusicStore/index" id="current">Home</a>
            </li>
            <li>
                <a href="/MusicStore/Store">Store</a>
            </li>
            <!-- 
            <li>
                @{Html.RenderAction("CartSummary", "ShoppingCart");}
            </li>
             -->
            <li>
            <li>
                 <a href="/MusicStore/StoreManager"">Admin</a>
            </li>
        </ul>
    </div>
</body>
</html>