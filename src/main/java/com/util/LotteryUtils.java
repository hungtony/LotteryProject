package com.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class LotteryUtils {


    public static String generateNumbers(Integer openNumbers){

        Random random = new Random();

        Set<Integer> results = new HashSet<>();

        while (results.size()!=openNumbers){
            results.add(random.nextInt(38)+1);
        }

        return results.toString().replace("[","").replace("]","");
    }


    /***
     *  2nums+sp -> 8獎 $400
     *  3nums -> 7獎 $400
     *  3nums+sp -> 6獎 $1000
     *  4nums -> 5獎 $2000
     *  4nums+sp -> 4獎
     *  5nums -> 3獎
     *  5nums+sp -> 2獎
     *  6nums -> 1獎
     * */
    public static Integer checkLottery(String betNums, String drawNums){

        List<String> betList = new ArrayList<>(Arrays.asList(betNums.split(",")));
        List<String> drawList = new ArrayList<>(Arrays.asList(drawNums.split(",")));
        String specialNum = drawList.get(drawList.size()-1);
        drawList.remove(specialNum);


        Integer matchNums = (int)betList.stream().filter(b->drawList.contains(b)).count();
        Boolean hasSpecialNum = betList.contains(specialNum);


        switch (matchNums){

            case 2: if(hasSpecialNum){return 8;}
                    else return 99;
            case 3: if(hasSpecialNum){return 6;}
                    else return 7;
            case 4: if(hasSpecialNum){return 4;}
                    else return 5;
            case 5: if(hasSpecialNum){return 2;}
                    else return 3;
            case 6: return 1;

            default:return 99;
        }

    }
}
