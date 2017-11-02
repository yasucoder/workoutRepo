package com.yasucoder.codegrow.Algorithms;

public class SortingCollection {
	
	public static int[] selectionSort(int[] array){
		int imin = 0;
		int n = array.length;
		for (int i=0;i<n-2;i++){
			imin=i;
			for(int j = i+1;j<n;j++){
				System.out.println(j);
				if(array[j]<array[imin])
					imin = j;
			}
			if(imin != i){
				swapNumbers(i,imin,array);
			}
		}
		printNumbers(array);
		return array;
	}
	
	public static int[] insertionSort(int[] array){
		int n = array.length;
		
		for(int i=1; i<n;i++){
			int value = array[i];
			int hole = i;
			while(hole>0 && array[hole-1]>value){
				array[hole] = array[hole -1];
				hole = hole -1;
			}
			
			array[hole] = value;			
		}
		
		printNumbers(array);
		return array;
	}
	
	
	public static void merge(int[] leftarray, int[] rightarray, int[] array){
		int leftlen = leftarray.length;
		int rightlen = rightarray.length;
		int len = array.length;
		
		int i = 0,j = 0,k=0;
		
		while(i<leftlen && j<rightlen){
			
			if(leftarray[i]<rightarray[j]){
				array[k]= leftarray[i];
				k = k+1;
				i = i+1;
			}
			else{
				array[k] = rightarray[j];
				k = k+1;
				j = j+1;
			}			
		}
		while(i<leftlen){
			array[k]= leftarray[i];
			k = k+1;
			i = i+1;
		}
		while(j<rightlen){
			array[k] = rightarray[j];
			k = k+1;
			j = j+1;
		}	
		//printNumbers(array);
	}
	public static void mergeSort(int[] array){
		
		int n = array.length;
		if(n<2) return;
		int mid = n/2;
		int[] leftarray = new int[mid];
		int[] rightarray= new int[n-mid];
		
		for(int i = 0; i<mid; i++){
			leftarray[i] = array[i];
		}
		for(int i = mid; i<n; i++){
			rightarray[i-mid] = array[i];
		}
		
		mergeSort(leftarray);
		mergeSort(rightarray);
		merge(leftarray, rightarray, array);
		
		printNumbers(array);
	}
	
	
	private static void printNumbers(int[] input) {
		
		for (int i = 0; i < input.length; i++) {
		System.out.print(input[i] + ", ");
		}
		System.out.println("\n");
	}
	private static void swapNumbers(int i, int j, int[] array) {

		int temp;
		temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

}
