package com.yasucoder.string;

public class PyramidPattern {

	public static void printpyamidTriangle(int n) {

		String printstr = new String("");
		for (int i = 0; i < n; i++) {
			printstr = "";
			for (int j = 0; j < (n - i); j++) {
				printstr += " ";
			}
			for (int k = 0; k <= i; k++) {
				printstr = printstr + k + " ";
			}
			System.out.println(printstr);
		}
	}

	public static void main(String[] args) {

		PyramidPattern.printpyamidTriangle(10);

	}

}
