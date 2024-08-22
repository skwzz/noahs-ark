package song.programmers;

import java.util.*;
import java.util.stream.Collectors;

/**
 * k진수에서 소수 개수 구하기
 * https://school.programmers.co.kr/learn/courses/30/lessons/92335
 */
public class PrimeCounterInKBase {
    public static void main(String[] args) {
        PrimeCounterInKBase p = new PrimeCounterInKBase();
        System.out.println(p.solution(437674, 3)); // 3
        System.out.println(p.solution(110011, 10)); // 2
    }

    public int solution(int n, int k) {
        // 진법 변환
        String kBase = convertToKBase(n, k);
        List<Integer> pList = Arrays.stream(kBase.split("0"))
                .filter(s -> !s.equals(""))
                .map(s -> Integer.valueOf(s))
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        // 변환된 수보다 작은 소수 Set 생성
        Set<Integer> primeSet = getPrimSet(pList.get(0));


        int answer = 0;
        for(Integer p : pList){
            if(primeSet.contains(p)) answer ++;
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

    private Set<Integer> getPrimSet(Integer maxNumber) {
        Set<Integer> primeSet = new HashSet<>();

        if (maxNumber == null || maxNumber < 2) {
            return primeSet;
        }

        boolean[] isPrime = new boolean[maxNumber + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= maxNumber; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= maxNumber; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        for (int i = 2; i <= maxNumber; i++) {
            if (isPrime[i]) {
                primeSet.add(i);
            }
        }

        return primeSet;
    }
}
/**
 * 정확성  테스트
 * 테스트 1 〉	실패 (런타임 에러)
 * 테스트 2 〉	통과 (10.99ms, 72.6MB)
 * 테스트 3 〉	통과 (3.81ms, 70.8MB)
 * 테스트 4 〉	통과 (3.27ms, 70.9MB)
 * 테스트 5 〉	통과 (3.37ms, 76MB)
 * 테스트 6 〉	통과 (3.90ms, 72.6MB)
 * 테스트 7 〉	통과 (8.61ms, 83.7MB)
 * 테스트 8 〉	통과 (2.48ms, 82.1MB)
 * 테스트 9 〉	통과 (3.36ms, 76.1MB)
 * 테스트 10 〉	통과 (3.54ms, 74.8MB)
 * 테스트 11 〉	실패 (런타임 에러)
 * 테스트 12 〉	통과 (3.51ms, 73.5MB)
 * 테스트 13 〉	통과 (3.36ms, 76.4MB)
 * 테스트 14 〉	통과 (2.88ms, 74.9MB)
 * 테스트 15 〉	통과 (2.49ms, 72.7MB)
 * 테스트 16 〉	통과 (3.28ms, 75.4MB)
 * 채점 결과
 * 정확성: 86.9
 * 합계: 86.9 / 100.0
 */