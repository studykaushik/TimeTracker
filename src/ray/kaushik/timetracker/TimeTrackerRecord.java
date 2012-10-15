package ray.kaushik.timetracker;

public class TimeTrackerRecord {
	private String time;
	private String notes;
	
	public TimeTrackerRecord(String time,String  notes){
		this.time = time;
		this.notes = notes;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
	
}
