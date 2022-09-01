import java.util.ArrayList;

public interface Student {
	public void saveStudent(StudentDao student);
	public ArrayList<StudentDao> getStudentList(); 
}
