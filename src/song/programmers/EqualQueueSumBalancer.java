package song.programmers;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
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
        Queue<Integer> operationCountQueue = new PriorityQueue(Collections.reverseOrder());
        int targetNumber = (IntStream.of(queue1).sum() + IntStream.of(queue2).sum()) / 2;
        int[] extendedQueue = makeExtendedQueue(queue1, queue2);
        for (int i = 0; i < queue1.length + queue2.length; i++) {
            int sum = 0;
            int j = i;
            while (true){
                sum += extendedQueue[j];
                if (sum == targetNumber){
                    int operationCount = calculateOperationCount(i,j, queue1.length);
                    operationCountQueue.add(operationCount);
                    break;
                }
                j++;

                if(sum > targetNumber || j == queue1.length + queue2.length) {
                    break;
                }
            }
        }
        return operationCountQueue.isEmpty() ? -1 : operationCountQueue.peek();
    }

    private int calculateOperationCount(int i, int j, int queue1Length) {
        System.out.println("calculateOperationCount " + i + ", " + j);
        if(i < queue1Length && j < queue1Length){
            return i + queue1Length - j - 1;
        }else if(i < queue1Length && j >= queue1Length){
            return i + j - queue1Length + 1;
        }
        return j + i;
    }

    private int[] makeExtendedQueue(int[] queue1, int[] queue2){
        int queueLengthSum = queue1.length + queue2.length;
        int[] extendedQueue = new int[queueLengthSum * 2];
        for (int i = 0; i < queueLengthSum; i++) {
            if(i < queue1.length){
                extendedQueue[i] = queue1[i];
            }else {
                extendedQueue[i] = queue2[i -queue1.length];
            }
            extendedQueue[i + queueLengthSum] = extendedQueue[i];
        }
        return extendedQueue;
    }
}
