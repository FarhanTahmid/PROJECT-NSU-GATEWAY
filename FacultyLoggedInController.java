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

public class FacultyLoggedInController extends Confirmation {
	 @FXML
	    private MenuItem shoOfficialInfo;
	@FXML
    private MenuItem cse299Sec15;

    @FXML
    private MenuItem cse215Sec03;

    @FXML
    private MenuItem cse215sec04;

    @FXML
    private MenuItem cs173Ston04;

    @FXML
    private MenuItem cse173section05;

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
    private MenuItem sendEmail;
    @FXML
    void sendMail(ActionEvent event) throws IOException {
    	FXMLLoader loader=new FXMLLoader(getClass().getResource("AdminMiniEmailLogin.fxml"));
		root=loader.load();
		AdminMiniEmailLoginController controller=loader.getController();
		stage=new Stage();
		scene=new Scene(root);
		stage.setScene(scene);
		stage.show();
		
    }
	Parent root;
	Scene scene;
	Stage stage;
	
	public void showStudentListCse173Section4() throws IOException {
		Stage stage=new Stage();
		FXMLLoader loader=new FXMLLoader(getClass().getResource("studentListCSE173Sec04SFR1.fxml"));
		root=loader.load();
		CourseStudentListController controller=loader.getController();
		scene=new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	  static String ID;
	     void initializor(String ID) {
	    	 FacultyLoggedInController.ID=ID;
	     }
	FacultyOfficialInfoController controller;
	  @FXML
	    void showOfficialInfo(ActionEvent event) throws IOException {
		  Stage stage=new Stage();
			FXMLLoader loader=new FXMLLoader(getClass().getResource("FacultyOfficialInformation.fxml"));
			root=loader.load();
			controller=loader.getController();
			controller.InfoSetter(FacultyLoggedInController.ID);
			scene=new Scene(root);
			stage.setScene(scene);
			stage.show();
	    }
	
	
	
	  @FXML
	    void showCSE299Sec15StudentList(ActionEvent event) throws IOException {
			Stage stage=new Stage();
			FXMLLoader loader=new FXMLLoader(getClass().getResource("studentListCSE299Sec15SFR1.fxml"));
			root=loader.load();
			Cse299sec15SFR1Controller controller=loader.getController();
			
			scene=new Scene(root);
			stage.setScene(scene);
			stage.show();
		  
	    }
	  @FXML
	    void showCSE173Sec05StudentList(ActionEvent event) throws IOException {
		  	Stage stage=new Stage();
			FXMLLoader loader=new FXMLLoader(getClass().getResource("studentListCSE173Sec05SFR1.fxml"));
			root=loader.load();
			Cse173sec05Controller controller=loader.getController();
			controller.getInfo();
			scene=new Scene(root);
			stage.setScene(scene);
			stage.show();
	  }
	    @FXML
	    void showCSE215Sec03StudentList(ActionEvent event) throws IOException {
	    	Stage stage=new Stage();
			FXMLLoader loader=new FXMLLoader(getClass().getResource("studentListCSE215Sec03SFR1.fxml"));
			root=loader.load();
			Cse215Sec03Controller controller=loader.getController();
			scene=new Scene(root);
			stage.setScene(scene);
			stage.show();
	    }
	    
	    @FXML
	    void showCSE215Sec04StudentList(ActionEvent event) throws IOException {
	    	Stage stage=new Stage();
			FXMLLoader loader=new FXMLLoader(getClass().getResource("studentListCSE215Sec04SFR1.fxml"));
			root=loader.load();
			Cse215sec04Controller controller=loader.getController();
			
			scene=new Scene(root);
			stage.setScene(scene);
			stage.show();
	    }
	  
	
	
	
	public void facultyInfoSetter(String ID,String name,String designation,String department,String officehour,String email,String number,String degree,String office,String course1,String section1,String time1,String course2,String section2,String time2,String course3,String section3,String time3,String researchAreas) throws IOException{
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
			
			
			
			switch(ID) {
			case "3021":{
				try {
					InputStream stream = new FileInputStream("src\\Faculty Pictures\\3021.jpg");
					Image facultyImage=new Image(stream);
					facultyImageView.setImage(facultyImage);
					break;
				} catch (FileNotFoundException e) {
					System.out.println("File can not be found");
					e.printStackTrace();
				}
			}
			}
			
		}
	
	public void backtoLogin(ActionEvent event) throws IOException {
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
