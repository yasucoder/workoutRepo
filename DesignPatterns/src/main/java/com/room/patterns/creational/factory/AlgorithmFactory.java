package com.room.patterns.creational.factory;

public class AlgorithmFactory {
	Algorithms algoObj = null;
	Algorithms getAlgorithm(String algoName){
		if(algoName.compareToIgnoreCase("bubblesort") == 0 ){
			algoObj = new BubbleSort();
		}
		else if(algoName.compareToIgnoreCase("quicksort") == 0 ){
			algoObj = new QuickSort();
		}
		return algoObj;
	}
	

}
