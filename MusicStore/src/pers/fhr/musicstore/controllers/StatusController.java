package pers.fhr.musicstore.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Status")
public class StatusController {
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
