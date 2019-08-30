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

import org.springframework.web.bind.annotation.RequestParam;



import com.LTR.service.AnnotationService;
import com.LTR.service.PlatformService;
import com.LTR.service.UserService;

@Controller
public class AnnotationController {
	
	@Autowired
	@Qualifier("annotationServiceImpl")
	private AnnotationService annotationServiceImpl;
	
	@Autowired
	@Qualifier("platformServiceImpl")
	private PlatformService platformServiceImpl;
	
	@Autowired
	@Qualifier("userServiceImpl")
	private UserService userService;
	
	
	private static final Log LOG = LogFactory.getLog(AnnotationController.class);
	
	
	@GetMapping({"/admin/annotation/newAnnotation"})
    public String addNewAnnotation(@RequestParam(name="platformId",required = false) Long platformId,Model model) {
		
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("username",user.getUsername());
		
		if(platformId == null  ||  platformServiceImpl.exists(platformId) == false) {
			 return "redirect:/admin/index";	
		}else {
			model.addAttribute("platform",platformServiceImpl.getOne(platformId));
			LOG.info(platformServiceImpl.getOne(platformId).toString());
		}

		return "AddAnnotation";
    }
	
	
	/*@PostMapping({"/admin/annotation/addNewAnnotation"})
    public String addAnnotation(@ModelAttribute(name="annotation") Annotation annotation,HttpServletRequest request,Model model) {
		
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("username",user.getUsername());
		
		try {
			
			/* Setting annotationEntity
			
			Date localDate = new Date();
			annotation.setDate(localDate);
			annotation.setUser(userService.getOne(user.getUsername()));
			annotationServiceImpl.addOne(annotation);
			
			/* Setting update from platformDetailHour
			PlatformDetail newDetailPlatform = platformDetailServiceImpl.getPlatformDetailByPlatformId(annotation.getPlatform().getPlatformId());
			newDetailPlatform.setLastUpdate(localDate);
			platformDetailServiceImpl.addOne(newDetailPlatform);

			model.addAttribute("success","success");
			model.addAttribute("platform",platformServiceImpl.getOne(annotation.getPlatform().getPlatformId()));
			return "AddAnnotation";
			
		}catch(Exception ex) {
			model.addAttribute("error","error");
			LOG.info(ex.toString());
			return "AddAnnotation";
		}

    }*/
	
	

}
