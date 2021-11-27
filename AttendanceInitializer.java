package application;

import javafx.scene.control.RadioButton;

public class AttendanceInitializer {
	private String id,name;
	private RadioButton button;
	private int presentDay,absentDay;
	public AttendanceInitializer(String id, String name, RadioButton button, int presentDay, int absentDay) {
		super();
		this.id = id;
		this.name = name;
		this.button = button;
		this.presentDay = presentDay;
		this.absentDay = absentDay;
	}
	public void setAbsentDay(int absentDay) {
		this.absentDay = absentDay;
	}
	public void setButton(RadioButton button) {
		this.button = button;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPresentDay(int presentDay) {
		this.presentDay = presentDay;
	}
	public int getAbsentDay() {
		return absentDay;
	}
	public RadioButton getButton() {
		return button;
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getPresentDay() {
		return presentDay;
	}
	
}
