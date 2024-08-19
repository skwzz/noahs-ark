package kiwoong.programmers.lvl2;

import java.util.LinkedList;
import java.util.Queue;

public class 두큐합같게만들기 {
    public static void main(String[] args) {
        int[] q1 = {10, 5, 1};
        int[] q2 = {2, 2, 2};
        System.out.println(solution(q1, q2));
    }

    static int solution(int[] arr1, int[] arr2) {
        long arr1Sum = 0L;
        long arr2Sum = 0L;

        int maxValue = Integer.MIN_VALUE;
        for(int i=0; i<arr1.length; i++){
            arr1Sum += arr1[i];
            arr2Sum += arr2[i];
            maxValue = Math.max(Math.max(maxValue, arr1[i]), arr2[i]);
        }
        long sum = arr1Sum + arr2Sum;
        long target = sum/2;
        if(sum%2==1 || maxValue > target) return -1;

        int opCount = 0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        for (int num : arr1) { q1.add(num); }
        for (int num : arr2) { q2.add(num); }
        int bp = arr1.length * 3;
        while(arr1Sum != target && opCount < bp){
            int n;
            if(arr1Sum < target){
                n = q2.peek();
                arr1Sum += n;
                q1.add(q2.poll());
            }else{
                n = q1.peek();
                arr1Sum -= n;
                q2.add(q1.poll());
            }
            opCount++;
        }

        return arr1Sum == target ? opCount : -1;
    }
}