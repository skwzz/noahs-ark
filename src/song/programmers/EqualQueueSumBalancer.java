package song.programmers;

import java.util.stream.IntStream;

/**
 * 두 큐 합 같게 만들기
 * https://school.programmers.co.kr/learn/courses/30/lessons/118667
 */
public class EqualQueueSumBalancer {
    public static void main(String[] args) {
        EqualQueueSumBalancer balancer = new EqualQueueSumBalancer();
        // 	[3, 2, 7, 2], [4, 6, 5, 1] -> 2
        System.out.println(balancer.solution(new int[]{3, 2, 7, 2}, new int[]{4, 6, 5, 1}));
        System.out.println();

        // [1, 2, 1, 2], [1, 10, 1, 2] -> 7
        System.out.println(balancer.solution(new int[]{1, 2, 1, 2}, new int[]{1, 10, 1, 2}));
        System.out.println();

        // 	[1, 1], [1, 5] -> -1
        System.out.println(balancer.solution(new int[]{1, 1}, new int[]{1, 5}));
        System.out.println();

    }

    public int solution(int[] queue1, int[] queue2) {
        long minOperationCount = Long.MAX_VALUE;
        long totalSum = (long) IntStream.of(queue1).sum() + IntStream.of(queue2).sum();
        if (totalSum % 2 != 0) return -1;
        long targetNumber = totalSum / 2;

        int[] extendedQueue = makeExtendedQueue(queue1, queue2);
        for (int i = 0; i < queue1.length + queue2.length; i++) {
            long sum = 0;
            int j = i;
            while (true){
                sum += extendedQueue[j];
                if (sum == targetNumber){
                    long operationCount = calculateOperationCount(i,j, queue1.length, queue2.length);
                    if(minOperationCount > operationCount){
                        minOperationCount = operationCount;
                    }
                    break;
                }
                j++;

                if(sum > targetNumber || j == queue1.length + queue2.length) {
                    break;
                }
            }
        }

        if(minOperationCount == Long.MAX_VALUE){
          minOperationCount = -1;
        }
        return (int) minOperationCount;
    }

    // j > i
    private long calculateOperationCount(int i, int j, int queue1Length, int queue2Length) {
        System.out.println("calculateOperationCount " + i + ", " + j);
        if(j < queue1Length -1){
            return (j + 1) + (queue2Length + i);
        }else if (j == queue1Length - 1){
            return i;
        }else if (i < queue1Length){
            return i + (j - queue1Length + 1);
        }else if (j < queue1Length + queue2Length - 1){
            return (j - queue1Length + 1) + queue1Length + (i-queue1Length);
        }
        return i - queue1Length + 1;
    }

    private int[] makeExtendedQueue(int[] queue1, int[] queue2){
        int queueLengthSum = queue1.length + queue2.length;
        int[] extendedQueue = new int[queueLengthSum];
        for (int i = 0; i < queueLengthSum; i++) {
            if(i < queue1.length){
                extendedQueue[i] = queue1[i];
            }else {
                extendedQueue[i] = queue2[i - queue1.length];
            }
        }
        return extendedQueue;
    }
}
/**
 * 정확성  테스트
 * 테스트 1 〉	통과 (12.08ms, 96MB)
 * 테스트 2 〉	통과 (11.66ms, 79.5MB)
 * 테스트 3 〉	통과 (10.73ms, 77.1MB)
 * 테스트 4 〉	통과 (13.63ms, 76.4MB)
 * 테스트 5 〉	통과 (9.14ms, 76MB)
 * 테스트 6 〉	통과 (8.63ms, 77.7MB)
 * 테스트 7 〉	통과 (11.09ms, 79.2MB)
 * 테스트 8 〉	통과 (15.70ms, 82.9MB)
 * 테스트 9 〉	통과 (23.11ms, 68MB)
 * 테스트 10 〉	통과 (37.24ms, 86.6MB)
 * 테스트 11 〉	통과 (2768.84ms, 90.1MB) = -1
 * 테스트 12 〉	통과 (3680.34ms, 101MB)
 * 테스트 13 〉	통과 (7183.78ms, 96.6MB)
 * 테스트 14 〉	통과 (9400.20ms, 101MB)
 * 테스트 15 〉	실패 (시간 초과)
 * 테스트 16 〉	실패 (시간 초과)
 * 테스트 17 〉	실패 (시간 초과)
 * 테스트 18 〉	실패 (시간 초과)
 * 테스트 19 〉	실패 (시간 초과)
 * 테스트 20 〉	실패 (35.89ms, 135MB)
 * 테스트 21 〉	실패 (22.72ms, 143MB)
 * 테스트 22 〉	실패 (9034.24ms, 134MB)
 * 테스트 23 〉	실패 (22.94ms, 131MB)
 * 테스트 24 〉	실패 (22.70ms, 138MB)
 * 테스트 25 〉	실패 (1.09ms, 75MB)
 * 테스트 26 〉	실패 (1.09ms, 75.1MB)
 * 테스트 27 〉	실패 (1.06ms, 74.4MB)
 * 테스트 28 〉	통과 (9904.74ms, 92MB) = -1
 * 테스트 29 〉	통과 (198.98ms, 101MB)
 * 테스트 30 〉	실패 (3194.96ms, 106MB)
 * 채점 결과
 * 정확성: 53.3
 * 합계: 53.3 / 100.0
 */