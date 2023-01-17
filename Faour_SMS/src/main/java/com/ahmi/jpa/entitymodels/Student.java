package com.ahmi.jpa.entitymodels;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/*
 * These annotations are signifying that an entity is being created,
 * and will be turned into a table by the name of "Student".
 */

@Entity
@Table(name = "Student")
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/*
	 * Here, the primary key is being set to email, the unique identifier for the
	 * Student table.
	 */
	
	@Id
	@Column (name = "Email", length = 50, nullable = false)
	private String sEmail;
	
	@Column (name = "Name", length = 50, nullable = false)
	private String sName;
	
	@Column (name = "Password", length = 50, nullable = false)
	private String sPass;
	
	
	/*
	 * ManyToMany relationship was chosen, because many students can have many courses.
	 */
	
	@ManyToMany(targetEntity = Course.class, cascade = {(CascadeType.ALL)})
	private List<Course> sCourses;
	
	
	/*
	 * Empty constructor for the Student object. 
	 */
	
	public Student() {
		this.sEmail = "";
		this.sName = "";
		this.sPass = "";
		this.sCourses = null;
	}

	/*
	 *  Constructor with parameters for the Student object.
	 */
	
	public Student(String sEmail, String sName, String sPass, List<Course> sCourses) {
		this.sEmail = sEmail;
		this.sName = sName;
		this.sPass = sPass;
		this.sCourses = sCourses;
	}
	
	/*
	 * Below are the various "Getters" and "Setters" for the parameters specified
	 * in the Student object constructor above.
	 */
	
	public String getsEmail() {
		return sEmail;
	}

	public void setsEmail(String sEmail) {
		this.sEmail = sEmail;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getsPass() {
		return sPass;
	}

	public void setsPass(String sPass) {
		this.sPass = sPass;
	}

	public List<Course> getsCourses() {
		return sCourses;
	}

	public void setsCourses(List<Course> sCourses) {
		this.sCourses = sCourses;
	}
	
	/*
	 * This toString method creates a readable output for the Student table onto
	 * the console.
	 */
	
	@Override
	public String toString() {
		return "Student [sEmail=" + sEmail + ", sName=" + sName + ", sPass=" + sPass + ", sCourses=" + sCourses + "]";
	}
	
	
}
