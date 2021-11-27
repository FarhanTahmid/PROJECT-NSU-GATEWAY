package application;

public class CourseStudentListInfo {
	protected String serialNumber;
	protected String initializerID;
	protected String initializerName;
	protected String email;
	CourseStudentListInfo(String serialnumber,String id,String name,String email){
		this.serialNumber=serialnumber;
		this.initializerID=id;
		this.initializerName=name;
		this.email=email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setInitializerID(String initializerID) {
		this.initializerID = initializerID;
	}
	public void setInitializerName(String initializerName) {
		this.initializerName = initializerName;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getEmail() {
		return email;
	}
	public String getInitializerID() {
		return initializerID;
	}
	public String getInitializerName() {
		return initializerName;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
}
