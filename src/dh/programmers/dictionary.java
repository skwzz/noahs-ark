package dh.programmers;

import java.util.Arrays;
import java.util.List;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/84512
 */
public class dictionary {
    public static void main(String[] args) {
        String word = "AAAAE"; // result = 6
        System.out.println("result = " + solution(word));

        word = "AAAE"; // result = 10
        System.out.println("result = " + solution(word));
    }

    static int solution(String word)
    {
        int result = 0;
        int[] gaps = {781, 156, 31, 6, 1};
        List<Character> characters = Arrays.asList('A', 'E', 'I', 'O', 'U');

        for(int i=0; i<word.length(); i++) {
            char w = word.charAt(i);
            int characterOrder = characters.indexOf(w);
            int wordOrder =  characterOrder * gaps[i] + 1;
            result += wordOrder;
         }
        return result;
    }
}
