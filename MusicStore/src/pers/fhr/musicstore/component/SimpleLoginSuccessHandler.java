package pers.fhr.musicstore.component;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.util.StringUtils;

import com.opensymphony.oscache.base.InitializationException;

import pers.fhr.musicstore.models.ShopingCart;

public class SimpleLoginSuccessHandler implements AuthenticationSuccessHandler, InitializingBean {
     	private static final Logger logger=Logger.getLogger(SimpleLoginSuccessHandler.class);
     	private String defaultTargetUrl;  
     	private boolean forwardToDestination = false;   
	    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();  
	    public void setDefaultTargetUrl(String defaultTargetUrl) {  
	        this.defaultTargetUrl = defaultTargetUrl;  
	    }  
	    public void setForwardToDestination(boolean forwardToDestination) {  
	        this.forwardToDestination = forwardToDestination;  
	    }  
	    @Override  
	    public void onAuthenticationSuccess(HttpServletRequest request,  
	            HttpServletResponse response, Authentication authentication)  
	            throws IOException, ServletException {       
	    	//修改购物车和购物key
	    	migrateShoppingCart(request.getSession(),getUserDetails().getUsername());
	        if(forwardToDestination){  
	            logger.info("Login success,Forwarding to "+this.defaultTargetUrl);  
	            request.getRequestDispatcher(this.defaultTargetUrl).forward(request, response);  
	        }else{  
	            logger.info("Login success,Redirecting to "+this.defaultTargetUrl);  
	            this.redirectStrategy.sendRedirect(request, response, this.defaultTargetUrl);  
	        }  
	    }  
	    @Override  
	    public void afterPropertiesSet() throws Exception {  
	        if(StringUtils.isEmpty(defaultTargetUrl))  
	            throw new InitializationException("You must configure defaultTargetUrl");  
	    }    
	    private void migrateShoppingCart(HttpSession session, String userName){
	          // Associate shopping cart items with logged-in user
	          ShopingCart cart = ShopingCart.GetCart(session);
	          cart.migrateCart(userName);
	          session.setAttribute(ShopingCart.getCartSessionKey(), userName);
	      }
	    private UserDetails getUserDetails() {
			Object user=SecurityContextHolder.getContext()
				    .getAuthentication()
				    .getPrincipal();
			return (UserDetails)user;
		}
	    //获取IP地址
	    public String getIpAddress(HttpServletRequest request){    
	        String ip = request.getHeader("x-forwarded-for");    
	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {    
	            ip = request.getHeader("Proxy-Client-IP");    
	        }    
	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {    
	            ip = request.getHeader("WL-Proxy-Client-IP");    
	        }    
	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {    
	            ip = request.getHeader("HTTP_CLIENT_IP");    
	        }    
	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {    
	            ip = request.getHeader("HTTP_X_FORWARDED_FOR");    
	        }    
	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {    
	            ip = request.getRemoteAddr();    
	        }    
	        return ip;    
	    }  
}
