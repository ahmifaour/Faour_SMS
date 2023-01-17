package com.ahmi.jpa.entitymodels;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * These annotations are signifying that an entity is being created,
 * and will be turned into a table by the name of "Student".
 */

@Entity
@Table(name = "Course")
public class Course implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/*
	 * Here, the primary key is being set to course ID, the unique identifier for
	 * the Course table.
	 */
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "ID", nullable = false)
	private int cId;
	
	@Column (name = "Name", length = 50, nullable = false)
	private String cName;
	
	@Column (name = "Instructor", length = 50, nullable = false)
	private String cInstructorName;
	
	/*
	 * Empty constructor for the Course object.
	 */
	
	public Course() {
		this.cId = 0;
		this.cName = "";
		this.cInstructorName = "";
	}
	
	/*
	 * Constructor with parameters for the Course object.
	 */

	public Course(int cId, String cName, String cInstructorName) {
		this.cId = cId;
		this.cName = cName;
		this.cInstructorName = cInstructorName;
	}

	
	/*
	 * Below are the various "Getters" and "Setters" for the parameters specified
	 * in the Course object constructor above.
	 */
	
	public int getcId() {
		return cId;
	}


	public void setcId(int cId) {
		this.cId = cId;
	}


	public String getcName() {
		return cName;
	}


	public void setcName(String cName) {
		this.cName = cName;
	}


	public String getcInstructorName() {
		return cInstructorName;
	}


	public void setcInstructorName(String cInstructorName) {
		this.cInstructorName = cInstructorName;
	}

	/*
	 * This toString method creates a readable output for the Course table onto
	 * the console.
	 */
	
	@Override
	public String toString() {
		return "Course [cId=" + cId + ", cName=" + cName + ", cInstructorName=" + cInstructorName + "]";
	}

	
}
