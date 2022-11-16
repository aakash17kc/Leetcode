package com.leetcode.datastructures;

import java.util.Arrays;

public class Sorting {

  public static void main(String[] args) {
    int arr[] = {789, 345, 678, 12, 45, 99, 5467, 234, 43234, 56778, 21324, 3546};

//    System.out.println(Arrays.toString(selectionSort(arr)));
//    System.out.println(Arrays.toString(bubbleSort(arr)));
//    System.out.println(Arrays.toString(mergeSort(arr)));
//    System.out.println(Arrays.toString(insertionSort(arr)));

    System.out.println(Arrays.toString(quickSort(arr,0, arr.length-1)));
//    System.out.println(Arrays.toString(heapSort(arr)));
//    System.out.println(Arrays.toString(countSort(arr)));



  }

  private static int[] countSort(int[] arr) {
     return arr;
  }

  private static int[] heapSort(int[] arr) {

    int n = arr.length;;
    for (int i = n/2-1; i >= 0; i--) {
      heapify(arr,n,i);
    }
    for (int i = n-1; i >= 0; i--) {
      swap(arr,i,0);
      heapify(arr,i,0);
    }

    return arr;

  }

  private static void heapify(int[] arr, int n, int i) {
    int large = i;
    int left = 2*i+1;
    int right = 2*i+2;

    if(left < n && arr[left] > arr[large]){
      large = left;
    }
    if(right < n && arr[right] > arr[large]){
      large = right;
    }
    if(large!=i){
      swap(arr, large, i);
      heapify(arr, n, large);
    }
  }

  private static int[] quickSort(int[] arr, int left, int right) {
    if (left < right) {
      int pos = getPivot(arr, left, right);
      quickSort(arr, left, pos-1);
      quickSort(arr, pos + 1, right);

    }
    return arr;
  }

  private static int getPivot(int[] arr, int low, int high) {
    int indx = low-1;

    for (int i = low; i <= high - 1; i++) {
      if (arr[i] < arr[high]) {
        indx++;
        swap(arr, indx, i);
      }
    }
    swap(arr, indx + 1, high);
    return indx + 1;
  }

  private static int[] insertionSort(int[] arr) {

    int n = arr.length;

    for (int i = 1; i < n; i++) {
      int key = arr[i];
      int j = i - 1;

      while (j >= 0 && arr[j] > key) {
        arr[j + 1] = arr[j];
        j--;
      }
      arr[j + 1] = key;

    }
    return arr;
  }

  private static int[] mergeSort(int[] arr) {
    if (arr.length <= 1) {
      return arr;
    }
    int mid = arr.length / 2;
    int[] leftList = mergeSort(Arrays.copyOfRange(arr, 0, mid));
    int[] rightList = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));
    return merge(leftList, rightList);
  }

  private static int[] merge(int[] leftList, int[] rightList) {
    int leftI = 0, rightI = 0, sortArr[] = new int[leftList.length + rightList.length], ind = 0;

    while (leftI < leftList.length && rightI < rightList.length) {
      if (leftList[leftI] < rightList[rightI]) {
        sortArr[ind] = leftList[leftI];
        leftI++;
        ind++;
      } else {
        sortArr[ind] = rightList[rightI];
        rightI++;
        ind++;
      }
    }
    while (leftI < leftList.length) {
      sortArr[ind] = leftList[leftI];
      leftI++;
      ind++;
    }
    while (rightI < rightList.length) {
      sortArr[ind] = rightList[rightI];
      rightI++;
      ind++;
    }
    return sortArr;
  }

  private static int[] bubbleSort(int[] arr) {
    int n = arr.length;
    boolean swapped;
    for (int i = 0; i < n - 1; i++) {
      swapped = false;
      for (int j = 0; j < n - i - 1; j++) {
        if (arr[j] > arr[j + 1]) {
          swap(arr, j, j + 1);
          swapped = true;
        }

      }
      if (!swapped) {
        break;
      }

    }
    return arr;
  }


  private static int[] selectionSort(int[] arr) {

    int n = arr.length;

    for (int i = 0; i < n - 1; i++) {
      int min_ind = i;
      for (int j = i + 1; j < n; j++) {
        if (arr[j] < arr[min_ind]) {
          min_ind = j;
        }
      }
      swap(arr, min_ind, i);
    }
    return arr;
  }


  public static void swap(int[] arr, int min_ind, int i) {
    int temp = arr[min_ind];
    arr[min_ind] = arr[i];
    arr[i] = temp;
  }


}
