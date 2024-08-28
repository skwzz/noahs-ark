package song.programmers;

import java.util.Stack;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/12973">짝지어 제거하기</a>
 */
public class PairRemover2 {
    public static void main(String[] args) {
        PairRemover2 remover = new PairRemover2();

        System.out.println(remover.solution("baabaa")); //1
        System.out.println(remover.solution("cdcd")); //0

    }

    public int solution(String s) {
        Stack<Character> unpairedCharStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            if(isNotPair(unpairedCharStack, sChar)){
                unpairedCharStack.push(sChar);
                continue;
            }
            unpairedCharStack.pop();
        }
        return unpairedCharStack.isEmpty() ? 1 : 0;
    }

    private boolean isNotPair(Stack<Character> stack, char sChar) {
        return stack.isEmpty() || stack.peek() != sChar;
    }
}
/*
  정확성  테스트
  테스트 1 〉	통과 (0.21ms, 69MB)
  테스트 2 〉	통과 (14.30ms, 83.1MB)
  테스트 3 〉	통과 (18.80ms, 80.4MB)
  테스트 4 〉	통과 (14.27ms, 74.5MB)
  테스트 5 〉	통과 (12.81ms, 82.2MB)
  테스트 6 〉	통과 (16.37ms, 79.8MB)
  테스트 7 〉	통과 (14.04ms, 87.4MB)
  테스트 8 〉	통과 (13.94ms, 84.2MB)
  테스트 9 〉	통과 (0.18ms, 73.5MB)
  테스트 10 〉	통과 (0.30ms, 80.6MB)
  테스트 11 〉	통과 (0.20ms, 78.9MB)
  테스트 12 〉	통과 (0.29ms, 86MB)
  테스트 13 〉	통과 (1.91ms, 72.6MB)
  테스트 14 〉	통과 (0.29ms, 74.1MB)
  테스트 15 〉	통과 (0.19ms, 73.8MB)
  테스트 16 〉	통과 (0.27ms, 65.7MB)
  테스트 17 〉	통과 (0.20ms, 73.7MB)
  테스트 18 〉	통과 (0.32ms, 79.3MB)
  효율성  테스트
  테스트 1 〉	통과 (61.89ms, 61.4MB)
  테스트 2 〉	통과 (41.13ms, 56MB)
  테스트 3 〉	통과 (46.09ms, 58.3MB)
  테스트 4 〉	통과 (44.76ms, 58.6MB)
  테스트 5 〉	통과 (47.54ms, 58.7MB)
  테스트 6 〉	통과 (45.60ms, 58.6MB)
  테스트 7 〉	통과 (53.93ms, 59.1MB)
  테스트 8 〉	통과 (44.75ms, 58.9MB)
  채점 결과
  정확성: 61.2
  효율성: 38.8
  합계: 100.0 / 100.0
 */
