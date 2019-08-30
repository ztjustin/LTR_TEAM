package com.LTR.controller;


import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.LTR.entity.Silicon;
import com.LTR.service.SiliconService;
import com.LTR.service.UserService;
import com.LTR.service.PlatformService;

@Controller
public class SiliconController {
	
	private static final Log LOG = LogFactory.getLog(SiliconController.class);
	
	@Autowired
	@Qualifier("siliconServiceImpl")
	private SiliconService siliconServiceImpl;
	
	@Autowired
	@Qualifier("userServiceImpl")
	private UserService userServiceImpl;
	
	@Autowired
	@Qualifier("platformServiceImpl")
	private PlatformService platformServiceImpl;
	
	
	@GetMapping({"/admin/silicon"})
    public ModelAndView index(@RequestParam(value = "siliconId",defaultValue = "", required = false) Long siliconId) {
		
		ModelAndView model = new ModelAndView("silicon");
		model.addObject("silicons",siliconServiceImpl.getAll());
		model.addObject("users",userServiceImpl.getAll());
		model.addObject("platforms",platformServiceImpl.getAll());
		if(siliconId != null) {
			model.addObject("siliconUpdate",siliconServiceImpl.getOne(siliconId));
		}else {
			model.addObject("siliconUpdate",null);
		}
		
		return model;
    }
	
	@GetMapping({"/admin/requestSiliconbyUsers"})
    public ModelAndView requestSilicon() {
		
		ModelAndView model = new ModelAndView("requestSiliconbyUsers");
		model.addObject("silicons",siliconServiceImpl.finbBystatusSilicon("REQUESTED"));

		return model;
    }
	
	@PostMapping({"/admin/siliconAdd"})
    public String addOrEditSilicon(@ModelAttribute(name="silicon") Silicon silicon,
    		final RedirectAttributes redirectAttributes,HttpServletRequest request,Model model) {
		
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		String messageString  = null;
		Date localDateToday = new Date();
		
		try {
						
			if(silicon.getId() == null) {
				messageString = "inserted";
				silicon.setDateAdmission(localDateToday);
				silicon.setStatusSilicon("AVAILABLE");
				silicon.setUserOwner(userServiceImpl.getOne(user.getUsername()));
			}else {
				
				messageString = "updated";
				
			}
			
								
		    siliconServiceImpl.addOne(silicon);
			model.addAttribute("silicons",siliconServiceImpl.getAll());
			
			//Date localDate = new Date();
			//PlatformDetail newDetailPlatform = new PlatformDetail();
			//newDetailPlatform.setLastUpdate(localDate);
			//newDetailPlatform.setPlatform(platform);
			//platformDetailServiceImpl.addOne(newDetailPlatform);
			redirectAttributes.addFlashAttribute("success",messageString);
			return "redirect:/admin/silicon";
			
		}catch(Exception ex) {
			redirectAttributes.addFlashAttribute("error",messageString);
			LOG.info(ex.toString());
			return "redirect:/admin/silicon";
		}

    }
	
	@PostMapping({"/admin/updateSilicon"})
    public String updateSilicon(@RequestParam(name="siliconId",required = true) Long siliconId,@RequestParam(name="qdf",required = true) String qdf,
    		@RequestParam(name="cpuId",required = true) String cpuId,@RequestParam(name="siliconName",required = true) String siliconName,
    		@RequestParam(name="siliconVisualId",required = true) String siliconVisualId,@RequestParam(name="typeSilicon",required = true) String typeSilicon,
    		@RequestParam(name="socket",required = true) String socket,@RequestParam(name="stepping",required = true) String stepping,
    		@RequestParam(name="platform",required = true) Long platformId,
    		final RedirectAttributes redirectAttributes,HttpServletRequest request,Model model) {
				
		String messageString  = null;
		LOG.info(siliconId);
		try {
						
		    Silicon siliconToUpdate = siliconServiceImpl.getOne(siliconId);
		    siliconToUpdate.setQdf(qdf);
		    siliconToUpdate.setCpuId(cpuId);
		    siliconToUpdate.setSiliconName(siliconName);
		    siliconToUpdate.setSiliconVisualId(siliconVisualId);
		    siliconToUpdate.setTypeSilicon(typeSilicon);
		    siliconToUpdate.setSocket(socket);
		    siliconToUpdate.setStepping(stepping);
		    siliconToUpdate.setPlatform(platformServiceImpl.getOne(platformId));
		    
		    siliconServiceImpl.addOne(siliconToUpdate);
		    redirectAttributes.addAttribute("platformId", siliconToUpdate.getPlatform().getPlatformId());
		    messageString = "updatedSilicon";
			redirectAttributes.addFlashAttribute("success",messageString);
			return "redirect:/admin/platform";
			
		}catch(Exception ex) {
			redirectAttributes.addFlashAttribute("error",messageString);
			LOG.info(ex.toString());
			return "redirect:/admin/error";
		}

}
	
