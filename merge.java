import java.io.*;
import java.util.*;

public class merge{
  public static void main(String[] args){
    int[] a = {};
    int[] b = {};
    int[] c = {1,2,3,4,5,6,7,8,9,10};
    int[] d = {11,12,13,14,15,16,17,18,19,20};
    int[] e = {1,3,5,7,9,12,14,16,18,20};
    int[] f = {2,4,6,8,10,11,13,15,17,19};

    System.out.println("Array a :" + Arrays.toString(a));
    System.out.println("Array b :" + Arrays.toString(b));
    System.out.println("Array c :" + Arrays.toString(c));
    System.out.println("Array d :" + Arrays.toString(d));
    System.out.println("Array e :" + Arrays.toString(e));
    System.out.println("Array f :" + Arrays.toString(f));

    System.out.println();

    System.out.println("merge on array a and b should be [] ");
    System.out.println(Arrays.toString(merge(a,b)));
    System.out.println("merge on array c and d : should be [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19.20]");
    System.out.println(Arrays.toString(merge(c,d)));
    System.out.println("merge on array e and f : should be [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19.20]");
    System.out.println(Arrays.toString(merge(e,f)));
  }

  public static void mergesort(int[] data){
    mergesortH(data, 0, data.length-1);
  }

  public static void mergesortH(int[] data, int lo, int hi){
    if( lo >= hi){
      return;
    }

    if( hi - lo < 56){
      insertionsort(data,0,data.length-1);
    }
    int mid = data.length / 2;

    int[] left = new int[mid];
    for(int i = 0; i < left.length; i++){
      left[i] = data[i];
    }

    int[] right = new int[data.length - mid];
    for(int i= 0; i < right.length;i++){
      right[i] = data[i+mid];
    }
    //mergesort the left side
    //mergesort the right side
    //merge


    mergesortH(left, lo, left.length -1);
    mergesortH(right, left.length, data.length-1);
    merge(left,right);
  }

  public static int[] merge(int[] data1, int[] data2){ // takes in 2 sorted arrays and merge them into 1 sorted array
    int d1 = data1.length;
    int d2 = data2.length;
    int[] output = new int[d1 + d2]; // temp array
    int index1 = 0;
    int index2 = 0;

    for(int i = 0; i < output.length; i++){
      if( index1 >= data1.length){ // the first array is entirely finsihed
        output[i] = data2[index2];
        index2++;
      }else if( index2 >= data2.length){ // the second array is entirely finsihed
        output[i] = data1[index1];
        index1++;
      }else if( data1[index1] <= data2[index2]){ // the number of the first array is smaller or equal
        output[i] = data1[index1];
        index1++;
      }else if( data2[index2] <= data1[index1]){ // the number of the second array is smaller or equal
        output[i] = data2[index2];
        index2++;
      }
    }

    return output;

  }

  public static void insertionsort(int[] data, int start, int end){
    int temp = 0;
    int temp2 =0;
    for(int i = start +1; i < end + 1; i++){
      temp = data[i];
      for(temp2 = i-1; temp2 >= 0 && data[temp2] > temp; temp2--){
        data[temp2+1] = data[temp2];
      }
      data[temp2+1] = temp;
    }

  }

}
