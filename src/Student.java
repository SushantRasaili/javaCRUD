import java.util.ArrayList;

public interface Student {
	public void saveStudent(StudentDao student);
	
	public ArrayList<StudentDao> getStudentList();
	
	public void deleteStudentInfo(int id);
	
	public ArrayList<StudentDao> searchName(String name);
	
}
