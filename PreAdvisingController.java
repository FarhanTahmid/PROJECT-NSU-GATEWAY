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

public class PreAdvisingController implements Initializable {

    @FXML
    private TableView<PreAdvisingInitializer> preAdvisingTable;

    @FXML
    private TableColumn<PreAdvisingInitializer, String> serialnocolumn;

    @FXML
    private TableColumn<PreAdvisingInitializer, String> courseinitialcolumn;

    @FXML
    private TableColumn<PreAdvisingInitializer, String> coursecreditcolumn;

    @FXML
    private TableColumn<PreAdvisingInitializer, String> coursetitlecolumn;

    @FXML
    private TableColumn<PreAdvisingInitializer, String> departmentColumn;

    @FXML
    private TextField searchtextField;

    @FXML
    private TextField priorityTextField;

    @FXML
    private Button gotoHome;

    @FXML
    private Button saveSession;
    @FXML
    private Button adviseCourseButton;
    
    private Stage stage;
    
    @FXML
    void goHome(ActionEvent event) {
    	stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		stage.close();
    }
    Scene scene;
    Parent root;
    PreAdvisedListController controller;
    @FXML
    void savSession(ActionEvent event) throws IOException {
    	Stage stage=new Stage();
    	FXMLLoader loader=new FXMLLoader(getClass().getResource("preAdvisingConfirmation.fxml"));
    	root=(Parent)loader.load();
    	controller =loader.getController();
    	//controller.initializingInfo(preAdvisedData);
    	scene=new Scene(root);
    	stage.setScene(scene);
    	stage.show();
    }
    
    private static Scanner reader;
    final ObservableList<PreAdvisingInitializer>coursesData=FXCollections.observableArrayList();
    
    
    
    SortedList<PreAdvisingInitializer>sortedCourseList;
    String filePath="src//Advising Data//PreAdvisingCourseList.csv";
    String serialno="";
    String courseInitial="";
    String courseCredit="";
    String time="";
    String section="";
    String facultyName="";
    String department="";
    String coursetitle="";
    Button[] button=new Button[60];
    public void buttonHandler(ActionEvent event) {
    	for(int i=0;i<button.length;i++) {
        	System.out.println("clicked");
    	}
    }
    

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			reader=new Scanner(new File(filePath));
			reader.useDelimiter("[,\n]");
			while(reader.hasNext()) {
				
				serialno=reader.next();
				courseInitial=reader.next();
				courseCredit=reader.next();
				time=reader.next();
				section=reader.next();
				facultyName=reader.next();
				department=reader.next();
				coursetitle=reader.next();
				coursesData.add(new PreAdvisingInitializer(serialno, courseInitial, courseCredit, coursetitle, department,time,section,facultyName));
				
			}
		} catch (FileNotFoundException e) {
			System.out.println(e);
			
		}catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		
		
		
		this.serialnocolumn.setCellValueFactory(new PropertyValueFactory<PreAdvisingInitializer,String>("serialNo"));
		this.courseinitialcolumn.setCellValueFactory(new PropertyValueFactory<PreAdvisingInitializer,String>("courseInitial"));
		this.coursecreditcolumn.setCellValueFactory(new PropertyValueFactory<PreAdvisingInitializer,String>("courseCredit"));
		this.coursetitlecolumn.setCellValueFactory(new PropertyValueFactory<PreAdvisingInitializer,String>("courseTitle"));
		this.departmentColumn.setCellValueFactory(new PropertyValueFactory<PreAdvisingInitializer,String>("rootDepartment"));
		
		
		FilteredList<PreAdvisingInitializer>filteredData=new FilteredList<>(coursesData,b ->true);
		this.searchtextField.textProperty().addListener((observable,oldValue,newValue)->{
			filteredData.setPredicate(course -> {
				if(newValue==null || newValue.isEmpty()) {
					return true;
				}
				String lowerCaseFilter=newValue.toLowerCase();
				
				if(course.getCourseInitial().toLowerCase().indexOf(lowerCaseFilter)!= -1) {
					return true;
				}
				else if(course.getCourseCredit().toLowerCase().indexOf(lowerCaseFilter)!= -1) {
					return true;
				}
				else if(course.getCourseTitle().toLowerCase().indexOf(lowerCaseFilter)!= -1) {
					return true;
				}
				else if(course.getRootDepartment().toLowerCase().indexOf(lowerCaseFilter)!= -1 ) {
					return true;
				}
				
				else {
					return false;
				}
			});
		});
		
		sortedCourseList=new SortedList<>(filteredData);
		sortedCourseList.comparatorProperty().bind(preAdvisingTable.comparatorProperty());
	
		
		
		
		this.preAdvisingTable.setItems(sortedCourseList);
	}
	static ObservableList<PreAdvisingInitializer>preAdvisedData=FXCollections.observableArrayList();
    PreAdvisingInitializer getdatafrombutton;
	@FXML
    void adviseCourse(ActionEvent event) throws FileNotFoundException {
    	getdatafrombutton=this.preAdvisingTable.getSelectionModel().getSelectedItem();
    	preAdvisedData.add(new PreAdvisingInitializer(getdatafrombutton.getSerialNo(), getdatafrombutton.getCourseInitial(), getdatafrombutton.getCourseCredit(), getdatafrombutton.getCourseTitle()
    			, getdatafrombutton.getRootDepartment(),getdatafrombutton.getTime(),getdatafrombutton.getSection(),getdatafrombutton.getFaculty()));
    	
    }
    

}

