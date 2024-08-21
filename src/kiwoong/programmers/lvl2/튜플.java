package kiwoong.programmers.lvl2;

import java.util.*;

public class 튜플 {
    public static void main(String[] args) {
        String s1 = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
        String s2 = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
        String s3 = "{{20,111},{111}}";
        String s4 = "{{123}}";
        String s5 = "{{4,2,3},{3},{2,3,4,1},{2,3}}";

        System.out.println(Arrays.toString(solution(s1)));
        System.out.println(Arrays.toString(solution(s2)));
        System.out.println(Arrays.toString(solution(s3)));
        System.out.println(Arrays.toString(solution(s4)));
        System.out.println(Arrays.toString(solution(s5)));
    }

    static int[] solution(String s){
        ArrayList<ArrayList<Integer>> arr = parser(s);
        List<Integer> result = new ArrayList<>();
        Collections.sort(arr, new Comparator<ArrayList<Integer>>(){
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return o1.size() > o2.size() ? 1 : -1;
            }
        });
        for(ArrayList<Integer> inner : arr){
            for(Integer num : inner){
                if(!result.contains(num)){
                    result.add(num);
                }
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    static ArrayList<ArrayList<Integer>> parser(String s) {
        s = s.substring(2, s.length() - 2); // Remove outer curly braces
        String[] sets = s.split("\\},\\{"); // Split by "},{"

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (String set : sets) {
            String[] numbers = set.split(",");
            ArrayList<Integer> innerList = new ArrayList<>();
            for (String number : numbers) {
                innerList.add(Integer.parseInt(number));
            }
            list.add(innerList);
        }

        return list;
    }
}
