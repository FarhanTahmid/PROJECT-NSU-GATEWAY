package application;

import java.time.LocalDate;

public class AdminStudentDatabaseInitializer {
	private String studentID,studentName,studentDepartment,studentCurrentCurriculum,enrollmentSemester;
	
	public AdminStudentDatabaseInitializer() {
		
	}
	public AdminStudentDatabaseInitializer(String ID,String name,String department,String currentCurriculum, String enrollmentSemester){
		this.studentID=ID;
		this.studentName=name;
		this.studentDepartment=department;
		this.studentCurrentCurriculum=currentCurriculum;
		this.enrollmentSemester=enrollmentSemester;
	}
	private String newStudentID,newStudentName,newStudentDepartment,newStudentCourseCurriculum,newStudentSemester,
	newStudentNationalit,newStudentMail,newStudentContactNo,newStudentAddress;
	private String newStudentBirthDate;
	public AdminStudentDatabaseInitializer(String newStudentID,String newStudentName,String newStudentDepartment,String newStudentCourseCurriculum,String newStudentSemester,String 
			newStudentNationalit,String newStudentBirthDate,String newStudentMail,String newStudentContactNo,String newStudentAddress
			) {
		this.newStudentID=newStudentID;
		this.newStudentName=newStudentName;
		this.newStudentDepartment=newStudentDepartment;
		this.newStudentCourseCurriculum=newStudentCourseCurriculum;
		this.newStudentAddress=newStudentAddress;
		this.newStudentBirthDate=newStudentBirthDate;
		this.newStudentContactNo=newStudentContactNo;
		this.newStudentMail=newStudentMail;
		this.newStudentNationalit=newStudentNationalit;
		this.newStudentSemester=newStudentSemester;
		
		
	}
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	public void setEnrollmentSemester(String enrollmentSemester) {
		this.enrollmentSemester = enrollmentSemester;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public void setStudentDepartment(String studentDepartment) {
		this.studentDepartment = studentDepartment;
	}
	public void setStudentCurrentCurriculum(String studentCurrentCurriculum) {
		this.studentCurrentCurriculum = studentCurrentCurriculum;
	}
	public String getStudentCurrentCurriculum() {
		return studentCurrentCurriculum;
	}
	public String getStudentDepartment() {
		return studentDepartment;
	}
	public String getStudentID() {
		return studentID;
	}
	public String getStudentName() {
		return studentName;
	}
	public String getEnrollmentSemester() {
		return enrollmentSemester;
	}
	
	
	
	
	public void setNewStudentAddress(String newStudentAddress) {
		this.newStudentAddress = newStudentAddress;
	}
	public void setNewStudentBirthDate(String newStudentBirthDate) {
		this.newStudentBirthDate = newStudentBirthDate;
	}
	public void setNewStudentContactNo(String newStudentContactNo) {
		this.newStudentContactNo = newStudentContactNo;
	}
	public void setNewStudentCourseCurriculum(String newStudentCourseCurriculum) {
		this.newStudentCourseCurriculum = newStudentCourseCurriculum;
	}public void setNewStudentDepartment(String newStudentDepartment) {
		this.newStudentDepartment = newStudentDepartment;
	}
	public void setNewStudentID(String newStudentID) {
		this.newStudentID = newStudentID;
	}
	public void setNewStudentMail(String newStudentMail) {
		this.newStudentMail = newStudentMail;
	}
	public void setNewStudentName(String newStudentName) {
		this.newStudentName = newStudentName;
	}
	public void setNewStudentNationalit(String newStudentNationalit) {
		this.newStudentNationalit = newStudentNationalit;
	}
	public void setNewStudentSemester(String newStudentSemester) {
		this.newStudentSemester = newStudentSemester;
	}
	public String getNewStudentAddress() {
		return newStudentAddress;
	}
	public String getNewStudentBirthDate() {
		return newStudentBirthDate;
	}
	public String getNewStudentContactNo() {
		return newStudentContactNo;
	}
	public String getNewStudentCourseCurriculum() {
		return newStudentCourseCurriculum;
	}
	public String getNewStudentDepartment() {
		return newStudentDepartment;
	}
	public String getNewStudentID() {
		return newStudentID;
	}
	public String getNewStudentMail() {
		return newStudentMail;
	}
	public String getNewStudentName() {
		return newStudentName;
	}
	public String getNewStudentNationalit() {
		return newStudentNationalit;
	}
	public String getNewStudentSemester() {
		return newStudentSemester;
	}
	
	private String facultyID,facultyName,FacultyDesignation,facultyDepartment,facultyOFffice,facultyemail;
	public AdminStudentDatabaseInitializer(String facultyId,String facultyname,String designation,String department,String office,String email){
		this.facultyID=facultyId;
		this.facultyName=facultyname;
		this.FacultyDesignation=designation;
		this.facultyDepartment=department;
		this.facultyOFffice=office;
		this.facultyemail=email;
	}
	public void setFacultyDepartment(String facultyDepartment) {
		this.facultyDepartment = facultyDepartment;
	}
	public void setFacultyDesignation(String facultyDesignation) {
		FacultyDesignation = facultyDesignation;
	}
	public void setFacultyemail(String facultyemail) {
		this.facultyemail = facultyemail;
	}
	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}
	public void setFacultyID(String facultyID) {
		this.facultyID = facultyID;
	}
	public void setFacultyOFffice(String facultyOFffice) {
		this.facultyOFffice = facultyOFffice;
	}
	public String getFacultyDepartment() {
		return facultyDepartment;
	}
	public String getFacultyDesignation() {
		return FacultyDesignation;
	}
	public String getFacultyemail() {
		return facultyemail;
	}
	public String getFacultyID() {
		return facultyID;
	}
	public String getFacultyName() {
		return facultyName;
	}
	public String getFacultyOFffice() {
		return facultyOFffice;
	}
	
	
}

