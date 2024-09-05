package kiwoong.programmers.lvl2;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42747
 */
public class HIndex {
    public static void main(String[] args) {
        int[] arr = {3, 0, 6, 1, 5};
        //int[] arr = {0, 0, 0, 0, 0};
        System.out.println(solution(arr));
    }

    static int solution(int[] arr){
        int answer = 0;
        Arrays.sort(arr);
        int bookCount = 0;
        for(int i=0; i<arr.length; i++){
            bookCount = arr.length-(i);
            if(bookCount <= arr[i]){
                answer = bookCount;
                break;
            }
        }
        return answer;
    }
}
