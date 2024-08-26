package song.programmers;

import java.util.*;
import java.util.stream.Collectors;

/**
 * k진수에서 소수 개수 구하기
 * https://school.programmers.co.kr/learn/courses/30/lessons/92335
 */
public class PrimeCounterInKBase2 {
    public static void main(String[] args) {
        PrimeCounterInKBase2 p = new PrimeCounterInKBase2();
        System.out.println(p.solution(437674, 3)); // 3
        System.out.println(p.solution(110011, 10)); // 2
    }

    public int solution(int n, int k) {
        // 진법 변환
        String kBase = convertToKBase(n, k);
        List<String> pList = Arrays.stream(kBase.split("0"))
                .filter(s -> !s.equals("")).toList();


        int answer = 0;
        for(String p : pList){
            if(isPrime(Long.valueOf(p))){
                answer ++;
            }
        }
        return answer;
    }

    private String convertToKBase(int n, int k) {
        StringBuilder kBaseNumber = new StringBuilder();
        while (n > 0) {
            int remainder = n % k;
            kBaseNumber.append(remainder);
            n /= k;
        }
        return kBaseNumber.reverse().toString();
    }

    public boolean isPrime(Long n) {
        if (n < 2)  return false;
        if (n == 2) return true;

        int sqrt = (int) Math.sqrt(n);
        for (int i = 2; i <= sqrt; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

}
/**
 *정확성  테스트
 * 테스트 1 〉	통과 (13.83ms, 77.1MB)
 * 테스트 2 〉	통과 (2.79ms, 75.7MB)
 * 테스트 3 〉	통과 (1.62ms, 65.5MB)
 * 테스트 4 〉	통과 (1.26ms, 74MB)
 * 테스트 5 〉	통과 (1.70ms, 78.9MB)
 * 테스트 6 〉	통과 (1.51ms, 79.1MB)
 * 테스트 7 〉	통과 (2.19ms, 81.5MB)
 * 테스트 8 〉	통과 (1.36ms, 74.9MB)
 * 테스트 9 〉	통과 (1.74ms, 73.7MB)
 * 테스트 10 〉	통과 (1.68ms, 75.4MB)
 * 테스트 11 〉	통과 (2.07ms, 78.2MB)
 * 테스트 12 〉	통과 (1.91ms, 76.9MB)
 * 테스트 13 〉	통과 (5.70ms, 73.2MB)
 * 테스트 14 〉	통과 (1.38ms, 76.8MB)
 * 테스트 15 〉	통과 (1.83ms, 76.4MB)
 * 테스트 16 〉	통과 (1.37ms, 77.7MB)
 * 채점 결과
 * 정확성: 100.0
 * 합계: 100.0 / 100.0
 */