package com.cg.report.daoservices;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.cg.report.beans.Student;
import com.cg.report.beans.Subject;
import com.cg.report.utilities.Utilities;

public class ReportCardDAOServicesImpl implements ReportCardDAOServices {
	public static HashMap<Integer,Student> students = new HashMap<>();
	@Override
	public int insertStudent(Student student) {
		student.setStudentId(Utilities.STUDENT_ID_COUNTER++);
		students.put(student.getStudentId(), student);
		return student.getStudentId();
	}

	@Override
	public int insertSubject(int studentId,Subject subject) {
		students.get(studentId).getSubjects().put( Utilities.SUBJECT_ID_COUNTER, subject);
		students.get(studentId).getSubjects().get(Utilities.SUBJECT_ID_COUNTER).setSubjectId(Utilities.SUBJECT_ID_COUNTER++);
		return students.get(studentId).getSubjects().get(subject.getSubjectId()).getSubjectId();
	}

	@Override
	public boolean updateStudent(Student student) {
		if(students.containsKey(student.getStudentId())==true)
			students.put(student.getStudentId(), student);
		student.setStudentId(student.getStudentId());
		return false;
	}

	@Override
	public boolean deleteStudent(int studentId) {
		students.remove(studentId);
		return true;
	}

	@Override
	public Student getStudent(int studentId) {
		return students.get(studentId);
	}

	@Override
	public Subject getSubject(int studentId,int subjectId) {
		return students.get(studentId).getSubjects().get(subjectId);
	}
	@Override
	public List<Student> getStudents() {
		List<Student> studentList = new ArrayList<Student>(students.values());
		return studentList;
	}

	@Override
	public List<Subject> getSubjects(int studentId) {
		List<Subject> subjectList = new ArrayList<Subject>(students.get(studentId).getSubjects().values());
		return subjectList;
	}

}
