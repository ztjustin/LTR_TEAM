package com.LTR.controller;


import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.LTR.entity.Platform;
import com.LTR.service.PlatformService;
import com.LTR.service.SiliconService;
import com.LTR.service.UserService;
import com.LTR.service.impl.LocationServiceImpl;

@Controller
public class PlatformController {
	
	private static final Log LOG = LogFactory.getLog(PlatformController.class);
	
	@Autowired
	@Qualifier("platformServiceImpl")
	private PlatformService platformServiceImpl;
	
	@Autowired
	@Qualifier("userServiceImpl")
	private UserService userServiceImpl;
	
	@Autowired
	@Qualifier("locationServiceImpl")
	private LocationServiceImpl locationServiceImpl;
	
	@Autowired
	@Qualifier("siliconServiceImpl")
	private SiliconService siliconServiceImpl;
		
	@GetMapping({"/admin/step1", "/admin/step1/{platformId}"})
    public ModelAndView indexStep1(@PathVariable(required = false) Long platformId) {
		
		ModelAndView model = new ModelAndView("step1");
		
		model.addObject("locations",locationServiceImpl.getAll());
		model.addObject("platforms",platformServiceImpl.getAll());
	
		if(platformId != null) {
			model.addObject("platform",platformServiceImpl.getOne(platformId));
			//model.addObject("silicons",siliconServiceImpl.findByPlatform(platformServiceImpl.getOne(platformId)));
			//model.addObject("siliconsbyRequest", siliconServiceImpl.findBySiliconRequestUsers(userServiceImpl.getOne(user.getUsername())));
			
		}
		
		return model;
			
    }
	
	
	@PostMapping({"/admin/platformAddorEdit"})
    public String addOrEditPlatform(@ModelAttribute(name="platform") Platform platform,
    		final RedirectAttributes redirectAttributes,HttpServletRequest request,Model model) {
		
		
		String messageString  = null;
		
		try {
			
			
			if(platform.getPlatformId() == null) {
				messageString = "inserted";
			}else {				
				messageString = "updated";
			}
			
			Platform platf = platformServiceImpl.addOne(platform);
			model.addAttribute("locations",locationServiceImpl.getAll());
			
			//Date localDate = new Date();
			//PlatformDetail newDetailPlatform = new PlatformDetail();
			//newDetailPlatform.setLastUpdate(localDate);
			//newDetailPlatform.setPlatform(platform);
			//platformDetailServiceImpl.addOne(newDetailPlatform);
			//redirectAttributes.addAttribute("platformId", platf.getPlatformId());
			redirectAttributes.addFlashAttribute("success",messageString);
			return "redirect:/admin/step1/" + platf.getPlatformId();
			
		}catch(Exception ex) {
			redirectAttributes.addFlashAttribute("error",messageString);
			LOG.info(ex.getMessage());
			return "redirect:/admin/platform";
		}

    }
	
	/*@GetMapping({"/admin/updatePlatform"})
    public String updatePlatform(@RequestParam(name="platformId",required = false) Long platformId,Model model) {
		
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("username",user.getUsername());
		
		if(platformId == null  ||  platformServiceImpl.exists(platformId) == false) {
			 return "redirect:/admin/index";	
		}else {
			model.addAttribute("platform",platformServiceImpl.getOne(platformId));
		}

		return "updatePlatform";
    }*/
	
	
	/*@PostMapping({"/admin/platform/updatePlatformDetail"})
    public String updatePlatformDetail(@ModelAttribute(name="platform") Platform platform,HttpServletRequest request,Model model) {
		
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("username",user.getUsername());
		
		try {
			
			platformServiceImpl.addOne(platform);
			PlatformDetail newDetailPlatform = platformDetailServiceImpl.getPlatformDetailByPlatformId(platform.getPlatformId());
			LOG.info(newDetailPlatform.toString());
			Date localDate = new Date();
			newDetailPlatform.setLastUpdate(localDate);
			platformDetailServiceImpl.addOne(newDetailPlatform);
			model.addAttribute("success","success");
			
			return "updatePlatform";
			
		}catch(Exception ex) {
			model.addAttribute("error","error");
			LOG.info(ex.toString());
			return "updatePlatform";
		}

    }*/
	
	
	
	
}