	@PostMapping("/admin/returnSilicon")
	public String returnSilicon(@RequestParam(name="siliconId",required = true) Long siliconId,Model model,
			final RedirectAttributes redirectAttributes) {
		
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String messageString  = null;
		
		try {
			
			siliconServiceImpl.returnSilicon(siliconId,userServiceImpl.getOne(user.getUsername()));
			messageString = "deleted";
			redirectAttributes.addFlashAttribute("success",messageString);
			return "redirect:/admin/platform";
			
		}catch(Exception ex) {
			messageString = "error";
			LOG.info(ex.toString());
			return "redirect:/admin/error";
		}

	}
	
	@PostMapping("/admin/deleteSilicon")
	public String deleteSilicon(@RequestParam(name="siliconId",required = true) Long siliconId,Model model,
			final RedirectAttributes redirectAttributes) {
		
		String messageString  = null;
		
		try {
			
			siliconServiceImpl.delete(siliconId);
			messageString = "deleted";
			redirectAttributes.addFlashAttribute("success",messageString);
			return "redirect:/admin/silicon";
			
		}catch(Exception ex) {
			messageString = "error";
			LOG.info(ex.toString());
			return "redirect:/admin/error";
		}

	}	
	
	@PostMapping("/admin/requestSiliconAssignToUser")
	public String requestSiliconAssignToUser(@RequestParam(name="siliconId",required = true) Long siliconId,Model model,
			@RequestParam(name="userName",required = true) String userName,final RedirectAttributes redirectAttributes) {
				
		String messageString  = null;
		
		try {
			
			siliconServiceImpl.assignSiliconToUser(userServiceImpl.getOne(userName), siliconId);
			messageString = "assignedToUser";
			redirectAttributes.addFlashAttribute("success",messageString);
			return "redirect:/admin/requestSiliconbyUsers";
			
		}catch(Exception ex) {
			messageString = "error";
			LOG.info(ex.toString());
			return "redirect:/admin/error";
		}

	}
	
	
	@PostMapping("/admin/requestSiliconFromInventory")
	public String requestSiliconFromInventory(@RequestParam(name="siliconId",required = true) Long siliconId,Model model,
			final RedirectAttributes redirectAttributes) {
		
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String messageString  = null;
		
		try {
			
			LOG.info(siliconServiceImpl.requestSilicon(userServiceImpl.getOne(user.getUsername()), siliconId));
			messageString = "requested";
			redirectAttributes.addFlashAttribute("success",messageString);
			return "redirect:/admin/silicon";
			
		}catch(Exception ex) {
			messageString = "error";
			LOG.info(ex.toString());
			return "redirect:/admin/error";
		}

	}
	
	@PostMapping("/admin/addSiliconFromBu")
	public String addSiliconFromBu(@RequestParam(name="platformId",required = true) Long platformId,
			@RequestParam(name="qdf",required = true) String qdf,@RequestParam(name="siliconVisualId",required = true) String siliconVisualId,
			@RequestParam(name="cpuId",required = false) String cpuId,@RequestParam(name="siliconName",required = true) String siliconName,
			@RequestParam(name="stepping",required = false) String stepping,@RequestParam(name="typeSilicon",required = true) String typeSilicon,
			@RequestParam(name="socket",required = true) String socket,
			Model model,
			final RedirectAttributes redirectAttributes) {
		
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String messageString  = null;
		
		try {
			
			Silicon silFromBu = new Silicon();
			silFromBu.setPlatformOwn(platformServiceImpl.getOne(platformId));
			silFromBu.setQdf(qdf);
			silFromBu.setSiliconVisualId(siliconVisualId);
			silFromBu.setCpuId(cpuId);
			silFromBu.setSiliconName(siliconName);
			silFromBu.setStepping(stepping);
			silFromBu.setTypeSilicon(typeSilicon);
			silFromBu.setSocket(socket);
			Date localDate = new Date();
			silFromBu.setDateAdmission(localDate);
			silFromBu.setDateDelivered(localDate);
			silFromBu.setStatusSilicon("BUSY");
			silFromBu.setPlatform(platformServiceImpl.getOne(platformId));
			silFromBu.setUserOwner(userServiceImpl.getOne(user.getUsername()));
			silFromBu.setUserRequest(userServiceImpl.getOne(user.getUsername()));
			
			
			siliconServiceImpl.addOne(silFromBu);
			messageString = "requested";
			redirectAttributes.addFlashAttribute("success",messageString);
			return "redirect:/admin/silicon";
			
		}catch(Exception ex) {
			messageString = "error";
			LOG.info(ex.toString());
			return "redirect:/admin/error";
		}

	}
	
