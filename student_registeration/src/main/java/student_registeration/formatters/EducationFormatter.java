package student_registeration.formatters;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import student_registeration.models.Education;
import student_registeration.persistance.EducationRepository;

public class EducationFormatter implements Formatter<Education> {
	@Override
	public String print(Education object, Locale locale) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Education parse(String text, Locale locale) throws ParseException {
		EducationRepository repo=new EducationRepository();
		int eid=Integer.parseInt(text);
		Education education=repo.getById(eid);//full info object yu
		return education;
	}
}
