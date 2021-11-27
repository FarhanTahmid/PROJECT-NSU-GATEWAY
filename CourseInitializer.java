package application;

public class CourseInitializer {
	private String Serialno,courseInitial,facultyInitial,section,time,grades;
	
	public CourseInitializer(String Serialno,String courseInitial,String facultyInitial,String section,String time,String grades) {
		this.Serialno=Serialno;
		this.courseInitial=courseInitial;
		this.facultyInitial=facultyInitial;
		this.section=section;
		this.time=time;
		this.grades=grades;
	}
	public void setCourseInitial(String courseInitial) {
		this.courseInitial = courseInitial;
	}
	public void setFacultyInitial(String facultyInitial) {
		this.facultyInitial = facultyInitial;
	}
	public void setGrades(String grades) {
		this.grades = grades;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public void setSerialno(String serialno) {
		Serialno = serialno;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	public String getCourseInitial() {
		return courseInitial;
	}
	public String getFacultyInitial() {
		return facultyInitial;
	}
	public String getGrades() {
		return grades;
	}
	public String getSection() {
		return section;
	}
	public String getSerialno() {
		return Serialno;
	}
	public String getTime() {
		return time;
	}
}
