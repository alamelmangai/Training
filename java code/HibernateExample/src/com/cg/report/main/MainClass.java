package com.cg.report.main;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import com.cg.report.beans.Student;
import com.cg.report.beans.Subject;
import com.cg.report.exception.InvalidMarkException;
import com.cg.report.exception.ReportServicesDownException;
import com.cg.report.exception.StudentNotFoundException;
import com.cg.report.exception.SubjectNotFoundException;
import com.cg.report.services.ReportCardServices;
import com.cg.report.services.ReportServicesImpl;

public class MainClass{
	public static void main(String[] args){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("projectbeans.xml");
		ReportCardServices reportServices = (ReportCardServices) applicationContext.getBean("ReportCardServices");
	}
}

	/*private static int studentId6;

	public static void main(String[] args) throws ReportServicesDownException {
		try {
			ReportServicesImpl reportServices = new ReportServicesImpl();
			int studentId;
			int key=0;
			Scanner sc=new Scanner(System.in);
			while(key!=9){
				System.out.println("Enter 1 : Insert New student"+"\n"+
						//"2 : update student Details"+"\n"+
						"2 : To get student Details "+"\n"+
						"3 : To get  All student Details/"+"\n"+
						"4 : To get subject Details"+"\n"+
						"5 : To get  All subject Details of student/"+"\n"+
						"6 : To get result of student"+"\n"+
						"7 : To delete an studentRecord"+"\n"+
						"8 : Insert subject detail"+"\n"+
						"9: Exit");
				key=sc.nextInt();
				switch (key) {
				case 1: System.out.println("enter first Name");
				String firstName=sc.next();
				System.out.println("enter last Name");
				String lastName=sc.next();
				System.out.println("enter stream");
				String stream=sc.next();
				System.out.println("\t Enter student Address:");
				System.out.print("\t Enter City : ");
				String city = sc.next();
				System.out.print("\t Enter State : ");
				String state = sc.next();
				System.out.print("\t Enter PINCODE: ");
				int pincode = sc.nextInt();
				System.out.println("enter dateOfBirth");
				String dateOfBirth=sc.next();
				System.out.println("enter EmailId");
				String emailId=sc.next();
				int stdId = reportServices.acceptStudentDetails(firstName, lastName, stream, emailId, city, state, pincode, dateOfBirth);
				System.out.println("Your studentId is : "+stdId);
				break;
				case 2:System.out.println("enter studentId");
				int studentId1 = sc.nextInt();
				Student stdDetail = reportServices.getStudentDetails(studentId1);
				System.out.println("The student Details are: "+stdDetail);
				break;
				case 3:
					List<Student> student = reportServices.getAllStudentDetails();
					System.out.println("All Student Details: "+student);
					break;
				case 4:System.out.println("enter studentId");
				int studentId2 = sc.nextInt();
				System.out.println("enter sId");
				int subjectId1 = sc.nextInt();
				Subject subDetail = reportServices.getSubjectDetails(studentId2, subjectId1);
				System.out.println("The subject Details are: "+subDetail);
				break;
				case 5:System.out.println("enter studentId");
				int studentId3 = sc.nextInt();
					List<Subject> sub = reportServices.getAllSubjectDetails(studentId3);
					System.out.println("All Subject Details: "+sub);
					break;
				case 6:System.out.println("enter the studentId");
				int studentId21 = sc.nextInt();
				float mark = reportServices.markCalculation(studentId21);
				System.out.println("your total mark is:"+mark);
				float perc = reportServices.getStudentDetails(studentId21).getPercentage();
				System.out.println("your percentage is:"+perc);
			    String grade1 =  reportServices.getStudentDetails(studentId21).getGrade();
			    System.out.println("your grade is:"+grade1);
			    break;
				case 8:
				for(int i=1;i<=6;i++){	
				System.out.println("enter the studentId");
				int studentI6 = sc.nextInt();
				System.out.println("enter the subject name");
				String subName=sc.next();
				System.out.println("enter the mark");
				float mark10=sc.nextFloat();
				int subId = reportServices.acceptSubjectDetails(subName, mark10, studentId6);
				System.out.println("Your subjectId is : "+subId);
				}
				case 9:
					System.out.println("You are go to Exit,Thank You!!!");
					break;
				default:
					System.out.println("Please Enter Valid Option!!!");
					break;
				}
			}
			}catch(StudentNotFoundException e){
				e.printStackTrace();
			}catch(SubjectNotFoundException e){
				e.printStackTrace();
			}catch(ReportServicesDownException e){
				e.printStackTrace();
			}
	}
}
				
package com.cg.report.main;

import java.util.List;
import java.util.Scanner;

import javax.security.auth.Subject;

import com.cg.report.beans.Student;
import com.cg.report.exception.InvalidMarkException;
import com.cg.report.exception.ReportServicesDownException;
import com.cg.report.exception.StudentNotFoundException;
import com.cg.report.exception.SubjectNotFoundException;
import com.cg.report.services.ReportServicesImpl;

public class MainClass {
	public static void main(String[] args) {
		ReportServicesImpl reportServices = new ReportServicesImpl();
		int choice=0;
		do {
			Scanner sc = new Scanner(System.in);
			try {
				System.out.println("Enter 1 : Insert New student"+"\n"+
						//"2 : update student Details"+"\n"+
						"2 : To get student Details "+"\n"+
						"3 : To get  All student Details/"+"\n"+
						"4 : To get subject Details"+"\n"+
						"5 : To get  All subject Details of student/"+"\n"+
						"6 : To get result of student"+"\n"+
						"7 : To delete an studentRecord"+"\n"+
						"8: Exit");
				choice=sc.nextInt();
				switch (choice) {
				case 1: System.out.println("enter first Name");
				String firstName=sc.next();
				System.out.println("enter last Name");
				String lastName=sc.next();
				System.out.println("enter stream");
				String stream=sc.next();
				System.out.println("\t Enter student Address:");
				System.out.print("\t Enter City : ");
				String city = sc.next();
				System.out.print("\t Enter State : ");
				String state = sc.next();
				System.out.print("\t Enter PINCODE: ");
				int pincode = sc.nextInt();
				System.out.println("enter dateOfBirth");
				String dateOfBirth=sc.next();
				System.out.println("enter EmailId");
				String emailId=sc.next();
				int stdId = reportServices.acceptStudentDetails(firstName, lastName, stream, emailId, city, state, pincode, dateOfBirth);
				System.out.println("Your studentId is : "+stdId);
				break;
				case 2:System.out.println("enter studentId");
				int studentId1 = sc.nextInt();
				Student stdDetail = reportServices.getStudentDetails(studentId1);
				System.out.println("The student Details are: "+stdDetail);
				break;
				case 3:
					List<Student> student = reportServices.getAllStudentDetails();
					System.out.println("All Student Details: "+student);
					break;
				case 4:System.out.println("enter studentId");
				int subjectId1 = sc.nextInt();
				Subject subDetail = reportServices.getSubjectDetails(studentId1, subjectId1));
				System.out.println("The subject Details are: "+stdDetail);
				break;
				case 5:
					List<Subject> sub = reportServices.getAllSubjectDetails(studentId1);
					System.out.println("All Subject Details: "+sub);
					break;
				case 6:System.out.println("enter the studentId");
				int studentId2 = sc.nextInt();
				float mark = reportServices.markCalculation(studentId2);
				System.out.println("your total mark is:"+mark);
				float perc = reportServices.getStudentDetails(studentId2).getPercentage();
				System.out.println("your percentage is:"+perc);
			    String grade1 =  reportServices.getStudentDetails(studentId2).getGrade();
			    System.out.println("your grade is:"+grade1);
			    break;
				case 8:
					System.out.println("You are go to Exit,Thank You!!!");
					break;
				default:
					System.out.println("Please Enter Valid Option!!!");
					break;
				}
			}catch(StudentNotFoundException e){
				e.printStackTrace();
			}catch(SubjectNotFoundException e){
				e.printStackTrace();
			}catch(InvalidMarkException e){
				e.printStackTrace();
			}catch(ReportServicesDownException e){
				e.printStackTrace();
			}

		}while(choice != 8);
	}
}			*/
				
				
					


