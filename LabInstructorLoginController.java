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
import javafx.scene.control.MenuItem;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


public class LabInstructorLoginController extends Confirmation{
	
	
	 @FXML
	    private MenuItem facultyOfficialInfo;

	
    @FXML
    private MenuItem cse215Sec04;

    @FXML
    private MenuItem attendanceCSE215sec04;

    @FXML
    private Label welcomefacultyName;

    @FXML
    private ImageView universityLogo;

    @FXML
    private Label departmentName;

    @FXML
    private ImageView facultyImageView;

    @FXML
    private Label facultyName;

    @FXML
    private Label facultyDesignation;

    @FXML
    private Label office;

    @FXML
    private Label email;

    @FXML
    private Button logoutbutton;
    @FXML
    private MenuItem sendMail;
    @FXML
    void sendMAil(ActionEvent event) throws IOException {
    	FXMLLoader loader=new FXMLLoader(getClass().getResource("AdminMiniEmailLogin.fxml"));
		root=loader.load();
		AdminMiniEmailLoginController controller=loader.getController();
		stage=new Stage();
		scene=new Scene(root);
		stage.setScene(scene);
		stage.show();
    }

    @FXML
    void backtoLogin(ActionEvent event) throws IOException {
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
    
    private Stage stage;
    private Scene scene;
    Parent root;

    @FXML
    void showCSE215Sec04StudentList(ActionEvent event) throws IOException {
		Stage stage=new Stage();
    	FXMLLoader loader=new FXMLLoader(getClass().getResource("StudentListCSE215Sec04LabMonamymam.fxml"));
		root=loader.load();
		Cse215sec04LabController controller=loader.getController();
		scene=new Scene(root);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();

    }
     static String ID;
     void initializor(String ID) {
    	 LabInstructorLoginController.ID=ID;
     }
    
    @FXML
    void showOfficialInfo(ActionEvent event) throws IOException {
    	Stage stage=new Stage();
		FXMLLoader loader=new FXMLLoader(getClass().getResource("FacultyOfficialInformation.fxml"));
		root=loader.load();
		FacultyOfficialInfoController controller=loader.getController();
		controller.InfoSetter(LabInstructorLoginController.ID);
		scene=new Scene(root);
		stage.setScene(scene);
		stage.show();
    }
    
    public void labInstructorInfoSetter(String ID,String name,String designation,String department,String officehour,String email,String number,String degree,String office,String course1,String section1,String time1,String course2,String section2,String time2,String course3,String section3,String time3,String researchAreas) throws IOException {
		welcomefacultyName.setText(name);
		facultyName.setText(name);
		facultyDesignation.setText(designation);
		this.office.setText(office);
		this.email.setText(email);
		this.departmentName.setText(department);
		
		InputStream stream2;
		try {
			stream2 = new FileInputStream("src\\NSU-LOGO-2021.png");
			Image universityImage=new Image(stream2);
			this.universityLogo.setImage(universityImage);
		} catch (FileNotFoundException e1) {
			System.out.println("File can not be found");
			e1.printStackTrace();
		}
		InputStream stream;
		stream = new FileInputStream("src\\Faculty Pictures\\5566.jpg");
		Image facultyImage=new Image(stream);
		facultyImageView.setImage(facultyImage);
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
