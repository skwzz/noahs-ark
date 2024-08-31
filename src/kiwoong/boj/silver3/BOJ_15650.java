package kiwoong.boj.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * N과 M (2)
 * <a href="https://www.acmicpc.net/problem/15650">...</a>
 */
public class BOJ_15650 {
    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[m];
        visited = new boolean[n];

        bt(0, 0, m);
        System.out.println(sb);
    }

    static void bt(int start, int depth, int end){
        if(depth == end){
            for(int i=0; i<arr.length; i++){
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=start; i<visited.length; i++){
            if(!visited[i]){
                arr[depth] = i+1;
                visited[i] = true;
                bt(i+1, depth+1, end);
                visited[i] = false;
            }
        }
    }
}
