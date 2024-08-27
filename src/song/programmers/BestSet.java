package song.programmers;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/12938">최고의 집합</a>
 */
public class BestSet {
    public static void main(String[] args) {
        BestSet p = new BestSet();
        int[] solution;

        solution = p.solution(2, 9);
        display(solution); // [4, 5]

        solution = p.solution(2, 1);
        display(solution); // [-1]

        solution = p.solution(2, 8);
        display(solution); // [4, 4]
    }

    private static void display(int[] solution) {
        for (int i : solution) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public int[] solution(int n, int s) {
        int minElement = s/n;
        if(minElement == 0) return new int[]{-1};

        int surplus = s%n;
        int[] answer = new int[n];
        for (int i = answer.length -1; i >= 0 ; i--) {
            if (surplus == 0){
                answer[i] = minElement;
            }else{
                answer[i] = minElement + 1;
                surplus--;
            }
        }
        return answer;
    }
}
/*
정확성  테스트
테스트 1 〉	통과 (0.07ms, 68.1MB)
테스트 2 〉	통과 (0.11ms, 78.2MB)
테스트 3 〉	통과 (0.10ms, 81MB)
테스트 4 〉	통과 (0.11ms, 79.9MB)
테스트 5 〉	통과 (0.04ms, 72.4MB)
테스트 6 〉	통과 (0.05ms, 74.8MB)
테스트 7 〉	통과 (0.02ms, 77MB)
테스트 8 〉	통과 (0.03ms, 78.1MB)
테스트 9 〉	통과 (0.07ms, 74.7MB)
테스트 10 〉	통과 (0.15ms, 68.5MB)
테스트 11 〉	통과 (0.16ms, 79.5MB)
테스트 12 〉	통과 (0.08ms, 76.1MB)
테스트 13 〉	통과 (0.11ms, 87MB)
테스트 14 〉	통과 (0.02ms, 78.9MB)
효율성  테스트
테스트 1 〉	통과 (0.18ms, 53.1MB)
테스트 2 〉	통과 (0.15ms, 53.1MB)
테스트 3 〉	통과 (0.17ms, 53.1MB)
테스트 4 〉	통과 (0.17ms, 54.1MB)
테스트 5 〉	통과 (0.29ms, 53.6MB)
테스트 6 〉	통과 (0.01ms, 52.5MB)
채점 결과
정확성: 70.0
효율성: 30.0
합계: 100.0 / 100.0
 */