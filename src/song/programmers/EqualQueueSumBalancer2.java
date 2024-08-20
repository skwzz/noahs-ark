package song.programmers;

import java.util.LinkedList;
import java.util.Queue;

public class EqualQueueSumBalancer2 {
    public static void main(String[] args) {
        EqualQueueSumBalancer2 balancer = new EqualQueueSumBalancer2();
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

    public int solution(int[] arr1, int[] arr2) {
        Queue<Integer> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();
        long sum = 0;
        long sum1 = 0;
        int maxNum = 0;
        for(int num : arr1){
            queue1.add(num);
            sum += num;
            sum1 += num;
            if(maxNum < num) {
                maxNum = num;
            }
        }
        for(int num : arr2){
            queue2.add(num);
            sum += num;
            if(maxNum < num) {
                maxNum = num;
            }
        }
        if(sum % 2 == 1) return -1;

        long target = sum/2;
        if(maxNum > target) return -1;

        int moveCount = 0;
        for (int i = 0; i < arr1.length + arr1.length + arr2.length + arr2.length; i++) {
            if(sum1 == target){
                break;
            }
            else if(sum1 > target){
                Integer num = queue1.poll();
                sum1-=num;
                queue2.add(num);
            }else {
                Integer num = queue2.poll();
                sum1+=num;
                queue1.add(num);
            }
            moveCount++;
        }

        return sum1 == target ? moveCount : -1;
    }
}
