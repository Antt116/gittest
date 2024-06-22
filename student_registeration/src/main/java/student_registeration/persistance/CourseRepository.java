package student_registeration.persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import student_registeration.models.Course;

public class CourseRepository {
	public static Connection con=null;
	static {
		con=MyConnection.getConnection();
	}
	
	//create insert
		public int add(Course course) {
			int result=0;
			String sql="INSERT INTO course(id,course_id,course_name) VALUES (?,?,?)";
			try {
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setInt(1,course.getId());
				ps.setString(2, course.getCourse_id());
				ps.setString(3, course.getCourse_name());
				result=ps.executeUpdate();
				
			}catch(SQLException e) {
				result=0;
				System.out.println("Course insert err: "+e);
			}
			return result;
		}
		
		//update
		public int edit(Course course) {
			int result=0;
			String sql="UPDATE course SET course_id=?, course_name=? WHERE id=?";
			try {
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setString(1, course.getCourse_id());
				ps.setString(2, course.getCourse_name());
				
				ps.setInt(3, course.getId());
				
				result=ps.executeUpdate();
			}catch(SQLException e) {
				result=0;
				System.out.println("Course edit err: "+e);
			}
			return result;
		}
		
		//delete
			public int delete(int id) {
				int result=0;
				String sql="DELETE FROM course WHERE id=?";
				try {
					PreparedStatement ps=con.prepareStatement(sql);
					ps.setInt(1, id);
					result=ps.executeUpdate();
					
				}catch(SQLException e) {
					result=0;
					System.out.println("course delete err: "+e);
				}
				return result;
			}
			
			//getAll
			public List<Course>getAll(){
				List<Course> courses=new ArrayList<>();
				String sql="SELECT * FROM course";
				try {
					PreparedStatement ps=con.prepareStatement(sql);
					ResultSet rs=ps.executeQuery();
					while(rs.next()) {
						Course course=new Course();
						course.setId(rs.getInt("id"));
						course.setCourse_id(rs.getString("course_id"));
						course.setCourse_name(rs.getString("course_name"));
						courses.add(course);
					}
					
				}catch(SQLException e) {
					System.out.println("author selec err: "+e);
				}
				return courses;
			}
			
			//getByCode == getOne
			public Course getById(int id) {
				Course course=null;//initially null
				String sql="SELECT * FROM course WHERE id=?";
				try {
					PreparedStatement ps=con.prepareStatement(sql);
					ps.setInt(1, id);
					ResultSet rs=ps.executeQuery();
					while(rs.next()) {
						course=new Course();
						course.setId(rs.getInt("id"));
						course.setCourse_id(rs.getString("course_id"));
						course.setCourse_name(rs.getString("course_name"));
					}
					
				}catch(SQLException e) {
					System.out.println("author getByCode err: "+e);
				}
				return course;
			}
			//GetNameByBookCode
			public List<Course> getCourseByStudentId(int id) {
//				Author author=null;//initially null
				List<Course> courses=new ArrayList<>();
				String sql="SELECT c.* FROM course c inner join student_has_course sc on c.id=sc.course_id where sc.student_id=?";
				try {
					PreparedStatement ps=con.prepareStatement(sql);
					ps.setInt(1, id);
					ResultSet rs=ps.executeQuery();
					while(rs.next()) {
						Course course=new Course();
						course.setId(rs.getInt("id"));
						course.setCourse_id(rs.getString("course_id"));
						course.setCourse_name(rs.getString("course_name"));
						courses.add(course);
					}
					
				}catch(SQLException e) {
					System.out.println("Course getCourseByStudentId err: "+e);
				}
				return courses;
			}
}
