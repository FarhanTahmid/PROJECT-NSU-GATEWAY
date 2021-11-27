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

public class ShowPersonalInfoController {
	@FXML
	private Label dateofbirth,studentName,nationality,nid,religeon,maritialStatus,bloodGroup,fathersName,mothersName,address,phonenumber,gender;
	
	private static String ID;
	
	private static Scanner reader;
	Scanner input =new Scanner(System.in);
	String filepath="src\\StudentPersonalInfo.csv";
    @FXML
    private Button homebutton;
    private Stage stage;
    @FXML
    void goHome(ActionEvent event) {
    	stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		stage.close();
    }

	
	public void staticInitializer(String id) {
		ID=id;	
	}
	
	public void showPersonalInfo(String id) {
		boolean found=false;
		String IdInfile="";
		String nameInfile="";
		String fathersname="";
		String mothersname="";
		String address="";
		String mobileNumber="";
		String religeon="";
		String nationality="";
		String maritialStatus="";
		String bloodgroup="";
		String birthdate="";
		String gender="";
		
		try {
			reader=new Scanner(new File(filepath));
			reader.useDelimiter("[,\n]");
			
			while(reader.hasNext()&& !found) {
				IdInfile=reader.next();
				nameInfile=reader.next();
				fathersname=reader.next();
				mothersname=reader.next();
				address=reader.next();
				mobileNumber=reader.next();
				religeon=reader.next();
				nationality=reader.next();
				maritialStatus=reader.next();
				bloodgroup=reader.next();
				birthdate=reader.next();
				gender=reader.next();
				
				if(IdInfile.equals(ShowPersonalInfoController.ID)) {
					found=true;
				}
			}
			
			if(found) {
				this.address.setText(address);
				this.dateofbirth.setText(birthdate);
				this.bloodGroup.setText(bloodgroup);
				this.fathersName.setText(fathersname);
				this.mothersName.setText(mothersname);
				this.maritialStatus.setText(maritialStatus);
				this.religeon.setText(religeon);
				this.studentName.setText(nameInfile);
				this.nationality.setText(nationality);
				this.nid.setText("174897471974");
				this.phonenumber.setText("0"+mobileNumber);
				this.gender.setText(gender);
				
			}
			
			
			
			
		} catch (FileNotFoundException e) {
			System.out.println("File Error");
			e.printStackTrace();
		}
		
		
		
		
		
	}
}
