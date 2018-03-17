package application;

public enum AppointmentType {
	REGULAR("Regular"),
	EXAM("Medical Exam");
	
	private String type;
	
	private AppointmentType(String type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return type;
	}
}
