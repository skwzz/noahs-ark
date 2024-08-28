package kiwoong.programmers.lvl2;

import java.util.*;

public class 캐시 {
    public static void main(String[] args) {
        System.out.println(solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));	// 50
        System.out.println(solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"}));	// 21
        System.out.println(solution(2, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}));	// 60
        System.out.println(solution(5, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}));	// 52
        System.out.println(solution(2, new String[]{"Jeju", "Pangyo", "NewYork", "newyork"}));	// 16
        System.out.println(solution(0, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));	// 25
    }

    // 0 <= cacheSize <= 30
    // cities.length <= 100000
    static int solution(int cacheSize, String[] arr) {
        int answer = 0;
        ArrayList<String> list = new ArrayList<>();
        LinkedHashSet<String> lhs = new LinkedHashSet<>();

        for(int i=0; i<arr.length; i++){
            String city = arr[i].toLowerCase();
            // 캐시 교체 알고리즘은 LRU(Least Recently Used)를 사용한다. 캐시에서 지울 때 가장 오래동안 사용되지 않은 데이터 삭제
            if(lhs.contains(city)){ // cache hit : 캐시에서 가장 맨 뒤(최근에 사용됨)로 옮김
                answer++;
                for(int j=0; j<list.size(); j++){
                    if(city.equals(list.get(j))){
                        list.add(list.remove(j));
                    }
                }
            }else{ // cache miss
                answer+=5;
                if(cacheSize == 0) continue;

                if(list.size() == cacheSize){ // 캐시가 꽉찼음
                    lhs.remove(list.remove(0));
                }
                lhs.add(city);
                list.add(city);
            }
        }
        return answer;
    }
}
