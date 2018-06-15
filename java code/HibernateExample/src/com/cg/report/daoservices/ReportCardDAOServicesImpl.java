package com.cg.report.daoservices;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.report.beans.Student;
import com.cg.report.beans.Subject;
import com.cg.report.utilities.Utilities;
@Component("ReportDAOServices")
public class ReportCardDAOServicesImpl implements ReportCardDAOServices {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int insertStudent(Student student) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSubject(int studentId, Subject subject) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean updateStudent(Student student) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteStudent(int studentsId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Student getStudent(int studentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Subject getSubject(int studentId, int subjectId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> getStudents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Subject> getSubjects(int studentId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
