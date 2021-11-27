package application;

public class ParkingRequestStatusInitializer {
	private String serialNo,vehicleType,licenceNo,status,duePayment;
	public ParkingRequestStatusInitializer(String serialNo,String vehicleType,String licenceNo,String status,String duePayment) {
		this.serialNo=serialNo;
		this.vehicleType=vehicleType;
		this.licenceNo=licenceNo;
		this.status=status;
		this.duePayment=duePayment;
	}
	public void setDuePayment(String duePayment) {
		this.duePayment = duePayment;
	}
	public void setLicenceNo(String licenceNo) {
		this.licenceNo = licenceNo;
	}
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public String getDuePayment() {
		return duePayment;
	}
	public String getLicenceNo() {
		return licenceNo;
	}
	public String getSerialNo() {
		return serialNo;
	}
	public String getStatus() {
		return status;
	}
	public String getVehicleType() {
		return vehicleType;
	}
}
