package com.util;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class LotteryUtils {


    public static String generateNumbers(){

        Random random = new Random();

        Set<Integer> results = new HashSet<>();

        while (results.size()!=7){
            results.add(random.nextInt(49)+1);
        }

        return results.toString().replace("[","").replace("]","");
    }

}
