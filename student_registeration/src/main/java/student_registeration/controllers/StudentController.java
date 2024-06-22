package student_registeration.controllers;


import java.util.ArrayList;
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
import org.springframework.web.servlet.ModelAndView;

import student_registeration.models.Course;
import student_registeration.models.Education;
import student_registeration.models.Student;
import student_registeration.persistance.CourseRepository;
import student_registeration.persistance.EducationRepository;
import student_registeration.persistance.StudentRepository;

@Controller
public class StudentController {
	@Autowired
	CourseRepository courseRepo;
	@Autowired
	StudentRepository studentRepo;
	@Autowired
	EducationRepository eduRepo;
	
	@RequestMapping("studentlist")
	public String displayAll(ModelMap map) {
		List<Student> students = studentRepo.getAll();
		map.addAttribute("students", students);// model
		return "studentList";// view
	}
	
	@GetMapping("addstudent")
	public ModelAndView addStudent( ModelMap map) {
		List<Course> courses=courseRepo.getAll();
		List<Education> education=eduRepo.getAll();
		List<Student> student = studentRepo.getAll();
		map.addAttribute("selected_course",courses);
		map.addAttribute("selected_edu",education);
		map.addAttribute("student", student);
		System.out.println(student);
		return new ModelAndView("addStudent", "student", new Student());// view ,model book to new Book obj (java understand
																// model)
	}
	
	@PostMapping("addstudent")
	public String addStudent(@ModelAttribute("student") @Validated Student student, BindingResult bResult, ModelMap map) {
		if (bResult.hasErrors()) {
			map.addAttribute("error_msg", bResult.getFieldError());
			map.addAttribute("selected_course",courseRepo.getAll());
			map.addAttribute("selected_edu",eduRepo.getAll());
			map.addAttribute("student", student);
			return "addStudent";
		}
		System.out.println(student);
		map.addAttribute("student", student);
		int rs = studentRepo.add(student);
		if (rs == 0) {
			map.addAttribute("student", student);
			map.addAttribute("error_msg", "SQL Insert Error: ");
			map.addAttribute("selected_course",courseRepo.getAll());
			map.addAttribute("selected_edu",eduRepo.getAll());
			return "addStudent";
		} else {
			return "redirect:/studentlist";
		}
	}
	
	// delete
		@GetMapping("/deletestudent/{id}")
		public String deleteStudent(@PathVariable int id) {// code is rename in java
			studentRepo.delete(id);
			return "redirect:/studentlist";
		}

		@GetMapping("editstudent/{id}")
		public ModelAndView editStudent(@PathVariable String id,ModelMap map) {
			Student student = studentRepo.getById(id);
			
			List<Course> courses=courseRepo.getAll();
			List<Education> education=eduRepo.getAll();
			map.addAttribute("selected_course",courses);
			map.addAttribute("selected_edu",education);
			return new ModelAndView("updateStudent", "student", student);// last book mean that the model have old book
		}

//		@PostMapping("/editstudent")
//		public String editStudent(@ModelAttribute("student") @Validated Student student, BindingResult bResult, ModelMap map) {
//			if (bResult.hasErrors()) {
//				map.addAttribute("error_msg", bResult.getFieldError());
//				map.addAttribute("student",student);
//				map.addAttribute("selected_course",courseRepo.getAll());
//				map.addAttribute("selected_edu",eduRepo.getAll());
//				return "updateStudent";
//			}
//			int rs = studentRepo.edit(student);
//			if (rs == 0) {
//				map.addAttribute("error_msg", "SQL Update Error: ");
//				map.addAttribute("student", student);
//				map.addAttribute("selected_course",courseRepo.getAll());
//				map.addAttribute("selected_edu",eduRepo.getAll());
//				return "updateStudent";
//			} else {
//				return "redirect:/studentlist";
//			}
//		}
		
		@PostMapping("editstudent")
		public String editStudent(@ModelAttribute("student") @Validated Student student, BindingResult bResult, ModelMap map) {
			if (bResult.hasErrors()) {
				map.addAttribute("error_msg", bResult.getFieldError());
				map.addAttribute("selected_course",courseRepo.getAll());
				map.addAttribute("selected_edu",eduRepo.getAll());
				map.addAttribute("student", student);
				return "updateStudent";
			}
			
			int rs = studentRepo.edit(student);
			if (rs == 0) {
				map.addAttribute("student", student);
				map.addAttribute("error_msg", "SQL Insert Error: ");
				map.addAttribute("selected_course",courseRepo.getAll());
				map.addAttribute("selected_edu",eduRepo.getAll());
				return "updateStudent";
			} else {
				return "studentList";
			}
		}
	
}
