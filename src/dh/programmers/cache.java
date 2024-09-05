package dh.programmers;

import java.util.ArrayList;
import java.util.List;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/17680?language=java
 */
public class cache {
    public static void main(String[] args) {
        int cacheSize = 3;
        String[] cities = new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        System.out.println("result = " + solution(cacheSize, cities));

        cacheSize = 2;
        cities = new String[]{"Jeju", "Pangyo", "NewYork", "newyork"};
        System.out.println("result = " + solution(cacheSize, cities));

        cacheSize = 5;
        cities = new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
        System.out.println("result = " + solution(cacheSize, cities));

        cacheSize = 0;
        cities = new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        System.out.println("result = " + solution(cacheSize, cities));
    }

    static int solution(int cacheSize, String[] cities)
    {
        List<String> cacheList = new ArrayList<>();
        int resultTime = 0;

        int hitTime = 1;
        int missTime = 5;

        if(cacheSize == 0) {
            resultTime = cities.length * missTime;
            return resultTime;
        }

        for(String city : cities) {
            city = city.toLowerCase();
            if(cacheList.contains(city)){
                cacheList.remove(city);
                cacheList.add(city);
                resultTime += hitTime;
            } else {
                if(cacheList.size() >= cacheSize) {
                    cacheList.remove(0);
                }
                cacheList.add(city);
                resultTime += missTime;
            }
        }

        return resultTime;
    }
}
