package song.programmers;

/**
 * 짝지어 제거하기
 * https://school.programmers.co.kr/learn/courses/30/lessons/12973
 */
public class PairRemover {
    public static void main(String[] args) {
        PairRemover remover = new PairRemover();

        System.out.println(remover.solution("baabaa")); //1
        System.out.println(remover.solution("cdcd")); //0

    }

    public int solution(String s) {
        int oldStrLength = s.length();
        while (true){
            if(s.length() == 0) return 1;
            for (int i = 0; i < s.length()-1; i++) {
                if(s.charAt(i) == s.charAt(i+1)){
                    s = s.substring(0, i) + s.substring(i + 2);
                }
            }

            if (oldStrLength == s.length()){
                break;
            }
            oldStrLength = s.length();
        }
        return 0;
    }
}
/**
 * 정확성  테스트
 * 테스트 1 〉	통과 (1.54ms, 72.2MB)
 * 테스트 2 〉	통과 (1037.21ms, 400MB)
 * 테스트 3 〉	통과 (5784.84ms, 382MB)
 * 테스트 4 〉	통과 (6320.57ms, 389MB)
 * 테스트 5 〉	통과 (6942.06ms, 375MB)
 * 테스트 6 〉	통과 (5863.19ms, 380MB)
 * 테스트 7 〉	통과 (5855.72ms, 387MB)
 * 테스트 8 〉	통과 (6111.81ms, 396MB)
 * 테스트 9 〉	통과 (0.01ms, 72.1MB)
 * 테스트 10 〉	통과 (1.90ms, 67.2MB)
 * 테스트 11 〉	통과 (1.54ms, 74.3MB)
 * 테스트 12 〉	통과 (1.42ms, 75.8MB)
 * 테스트 13 〉	통과 (1.37ms, 76.4MB)
 * 테스트 14 〉	통과 (0.03ms, 65.9MB)
 * 테스트 15 〉	통과 (0.02ms, 76.2MB)
 * 테스트 16 〉	통과 (1.49ms, 72.4MB)
 * 테스트 17 〉	통과 (1.17ms, 77.2MB)
 * 테스트 18 〉	통과 (1.44ms, 76.5MB)
 * 효율성  테스트
 * 테스트 1 〉	실패 (시간 초과)
 * 테스트 2 〉	실패 (시간 초과)
 * 테스트 3 〉	실패 (시간 초과)
 * 테스트 4 〉	실패 (시간 초과)
 * 테스트 5 〉	실패 (시간 초과)
 * 테스트 6 〉	실패 (시간 초과)
 * 테스트 7 〉	실패 (시간 초과)
 * 테스트 8 〉	실패 (시간 초과)
 * 채점 결과
 * 정확성: 61.2
 * 효율성: 0.0
 * 합계: 61.2 / 100.0
 */
