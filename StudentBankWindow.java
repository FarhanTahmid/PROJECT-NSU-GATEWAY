package application;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class StudentBankWindow {

    @FXML
    private Label studentName;

    @FXML
    private Label studentID;

    @FXML
    private TextField withdrawTextField;

    @FXML
    private Button withdrawButton;

    @FXML
    private Label withdrawStatus;

    @FXML
    private TextField depositTextField;

    @FXML
    private Button depositButton;

    @FXML
    private Label depositStatus;
    @FXML
    private Label depositStatus1;

    @FXML
    private Button paySemesterFee;

    @FXML
    private Label ifSemesterFeeDue;

    @FXML
    private Label semesterfeeSet;

    @FXML
    private Label bankbalance;

    @FXML
    private Button homeButton;

    @FXML
    private ImageView uniLogo;
    @FXML
    private Label serviceFee;
    @FXML
    private Button serviceFeeButton;
	    
	Stage stage;
	Scene scene;
	Parent root;
    
    private static Scanner reader;
    String filePath="src\\StudentBankInfo.csv";
    
    private static String staticid;
    private static double staticbankBalance;
    
    public void getInfo(String idnumber) {
    	StudentBankWindow.staticid=idnumber;
    	
    }
    
    public void intializingBalance(Double studentBalance) {
    		StudentBankWindow.staticbankBalance=studentBalance;
    }
    
    
    //change all the controls
    public void withdrawMoney(ActionEvent event) {
    	
    	double amount=Double.parseDouble(this.withdrawTextField.getText());
    	
    	if(amount<staticbankBalance) {
    		staticbankBalance-=amount;
    		this.bankbalance.setText(""+staticbankBalance+" BDT");
    		this.withdrawStatus.setText("Withdrawal Successful!");
    	}
    	else if(amount>staticbankBalance) {
    		this.withdrawStatus.setText("Not enough money in the Account");
    	}
    	
    	
    }
    
    public void depositMoney(ActionEvent event) {
    	double amount=Double.parseDouble(this.depositTextField.getText());
    	staticbankBalance+=amount;
    	this.bankbalance.setText(""+staticbankBalance+" BDT");
    	this.depositStatus.setText("Put the envelop of cash inside the ATM!");
    	this.depositStatus1.setText("Deposit Successful");
    	
    }
    
    private double semesterFee=AdvisingPaymentControler.totalPayablefee;
    static boolean paid=false;
    
    public void showPaymentInfo(String amount) {
    	if(!paid) {
    		if(Double.parseDouble(amount)>0.0) {
        		this.ifSemesterFeeDue.setText("You have your semester fee due");
        		if(Double.parseDouble(amount)>staticbankBalance) {
        			this.ifSemesterFeeDue.setText("Not enough money in account to pay fee");
        		}
        		
        	}
        	this.semesterfeeSet.setText(amount);
    	}
    	if(paid) {
    		this.ifSemesterFeeDue.setText("You dont have any semester fee due");
    	}	
    }
    
    public void semesterFee(ActionEvent event) {
    	if(semesterFee<staticbankBalance) {
    		staticbankBalance-=semesterFee;
    		this.bankbalance.setText(""+staticbankBalance+"BDT");
    		this.ifSemesterFeeDue.setText("Semester fee Paid");
    		this.semesterfeeSet.setText("0.0");
    		paid=true;
    	}
    	else if(semesterFee>staticbankBalance){
    		this.ifSemesterFeeDue.setText("Not enough money in account to Pay");
    	}
    }
    boolean feepaid;
    @FXML
    private Label ifservicefeedue;
    private double serviceAmount;
    void showServicePaymentInfo(String amount) {
    	 serviceAmount=Double.parseDouble(amount);
    	if(!feepaid) {
    		if(Double.parseDouble(amount)>0.0) {
    			this.ifservicefeedue.setText("You have Dues to pay!");
    		}
    		this.serviceFee.setText(amount);
    	}
    	if(feepaid) {
    		this.ifservicefeedue.setText("You dont have any Dues to pay");
    	}
    	
    	
    }
    @FXML
    void payServiceFee(ActionEvent event) {
    	if(serviceAmount<staticbankBalance) {
    		staticbankBalance-=serviceAmount;
    		this.bankbalance.setText(""+staticbankBalance+"BDT");
    		this.serviceFee.setText("0.0");
    		feepaid=true;
    	}
    	else if(serviceAmount>staticbankBalance) {
			this.ifservicefeedue.setText("Not enough money in the Account");
			feepaid=false;
		}
    }
    
	public void goHome(ActionEvent event) throws IOException {
		stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		stage.close();
}
    
    
    
    
	String fileID="";
	String fileName="";
    static String fileBankBalance;
    public void findingInfo(String number) throws FileNotFoundException {
    	
    	boolean found=false;
    	try {
			reader=new Scanner(new File(filePath));
			reader.useDelimiter("[,\n]");
			
			while(reader.hasNext()&&!found) {
				this.fileID=reader.next();
				StudentBankWindow.fileBankBalance =reader.next();
				this.fileName=reader.next();
				
				if(this.fileID.equals(StudentBankWindow.staticid)){
					found=true;
				}
				
			}
			if(found) {
				this.studentName.setText(this.fileName);
				this.studentID.setText(this.fileID);
				this.bankbalance.setText(""+StudentBankWindow.staticbankBalance+"BDT");
			}
    	
    	} catch (FileNotFoundException e) {
			//System.out.println(e);
			e.printStackTrace();
		}catch (Exception e) {
			//e.printStackTrace();
		}
    
    }
    

}
