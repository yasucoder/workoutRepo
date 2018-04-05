package com.mycoderoom.springdemo.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.mycoderoom.springdemo.validation.AptCode;

public class Renter {

	private String firstName; // No Rules

	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String lastName;

	@NotNull(message = "is required")
	@Min(value = 0, message = "must be greater than or equal to 0 parking space")
	@Max(value = 3, message = "must be less than or equal to 3 parking space")
	private Integer parkinglot; // Change to interger there is preprocess method
								// which try to trim

	@Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "only 5 char/digits")
	private String postalCode;

	@AptCode(value = "APT", message = "must start with APT")
	private String aptCode;

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
	 * @return the parkinglot
	 */
	public Integer getParkinglot() {
		return parkinglot;
	}

	/**
	 * @param parkinglot
	 *            the parkinglot to set
	 */
	public void setParkinglot(Integer parkinglot) {
		this.parkinglot = parkinglot;
	}

	/**
	 * @return the postalCode
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * @param postalCode
	 *            the postalCode to set
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	/**
	 * @return the aptCode
	 */
	public String getAptCode() {
		return aptCode;
	}

	/**
	 * @param aptCode
	 *            the aptCode to set
	 */
	public void setAptCode(String aptCode) {
		this.aptCode = aptCode;
	}

}
