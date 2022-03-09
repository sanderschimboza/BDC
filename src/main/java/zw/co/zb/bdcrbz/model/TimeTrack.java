package zw.co.zb.bdcrbz.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class TimeTrack implements Serializable{
	private static final long serialVersionUID = 1L;
	
@Id
private String timeLastRun;

public String getTimeLastRun() {
	return timeLastRun;
}

public void setTimeLastRun(String timeLastRun) {
	this.timeLastRun = timeLastRun;
}

public TimeTrack(String timeLastRun) {
	
	this.timeLastRun = timeLastRun;
	
}

public TimeTrack() {
	
}


}
