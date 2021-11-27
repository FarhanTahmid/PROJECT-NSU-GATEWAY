package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;



import javafx.beans.value.WritableBooleanValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class AdminParkingSpotController implements Initializable {
	@FXML
    private TableView<AdminParkingSpotInitializer> AdminparkingTAble;

    @FXML
    private TableColumn<AdminParkingSpotInitializer, String> parkingStudentID;

    @FXML
    private TableColumn<AdminParkingSpotInitializer, String> parkingVehicleType;

    @FXML
    private TableColumn<AdminParkingSpotInitializer, String> parkingLicenseType;

    @FXML
    private TableColumn<AdminParkingSpotInitializer, String> parkingPAymentDue;

    @FXML
    private Button acceptButton;

    @FXML
    private Button rejectButton;

    @FXML
    private Button homeButton;
    private Stage stage;
    @FXML
    void goHome(ActionEvent event) {
    	stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		stage.close();
    }
    AdminParkingSpotInitializer datafromButton;
    final ObservableList<AdminParkingSpotInitializer>acceptedreq=FXCollections.observableArrayList();
    final ObservableList<AdminParkingSpotInitializer>rejectedData=FXCollections.observableArrayList();
    
    String parkingAcepptedFile="src//Admin Files//parkingaccepted.csv";
   
    
    
    String parkingRejectedFile="src//Admin Files//parkingrejected.csv";
    
    PrintWriter writer;
    @FXML
    void accept(ActionEvent event) {
    	datafromButton=this.AdminparkingTAble.getSelectionModel().getSelectedItem();
    	acceptedreq.add(new AdminParkingSpotInitializer(datafromButton.getStudentID(), datafromButton.getVehicleType(), datafromButton.getLicencePlateID(), datafromButton.getDuePayment()));
    	try {
			writer=new PrintWriter(parkingAcepptedFile);
			for(int i=0;i<acceptedreq.size();i++) {
				writer.append(acceptedreq.get(i).getStudentID());
				writer.append(",");
				writer.append(acceptedreq.get(i).getVehicleType());
				writer.append(",");
				writer.append(acceptedreq.get(i).getLicencePlateID());
				writer.append(",");
				writer.append(acceptedreq.get(i).getDuePayment());
				writer.append("\n");
			}
			writer.flush();
			writer.close();
    	} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    PrintWriter writer2;
    @FXML
    void rejectButton(ActionEvent event) {
    	
    	datafromButton=this.AdminparkingTAble.getSelectionModel().getSelectedItem();
    	rejectedData.add(new AdminParkingSpotInitializer(datafromButton.getStudentID(), datafromButton.getVehicleType(), datafromButton.getLicencePlateID(), datafromButton.getDuePayment()));
    	
    	try {
			writer2=new PrintWriter(parkingRejectedFile);
			for(int i=0;i<rejectedData.size();i++) {
				writer2.append(rejectedData.get(i).getStudentID());
				writer2.append(",");
				writer2.append(rejectedData.get(i).getVehicleType());
				writer2.append(",");
				writer2.append(rejectedData.get(i).getLicencePlateID());
				//writer2.append(",");
				//writer2.append(rejectedData.get(i).getDuePayment());
				writer2.append("\n");
			}
			writer2.flush();
			writer2.close();
    	} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    	System.out.println("Clicked");

    }
    final ObservableList<AdminParkingSpotInitializer>parkingData=FXCollections.observableArrayList();
    
    static Scanner reader;
    String studentID="";
    String vehicleType="";
    String license="";
    String duePayment="";
	
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
    	try {
			reader=new Scanner(new File("src//StudentCoursesHistory//parkingfiles.csv"));
			reader.useDelimiter("[,\n]");
			while (reader.hasNext()) {
				studentID=reader.next();
				vehicleType=reader.next();
				license=reader.next();
				duePayment=reader.next();
				parkingData.add(new AdminParkingSpotInitializer(studentID, vehicleType, license, duePayment));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	this.parkingStudentID.setCellValueFactory(new PropertyValueFactory<AdminParkingSpotInitializer,String>("studentID"));
    	this.parkingVehicleType.setCellValueFactory(new PropertyValueFactory<AdminParkingSpotInitializer,String>("vehicleType"));
    	this.parkingLicenseType.setCellValueFactory(new PropertyValueFactory<AdminParkingSpotInitializer,String>("licencePlateID"));
    	this.parkingPAymentDue.setCellValueFactory(new PropertyValueFactory<AdminParkingSpotInitializer,String>("duePayment"));
    	this.AdminparkingTAble.setItems(parkingData);
		
	}
}
