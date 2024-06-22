package student_registeration.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import student_registeration.models.Course;
import student_registeration.persistance.CourseRepository;

@Controller
public class CourseController {
	@Autowired
	CourseRepository courseRepo;
	
	@GetMapping("addcourse")
	public ModelAndView addAuthor() {
		return new ModelAndView("addCourse","course",new Course());
	}
	//post are wirte to get the data from form
	@PostMapping("addcourse")
	public String addAuthor(@ModelAttribute("course")@Validated Course course,BindingResult bResult,ModelMap map) {
		if(bResult.hasErrors()) {
			return "addCourse";
		}
		int rs=courseRepo.add(course);
		//repo adding fail due to Sql error or connection timeout 
		if(rs==0) {
			map.addAttribute("error_msg","Database Error");
			return "addCourse";
		}
		return "welcome";
	}
}
