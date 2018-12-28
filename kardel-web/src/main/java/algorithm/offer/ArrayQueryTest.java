package algorithm.offer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by dennis on 2018/7/18.
 */
public class ArrayQueryTest {

    public static boolean find(int target, int [][] array) {
        if(array.length <= 0)
            return false;
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array[i].length;j++){
                if(target == array[i][j]){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 矩阵从左至右，从上到下，数字依次是递增，那么可以判断右上角的数字是否大于target，如果大于则删除对应的列。
     * @param target
     * @param array
     * @return
     */
    public static boolean findOne(int target, int [][] array) {

        if(array.length <= 1)
            return false;

        int latestRow = array[0].length - 1;;
        for(int line=0;line<array.length;line++){
            if(array[line][latestRow] > target){
                latestRow --;
                line -- ;
                if(latestRow < 0)
                    return false;
                continue;
            }


            for(int m=0;m<latestRow+1;m++){
                if(target == array[line][m])
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args){

        int target = 5;
        int[][] array = new int[4][4];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in ));
        String read;
        String[] splitArray = null;
        try {
            read = br.readLine();
            splitArray = read.split(",");
        } catch (IOException e) {
            e.printStackTrace();
        }

        int m = 0;
        for(int i=0;i<4;i++){
            for (int j=0;j<4;j++){
                if(m == splitArray.length)
                    break;
                array[i][j] = Integer.parseInt(splitArray[m]);
                m++;
            }
        }
        boolean result = findOne(target,array);
        System.out.println(result);
    }
}
