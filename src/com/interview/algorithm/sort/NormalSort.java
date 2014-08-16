package com.interview.algorithm.sort;

public class NormalSort {
	 public void selectionSort(int[] data){
         int minimum = 0;
         for(int i=0; i<data.length-1; i++){
               minimum = i;
               for(int j=i+1;j<data.length;j++){
                     if(data[j]<data[minimum]){
                           minimum = j;
                     }
               }
               SortUtils.swap(data,i,minimum);
         }
     }
	 
	 public void insertionSort(int[] data){
	        int key = 0;
	        int j = 0;
	        for(int i=1; i<data.length; i++){
	              key = data[i];
	              j = i-1;
	              while(j>=0 && data[j]>key){
	            	    SortUtils.swap(data,j,j+1);
	                    j=j-1;
	              }
	        }
	 }
	 
	 public void bubbleSort(int[] data){
         for(int i=0; i<data.length; i++){
               for(int j=0; j<data.length-1-i; j++){
                     if(data[j]>data[j+1]){
                           SortUtils.swap(data,j,j+1);
                     }
               }
         }
     }
}
