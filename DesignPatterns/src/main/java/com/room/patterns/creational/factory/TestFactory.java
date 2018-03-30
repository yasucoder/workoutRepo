package com.room.patterns.creational.factory;

public class TestFactory {

	public static void main(String[] args) {
		AlgorithmFactory fac = new AlgorithmFactory();
		Algorithms algo = fac.getAlgorithm("bubblesort");
		algo.sort();
		algo = fac.getAlgorithm("quicksort");
		algo.sort();
	}

}
