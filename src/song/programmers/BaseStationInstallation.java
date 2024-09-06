package song.programmers;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/12979">기지국 설치</a>
 *
 */
public class BaseStationInstallation {
    public static void main(String[] args) {
        BaseStationInstallation p = new BaseStationInstallation();
        System.out.println(p.solution(11, new int[]{4,11}, 1));
        System.out.println(p.solution(16, new int[]{9}, 2));
    }

    public int solution(int n, int[] stations, int w) {
        int expansionCnt =0;
        int tempPivot=1;
        int tempStation;
        int divde=(w*2+1);
        for (int station : stations) {
            tempStation = station;
            expansionCnt += Math.ceil(((double) (tempStation - w - tempPivot) / divde));
            tempPivot = (++tempStation) + w;
        }
        if(tempPivot<n+1){
            expansionCnt+=Math.ceil(((double)(n-tempPivot+1)/divde));
            return expansionCnt;
        }
        return expansionCnt;
    }
}
/*
정확성  테스트
테스트 1 〉	통과 (0.25ms, 73.1MB)
테스트 2 〉	통과 (0.26ms, 68.2MB)
테스트 3 〉	통과 (0.20ms, 75MB)
테스트 4 〉	통과 (0.37ms, 78MB)
테스트 5 〉	통과 (0.28ms, 73.9MB)
테스트 6 〉	통과 (0.23ms, 73.6MB)
테스트 7 〉	통과 (0.22ms, 77.6MB)
테스트 8 〉	통과 (0.32ms, 78.4MB)
테스트 9 〉	통과 (0.30ms, 74.1MB)
테스트 10 〉	통과 (0.27ms, 85.4MB)
테스트 11 〉	통과 (0.30ms, 73.4MB)
테스트 12 〉	통과 (0.23ms, 73.1MB)
테스트 13 〉	통과 (0.30ms, 78.8MB)
테스트 14 〉	통과 (0.23ms, 76.5MB)
테스트 15 〉	통과 (0.20ms, 73.8MB)
테스트 16 〉	통과 (0.31ms, 82MB)
테스트 17 〉	통과 (0.21ms, 76.3MB)
테스트 18 〉	통과 (0.29ms, 77.2MB)
테스트 19 〉	통과 (0.37ms, 72.8MB)
테스트 20 〉	통과 (0.21ms, 68.1MB)
테스트 21 〉	통과 (0.31ms, 70.5MB)
효율성  테스트
테스트 1 〉	통과 (2.02ms, 53MB)
테스트 2 〉	통과 (1.91ms, 52.9MB)
테스트 3 〉	통과 (1.51ms, 53.1MB)
테스트 4 〉	통과 (2.35ms, 52.6MB)
채점 결과
정확성: 70.5
효율성: 29.5
합계: 100.0 / 100.0
 */
