package song.programmers;

/**
 * 이진 변환 반복하기
 * https://school.programmers.co.kr/learn/courses/30/lessons/70129
 */
public class BinaryConversionRepeater {
    public static void main(String[] args) {
        BinaryConversionRepeater repeater = new BinaryConversionRepeater();

        // "110010101001" > 	[3, 8]
        int[] solution1 = repeater.solution("110010101001");
        display(solution1);


        // "01110" > 	[3, 3]


        // "1111111" > [4, 1]

    }

    private static void display(int[] solution) {
        for (int i = 0; i < solution.length; i++) {
            System.out.print(solution[i] + " ");
        }
        System.out.println();
    }

    public int[] solution(String s) {
        int loopCount = 0;
        int zeroCount = 0;
        while (true){
            if (s.length() == 1) break;
            int currentZeroCount = 0;
            for (int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == '0'){
                    currentZeroCount++;
                }
            }
            zeroCount+=currentZeroCount;
            s = Integer.toBinaryString(s.length() - currentZeroCount);
            loopCount++;
        }
        return new int[]{loopCount, zeroCount};
    }
}
