import java.io.*;
import java.util.*;

public class merge{
  public static void main(String[] args){
    int[] data1 = {1,2};
    int[] data2 = {7,8} ;

    System.out.println(Arrays.toString(merge(data1,data2)));
  }

  public static void mergesort(int[] data){

  }

  public static int[] merge(int[] data1, int[] data2){ // takes in 2 sorted arrays and merge them into 1 sorted array
    int d1 = data1.length;
    int d2 = data2.length;
    int[] output = new int[d1 + d2];
    int index1 = 0;
    int index2 = 0;

    for(int i = 0; i < output.length; i++){
      if( index1 >= data1.length){ // the first array is entirely finsihed
        output[i] = data2[index2];
        index2++;
      }else if( index2 >= data2.length){ // the second array is entirely finsihed
        output[i] = data1[index1];
        index1++;
      }else if( data1[index1] <= data2[index2]){
        output[i] = data1[index1];
        index1++;
      }else if( data2[index2] <= data1[index1]){
        output[i] = data2[index2];
        index2++;
      }
    }

    return output;

  }

}
