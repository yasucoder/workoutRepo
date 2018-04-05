package com.mycoderoom.springdemo.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AptCodeConstraintValidator implements
		ConstraintValidator<AptCode, String> {

	private String aptPrefix;

	@Override
	public boolean isValid(String theCode,
			ConstraintValidatorContext theconstraintValidatorContext) {
		boolean result = true;
		if (null != theCode)
			result = theCode.startsWith(aptPrefix);

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.validation.ConstraintValidator#initialize(java.lang.annotation.
	 * Annotation)
	 */
	@Override
	public void initialize(AptCode constraintAnnotation) {
		aptPrefix = constraintAnnotation.value();
	}

}
