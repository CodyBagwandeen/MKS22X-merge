import java.io.*;
import java.util.*;

public class Merge{
  public static void main(String[] args){
    Random random = new Random(1);
          System.out.println("Size\t\tMax Value\tquick/builtin ratio ");
          int[]MAX_LIST = {1000000000,500,10};
          for(int MAX : MAX_LIST){
              for(int size = 31250; size < 2000001; size*=2){
                  long qtime=0;
                  long btime=0;
                  //average of 5 sorts.
                  for(int trial = 0 ; trial <=5; trial++){
                      int []data1 = new int[size];
                      int []data2 = new int[size];
                      for(int i = 0; i < data1.length; i++){
                          data1[i] = (int)(random.nextDouble()*MAX);
                          data2[i] = data1[i];
                      }
                      long t1,t2;
                      t1 = System.currentTimeMillis();
                      Merge.mergesort(data2);
                      t2 = System.currentTimeMillis();
                      qtime += t2 - t1;
                      t1 = System.currentTimeMillis();
                      Arrays.sort(data1);
                      t2 = System.currentTimeMillis();
                      btime+= t2 - t1;
                      if(!Arrays.equals(data1,data2)){
                          System.out.println("FAIL TO SORT!");
                          System.exit(0);
                      }
                  }
                  System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime);
              }
              System.out.println();
          }
  }

  public static void mergesort(int[] data){
    mergesortH(data, 0, data.length-1);
  }

  public static void mergesortH(int[] data, int lo, int hi) {
    if(lo >= hi){
      return;
    }

    if(hi - lo < 47) {
        insertionsort(data,0,data.length-1);
        return;
      }

      int mid = data.length/2;
      int[] left = new int[data.length/2];
      int[] right = new int[data.length - data.length/2];

      for(int i=0; i<data.length; i++) {
        if(i < left.length) {
            left[i] = data[i];
          } else {
            right[i-left.length] = data[i];
          }
        }

        mergesortH(left,0,left.length-1);
        mergesortH(right,left.length,data.length-1);
        merge(data,left,right);
      }

    public static void merge(int[] data, int[] left, int[] right) {
      int Index1, Index2;
      Index1 = Index2 = 0;
      for(int i=0; i<data.length; i++) {
          if(Index1 >= left.length) {
              data[i] = right[Index2];
              Index2 += 1;
            } else if(Index2 >= right.length) {
              data[i] = left[Index1];
              Index1 += 1;
            } else {
              if(left[Index1] < right[Index2]) {
                  data[i] = left[Index1];
                  Index1 += 1;
                } else {
                  data[i] = right[Index2];
                  Index2 += 1;

                }
              }

            }
        }

  public static void insertionsort(int[] data, int lo, int hi){
    int temp = 0;
    int temp2 =0;
    for(int i = lo +1; i < hi + 1; i++){
      temp = data[i];
      for(temp2 = i-1; temp2 >= 0 && data[temp2] > temp; temp2--){
        data[temp2+1] = data[temp2];
      }
      data[temp2+1] = temp;
    }

  }

}
