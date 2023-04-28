package com.tmf.sms.sms_backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
record Employer(@Id @GeneratedValue(strategy = GenerationType.SEQUENCE)int employerId,String organizationName,String contactPerson,long phoneNumber,String address,String technologiesWorkingOn) {}

public class Concept {
	private int id;
	private String conceptName;
	private String conceptDescription;
	private double duration;
	
	public Concept() {}
	
	public Concept(int id, String conceptName, String conceptDescription, int duration) {
		super();
		this.id = id;
		this.conceptName = conceptName;
		this.conceptDescription = conceptDescription;
		this.duration = duration;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getConceptName() {
		return conceptName;
	}
	public void setConceptName(String conceptName) {
		this.conceptName = conceptName;
	}
	public String getConceptDescription() {
		return conceptDescription;
	}
	public void setConceptDescription(String conceptDescription) {
		this.conceptDescription = conceptDescription;
	}
	public double getDuration() {
		return duration;
	}
	public void setDuration(double duration) {
		this.duration = duration;
	}
	@Override
	public String toString() {
		return "Concept [id=" + id + ", conceptName=" + conceptName + ", conceptDescription=" + conceptDescription
				+ ", duration=" + duration + "]";
	}
}
