package dh.programmers;
import java.util.*;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12946
 */
public class towerOfHanoi {
    public static void main(String[] args) {
        int n = 3;
        int[][] result = solution(n);
        System.out.println("result = " + Arrays.deepToString(result));
    }

    // solution 함수: 하노이 탑의 최소 이동 과정을 반환
    public static int[][] solution(int n) {
        List<int[]> moves = new ArrayList<>();
        hanoi(n, 1, 3, 2, moves);

        // List<int[]>를 int[][]로 변환
        int[][] answer = new int[moves.size()][2];
        for (int i = 0; i < moves.size(); i++) {
            answer[i] = moves.get(i);
        }

        return answer;
    }

    // 하노이 함수: 원판을 옮기는 과정을 재귀적으로 해결
    private static void hanoi(int n, int start, int end, int via, List<int[]> moves) {
        if (n == 1) {
            // 원판이 하나일 때, 바로 목적지로 옮김
            moves.add(new int[]{start, end});
            return;
        }
        // Step 1: n-1개의 원판을 start에서 via로 옮김 (end를 보조 기둥으로 사용)
        hanoi(n - 1, start, via, end, moves);
        // Step 2: n번째 원판을 start에서 end로 옮김
        moves.add(new int[]{start, end});
        // Step 3: n-1개의 원판을 via에서 end로 옮김 (start를 보조 기둥으로 사용)
        hanoi(n - 1, via, end, start, moves);
    }
}

