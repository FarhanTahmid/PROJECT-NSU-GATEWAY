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
import javafx.scene.control.TextField;import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class AdminStudentDatabaseController implements Initializable {

    @FXML
    private TableView<AdminStudentDatabaseInitializer> studentDtabaseTable;

    @FXML
    private TableColumn<AdminStudentDatabaseInitializer, String> studentDatabaseID;

    @FXML
    private TableColumn<AdminStudentDatabaseInitializer, String> studentDatabaseName;

    @FXML
    private TableColumn<AdminStudentDatabaseInitializer, String> studentDatabaseDepartment;

    @FXML
    private TableColumn<AdminStudentDatabaseInitializer, String> studetDatabAseCurrentCurriculum;

    @FXML
    private TableColumn<AdminStudentDatabaseInitializer, String> studentDatabaseEnrollmentSemester;

    @FXML
    private TextField searchTextField;

    @FXML
    private Button HomeButton;

    @FXML
    private Button addStudentIndatabaseButton;

    @FXML
    private Button DeleteStudentInDatabaseButton;
    @FXML
    private Button refreshButton;
    private Stage stage;
    private Parent root;
    private Scene scene;
    @FXML
    void refresh(ActionEvent event) throws IOException {
    	stage=new Stage();
    	FXMLLoader loader=new FXMLLoader(getClass().getResource("AdminStudentDatabase.fxml"));
    	root=loader.load();
    	AdminStudentDatabaseController controller=loader.getController();
    	Scene scene=new Scene(root);
    	stage.setScene(scene);
    	stage=(Stage)((Node)event.getSource()).getScene().getWindow();
    	stage.show();
    }

    @FXML
    void addstudentInDatabase(ActionEvent event) throws IOException {
    	stage=new Stage();
    	FXMLLoader loader=new FXMLLoader(getClass().getResource("AddStudentBasicInfo.fxml"));
    	root=loader.load();
    	AddStudentDataController controller=loader.getController();
    	
    	Scene scene=new Scene(root);
    	stage.setScene(scene);
    	//stage=(Stage)((Node)event.getSource()).getScene().getWindow();
    	stage.show();
    	
    	
    }
    void addStudent(String newStudentID,String newStudentName,String newStudentDepartment,String newStudentCourseCurriculum,String newStudentSemester) {
    
    	AdminStudentInformationController.studentID=newStudentID;
    	AdminStudentInformationController.studentName=newStudentName;
    	AdminStudentInformationController.departmentName=newStudentDepartment;
    	AdminStudentInformationController.currentCurriculum=newStudentCourseCurriculum;
    	AdminStudentInformationController.enrollmentSemester=newStudentSemester;
    	AdminStudentInformationController.studentData.add(new AdminStudentDatabaseInitializer(AdminStudentInformationController.studentID, AdminStudentInformationController.studentName, AdminStudentInformationController.departmentName, AdminStudentInformationController.currentCurriculum, AdminStudentInformationController.enrollmentSemester));	
    }

    @FXML
    void deleteStudent(ActionEvent event) {
    	int visibleIndex = this.studentDtabaseTable.getSelectionModel().getSelectedIndex();
		int sourceIndex = sortedStudentList.getSourceIndexFor(AdminStudentInformationController.studentData, visibleIndex);   //sortecoursedata is the new SortedList
		AdminStudentInformationController.studentData.remove(sourceIndex); //courseData is the main list
    	
    }
    
    
    @FXML
    void goHome(ActionEvent event) throws IOException {
    	
		stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		
		stage.close();
    }
    static SortedList<AdminStudentDatabaseInitializer>sortedStudentList;
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
				AdminStudentInformationController.studentData.add(new AdminStudentDatabaseInitializer(AdminStudentInformationController.studentID, AdminStudentInformationController.studentName, AdminStudentInformationController.departmentName, AdminStudentInformationController.currentCurriculum, AdminStudentInformationController.enrollmentSemester));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.studentDatabaseID.setCellValueFactory((new PropertyValueFactory<AdminStudentDatabaseInitializer,String>("studentID")));
		this.studentDatabaseName.setCellValueFactory((new PropertyValueFactory<AdminStudentDatabaseInitializer,String>("studentName")));
		this.studentDatabaseDepartment.setCellValueFactory((new PropertyValueFactory<AdminStudentDatabaseInitializer,String>("studentDepartment")));
		this.studetDatabAseCurrentCurriculum.setCellValueFactory((new PropertyValueFactory<AdminStudentDatabaseInitializer,String>("studentCurrentCurriculum")));
		this.studentDatabaseEnrollmentSemester.setCellValueFactory((new PropertyValueFactory<AdminStudentDatabaseInitializer,String>("enrollmentSemester")));
		
		FilteredList<AdminStudentDatabaseInitializer>sortData=new FilteredList<>(AdminStudentInformationController.studentData,b -> true);
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
		sortedStudentList=new SortedList<AdminStudentDatabaseInitializer>(sortData);
		sortedStudentList.comparatorProperty().bind(studentDtabaseTable.comparatorProperty());
		this.studentDtabaseTable.setItems(sortData);		
	}

}

