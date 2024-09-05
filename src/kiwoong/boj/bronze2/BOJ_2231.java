package kiwoong.boj.bronze2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 분해합
 * <a href="https://www.acmicpc.net/problem/2231">...</a>
 */
public class BOJ_2231 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int answer = Integer.MAX_VALUE;
        for(int i=1; i<=n; i++){
            if(n == proc(i)){
                answer = i;
                break;
            }
        }
        System.out.println(answer==Integer.MAX_VALUE ? 0 : answer);

    }

    static int proc(int num){
        int procSum = num;
        while(num>0){
            procSum += num%10;
            num/=10;
        }
        return procSum;
    }
}
