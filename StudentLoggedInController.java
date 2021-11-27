package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
//import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


public class StudentLoggedInController extends Confirmation implements Initializable {
	
    @FXML
    private ImageView studentImageView;

    @FXML
    private Label loggedInStudentName;

    @FXML
    private Label loggedInStudentName2;

    @FXML
    private Label loggedInStudentID;

    @FXML
    private Label totalCredit;

    @FXML
    private Label loggedInStudentMail;

    @FXML
    private Label loggedInStudentCurrentStat;

    @FXML
    private Label loggedInStudentCurriculumName;

    @FXML
    private ImageView universityLogo;

    @FXML
    private Label loggedInStudentDeptName;

    @FXML
    private Button backToLoginPageButton;

    @FXML
    private MenuItem studentAcademicInfo;

    @FXML
    private MenuItem studenPersonalInfo;

    @FXML
    private MenuItem summer2021;
    @FXML
    private MenuItem spring2021;
    @FXML
    private MenuItem preAdvising;
    @FXML
    private MenuItem advisingWindow;
    @FXML
    private MenuItem cgpaCalculator;
    @FXML
    private MenuItem gradeHistory;
    @FXML
    private MenuItem courseDropRequest;

    @FXML
    private MenuItem semesterDropRequest;

    @FXML
    private MenuItem ParkingSpotRequest;
    @FXML
    private MenuItem requestStatus;
    @FXML
    private MenuItem parkingspotStatus;
    @FXML
    private MenuItem fall2020;

    @FXML
    private MenuItem sendEmail;
	
	private Scene scene;
	private Stage stage;
	private Parent root;
	
	static String staticID;
	
	@FXML
    void sendEmail(ActionEvent event) throws IOException {
		FXMLLoader loader=new FXMLLoader(getClass().getResource("AdminMiniEmailLogin.fxml"));
		root=loader.load();
		AdminMiniEmailLoginController controller=loader.getController();
		stage=new Stage();
		scene=new Scene(root);
		stage.setScene(scene);
		stage.show();
		
    }
	
	public void academicInfo(ActionEvent event) throws IOException {
		Stage stage=new Stage();
		FXMLLoader loader=new FXMLLoader(getClass().getResource("ShowAcademicInfo.fxml"));
		root=loader.load();
		ShowAcademicInfoController passer=(ShowAcademicInfoController) loader.getController();
		passer.staticInitializer(staticID);
		passer.ShowAcademicInfo(staticID);
		
		scene=new Scene(root);
		stage.setScene(scene);
		stage.show();
		
		
	}
	
	
	
