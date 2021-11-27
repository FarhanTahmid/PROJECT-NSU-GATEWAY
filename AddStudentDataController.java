package application;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddStudentDataController implements Initializable {

    @FXML
    private TextField enterStudentName;

    @FXML
    private TextField enterStudentContactNo;

    @FXML
    private TextField enterStudentMail;

    @FXML
    private TextField enterStudentNationality;

    @FXML
    private TextField enterStudentID;

    @FXML
    private TextField enterStudentAddress;

    @FXML
    private ChoiceBox<String> enterDeoartmentChoiceBox;

    @FXML
    private ChoiceBox<String> enterDepartmentCurriculum;

    @FXML
    private ChoiceBox<String> enterEnrollmentSemester;

    @FXML
    private ChoiceBox<String> newStudentGender;

    @FXML
    private DatePicker enterStudentBirthdate;

    @FXML
    private Button saveAndCloseButton;
    
    
    Parent root;
    private Stage stage;
    
    @FXML
    void saveAndClose(ActionEvent event) throws IOException {
    	
    	//Wrong here
		name=this.enterStudentName.getText();
		id=this.enterStudentID.getText();
		department=this.enterDeoartmentChoiceBox.getValue();
		curriculum=this.enterDepartmentCurriculum.getValue();
		enrollmentSemester=this.enterEnrollmentSemester.getValue();
		
		studentGender=this.newStudentGender.getValue();
		studentAddress=this.enterStudentAddress.getText();
		nationality=this.enterStudentMail.getText();
		studentMail=this.enterStudentMail.getText();
		contactNo=this.enterStudentContactNo.getText();
		birthdate=String.valueOf(this.enterStudentBirthdate.getValue());
    	
    	AdminStudentDatabaseController passer=new AdminStudentDatabaseController();
    	passer.addStudent(AddStudentDataController.id,AddStudentDataController.name,AddStudentDataController.department,AddStudentDataController.curriculum,AddStudentDataController.enrollmentSemester);
    	
    	
    	
    	stage=(Stage)((Node)event.getSource()).getScene().getWindow();
    	stage.close();
    	
  
    }
    private String[] departmentList= {"Electrical And Computer Engineering","Busines Administration","Pharmacy","Biochemistry And Microbiology","Architecture","Civil Engineering","Environmental Science"};
    private String[] curriculumList= {"BS in CSE","BBA General","BS in Civil & Environmental Engineering (CEE)",
    		"BS in Electrical & Electronic Engineering (EEE)","BS in Electronic & Telecom Engineering (ETE)","BS in Biochemistry and Biotechnology",
    		"BS in Environmental Science & Management","BS in Microbiology","BPharm Professional","BBA Major in Accounting","BBA Major in Economics","BBA Major in Entrepreneurship","BBA Major in Finance",
    		"BBA Major in Human Resource Management","BBA Major in International Business","BBA Major in International Business","BBA Major in Management Information Systems","BBA General","BS in Economics","BA in English"};
    private String[] gender= {"Male","Female"};
    private String[] semester= {"Summer-2021","Fall-2021"};
    
    static String name="";
    static String id="";
    static String department="";
    static String curriculum="";
    static String enrollmentSemester="";
    String studentGender="";
    String studentAddress="";
    String nationality="";
    String studentMail="";
    String contactNo="";
    String birthdate="";
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.enterDeoartmentChoiceBox.getItems().addAll(departmentList);
		this.newStudentGender.getItems().addAll(gender);
		this.enterDepartmentCurriculum.getItems().addAll(curriculumList);
		this.enterEnrollmentSemester.getItems().addAll(semester);
			
	}

}
