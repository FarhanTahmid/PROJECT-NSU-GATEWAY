package application;

public class AdminCourseDropInitializer {
	private String studentID,courseInitial,facultyInitial,section;
	public AdminCourseDropInitializer(String studentID,String courseInitial,String facultyInitial,String section) {
		this.studentID=studentID;
		this.courseInitial=courseInitial;
		this.facultyInitial=facultyInitial;
		this.section=section;
	}
	public void setCourseInitial(String courseInitial) {
		this.courseInitial = courseInitial;
	}
	public void setFacultyInitial(String facultyInitial) {
		this.facultyInitial = facultyInitial;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	public String getCourseInitial() {
		return courseInitial;
	}
	public String getFacultyInitial() {
		return facultyInitial;
	}
	public String getSection() {
		return section;
	}
	public String getStudentID() {
		return studentID;
	}
}
