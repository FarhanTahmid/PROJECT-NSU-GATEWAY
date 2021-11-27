package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class AdminStudentInformationController implements Initializable{

    @FXML
    private TextField searchTextField;

    @FXML
    private Button showPersonalInfoButton;

    @FXML
    private Button showAcademcInfoButton;

    @FXML
    private Button goHomeButton;
    
    private Stage stage;

    @FXML
    private TableView<AdminStudentDatabaseInitializer> studentDataTable;

    @FXML
    private TableColumn<AdminStudentDatabaseInitializer, String> studentIDColumn;

    @FXML
    private TableColumn<AdminStudentDatabaseInitializer, String> studentNameColumn;

    @FXML
    private TableColumn<AdminStudentDatabaseInitializer, String> studentDepartmentColumn;

    @FXML
    private TableColumn<AdminStudentDatabaseInitializer, String> studentCurrentCurriculumcolum;

    @FXML
    private TableColumn<AdminStudentDatabaseInitializer, String> studentEnrollmentSemester;
    @FXML
    private Button emailSendButton;
    
    
    @FXML
    void goHome(ActionEvent event) {
    	stage=(Stage)((Node)event.getSource()).getScene().getWindow();
    	stage.close();
    }
    
    Parent root;
    static ObservableList<AdminStudentDatabaseInitializer>getInfo=FXCollections.observableArrayList();
    @FXML
    void showAcademicInfo(ActionEvent event) throws IOException {
    	AdminStudentDatabaseInitializer datafromTable;
    	String id="";
    	datafromTable=this.studentDataTable.getSelectionModel().getSelectedItem();
    	
    	getInfo.add(new AdminStudentDatabaseInitializer(datafromTable.getStudentID(),datafromTable.getStudentName(),datafromTable.getStudentDepartment(), datafromTable.getStudentCurrentCurriculum(), datafromTable.getEnrollmentSemester()));
    	for(int i=0;i<getInfo.size();i++) {
    		id=getInfo.get(i).getStudentID();
    	}
    	
    	FXMLLoader loader=new FXMLLoader(getClass().getResource("ShowAcademicInfo.fxml"));
		root=loader.load();
		ShowAcademicInfoController passer=(ShowAcademicInfoController) loader.getController();
		passer.staticInitializer(id);
		passer.ShowAcademicInfo(id);
		
		Scene scene=new Scene(root);
    	stage=new Stage();
    	stage.setScene(scene);
    	stage.show();
    }

    @FXML
    void showPersonalInfo(ActionEvent event) throws IOException {
    	AdminStudentDatabaseInitializer datafromTable;
    	String id="";
    	datafromTable=this.studentDataTable.getSelectionModel().getSelectedItem();
    	
    	getInfo.add(new AdminStudentDatabaseInitializer(datafromTable.getStudentID(),datafromTable.getStudentName(),datafromTable.getStudentDepartment(), datafromTable.getStudentCurrentCurriculum(), datafromTable.getEnrollmentSemester()));
    	for(int i=0;i<getInfo.size();i++) {
    		id=getInfo.get(i).getStudentID();
    		
    	}
    	
    	FXMLLoader loader=new FXMLLoader(getClass().getResource("ShowPersonalInfo.fxml"));
		root=loader.load();
		ShowPersonalInfoController passer2=(ShowPersonalInfoController) loader.getController();
		
		passer2.staticInitializer(id);
		passer2.showPersonalInfo(id);
		
		Scene scene=new Scene(root);
    	stage=new Stage();
    	stage.setScene(scene);
    	stage.show();

    }
    
    @FXML
    void sendMail(ActionEvent event) throws IOException {
    	AdminStudentDatabaseInitializer datafromTable;
    	String emailID="";
    	datafromTable=this.studentDataTable.getSelectionModel().getSelectedItem();
    	
    	getInfo.add(new AdminStudentDatabaseInitializer(datafromTable.getStudentID(),datafromTable.getStudentName(),datafromTable.getStudentDepartment(), datafromTable.getStudentCurrentCurriculum(), datafromTable.getEnrollmentSemester()));
    	for(int i=0;i<getInfo.size();i++) {
    		emailID=getInfo.get(i).getEnrollmentSemester();
    	}
    	AdminMiniEmailSendingController idPasser=new AdminMiniEmailSendingController();
    	idPasser.getRecieverid(emailID);
    	FXMLLoader loader=new FXMLLoader(getClass().getResource("AdminMiniEmailLogin.fxml"));
    	root=loader.load();
    	AdminMiniEmailLoginController controller=loader.getController();
    	Scene scene=new Scene(root);
    	stage=new Stage();
    	stage.setScene(scene);
    	stage.show();
    }
    
    
    
    
    
    static SortedList<AdminStudentDatabaseInitializer>sortedStudentList;
    
    static ObservableList<AdminStudentDatabaseInitializer>studentData=FXCollections.observableArrayList();
    static String studentID="";
    static String studentName="";
    static String departmentName="";
    static String currentCurriculum="";
    static String enrollmentSemester="";
    static Scanner reader;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			reader=new Scanner(new File("src//Admin Files//StudentInformation_Adminread.csv"));
			reader.useDelimiter("[,\n]");
			while(reader.hasNext()) {
				AdminStudentInformationController.studentID=reader.next();
				AdminStudentInformationController.studentName=reader.next();
				AdminStudentInformationController.departmentName=reader.next();
				AdminStudentInformationController.currentCurriculum=reader.next();
				AdminStudentInformationController.enrollmentSemester=reader.next();
				AdminStudentInformationController.studentData.add(new AdminStudentDatabaseInitializer(studentID, studentName, departmentName, currentCurriculum, enrollmentSemester));
			}
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		this.studentIDColumn.setCellValueFactory(new PropertyValueFactory<AdminStudentDatabaseInitializer,String>("studentID"));
		this.studentNameColumn.setCellValueFactory(new PropertyValueFactory<AdminStudentDatabaseInitializer,String>("studentName"));
		this.studentDepartmentColumn.setCellValueFactory(new PropertyValueFactory<AdminStudentDatabaseInitializer,String>("studentDepartment"));
		this.studentCurrentCurriculumcolum.setCellValueFactory(new PropertyValueFactory<AdminStudentDatabaseInitializer,String>("studentCurrentCurriculum"));
		this.studentEnrollmentSemester.setCellValueFactory(new PropertyValueFactory<AdminStudentDatabaseInitializer,String>("enrollmentSemester"));
		
		FilteredList<AdminStudentDatabaseInitializer>sortData=new FilteredList<>(studentData,b -> true);
		this.searchTextField.textProperty().addListener((observable,oldvalue,newValue)->{
			sortData.setPredicate(student ->{
				if(newValue==null|| newValue.isEmpty()){
					return true;
				}
				String lowerCaseSort=newValue.toLowerCase();
				String upperCaseSort=newValue.toUpperCase();
				if(student.getStudentID().indexOf(lowerCaseSort)!=-1) {
					return true;
				}
				else if(student.getStudentName().toLowerCase().indexOf(lowerCaseSort)!= -1 || student.getStudentName().toUpperCase().indexOf(upperCaseSort)!= -1) {
					return true;
				}
				else if(student.getStudentDepartment().toLowerCase().indexOf(lowerCaseSort)!= -1 || student.getStudentDepartment().toUpperCase().indexOf(upperCaseSort)!= -1) {
					return true;
				}
				else if(student.getStudentCurrentCurriculum().toLowerCase().indexOf(lowerCaseSort)!= -1 || student.getStudentCurrentCurriculum().toUpperCase().indexOf(upperCaseSort)!= -1) {
					return true;
				}
				else if(student.getEnrollmentSemester().toLowerCase().indexOf(lowerCaseSort)!= -1 || student.getEnrollmentSemester().toUpperCase().indexOf(upperCaseSort)!= -1) {
					return true;
				}
				else {
					return false;
				}
			});
		});
		sortedStudentList=new SortedList<>(sortData);
		sortedStudentList.comparatorProperty().bind(studentDataTable.comparatorProperty());
		
		this.studentDataTable.setItems(sortData);

	}
	

}

