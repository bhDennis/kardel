package algorithm.chapter1;

public class KMaxInNOneTest {


// 参考链接 https://www.cnblogs.com/chengxiao/p/6103002.html
//    4 3 2 1 5  - 比较 4次
//
//    3 2 1 4 5  - 比较 3次
//
//    2 1 3 4 5  - 比较 2次
//
//    1 2 3 4 5  - 比较 1次

      public static void main(String[] args){


          int swapCount = 0 ;
          int[] N_ARRAY = new int[]{5,4,3,2,1};

          for(int i = 0;i< N_ARRAY.length - 1;i++){

              System.out.println("--第"+(i+1)+"轮冒泡开始--");

              for (int j = 0; j<N_ARRAY.length-1-i;j++){

                  if(N_ARRAY[j] > N_ARRAY[j+1]){
                      int swap = N_ARRAY[j];
                      N_ARRAY[j] =  N_ARRAY[j+1];
                      N_ARRAY[j+1] = swap;
                      swapCount++;
                  }
              }
              System.out.println("--第"+(i+1)+"轮冒泡结束--");
          }
          System.out.println("--冒泡完成,结果如下--");
          for(int m=0;m<N_ARRAY.length;m++){
              System.out.println(N_ARRAY[m]);
          }
          System.out.println("--冒泡完成,总交换次数--"+swapCount);
      }
}

// 初始 【5,4,3,2,1】
// i= 0  共交换4次
//j = 0    4 5 3 2 1   --- 4 5
//j = 1    4 3 5 2 1   --- 4 3 5
//j = 2    4 3 2 5 1   --- 4 3 2 5
//j = 3    4 3 2 1 5   --- 4 3 2 1 5

// i= 1 共交换3次
//j = 0    3 4 2 1 5
//j = 1    3 2 4 1 5
//j = 2    3 2 1 4 5

// i= 2 共交换2次
//j = 0    2 3 1 4 5
//j = 1    2 1 3 4 5

// i= 3 共交换1次
//j = 0    1 2 3 4 5