package application;


import java.io.File;
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

public class Cse215sec04LabController extends AdminMiniEmailSendingController implements Initializable {

    @FXML
    private TableView<CourseStudentListInfo> cse215sec04Lab;

    @FXML
    private TableColumn<CourseStudentListInfo, String> tableserialNo;

    @FXML
    private TableColumn<CourseStudentListInfo, String> tableStudentID;

    @FXML
    private TableColumn<CourseStudentListInfo, String> tablleStudentName;
    
    @FXML
    private TableColumn<CourseStudentListInfo, String> emailAddress;
    @FXML
    private TextField searchField;
    @FXML
    private Button sendmailButton;

    @FXML
    private Button homeButton;

    @FXML
    void goHome(ActionEvent event) {
    	stage=(Stage)((Node)event.getSource()).getScene().getWindow();
    	stage.close();

    }
    private Stage stage;
    private Scene scene;
    private Parent root;
    static String emaild;
    @FXML
    void sendmail(ActionEvent event) throws IOException {
    	CourseStudentListInfo datafrombutton;
    	ObservableList<CourseStudentListInfo>info=FXCollections.observableArrayList();
    	
    	datafrombutton=this.cse215sec04Lab.getSelectionModel().getSelectedItem();
    	info.add(new CourseStudentListInfo(datafrombutton.getSerialNumber(), datafrombutton.getInitializerID(), datafrombutton.getInitializerName(), datafrombutton.getEmail()));
    	for(int i=0;i<info.size();i++) {
    		Cse215sec04LabController.emaild=info.get(i).getEmail();
    	}
    	
    	FXMLLoader loader=new FXMLLoader(getClass().getResource("AdminMiniEmailLogin.fxml"));
    	root=loader.load();
    	AdminMiniEmailLoginController controller=loader.getController();
    	AdminMiniEmailSendingController passer=new AdminMiniEmailSendingController();
    	passer.getRecieverid(Cse215sec04LabController.emaild);
    	scene=new Scene(root);
    	stage=new Stage();
    	stage.setScene(scene);
    	stage.show();
    }

    void getInfo() {
    	
    }
    
    private static Scanner reader;
    
    final ObservableList<CourseStudentListInfo>courseStudentData=FXCollections.observableArrayList();
    static SortedList<CourseStudentListInfo>sortedStudentList;
    String serialno="";
    String studentID="";
    String studentName="";
    String email="";
    
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			
			reader=new Scanner(new File("src//FacultyFiles//CSE215.4LabMonamyMam.csv"));
			reader.useDelimiter("[,\n]");
			
			while(reader.hasNext()) {
					serialno=reader.next();
					studentID=reader.next();
					studentName=reader.next();
					email=reader.next();
					courseStudentData.add(new CourseStudentListInfo(serialno, studentID, studentName, email));
				}
			
		} catch (IOException e) {
			System.out.println(e);
		}catch (Exception e) {
			System.out.println(e);
			System.out.println(e);
		}
		
		this.tableserialNo.setCellValueFactory(new PropertyValueFactory<CourseStudentListInfo,String>("serialNumber"));
		this.tableStudentID.setCellValueFactory(new PropertyValueFactory<CourseStudentListInfo,String>("initializerID"));
		this.tablleStudentName.setCellValueFactory(new PropertyValueFactory<CourseStudentListInfo,String>("initializerName"));
		this.emailAddress.setCellValueFactory(new PropertyValueFactory<CourseStudentListInfo,String>("email"));
		
		FilteredList<CourseStudentListInfo>sortData=new FilteredList<>(courseStudentData,b -> true);
		this.searchField.textProperty().addListener((observable,oldvalue,newValue)->{
			sortData.setPredicate(student ->{
				if(newValue==null|| newValue.isEmpty()){
					return true;
				}
				String lowerCaseSort=newValue.toLowerCase();
				String upperCaseSort=newValue.toUpperCase();
				
				if(student.getSerialNumber().toLowerCase().indexOf(lowerCaseSort)!= -1 || student.getSerialNumber().toUpperCase().indexOf(upperCaseSort)!= -1) {
					return true;
				}
				else if(student.getInitializerID().indexOf(lowerCaseSort)!=-1) {
					return true;
				}
				else if(student.getInitializerName().toLowerCase().indexOf(lowerCaseSort)!= -1 || student.getInitializerName().toUpperCase().indexOf(upperCaseSort)!= -1) {
					return true;
				}
				else if(student.getEmail().toLowerCase().indexOf(lowerCaseSort)!= -1 || student.getEmail().toUpperCase().indexOf(upperCaseSort)!= -1) {
					return true;
				}
				
				else {
					return false;
				}
			});
		});
		sortedStudentList=new SortedList<CourseStudentListInfo>(sortData);
		sortedStudentList.comparatorProperty().bind(cse215sec04Lab.comparatorProperty());
		
		
		this.cse215sec04Lab.setItems(sortData);
		
		
	}


}
