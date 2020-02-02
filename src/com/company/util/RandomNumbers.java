package com.company.util;

import java.util.Date;
import java.util.Random;

public class RandomNumbers {
//    public int threeDigitNumber1 = (int) (100 + Math.random()* 899);
//    public int threeDigitNumber2 = (int) (100 + Math.random()* 899);
//    public int threeDigitNumber3 = (int) (100 + Math.random()* 899);
//    public int twoDigitNumber1 = (int) (10 + Math.random()* 90);
//    public Date time = new Date();
//    public int session = (int) (100000000 +Math.random() * 899999999);
//    public String ip = threeDigitNumber1 + "." + threeDigitNumber2 + "." +  threeDigitNumber3 + "." + twoDigitNumber1;
//
     public static Integer getRandom(int min , int max){
         Random random = new Random();
         return min + random.nextInt(max - min);
     }
}
