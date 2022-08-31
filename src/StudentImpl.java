import java.sql.PreparedStatement;

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
	
}
