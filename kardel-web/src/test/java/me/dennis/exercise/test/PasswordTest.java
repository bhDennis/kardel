package me.dennis.exercise.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dennis on 2018/4/15.
 */
public class PasswordTest {

    // 前缀
    private static List<String> prePasswordLists = new ArrayList<>();

    // 中部
    private static List<String> middlePasswordListsOne = new ArrayList<>();
    private static List<String> middlePasswordListsTwo = new ArrayList<>();

    // 后缀
    private static List<String> suffixPasswordListsOne = new ArrayList<>();
    private static List<String> suffixPasswordListsTwo = new ArrayList<>();
    private static List<String> suffixPasswordListsThree = new ArrayList<>();


    static {

        // 前缀
        prePasswordLists.add("hsh");
        prePasswordLists.add("HSH");

        // 中部一
        middlePasswordListsOne.add("hzx");
        middlePasswordListsOne.add("HZX");
        middlePasswordListsOne.add("hzt");
        middlePasswordListsOne.add("HZT");
        middlePasswordListsOne.add("hxl");
        middlePasswordListsOne.add("HXL");

        // 中部二
        middlePasswordListsTwo.add("zjj");

        // 后缀一
        suffixPasswordListsOne.add("1991");
        suffixPasswordListsOne.add("1989");

        // 后缀二
        suffixPasswordListsTwo.add("03");
        suffixPasswordListsTwo.add("09");

        // 后缀三
        suffixPasswordListsThree.add("09");
        suffixPasswordListsThree.add("10");
    }
    public static void main(String[] args){

        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0;i<prePasswordLists.size();i++){

            stringBuilder.append(prePasswordLists.get(i));

            for(int j=0;j<middlePasswordListsOne.size();j++){

                stringBuilder.append(middlePasswordListsOne.get(i)).append(middlePasswordListsTwo.get(0));

                for(int x=0;x<middlePasswordListsTwo.size();x++){

                    stringBuilder.append(middlePasswordListsTwo.get(x));

                    for(int y=0;y<suffixPasswordListsOne.size();y++){
                        stringBuilder.append(suffixPasswordListsOne.get(y));


                        for(int z=0;y<suffixPasswordListsTwo.size();z++){
                            stringBuilder.append(suffixPasswordListsTwo.get(z));
                        }
                    }
                }
            }
        }
    }
}
