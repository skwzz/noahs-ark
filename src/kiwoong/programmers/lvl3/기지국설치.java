package kiwoong.programmers.lvl3;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/12979">...</a>
 */
public class 기지국설치 {
    public static void main(String[] args) {
        System.out.println(solution(11, new int[]{4, 11}, 1)); // 3
        System.out.println(solution(16, new int[]{9}, 2)); // 3
        System.out.println(solution(10, new int[]{1}, 1));
        System.out.println(solution(10, new int[]{10}, 1));
        System.out.println(solution(10, new int[]{1, 2, 3, 4, 5, 6 ,7 ,8 ,9 ,10}, 1));
        System.out.println(solution(10, new int[]{1, 2, 3, 4, 5, 6 ,7 ,8 ,9 ,10}, 100));
        System.out.println(solution(10, new int[]{5}, 5));
        System.out.println(solution(10, new int[]{5}, 4));
    }

    static int solution(int n, int[] stations, int w) {
        int answer = 0;
        int quotient = w*2+1;
        int pointer = 1;
        for(int i=0; i<stations.length; i++){
            int num = stations[i];
            int left = num - w;
            int right = num + w;

            if(left>pointer){
                int base = left-pointer;
                answer += base/quotient;
                answer += (base%quotient > 0) ? 1 : 0;
            }
            pointer = right + 1;
            if(pointer > n){
                break;
            }
            if(i==stations.length-1 && pointer <= n){
                int base = n - right;
                answer += base/quotient;
                answer += (base%quotient > 0) ? 1 : 0;
            }
        }
        return answer;
    }
}
