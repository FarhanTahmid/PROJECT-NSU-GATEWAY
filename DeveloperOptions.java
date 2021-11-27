package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class DeveloperOptions implements Initializable {
    @FXML
    private Button backButton;
    private Stage stage;
    private Parent root;
    private Scene scene;
    
    @FXML
    void backToLogin(ActionEvent event) throws IOException {
    	
		stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		stage.close();
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

	
}
