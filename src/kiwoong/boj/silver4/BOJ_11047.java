package kiwoong.boj.silver4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 동전 0
 * <a href="https://www.acmicpc.net/problem/11047">...</a>
 */
public class BOJ_11047 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        for(int i=0; i<arr.length; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int answer = 0;
        for(int i=arr.length-1; i>=0; i--){
            if(k == 0) break;
            int a = arr[i];
            if(k/a >= 1) {
                answer += k/a;
                k = k%a;
            }
        }
        System.out.println(answer);
    }
}