	@PostMapping("/admin/assignUnit")
	public String assignSilicontoPlatform(@RequestParam(name="siliconId",required = true) Long siliconId,
			@RequestParam(name="socket",required = true) String socket,@RequestParam(name="platformId",required = true) Long platformId,
			Model model,final RedirectAttributes redirectAttributes) {
		
		String messageString  = null;
		
		try {
			
			//update specific silicon to assign unit
			siliconServiceImpl.assignSilicon(platformServiceImpl.getOne(platformId), socket, siliconId);
			redirectAttributes.addAttribute("platformId", platformId);
			messageString = "assigned";
			redirectAttributes.addFlashAttribute("success",messageString);
			return "redirect:/admin/platform";
			
		}catch(Exception ex) {
			messageString = "error";
			LOG.info(ex.toString());
			return "redirect:/admin/error";
		}

	}	
	
	/*@GetMapping({"/admin/siliconEdit"})
    public String detailSilicon(@RequestParam(name="cpuId",required = false) Long cpuId,Model model) {
		
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("username",user.getUsername());
		
		if(cpuId == null  ||  siliconServiceImpl.exists(cpuId) == false) {
			 return "redirect:/admin/cpu";	
		}else {
			model.addAttribute("cpu",siliconServiceImpl.getOne(cpuId));
		}

		return "editCpu";
    }*/
	
	/*For ajax method
	@GetMapping({"/admin/getOneSilicon"})
	@ResponseBody
    public Silicon getOnePch(@RequestParam(name="siliconId",required = false) Long siliconId) {
		
		Silicon cpu = new Silicon();
		if(siliconId == null  ||  siliconServiceImpl.exists(siliconId) == false) {
			 return null;	
		}else {
			cpu = siliconServiceImpl.getOne(siliconId);
		}
		
		return cpu;
    }
	
	/*@GetMapping({"/admin/addCpuToPlatform"})
    public String addcpuToPlatform(@RequestParam(name="platformId",required = false) Long platformId,Model model) {
		
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("username",user.getUsername());
		
		if(platformId == null  ||  platformServiceImpl.exists(platformId) == false) {
			 return "redirect:/admin/cpu";	
		}else {
			model.addAttribute("cpus",cpuServiceImpl.getAll());
			model.addAttribute("platform",platformServiceImpl.getOne(platformId));
			return "AddCpu";
		}

    }*/
	
		
	/*@PostMapping({"/admin/cpu/AddPlatformToCpu"})
    public String updatePlatformDetailCpu(@RequestParam(name="platformId",required = false) Long platformId,
    		@RequestParam(name="cpuId",required = false) Long cpuId,HttpServletRequest request,Model model) {
		
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("username",user.getUsername());
		
		try {
			
			
			model.addAttribute("platform",platformServiceImpl.getOne(platformId));
			model.addAttribute("cpus",cpuServiceImpl.getAll());
			
			Cpu updatePlatformCpu = new Cpu();
			updatePlatformCpu = cpuServiceImpl.getOne(cpuId);
			
			PlatformDetail newDetailPlatform = platformDetailServiceImpl.getPlatformDetailByPlatformId(platformId);
			Date localDate = new Date();
			newDetailPlatform.setLastUpdate(localDate);
			//updatePlatformCpu.setPlatformDetail(newDetailPlatform);
			cpuServiceImpl.addOne(updatePlatformCpu);
			model.addAttribute("success","success");
			return "AddCpu";
			
		}catch(DataIntegrityViolationException ex) {
			
			//model.addAttribute("duplicate","The pch is located in the platform " + cpuServiceImpl.getOne(cpuId).getPlatformDetail().getPlatform().getName());
			LOG.info(ex.toString());
			return "AddCpu";
		}

    }*/
	
	
	

}
