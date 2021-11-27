package application;


import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class AdminEmployeeController implements Initializable {
	@FXML
    private TableView<AdminStudentDatabaseInitializer> tableEmployee;

    @FXML
    private TableColumn<AdminStudentDatabaseInitializer, String> tableEmployeeId;

    @FXML
    private TableColumn<AdminStudentDatabaseInitializer, String> tableEmployeeNAme;

    @FXML
    private TableColumn<AdminStudentDatabaseInitializer, String> tableEmployeeDesignation;

    @FXML
    private TableColumn<AdminStudentDatabaseInitializer, String> tableEmployeeType;

    @FXML
    private TableColumn<AdminStudentDatabaseInitializer, String> tableEmployeeOffice;


    @FXML
    private TextField searchField;
    
    @FXML
    private Button homeButton;
    private Stage stage;
    @FXML
    void goHome(ActionEvent event) {
    	stage=(Stage)((Node)event.getSource()).getScene().getWindow();
    	stage.close();
    }
    final ObservableList<AdminStudentDatabaseInitializer>employeeData=FXCollections.observableArrayList();
    static SortedList<AdminStudentDatabaseInitializer>sortedEmployeeList;
    static Scanner reader;
    String employeID="";
    String employeeName="";
    String employeeDesignation="";
    String employeeType="";
    String employeeOffice="";
    

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			reader=new Scanner(new File("src//Admin Files//Employee-List.csv"));
			reader.useDelimiter("[,\n]");
			while(reader.hasNext()) {
				employeID=reader.next();
				employeeName=reader.next();
				employeeDesignation=reader.next();
				employeeType=reader.next();
				employeeOffice=reader.next();
				employeeData.add(new AdminStudentDatabaseInitializer(employeID, employeeName, employeeDesignation, employeeType, employeeOffice));
			
			}
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		this.tableEmployeeId.setCellValueFactory(new PropertyValueFactory<AdminStudentDatabaseInitializer,String>("studentID"));
		this.tableEmployeeNAme.setCellValueFactory(new PropertyValueFactory<AdminStudentDatabaseInitializer,String>("studentName"));
		this.tableEmployeeDesignation.setCellValueFactory(new PropertyValueFactory<AdminStudentDatabaseInitializer,String>("studentDepartment"));
		this.tableEmployeeType.setCellValueFactory(new PropertyValueFactory<AdminStudentDatabaseInitializer,String>("studentCurrentCurriculum"));
		this.tableEmployeeOffice.setCellValueFactory(new PropertyValueFactory<AdminStudentDatabaseInitializer,String>("enrollmentSemester"));
		
		FilteredList<AdminStudentDatabaseInitializer>sortData=new FilteredList<>(employeeData,b -> true);
		this.searchField.textProperty().addListener((observable,oldvalue,newValue)->{
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
		
		sortedEmployeeList=new SortedList<AdminStudentDatabaseInitializer>(sortData);
		sortedEmployeeList.comparatorProperty().bind(this.tableEmployee.comparatorProperty());
		
		this.tableEmployee.setItems(sortData);
	}

}
