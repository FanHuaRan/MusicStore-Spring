package pers.fhr.musicstore.controllers;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pers.fhr.musicstore.models.Album;
import pers.fhr.musicstore.services.IAlbumService;

@Controller
@RequestMapping("/index")
public class HomeController {
	private static Logger logger = Logger.getLogger(HomeController.class);
	@Autowired
	private IAlbumService albumService=null;
	@RequestMapping()
	ModelAndView home(){
		List<Album> albums = albumService.GetTopSellingAlbums(5);
		logger.error("Album count:"+albums.size());
		return new ModelAndView("home/index","albums",albums);
	}
}
