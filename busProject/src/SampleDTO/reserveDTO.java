package SampleDTO;

import java.sql.Date;

public class reserveDTO {	
	private int timeno;
	private int routeno;
	private String depart;
	private String arrival;
	private String company;	
	private String rank;	
	private int seat;
	private int seatrmd;
	private int platform;
	private int data;
	
	public int getTimeno() {
		return timeno;
	}
	public void setTimeno(int timeno) {
		this.timeno = timeno;
	}
	public int getRouteno() {
		return routeno;
	}
	public void setRouteno(int routeno) {
		this.routeno = routeno;
	}
	public String getDepart() {
		return depart;
	}
	public void setDepart(String depart) {
		this.depart = depart;
	}
	public String getArrival() {
		return arrival;
	}
	public void setArrival(String arrival) {
		this.arrival = arrival;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public int getSeat() {
		return seat;
	}
	public void setSeat(int seat) {
		this.seat = seat;
	}
	public int getSeatrmd() {
		return seatrmd;
	}
	public void setSeatrmd(int seatrmd) {
		this.seatrmd = seatrmd;
	}
	public int getPlatform() {
		return platform;
	}
	public void setPlatform(int platform) {
		this.platform = platform;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}	
}
