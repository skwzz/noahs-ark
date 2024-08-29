package kiwoong.programmers.lvl2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/138476">...</a>
 */
public class 귤고르기 {
    public static void main(String[] args) {
        System.out.println(solution(6, new int[]{1, 3, 2, 5, 4, 5, 2, 3}));
        System.out.println(solution(4, new int[]{1, 3, 2, 5, 4, 5, 2, 3}));
        System.out.println(solution(2, new int[]{1, 1, 1, 1, 2, 2, 2, 3}));
    }

    static int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer, Integer> hmap = new HashMap<>();
        for(int n : tangerine){
            hmap.put(n, hmap.getOrDefault(n, 0)+1);
        }
        ArrayList<Map.Entry<Integer, Integer>> sortList = new ArrayList<>(hmap.entrySet());
        sortList.sort(Comparator.comparing(Map.Entry::getValue));

        int sumValue = 0;
        for(int i=sortList.size()-1; i>=0; i--){
            sumValue += sortList.get(i).getValue();
            answer++;
            if(sumValue >= k){
                break;
            }
        }

        return answer;
    }
}
