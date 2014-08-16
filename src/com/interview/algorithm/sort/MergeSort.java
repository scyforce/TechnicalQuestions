package com.interview.algorithm.sort;

import java.util.Arrays;

public class MergeSort {
   
	public int[] mergeSort(int[] data){
        if(data.length<=1)
              return data;
        int middle = data.length/2;
        int[] left = new int[middle];
        int[] right = new int[data.length-middle];
        for(int i=0; i<left.length; i++){
              left[i] = data[i];
        }
        for(int i=0; i<right.length;i++){ 
        	right[i] = data[middle+i];
        }
        left = mergeSort(left);
        right = mergeSort(right);
        int[] result = merge(left, right);
        return result;
    }

	public int[] merge(int[] left,int[] right){
        int result[] = new int[left.length + right.length];
        int index = 0;//index of result
        int x = 0;//index of left
        int y = 0;//index of right 

        //compare each element in two arrays, after comparing, index++.
        while(x<left.length && y<right.length){
              if(left[x]<right[y]){
                    result[index++] = left[x++];
              }else{
                    result[index++] = right[y++];
              }
        }
       
        //the length of two arrays might be different, 
        //so we have to copy the rest elements in two arrays
        while(x<left.length)  
              result[index++] = left[x++];  
        while(y<right.length)  
              result[index++] = right[y++];
        return result;
  }

	
	public static void main(String[] args) {
		int[] array = new int[]{7,3,4,2,6,8,1,1,1,1,200,30001,200,4,5,6,7,299,1000,299};
		MergeSort ms = new MergeSort();
		System.out.println(Arrays.toString(ms.mergeSort(array)));

	}

}
