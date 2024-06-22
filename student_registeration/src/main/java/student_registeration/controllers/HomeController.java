package student_registeration.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import student_registeration.models.Login;
import student_registeration.models.User;
import student_registeration.persistance.UserRepository;

@Controller
public class HomeController {
	@RequestMapping("/")
	public ModelAndView index() {
		return new ModelAndView ("index","user",new Login());
	}
	
	@PostMapping("user")
	public String checkLogin(@ModelAttribute("user")Login login) {
		UserRepository userRepo=new UserRepository();
		User user=userRepo.getByLogin(login);
		if(user!=null && user.getUser_name()!=null) {
			return "welcome";
		}else {
			return "redirect:/";
		}
	}
}
