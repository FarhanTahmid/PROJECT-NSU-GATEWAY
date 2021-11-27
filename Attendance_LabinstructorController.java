package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class Attendance_LabinstructorController extends ExtractingInfoFromDatabase implements Initializable{

    @FXML
    private TableView<AttendanceInitializer> attendanceTableLabinstructor;

    @FXML
    private TableColumn<AttendanceInitializer, String> studentIDcolumn;

    @FXML
    private TableColumn<AttendanceInitializer, String> studentNameColumn;

    @FXML
    private TableColumn<AttendanceInitializer, String> attendanceButton;

    @FXML
    private TableColumn<AttendanceInitializer, String> presentDaysColumn;

    @FXML
    private TableColumn<AttendanceInitializer, String> absenDaysColumn;

    @FXML
    private Button homeButton;
    @FXML
    private Button submitAttendance;
    private Stage stage;
    private Scene scene;
    @FXML
    void goHome(ActionEvent event) {
    	stage=(Stage)((Node)event.getSource()).getScene().getWindow();
    	stage.close();
    }
    private static int absentDay=0;
    private static int presentDay=0;
    @FXML
    void submitAttendance(ActionEvent event) {
    	ExtractingInfoFromDatabase database=new ExtractingInfoFromDatabase();
    	for(int i=0;i<attendance.size();i++) {
    		if(attendance.get(i).getButton().isSelected()) {
    			attendance.get(i).setPresentDay(presentDay++);
    			attendance.get(i).setAbsentDay(absentDay);
    			database.initializingAttendance(presentDay, absentDay);
    		}
    		else {
    			attendance.get(i).setPresentDay(presentDay++);
    			attendance.get(i).setAbsentDay(absentDay++);
    			database.initializingAttendance(presentDay, absentDay);
    		}
    	}
    	
    	
    	getdata();
    	System.out.println("Clicked");
    	System.out.println(attendance.get(0).getPresentDay());
    	System.out.println(attendance.get(1).getAbsentDay());
    	
    }
    
    ObservableList<AttendanceInitializer> attendance=FXCollections.observableArrayList();
	void getdata() {
		ExtractingInfoFromDatabase database=new ExtractingInfoFromDatabase();
		attendance.addAll(database.labInstructorAttendanceinfoInitializer("src//FacultyFiles//CSE215.4LabMonamyMam.csv"));
	}
	
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		getdata();
		this.studentIDcolumn.setCellValueFactory(new PropertyValueFactory<AttendanceInitializer,String>("id"));
		this.studentNameColumn.setCellValueFactory(new PropertyValueFactory<AttendanceInitializer,String>("name"));
		this.attendanceButton.setCellValueFactory(new PropertyValueFactory<AttendanceInitializer,String>("button"));
		this.presentDaysColumn.setCellValueFactory(new PropertyValueFactory<AttendanceInitializer,String>("presentDay"));
		this.absenDaysColumn.setCellValueFactory(new PropertyValueFactory<AttendanceInitializer,String>("absentDay"));
		this.attendanceTableLabinstructor.setItems(attendance);
	}
}