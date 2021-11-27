package application;



import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.NoSuchElementException;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class StudentCourseFall2020Controller implements Initializable {

    @FXML
    private Label studentIDLabel;

    @FXML
    private Label studentNameLabe;

    @FXML
    private TableView<CourseInitializer> fall20Courses;

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

    private Stage stage;
    private Scene scene;
    
    @FXML
    void goHome(ActionEvent event) {
    	stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		stage.close();
    }
    static String ID;
    
    public void staticInitializer(String idnumber) {
    	StudentCourseFall2020Controller.ID=idnumber;
    	//System.out.println(StudentCourseFall2020Controller.ID);
    }
    
    
    
    String fileID="";
    String fileCourse1="";
    String fileFaculty1="";
    String fileSection1="";
    String fileTime1="";
    
    String fileCourse2="";
    String fileFaculty2="";
    String fileSection2="";
    String fileTime2="";
    
    String fileCourse3="";
    String fileFaculty3="";
    String fileSection3="";
    String fileTime3="";
    
    String fileCourse4="";
    String fileFaculty4="";
    String fileSection4="";
    String fileTime4="";
    String fileName="";
    String fileSerialNo="";
    String fileCG1="";
    String fileCG2="";
    String fileCG3="";
    String fileCG4="";
    
    private static Scanner reader;
    private static Scanner reader2;
    
    String filepath="src//StudentCoursesHistory//Fall 2020_courses_F.csv";
    
    final ObservableList<CourseInitializer>courseData=FXCollections.observableArrayList();
    
    public void infoInitializer(String idNumber) {
    	
    }
    
    
    
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			reader=new Scanner(new File(filepath));
			reader.useDelimiter("[,\n]");
			boolean found=false;
			while(reader.hasNext()&& !found) {
				fileID=reader.next();
				
				fileCourse1=reader.next();
				fileFaculty1=reader.next();
				fileSection1=reader.next();
				fileTime1=reader.next();
				
				fileCourse2=reader.next();
				fileFaculty2=reader.next();
				fileSection2=reader.next();
				fileTime2=reader.next();
				
				
				fileCourse3=reader.next();
				fileFaculty3=reader.next();
				fileSection3=reader.next();
				fileTime3=reader.next();
				
				
				fileCourse4=reader.next();
				fileFaculty4=reader.next();
				fileSection4=reader.next();
				fileTime4=reader.next();
				
				fileName=reader.next();
				
				fileSerialNo=reader.next();
				
				fileCG1=reader.next();
				fileCG2=reader.next();
				fileCG3=reader.next();
				fileCG4=reader.next();
				if(fileID.equals(StudentCourseFall2020Controller.ID)) {
					found=true;
				}
			}
			
			if(found) {
				this.studentIDLabel.setText(fileID);
				this.studentNameLabe.setText(fileName);
				
				PrintWriter writer=new PrintWriter(new File("src//StudentCoursesHistory//tempfall2020.csv"));
				
				StringBuilder builder=new StringBuilder();
				
				builder.append("1");
				builder.append(",");
				builder.append(this.fileCourse1);
				builder.append(",");
				builder.append(this.fileFaculty1);
				builder.append(",");
				builder.append(this.fileSection1);
				builder.append(",");
				builder.append(this.fileTime1);
				builder.append(",");
				builder.append(this.fileCG1);
				builder.append("\r\n");
				
				builder.append("2");
				builder.append(",");
				builder.append(this.fileCourse2);
				builder.append(",");
				builder.append(this.fileFaculty2);
				builder.append(",");
				builder.append(this.fileSection2);
				builder.append(",");
				builder.append(this.fileTime2);
				builder.append(",");
				builder.append(this.fileCG2);
				builder.append("\r\n");
				
				builder.append("3");
				builder.append(",");
				builder.append(this.fileCourse3);
				builder.append(",");
				builder.append(this.fileFaculty3);
				builder.append(",");
				builder.append(this.fileSection3);
				builder.append(",");
				builder.append(this.fileTime3);
				builder.append(",");
				builder.append(this.fileCG3);
				builder.append("\r\n");
				
				builder.append("4");
				builder.append(",");
				builder.append(this.fileCourse4);
				builder.append(",");
				builder.append(this.fileFaculty4);
				builder.append(",");
				builder.append(this.fileSection4);
				builder.append(",");
				builder.append(this.fileTime4);
				builder.append(",");
				builder.append(this.fileCG4);
				builder.append("\r\n");
				writer.write(builder.toString());
				writer.checkError();
				
				try {
					reader2=new Scanner(new File("src//StudentCoursesHistory//tempfall2020.csv"));
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
				
				
			
			}
			
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			e.printStackTrace();
		}catch (NoSuchElementException e) {
			System.out.println("Data missing");
		}
		this.courseSerialNo.setCellValueFactory(new PropertyValueFactory<CourseInitializer, String>("Serialno"));
		this.courseInitialColumn.setCellValueFactory(new PropertyValueFactory<CourseInitializer, String>("courseInitial"));
		this.facultyInitalColumn.setCellValueFactory(new PropertyValueFactory<CourseInitializer, String>("facultyInitial"));
		this.sectionColumn.setCellValueFactory(new PropertyValueFactory<CourseInitializer, String>("section"));
		this.timeColumn.setCellValueFactory(new PropertyValueFactory<CourseInitializer, String>("time"));
		this.gradeColumn.setCellValueFactory(new PropertyValueFactory<CourseInitializer, String>("grades"));
		
		this.fall20Courses.setItems(courseData);
	}
}

