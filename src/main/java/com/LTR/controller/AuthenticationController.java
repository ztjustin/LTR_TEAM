package com.LTR.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.LTR.service.PlatformService;
import com.LTR.service.UserService;


@Controller
public class AuthenticationController {
	
	
	private static final Log LOG = LogFactory.getLog(AuthenticationController.class);
	
	@Autowired
	@Qualifier("userServiceImpl")
	private UserService userService;
	
	@Autowired
	@Qualifier("platformServiceImpl")
	private PlatformService platformServiceImpl;
	
	
	@GetMapping("/")
	public String showLoginForm(Model model,
			@RequestParam(name="error", required=false) String error,
			@RequestParam(name="logout",required=false) String logout){
		
		LOG.info("METHOD: showLoginForm() -- PARAMS: error="+error+",logout:"+logout);
		
		model.addAttribute("error",error);
		model.addAttribute("logout",logout);
		LOG.info("Returning to login view");
		return "login";
	}
	
	/*En este controller debe de ir toda la logica de logeos, autentificacion y redirecciones*/

	
	@GetMapping({"/admin/index"})
    public ModelAndView index() {
		
		ModelAndView view = new ModelAndView("platforms");
		
		view.addObject("platforms",platformServiceImpl.getAll());

		
		return view;
		
    }
	
	
	@GetMapping("/admin/logout")
	public ModelAndView logout(){
		SecurityContextHolder.getContext().setAuthentication(null);
		return new ModelAndView(new RedirectView("/"));
	}
	
	
	
	
	
	

	
}