	public void personalInfo(ActionEvent event) throws IOException {
		Stage stage=new Stage();
		FXMLLoader loader=new FXMLLoader(getClass().getResource("ShowPersonalInfo.fxml"));
		root=loader.load();
		ShowPersonalInfoController info2=(ShowPersonalInfoController) loader.getController();
		info2.showPersonalInfo(staticID);
		
		scene=new Scene(root);
		stage.setScene(scene);
		stage.show();
		
	}
	@FXML
    void gradeHistory(ActionEvent event) {
		Stage stage=new Stage();
		try {

			FXMLLoader loader=new FXMLLoader(getClass().getResource("StudentGradeHistory.fxml"));
			root=(Parent)loader.load();
			StudentGradeHistory controller=loader.getController();
			
			scene=new Scene(root);
			stage.setScene(scene);
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
    }
    @FXML
    void cgpaCalculator(ActionEvent event) {
    	Stage stage=new Stage();
		try {

			FXMLLoader loader=new FXMLLoader(getClass().getResource("CGPA Calculator.fxml"));
			root=loader.load();
			CGPACalculatorController controller=loader.getController();
			
			scene=new Scene(root);
			stage.setScene(scene);
			stage.show();
		} catch (Exception e) {
			System.out.println(e);
		}		
		
    }
    
	public void usebankAccount(ActionEvent event) throws IOException {
		Stage stage=new Stage();
		try {

			FXMLLoader loader=new FXMLLoader(getClass().getResource("NSUBankAccountWindow.fxml"));
			root=loader.load();
			StudentBankWindow bankInfo=(StudentBankWindow)loader.getController();
			bankInfo.findingInfo(staticID);
			scene=new Scene(root);
			stage.setScene(scene);
			stage.show();
		} catch (Exception e) {
			System.out.println(e);
		}		
		
		
	}
	

	@FXML
    void courseInfoSummer2021(ActionEvent event) throws IOException {
    	try {
    		Stage stage=new Stage();
    		FXMLLoader loader=new FXMLLoader(getClass().getResource("StudentCoursesSummer2021.fxml"));
    		root=(Parent) loader.load();
    		
    		StudentCourseSummer2021Conotroller passer=(StudentCourseSummer2021Conotroller)loader.getController();
    		passer.infoInitializer(staticID);
    		scene=new Scene(root);
    		stage.setScene(scene);
    		stage.show();
			
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
    	
    }


    @FXML
    void courseInfoSpring2021(ActionEvent event) {
    	try {
    		Stage stage=new Stage();
    		FXMLLoader loader=new FXMLLoader(getClass().getResource("StudentCoursesSpring2021.fxml"));
    		root=(Parent) loader.load();
    		
    		StudentCourseSpring2021Conotroller passer=(StudentCourseSpring2021Conotroller)loader.getController();
    		passer.infoInitializer(staticID);
    		scene=new Scene(root);
    		stage.setScene(scene);
    		stage.show();
			
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
    }
    @FXML
    void fall2020CourseInfo(ActionEvent event) {
    	try {
    		Stage stage=new Stage();
    		FXMLLoader loader=new FXMLLoader(getClass().getResource("StudentCoursesFall202.fxml"));
    		root=loader.load();
    		
    		StudentCourseFall2020Controller passer=loader.getController();
    		
    		scene=new Scene(root);
    		stage.setScene(scene);
    		stage.show();
			
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
    }
    
    @FXML
    void preAdvisingWindow(ActionEvent event) {
    	try {
    		
    		Stage stage=new Stage();
    		FXMLLoader loader=new FXMLLoader(getClass().getResource("PreAdvisingWindow.fxml"));
    		root=(Parent) loader.load();
    		
    		PreAdvisingController passer=(PreAdvisingController)loader.getController();
    		
    		scene=new Scene(root);
    		stage.setScene(scene);
    		stage.show();
			
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
    }
    
    @FXML
    void showAdvisingWindow(ActionEvent event) {
    	try {
    		
    		Stage stage=new Stage();
    		FXMLLoader loader=new FXMLLoader(getClass().getResource("AdvisingWindow.fxml"));
    		root=(Parent)loader.load();
    		AdvisingWindowController passer=loader.getController();
    		scene=new Scene(root);
    		stage.setScene(scene);
    		stage.show();
			
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
    }
    @FXML
    void parkingSpotRequest(ActionEvent event) throws IOException {
    	stage=new Stage();
    	FXMLLoader loader=new FXMLLoader(getClass().getResource("ParkingSpotRequest.fxml"));
    	root=loader.load();
    	ParkingSpotRequestController controller=loader.getController();
    	scene=new Scene(root);
    	stage.setScene(scene);
    	stage.show();
    }
    @FXML
    void courseDropRequest(ActionEvent event) throws IOException {
    	stage=new Stage();
    	FXMLLoader loader=new FXMLLoader(getClass().getResource("StudentCourseDropRequest.fxml"));
    	root=loader.load();
    	CourseDropRequestController controller=(CourseDropRequestController)loader.getController();
    	controller.staticInitializer(staticID);
    	scene=new Scene(root);
    	stage.setScene(scene);
    	stage.show();
    	
    }
    @FXML
    void semesterDropRequest(ActionEvent event) {

    }
    @FXML
    void requestStatus(ActionEvent event) throws IOException {
    	FXMLLoader loader=new FXMLLoader(getClass().getResource("StrudentRequestStatus.fxml"));
    	root=loader.load();
    	StudentRequestStatusController controller=loader.getController();
    	StudentRequestStatusController controller1=new StudentRequestStatusController();
    	
    	stage=new Stage();
    	scene=new Scene(root);
    	stage.setScene(scene);
    	stage.show();
    }
    
    @FXML
    void parkingspotrequeststatus(ActionEvent event) throws IOException {
    	
    	FXMLLoader loader=new FXMLLoader(getClass().getResource("ParkingRequestStatus.fxml"));
    	root=loader.load();
    	StudentParkingRequestStatusController controller=loader.getController();
    	controller.adminAcceptedInitializer();
    	controller.adminRejectedInitializer();
    	controller.initializer();
    	scene=new Scene(root);
    	stage=new Stage();
    	stage.setScene(scene);
    	stage.show();
    }
	
	
	
	

	public void loggedInStudentInfo(String name,String Id,String credits,String deptName,String curriculumName,String email,String currentstat,String gender){		
		loggedInStudentName.setText("WELCOME "+name.toUpperCase());
		loggedInStudentName2.setText(name);
		loggedInStudentID.setText("ID: "+Id);
		totalCredit.setText("Completed Credit: "+credits);
		loggedInStudentCurriculumName.setText(curriculumName+"-130 Credit Curriculum");;
		loggedInStudentMail.setText("Email : "+email);
		loggedInStudentDeptName.setText(deptName);
		loggedInStudentCurrentStat.setText("Your Current Status: "+currentstat);
		
		
		staticID=Id;
	
		//setting student Picture
		try {
			switch(Id) {
			
			case "1812400642":{
				InputStream stream = new FileInputStream("src\\Student Pictures\\1812400642.jpg");
				Image studentImage=new Image(stream);
				studentImageView.setImage(studentImage);
				break;
				}
			
			case "1922214030":{
				InputStream stream = new FileInputStream("src\\Student Pictures\\1922214030.jpeg");
				Image studentImage=new Image(stream);
				studentImageView.setImage(studentImage);
				break;
				}
			
			case "2011195642":{
				InputStream stream = new FileInputStream("src\\Student Pictures\\2011195642.jpg");
				Image studentImage=new Image(stream);
				studentImageView.setImage(studentImage);
				break;
				}
			
			case "2011691642":{
				InputStream stream = new FileInputStream("src\\Student Pictures\\2011691642.jpeg");
				Image studentImage=new Image(stream);
				studentImageView.setImage(studentImage);
				break;
				}
			
			case "2011703642":{
				InputStream stream = new FileInputStream("src\\Student Pictures\\2011703642.jpg");
				Image studentImage=new Image(stream);
				studentImageView.setImage(studentImage);
				break;
				}
			case "2012018642":{
				InputStream stream = new FileInputStream("src\\Student Pictures\\2012018642.jpg");
				Image studentImage=new Image(stream);
				studentImageView.setImage(studentImage);
				break;
				}
			case "2012273642":{
				InputStream stream = new FileInputStream("src\\Student Pictures\\2012273642.JPG");
				Image studentImage=new Image(stream);
				studentImageView.setImage(studentImage);
				break;
				}
			case "2012677642":{
				InputStream stream = new FileInputStream("src\\Student Pictures\\2012677642.jpg");
				Image studentImage=new Image(stream);
				studentImageView.setImage(studentImage);
				break;
				}
			case "2012335642":{
				InputStream stream = new FileInputStream("src\\Student Pictures\\2012335642.jpg");
				Image studentImage=new Image(stream);
				studentImageView.setImage(studentImage);
				break;
				}
			case "2012932642":{
				InputStream stream = new FileInputStream("src\\Student Pictures\\2012932642.jpg");
				Image studentImage=new Image(stream);
				studentImageView.setImage(studentImage);
				break;
				}
			case "2013199645":{
				InputStream stream = new FileInputStream("src\\Student Pictures\\2013199645.jpg");
				Image studentImage=new Image(stream);
				studentImageView.setImage(studentImage);
				break;
				}
			case "2013213630":{
				InputStream stream = new FileInputStream("src\\Student Pictures\\2013213630.jpg");
				Image studentImage=new Image(stream);
				studentImageView.setImage(studentImage);
				break;
				}
			case "2021876643":{
				InputStream stream = new FileInputStream("src\\Student Pictures\\2021876643.png");
				Image studentImage=new Image(stream);
				studentImageView.setImage(studentImage);
				break;
				}
			case "2031033642":{
				InputStream stream = new FileInputStream("src\\Student Pictures\\2031033642.jpg");
				Image studentImage=new Image(stream);
				studentImageView.setImage(studentImage);
				break;
				}
			case "2031130642":{
				InputStream stream = new FileInputStream("src\\Student Pictures\\2031130642.jpg");
				Image studentImage=new Image(stream);
				studentImageView.setImage(studentImage);
				break;
				}
			case "2031206642":{
				InputStream stream = new FileInputStream("src\\Student Pictures\\2031206642.jpg");
				Image studentImage=new Image(stream);
				studentImageView.setImage(studentImage);
				break;
				}
			case "2031326642":{
				InputStream stream = new FileInputStream("src\\Student Pictures\\2031326642.jpg");
				Image studentImage=new Image(stream);
				studentImageView.setImage(studentImage);
				break;
				}
			case "2031340042":{
				InputStream stream = new FileInputStream("src\\Student Pictures\\2031340042.JPG");
				Image studentImage=new Image(stream);
				studentImageView.setImage(studentImage);
				break;
				}
			case "2031436642":{
				InputStream stream = new FileInputStream("src\\Student Pictures\\2031436642.jpeg");
				Image studentImage=new Image(stream);
				studentImageView.setImage(studentImage);
				break;
				}
			case "2031458642":{
				InputStream stream = new FileInputStream("src\\Student Pictures\\2031458642.jpeg");
				Image studentImage=new Image(stream);
				studentImageView.setImage(studentImage);
				break;
				}
			
			case "2031519642":{
				InputStream stream = new FileInputStream("src\\Student Pictures\\2031519642.jpg");
				Image studentImage=new Image(stream);
				studentImageView.setImage(studentImage);
				break;
				}
			case "2031523642":{
				InputStream stream = new FileInputStream("src\\Student Pictures\\2031523642.jpg");
				Image studentImage=new Image(stream);
				studentImageView.setImage(studentImage);
				break;
				}
			case "2112183642":{
				InputStream stream = new FileInputStream("src\\Student Pictures\\2112183642.jpg");
				Image studentImage=new Image(stream);
				studentImageView.setImage(studentImage);
				break;
				}
			case "2112348642":{
				InputStream stream = new FileInputStream("src\\Student Pictures\\2112348642.jpg");
				Image studentImage=new Image(stream);
				studentImageView.setImage(studentImage);
				break;
				}
			case "2121443642":{
				InputStream stream = new FileInputStream("src\\Student Pictures\\2121443642.jpg");
				Image studentImage=new Image(stream);
				studentImageView.setImage(studentImage);
				break;
				}
			default:{
				if(gender.equals("Male")) {

					InputStream stream = new FileInputStream("src\\Student Pictures\\default boys.jpg");
					Image studentImage=new Image(stream);
					studentImageView.setImage(studentImage);
					
				}
				else if(gender.equals("Female")) {
					InputStream stream = new FileInputStream("src\\Student Pictures\\WomanDefault.jpg");
					Image studentImage=new Image(stream);
					studentImageView.setImage(studentImage);
				}
			}
			}
			
		}catch (Exception e) {
			System.out.println(e);
		}
		
		//University Logo
		InputStream stream;
		try {
			stream = new FileInputStream("src\\NSU-LOGO-2021.png");
			Image uniLogo=new Image(stream);
			universityLogo.setImage(uniLogo);
			
		} catch (FileNotFoundException e) {
			System.out.println(e);
		}
	}
	

	
	public void backToLogin(ActionEvent event) throws IOException {
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
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
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
		Alert alert =new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Logout");
		alert.setHeaderText("You are about to quit from the program! Are you sure?");
		
		if (alert.showAndWait().get()==ButtonType.OK) {
			return true;
		}
		return false;
	}



	@Override
	boolean sameCourseSelected() {
		// TODO Auto-generated method stub
		return false;
	}
}

