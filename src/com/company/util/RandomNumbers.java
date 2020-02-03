package com.company.util;

import java.util.Date;
import java.util.Random;

public class RandomNumbers {
     public static Integer getRandom(int min , int max){
         Random random = new Random();
         return min + random.nextInt(max - min);
     }
}
