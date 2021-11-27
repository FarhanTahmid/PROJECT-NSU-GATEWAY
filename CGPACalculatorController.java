package application;

import java.math.BigDecimal;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class CGPACalculatorController implements Initializable {

    @FXML
    private TableView<CGPACalculatorInitializer> cgpaTable;

    @FXML
    private TableColumn<CGPACalculatorInitializer, String> cgpaTableCourseName;

    @FXML
    private TableColumn<CGPACalculatorInitializer, String> cgpaTableCredit;

    @FXML
    private TableColumn<CGPACalculatorInitializer, String> cgpaTableObtainedGrade;

    @FXML
    private TextField courseName;

    @FXML
    private TextField creditsTextField;

    @FXML
    private ChoiceBox<String> grades;

    @FXML
    private Button calculate;

    @FXML
    private Button removeAnEntryButton;

    @FXML
    private Label cgpaOutput;
    @FXML
    private Button addbutton;
    @FXML
    private Button homebutton;
    private Stage stage;
    
    @FXML
    void gohome(ActionEvent event) {
    	stage=(Stage)((Node)event.getSource()).getScene().getWindow();
    	stage.close();
    }
    double totalcredit;
    double gradeValue;
    double totalPoints;
    @FXML
    void calculateCgpa(ActionEvent event) {
    	
    	for(int i=0;i<cgpaData.size();i++) {
    		if (cgpaData.get(i).getGrade().equals("A"))
    		    gradeValue= 4.00;
    		  else if (cgpaData.get(i).getGrade().equals("A-"))
    		    gradeValue= 3.7;
    		  else if (cgpaData.get(i).getGrade().equals("B+"))
    		    gradeValue = 3.3;
    		  else if (cgpaData.get(i).getGrade().equals("B"))
    		    gradeValue = 3.00;
    		  else if (cgpaData.get(i).getGrade().equals("B-"))
    		    gradeValue = 2.7;
    		  else if (cgpaData.get(i).getGrade().equals("C+"))
    		    gradeValue = 2.3;
    		  else if (cgpaData.get(i).getGrade().equals("C"))
    		    gradeValue = 2.00;
    		  else if (cgpaData.get(i).getGrade().equals("C-"))
    		  gradeValue = 1.7;
    		  else if (cgpaData.get(i).getGrade().equals("D+"))
    		    gradeValue = 1.3;
    		  else if (cgpaData.get(i).getGrade().equals("D"))
    		    gradeValue = 1.0;
    		  else if (cgpaData.get(i).getGrade().equals("F"))
    		    gradeValue = 0.0;
    		double points=(Double.parseDouble(cgpaData.get(i).getCredit()))*gradeValue;
    		totalPoints+=points;
    		double credit=(Double.parseDouble(cgpaData.get(i).getCredit()));
    		totalcredit+=credit;
    	}
    	double CGPA=totalPoints/totalcredit;
    	DecimalFormat df = new DecimalFormat("#.##");
    	this.cgpaOutput.setText(String.valueOf(df.format(CGPA)));
    	
    }

    @FXML
    void removeEntry(ActionEvent event) {
    	cgpaTable.getItems().removeAll(cgpaTable.getSelectionModel().getSelectedItem());

    }
    private String[] choiceboxGrades= {"A","A-","B+","B","B-","C+","C","C-","D+","D","F"};
    @FXML
    void addfield(ActionEvent event) {
    	CGPACalculatorInitializer field=new CGPACalculatorInitializer();
    	field.setCourse(this.courseName.getText());
    	field.setCredit(this.creditsTextField.getText());
    	field.setGrade(this.grades.getValue());
    	cgpaData.add(new CGPACalculatorInitializer(field.getCourse(), field.getCredit(), field.getGrade()));
    }
    ObservableList<CGPACalculatorInitializer>cgpaData=FXCollections.observableArrayList();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.grades.getItems().addAll(choiceboxGrades);
		
		this.cgpaTableCourseName.setCellValueFactory(new PropertyValueFactory<CGPACalculatorInitializer,String>("course"));
		this.cgpaTableCredit.setCellValueFactory(new PropertyValueFactory<CGPACalculatorInitializer,String>("credit"));
		this.cgpaTableObtainedGrade.setCellValueFactory(new PropertyValueFactory<CGPACalculatorInitializer,String>("grade"));
		this.cgpaTable.setItems(cgpaData);
	}

}

