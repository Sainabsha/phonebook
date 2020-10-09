package phoneBook.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import phoneBook.dao.AddressDao;
import phoneBook.dao.ProfileDao;
import phoneBook.model.Address;
import phoneBook.model.Profile;

@Controller
public class ProfileController {
	 
	private ProfileDao profileDao;
	private AddressDao addressDao;

	
	@Autowired
	public ProfileController (ProfileDao profileDao, AddressDao addressDao) {
		this.profileDao = profileDao;
		this.addressDao = addressDao;
	}
	
	@GetMapping({"/"})
	public String showContactList(Model model) {
		List<Profile> contactList = profileDao.getContact();
		model.addAttribute("contactList", contactList);
		return "contactList";
	}

	
	@PostMapping("/addContact")
	public ModelAndView addContact(@ModelAttribute Profile profile) {
		profile.getAddress().setMobile(profile.getMobile());
		profileDao.addContact(profile);
		addressDao.addAddress(profile.getAddress());
		ModelAndView modelAndView = new ModelAndView("redirect:/");
		return modelAndView;
	}

	
	@GetMapping({"/getContactbyName"})
	public Model getContactbyName (Model model, @RequestParam String name) {
		List<Profile> profile = profileDao.getContactbyName(name);
		model.addAttribute("profile", profile);
		return model;
	}
	
	
	@GetMapping({"/getContactByCategory"})
	public Model getContactbyCategory (Model model, @RequestParam String category) {
		List<Profile> profile = profileDao.getContactByCategory(category);
		model.addAttribute("profile", profile);
		return model;
	}

	
	@GetMapping("/removeContact")
	public String removeContact(@RequestParam("mobile") int mobile, Model model) {
		profileDao.removeContact(mobile);
		addressDao.removeAddress(mobile);
		List<Profile> contactList = profileDao.getContact();
		model.addAttribute("contactList", contactList);
		return "contactList";
	}


	@RequestMapping("/update")
	public String update(Model model,@RequestParam int mobile) {
		model.addAttribute("profile", profileDao.getContactByNumber(mobile));
		return "update";
		
	}
	


	/*
	 * @RequestMapping("/updateContact") public String updateNote(Model
	 * model,@ModelAttribute Profile profile) { Profile profile1 = new Profile();
	 * Address address = new Address(); profile1.setMobile(profile.getMobile());
	 * profile1.setName(profile.getName()); profile1.setEmail(profile.getEmail());
	 * profile1.setCategory(profile.getCategory());
	 * address.setMobile(profile.getMobile());
	 * address.setAddressline(profile.getAddress().getAddressline());
	 * address.setCity(profile.getAddress().getCity());
	 * address.setPincode(profile.getAddress().getPincode());
	 * profile1.setAddress(address); profileDao.updateContact(profile1);
	 * model.addAttribute("updated List", profileDao.getContact()); return
	 * "contactList"; }
	 */
	

	@RequestMapping("/updateContact")
	public ModelAndView updateContact(@ModelAttribute Profile profile) {
		profile.getAddress().setMobile(profile.getMobile());
		profileDao.updateContact(profile);
		/*
		 * addressDao.updateAddress(profile.getAddress());
		 */		
		ModelAndView modelAndView = new ModelAndView("redirect:/");
		return modelAndView;
	}
	}
	
