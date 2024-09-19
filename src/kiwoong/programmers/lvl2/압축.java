package kiwoong.programmers.lvl2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/17684">...</a>
 */
public class 압축 {
    static HashMap<String, Integer> dictionary = new HashMap<>();
    public static void main(String[] args) {
        //System.out.println(Arrays.toString(solution("KAKAO"))); // [11, 1, 27, 15]
        System.out.println(Arrays.toString(solution("TOBEORNOTTOBEORTOBEORNOT"))); // [20, 15, 2, 5, 15, 18, 14, 15, 20, 27, 29, 31, 36, 30, 32, 34]
        //System.out.println(Arrays.toString(solution("ABABABABABABABAB"))); // [1, 2, 27, 29, 28, 31, 30]
    }

    static int[] solution(String msg) {
        int[] answer = {};
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            char key = (char) ('A' + i); // A부터 Z까지 문자 생성
            int value = i + 1; // 1부터 26까지 숫자 생성
            dictionary.put(String.valueOf(key), value);
        }

        int front = 0;
        int back = 1;
        boolean breakPoint = false;
        // 종료조건 back이 맨 뒤면서 사전에 등록되어 있는 경우
        // back == msg.length() && exist dictionary(msg.substring(?, back))

        while(true){
            while(dictionary.containsKey(msg.substring(front, back))){
                if(back == msg.length()){
                    breakPoint = true;
                    break;
                }
                back++;
            }
            if(breakPoint){
                list.add(dictionary.get(msg.substring(front, back)));
                break;
            }
            dictionary.put(msg.substring(front, back), dictionary.size()+1);
            list.add(dictionary.get(msg.substring(front, back-1)));
            front = back - 1;
        }

        // 마지막꺼 처리
        answer = new int[list.size()];
        for(int i=0; i<answer.length; i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}
