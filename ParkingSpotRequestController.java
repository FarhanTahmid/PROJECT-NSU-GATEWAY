package application;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class ParkingSpotRequestController {

    @FXML
    private RadioButton motorCycleButton;

    @FXML
    private ToggleGroup vehicleGroup;

    @FXML
    private RadioButton privateCarButton;

    @FXML
    private RadioButton SUVbutton;

    @FXML
    private TextField licencePlateTextField;
    @FXML
    private Button submitRequest;
    
    String vehicleType="";
    static Double paymentForParking;
    private Stage stage;
    String parkingrequestfile="src//StudentCoursesHistory//parkingfiles.csv";
    PrintWriter writer;
    
    @FXML
    void parking(ActionEvent event) {
    	
    		if(event.getSource()==submitRequest) {
        		if(motorCycleButton.isSelected()) {
            		vehicleType=motorCycleButton.getText();
            		paymentForParking=420.0;
            	}
            	else if(privateCarButton.isSelected()) {
            		vehicleType=privateCarButton.getText();
            		paymentForParking=620.0;
            	}
            	else if(privateCarButton.isSelected()) {
            		vehicleType=SUVbutton.getText();
            		paymentForParking=820.0;
            	}
            	try {
        			writer=new PrintWriter(parkingrequestfile);
        			writer.append(StudentLoggedInController.staticID);
        			writer.append(",");
        			writer.append(vehicleType);
        			writer.append(",");
        			writer.append(licencePlateTextField.getText());
        			writer.append(",");
        			writer.append(String.valueOf(paymentForParking));
        			writer.append("\n");
        			
        		} catch (FileNotFoundException e) {
        			
        			e.printStackTrace();
        		}
            	writer.flush();
    			writer.close();
    			
            	stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        		stage.close();
        		
        		
            	
        	}
    	
    	
    }
}
