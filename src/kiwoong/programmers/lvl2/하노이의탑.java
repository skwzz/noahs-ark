package kiwoong.programmers.lvl2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/12946">...</a>
 */
public class 하노이의탑 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(2)));
    }

    public static int[][] solution(int n) {
        List<int[]> moves = new ArrayList<>();
        hanoi(n, 1, 3, 2, moves);
        int[][] answer = new int[moves.size()][2];
        for (int i = 0; i < moves.size(); i++) {
            answer[i] = moves.get(i);
        }
        return answer;
    }

    private static void hanoi(int n, int from, int to, int aux, List<int[]> moves) {
        if (n == 1) {
            moves.add(new int[]{from, to});
            return;
        }
        hanoi(n - 1, from, aux, to, moves);
        moves.add(new int[]{from, to});
        hanoi(n - 1, aux, to, from, moves);
    }
}
