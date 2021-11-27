package application;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LogInClassController extends Confirmation {
	
	@FXML
	private TextField userIdField;
	@FXML
	private TextField passwordField;
	@FXML
	private Button loginButton,facultyLoginButton,adminLoginButton,button;
	@FXML
	private Button cancelLoginButton;
	@FXML 
	public Label statusLabel;
	@FXML
	private Label changeLabel;
	@FXML
	private RadioButton studentLogInSelector,facultyLogInSelector,adminLogInSelector;
	  @FXML
	    private Button aboutUsButton;

	    @FXML
	    void aboutUS(ActionEvent event) throws IOException {
	    	FXMLLoader loader=new FXMLLoader(getClass().getResource("AboutUS.fxml"));
	    	root=loader.load();
	    	DeveloperOptions controller=loader.getController();
	    	scene=new Scene(root);
	    	stage=new Stage();
	    	stage.setScene(scene);
	    	stage.show();
	    }
	
	
	static String loginCriteria;
	private Scene scene;	
	private Stage stage;
	private Parent root;
	
	
	private String defaultPass="1234";
	
	private static Scanner reader;
	Scanner input =new Scanner(System.in);
	String filepath="src\\StudentInformation1.csv";
	String facultyfilepath="src\\FacultyInfo.csv";
	
	public void getloginMethod(ActionEvent event) throws IOException {
		if(studentLogInSelector.isSelected()) {
			this.facultyLoginButton.setDisable(true);
			this.adminLoginButton.setDisable(true);
			this.loginButton.setDisable(false);
			this.changeLabel.setText("You are logging in as a Student!");
			if(event.getSource()==this.loginButton) {
				logIn(event);
			}	
		}
		else if(facultyLogInSelector.isSelected()) {
			this.adminLoginButton.setDisable(true);
			this.loginButton.setDisable(true);
			this.facultyLoginButton.setDisable(false);
			this.changeLabel.setText("You are logging in as a Faculty Member!");
			if(event.getSource()==this.facultyLoginButton) {
				facultyLogin(event);
			}
		}
		else if(adminLogInSelector.isSelected()) {
			this.facultyLoginButton.setDisable(true);
			this.loginButton.setDisable(true);
			this.adminLoginButton.setDisable(false);
			this.changeLabel.setText("You are logging in as a Admin Member!");
		}
		else {
			this.loginButton.setDisable(true);
			this.facultyLoginButton.setDisable(true);
			this.adminLoginButton.setDisable(true);
		}
	}
	
	
	public void adminLogin(ActionEvent event) throws IOException {
		String userID=userIdField.getText();
		String password=passwordField.getText();
		
		boolean found=false;
		String officeID="";
		String name="";
		String designation="";
		String email="";
		
		reader=new Scanner(new File("src//Admin Files//adminInfo.csv"));
		reader.useDelimiter("[,\n]");
		while(reader.hasNext()&& !found) {
			officeID=reader.next();
			name=reader.next();
			designation=reader.next();
			email=reader.next();
			if(officeID.equals(userID)&& password.equals(defaultPass)) {
				found=true;
			}
			else {
				statusLabel.setText("Wrong Username or Password");
			}
			
		}
		
		
		if(found) {
			
			FXMLLoader loader=new FXMLLoader(getClass().getResource("AdminLoggedInPage.fxml"));
			root=loader.load();
			AdminLoginController controller=loader.getController();
			controller.AdminLoginController(officeID, name, designation, email);
			controller.infoSetter();
			stage=(Stage)((Node)event.getSource()).getScene().getWindow();
			scene=new Scene(root);
			stage.setScene(scene);
			stage.show();
			LogInClassController.loginCriteria="Admin";
			
		}
	}
	
	
	
	
	public void facultyLogin(ActionEvent event) throws IOException {
		
		String userID=userIdField.getText();
		String password= passwordField.getText();
		
		boolean found=false;
		String ID="";
		String name="";
		String designation="";
		String department="";
		String officeHours="";
		String email="";
		String number="";
		String degree="";
		String office="";
		String course1="";
		String section1="";
		String time1="";
		String course2="";
		String section2="";
		String time2="";
		String course3="";
		String section3="";
		String time3="";
		String researchareas="";
		
		try {
			reader=new Scanner(new File(facultyfilepath));
			reader.useDelimiter("[,\n]");
			
			while(reader.hasNext()&& !found) {
				ID=reader.next();
				name=reader.next();
				designation=reader.next();
				department=reader.next();
				officeHours=reader.next();
				email=reader.next();
				number=reader.next();
				degree=reader.next();
				office=reader.next();
				course1=reader.next();
				section1=reader.next();
				time1=reader.next();
				course2=reader.next();
				section2=reader.next();
				time2=reader.next();
				course3=reader.next();
				section3=reader.next();
				time3=reader.next();
				researchareas=reader.next();
				
				if(ID.equals(userID)&&password.equals(defaultPass)) {
					found=true;
					statusLabel.setText("Login Successful");
					
				}
				else {
					statusLabel.setText("Wrong Username or Password");
				}
				
			}
			if(found) {
				
				if(ID.equals("3021")) {
					FXMLLoader loader=new FXMLLoader(getClass().getResource("FacultyLoginPage.fxml"));
					root=loader.load();
				
					
					FacultyLoggedInController passer=loader.getController();
					passer.facultyInfoSetter(ID, name, designation, department, officeHours, email, number, degree, office, course1, section1, time1, course2, section2, time2, course3, section3, time3, researchareas);
					passer.initializor(ID);
					stage=(Stage)((Node)event.getSource()).getScene().getWindow();
					scene=new Scene(root);
					stage.setScene(scene);
					stage.show();
					LogInClassController.loginCriteria="Faculty";
				}
				else if (ID.equals("5566")) {
					FXMLLoader loader=new FXMLLoader(getClass().getResource("LabInstructorLogInPage.fxml"));
					root=loader.load();
				
					LabInstructorLoginController passer=loader.getController();
					passer.labInstructorInfoSetter(ID, name, designation, department, officeHours, email, number, degree, office, course1, section1, time1, course2, section2, time2, course3, section3, time3, researchareas);
					passer.initializor(ID);
					stage=(Stage)((Node)event.getSource()).getScene().getWindow();
					scene=new Scene(root);
					stage.setScene(scene);
					stage.show();
					LogInClassController.loginCriteria="Faculty";
				}
				
			}
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	
	public void logIn(ActionEvent event) {
	
		String userID=userIdField.getText();
		String password= passwordField.getText();
		
		
		boolean found=false;
		String ID="";
		String name="";
		String completedCredit="";
		String departmentName="";
		String curriculumName="";
		String email="";
		String currentStatus="";
		String degreeName="";
		String gender="";
		String birthdate="";
		String enrollmentSemester="";
		String grade="";
		
		try {
			reader=new Scanner(new File(filepath));
			reader.useDelimiter("[,\n]");
			
			while(reader.hasNext() && !found) {
				ID=reader.next();
				name=reader.next();
				completedCredit=reader.next();
				departmentName=reader.next();
				curriculumName=reader.next();
				email=reader.next();
				currentStatus=reader.next();
				degreeName=reader.next();
				gender=reader.next();
				birthdate=reader.next();
				enrollmentSemester=reader.next();
				grade=reader.next();
				
				
				if(ID.equals(userID) && password.equals(defaultPass)) {
					found=true;
					statusLabel.setText("Log in Successful");
				}
			}
			if(found) {
				
				FXMLLoader loader=new FXMLLoader(getClass().getResource("StudentLoggedInPage2.fxml"));
				root=loader.load();
				StudentLoggedInController passer=loader.getController();
				passer.loggedInStudentInfo(name, ID, completedCredit,departmentName,curriculumName,email,currentStatus,gender);	
				
				ShowAcademicInfoController info =new ShowAcademicInfoController();
				info.staticInitializer(ID);
				
				ShowPersonalInfoController info2=new ShowPersonalInfoController();
				info2.staticInitializer(ID);
				
				
				StudentCourseSummer2021Conotroller courseInfo=new StudentCourseSummer2021Conotroller();
				courseInfo.staticInitializer(ID);
				
				StudentCourseSpring2021Conotroller courseInfo2=new StudentCourseSpring2021Conotroller();
				courseInfo2.staticInitializer(ID);
				
				StudentCourseFall2020Controller courseinfo3=new StudentCourseFall2020Controller();
				courseinfo3.staticInitializer(ID);
				
				StudentBankWindow initializer=new StudentBankWindow();
				initializer.getInfo(ID);
				initializer.findingInfo(ID);
				initializer.intializingBalance(Double.parseDouble(StudentBankWindow.fileBankBalance));
				
				
				stage=(Stage)((Node)event.getSource()).getScene().getWindow();
				scene=new Scene(root);
				stage.setScene(scene);
				stage.show();
				LogInClassController.loginCriteria="Student";
			
			}
			
			else {
				if(!ID.equals(userID) && password.equals(defaultPass)) {
					statusLabel.setText("Sorry there is no such ID registered in the system");
				}
				else if(!password.equals(defaultPass) && ID.equals(userID)) {
					statusLabel.setText("The password You entered is Wrong");
				}
				else if (!password.equals(defaultPass) && !ID.equals(userID)) {
					statusLabel.setText("The username or the password you entered does not match with the system record");
				}
			}
		} catch (Exception e) {
			System.out.println(e);
			//System.out.println("File Error!");
		}
		
	}
	public void cancelLogin(ActionEvent event) {
		if(alrtboxforQuitting()) {
			stage=(Stage)((Node)event.getSource()).getScene().getWindow();
			stage.close();
		}
		
	}


	@Override
	boolean alertboxforLogout() {
		Alert alert =new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Logout");
		alert.setHeaderText("You are about to logout! Are you sure?");
		alert.setContentText("Do you want to save before exiting?");
		if (alert.showAndWait().get()==ButtonType.OK) {
			return true;
		}
		return false;
	}


	@Override
	boolean alrtboxforQuitting() {
		Alert alert =new Alert(AlertType.CONFIRMATION);
		alert.setTitle("QUIT");
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
