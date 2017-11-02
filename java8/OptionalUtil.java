package com.yasucoder.codegrow.java8features;

import java.util.Optional;

public class OptionalUtil {

	public static void main(String[] args) {

		Integer value = null;
		Integer value1 = 10;
		Optional<Integer> a = Optional.ofNullable(value) ;
		Optional<Integer> b = Optional.of(value1);
		
		System.out.println(OptionalUtil.sum(a, b));

	}
	
	public static Integer sum(Optional<Integer> a, Optional<Integer> b){
		
	      //Optional.isPresent - checks the value is present or not
			
	      System.out.println("First parameter is present: " + a.isPresent());
	      System.out.println("Second parameter is present: " + b.isPresent());
			
	      //Optional.orElse - returns the value if present otherwise returns
	      //the default value passed.
	      Integer value1 = a.orElse(new Integer(10));
			
	      //Optional.get - gets the value, value should be present
	      Integer value2 = b.get();
	      return value1 + value2;
	   }

}
