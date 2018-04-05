package com.mycoderoom.springdemo.model;

import java.util.LinkedHashMap;
import java.util.List;

public class Employee {

	private String firstName;
	private String lastName;
	private String jobType;
	private LinkedHashMap<String, String> jobtypeOptions;
	private String mainSkill;
	private String[] operatingSystem;

	public Employee() {
		jobtypeOptions = new LinkedHashMap<String, String>();
		jobtypeOptions.put("FT", "FullTime");
		jobtypeOptions.put("CO", "Contract");
		// operatingSystem = new String {"Linux","Mac OS","MS Windows"}

	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the jobType
	 */
	public String getJobType() {
		return jobType;
	}

	/**
	 * @param jobType
	 *            the jobType to set
	 */
	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	/**
	 * @return the jobtypeOptions
	 */
	public LinkedHashMap<String, String> getJobtypeOptions() {
		return jobtypeOptions;
	}

	/**
	 * @return the mainSkill
	 */
	public String getMainSkill() {
		return mainSkill;
	}

	/**
	 * @param mainSkill
	 *            the mainSkill to set
	 */
	public void setMainSkill(String mainSkill) {
		this.mainSkill = mainSkill;
	}

	/**
	 * @return the operatingSystem
	 */
	public String[] getOperatingSystem() {
		return operatingSystem;
	}

	/**
	 * @param operatingSystem
	 *            the operatingSystem to set
	 */
	public void setOperatingSystem(String[] operatingSystem) {
		this.operatingSystem = operatingSystem;
	}

}
