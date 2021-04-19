package algorithms;

import java.util.Arrays;

public class sorts {

	public static void main(String[] args) {
		int[] arr = {1,0,5,6,3,2,3,7,9,8,4};
		int[] arr2 = arr.clone();
				
		System.out.println("unsorted: " + Arrays.toString(arr));
		bubbleSort(arr);
		System.out.println("----------------------");
		System.out.println("bubble sort: " + Arrays.toString(arr));
		
		System.out.println("----------------------");
		System.out.println("unsorted: " + Arrays.toString(arr2));
		mergeSort(arr2, 0, arr2.length - 1);
		System.out.println("----------------------");
		System.out.println("merge sort: " + Arrays.toString(arr2));
	}
	
	public static void bubbleSort(int[] arr) {
		int l = arr.length;
		
		for(int i = 0; i < l-1; i++) {
			for(int j = 0; j < l-i-1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		
	}

	public static void mergeSort(int[] arr, int start, int end) {
		
		if(start < end) {
			int mid = (start + end) / 2;
			mergeSort(arr, start, mid);
			mergeSort(arr, mid+1, end);
			merge(arr, start, mid, end);
		}
		
	}
	
	public static void merge(int[] arr, int start, int mid, int end) {
		int[] temp = new int[end - start + 1];
		
		int s = start;
		int m = mid + 1;
		int i = 0;
		
		while(s <= mid && m <= end) {
			if(arr[s] <= arr[m]) {
				temp[i] = arr[s];
				s++;
			} else {
				temp[i] = arr[m];
				m++;
			}	
			i++;
		}
		
		while (s <= mid) {
			temp[i] = arr[s];
			i++;
			s++;
		}
		
		while(m <= end) {
			temp[i] = arr[m];
			i++;
			m++;
		}
		
		for(s = start; s <= end; s++) {
			arr[s] = temp[s - start];
		}
		
	}
}
