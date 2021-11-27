package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.URL;

import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class AdminDropManagementController implements Initializable{

    @FXML
    private TableView<AdminCourseDropInitializer> courseDropTable;

    @FXML
    private TableColumn<AdminCourseDropInitializer, String> columnStudentID;

    @FXML
    private TableColumn<AdminCourseDropInitializer, String> columnCourseInitial;

    @FXML
    private TableColumn<AdminCourseDropInitializer, String> columnFacultyInitial;

    @FXML
    private TableColumn<AdminCourseDropInitializer, String> columnSection;

    @FXML
    private Button dropAcceptButton;

    @FXML
    private Button rejectCourseButton;
    
    AdminCourseDropInitializer datafrombutton;
    final ObservableList<AdminCourseDropInitializer>accepted=FXCollections.observableArrayList();
    static String acceptedDropFile="src//Admin Files//acceptedCourseDrops.csv";
    PrintWriter writer;
    @FXML
    void acceptCourseDrop(ActionEvent event) {
    	
    	datafrombutton=this.courseDropTable.getSelectionModel().getSelectedItem();
    	accepted.add(new AdminCourseDropInitializer(datafrombutton.getStudentID(), datafrombutton.getCourseInitial(), datafrombutton.getFacultyInitial(), datafrombutton.getSection()));
    
    	
    	try {
			writer=new PrintWriter(acceptedDropFile);
			for(int i=0;i<accepted.size();i++) {
				writer.append(accepted.get(i).getStudentID());
				writer.append(",");
				writer.append(accepted.get(i).getCourseInitial());
				writer.append(",");
				writer.append(accepted.get(i).getFacultyInitial());
				writer.append(",");
				writer.append(accepted.get(i).getSection());
				writer.append("\n");
			}
			writer.flush();
			writer.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    static String rejectedCourseDropFile="src//Admin Files//rejectedCoursesDrop.csv";
    final ObservableList<AdminCourseDropInitializer>rejected=FXCollections.observableArrayList();
    @FXML
    void rejectCourseButton(ActionEvent event) {
    	datafrombutton=this.courseDropTable.getSelectionModel().getSelectedItem();
    	rejected.add(new AdminCourseDropInitializer(datafrombutton.getStudentID(), datafrombutton.getCourseInitial(), datafrombutton.getFacultyInitial(), datafrombutton.getSection()));
    	try {
			writer=new PrintWriter(rejectedCourseDropFile);
			for(int i=0;i<rejected.size();i++) {
				writer.append(rejected.get(i).getStudentID());
				writer.append(",");
				writer.append(rejected.get(i).getCourseInitial());
				writer.append(",");
				writer.append(rejected.get(i).getFacultyInitial());
				writer.append(",");
				writer.append(rejected.get(i).getSection());
				writer.append("\n");
	    	}
			writer.flush();
			writer.close();
    	
    	} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    static Scanner reader;
    String studentID="";
    String courseInitial="";
    String faculty="";
    String section="";
    
    final ObservableList<AdminCourseDropInitializer>adminCourseDrop=FXCollections.observableArrayList();
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			reader=new Scanner(new File("src//StudentCoursesHistory//studentCourseDrop.csv"));
			reader.useDelimiter("[,\n]");
			while(reader.hasNext()) {
				studentID=reader.next();
				courseInitial=reader.next();
				faculty=reader.next();
				section=reader.next();
				
				adminCourseDrop.add(new AdminCourseDropInitializer(studentID, courseInitial, faculty, section));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e) {
			System.out.println(e);
		}
		
		this.columnStudentID.setCellValueFactory(new PropertyValueFactory<AdminCourseDropInitializer,String>("studentID"));
		this.columnCourseInitial.setCellValueFactory(new PropertyValueFactory<AdminCourseDropInitializer,String>("courseInitial"));
		this.columnFacultyInitial.setCellValueFactory(new PropertyValueFactory<AdminCourseDropInitializer,String>("facultyInitial"));
		this.columnSection.setCellValueFactory(new PropertyValueFactory<AdminCourseDropInitializer,String>("section"));
		
		this.courseDropTable.setItems(adminCourseDrop);
	}

}
