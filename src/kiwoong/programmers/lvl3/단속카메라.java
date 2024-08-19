package kiwoong.programmers.lvl3;

import java.util.*;

public class 단속카메라 {
    public static void main(String[] args) {
        int[][] routes = {{-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}};
        System.out.println(solution(routes));
    }

    static int solution(int[][] routes) {
        int answer = 0;
        // 배열 정렬
        Arrays.sort(routes, (a, b) -> {
            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            } else {
                return Integer.compare(a[0], b[0]);
            }
        });

        int lastNum = 0;
        for(int j=0; j<routes.length; j++) {
            if(j==0){
                lastNum = routes[j][1];
                answer++;
            }else{
                if(routes[j][0] > lastNum){
                    lastNum = routes[j][1];
                    answer++;
                }
            }
        }
        return answer;
    }
}
