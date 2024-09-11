package kiwoong.programmers.lvl2;

import java.util.Stack;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/17687
 */
public class N진수게임 {
    public static void main(String[] args) {
        System.out.println(solution(2, 4, 2, 1)); // "0111"
        System.out.println(solution(16, 16, 2, 1)); // "02468ACE11111111"
        System.out.println(solution(16, 16, 2, 2)); // "13579BDF01234567"ㄴ
    }

    static String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();
        // N진수 변환기
        // break point : answer.length() == t
        Stack<String> s = new Stack<>();
        int cur = 0;
        int idx = 1;
        while(answer.length() != t){
            if(s.isEmpty()){
                s = convertor(n, cur++);
            }
            String temp = s.pop();
            if(idx == p){
                answer.append(temp);
            }
            idx++;
            if(idx > m){
                idx = 1;
            }
        }
        return answer.toString();
    }

    static Stack<String> convertor(int n, int num){
        Stack<String> s = new Stack<>();
        if(num == 0){
            s.add("0");
            return s;
        }

        while(num != 0){
            int k = num % n;
            if(k == 10){
                s.add("A");
            }else if(k == 11){
                s.add("B");
            }else if(k == 12){
                s.add("C");
            }else if(k == 13){
                s.add("D");
            }else if(k == 14){
                s.add("E");
            }else if(k == 15){
                s.add("F");
            }else{
                s.add(String.valueOf(k));
            }
            num /= n;
        }
        return s;
    }
}
