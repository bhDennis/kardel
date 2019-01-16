package algorithm.chapter2;

import java.util.Arrays;
import java.util.List;

/**
 * p.29  ~ p.31
 * Created by dennis on 2018/5/21.
 */
public class MaximumSubsequence {

    // 假设数组 【4，-3，5，-2，-1，2，6，2】，二分后的左边数组【4，-3，5，-2】，二分后右边数组【-1，2，6，2】


    // 算法1：三重for循环 O(N^3)
    public static int maxSubSumOne(int[] array) {

        int N = array.length;
        int max = 0;
        for (int i = 0; i < N; i++) {              // i.max = len - 1   [0,len-1]

            for (int j = i; j < N; j++) {          // j.max = len - 1    [i,len-1]

                int sum = 0;
                for (int k = i; k <= j; k++) {    // z.max = len - 1
                    sum = sum + array[k];
                }

                if (sum > max) {         // 开销是 O(N^2)
                    max = sum;
                }
            }
        }
        return max;
    }


    // 算法2：两层for循环 O(N^2)
    public static int maxSubSumTwo(int[] array) {

        int N = array.length;
        int max = 0;

        for (int i = 0; i < N; i++) {

            int sum = 0;

            for (int j = i; j < N; j++) {

                sum = sum + array[j];

                if (sum > max) {

                    max = sum;
                }
            }
        }
        return max;
    }


    // 算法3：递归二分求法  O(NlogN) 时间复杂度具体分析见 p.32
    public static int maxSubSumThree(int[] array) {

        return maxSumSec(array, 0, array.length - 1);
    }

    private static int maxSumSec(int[] array, int left, int right) {

        if (left == right) {
            if (array[left] > 0) {
                return array[left];
            } else {
                return 0;
            }
        }

        int centre = (left + right) / 2;
        int maxLeftSum = maxSumSec(array, left, centre);
        int maxRightSum = maxSumSec(array, (centre + 1), right);

        int maxLeftBorderSum = 0, leftBorderSum = 0;
        for (int i = centre; i >= left; i--) {    // 二分后左边数组含最后一个元素的最大值

            leftBorderSum = leftBorderSum + array[centre];

            if (leftBorderSum > maxLeftBorderSum) {
                maxLeftBorderSum = leftBorderSum;
            }
        }

        int maxRightBorderSum = 0, rightBorderSum = 0;
        for (int i = centre + 1; i <= right; i++) {   // 二分后右边数组含第一个元素的最大值

            rightBorderSum = rightBorderSum + array[i];
            if (rightBorderSum > maxRightBorderSum) {
                maxRightBorderSum = rightBorderSum;
            }
        }

        return compareThreeMax(maxLeftSum, maxRightSum, maxLeftBorderSum + maxRightBorderSum);
    }


    // 左边数组、右边数组，以及含左边数组最后一个元素和右边数组第一个元素之后最大值，求三者最大值
    private static int compareThreeMax(int maxLeftSum, int maxRightSum, int sum) {

        int max = maxLeftSum;
        List<Integer> sumList = Arrays.asList(maxLeftSum,maxRightSum,sum);
        for(int i=0;i<sumList.size();i++){
            if(max < sumList.get(i)){
                max = sumList.get(i);
            }
        }
        return max;
    }

    // 算法4：一个聪明的算法 解析见 p.32  复杂度 O(N)
    public static int maxSubSumFour(int[] array){

        int maxSum = 0, thisSum = 0;

        for(int j=0;j<array.length;j++){

            thisSum = thisSum + array[j];

            if(thisSum > maxSum){
                maxSum = thisSum;
            }else if(thisSum < 0){
                thisSum = 0;
            }
        }
        return maxSum;
    }
}
