package kiwoong.programmers.lvl3;

import java.util.Arrays;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/12979">...</a>
 */
public class 기지국설치 {
    public static void main(String[] args) {
        System.out.println(solution(11, new int[]{4, 11}, 1)); // 3
        System.out.println(solution(16, new int[]{9}, 2)); // 3
    }

    static int solution(int n, int[] stations, int w) {
        int answer = 0;
        int[] arr = new int[n+1];
        for(int i=0; i<stations.length; i++){
            int l = stations[i] - w;
            int r = stations[i] + w;
            for(int j=l; j<=r; j++){
                if(j <= 0 || j > n){
                    continue;
                }
                arr[j] = 1;
            }
        }
        //System.out.println(Arrays.toString(arr));
        for (int i=1; i<arr.length; i++) {
            if(arr[i] == 0){
                int j = i;
                while(j < arr.length && arr[j] == 0){
                    j++;
                }
                int range = j - i;
                int cnt = range / (2*w+1);
                if(range % (2*w+1) != 0){
                    cnt++;
                }
                answer += cnt;
                i = j;
            }
        }
        return answer;
    }
}
