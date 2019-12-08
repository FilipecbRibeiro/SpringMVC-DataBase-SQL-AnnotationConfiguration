package org.light.spring.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

public class User {
		private int userID;
		@Size(min=2,max=14,message="Enter a name between 2 and 14")
		private String name;
		@Email(message="Enter a valid E-mail!!")
		private String email;
		
		
		
		
		public User(int userID, String name, String email) {
			super();
			this.userID = userID;
			this.name = name;
			this.email = email;
		}
	
		public User() {
		}
		public int getUserID() {
			return userID;
		}
		public void setUserID(int userID) {
			this.userID = userID;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		
		@Override
		public String toString() {
			return "User [userID=" + userID + ", name=" + name + ", email=" + email + "]";
		}
}
