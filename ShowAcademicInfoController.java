package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class ShowAcademicInfoController {
	@FXML
	private Label picturefullName;
	@FXML
	private Label creditCompleted;
	@FXML
	private Label CGPA;
	@FXML
	private Label currentStatus;
	@FXML
	private Label enrolledSemester;
	@FXML
	private Label curriculumName;
	@FXML
	private Label studentID;
	@FXML
	private Label fullName;
	@FXML
	private ImageView studentImage1;
	
	static String ID="";
	/*
	static String name="";
	static String completedCredit="";
	static String departmentName="";
	static String curriculumname="";
	static String email="";
	static String currentstatus="";
	*/
	
	private Stage stage;
	
	private static Scanner reader;
	Scanner input =new Scanner(System.in);
	String filepath="src\\StudentInformation1.csv";
	
	public void staticInitializer(String id) {
		ID=id;
	}
	
	
	public void goHome(ActionEvent event) throws IOException {
		stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		stage.close();
}
	String Id="";
	String name="";
	String completedCredit="";
	String departmentName="";
	String curriculumName1="";
	String email="";
	String currentStatus1="";
	String degreeName="";
	static String gender="";
	String birthdate="";
	String enrollmentSemester="";
	String grade="";

	public void ShowAcademicInfo(String idnumber){
		
		boolean found=false;
		
		
		try {
			reader=new Scanner(new File(filepath));
			reader.useDelimiter("[,\n]");
			
			while(reader.hasNext() && !found) {
				Id=reader.next();
				name=reader.next();
				completedCredit=reader.next();
				departmentName=reader.next();
				curriculumName1=reader.next();
				email=reader.next();
				currentStatus1=reader.next();
				degreeName=reader.next();
				gender=reader.next();
				birthdate=reader.next();
				enrollmentSemester=reader.next();
				grade=reader.next();
				
				
				if(Id.equals(ShowAcademicInfoController.ID)) {
					found=true;
					
				}
			}
			if(found) {
				
				
				fullName.setText(name);
				studentID.setText(Id);
				this.curriculumName.setText(curriculumName1);
				enrolledSemester.setText(enrollmentSemester);
				this.currentStatus.setText(currentStatus1);
				CGPA.setText(grade);
				creditCompleted.setText(completedCredit);
				picturefullName.setText(name);
				
				
				try {
					switch(idnumber) {
					
					case "1812400642":{
						InputStream stream = new FileInputStream("src\\Student Pictures\\1812400642.jpg");
						Image studentImage=new Image(stream);
						studentImage1.setImage(studentImage);
						break;
						}
					
					case "1922214030":{
						InputStream stream = new FileInputStream("src\\Student Pictures\\1922214030.jpeg");
						Image studentImage=new Image(stream);
						studentImage1.setImage(studentImage);
						break;
						}
					
					case "2011195642":{
						InputStream stream = new FileInputStream("src\\Student Pictures\\2011195642.jpg");
						Image studentImage=new Image(stream);
						studentImage1.setImage(studentImage);
						break;
						}
					
					case "2011691642":{
						InputStream stream = new FileInputStream("src\\Student Pictures\\2011691642.jpeg");
						Image studentImage=new Image(stream);
						studentImage1.setImage(studentImage);
						break;
						}
					
					case "2011703642":{
						InputStream stream = new FileInputStream("src\\Student Pictures\\2011703642.jpg");
						Image studentImage=new Image(stream);
						studentImage1.setImage(studentImage);
						break;
						}
					case "2012018642":{
						InputStream stream = new FileInputStream("src\\Student Pictures\\2012018642.jpg");
						Image studentImage=new Image(stream);
						studentImage1.setImage(studentImage);
						break;
						}
					case "2012273642":{
						InputStream stream = new FileInputStream("src\\Student Pictures\\2012273642.JPG");
						Image studentImage=new Image(stream);
						studentImage1.setImage(studentImage);
						break;
						}
					case "2012677642":{
						InputStream stream = new FileInputStream("src\\Student Pictures\\2012677642.jpg");
						Image studentImage=new Image(stream);
						studentImage1.setImage(studentImage);
						break;
						}
					case "2012335642":{
						InputStream stream = new FileInputStream("src\\Student Pictures\\2012335642.jpg");
						Image studentImage=new Image(stream);
						studentImage1.setImage(studentImage);
						break;
						}
					case "2012932642":{
						InputStream stream = new FileInputStream("src\\Student Pictures\\2012932642.jpg");
						Image studentImage=new Image(stream);
						studentImage1.setImage(studentImage);
						break;
						}
					case "2013199645":{
						InputStream stream = new FileInputStream("src\\Student Pictures\\2013199645.jpg");
						Image studentImage=new Image(stream);
						studentImage1.setImage(studentImage);
						break;
						}
					case "2013213630":{
						InputStream stream = new FileInputStream("src\\Student Pictures\\2013213630.jpg");
						Image studentImage=new Image(stream);
						studentImage1.setImage(studentImage);
						break;
						}
					case "2021876643":{
						InputStream stream = new FileInputStream("src\\Student Pictures\\2021876643.png");
						Image studentImage=new Image(stream);
						studentImage1.setImage(studentImage);
						break;
						}
					case "2031033642":{
						InputStream stream = new FileInputStream("src\\Student Pictures\\2031033642.jpg");
						Image studentImage=new Image(stream);
						studentImage1.setImage(studentImage);
						break;
						}
					case "2031130642":{
						InputStream stream = new FileInputStream("src\\Student Pictures\\2031130642.jpg");
						Image studentImage=new Image(stream);
						studentImage1.setImage(studentImage);
						break;
						}
					case "2031206642":{
						InputStream stream = new FileInputStream("src\\Student Pictures\\2031206642.jpg");
						Image studentImage=new Image(stream);
						studentImage1.setImage(studentImage);
						break;
						}
					case "2031326642":{
						InputStream stream = new FileInputStream("src\\Student Pictures\\2031326642.jpg");
						Image studentImage=new Image(stream);
						studentImage1.setImage(studentImage);
						break;
						}
					case "2031458642":{
						InputStream stream = new FileInputStream("src\\Student Pictures\\2031458642.jpeg");
						Image studentImage=new Image(stream);
						studentImage1.setImage(studentImage);
						break;
						}
					case "2031340042":{
						InputStream stream = new FileInputStream("src\\Student Pictures\\2031340042.JPG");
						Image studentImage=new Image(stream);
						studentImage1.setImage(studentImage);
						break;
						}
					case "2031436642":{
						InputStream stream = new FileInputStream("src\\Student Pictures\\2031436642.jpeg");
						Image studentImage=new Image(stream);
						studentImage1.setImage(studentImage);
						break;
						}
					case "2031519642":{
						InputStream stream = new FileInputStream("src\\Student Pictures\\2031519642.jpg");
						Image studentImage=new Image(stream);
						studentImage1.setImage(studentImage);
						break;
						}
					case "2031523642":{
						InputStream stream = new FileInputStream("src\\Student Pictures\\2031523642.jpg");
						Image studentImage=new Image(stream);
						studentImage1.setImage(studentImage);
						break;
						}
					case "2112183642":{
						InputStream stream = new FileInputStream("src\\Student Pictures\\2112183642.jpg");
						Image studentImage=new Image(stream);
						studentImage1.setImage(studentImage);
						break;
						}
					case "2112348642":{
						InputStream stream = new FileInputStream("src\\Student Pictures\\2112348642.jpg");
						Image studentImage=new Image(stream);
						studentImage1.setImage(studentImage);
						break;
						}
					case "2121443642":{
						InputStream stream = new FileInputStream("src\\Student Pictures\\2121443642.jpg");
						Image studentImage=new Image(stream);
						studentImage1.setImage(studentImage);
						break;
						}
					default:{
						if(ShowAcademicInfoController.gender.equals("Male")) {
							InputStream stream = new FileInputStream("src\\Student Pictures\\default boys.jpg");
							Image studentImage=new Image(stream);
							studentImage1.setImage(studentImage);
						}
						else if(ShowAcademicInfoController.gender.equals("Female")) {
							InputStream stream = new FileInputStream("src\\Student Pictures\\WomanDefault.jpg");
							Image studentImage=new Image(stream);
							studentImage1.setImage(studentImage);
						}	
					}
					}
					
				}catch (Exception e) {
					System.out.println(e);
				}	
				
			}
		
			} catch (Exception e) {
				System.out.println(e);
				//System.out.println("File Error!");
		}	
	}

}
