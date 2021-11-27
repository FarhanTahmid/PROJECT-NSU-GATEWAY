package application;

import java.net.URL;
import java.util.ResourceBundle;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AdminMiniEmailSendingController implements Initializable {

    @FXML
    private TextArea mailTextArea;

    @FXML
    private TextField recievertextField;

    @FXML
    private TextArea subjectTextArea;

    @FXML
    private Button sendEmail;

    @FXML
    private Button cancelButton;
    @FXML
    private Label confirmation;
    
    private Stage stage;
    @FXML
    void cancel(ActionEvent event) {
    	stage=(Stage)((Node)event.getSource()).getScene().getWindow();
    	stage.close();
    }
    
    
    
    public AdminMiniEmailSendingController() {
		// TODO Auto-generated constructor stub
	}
    private EmailAccount emailAccount;
    void getMail(EmailAccount account) {
    	this.emailAccount=account;
    	System.out.println(this.emailAccount.getAddress());
    }
    
    Session session;
    static String recieverid;
    static String senderid;
    String sendingconfirmation="";
    @FXML
    void sendEmail(ActionEvent event) {
    	AdminMiniEmailSendingController.recieverid=this.recievertextField.getText();
    	MimeMessage message= new MimeMessage(session);
    	try {
    		
    		this.emailAccount.setSession(this.session);
    		Store store=this.session.getStore("imaps");
    		store.connect(this.emailAccount.getProperties().getProperty("incomingHost"),this.emailAccount.getAddress(),this.emailAccount.getPassword());
    		this.emailAccount.setStore(store);
    		System.out.println(this.emailAccount.getAddress());
    		
			message.setFrom(new InternetAddress(AdminMiniEmailSendingController.senderid));
			message.addRecipient(MimeMessage.RecipientType.TO, new InternetAddress(AdminMiniEmailSendingController.recieverid));
			message.setSubject(this.subjectTextArea.getText());
			message.setText(this.mailTextArea.getText());
			
			Transport transport = emailAccount.getSession().getTransport();            
					transport.connect(
					
							this.emailAccount.getProperties().getProperty("outgoingHost"),
							this.emailAccount.getAddress(),
                    
							this.emailAccount.getPassword()
            );
					
					 transport.sendMessage(message, message.getAllRecipients());
					 transport.close();
			
			//Transport.send(message);
			System.out.println(sendingconfirmation+"Connected to Gmail Server");
			this.confirmation.setText("Mail Sent");
			
			
    	} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e) {
			System.out.println(e);
			System.out.println("Network Error");
			e.printStackTrace();
		}
    }
    
    void getsession(Session gettingsession) {
    	this.session=gettingsession;
    }
    void getRecieverid(String mailID) {
    	
    	AdminMiniEmailSendingController.recieverid=mailID;
    }
    void getsenderid(String mailID) {
    	AdminMiniEmailSendingController.senderid=mailID;
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		recievertextField.setText(AdminMiniEmailSendingController.recieverid);
		
	}
    
}
