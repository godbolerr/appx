package com.series.numberseries.util;

import java.util.Map;

/**
 * Created by 115750 on 10/8/2016.
 */

public class TheMain {

    public static void main(String args[]){
        System.out.println("this is main class");
        Map<String,String> defMap = AppxUtil.loadDefinitions();
        if ( defMap != null ){
            System.out.println(defMap.size());
        }
    }
}
