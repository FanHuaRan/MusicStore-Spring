<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
 <div id="header">
        <h1>Spring MVC MUSIC STORE</h1>
        <ul id="navlist">
            <li class="first"><a href="/MusicStore/index" id="current">Home</a></li>
            <li><a href="/MusicStore/Store">Store</a></li>
         
            <!-- 可以使用下面的标签实现Admin用户才显示Admin链接 但是暂时不采用 -->
            <!--<security:authorize access="hasRole('Admin')">
            	 <li><a href="/MusicStore/StoreManager"">Admin</a></li>
            </security:authorize>-->
             <li><a href="/MusicStore/StoreManager"">Admin</a></li>
             <!-- 如果已经授权则显示退出链接 -->
            <security:authorize access="isAuthenticated()">
            	<li><a href="/MusicStore/Account/logOut">Log Out</a></li>
            </security:authorize>
            <!-- 不具有 Admin,User的权限则显示登录链接-->
           <security:authorize ifNotGranted="Admin,User">
           		<li><a href="/MusicStore/Account/logOn">Log In</a></li>
           </security:authorize>
           
           <li><a href="/MusicStore/ShoppingCart"><img alt="ShopCar" src="/MusicStore/Resource/images/shopingcar.png"/></a></li>
        </ul>
    </div>
</body>
</html>