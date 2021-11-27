package application;

public class CGPACalculatorInitializer {
	private String course,credit,grade;
	CGPACalculatorInitializer(){
		
	}
	public CGPACalculatorInitializer(String course,String credit,String grades) {
		this.course=course;
		this.credit=credit;
		this.grade=grades;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public void setCredit(String credit) {
		this.credit = credit;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getCourse() {
		return course;
	}
	public String getCredit() {
		return credit;
	}
	public String getGrade() {
		return grade;
	}
	

}
