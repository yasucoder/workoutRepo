package com.room.datastructure;

public class QuickSort {
	
	int[] array = null;
	QuickSort(int[] arr){
		array = arr;
	}
	
	int findpivot(int[] arr, int low, int high){
		
		int pivot = high;
			
		int i = low -1;
		int j=low;
		while(i<j && j <= high){
			
			if(arr[j] < arr[pivot]){
				i++;
				int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
				}
			j++;
		}
		int temp = arr[i+1];
		arr[i+1] = arr[pivot];
		arr[pivot] = temp;		
		
		return i+1;
	}
	void sort(){
		sort(array,0,array.length);
	}
	void sort(int[] arr, int low, int high){
		if(low>=high)
			return;
		
		int pivot = findpivot(arr,low,high-1);
		sort (arr,low,pivot-1);
		sort (arr, pivot +1, high);
		
	}
	
	
	
	

	public static void main(String[] args) {
		
		int[] data =  {5,6,2,5,4};
		QuickSort qsort = new QuickSort(data);
		qsort.sort();
		

	}

}
