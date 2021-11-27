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
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.shape.Arc;
import javafx.stage.Stage;


public class PreAdvisedListController extends Confirmation implements Initializable  {
    @FXML
    private TableView<PreAdvisingInitializer> preadvisedCourses;

    @FXML
    private TableColumn<PreAdvisingInitializer, String> preadvisedlistslcolumn;

    @FXML
    private TableColumn<PreAdvisingInitializer, String> preadvisedlistcourseinitialcolumn;

    @FXML
    private TableColumn<PreAdvisingInitializer, String> preadvisedlistcoursetitlecolumn;

    @FXML
    private TableColumn<PreAdvisingInitializer, String> preadvisedlistcourseCredittitlecolumn;

    @FXML
    private Button saveForAdvisingButton;

    @FXML
    private Button cancelButton;
    @FXML
    private Button preadvisingcoursedeletebutton;
    @FXML
    private Label duplicateCourse;
    private Stage stage;
    @FXML
    void cancel(ActionEvent event) {
    	stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		stage.close();
    }
    @FXML
    void preAdvisingCourseDeleteButton(ActionEvent event) {
    	preadvisedCourses.getItems().removeAll(preadvisedCourses.getSelectionModel().getSelectedItem());
    }

 
    List <List<String>> arrlist=new ArrayList<>();
    PreAdvisingInitializer savingTableview=new PreAdvisingInitializer();
    static File preAdvisingfile;
    boolean alarm=false;
    @FXML
    void saveforAdvisimg(ActionEvent event) throws FileNotFoundException {
    	
    	for(int i=0;i<preadvisedCourses.getItems().size();i++) {
    		for(int j=1;j<preadvisedCourses.getItems().size();j++) {
    			if(preadvisedCourses.getItems().get(i).getCourseInitial().equals(preadvisedCourses.getItems().get(j).getCourseInitial())){
    				this.duplicateCourse.setText("Exclude the Duplicate Courses and Save For Advising");
    				alarm=true;
    				
    			}
    			else {
    				alarm=false;
    			}	
    		}
    		
    		savingTableview=preadvisedCourses.getItems().get(i);
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
    	
    		preAdvisingfile=new File("src//Advising Data//preadvisingfileSaved.csv");
        	PrintWriter writer=new PrintWriter(preAdvisingfile);
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
    		stage=(Stage)((Node)event.getSource()).getScene().getWindow();
    		stage.close();
    	
    	
    }
    
    String serialnoString="";
    String courseInitial="";
    String courseTitle="";
    String courseCredit="";
    String department="";
    String time="";
    String section="";
    String faculty="";
    
    final ObservableList<PreAdvisingInitializer>preadvisedfile=FXCollections.observableArrayList();
    private static Scanner reader;
    String filepath="src//Advising Data//tryfile.csv";
    File file=new File(filepath);
    
   
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
			
			try {
				FileWriter csvWriter = new FileWriter(file);
				
				for(int i=0;i<PreAdvisingController.preAdvisedData.size();i++) {
					
					csvWriter.append(String.valueOf(i+1));
					csvWriter.append(",");
					csvWriter.append(PreAdvisingController.preAdvisedData.get(i).getCourseInitial());
					csvWriter.append(",");
					csvWriter.append(PreAdvisingController.preAdvisedData.get(i).getCourseCredit());
					csvWriter.append(",");
					csvWriter.append(PreAdvisingController.preAdvisedData.get(i).getTime());
					csvWriter.append(",");
					csvWriter.append(PreAdvisingController.preAdvisedData.get(i).getSection());
					csvWriter.append(",");
					csvWriter.append(PreAdvisingController.preAdvisedData.get(i).getFaculty());
					csvWriter.append(",");
					csvWriter.append(PreAdvisingController.preAdvisedData.get(i).getRootDepartment());
					csvWriter.append(",");
					csvWriter.append(PreAdvisingController.preAdvisedData.get(i).getCourseTitle());
					csvWriter.append("\n");
				}
				csvWriter.flush();
				csvWriter.close();
				
				
				reader=new Scanner(file);
				reader.useDelimiter("[,\n]");
				while(reader.hasNext()) {
					this.serialnoString=reader.next();
					this.courseInitial=reader.next();
					this.courseCredit=reader.next();
					this.time=reader.next();
					this.section=reader.next();
					this.faculty=reader.next();
					this.department=reader.next();
					this.courseTitle=reader.next();
					
					
					preadvisedfile.add(new PreAdvisingInitializer(serialnoString, courseInitial, courseCredit, courseTitle, department,time,section,faculty));
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}catch (Exception e) {
				try {
					reader=new Scanner(preAdvisingfile);
				} catch (FileNotFoundException e1) {
					
					e1.printStackTrace();
				}
				reader.useDelimiter("[,\n]");
				while(reader.hasNext()) {
					this.serialnoString=reader.next();
					this.courseInitial=reader.next();
					this.courseCredit=reader.next();
					this.time=reader.next();
					this.section=reader.next();
					this.faculty=reader.next();
					this.department=reader.next();
					this.courseTitle=reader.next();
					
					
					preadvisedfile.add(new PreAdvisingInitializer(serialnoString, courseInitial, courseCredit, courseTitle, department,time,section,faculty));
				}
				//System.out.println("Element Missing");
				//System.out.println(e);
			}
			

		this.preadvisedlistslcolumn.setCellValueFactory(new PropertyValueFactory<PreAdvisingInitializer,String>("serialNo"));
		this.preadvisedlistcourseinitialcolumn.setCellValueFactory(new PropertyValueFactory<PreAdvisingInitializer,String>("courseInitial"));
		this.preadvisedlistcourseCredittitlecolumn.setCellValueFactory(new PropertyValueFactory<PreAdvisingInitializer,String>("courseCredit"));
		this.preadvisedlistcoursetitlecolumn.setCellValueFactory(new PropertyValueFactory<PreAdvisingInitializer,String>("courseTitle"));
		this.preadvisedCourses.setItems(preadvisedfile);
		
		
	}
	@Override
	boolean alertboxforLogout() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	boolean alrtboxforQuitting() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	boolean sameCourseSelected() {
		Alert alert =new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Selected Course Error");
		alert.setHeaderText("You selected one course multiple times!");
		alert.setContentText("Exclude the course and continue your advising");
		if (alert.showAndWait().get()==ButtonType.OK) {
			alert.close();
			return true;
		}
		return false;
	
	}

}
