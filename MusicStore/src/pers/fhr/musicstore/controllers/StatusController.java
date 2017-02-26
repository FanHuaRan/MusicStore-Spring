package pers.fhr.musicstore.controllers;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Status")
public class StatusController {
	private final static Logger logger = Logger.getLogger(StatusController.class);
	@RequestMapping("/404")
	public String page404(){
		return "common/404";
	}
	@RequestMapping("/403")
	public String page403(){
		return "common/403";
	}
	@RequestMapping("/500")
	public String page500(){
		return "common/500";
	}
}
