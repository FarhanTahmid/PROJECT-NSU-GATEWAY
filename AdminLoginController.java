package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class AdminLoginController extends Confirmation{

	@FXML
    private Button homeButton;

    @FXML
    private MenuItem studentInfo;

    @FXML
    private MenuItem studentDatabase;

    @FXML
    private MenuItem facultyInfo;

    @FXML
    private MenuItem facultyDatabase;

    @FXML
    private MenuItem employeeDatabase;

    @FXML
    private MenuItem admincourseDropRequest;

    @FXML
    private MenuItem adminSemesterDropRequest;

    @FXML
    private MenuItem adminParkingSpot;

    @FXML
    private Label welcomeName;

    @FXML
    private ImageView universityLogo;

    @FXML
    private ImageView adminPhoto;

    @FXML
    private Label adminName;

    @FXML
    private Label offceid;

    @FXML
    private Label adminDesignation;

    @FXML
    private Label adminEmail;
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    void homeButton(ActionEvent event) throws IOException {
    	if(alertboxforLogout()) {
    		FXMLLoader loader=new FXMLLoader(getClass().getResource("LogInPage.fxml"));
    		root=loader.load();
    		stage=(Stage)((Node)event.getSource()).getScene().getWindow();
    		scene=new Scene(root);
    		stage.setScene(scene);
    		stage.setResizable(false);
    		stage.show();

    	}
   }
    
    
    private String officeID2,name,designation,email;
    public void AdminLoginController(String officeId,String name,String designation,String email) {
		this.officeID2=officeId;
		this.name=name;
		this.designation=designation;
		this.email=email;
	}
    public void infoSetter() throws FileNotFoundException {
    	this.welcomeName.setText(name);
    	this.adminName.setText(name);
    	this.adminEmail.setText(email);
    	this.adminDesignation.setText(designation);
    	this.offceid.setText(officeID2);
    	InputStream stream = new FileInputStream("src\\Student Pictures\\default boys.jpg");
		Image studentImage=new Image(stream);
		adminPhoto.setImage(studentImage);
		InputStream stream2=new FileInputStream("src//NSU-LOGO-2021.png");
		Image universityImage=new Image(stream2);
		universityLogo.setImage(universityImage);
    }
    
    @FXML
    void enterStudentDatabase(ActionEvent event) {
    	try {
    		Stage stage=new Stage();
    		FXMLLoader loader=new FXMLLoader(getClass().getResource("AdminStudentDatabase.fxml"));
    		root=(Parent) loader.load();
    		
    		AdminStudentDatabaseController passer=(AdminStudentDatabaseController)loader.getController();
    		
    		scene=new Scene(root);
    		stage.setScene(scene);
    		stage.show();
			
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
    }

    @FXML
    void showStudentInfo(ActionEvent event) {
    	try {
    		Stage stage=new Stage();
    		FXMLLoader loader=new FXMLLoader(getClass().getResource("AdminStudentInfo.fxml"));
    		root=(Parent) loader.load();
    		
    		AdminStudentInformationController passer=(AdminStudentInformationController)loader.getController();
    		
    		scene=new Scene(root);
    		stage.setScene(scene);
    		stage.show();
			
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
    	
    }
    
    @FXML
    void employeeData(ActionEvent event){
    	stage=new Stage();
    	FXMLLoader loader=new FXMLLoader(getClass().getResource("AdminEmployeeData.fxml"));
    	try {
			root=(Parent)loader.load();
			AdminEmployeeController controller=loader.getController();
	    	scene=new Scene(root);
	    	stage.setScene(scene);;
	    	stage.show();
	    		
		} catch (IOException e) {
			//System.out.println("Clicked");
			e.printStackTrace();
		}
   	
    }
    	
    
    
    
    
    
    @FXML
    void showFacultyInfo(ActionEvent event) throws IOException {
    	stage=new Stage();
    	FXMLLoader loader=new FXMLLoader(getClass().getResource("AdminFacultyInfo.fxml"));
    	root=(Parent)loader.load();
    	AdminShowFacultyInfoController controller=loader.getController();
    	scene=new Scene(root);
    	stage.setScene(scene);
    	stage.show();
    	
    	
    }
    @FXML
    void facultydatabase(ActionEvent event) {

    }
    @FXML
    void manageCourseDrop(ActionEvent event) throws IOException {
    	stage=new Stage();
    	FXMLLoader loader=new FXMLLoader(getClass().getResource("AdminCourseDropManagement.fxml"));
    	root=(Parent)loader.load();
    	AdminDropManagementController controller=loader.getController();
    	scene=new Scene(root);
    	stage.setScene(scene);
    	stage.show();
    	
    }
    @FXML
    void parkingSpot(ActionEvent event) throws IOException {
    	FXMLLoader loader=new FXMLLoader(getClass().getResource("AdminParkingRequest.fxml"));
    	root=loader.load();
    	AdminParkingSpotController controller=loader.getController();
    	stage=new Stage();
    	scene=new Scene(root);
    	stage.setScene(scene);
    	stage.show();
    }
    @FXML
    private MenuItem loginToYourMail;
    
    @FXML
    void mailLogin(ActionEvent event) throws IOException {
    	FXMLLoader loader=new FXMLLoader(getClass().getResource("AdminMiniEmailLogin.fxml"));
		root=loader.load();
		AdminMiniEmailLoginController controller=loader.getController();
		stage=new Stage();
		scene=new Scene(root);
		stage.setScene(scene);
		stage.show();
    }
    
    @Override
	boolean alertboxforLogout() {
		Alert alert =new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Logout");
		alert.setHeaderText("You are about to logout! Are you sure?");
		
		if (alert.showAndWait().get()==ButtonType.OK) {
			return true;
		}
		return false;
	}
	@Override
	boolean alrtboxforQuitting() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	boolean sameCourseSelected() {
		// TODO Auto-generated method stub
		return false;
	}
    

}
