package com.cg.report.services;
import java.util.List;

import com.cg.report.beans.Address;
import com.cg.report.beans.Student;
import com.cg.report.beans.Subject;
import com.cg.report.exception.ReportServicesDownException;
import com.cg.report.exception.StudentNotFoundException;
import com.cg.report.exception.SubjectNotFoundException;
public interface ReportCardServices {
	int acceptStudentDetails(String firstName,String lastName,String stream,
			String emailId,String city,String state,int pincode,String dateOfBirth)throws ReportServicesDownException;

	float markCalculation(int studentId)throws StudentNotFoundException, ReportServicesDownException;
	
	Student getStudentDetails(int studentId) throws StudentNotFoundException,ReportServicesDownException;
	
	Subject getSubjectDetails(int studentId,int subjectId) throws StudentNotFoundException,ReportServicesDownException,SubjectNotFoundException;
	
	List<Student> getAllStudentDetails()throws ReportServicesDownException;
	
	List<Subject> getAllSubjectDetails(int studentId)throws ReportServicesDownException,StudentNotFoundException;
	
	boolean deleteStudent(int studentId)throws ReportServicesDownException, StudentNotFoundException;

}

