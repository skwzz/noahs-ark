package kiwoong.programmers.lvl2;

import java.util.Stack;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/12973">...</a>
 */
public class 짝지어제거하기 {
    public static void main(String[] args) {
        // 문자열 최대 길이 : 1000000
        System.out.println(solution("baabaa"));
        System.out.println(solution("cdcd"));
    }

    static int solution(String s){
        StringBuilder sb = new StringBuilder(s);
        if(sb.length() < 2){
            return 0;
        }

        Stack<Character> stack = new Stack<>();
        for(int i=0; i<sb.length(); i++){
            char c = sb.charAt(i);
            if(stack.isEmpty() || stack.peek() != c){
                stack.push(sb.charAt(i));
            }else{
                stack.pop();
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }
}
