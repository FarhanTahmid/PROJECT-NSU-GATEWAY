package application;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.mail.Session;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.mail.*;
import javax.mail.internet.*;



public class AdminMiniEmailLoginController implements Initializable {

    @FXML
    private TextField emailIDtextField;

    @FXML
    private PasswordField passwordTextField;

    @FXML
    private Button loginButton;
    @FXML
    private Label statusLabel;
    Parent root;
    private Stage stage;
    private Scene scene;
    
    Session mailSession;
    EmailAccount emailAccount;
    
    
    @FXML
    void cancelButton(ActionEvent event) {
    	stage=(Stage)((Node)event.getSource()).getScene().getWindow();
    	stage.close();
    }
    protected static String password;
    private boolean emailLogin() {
    	password=this.passwordTextField.getText();
    	emailAccount=new EmailAccount(this.emailIDtextField.getText(), this.passwordTextField.getText());
    	
    	Authenticator authenticator=new Authenticator() {
    		@Override
    		protected PasswordAuthentication getPasswordAuthentication() {
    			
    			return new PasswordAuthentication(emailAccount.getAddress(),emailAccount.getPassword());
    			
    		}
    	};
    	
    	try {
    		
    		mailSession=Session.getInstance(emailAccount.getProperties(),authenticator);
    		Store store=mailSession.getStore("imaps");
    		store.connect(emailAccount.getProperties().getProperty("incomingHost"),emailAccount.getAddress(),emailAccount.getPassword());
    		emailAccount.setStore(store);
    	
    	}catch (NoSuchProviderException e) {
			this.statusLabel.setText("Network Failed");
			System.out.println("Network Failed");
			
		}catch (AuthenticationFailedException e) {
			this.statusLabel.setText("Wrong Username or Password!");
			System.out.println("Wrong Username or Password!");
			return false;
		}catch (Exception e) {
			this.statusLabel.setText("");
			System.out.println("Unexpected Error Occured");
			return false;
		}
    	
    	return true;
    }

    @FXML
    void logintomail(ActionEvent event) throws IOException {
    		
    		if(emailLogin()) {
    			this.statusLabel.setText("Logged in Successfully");
    			FXMLLoader loader=new FXMLLoader(getClass().getResource("AdminMiniEmailSendingWindow.fxml"));
            	root=loader.load();
            	AdminMiniEmailSendingController controller=loader.getController();
            	getsenderid();
            	controller.getMail(emailAccount);
            	controller.getsession(mailSession);
            	scene=new Scene(root);
            	stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            	stage.setScene(scene);
            	stage.show();
    		
    		}
    		else {
    			System.out.println("Retry Logging in");
    		}    		
    }				
    void getsenderid() {
    	String senderID=this.emailIDtextField.getText();
    	AdminMiniEmailSendingController passer=new AdminMiniEmailSendingController();
    	passer.getsenderid(senderID);    	
    	//System.out.println(senderID);
    	//System.out.println("Connecting.........");
    	
    }
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		if(LogInClassController.loginCriteria.equals("Admin")) {
			this.emailIDtextField.setText("northaccess15725@gmail.com");
			this.passwordTextField.setText("allahsaveme!");
			
		}
		else if(LogInClassController.loginCriteria.equals("Faculty")) {
			this.emailIDtextField.setText("facultyaccess15725@gmail.com");
			this.passwordTextField.setText("allahsaveme!");
		}
		
	}

}