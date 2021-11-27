package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileHandling {
		
	private static Scanner reader;
	 public void removerecordFromAdminacceptedParkingFile(String filePath,String removeTerm) {
		 System.out.println(removeTerm);
		 String tempfile="temp.csv";
		 File oldfile=new File(filePath);
		 File newFile=new File(tempfile);
		 String id="";
		 String vehicleType="";
		 String licensePlate="";
		 String payment="";
		 try {
			FileWriter fw=new FileWriter(tempfile,true);
			BufferedWriter bw=new BufferedWriter(fw);
			PrintWriter writer=new PrintWriter(bw);
			reader=new Scanner(new File(filePath));
			reader.useDelimiter("[,\n]");
			while(reader.hasNext()) {
				id=reader.next();
				vehicleType=reader.next();
				licensePlate=reader.next();
				payment=reader.next();
				if(!licensePlate.equals(removeTerm)) {
					writer.println(id+","+vehicleType+","+licensePlate+","+payment);
				}
			}
			reader.close();
			writer.flush();
			writer.close();
			oldfile.delete();
			File deletedFile=new File(filePath);
			newFile.renameTo(deletedFile);
		} catch (IOException e) {
			System.out.println("Unknown Error Occured");
			e.printStackTrace();
		}
		 
	 }
}
