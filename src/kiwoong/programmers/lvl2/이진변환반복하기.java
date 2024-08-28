package kiwoong.programmers.lvl2;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/70129
 */
public class 이진변환반복하기 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("110010101001")));
        System.out.println(Arrays.toString(solution("01110")));
        System.out.println(Arrays.toString(solution("1111111")));
    }

    static int[] solution(String s) {
        int[] answer = new int[2];
        StringBuilder sb = new StringBuilder(s);
        int zc = 0;
        int loopCount = 0;
        while(sb.length() > 1){
            loopCount++;
            for(int i=sb.length()-1; i>=0; i--){
                if(sb.charAt(i) == '0'){
                    zc++;
                    sb.delete(i,i+1);
                }
            }

            StringBuilder nextS = new StringBuilder();
            int len = sb.length();
            while(len > 0){
                nextS.insert(0, len%2);
                len /= 2;
            }
            sb = new StringBuilder(nextS);
        }

        answer[0] = loopCount;
        answer[1] = zc;
        return answer;
    }
}
