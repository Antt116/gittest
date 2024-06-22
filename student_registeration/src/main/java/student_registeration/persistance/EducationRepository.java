package student_registeration.persistance;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import student_registeration.models.Education;

public class EducationRepository {
	public static Connection con = null;
	static {
		con = MyConnection.getConnection();
	}

//	// create insert
//	public int add(Education edu) {
//		int result = 0;
//		String sql = "INSERT INTO education(id,edu_name) VALUES (?,?)";
//		try {
//			PreparedStatement ps = con.prepareStatement(sql);
//			ps.setInt(1, edu.getId());
//			ps.setString(2, edu.getEdu_name());
//			result = ps.executeUpdate();
//
//		} catch (SQLException e) {
//			result = 0;
//			System.out.println("Education insert err: " + e);
//		}
//		return result;
//	}
//
//	// update
//	public int edit(Education edu) {
//		int result = 0;
//		String sql = "UPDATE education SET edu_name=? WHERE id=?";
//		try {
//			PreparedStatement ps = con.prepareStatement(sql);
//			ps.setString(1, edu.getEdu_name());
//			ps.setInt(2, edu.getId());
//
//			result = ps.executeUpdate();
//		} catch (SQLException e) {
//			result = 0;
//			System.out.println("Education edit err: " + e);
//		}
//		return result;
//	}
//
//	// delete
//	public int delete(int id) {
//		int result = 0;
//		String sql = "DELETE FROM education WHERE id=?";
//		try {
//			PreparedStatement ps = con.prepareStatement(sql);
//			ps.setInt(1, id);
//			result = ps.executeUpdate();
//
//		} catch (SQLException e) {
//			result = 0;
//			System.out.println("Education delete err: " + e);
//		}
//		return result;
//	}

	// getAll
	public List<Education> getAll() {
		List<Education> educations = new ArrayList<>();
		String sql = "SELECT * FROM education";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Education education = new Education();
				education.setEid(rs.getInt("eid"));
				education.setEname(rs.getString("ename"));
				educations.add(education);
			}

		} catch (SQLException e) {
			System.out.println("Education selec err: " + e);
		}
		return educations;
	}

	// getByCode == getOne
	public Education getById(int eid) {
		Education education = null;// initially null
		String sql = "SELECT * FROM education WHERE eid=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, eid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				education = new Education();
				education.setEid(rs.getInt("eid"));
				education.setEname(rs.getString("ename"));
			}

		} catch (SQLException e) {
			System.out.println("author getByCode err: " + e);
		}
		return education;
	}

}
