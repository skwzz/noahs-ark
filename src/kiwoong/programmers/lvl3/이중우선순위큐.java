package kiwoong.programmers.lvl3;

import java.util.*;

public class 이중우선순위큐 {
    public static void main(String[] args) {
        String[] arr = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
        System.out.println(Arrays.toString(solution(arr)));
    }

    static int[] solution(String[] arr) {
        int[] result = new int[2];
        StringTokenizer st;
        LinkedList<Integer> ll = new LinkedList<>();

        for (String s : arr) {
            st = new StringTokenizer(s);
            String op = st.nextToken();
            int val = Integer.parseInt(st.nextToken());
            if ("I".equals(op)) {
                ll.add(val);
                Collections.sort(ll);
            } else if (!ll.isEmpty()) {
                if (val == 1) {
                    ll.remove(ll.size() - 1);
                } else {
                    ll.remove(0);
                }
            }
        }

        if(!ll.isEmpty()){
            result[1] = ll.get(0);
            result[0] = ll.get(ll.size()-1);
        }else{
            result = new int[]{0, 0};
        }
        return result;
    }
}
