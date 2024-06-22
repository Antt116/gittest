package student_registeration.models;

import java.util.Objects;

public class Course {
	private int id;
	private String course_id;
	private String course_name;
	
	public Course() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCourse_id() {
		return course_id;
	}

	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id,course_name);//attr values twe pw mhr code htote lite tr
	}
	@Override
	public boolean equals(Object obj) {
		if(this==obj) {
			return true;//memory
		}if(obj==null) {
			return false;
		}
		if(getClass()!=obj.getClass()) {
			return false;
		}
		Course other=(Course)obj;
		return Objects.equals(id, other.getId()) && Objects.equals(course_name, other.getCourse_name());
	}
	
}
