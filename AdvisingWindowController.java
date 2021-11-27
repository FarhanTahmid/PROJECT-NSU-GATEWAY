package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class AdvisingWindowController implements Initializable {

    @FXML
    private TableView<PreAdvisingInitializer> preAdvisingListLoad;

    @FXML
    private TableColumn<PreAdvisingInitializer, String> preAdvisingcourseInitialColumn;

    @FXML
    private TableColumn<PreAdvisingInitializer, String> preAdvisingCourseDepartmentColumn;

    @FXML
    private TableColumn<PreAdvisingInitializer, String> preadvisingtime;

    @FXML
    private TableColumn<PreAdvisingInitializer, String> preAdvisingCourseSection;
    
    //---------

    @FXML
    private TableView<PreAdvisingInitializer> advisingTable;

    @FXML
    private TableColumn<PreAdvisingInitializer, String> AdvisingSerialNo;

    @FXML
    private TableColumn<PreAdvisingInitializer, String> advisedCourseInitial;

    @FXML
    private TableColumn<PreAdvisingInitializer, String> advisingCourseTitle;

    @FXML
    private TableColumn<PreAdvisingInitializer, String> advisingCourseTime;

    @FXML
    private TableColumn<PreAdvisingInitializer, String> advisingCourseFaculty;
    @FXML
    private TableColumn<PreAdvisingInitializer, String> advisingCoursesection;


    @FXML
    private Button saveAdvivngButton;

    @FXML
    private Button selectCourseButton;

    @FXML
    private Button backToHomeButton;

    @FXML
    private Button cancelAdvisingButton;

    @FXML
    private Button dropAdvisedCourseButton;
    @FXML
    private Button savedadvisingInfoAndPaymentStatus;
    @FXML
    private Label warningLabel;
    
    private Stage stage;
    Parent root;
    @FXML
    void showPaymentStatus(ActionEvent event) throws IOException {
    	if(advisingfile.exists()) {
    		FXMLLoader loader=new FXMLLoader(getClass().getResource("AdvisingPAymentStatus.fxml"));
        	root=loader.load();
        	AdvisingPaymentControler controller=loader.getController();
        	stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        	Scene scene=new Scene(root);
        	stage.setScene(scene);
    	}
    	else {
			savAdvising(event);
			showPaymentStatus(event);
		}
    	
    	
    }
    
    @FXML
    void cancelAdvising(ActionEvent event) {
    	stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		stage.close();
    }

    @FXML
    void dropSelectedCourse(ActionEvent event) {
    	advisingTable.getItems().removeAll(advisingTable.getSelectionModel().getSelectedItem());
    }
    List <List<String>> arrlist=new ArrayList<>();
    PreAdvisingInitializer savingTableview=new PreAdvisingInitializer();
    static File advisingfile;
    
    @FXML
    void savAdvising(ActionEvent event) throws FileNotFoundException {
    	for(int i=0;i<advisingTable.getItems().size();i++) {
    		savingTableview=advisingTable.getItems().get(i);
    		arrlist.add(new ArrayList<>());
    		arrlist.get(i).add(savingTableview.getSerialNo());
    		arrlist.get(i).add(savingTableview.getCourseInitial());
    		arrlist.get(i).add(savingTableview.getCourseCredit());
    		arrlist.get(i).add(savingTableview.getTime());
    		arrlist.get(i).add(savingTableview.getSection());
    		arrlist.get(i).add(savingTableview.getFaculty());
    		arrlist.get(i).add(savingTableview.getRootDepartment());
    		arrlist.get(i).add(savingTableview.getCourseTitle());
    	}
    	advisingfile=new File("src//Advising Data//AdvisingfileSaved.csv");
    	PrintWriter writer=new PrintWriter(advisingfile);
    	for(int i=0;i<arrlist.size();i++) {
    		for(int j=0;j<arrlist.get(i).size();j++) {
    			if(j<arrlist.get(i).size()-1) {
    				writer.append(arrlist.get(i).get(j)+",");
    			}
    			else {
    				writer.append(arrlist.get(i).get(j));
    			}
    			
    		}
    		writer.append("\n");
    		
    		
    	}
    	writer.flush();
		writer.close();
		file.delete();
    	
    }

    @FXML
    void saveAndBackToHome(ActionEvent event) {
    	
    	stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		stage.close();
    }
    
    PreAdvisingInitializer getDataFromSelectCourseButton;
    
    @FXML
    void selectCourse(ActionEvent event) throws IOException {
    	
    	getDataFromSelectCourseButton=this.preAdvisingListLoad.getSelectionModel().getSelectedItem();
    	
    	advisedData.add(new PreAdvisingInitializer(getDataFromSelectCourseButton.getSerialNo(), getDataFromSelectCourseButton.getCourseInitial(), getDataFromSelectCourseButton.getCourseCredit()
    			, getDataFromSelectCourseButton.getCourseTitle(), getDataFromSelectCourseButton.getRootDepartment(),
    			getDataFromSelectCourseButton.getTime(),getDataFromSelectCourseButton.getSection(),getDataFromSelectCourseButton.getFaculty()));
    	
    	FileWriter writer=new FileWriter(file);
    	for(int i=0;i<advisedData.size();i++) {
			writer.append(String.valueOf(i+1));
			writer.append(",");
			writer.append(advisedData.get(i).getCourseInitial());
			writer.append(",");
			writer.append(advisedData.get(i).getCourseCredit());
			writer.append(",");
			writer.append(advisedData.get(i).getTime());
			writer.append(",");
			writer.append(advisedData.get(i).getSection());
			writer.append(",");
			writer.append(advisedData.get(i).getFaculty());
			writer.append(",");
			writer.append(advisedData.get(i).getRootDepartment());
			writer.append(",");
			writer.append(advisedData.get(i).getCourseTitle());
			writer.append("\n");
			
		}
		writer.flush();
		writer.close();
    }
    
    static ObservableList<PreAdvisingInitializer>preAdvisingData=FXCollections.observableArrayList();
    static ObservableList<PreAdvisingInitializer>advisedData=FXCollections.observableArrayList();
    static Scanner reader;
    static Scanner reader2;
    
    File file=new File("src//Advising Data//advisingfile.csv");
    
    String serialno="";
    String courseIntial="";
    String courseTitle="";
    String rootDepartment="";
    String courseCredit="";
    String time="";
    String section="";
    String faculty="";
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		try {
			reader=new Scanner(PreAdvisedListController.preAdvisingfile);
			reader.useDelimiter("[,\n]");
			while(reader.hasNext()) {
				this.serialno=reader.next();
				this.courseIntial=reader.next();
				this.courseCredit=reader.next();
				this.time=reader.next();
				this.section=reader.next();
				this.faculty=reader.next();
				this.rootDepartment=reader.next();
				this.courseTitle=reader.next();
				preAdvisingData.add(new PreAdvisingInitializer(serialno, courseIntial, courseCredit, courseTitle, rootDepartment,time,section,faculty));
				
			}
		} catch (FileNotFoundException e) {
			System.out.println();
			System.out.println(e);
			e.printStackTrace();
		}catch (Exception e) {
			this.warningLabel.setText("Complete Pre-advising First");
			System.out.println("something is missing");
		}
		
		this.preadvisingtime.setCellValueFactory(new PropertyValueFactory<PreAdvisingInitializer,String>("time"));
		this.preAdvisingcourseInitialColumn.setCellValueFactory(new PropertyValueFactory<PreAdvisingInitializer,String>("courseInitial"));
		this.preAdvisingCourseSection.setCellValueFactory(new PropertyValueFactory<PreAdvisingInitializer,String>("section"));
		this.preAdvisingCourseDepartmentColumn.setCellValueFactory(new PropertyValueFactory<PreAdvisingInitializer,String>("rootDepartment"));
		
		this.preAdvisingListLoad.setItems(preAdvisingData);
		
		
		try {
			reader2=new Scanner(file);
			reader2.useDelimiter("[,\n]");
			while(reader2.hasNext()) {
				
				String advisingSerialNo=reader.next();
				String courseInitial=reader.next();
				String courseCredit=reader.next();
				String time=reader.next();
				String section=reader.next();
				String faculty=reader.next();
				String rootDepartment=reader.next();
				String coursetitle=reader.next();
				advisedData.add(new PreAdvisingInitializer(advisingSerialNo, courseInitial, courseCredit, coursetitle, rootDepartment,time,section,faculty));
			}
		} 
		catch (FileNotFoundException e) {
			try {
				reader2=new Scanner(advisingfile);
				reader2.useDelimiter("[,\n]");
				while(reader2.hasNext()) {
					
					String advisingSerialNo=reader.next();
					String courseInitial=reader.next();
					String courseCredit=reader.next();
					String time=reader.next();
					String section=reader.next();
					String faculty=reader.next();
					String rootDepartment=reader.next();
					String coursetitle=reader.next();
					advisedData.add(new PreAdvisingInitializer(advisingSerialNo, courseInitial, courseCredit, coursetitle, rootDepartment,time,section,faculty));
				}
			}catch (Exception ge) {
				System.out.println(ge);
			}
			System.out.println("here");
			e.printStackTrace();
		}catch (Exception e) {
			//System.out.println(e);
		}
		this.AdvisingSerialNo.setCellValueFactory(new PropertyValueFactory<PreAdvisingInitializer,String>("serialNo"));
		this.advisedCourseInitial.setCellValueFactory(new PropertyValueFactory<PreAdvisingInitializer,String>("courseInitial"));
		this.advisingCourseTitle.setCellValueFactory(new PropertyValueFactory<PreAdvisingInitializer,String>("courseTitle"));
		this.advisingCourseTime.setCellValueFactory(new PropertyValueFactory<PreAdvisingInitializer,String>("time"));
		this.advisingCoursesection.setCellValueFactory(new PropertyValueFactory<PreAdvisingInitializer,String>("section"));
		this.advisingCourseFaculty.setCellValueFactory(new PropertyValueFactory<PreAdvisingInitializer,String>("faculty"));
		
		this.advisingTable.setItems(advisedData);
		
		
	}
}

