package pers.fhr.musicstore.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pers.fhr.musicstore.component.IPAddressUtil;
import pers.fhr.musicstore.models.Album;
import pers.fhr.musicstore.models.IpAddress;
import pers.fhr.musicstore.services.IAlbumService;

@Controller
public class HomeController {
	private final static Logger logger = Logger.getLogger(HomeController.class);
	@Autowired
	private IPAddressUtil ipAddressUtil=null;
	@Autowired
	private IAlbumService albumService=null;
	@RequestMapping("/index")
	public ModelAndView index(HttpServletRequest httpServletRequest){
		List<Album> albums = albumService.getTopSellingAlbums(5);
		logger.error("Album count:"+albums.size());
		test(httpServletRequest);
		return new ModelAndView("home/index","albums",albums);
	}
	@RequestMapping("/")
	public ModelAndView home(){
		List<Album> albums = albumService.getTopSellingAlbums(5);
		logger.error("Album count:"+albums.size());
		return new ModelAndView("home/index","albums",albums);
	}
	public void test(HttpServletRequest httpRequest){
		String ip=ipAddressUtil.getIpAddress(httpRequest);
		IpAddress address=ipAddressUtil.getIpInfoBySina(ip);
	}
}
