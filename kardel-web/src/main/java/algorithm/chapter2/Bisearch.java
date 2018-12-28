package algorithm.chapter2;

/**
 * 折半查找：给定一个整数X，以及一个整数序列A0，A1，A2，...，A(n-1)，A(n)，该
 * 序列已经预先排好序，且在内存中，请下标i使得A(i) = X，如果不在则返回-1。
 *
 * 适用场景：数据是稳定的（即不允许插入和删除）的应用中，这种操作很有用，
 *
 * p.34
 *
 * Created by dennis on 2018/5/27.
 */
public class Bisearch {

    public static int binarySearch(Integer[] array,Integer x){

        int low = 0,high = array.length - 1;

        while (low <= high){

            int mid = (low + high)/2;

            if(array[mid].compareTo(x) < 0){
                low = mid + 1;
            }else if(array[mid].compareTo(x) > 0){
                high = mid - 1;
            }else {
                return mid;
            }
        }
        return  - 1;
    }
}
