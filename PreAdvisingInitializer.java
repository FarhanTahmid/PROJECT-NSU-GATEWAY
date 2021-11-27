package application;

import javafx.scene.control.Button;


public class PreAdvisingInitializer {
	private String serialNo,courseInitial,courseCredit,courseTitle,rootDepartment,time,section,faculty;
	private String fee;
	PreAdvisingInitializer(){
		
	}
	
	PreAdvisingInitializer(String serialNo,String courseInitial,String courseCredit,String courseTitle,String rootDepartment,String time,String section,String faculty){
		this.serialNo=serialNo;
		this.courseInitial=courseInitial;
		this.courseCredit=courseCredit;
		this.courseTitle=courseTitle;
		this.rootDepartment=rootDepartment;
		this.faculty=faculty;
		this.time=time;
		this.section=section;
		
	}
	
	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public void setCourseCredit(String courseCredit) {
		this.courseCredit = courseCredit;
	}
	public void setCourseInitial(String courseInitial) {
		this.courseInitial = courseInitial;
	}
	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}
	public void setRootDepartment(String rootDepartment) {
		this.rootDepartment = rootDepartment;
	}
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}
	
	public String getCourseCredit() {
		return courseCredit;
	}
	public String getCourseInitial() {
		return courseInitial;
	}
	public String getCourseTitle() {
		return courseTitle;
	}
	public String getRootDepartment() {
		return rootDepartment;
	}
	public String getSerialNo() {
		return serialNo;
	}
	public String getFaculty() {
		return faculty;
	}
	public String getSection() {
		return section;
	}
	public String getTime() {
		return time;
	}
	
	public String getFee() {
		double credit=Double.parseDouble(getCourseCredit());
		double fee=credit*6500;
		return String.valueOf(fee);
	}
}
