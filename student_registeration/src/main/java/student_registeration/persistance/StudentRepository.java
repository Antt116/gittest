package student_registeration.persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import student_registeration.models.Course;
import student_registeration.models.Student;

public class StudentRepository {
	public static Connection con=null;
	static {
		con=MyConnection.getConnection();
	}
	
	//create insert
		public int add(Student student) {
			int result=0;
			String sql="INSERT INTO student(id,stu_id,stu_name,stu_dob,stu_gender,stu_phone,eid) VALUES (?,?,?,?,?,?,?)";
			try {
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setInt(1, student.getId());
				ps.setString(2, student.getStu_id());
				ps.setString(3, student.getStu_name());
				ps.setString(4,student.getStu_dob());
				ps.setString(5, student.getStu_gender());
				ps.setString(6, student.getStu_phone());
				ps.setInt(7, student.getEid());
				ps.executeUpdate();
				for(Course course:student.getCourses()) {
					sql="INSERT INTO student_has_course(student_id,course_id) VALUES (?,?)";
					
					ps=con.prepareStatement(sql);
					ps.setInt(1,student.getId());
					ps.setInt(2, course.getId());
					result=ps.executeUpdate();
				}
			}catch(SQLException e) {
				result=0;
				System.out.println("Student insert err: "+e);
			}
			return result;
		}
		
		//update
		public int edit(Student student) {
			int result=0;
			String sql="UPDATE student SET stu_id,stu_name=?,stu_dob=?, stu_gender=?,stu_phone=?,eid=? WHERE id=?";
			try {
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setString(1, student.getStu_id());
				ps.setString(2, student.getStu_name());
				ps.setString(3, student.getStu_dob());
				ps.setString(4, student.getStu_gender());
				ps.setString(5, student.getStu_phone());
				ps.setInt(6, student.getEid());
				ps.setInt(7,student.getId());
				
				result=ps.executeUpdate();
				
				sql="DELETE FROM student_has_course WHERE student_id=?";
				ps=con.prepareStatement(sql);
				ps.setInt(1, student.getId());
				ps.executeUpdate();
				for(Course course:student.getCourses()) {
					sql="INSERT INTO student_has_course(student_id,course_id) VALUES (?,?)";
					
					ps=con.prepareStatement(sql);
					ps.setInt(1,student.getId());
					ps.setInt(2, course.getId());
					result=ps.executeUpdate();
				}
			}catch(SQLException e) {
				result=0;
				System.out.println("Student edit err: "+e);
			}
			return result;
		}
		
		//delete
			public int delete(int id) {
				int result=0;
				String sql="DELETE FROM student WHERE id=?";
				try {
					PreparedStatement ps=con.prepareStatement(sql);
					ps.setInt(1, id);
					result=ps.executeUpdate();
					
				}catch(SQLException e) {
					result=0;
					System.out.println("student delete err: "+e);
				}
				return result;
			}
			
			//getAll
			public List<Student>getAll(){
				CourseRepository courseRepo=new CourseRepository();
				List<Student> students=new ArrayList<>();
				String sql="SELECT s.*,e.ename FROM student s INNER JOIN education e ON s.eid=e.eid";
				try {
					PreparedStatement ps=con.prepareStatement(sql);
					ResultSet rs=ps.executeQuery();
					while(rs.next()) {
						Student student=new Student();
						student.setId(rs.getInt("id"));
						student.setStu_id(rs.getString("stu_id"));
						student.setStu_name(rs.getString("stu_name"));
						student.setStu_dob(rs.getString("stu_dob"));
						student.setStu_gender(rs.getString("stu_gender"));
						student.setStu_phone(rs.getString("stu_phone"));
						student.setEid(rs.getInt("eid"));
						student.setCourses(courseRepo.getCourseByStudentId(rs.getInt("id")));
						students.add(student);
					}
					
				}catch(SQLException e) {
					System.out.println("Student selec err: "+e);
				}
				return students;
			}
			//getByCode == getOne
			public Student getById(String sid) {
				Student student=null;//initially null
				CourseRepository courseRepo=new CourseRepository();

				String sql="SELECT * FROM student WHERE id=?";
				try {
					PreparedStatement ps=con.prepareStatement(sql);
					ps.setString(1, sid);
					ResultSet rs=ps.executeQuery();
					while(rs.next()) {
						student=new Student();
						student.setId(rs.getInt("id"));
						student.setStu_id(rs.getString("stu_id"));
						student.setStu_name(rs.getString("stu_name"));
						student.setStu_dob(rs.getString("stu_dob"));
						student.setStu_gender(rs.getString("stu_gender"));
						student.setStu_phone(rs.getString("stu_phone"));
						student.setEid(rs.getInt("eid"));
						student.setCourses(courseRepo.getCourseByStudentId(rs.getInt("id")));
					}
					
				}catch(SQLException e) {
					System.out.println("book getByCode err: "+e);
				}
				return student;
			}
}
