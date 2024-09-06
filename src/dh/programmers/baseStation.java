package dh.programmers;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12979
 */
public class baseStation {
    public static void main(String[] args) {
        int n = 11;
        int[] stations = new int[]{4, 11};
        int w = 1;

        System.out.println("result = " + solution(n, stations, w)); //3

        n = 16;
        stations = new int[]{9};
        w = 2;
        System.out.println("result = " + solution(n, stations, w)); //3
    }

    static int solution(int n, int[] stations, int w) {
/*
        아파트의 개수 N
        현재 기지국이 설치된 아파트의 번호가 담긴 1차원 배열 stations
        전파의 도달 거리 W
*/
        int answer = 0; //증설해야 할 기지국 개수의 최솟값
        int lastCovered = 0;  // 마지막으로 전파가 닿은 아파트 번호

        for (int station : stations) {
            int start = station - w;  // 기지국의 전파 시작점
            int end = station + w;    // 기지국의 전파 끝점

            // 전파가 닿지 않는 구간이 있는 경우
            if (lastCovered + 1 < start) {
                // 전파가 닿지 않는 구간의 길이
                int gap = start - lastCovered - 1;
                // 전파가 닿지 않는 구간을 커버하기 위한 최소 기지국 개수 계산
                answer += calculated(gap, w);
            }

            // 전파가 닿은 마지막 아파트 번호 업데이트
            lastCovered = end;
        }

        // 마지막 기지국 이후로 남은 구간이 있을 경우
        if (lastCovered < n) {
            int remaining = n - lastCovered;
            answer += calculated(remaining, w);
        }

        return answer;
    }


    static int calculated(int gap, int w) {
        return gap / (w*2 + 1) + ((gap % (w*2 + 1) == 0) ? 0 : 1);
    }

}
