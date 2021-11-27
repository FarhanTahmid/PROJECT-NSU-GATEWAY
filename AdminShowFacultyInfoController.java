package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class AdminShowFacultyInfoController implements Initializable {
	@FXML
    private TableView<AdminStudentDatabaseInitializer> facultyTable;

    @FXML
    private TableColumn<AdminStudentDatabaseInitializer, String> tableFacultyID;

    @FXML
    private TableColumn<AdminStudentDatabaseInitializer, String> tableFcultyName;

    @FXML
    private TableColumn<AdminStudentDatabaseInitializer, String> tableFacultyDpeartment;

    @FXML
    private TableColumn<AdminStudentDatabaseInitializer, String> tableFacultyDesignation;

    @FXML
    private TableColumn<AdminStudentDatabaseInitializer, String> tableFacultyOffice;

    @FXML
    private TableColumn<AdminStudentDatabaseInitializer, String> tableFacultyEmail;

    @FXML
    private Button showInformationButton;

    @FXML
    private Button goHome;
    private Stage stage;

    @FXML
    private Button snedEmailButton;

    @FXML
    void goHome(ActionEvent event) {
		stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		stage.close();
    }
    
    final ObservableList<AdminStudentDatabaseInitializer>getAdminInfo=FXCollections.observableArrayList();
    static Scanner reader;
    
    String facultyID="";
    String facultyName="";
    String facultyDepartment="";
    String facultyDesignation="";
    String facultyOFfice="";
    String facultEmail="";
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			reader=new Scanner(new File("src//Admin Files//AdminFacultyInfo.csv"));
			reader.useDelimiter("[,\n]");
			while(reader.hasNext()) {
				facultyID=reader.next();
				facultyName=reader.next();
				facultyDesignation=reader.next();
				facultyDepartment=reader.next();
				facultyOFfice=reader.next();
				facultEmail=reader.next();
				getAdminInfo.add(new AdminStudentDatabaseInitializer(facultyID, facultyName, facultyDesignation, facultyDepartment, facultyOFfice, facultEmail));
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.tableFacultyID.setCellValueFactory(new PropertyValueFactory<AdminStudentDatabaseInitializer,String>("facultyID"));
		this.tableFcultyName.setCellValueFactory(new PropertyValueFactory<AdminStudentDatabaseInitializer,String>("facultyName"));
		this.tableFacultyDesignation.setCellValueFactory(new PropertyValueFactory<AdminStudentDatabaseInitializer,String>("FacultyDesignation"));
		this.tableFacultyDpeartment.setCellValueFactory(new PropertyValueFactory<AdminStudentDatabaseInitializer,String>("facultyDepartment"));
		this.tableFacultyOffice.setCellValueFactory(new PropertyValueFactory<AdminStudentDatabaseInitializer,String>("facultyOFffice"));
		this.tableFacultyEmail.setCellValueFactory(new PropertyValueFactory<AdminStudentDatabaseInitializer,String>("facultyemail"));
		
		this.facultyTable.setItems(getAdminInfo);
	}
	Parent root;
	  @FXML
	    void showOfficialInfo(ActionEvent event) throws IOException {
		  AdminStudentDatabaseInitializer datafromTable;
		  String facultyID="";
		  datafromTable=this.facultyTable.getSelectionModel().getSelectedItem();
		  getAdminInfo.add(new AdminStudentDatabaseInitializer(datafromTable.getFacultyID(), datafromTable.getFacultyName(), datafromTable.getFacultyDesignation(), datafromTable.getFacultyDepartment(), datafromTable.getFacultyOFffice(), datafromTable.getFacultyemail()));
		  for(int i=0;i<getAdminInfo.size();i++) {
			  facultyID=getAdminInfo.get(i).getFacultyID();
		  }
		  stage=new Stage();
		  FXMLLoader loader=new FXMLLoader(getClass().getResource("FacultyOfficialInformation.fxml"));
		  root=loader.load();
		  FacultyOfficialInfoController controller=loader.getController();
		  controller.InfoSetter(facultyID);
		  Scene scene=new Scene(root);
		  stage.setScene(scene);
		  stage.show();
		  
	    }
	  
	  static ObservableList<AdminStudentDatabaseInitializer>getinfo=FXCollections.observableArrayList();
	  
	  @FXML
	    void sendEmail(ActionEvent event) throws IOException {
		  AdminStudentDatabaseInitializer datafromTable;
		  String emailID="";
		  datafromTable=this.facultyTable.getSelectionModel().getSelectedItem();
		  getAdminInfo.add(new AdminStudentDatabaseInitializer(datafromTable.getFacultyID(), datafromTable.getFacultyName(), datafromTable.getFacultyDesignation(), datafromTable.getFacultyDepartment(), datafromTable.getFacultyOFffice(), datafromTable.getFacultyemail()));
		  for(int i=0;i<getAdminInfo.size();i++) {
			  emailID=getAdminInfo.get(i).getFacultyemail();
		  }
	    	AdminMiniEmailSendingController idPasser=new AdminMiniEmailSendingController();
	    	idPasser.getRecieverid(emailID);
	    	
	    	FXMLLoader loader=new FXMLLoader(getClass().getResource("AdminMiniEmailLogin.fxml"));
	    	root=loader.load();
	    	AdminMiniEmailLoginController controller=loader.getController();
	    	Scene scene=new Scene(root);
	    	stage=new Stage();
	    	stage.setScene(scene);
	    	stage.show();
	    }

}
