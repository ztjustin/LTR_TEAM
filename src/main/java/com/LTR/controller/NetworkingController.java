package com.LTR.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.LTR.service.PlatformService;
import com.LTR.service.UserService;

@Controller
public class NetworkingController {
	
	private static final Log LOG = LogFactory.getLog(PlatformController.class);
	
	@Autowired
	@Qualifier("platformServiceImpl")
	private PlatformService platformServiceImpl;
	
	@Autowired
	@Qualifier("userServiceImpl")
	private UserService userServiceImpl;
	
	@GetMapping({"/admin/step5/{platformId}"})
    public ModelAndView indexStep1(@PathVariable(required = false) Long platformId) {
		
		ModelAndView model = new ModelAndView("step5");
		
		if(platformId != null) {
			model.addObject("platform",platformServiceImpl.getOne(platformId));
			//model.addObject("silicons",siliconServiceImpl.findByPlatform(platformServiceImpl.getOne(platformId)));
			//model.addObject("siliconsbyRequest", siliconServiceImpl.findBySiliconRequestUsers(userServiceImpl.getOne(user.getUsername())));			
		}else {
			
		}
		
		return model;
			
    }

}
