package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.RadioButton;

public class ExtractingInfoFromDatabase {

	ExtractingInfoFromDatabase(){
		
	}
	private static int absentdays=0;
	private static int presentDays=0;
	void initializingAttendance(int presentDay,int AbsentDay) {
		ExtractingInfoFromDatabase.absentdays=AbsentDay;
		ExtractingInfoFromDatabase.presentDays=presentDay;
	}
	private Scanner reader;
	public ObservableList<AttendanceInitializer> labInstructorAttendanceinfoInitializer(String filepath) {
		ObservableList<AttendanceInitializer> studentInfo=FXCollections.observableArrayList();
		RadioButton button;
		try {
			reader=new Scanner(new File(filepath));
			reader.useDelimiter("[,\n]");
			
			while(reader.hasNext()) {
				String serilano=reader.next();
				String studentID=reader.next();
				String studentName=reader.next();
				String emailid=reader.next();
				button=new RadioButton();
				studentInfo.add(new AttendanceInitializer(studentID, studentName, button, ExtractingInfoFromDatabase.presentDays,ExtractingInfoFromDatabase.absentdays ));				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return studentInfo;
	}
}
