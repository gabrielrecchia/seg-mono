package com.seguro.segmono.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.seguro.segmono.entity.Contact;
import com.seguro.segmono.model.ContactModel;
import com.seguro.segmono.service.ContactService;



@Controller
@RequestMapping("/contact")
public class ContactController {

private static final String COURSES_VIEW = "contact";
private static final String COURSESFORM_VIEW = "contactform";
	
	@Autowired
	@Qualifier("contactServiceImpl")
	private ContactService contactService;
	
	
	@GetMapping("/showcontacts")
	public ModelAndView showContacts() {
		ModelAndView mav = new ModelAndView("contacts");
		mav.addObject("contacts", contactService.listAllContacts());
		return mav;
	}
	
	@GetMapping("/contactform")
	public String redirectContactForm(Model model) {	
		model.addAttribute("contactModel", new ContactModel());
		return "contactform";
	}
	
	@GetMapping("/cancel")
	public String cancel() {	
		return "contacts";
	}
	
	@PostMapping("/addcontact")
	public String addCourse(@ModelAttribute(name="contactModel") ContactModel contactModel,
			Model model) {
		contactService.addContact(contactModel);
		model.addAttribute("result", 1);
		return "contacts";
	}
}
