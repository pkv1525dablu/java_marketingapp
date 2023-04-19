package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.controller.util.EmailService;
import com.demo.dto.LeadDto;
import com.demo.entities.Lead;
import com.demo.service.LeadService;


@Controller
public class LeadController {

@Autowired
private LeadService leadService;
@Autowired
private EmailService emailService;
	                          //localhost:8080/create
  @RequestMapping("/create")   // @webServlet
	public String viewCreateLeadForm() {
		return"create_lead";	
	} 
   @RequestMapping("/saveReg")
  public String saveOneLead(@ModelAttribute Lead lead,Model model) {
	   model.addAttribute("msg","Lead is Save.. !");
	  leadService.saveReg(lead);
	  emailService.sendEmail(lead.getEmail(), "Test", "Testing hello my dear");
	  return "create_lead";
  }
     @RequestMapping("/listAll")
     public String getAllLeads(Model model) {
    	 List<Lead> leads = leadService.findAllLeads();
      model.addAttribute("leads", leads);
    	 return "list_leads";
     }
     @RequestMapping("/delete")
     public String deleteLeadById(@RequestParam("id") long id, Model model) {
    	 leadService.deleteLeadById(id);
    	 List<Lead> leads = leadService.findAllLeads();
    	 
    	 model.addAttribute("leads", leads);
    	 return "list_leads";	
     }
     @RequestMapping("/update")
     public String updateLead(@RequestParam("id") long id,Model model) {
    	Lead lead=leadService.findLeadById(id);
    	model.addAttribute("lead", lead); 
    	 return "update_lead";
     }
     @RequestMapping("/editReg")
     public String editReg(LeadDto dto,Model model) {
    	     Lead lead =new Lead();
    	     
    	     lead.setId(dto.getId());
    	     lead.setFirstName(dto.getFirstName());
    	     lead.setLastName(dto.getLastName());
    	     lead.setEmail(dto.getEmail());
    	     lead.setMobile(dto.getMobile());
    	     
    	     leadService.saveReg(lead);
    	     
    	     List<Lead> leads = leadService.findAllLeads();
        	 model.addAttribute("leads", leads);
    	    return "list_leads" ;
     }
     
     
     
} 
     
   
  
   
//  @RequestMapping("/saveReg")
//  public String saveOneLead(@RequestParam("firstName")String firstName,@RequestParam("lastName")String lastName,
//  		  @RequestParam("email")String email,@RequestParam("mobile")long  mobile,Model model) {
//	  Lead lead=new Lead();
//	  lead.setFirstName(firstName);
//	  lead.setLastName(lastName);
//	  lead.setEmail(email);
//	  lead.setMobile(mobile);
//	  
//	   model.addAttribute("msg","Lead is Save.. !");
//	  leadService.saveReg(lead);
//	  return "create_lead";
//  }
  
//        @RequestMapping("/saveReg")
//        public String saveOneLead(LeadDto dto,Model model) {
//        	Lead lead=new Lead();
//        	lead.setFirstName(dto.getFirstName());
//        	lead.setLastName(dto.getLastName());
//        	lead.setEmail(dto.getEmail());
//        	lead.setMobile(dto.getMobile());
//        	
//        	model.addAttribute("msg", "Lead is saved");
//        	leadService.saveReg(lead);
//        	return "create_lead";
//        	
//        	
//        }
        


