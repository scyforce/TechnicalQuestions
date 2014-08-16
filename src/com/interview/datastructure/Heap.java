package com.interview.datastructure;

import java.util.NoSuchElementException;

//Max heap
public class Heap {
	private int[] heapArray;
	private int maxSize;           // size of array
	private int currentSize;       // number of nodes in array
	
	public Heap(int maxSize) {
		this.maxSize = maxSize;
		this.currentSize = 0;
		this.heapArray = new int[maxSize];
	}
	
	public boolean isEmpty() { 
		return currentSize==0; 
	}
	
	public boolean insert(int key) {
		if(currentSize==maxSize) {
			return false;
		}
		heapArray[currentSize] = key;
		siftUp(currentSize);
		currentSize = currentSize + 1;
		return true;
    } 
	
	public void siftUp(int index) {
		//find heap's last element, and its parent index
		int parent = (index-1) / 2;
		int bottom = heapArray[index];
		
		//compare the element with its parent, if the element is larger than the parent, swap them until meets the root.
		while(index>0 && heapArray[parent]<bottom) {
			heapArray[index] = heapArray[parent];  // move it down
			index = parent;
			parent = (parent-1) / 2;
        }
		//assign the last element to the right place
		heapArray[index] = bottom;
    } 
	
	// delete item with max key
	public int remove()  {
		if (isEmpty()) {
			throw new NoSuchElementException("Heap is Empty!");
		}
		int root = heapArray[0];
		heapArray[0] = heapArray[currentSize];
		currentSize = currentSize-1;
		siftDown(0);
		return root;
    }  
	
	public void siftDown(int index) {
		int largerChild;
		int top = heapArray[index];    // save root
		while(index < currentSize/2) { // while node has at least one child                
			int leftChild = 2*index+1;
			int rightChild = leftChild+1;
			// rightChild shoud exist and find larger child
			if(rightChild < currentSize &&  heapArray[leftChild] < heapArray[rightChild]) {
				largerChild = rightChild;
			} else {
				largerChild = leftChild;
			}
            
            // top >= largerChild
			if( top >= heapArray[largerChild] ) {
				break;
			}
            // shift child up
			heapArray[index] = heapArray[largerChild];
			// go down
			index = largerChild;           
	    } 
		// root to index
		heapArray[index] = top; 
    } 
	
	public boolean change(int index, int newValue) {
		if(index<0 || index>=currentSize) {
			return false;
		}
			
		int oldValue = heapArray[index]; // remember old
		heapArray[index] = newValue;  // change to new
		
		// if raised
		if(oldValue < newValue)  {
			siftUp(index); 
		// if lowered
		} else {
			siftDown(index);
		}
			          
		return true;
    } 
	
	
	public void displayHeap() {
		for (int i = 1; i <= heapArray.length; ++i) {
		    System.out.print(heapArray[i - 1] + " ");
		    if (Math.floor(Math.log(i + 1) / Math.log(2)) > Math.floor(Math.log(i) / Math.log(2))) {
		        System.out.println();
		    }
		}
	}
	
	public static void main(String[] args) {
		Heap heap = new Heap(15);
		heap.insert(10);
		heap.insert(5);
		heap.insert(12);
		heap.insert(22);
		heap.insert(3);
		heap.insert(4);
		heap.insert(7);
		heap.insert(8);
		heap.insert(13);
		heap.insert(11);
		heap.displayHeap();
	}
	
	
}
