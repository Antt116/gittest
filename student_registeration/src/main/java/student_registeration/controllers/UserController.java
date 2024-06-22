package student_registeration.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import student_registeration.models.User;
import student_registeration.persistance.UserRepository;

@Controller
@SessionAttributes("user")
public class UserController {
	@Autowired
	UserRepository userRepo;
	
	@RequestMapping("userlist")
	public ModelAndView userList(ModelMap map) {
		List<User> users = userRepo.getAll();
		map.addAttribute("users", users);// model
		return new ModelAndView("userList", "user", new User());
	}
	
	@GetMapping("adduser")
	public ModelAndView addUser(ModelMap map) {
		List<User> user = userRepo.getAll();
		map.addAttribute("user", user);
		return new ModelAndView("addUser","user",new User());
	}
	//post are wirte to get the data from form
	@PostMapping("adduser")
	public String addUser(@ModelAttribute("user")@Validated User user,BindingResult bResult,ModelMap map) {
		if(bResult.hasErrors()) {
			return "addUser";
		}
		map.addAttribute("user", user);
		int rs=userRepo.add(user);
		//repo adding fail due to Sql error or connection timeout 
		if(rs==0) {
			map.addAttribute("error_msg","Database Error");
			return "addUser";
		}
		return "redirect:/userlist";
	}
	
	@GetMapping("edituser/{id}")
	public ModelAndView editUser(@PathVariable String id ) {
		User user=userRepo.getById(id);//get old author from repo
		return new ModelAndView("updateUser","user",user);
	}
	@PostMapping("edituser")
	public String editUser(@ModelAttribute("user")@Validated User user,BindingResult bResult,ModelMap map) {
		if(bResult.hasErrors()) {
			return "updateUser";
		}
		int rs=userRepo.edit(user);
		//repo updating fail due to Sql error or connection timeout 
		if(rs==0) {
			map.addAttribute("error_msg","In Updating, Database something wrong.");
			return "updateUser";
		}
		else {
			return "redirect:/userlist";
		}
	}
	
	@GetMapping("deleteuser/{id}")
	public String deleteUser(@PathVariable String id ) {
		userRepo.delete(id);//get old author from repo
		return "redirect:/userlist";
	}

}
