package kiwoong.programmers.lvl2;

import java.util.HashMap;
import java.util.Stack;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/76502">...</a>
 */
public class 괄호회전하기 {
    public static void main(String[] args) {
        String s1 = "[](){}";
        String s2 = "}]()[{";
        String s3 = "[)(]";
        String s4 = "}}}";
        System.out.println(solution(s1));
        System.out.println(solution(s2));
        System.out.println(solution(s3));
        System.out.println(solution(s4));
    }

    static int solution(String str){
        HashMap<String, String> hMap = new HashMap<>();
        hMap.put("]", "[");
        hMap.put("}", "{");
        hMap.put(")", "(");
        int answer = 0;
        String[] strArray = new String[str.length()];
        for (int i = 0; i < str.length(); i++) {
            strArray[i] = String.valueOf(str.charAt(i));
        }

        for(int startIdx = 0; startIdx<strArray.length; startIdx++){
            int idx = startIdx;
            Stack<String> stack = new Stack<>();
            int loopCount = strArray.length;

            while(loopCount > 0){
                if( "[".equals(strArray[idx]) ||
                    "{".equals(strArray[idx]) ||
                    "(".equals(strArray[idx])){
                    stack.push(strArray[idx]);
                }else{
                    if( stack.isEmpty() ||
                        !stack.peek().equals(hMap.get(strArray[idx]))){
                        break;
                    }else{
                        stack.pop();
                    }
                }
                idx++;
                if(idx >= strArray.length){
                    idx = 0;
                }
                loopCount--;
            }
            if(stack.isEmpty() && loopCount == 0){
                answer++;
            }
        }
        return answer;
    }
}
