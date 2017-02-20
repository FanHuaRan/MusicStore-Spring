package pers.fhr.musicstore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pers.fhr.musicstore.services.IUserService;
import pers.fhr.musicstore.viewmodels.RegisterViewModel;

@Controller
@RequestMapping("/Account")
public class AccountController {
	@Autowired
	private IUserService userService=null;
	@RequestMapping("/logOn")
	public String logOn(){
		
		return "account/logon";
	}
	@RequestMapping("/Register")
    public String Register(Model model){
		RegisterViewModel registerViewModel=new RegisterViewModel();
		model.addAttribute("registerViewModel", registerViewModel);
        return "account/register";
    }
	@RequestMapping(value="/Register",
			method=RequestMethod.POST)
	public String Register(RegisterViewModel registerViewModel){
		if(registerViewModel.getName().equals("")||registerViewModel.getPassword().equals("")){
			return "redirect:Register";
		}
		if(!userService.insertUser(registerViewModel.getName(), registerViewModel.getPassword(), "user")){
			return "redirect:Register";
		}
		return "redirect:logOn";
	}

}
