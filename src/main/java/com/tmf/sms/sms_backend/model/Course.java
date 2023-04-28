package com.tmf.sms.sms_backend.model;

public class Course {
    private int cid;
    private String cname;
    private int duration;
    private String curr_status;
    private double fee;
    
    public Course() {}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getCurr_status() {
		return curr_status;
	}

	public void setCurr_status(String curr_status) {
		this.curr_status = curr_status;
	}

	public double getFee() {
		return fee;
	}

	public void setFee(double fee) {
		this.fee = fee;
	}

	@Override
	public String toString() {
		return "Course [cid=" + cid + ", cname=" + cname + ", duration=" + duration + ", curr_status=" + curr_status
				+ ", fee=" + fee + "]";
	}

	public Course(int cid, String cname, int duration, String curr_status, double fee) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.duration = duration;
		this.curr_status = curr_status;
		this.fee = fee;
	}
    
    
}
