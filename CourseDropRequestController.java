package application;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.URL;

import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.beans.value.WritableBooleanValue;
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

public class CourseDropRequestController implements Initializable{
	

    @FXML
    private TableView<CourseInitializer> summer21Courses;

    @FXML
    private TableColumn<CourseInitializer, String> courseSerialNo;

    @FXML
    private TableColumn<CourseInitializer, String> courseInitialColumn;

    @FXML
    private TableColumn<CourseInitializer, String> facultyInitalColumn;

    @FXML
    private TableColumn<CourseInitializer, String> sectionColumn;

    @FXML
    private TableColumn<CourseInitializer, String> timeColumn;

    @FXML
    private TableColumn<CourseInitializer, String> gradeColumn;

    @FXML
    private Button homeButton;
  

    @FXML
    private Button dropButton;
    private Stage stage;
    
    CourseInitializer datafromButton;
	static String courseDropFile="src//StudentCoursesHistory//studentCourseDrop.csv";	
	PrintWriter writer;
	final ObservableList<CourseInitializer>droppingCourseData=FXCollections.observableArrayList();
	
	
	@FXML
    void dropButton(ActionEvent event) {
    	datafromButton=this.summer21Courses.getSelectionModel().getSelectedItem();
    	droppingCourseData.add(new CourseInitializer(datafromButton.getSerialno(), datafromButton.getCourseInitial(), datafromButton.getFacultyInitial(), datafromButton.getSection(),datafromButton.getTime() , datafromButton.getGrades()));
    	try {
			writer=new PrintWriter(courseDropFile);
			for(int i=0;i<droppingCourseData.size();i++) {
				writer.append(CourseDropRequestController.ID);
				writer.append(",");
				writer.append(droppingCourseData.get(i).getCourseInitial());
				writer.append(",");
				writer.append(droppingCourseData.get(i).getFacultyInitial());
				writer.append(",");
				writer.append(droppingCourseData.get(i).getSection());
				writer.append("\n");
			}
			writer.flush();
			writer.close();
		}
    	catch (FileNotFoundException e) {
			System.out.println("File not created");
			e.printStackTrace();
		}
    	writer.flush();
    	writer.close();
    }
    
    
    @FXML
    void goHome(ActionEvent event) {
    	stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		stage.close();
    }
    static String ID;
    public void staticInitializer(String idnumber) {
    	CourseDropRequestController.ID=idnumber;
    	
    }
    
    private static Scanner reader;
    String filepath="src//StudentCoursesHistory//tempsummer2021.csv";
    
    final ObservableList<CourseInitializer>courseData1=FXCollections.observableArrayList();
    String serial="";
    String course="";
    String facultyInitial="";
    String section="";
    String time="";
    String grade="";
    
	@Override	
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			reader=new Scanner(new File(filepath));
			reader.useDelimiter("[,\n]");
			while(reader.hasNext()) {
				serial=reader.next();
				course=reader.next();
				facultyInitial=reader.next();
				section=reader.next();
				time=reader.next();
				grade=reader.next();
				courseData1.add(new CourseInitializer(serial, course, facultyInitial, section, time, grade));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.courseSerialNo.setCellValueFactory(new PropertyValueFactory<CourseInitializer, String>("Serialno"));
		this.courseInitialColumn.setCellValueFactory(new PropertyValueFactory<CourseInitializer, String>("courseInitial"));
		this.facultyInitalColumn.setCellValueFactory(new PropertyValueFactory<CourseInitializer, String>("facultyInitial"));
		this.sectionColumn.setCellValueFactory(new PropertyValueFactory<CourseInitializer, String>("section"));
		this.timeColumn.setCellValueFactory(new PropertyValueFactory<CourseInitializer, String>("time"));
		this.gradeColumn.setCellValueFactory(new PropertyValueFactory<CourseInitializer, String>("grades"));
		
		this.summer21Courses.setItems(courseData1);
		
	}
		
}
