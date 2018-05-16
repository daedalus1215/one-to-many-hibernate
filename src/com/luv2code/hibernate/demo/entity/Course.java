package com.luv2code.hibernate.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="course")
public class Course {
	
	// define our fields
	
	
	
	// define constructors
	
	
	// define getter setters
	
	
	// define tostring
	
	
	// annotate fields
	
	
	private int id;
	private String title;
	private Instructor instructor;
	
	
	public Course() {
		
	}


	public Course(String title) {
		super();
		this.title = title;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public Instructor getInstructor() {
		return instructor;
	}


	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}		
}
