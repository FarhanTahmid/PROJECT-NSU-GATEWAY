package application;

public class AdminParkingSpotInitializer {
	private String studentID,vehicleType,licencePlateID,duePayment;
	public AdminParkingSpotInitializer(String studentID,String vehicleType,String licencePlateID,String duePayment) {
		this.studentID=studentID;
		this.vehicleType=vehicleType;
		this.licencePlateID=licencePlateID;
		this.duePayment=duePayment;
	}
	public void setDuePayment(String duePayment) {
		this.duePayment = duePayment;
	}
	public void setLicencePlateID(String licencePlateID) {
		this.licencePlateID = licencePlateID;
	}
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public String getDuePayment() {
		return duePayment;
	}
	
	public String getLicencePlateID() {
		return licencePlateID;
	}
	public String getStudentID() {
		return studentID;
	}
	public String getVehicleType() {
		return vehicleType;
	}
}
