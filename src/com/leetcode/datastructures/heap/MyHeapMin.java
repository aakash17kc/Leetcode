package com.leetcode.datastructures.heap;

import com.example.datastructures.Sorting;

public class MyHeapMin {
  int minHeap[];
  int currSize;
  int maxSize;


  public MyHeapMin(int size) {
    this.minHeap = new int[size+1];
    this.currSize = 0;
    this.maxSize = size;
    minHeap[0] = Integer.MIN_VALUE;
  }

  public void add(int element) {
    currSize++;
    // If the number of elements in the Heap exceeds the preset maxSize
    // print "Added too many elements" and return
    if (currSize > maxSize) {
      System.out.println("Added too many elements!");
      currSize--;
      return;
    }
    // Add the element into the array
    minHeap[currSize] = element;
    // Index of the newly added element
    int index = currSize;
    // Parent node of the newly added element
    // Note if we use an array to represent the complete binary com.leetcode.tree
    // and store the root node at index 1
    // index of the parent node of any node is [index of the node / 2]
    // index of the left child node is [index of the node * 2]
    // index of the right child node is [index of the node * 2 + 1]
    int parent = index / 2;
    // If the newly added element is smaller than its parent node,
    // its value will be exchanged with that of the parent node 
    while ( minHeap[index] < minHeap[parent] && index > 1 ) {
      int temp = minHeap[index];
      minHeap[index] = minHeap[parent];
      minHeap[parent] = temp;
      index = parent;
      parent = index / 2;
    }
  }

  public int peek() {
    return minHeap[1];

  }

  public int poll() {
    if (currSize < 1) {
      return Integer.MAX_VALUE;
    }
    int element = minHeap[1]; //top
    minHeap[1] = minHeap[currSize];
    currSize--;
    int ind = 1;
    heapify(minHeap, currSize, 1);
    return element;

  }

  private void heapify(int[] minHeap, int currSize, int i) {
    int large = i;
    int left = 2 * i ;
    int right = 2 * i + 1;

    if (left < currSize && minHeap[left] > minHeap[large]) {
      large = left;
    }
    if (right < currSize && minHeap[right] > minHeap[large]) {
      large = right;
    }
    if (large != i) {
      Sorting.swap(minHeap, large, i);
      heapify(minHeap, currSize, large);
    }
  }

  public static void main(String[] args) {
    MyHeapMin myHeapMin = new MyHeapMin(5);
    myHeapMin.add(3);
    myHeapMin.add(1);
    myHeapMin.add(2);
    System.out.println(myHeapMin.peek());
    System.out.println(myHeapMin.poll());
    myHeapMin.add(4);
    myHeapMin.add(5);
    System.out.println(myHeapMin.poll());
    System.out.println(myHeapMin.poll());
//    System.out.println(Arrays.toString(myHeap.heapSort(new int[]{20,10,5})));
  }

}
