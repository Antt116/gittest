package student_registeration.models;

import java.util.ArrayList;
import java.util.List;

public class Student {
	private int id;
	private String stu_id;
	private String stu_name;
	private String stu_dob;
	private String stu_gender;
	private String stu_phone;
	private int eid;
	List<Course> courses=new ArrayList<Course>();
	List<Education> educations=new ArrayList<Education>();
	
	public Student() {
		
	}
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getStu_id() {
		return stu_id;
	}

	public void setStu_id(String stu_id) {
		this.stu_id = stu_id;
	}

	public String getStu_name() {
		return stu_name;
	}

	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}

	public String getStu_dob() {
		return stu_dob;
	}

	public void setStu_dob(String stu_dob) {
		this.stu_dob = stu_dob;
	}
	
	public String getStu_gender() {
		return stu_gender;
	}

	public void setStu_gender(String stu_gender) {
		this.stu_gender = stu_gender;
	}

	public String getStu_phone() {
		return stu_phone;
	}

	public void setStu_phone(String stu_phone) {
		this.stu_phone = stu_phone;
	}

	public int getEid() {
		return eid;
	}


	public void setEid(int eid) {
		this.eid = eid;
	}


	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public List<Education> getEducations() {
		return educations;
	}

	public void setEducations(List<Education> educations) {
		this.educations = educations;
	}
	public String toString() {
		return this.id+" : "+this.stu_name+" : "+this.stu_dob+" $ ";
	}
	
}
