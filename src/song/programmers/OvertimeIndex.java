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

        while (n > 0) {
            if (workQueue.isEmpty()) return 0L;

            Integer work = workQueue.poll();
            if (work == 1) continue;

            workQueue.add(work - 1);
            n--;
        }

        return workQueue.stream()
                .mapToLong(i -> ((long) i)*((long) i))
                .sum();
    }
}
/**
 * 정확성  테스트
 * 테스트 1 〉	통과 (4.43ms, 69.8MB)
 * 테스트 2 〉	통과 (3.52ms, 79.6MB)
 * 테스트 3 〉	통과 (2.74ms, 79.2MB)
 * 테스트 4 〉	통과 (3.51ms, 77.2MB)
 * 테스트 5 〉	통과 (4.22ms, 84.5MB)
 * 테스트 6 〉	통과 (3.27ms, 79.9MB)
 * 테스트 7 〉	통과 (3.22ms, 67.4MB)
 * 테스트 8 〉	통과 (5.14ms, 84.4MB)
 * 테스트 9 〉	통과 (5.71ms, 86.9MB)
 * 테스트 10 〉	통과 (3.06ms, 77MB)
 * 테스트 11 〉	통과 (3.13ms, 73.5MB)
 * 테스트 12 〉	실패 (1.19ms, 77.9MB)
 * 테스트 13 〉	통과 (1.08ms, 73.9MB)
 * 효율성  테스트
 * 테스트 1 〉	통과 (131.45ms, 67.6MB)
 * 테스트 2 〉	통과 (118.74ms, 68.4MB)
 * 채점 결과
 * 정확성: 80.0
 * 효율성: 13.3
 * 합계: 93.3 / 100.0
 */
