package com.LTR.controller;



//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Controller;

import com.LTR.service.PlatformService;

@Controller
public class HardDiskController {
	
	//private static final Log LOG = LogFactory.getLog(HardDiskController.class);
	
	
	@Autowired
	@Qualifier("platformServiceImpl")
	private PlatformService platformServiceImpl;
	
	/*@GetMapping({"/admin/hardDisk"})
    public ModelAndView index() {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		ModelAndView model = new ModelAndView("hardDisks");
		model.addObject("username",user.getUsername());
		model.addObject("hardDisks",hardDiskServiceImpl.getAll());
		LOG.info("Esta es el detalle de los Hard Disks " + hardDiskServiceImpl.getAll().toString());
		return model;
    }*/
	
	
	/*@GetMapping({"/admin/addHardDiskToPlatform"})
    public String addHardDiskToPlatform(@RequestParam(name="platformId",required = false) Long platformId,Model model) {
		
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("username",user.getUsername());
		
		if(platformId == null  ||  hardDiskServiceImpl.exists(platformId) == false) {
			 return "redirect:/admin/hardDisk";	
		}else {
			model.addAttribute("platform",platformServiceImpl.getOne(platformId));
			model.addAttribute("hardDisks",hardDiskServiceImpl.getHardDisksByNullPlatform());

		}

		return "AddHardDisk";
    }*/
	
	/*For ajax method*/
	/*@GetMapping({"/admin/getOneHardDisk"})
	@ResponseBody
    public HardDisk getOneHardDisk(@RequestParam(name="hardDiskId",required = false) Long hardDiskId) {
		
		HardDisk hardDisk = new HardDisk();
		if(hardDiskId == null  ||  hardDiskServiceImpl.exists(hardDiskId) == false) {
			 return null;	
		}else {
			hardDisk = hardDiskServiceImpl.getOne(hardDiskId);
		}
		
		return hardDisk;
    }*/
	
	/*@PostMapping({"/admin/hardDisk/AddPlatformToHardDisk"})
    public String updatePlatformDetailCpu(@RequestParam(name="platformId",required = false) Long platformId,
    		@RequestParam(name="hardDiskId",required = false) Long hardDiskId,HttpServletRequest request,Model model) {
		
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("username",user.getUsername());
		
		try {
			
			
			model.addAttribute("platform",platformServiceImpl.getOne(platformId));
			
			
			HardDisk updatePlatformHarDisk = new HardDisk();
			updatePlatformHarDisk = hardDiskServiceImpl.getOne(hardDiskId);
			
			PlatformDetail newDetailPlatform = platformDetailServiceImpl.getPlatformDetailByPlatformId(platformId);
			Date localDate = new Date();
			newDetailPlatform.setLastUpdate(localDate);
			updatePlatformHarDisk.setPlatformDetail(newDetailPlatform);
			hardDiskServiceImpl.addOne(updatePlatformHarDisk);
			model.addAttribute("success","success");
			return "AddHardDisk";
			
		}catch(DataIntegrityViolationException ex) {
			
			LOG.info(ex.toString());
			return "AddHardDisk";
		}

    }*/
	
	
	/*@PostMapping({"/admin/hardDisk/ChangeHold"})
    public String changeOnHoldHardDisk(@RequestParam(name="platformDetailId",required = true) Long platformDetailId,
    		@RequestParam(name="hardDiskId",required = true) Long hardDiskId,Model model) {
		
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("username",user.getUsername());
		
		try {
			
			hardDiskServiceImpl.updateOnHoldFalse(platformDetailId);
			HardDisk updateHardDiskHold = new HardDisk();
			updateHardDiskHold = hardDiskServiceImpl.getOne(hardDiskId);
			updateHardDiskHold.setHold(true);
			hardDiskServiceImpl.addOne(updateHardDiskHold);
			LOG.info(updateHardDiskHold.getHardDiskId() +" "+updateHardDiskHold.getHold());
			
			model.addAttribute("success","success");
			return "redirect:/admin/platformDetail?platformId=" + platformDetailId;
			
		}catch(Exception ex) {
			model.addAttribute("error","error");
			LOG.info(ex.toString());
			return "test";
		}

    }*/
	
	

}
