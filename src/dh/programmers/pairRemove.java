package dh.programmers;

import java.util.Stack;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12973?language=java
 */
public class pairRemove {
    public static void main(String[] args) {
        System.out.println("result = " + solution("baabaa"));
        System.out.println("result = " + solution("cdcd"));
    }

    // stack 사용
    static int solution(String s)
    {
        int i = 0;
        Stack<Character> stack = new Stack<>();

        while (i < s.length()) {
            char target = s.charAt(i);

            if(!stack.empty() && stack.peek() == target) {
                stack.pop();
            } else {
                stack.push(target);
            }

            i++;
        }

        return stack.empty() ? 1: 0;
    }
/*
    static int solution(String s)
    {
        int isLast = 0;
        int size = s.length() - 1;

        while(isLast == 0 && size > 0) {
            for(int i = 0; i < size; i++) {
                if(s.charAt(i) == s.charAt(i+1)) {
                    String value1 = s.substring(0, i);
                    String value2 = s.substring(i+2);

                    s = value1 + value2;
                    size = s.length()-1;
                    break;
                }

                if(i+2 == s.length()) {
                    isLast = 1;
                }
            }
        }

        return s.isEmpty() ? 1: 0;
    }
*/
}
