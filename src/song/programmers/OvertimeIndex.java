package song.programmers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 야근 지수
 * https://school.programmers.co.kr/learn/courses/30/lessons/12927
 */
public class OvertimeIndex {

    public static void main(String[] args) {
        OvertimeIndex p = new OvertimeIndex();
        System.out.println(p.solution(4, new int[]{4, 3, 3})); // 12

        System.out.println(p.solution(1, new int[]{2, 1, 2})); // 6

        System.out.println(p.solution(3, new int[]{1, 1})); // 0
    }

    public long solution(int n, int[] works) {
        Queue<Integer> workQueue = new PriorityQueue(Comparator.reverseOrder());
        Arrays.stream(works).forEach(workQueue::add);

        while (n-- > 0) {
            if (workQueue.isEmpty()) return 0L;

            Integer work = workQueue.poll();
            if (work == 1) continue;

            workQueue.add(work - 1);
        }

        return workQueue.stream()
                .mapToLong(i -> ((long) i)*((long) i))
                .sum();
    }
}
/**
 * 정확성  테스트
 * 테스트 1 〉	통과 (5.27ms, 77.3MB)
 * 테스트 2 〉	통과 (2.82ms, 78.8MB)
 * 테스트 3 〉	통과 (7.16ms, 78.1MB)
 * 테스트 4 〉	통과 (6.17ms, 78.3MB)
 * 테스트 5 〉	통과 (4.02ms, 82.8MB)
 * 테스트 6 〉	통과 (3.03ms, 77.5MB)
 * 테스트 7 〉	통과 (3.36ms, 76.7MB)
 * 테스트 8 〉	통과 (5.96ms, 87.2MB)
 * 테스트 9 〉	통과 (5.33ms, 72.9MB)
 * 테스트 10 〉	통과 (3.39ms, 79.6MB)
 * 테스트 11 〉	통과 (4.57ms, 78.4MB)
 * 테스트 12 〉	통과 (5.07ms, 76.3MB)
 * 테스트 13 〉	통과 (1.25ms, 74MB)
 * 효율성  테스트
 * 테스트 1 〉	통과 (141.65ms, 67.8MB)
 * 테스트 2 〉	통과 (219.37ms, 76.3MB)
 * 채점 결과
 * 정확성: 86.7
 * 효율성: 13.3
 * 합계: 100.0 / 100.0
 */
