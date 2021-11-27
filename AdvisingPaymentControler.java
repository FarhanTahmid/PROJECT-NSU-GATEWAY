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

public class AdvisingPaymentControler implements Initializable{

    @FXML
    private TableView<PreAdvisingInitializer> advisingTable;

    @FXML
    private TableColumn<PreAdvisingInitializer, String> courseInitial;

    @FXML
    private TableColumn<PreAdvisingInitializer, String> courseTitle;

    @FXML
    private TableColumn<PreAdvisingInitializer, String> advisinfCourseTime;

    @FXML
    private TableColumn<PreAdvisingInitializer, String> advisingSection;

    @FXML
    private TableColumn<PreAdvisingInitializer, String> advisingCourseFaculty;

    @FXML
    private TableColumn<PreAdvisingInitializer, String> advisingCourseCredit;

    @FXML
    private TableColumn<PreAdvisingInitializer, String> advisingCourseFee;

    @FXML
    private TableView<AdvisingPaymentInitializer> tuitionFeeTable;

    @FXML
    private TableColumn<AdvisingPaymentInitializer, String> TutionFeeCriteria;

    @FXML
    private TableColumn<AdvisingPaymentInitializer, String> tuitionFeeAmount;

    @FXML
    private Button editadvisingInfo;

    @FXML
    private Button paySemesterFee;

    @FXML
    private Button homeButton;
    
    Stage stage;
    Parent root;
    
    @FXML
    void editAdvisingInfo(ActionEvent event) throws IOException {
    	FXMLLoader loader=new FXMLLoader(getClass().getResource("AdvisingWindow.fxml"));
    	root=loader.load();
    	
    	AdvisingWindowController controller=loader.getController();
    	
    	stage=(Stage)((Node)event.getSource()).getScene().getWindow();
    	Scene scene=new Scene(root);
    	stage.setScene(scene);
    }

    @FXML
    void goHome(ActionEvent event) {
    	stage=(Stage)((Node)event.getSource()).getScene().getWindow();
    	stage.close();
    }

    @FXML
    void paySemesterFee(ActionEvent event) throws IOException {
    	FXMLLoader loader=new FXMLLoader(getClass().getResource("NSUBankAccountWindow.fxml"));
    	root=loader.load();
    	
    	StudentBankWindow controller=loader.getController();
    	controller.findingInfo(StudentLoggedInController.staticID);
    	controller.showPaymentInfo(String.valueOf(totalPayablefee));
    	
    	stage=(Stage)((Node)event.getSource()).getScene().getWindow();
    	Scene scene=new Scene(root);
    	stage.setScene(scene);
    }
   
    
       
    String serialno="";
    String courseIntial="";
    String coursetitle="";
    String rootDepartment="";
    String courseCredit="";
    String time="";
    String section="";
    String faculty="";
    static double totalPayablefee;
    final ObservableList<PreAdvisingInitializer>advisingData=FXCollections.observableArrayList();
    final ObservableList<AdvisingPaymentInitializer>paymentData=FXCollections.observableArrayList();
    static Scanner reader;
    File advisedFile=new File("src//Advising Data//AdvisingfileSaved.csv");

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			reader=new Scanner(advisedFile);
			reader.useDelimiter("[,\n]");
			while(reader.hasNext()) {
				this.serialno=reader.next();
				this.courseIntial=reader.next();
				this.courseCredit=reader.next();
				this.time=reader.next();
				this.section=reader.next();
				this.faculty=reader.next();
				this.rootDepartment=reader.next();
				this.coursetitle=reader.next();
				advisingData.add(new PreAdvisingInitializer(serialno, courseIntial, courseCredit, coursetitle, rootDepartment, time, section, faculty));
				
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		this.courseInitial.setCellValueFactory(new PropertyValueFactory<PreAdvisingInitializer,String>("courseInitial"));
		this.courseTitle.setCellValueFactory(new PropertyValueFactory<PreAdvisingInitializer,String>("courseTitle"));
		this.advisingCourseCredit.setCellValueFactory(new PropertyValueFactory<PreAdvisingInitializer,String>("courseCredit"));
		this.advisinfCourseTime.setCellValueFactory(new PropertyValueFactory<PreAdvisingInitializer,String>("time"));
		this.advisingSection.setCellValueFactory(new PropertyValueFactory<PreAdvisingInitializer,String>("section"));
		this.advisingCourseFaculty.setCellValueFactory(new PropertyValueFactory<PreAdvisingInitializer,String>("faculty"));
		this.advisingCourseFee.setCellValueFactory(new PropertyValueFactory<PreAdvisingInitializer,String>("fee"));
		
		this.advisingTable.setItems(advisingData);
		
		double credit=0.0;
		double tuitionTotal=0.0;
		
		for(int i=0;i<advisingData.size();i++) {
			
			double creditfromtable=Double.parseDouble(advisingData.get(i).getCourseCredit());
			credit+=creditfromtable;
			
		}
		tuitionTotal=credit*6500;
		totalPayablefee=3000+2500+1500+2500+tuitionTotal;
		/*
		StudentBankWindow controller=new StudentBankWindow();
		controller.showPaymentInfo(String.valueOf(totalPayablefee));
		*/
		paymentData.add(new AdvisingPaymentInitializer("StudentActivityFee", "3000"));
		paymentData.add(new AdvisingPaymentInitializer("Computer Lab Fee", "2500"));
		paymentData.add(new AdvisingPaymentInitializer("Library Fee", "1500"));
		paymentData.add(new AdvisingPaymentInitializer("Science Lab Fee", "2500"));
		paymentData.add(new AdvisingPaymentInitializer("Tuition Total", String.valueOf(tuitionTotal)));
		paymentData.add(new AdvisingPaymentInitializer("Total Payable", String.valueOf(totalPayablefee)));
		
		this.TutionFeeCriteria.setCellValueFactory(new PropertyValueFactory<AdvisingPaymentInitializer,String>("criteria"));
		this.tuitionFeeAmount.setCellValueFactory(new PropertyValueFactory<AdvisingPaymentInitializer,String>("amount"));
		this.tuitionFeeTable.setItems(paymentData);
		
		
	}

}
