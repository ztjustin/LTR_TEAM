package com.LTR.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.LTR.configuration.PasswordCreator;
import com.LTR.service.PlatformService;
import com.LTR.service.UserService;


@Controller
public class AuthenticationController {
	
	
	private static final Log LOG = LogFactory.getLog(AuthenticationController.class);
	
	@Autowired
	@Qualifier("userServiceImpl")
	private UserService userService;
	
	@Autowired
	PasswordCreator passCreator;
	
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
	
	@GetMapping({"/admin/changePassword"})
    public ModelAndView changePassword() {
		
		ModelAndView view = new ModelAndView("changePassword");
		
		return view;
		
    }
	
	@PostMapping("/admin/changePasswordUser")
	public String changeUserPassword(@RequestParam(name="newPassword", required=true) String newPassword,
			@RequestParam(name="repeatedPassword", required=true) String repeatedPassword,
			final RedirectAttributes redirectAttributes,Model model) {
							
		if(!newPassword.equals(repeatedPassword)) {
			redirectAttributes.addFlashAttribute("error","NotEqual");
			return "redirect:/admin/changePassword";
		}else {
			User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			try {
				com.LTR.entity.User newUserPass = userService.getOne(user.getUsername());
				newUserPass.setPassword(newPassword);
				LOG.info(newPassword);
				userService.addOne(newUserPass);
				return "redirect:/admin/logout";
				
			}catch(Exception ex) {
				redirectAttributes.addFlashAttribute("error","have been ocurred an error");
				return "redirect:/admin/changePassword";
				
			}
			
		}
	}
	
	@GetMapping("/admin/logout")
	public ModelAndView logout(){
		SecurityContextHolder.getContext().setAuthentication(null);
		return new ModelAndView(new RedirectView("/"));
	}
	
}