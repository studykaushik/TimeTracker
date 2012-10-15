package ray.kaushik.timetracker;

import java.util.ArrayList;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class Time_Tracker_Adapter extends BaseAdapter {
	private ArrayList<TimeTrackerRecord> timeRecordArray = new ArrayList<TimeTrackerRecord>();
	
	public Time_Tracker_Adapter() {
		super();
		// TODO Auto-generated constructor stub
		timeRecordArray.add(new TimeTrackerRecord("28:43", "Gud one"));
		timeRecordArray.add(new TimeTrackerRecord("12:3", "woooww"));
		timeRecordArray.add(new TimeTrackerRecord("32:5", "Gud race"));
		timeRecordArray.add(new TimeTrackerRecord("54:5", "OMG"));
		timeRecordArray.add(new TimeTrackerRecord("55:55", "HELL NO"));
		timeRecordArray.add(new TimeTrackerRecord("22:4", "HAHA..!! WHOS D Daddy now..!!"));
		
	}

	public void addTimeRecord(TimeTrackerRecord timeTrack){
		timeRecordArray.add(timeTrack);
	}
	public int getCount() {
		// TODO Auto-generated method stub
		return timeRecordArray.size();
	}

	public Object getItem(int index) {
		// TODO Auto-generated method stub
		if(timeRecordArray!= null && !timeRecordArray.isEmpty()){
			return getItem(index);
		}else{
			return null;
		}
	}

	public long getItemId(int index) {
		// TODO Auto-generated method stub
		return index;
	}

	public View getView(int index, View view, ViewGroup parent) {
		// TODO Auto-generated method stub
		if(view == null){
			LayoutInflater inflater = LayoutInflater.from(parent.getContext());
			view = inflater.inflate(R.layout.time_tracker_list_item, parent, false);
		}
		TimeTrackerRecord timeTrackerRecordInst = timeRecordArray.get(index);
		TextView timeText = (TextView)view.findViewById(R.id.time_view);
		timeText.setText(timeTrackerRecordInst.getTime());
		
		TextView notesText = (TextView) view.findViewById(R.id.notes_view);
		notesText.setText(timeTrackerRecordInst.getNotes());
		
		return view;
	}

   /* @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.time__tracker_layout);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.time__tracker_layout, menu);
        return true;
    }*/
}
