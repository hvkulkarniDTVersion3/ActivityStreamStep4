package com.stackroute.activitystream.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * The class "User" will be acting as the data model for the user Table in the database. Please
 * note that this class is annotated with @Entity annotation. Hibernate will scan all package for 
 * any Java objects annotated with the @Entity annotation. If it finds any, then it will begin the 
 * process of looking through that particular Java object to recreate it as a table in your database.
 */
@Entity
public class User {

	/*
	 * This class should have three fields (username,name,password). Out of
	 * these three fields, the field username should be the primary key. This
	 * class should also contain the getters and setters for the fields.
	 */
	@Id	
	private String userName;
	private String uname;	
	private String password;

	public User(String uname, String userName, String password) {
		this.uname = uname;
		this.userName = userName;
		this.password = password;
	}

	public User() {
		uname = "HemaK";
		userName = "hvkulkarni";
		password = "hema@123";
	}

	public void setName(String string) {
		this.uname = string;

	}

	public void setPassword(String string) {
		this.password = string;

	}

	public void setUsername(String string) {
		this.userName = userName;

	}

	public String getPassword() {
		return password;
	}

	public String getUname() {
		return uname;
	}

	public String getUserName() {
		return userName;
	}
}