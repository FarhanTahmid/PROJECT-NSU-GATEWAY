package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class StudentParkingRequestStatusController implements Initializable{

    @FXML
    private TableView<ParkingRequestStatusInitializer> studentPArkingrequestTable;

    @FXML
    private TableColumn<ParkingRequestStatusInitializer, String> studnetParkingserialcolumn;

    @FXML
    private TableColumn<ParkingRequestStatusInitializer, String> studentParkingVehicleType;

    @FXML
    private TableColumn<ParkingRequestStatusInitializer, String> studentParkingLicenseType;

    @FXML
    private TableColumn<ParkingRequestStatusInitializer, String> studentPArkingStatis;

    @FXML
    private TableColumn<ParkingRequestStatusInitializer, String> studentPArkingDue;

    @FXML
    private Button homeButton;

    @FXML
    private Button payPArkingFee;
    private Stage stage;
    Parent root;
    Scene scene;
    @FXML
    void goHome(ActionEvent event) {
    	stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		stage.close();
    }
    private double parkingFee;
    public StudentParkingRequestStatusController() {
    	
    }
    public StudentParkingRequestStatusController(double parkingFee) {
		super();
		this.parkingFee = parkingFee;
	}
    public void setParkingFee(double parkingFee) {
		this.parkingFee = parkingFee;
	}
    public double getParkingFee() {
		return parkingFee;
	}


    static double ParkingFee;
	@FXML
    void payParkingFee(ActionEvent event) throws IOException {
    	ParkingRequestStatusInitializer getdata;
    	getdata=this.studentPArkingrequestTable.getSelectionModel().getSelectedItem();
    	for(int i=0;i<parkingrequest.size();i++) {
    		parkingFee=(Double.parseDouble(parkingrequest.get(i).getDuePayment()));
    	}
    	FXMLLoader loader=new FXMLLoader(getClass().getResource("NSUBankAccountWindow.fxml"));
    	root=loader.load();
    	StudentBankWindow controller=loader.getController();
    	controller.findingInfo(parkingStudentID);
    	StudentParkingRequestStatusController.ParkingFee=this.parkingFee;
    	controller.showServicePaymentInfo(String.valueOf(StudentParkingRequestStatusController.ParkingFee));
    	scene=new Scene(root);
    	stage=(Stage)((Node)event.getSource()).getScene().getWindow();
    	stage.setScene(scene);
    	stage.show();
    			
	}
   
    static Scanner reader3;
    static Scanner reader4;
    static Scanner reader5;
    String adminAcceptedFilepath="src//Admin Files//parkingaccepted.csv";
    String adminRejectedFilepath="src//Admin Files//parkingrejected.csv";
    
    String parkingStudentID="";
    String parkingVehicleType="";
    String parkingLicenseType="";
    String parkingStatus="";
    String parkingPayment="";
    
    String adminAcceptParkingStudentID="";
    String adminAcceptParkingVehicleType="";
    String adminAcceptParkingLicenseType="";
    String adminAcceptParkingPayment="";
    
    public void adminAcceptedInitializer() throws FileNotFoundException {
    	reader3=new Scanner(new File(adminAcceptedFilepath));
    	reader3.useDelimiter("[,\n]");
    	while (reader3.hasNext()) {
			adminAcceptParkingStudentID=reader3.next();
			adminAcceptParkingVehicleType=reader3.next();
			adminAcceptParkingLicenseType=reader3.next();
			adminAcceptParkingPayment=reader3.next();
			
		}
    	reader3.close();
    	
    }
    
    String adminRejectParkingStudentID="";
    String adminRejectParkingVehicleType="";
    String adminRejectParkingLicenseType="";
    String adminRejectParkingPayment="";
    
    public void adminRejectedInitializer() throws FileNotFoundException {
    	reader4=new Scanner(new File(adminRejectedFilepath));
    	reader4.useDelimiter("[,\n]");
    	while(reader4.hasNext()) {
    		adminRejectParkingStudentID=reader4.next();
    		adminRejectParkingVehicleType=reader4.next();
    		adminRejectParkingLicenseType=reader4.next();
    	}
    	reader4.close();
    	
    }
    String parkingFilePath="src//StudentCoursesHistory//parkingfiles.csv";
    static ObservableList<ParkingRequestStatusInitializer>parkingrequest=FXCollections.observableArrayList();
    String serialNo="";
    
    public void initializer() throws FileNotFoundException {
			reader5=new Scanner(new File(parkingFilePath));
			
			reader5.useDelimiter("[,\n]");
			
			int i=0;
			while(reader5.hasNext()) {
				
				try{
					parkingStudentID=reader5.next();
					parkingVehicleType=reader5.next();
					parkingLicenseType=reader5.next();
					parkingPayment=reader5.next();
					serialNo=""+(i+1);
					if(adminAcceptParkingStudentID.equals(StudentLoggedInController.staticID)) {
						this.parkingStatus="Accepted";
					}
					else if(adminRejectParkingStudentID.equals(StudentLoggedInController.staticID)) {
						this.parkingStatus="Rejected";
						this.parkingPayment="0";
					}
					else {
						this.parkingStatus="Not Yet Decided";
						this.parkingPayment="0";
					}
					parkingrequest.add(new ParkingRequestStatusInitializer(serialNo, parkingVehicleType, parkingLicenseType, parkingStatus, parkingPayment));
					i++;
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
    }
    
    
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
			
			this.studnetParkingserialcolumn.setCellValueFactory(new PropertyValueFactory<ParkingRequestStatusInitializer,String>("serialNo"));
			this.studentParkingVehicleType.setCellValueFactory(new PropertyValueFactory<ParkingRequestStatusInitializer,String>("vehicleType"));
			this.studentParkingLicenseType.setCellValueFactory(new PropertyValueFactory<ParkingRequestStatusInitializer,String>("licenceNo"));
			this.studentPArkingStatis.setCellValueFactory(new PropertyValueFactory<ParkingRequestStatusInitializer,String>("status"));
			this.studentPArkingDue.setCellValueFactory(new PropertyValueFactory<ParkingRequestStatusInitializer,String>("duePayment"));
			this.studentPArkingrequestTable.setItems(parkingrequest);
			
		
				
		
		
		
	}
}