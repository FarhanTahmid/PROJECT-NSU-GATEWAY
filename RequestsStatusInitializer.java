package application;

public class RequestsStatusInitializer {
	private String studentID,courseInitial,facultyInitial,section,status;
	RequestsStatusInitializer(String studentId,String courseInitial,String facultyInitial,String section,String status){
		this.studentID=studentId;
		this.courseInitial=courseInitial;
		this.facultyInitial=facultyInitial;
		this.section=section;
		this.status=status;
	}
	public void setCourseInitial(String courseInitial) {
		this.courseInitial = courseInitial;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public void setFacultyInitial(String facultyInitial) {
		this.facultyInitial = facultyInitial;
	}
	public void setStatus(String status) {
		this.status = status;
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
	public String getStatus() {
		return status;
	}
	public String getStudentID() {
		return studentID;
	}
	
}
