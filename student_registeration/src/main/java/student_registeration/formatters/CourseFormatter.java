package student_registeration.formatters;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import student_registeration.models.Course;
import student_registeration.persistance.CourseRepository;

public class CourseFormatter implements Formatter<Course> {
	@Override
	public String print(Course object, Locale locale) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Course parse(String text, Locale locale) throws ParseException {
		CourseRepository repo=new CourseRepository();
		int id=Integer.parseInt(text);
		Course course=repo.getById(id);//full info object yu
		return course;
	}

}
