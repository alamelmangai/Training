package com.cg.report.daoservices;
import java.util.List;
import com.cg.report.beans.Student;
import com.cg.report.beans.Subject;

public interface ReportCardDAOServices {
	
	int insertStudent(Student student);
	
	int insertSubject(int studentId,Subject subject);

	boolean updateStudent(Student student);

	boolean deleteStudent(int studentsId);

	Student getStudent(int studentId);
	
	Subject getSubject(int studentId,int subjectId);

	List<Student> getStudents();
	
	List<Subject> getSubjects(int studentId);

}

