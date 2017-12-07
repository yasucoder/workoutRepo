package com.webservice.app.model;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/*@XmlRootElement(name = "consumedetails")
@XmlType(propOrder = {"userID", "userName", "password", "roleName", "emailId", "contactNo"})
@JsonPropertyOrder({"userID", "userName", "password", "roleName", "emailId", "contactNo"})*/

/*{
    "userID": "1",
    "userName": "Hash_Key",
    "password": "Suyatchi",
    "role": "Test",
    "emailId": "/",
    "contactNo": ""
    
}*/
public class ConsumeDetails  {
	
	private String userID;
	private String userName;
	private String password;
	private String roleName;
	private String emailId;
	private String contactNo;
	
	
	/**
	 * @param userID
	 * @param userName
	 * @param password
	 * @param roleName
	 * @param emailId
	 * @param param1
	 * @param param2
	 * @param param3
	 */
	public ConsumeDetails(String userID, String userName,
			String password, String roleName, String emailId,
			String contactNo) {
		
		this.userID = userID;
		this.userName = userName;
		this.password = password;		
		this.roleName = roleName;
		this.emailId = emailId;
		this.contactNo = contactNo;
		
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the roleName
	 */
	public String getRoleName() {
		return roleName;
	}
	/**
	 * @param roleName the roleName to set
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	/**
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}
	/**
	 * @param emailId the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	/**
	 * @return the contactNo
	 */
	public String getContactNo() {
		return contactNo;
	}
	/**
	 * @param contactNo the contactNo to set
	 */
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	/**
	 * 
	 */
	public ConsumeDetails() {
		
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}	

}
