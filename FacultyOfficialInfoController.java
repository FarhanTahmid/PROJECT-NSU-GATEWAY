package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class FacultyOfficialInfoController {

    @FXML
    private Label facultyName;

    @FXML
    private Label facultyDegree;

    @FXML
    private Label facultyDesignation;

    @FXML
    private Label facultyID;

    @FXML
    private Label facultyDepartment;

    @FXML
    private Label facultyResearchArea;

    @FXML
    private Label officehour;

    @FXML
    private Label officeID;

    @FXML
    private Label facultyContactNo;

    @FXML
    private Label facultyEmail;

    @FXML
    private Label course3;

    @FXML
    private Label course2;

    @FXML
    private Label course1;

    @FXML
    private Label section1;

    @FXML
    private Label section2;

    @FXML
    private Label section3;

    @FXML
    private Label time1;

    @FXML
    private Label time2;

    @FXML
    private Label time3;

    @FXML
    private Button homebutton;

    private Stage stage;
    @FXML
    void goToHome(ActionEvent event) {
    	stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		stage.close();

    }
    String ID="";
    String name="";
    String designation="";
    String department="";
    String fileofficehour="";
    String email="";
    String number="";
    String degree="";
    String office="";
    String filecourse1="";
    String filesection1="";
    String filetime1="";
    String filecourse2="";
    String filesection2="";
    String filetime2="";
    String filecourse3="";
    String filesection3="";
    String filetime3="";
    String researchAreas="";
    
    private static Scanner reader;
    boolean found= false;
    
    public void InfoSetter(String idnumber) throws FileNotFoundException {
    	
    	reader=new Scanner(new File("src//FacultyInfo.csv"));
    	reader.useDelimiter("[,\n]");
    	
    	while (reader.hasNext()&& !found){
    		ID=reader.next();
			name=reader.next();
			designation=reader.next();
			department=reader.next();
			fileofficehour=reader.next();
			email=reader.next();
			number=reader.next();
			degree=reader.next();
			office=reader.next();
			filecourse1=reader.next();
			filesection1=reader.next();
			filetime1=reader.next();
			filecourse2=reader.next();
			filesection2=reader.next();
			filetime2=reader.next();
			filecourse3=reader.next();
			filesection3=reader.next();
			filetime3=reader.next();
			researchAreas=reader.next();
			if(ID.equals(idnumber)) {
				found=true;
			}
			if (found) {
				this.facultyName.setText(name);
		    	this.facultyID.setText(ID);
		    	this.facultyContactNo.setText(number);
		    	this.facultyEmail.setText(email);
		    	this.facultyResearchArea.setText(researchAreas);
		    	this.facultyDesignation.setText(designation);
		    	this.facultyDepartment.setText(department);
		    	this.facultyDegree.setText(department);
		    	this.course1.setText(filecourse1);
		    	this.course2.setText(filecourse2);
		    	this.course3.setText(filecourse3);
		    	this.section1.setText(filesection1);
		    	this.section2.setText(filesection2);
		    	this.section3.setText(filesection3);
		    	this.time1.setText(filetime1);
		    	this.time2.setText(filetime2);
		    	this.time3.setText(filetime3);
		    	this.officehour.setText(fileofficehour);
		    	this.officeID.setText(office);
		    	
			}
		}
    	
    	
    	
    	    }

}
