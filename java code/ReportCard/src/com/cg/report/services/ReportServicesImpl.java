package com.cg.report.services;

import java.util.List;

import com.cg.report.beans.Address;
import com.cg.report.beans.Student;
import com.cg.report.beans.Subject;
import com.cg.report.daoservices.ReportCardDAOServices;
import com.cg.report.daoservices.ReportCardDAOServicesImpl;
import com.cg.report.exception.ReportServicesDownException;
import com.cg.report.exception.StudentNotFoundException;
import com.cg.report.exception.SubjectNotFoundException;
import com.cg.report.utilities.Utilities;

public class ReportServicesImpl implements ReportCardServices {
	private ReportCardDAOServices daoServices = new ReportCardDAOServicesImpl() ;
	@Override
	public int acceptStudentDetails(String firstName, String lastName, String stream, String emailId, String city,String state,int pincode,
			String dateOfBirth) throws ReportServicesDownException {
		return daoServices.insertStudent(new Student(new Address(pincode, city, state), firstName, lastName, stream, emailId, dateOfBirth));
		
		
	}
	public int acceptSubjectDetails(String subName,float mark, int studentId) throws SubjectNotFoundException{
		return daoServices.insertSubject(studentId, new Subject(mark, subName));
				}
	@Override
	public float markCalculation( int studentId) throws StudentNotFoundException,ReportServicesDownException {
		Student student = this.getStudentDetails(studentId);
		float total = 0;
		if(student!=null){
			for(Subject s:getAllSubjectDetails(studentId))
				total = s.getMark()+total;
			this.getStudentDetails(studentId).setTotMark(total);
			//this.getSubjectDetails(studentId, subjectId).setMark(total);
		float percentage=((total/(100*(Utilities.SUBJECT_ID_COUNTER-1)))*100);
			this.getStudentDetails(studentId).setPercentage(percentage);
			if(percentage==100){
				this.getStudentDetails(studentId).setGrade("S");
				getStudentDetails(studentId).setResult("Pass");
			}
			if(percentage>=90 && percentage<=99){
				this.getStudentDetails(studentId).setGrade("A");
				getStudentDetails(studentId).setResult("Pass");
			}
			if(percentage>=80 && percentage<=89){
				this.getStudentDetails(studentId).setGrade("B");
				getStudentDetails(studentId).setResult("Pass");
			}
			if(percentage>=70 && percentage<=79){
				this.getStudentDetails(studentId).setGrade("C");
				getStudentDetails(studentId).setResult("Pass");
			}
			if(percentage>=60 && percentage<=69){
				this.getStudentDetails(studentId).setGrade("D");
				getStudentDetails(studentId).setResult("Pass");
			}
			if(percentage<60){
				this.getStudentDetails(studentId).setGrade("E");
				getStudentDetails(studentId).setResult("Fail");
			}
			return total;
		}
		return 0;
	}
	@Override
	public Student getStudentDetails(int studentId) throws StudentNotFoundException, ReportServicesDownException {
		Object student;
		if(daoServices.getStudents()==null)
			throw new StudentNotFoundException("the studentn id is not present");
		return daoServices.getStudent(studentId);
	}

	@Override
	public Subject getSubjectDetails(int studentId, int subjectId)
			throws StudentNotFoundException, ReportServicesDownException,SubjectNotFoundException{
		if(daoServices.getStudent(subjectId)==null)
			throw new StudentNotFoundException("the studentn id is not present");
		if(daoServices.getSubject(studentId, subjectId)==null)
			throw new SubjectNotFoundException("Entered subject code is incorrect");
		return daoServices.getSubject(studentId, subjectId);
	}

	@Override
	public List<Student> getAllStudentDetails() throws ReportServicesDownException {
		daoServices.getStudents();
		return daoServices.getStudents();
	}

	@Override
	public List<Subject> getAllSubjectDetails(int studentId)
			throws ReportServicesDownException, StudentNotFoundException {
		if(daoServices.getStudents()==null)
			throw new StudentNotFoundException("the studentn id is not present");
		return daoServices.getSubjects(studentId);
	}

	@Override
	public boolean deleteStudent(int studentId) throws ReportServicesDownException, StudentNotFoundException {
		daoServices.deleteStudent(studentId);
		return false;
	}

	

}
