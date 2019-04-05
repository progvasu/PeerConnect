package com.peerconnect.request;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="requesttable")
public class Requesttable {
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int requestid;
		private int requestby;
		private String requestmsg;
		private String createdate;
		private String createtime;
		private String stopdate;
		private String stoptime;
		
		public Requesttable()	{
			
		}
		
		public Requesttable(String request_msg)	{
			this.requestmsg = request_msg;
			
			Date date = Calendar.getInstance().getTime();  
			
	        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");  
	        DateFormat timeFormat = new SimpleDateFormat("hh:mm:ss");
	        
	        String strDate = dateFormat.format(date); 
	        String strtime = timeFormat.format(date);
	        
	        this.setCreatedate(strDate);
	        this.setCreatetime(strtime);
		}
		
		public int getRequestid() {
			return requestid;
		}
		public void setRequestid(int request_id) {
			this.requestid = request_id;
		}
		public int getRequestby() {
			return requestby;
		}
		public void setRequestby(int request_by) {
			this.requestby = request_by;
		}
		public String getRequestmsg() {
			return requestmsg;
		}
		public void setRequestmsg(String request_msg) {
			this.requestmsg = request_msg;
		}
		public String getCreatedate() {
			return createdate;
		}
		public void setCreatedate(String create_date) {
			this.createdate = create_date;
		}
		public String getCreatetime() {
			return createtime;
		}
		public void setCreatetime(String create_time) {
			this.createtime = create_time;
		}
		public String getStopdate() {
			return stopdate;
		}
		public void setStopdate(String stop_date) {
			this.stopdate = stop_date;
		}
		public String getStoptime() {
			return stoptime;
		}
		public void setStoptime(String stop_time) {
			this.stoptime = stop_time;
		}
}
	
