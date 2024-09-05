package kiwoong.programmers.lvl2;

import java.util.Arrays;
/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42885
 */
public class 구명보트 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{70, 50, 80, 50}, 100)); // 3
        System.out.println(solution(new int[]{70, 80, 50}, 100)); // 3
    }

    static int solution(int[] people, int limit) {
        int answer = 0;
        int left = 0;
        int right = people.length - 1;
        Arrays.sort(people);

        while(left<=right){
            int lv = people[left];
            int rv = people[right];

            if(lv+rv <= limit){
                left++;
            }
            right--;
            answer++;
        }
        return answer;
    }
}
