
public class Participants {
	//-----------------------------------------------------
	// Title: Participants class
	// Author: Arda Baran
	// Description: This class consists of fundamental elements of the participants
	// in a zoom meeting such as join date and time of the meeting,leave date and time from the meeting,name and surname,
	//duration and e-Mail.
	//-----------------------------------------------------
	
	
	
	
public String joinTime,leaveTime,nameSurname,eMail;
public double duration;

public Participants(String joinTime,String leaveTime,double duration ,String nameSurname,String eMail ) {
	this.joinTime=joinTime;
	this.leaveTime=leaveTime;
    this.duration=duration;
    this.nameSurname=nameSurname;
    this.eMail=eMail;
  
}
public String getJoinTime() {
	return joinTime;
}
public void setJoinTime(String joinTime) {
	this.joinTime = joinTime;
}
public String getLeaveTime() {
	return leaveTime;
}
public void setLeaveTime(String leaveTime) {
	this.leaveTime = leaveTime;
}
public String getNameSurname() {
	return nameSurname;
}
public void setNameSurname(String nameSurname) {
	this.nameSurname = nameSurname;
}
public String geteMail() {
	return eMail;
}
public void seteMail(String eMail) {
	this.eMail = eMail;
}
public double getDuration() {
	return duration;
}
public void setDuration(double duration) {
	this.duration = duration;
}
public void printParticipants() {//prints the original datas in txt file

System.out.println(getJoinTime()+","+getLeaveTime()+","+getDuration()+","+getNameSurname()+","+geteMail());

}

}
