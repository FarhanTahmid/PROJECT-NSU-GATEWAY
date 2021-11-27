package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.control.ButtonType;



public class Main extends Application {
	
	static String s;
	@Override
	public void start(Stage loginStage) {
		try {
			Parent root=FXMLLoader.load(getClass().getResource("LogInPage.fxml"));
			Scene scene=new Scene(root);
			Image icon =new Image("NSU-LOGO-2021.png");
			loginStage.setScene(scene);
			loginStage.setTitle("NSU GATEWAY");
			loginStage.getIcons().add(icon);
			loginStage.setResizable(false);
			loginStage.show();
			loginStage.setOnCloseRequest(event ->{
				event.consume();
				quittingStage(loginStage);
			});
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
		
	}
	public void quittingStage(Stage stage) {
		
		
		Alert alert =new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Quitting Program");
		alert.setHeaderText("You are about to Quit the program! Are you sure?");
		
		if (alert.showAndWait().get()==ButtonType.OK) {
			
			stage.close();
		}
		
	}
	
}
