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

    if( d1 < d2 ){// data 1 is the shorter array
      for(int i = 0; i < d1 ; i++){
        if(data1[i] > data2[i]){ // i @ data 1 is bigger
          output[2*i] = data2[i];
          output[2*i + 1] = data1[i];
        }else{                  // i @ data 2 is bigger
          output[2*i] = data1[i];
          output[2*i + 1] = data2[i];
        }
      }
      for(int i = d1; i < d2; i++){
        output[2*i] = data2[i];
      }
    } else { // data 2 is the shorter array
      for(int i = 0; i < d1 ; i++){
        if(data1[i] > data2[i]){ // i @ data 1 is bigger
          output[2*i] = data2[i];
          output[2*i + 1] = data1[i];
        }else{                  // i @ data 2 is bigger
          output[2*i] = data1[i];
          output[2*i + 1] = data2[i];
        }
      }
      for(int i = d2; i < d1; i++){
        output[2*i] = data1[i];
      }
    }




    return output;

  }

}
