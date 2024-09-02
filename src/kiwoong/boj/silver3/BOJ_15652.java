package kiwoong.boj.silver3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * N과 M (4)
 * <a href="https://www.acmicpc.net/problem/15652">...</a>
 */
public class BOJ_15652 {
    static StringBuilder answer = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[m];

        bt(0, 0, m, arr, n);
        System.out.println(answer);
    }

    static void bt(int start, int depth, int end, int[] arr, int n){
        if(depth == end){
            for(int num : arr){
                answer.append(num).append(" ");
            }
            answer.append("\n");
            return;
        }

        for(int i=start; i<n; i++){
            arr[depth] = i+1;
            bt(i, depth+1, end, arr, n);
        }
    }
}
