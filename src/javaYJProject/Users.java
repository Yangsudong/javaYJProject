package javaYJProject;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Users {
	private SimpleStringProperty userName;
	private SimpleStringProperty userPassword;
	private SimpleStringProperty gender;
	private SimpleIntegerProperty phoneNum;
	
	public Users(String userName,String userPassword,String gender, int phoneNum){
		
	this.userName = new SimpleStringProperty(userName);
	this.userPassword = new SimpleStringProperty(userPassword);
	this.gender = new SimpleStringProperty(gender);
	this.phoneNum = new SimpleIntegerProperty(phoneNum);
	
	
	}
	
	public void setUserName(String userName) {
		this.userName.set(userName);
	}

	public String getUserName() {
		return this.userName.get();
	}

	public SimpleStringProperty userNameProperty() {
		return this.userName;
	}
	
	public void setUserPassword(String userPassword) {
		this.userPassword.set(userPassword);
	}

	public String getUserPassword() {
		return this.userPassword.get();
	}

	public SimpleStringProperty userPasswordProperty() {
		return this.userPassword;
	}
	
	public void setGender(String gender) {
		this.gender.set(gender);
	}

	public String getGender() {
		return this.gender.get();
	}

	public SimpleStringProperty genderProperty() {
		return this.gender;
	}
	
	
	public void setphoneNum(int phoneNum) {
		this.phoneNum.set(phoneNum);
	}

	public int getphoneNum() {
		return this.phoneNum.get();
	}

	public SimpleIntegerProperty phoneNumProperty() {
		return this.phoneNum;
	}
}

