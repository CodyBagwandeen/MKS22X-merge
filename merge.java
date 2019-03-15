import java.io.*;
import java.util.*;

public class merge{
  public static void main(String[] args){
    int[] data1 = {1,2,3,4,5,6};
    int[] data2 = {7,8,9,10,11,12,13};

    System.out.println(Arrays.toString(merge(data1,data2)));
  }

  public static void mergesort(int[] data){

  }

  public static int[] merge(int[] data1, int[] data2){ // takes in 2 sorted arrays and merge them into 1 sorted array
    int d1 = data1.length;
    int d2 = data2.length;
    int[] output = new int[d1 + d2];

    if(d1 < d2){
      for(int i = 0; i < d1; i++){
        if(data1[i] < data2[i]){
          output[i] = data1[i];
          output[i+1] = data2[i];
        }else {
          output[i] = data2[i];
          output[i+1] = data1[i];
        }
      }
      for(int j = d1; j < d2; j++){
        output[j] = data2[j];
      }
    }else{
      for(int i = 0; i < d2; i++){
        if(data1[i] < data2[i]){
          output[i] = data1[i];
          output[i+1] = data2[i];
        }else{
          output[i] = data2[i];
          output[i+1] = data1[i];
        }
      }
      for(int j = d2; j < d1; j++){
        output[j] = data1[j];
      }
    }

    return output;

  }

}
