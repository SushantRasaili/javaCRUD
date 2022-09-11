import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentImpl implements Student{
	
	PreparedStatement ps = null;

	@Override
	public void saveStudent(StudentDao student) {
	String sql = "insert into studentform(firstname,lasname,address,class,gender,section,contacts) VALUES(?,?,?,?,?,?,?)";
		
		try {
			ps = DatabaseCon.getConnection().prepareStatement(sql);
			ps.setString(1, student.getFirstName());
			ps.setString(2, student.getLastName());
			ps.setString(3, student.getAddress());
			ps.setString(4, student.getGrade());
			ps.setString(5, student.getGender());
			ps.setString(6, student.getSection());
			ps.setLong(7, student.getContactNumber());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<StudentDao> getStudentList() {
		ArrayList<StudentDao> studentList = new ArrayList<StudentDao>();
		 String sql = "select * from studentform";
		 
		 try {
			ps = DatabaseCon.getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				StudentDao studentDao = new StudentDao();
				studentDao.setId(rs.getInt("id"));
				studentDao.setFirstName(rs.getString("firstname"));
				studentDao.setLastName(rs.getString("lasname"));
				studentDao.setAddress(rs.getString("address"));
				studentDao.setGrade(rs.getString("class"));
				studentDao.setGender(rs.getString("gender"));
				studentDao.setSection(rs.getString("section"));
				studentDao.setContactNumber(rs.getLong("contacts"));
				
				studentList.add(studentDao);		
			}
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return studentList;
	}

	@Override
	public void deleteStudentInfo(int id) {
     String sql = "delete from studentform where id=?";		
     try {
		ps = DatabaseCon.getConnection().prepareStatement(sql);
		ps.setInt(1, id);
		ps.executeUpdate();
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
 	   
	}

	@Override
	public ArrayList<StudentDao> searchName(String name) {
		ArrayList<StudentDao> studentList = new ArrayList<StudentDao>();
		
		String sql = "select * from studentform where firstname like ?";
		try {
			ps = DatabaseCon.getConnection().prepareStatement(sql);
			ps.setString(1, "%"+name+"%");
			
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				StudentDao studentDao = new StudentDao();
				studentDao.setId(rs.getInt("id"));
				studentDao.setFirstName(rs.getString("firstname"));
				studentDao.setLastName(rs.getString("lasname"));
				studentDao.setAddress(rs.getString("address"));
				studentDao.setGrade(rs.getString("class"));
				studentDao.setGender(rs.getString("gender"));
				studentDao.setSection(rs.getString("section"));
				studentDao.setContactNumber(rs.getLong("contacts"));
				
				studentList.add(studentDao);		
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		return studentList;
	}
	
}
