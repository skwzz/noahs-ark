package kiwoong.programmers.lvl2;

import java.util.Arrays;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/77885">...</a>
 */
public class 두개이하로다른비트 {
    public static void main(String[] args) {
        long[] numbers = {2, 7}; // [3, 11]
        long[] result = solution(numbers);
        System.out.println(Arrays.toString(result));
    }

    static long[] solution(long[] numbers){
        long[] answer = new long[numbers.length];
        for(int z=0; z<numbers.length; z++){
            int[] ba = bitArr(numbers[z]);

            int pointer = ba.length-1;
            while(0 <= pointer){
                if(ba[pointer] == 0){
                    ba[pointer] = 1;
                    break;
                }
                pointer--;
            }
            pointer++;
            while(pointer < ba.length){
                if(ba[pointer] == 1){
                    ba[pointer] = 0;
                    break;
                }
                pointer++;
            }
            long sum = 0L;
            for(int i =0; i<ba.length; i++){
                if(ba[i] == 1){
                    sum += (long) Math.pow(2, ba.length-1-i);
                }
            }
            answer[z] = sum;
        }
        return answer;
    }

    static int[] bitArr(long n){
        StringBuilder sb = new StringBuilder();
        while(n>0){
            int a = (int) (n%2);
            sb.insert(0, a);
            n = n/2;
        }
        sb.insert(0, 0);

        int[] result = new int[sb.length()];
        for (int i = 0; i < sb.length(); i++) {
            result[i] = Character.getNumericValue(sb.charAt(i));
        }
        return result;
    }
}
