package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class StudentRequestStatusController implements Initializable {
	@FXML
    private TableView<RequestsStatusInitializer> courseDropStatusTable;

    @FXML
    private TableColumn<RequestsStatusInitializer, String> serialnoColumn;

    @FXML
    private TableColumn<RequestsStatusInitializer, String> courseInitialColumn;

    @FXML
    private TableColumn<RequestsStatusInitializer, String> facultyInitialColumn;

    @FXML
    private TableColumn<RequestsStatusInitializer, String> sectionColumn;

    @FXML
    private TableColumn<RequestsStatusInitializer, String> statusColumn;

    @FXML
    private Button homeButton;
    
    private Stage stage;
    
    @FXML
    void goHome(ActionEvent event) {
    	stage=(Stage)((Node)event.getSource()).getScene().getWindow();
    	stage.close();
    }
    
    static Scanner reader;
    static Scanner reader1;
    static Scanner reader2;
 
    
    String studentID="";
    String courseInitial="";
    String facultyInitial="";
    String section="";
    
    
    String adminStudentID="";
    String adminCourseInitial="";
    String adminFacultyInitial="";
    String adminSection="";
    String serialNoString="";
   
    
    String adminRejectedStudentID="";
    String adminRejectedCourseInitial="";
    String adminRejectedFacultyInitial="";
    String adminRejectedSection="";
        static String status;
   
    
    ObservableList<RequestsStatusInitializer>requestcourse=FXCollections.observableArrayList();
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		try {
			reader2=new Scanner(new File("src//Admin Files//rejectedCoursesDrop.csv"));
			reader2.useDelimiter("[,\n]");
			while(reader2.hasNext()) {
				adminRejectedStudentID=reader2.next();
				adminRejectedCourseInitial=reader2.next();
				adminRejectedFacultyInitial=reader2.next();
				adminRejectedSection=reader2.next();
			}
		} catch (FileNotFoundException e1) {
			
		}
		
		
		try {
			reader=new Scanner(new File("src//Admin Files//acceptedCourseDrops.csv"));
			reader.useDelimiter("[,\n]");
			while(reader.hasNext()) {
				adminStudentID=reader.next();
				adminCourseInitial=reader.next();
				adminFacultyInitial=reader.next();
				adminSection=reader.next();
			}
    	} catch (FileNotFoundException e) {
			
		}
		
		try {
			reader1=new Scanner(new File("src//StudentCoursesHistory//studentCourseDrop.csv"));
			reader1.useDelimiter("[,\n]");
			while(reader1.hasNext()) {
				int i=0;
				studentID=reader1.next();
				courseInitial=reader1.next();
				facultyInitial=reader1.next();
				section=reader1.next();
				String serialno=""+(i+1);
				i++;
				if(adminStudentID.equals(studentID) && adminCourseInitial.equals(courseInitial)) {
					StudentRequestStatusController.status="Accepted";
				}
				else if(adminRejectedStudentID.equals(studentID)&& adminRejectedCourseInitial.equals(courseInitial)) {
					StudentRequestStatusController.status="Rejected";
				}
				else {
					StudentRequestStatusController.status="Not Yet Accepted";
				}
				requestcourse.add(new RequestsStatusInitializer(serialno, courseInitial, facultyInitial, section,StudentRequestStatusController.status));
			}
			
			
    	} catch (FileNotFoundException e) {
			
		}
		
		
		
		this.serialnoColumn.setCellValueFactory(new PropertyValueFactory<RequestsStatusInitializer,String>("studentID"));
		this.courseInitialColumn.setCellValueFactory(new PropertyValueFactory<RequestsStatusInitializer,String>("courseInitial"));
		this.facultyInitialColumn.setCellValueFactory(new PropertyValueFactory<RequestsStatusInitializer,String>("facultyInitial"));
		this.sectionColumn.setCellValueFactory(new PropertyValueFactory<RequestsStatusInitializer,String>("section"));
		this.statusColumn.setCellValueFactory(new PropertyValueFactory<RequestsStatusInitializer,String>("status"));
		this.courseDropStatusTable.setItems(requestcourse);
		
	}
	
}
