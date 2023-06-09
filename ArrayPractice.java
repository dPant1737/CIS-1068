package ArrayPractice.src.arraypractice;

import java.util.Arrays;
import java.util.Collection;
import java.util.*; 

public class ArrayPractice {
  /* sets every item in A[] to initialValue */
  public static void initialize(int A[], int initialValue) {
    for(int i = 0; i < A.length;  i++)
    {
      A[i] = initialValue; 
    }
    return;
  }

  /* returns the average of the items in A
   * Be careful: A[] is an array of int and the method returns
   * double. What do we do to handle this? */
  public static double average(int A[]) {
    double average = 0.0;
    if(A.length > 0)
    {
      int sum = 0;
      for(int i = 0; i < A.length; i++)
      {
        sum += A[i]; 
      }
      
      average = sum/A.length; 
    }
    return average;
  }

  /* returns the number of times that x appears in A[] */
  public static int numOccurrences(int A[], int x) {
    int numOfTimesXAppears = 0; 
    int arrayLength = A.length; 
    if (arrayLength > 0) 
    {
      for(int i = 0; i < arrayLength; i++)
      {
        if (A[i] == x) 
        {
          numOfTimesXAppears++;
        }
      }
    }
    return numOfTimesXAppears;
  }


  /* returns the index of the first occurrence of
   * x in A[] or -1 if x doesn't exist in A[] */
  public static int find(int A[], int x) {
    int index = -1; 
    for(int i = 0; i < A.length; i++)
    {
      if(A[i] == x)
      {
        index = i; 
        break; 
      }
    }
    return index;
  }

  /* Returns the index of the first occurrence of
   * item within the first n elements of A[] or -1
   * if item is not among the first n elements of A[] */
  public static int findN(int A[], int item, int n) {
    int index = -1; 
    for(int i = 0; i < n; i++)
    {
      if (A[i] == item) 
      {
        index = i;
        break; 
      }
    }
    return index;
  }

  /* returns the index of the last occurrence of
   * x in A[] or -1 if x doesn't exist in A[] */
  public static int findLast(int A[], int x) {
    int index = -1; 
    for(int i = A.length - 1; i >= 0; i--)
    {
      if (A[i] == x) 
      {
        index = i;
        break;   
      }
    }
    return index;
  }

  /* returns the largest item found in A */
  public static int largest(int A[]) {
    int largest = 0; 
    for(int i = 0; i < A.length; i++)
    {
      if (A[i] > largest) 
      {
        largest = A[i]; 
      }
    }
    return largest;
  }

  /* returns the index of the largest item found in A */
  public static int indexOfLargest(int A[]) {
    int indexOfLargest = 0; 
    int largest = 0;
    for(int i = 0; i < A.length; i++)
    {
      if (A[i] > largest) 
      {
        largest = A[i]; 
        indexOfLargest = i;  
      }
    }
    return indexOfLargest;
  }

  /* returns the index of the largest odd number
   * in A[] or -1 if A[] contains no odd numbers */
  public static int indexOfLargestOdd(int A[]) {
    int indexOfLargestOdd = -1; 
    int largestOdd = 1;
    for(int i = 0; i < A.length; i++)
    {
      if (A[i]%2 != 0 && A[i] > largestOdd) 
      {
        largestOdd = A[i];
        indexOfLargestOdd = i;   
      }
    }
    return indexOfLargestOdd;
  }

  /* inserts n into A[] at A[index] shifting all */
  /*  the previous items one place to the right. For example */
  /*  if A is  */
  /*   |---+---+---+---+---+---+---+---+---+---| */
  /*   | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | */
  /*   |---+---+---+---+---+---+---+---+---+---| */
  /*   | 5 | 7 | 6 | 9 | 4 | 3 | 0 | 0 | 0 | 0 | */
  /*   |---+---+---+---+---+---+---+---+---+---| */

  /*   and we call insert(A, 15, 1), A then becomes */

  /*   |---+----+---+---+---+---+---+---+---+---| */
  /*   | 0 |  1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | */
  /*   |---+----+---+---+---+---+---+---+---+---| */
  /*   | 5 | 15 | 7 | 6 | 9 | 4 | 3 | 0 | 0 | 0 | */
  /*   |---+----+---+---+---+---+---+---+---+---| */
  /*  the element in A[] that's in the right-most */
  /*    position is removed.                      */
  /*                                              */
  /*  if index < 0 or index >= A.length-1, the method */
  /*                                    does nothing */
  public static void insert(int A[], int n, int index) {
    if(index >= 0 && index < A.length - 1)
    {
      int[] temp = new int[A.length];
      for(int i = 0; i < A.length; i++)
      {
        temp[i] = A[i]; 
      }
      for(int j = index + 1; j < A.length - index; j++)
      {
        A[j] = temp[j-1]; 
      }
      A[index] = n; 
    }
    return;
  }

  /* returns a new array consisting of all of the
   * elements of A[] */
  public static int[] copy(int A[]) {
    int[] copyOfArray = new int[A.length];
    for(int i = 0; i < A.length; i++)
    {
      copyOfArray[i] = A[i]; 
    }
    return copyOfArray;
  }

  /* Returns a new array consisting of all of the
     first n elements of A[]. If n>A.length, returns a
     new array of size n, with the first A.length elements
     exactly the same as A, and the remaining n-A.length elements
     set to 0. If n<=0, returns null. */
  public static int[] copyN(int A[], int n) {
    if(n > 0)
    {
      int[] copyNElements = new int[n]; 
      for(int i = 0; i < n; i++)
      {
        copyNElements[i] = 0; 
      }
      int upperIndex = A.length; 
      if (n < upperIndex) 
      {
        upperIndex = n;   
      }
      for(int j = 0; j < upperIndex; j++)
      {
        copyNElements[j] = A[j]; 
      }
    
      return copyNElements;
    }
    else
    {
      return null; 
    }
  }

  /* returns a new array consisting of all of the
   * elements of A[] followed by all of the
   * elements of B[]. For example, if 
   A[] is: {10,20,30} and 
   B[] is: {5, 9, 38}, the method returns the
   array : {10,20,30,5,9,38} */
  public static int[] copyAll(int A[], int B[]) {
    int numOfElements = A.length + B.length; 
    int[] unionArray = new int[numOfElements];
    for(int i = 0; i < A.length; i++)
    {
      unionArray[i] = A[i]; 
    }
    for(int j = 0; j < B.length; j++)
    {
      unionArray[j + A.length] = B[j]; 
    }
    return unionArray;
  }

  /* reverses the order of the elements in A[].
   * For example, if A[] is:
   {10,20,30,40,50}, after the method, A[] would
   be {50,40,30,20,10} */
  public static void reverse(int A[]) {
    int x; 
    int y = A.length; 
    for(int i = 0; i < y / 2; i++)
    {
      x = A[i]; 
      A[i] = A[y - i -1];
      A[y - i - 1] = x; 
    }
    return;
  }

  /* Extra credit:
   *
   * Returns a new array consisting of all of the
   * elements of A, but with no duplicates. For example,
   * if A[] is {10,20,5,32,5,10,9,32,8}, the method returns
   * the array {10,20,5,32,9,8} */
  public static int[] uniques(int A[]) {
    return null; 
  }

  public static void main(String[] args) {
    return;
  }
}
