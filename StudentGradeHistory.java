package application;

import java.io.File;
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

public class StudentGradeHistory implements Initializable {

    @FXML
    private TableView<CourseInitializer> summer21Courses;

    @FXML
    private TableColumn<CourseInitializer, String> summer2021courseSerialNo;

    @FXML
    private TableColumn<CourseInitializer, String> summer2021courseInitialColumn;

    @FXML
    private TableColumn<CourseInitializer, String> summer2021facultyInitalColumn;

    @FXML
    private TableColumn<CourseInitializer, String> summer2021sectionColumn;

    @FXML
    private TableColumn<CourseInitializer, String> summer2021gradeColumn;

    @FXML
    private TableView<CourseInitializer> fall2020Courses;

    @FXML
    private TableColumn<CourseInitializer, String> fall2020courseSerialNo2;

    @FXML
    private TableColumn<CourseInitializer, String> fall2020courseInitialColumn2;

    @FXML
    private TableColumn<CourseInitializer, String> fall2020facultyInitalColumn2;

    @FXML
    private TableColumn<CourseInitializer, String> fall2020sectionColumn2;

    @FXML
    private TableColumn<CourseInitializer, String> fall2020gradeColumn2;

    @FXML
    private TableView<CourseInitializer> spring21Courses;

    @FXML
    private TableColumn<CourseInitializer, String> spring21courseSerialNo1;

    @FXML
    private TableColumn<CourseInitializer, String> spring21courseInitialColumn1;

    @FXML
    private TableColumn<CourseInitializer, String> spring21facultyInitalColumn1;

    @FXML
    private TableColumn<CourseInitializer, String> spring21sectionColumn1;

    @FXML
    private TableColumn<CourseInitializer, String> spring21gradeColumn1;

    @FXML
    private Button homebutton;
    
    private Stage stage;
    @FXML
    void goHome(ActionEvent event) {
    	stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		stage.close();
    }
    static Scanner reader2;
    final ObservableList<CourseInitializer>courseData=FXCollections.observableArrayList();
    final ObservableList<CourseInitializer>courseData2=FXCollections.observableArrayList();


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			reader2=new Scanner(new File("src//StudentCoursesHistory//tempsummer2021.csv"));
			reader2.useDelimiter("[,\n]");
			while(reader2.hasNext()) {
				String serial=reader2.next();
				String course=reader2.next();
				String facultyInitial=reader2.next();
				String section=reader2.next();
				String time=reader2.next();
				String grader=reader2.next();
				courseData.add(new CourseInitializer(serial, course, facultyInitial, section, time, grader));
				
		}
		
		}catch (Exception e) {
			System.out.println("Can not read file");
			System.out.println(e);
		}
		this.summer2021courseSerialNo.setCellValueFactory(new PropertyValueFactory<CourseInitializer, String>("Serialno"));
		this.summer2021courseInitialColumn.setCellValueFactory(new PropertyValueFactory<CourseInitializer, String>("courseInitial"));
		this.summer2021facultyInitalColumn.setCellValueFactory(new PropertyValueFactory<CourseInitializer, String>("facultyInitial"));
		this.summer2021sectionColumn.setCellValueFactory(new PropertyValueFactory<CourseInitializer, String>("section"));
		//this.timeColumn.setCellValueFactory(new PropertyValueFactory<CourseInitializer, String>("time"));
		this.summer2021gradeColumn.setCellValueFactory(new PropertyValueFactory<CourseInitializer, String>("grades"));
		
		this.summer21Courses.setItems(courseData);
		
		
		try {
			reader2=new Scanner(new File("src//StudentCoursesHistory//tempspring2021.csv"));
			reader2.useDelimiter("[,\n]");
			while(reader2.hasNext()) {
				String serial=reader2.next();
				String course=reader2.next();
				String facultyInitial=reader2.next();
				String section=reader2.next();
				String time=reader2.next();
				String grader=reader2.next();
				courseData2.add(new CourseInitializer(serial, course, facultyInitial, section, time, grader));
				
		}
		
		}catch (Exception e) {
			System.out.println("Can not read file");
			System.out.println(e);
		}
		
		this.spring21courseSerialNo1.setCellValueFactory(new PropertyValueFactory<CourseInitializer, String>("Serialno"));
		this.spring21courseInitialColumn1.setCellValueFactory(new PropertyValueFactory<CourseInitializer, String>("courseInitial"));
		this.spring21facultyInitalColumn1.setCellValueFactory(new PropertyValueFactory<CourseInitializer, String>("facultyInitial"));
		this.spring21sectionColumn1.setCellValueFactory(new PropertyValueFactory<CourseInitializer, String>("section"));
		//this.timeColumn.setCellValueFactory(new PropertyValueFactory<CourseInitializer, String>("time"));
		this.spring21gradeColumn1.setCellValueFactory(new PropertyValueFactory<CourseInitializer, String>("grades"));
		
		this.spring21Courses.setItems(courseData2);
		
	}

}

