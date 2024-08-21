package song.programmers;

import java.util.*;

/**
 * 튜플
 * https://school.programmers.co.kr/learn/courses/30/lessons/64065
 */
public class Tuple {
    public static void main(String[] args) {
        Tuple tuple = new Tuple();
        int[] solution1 = tuple.solution("{{2},{2,1},{2,1,3},{2,1,3,4}}"); //	[2, 1, 3, 4]
        display(solution1);

        int[] solution2 = tuple.solution("{{1,2,3},{2,1},{1,2,4,3},{2}}"); //	[2, 1, 3, 4]
        display(solution2);

        int[] solution3 = tuple.solution("{{20,111},{111}}"); //	[111, 20]
        display(solution3);

        int[] solution4 = tuple.solution("{{123}}"); //[123]
        display(solution4);

        int[] solution5 = tuple.solution("{{4,2,3},{3},{2,3,4,1},{2,3}}"); //[3, 2, 4, 1]
        display(solution5);

    }

    private static void display(int[] solution) {
        for (int i = 0; i < solution.length; i++) {
            System.out.print(solution[i] + " ");
        }
        System.out.println();
    }

    public int[] solution(String s) {
        List<ElementSet> elementSets = makeElementSets(s);

        int[] answer = new int[elementSets.size()];
        for (int i = 0; i < elementSets.size(); i++) {
            answer[i] = elementSets.get(i).getElement();
            for (int j = i+1; j < elementSets.size(); j++) {
                elementSets.get(j).remove(answer[i]);
            }
        }
        return answer;
    }

    private List<ElementSet> makeElementSets(String s) {
        List<ElementSet> elementSets = new ArrayList<>();
        for (String setString : s.substring(2, s.length()-2).split("},\\{")) {
            elementSets.add(new ElementSet(setString));
        }
        elementSets.sort(Comparator.comparingInt(ElementSet::getCount));
        return elementSets;
    }

    // 원소의 집합
    private class ElementSet {
        private Map<Integer, Integer> elementCountMap = new HashMap<>();
        private final int count;

        public ElementSet(String elementSetString) {
            String[] elementStrings = elementSetString.split(",");
            for (String elementString : elementStrings){
                Integer element = Integer.valueOf(elementString);
                if(elementCountMap.containsKey(element)){
                    elementCountMap.put(element, elementCountMap.get(element) + 1);
                }else {
                    elementCountMap.put(element, 1);
                }
            }
            count = elementStrings.length;
        }

        public int getCount(){
            return this.count;
        }

        public int getElement(){
            for (Map.Entry<Integer, Integer> entrySet : this.elementCountMap.entrySet()) {
                return entrySet.getKey();
            }
            return 0;
        }

        public void remove(int i) {
            Integer count = elementCountMap.get(i);
            if(count ==1){
                elementCountMap.remove(i);
            }else {
                elementCountMap.put(i, count -1);
            }
        }
    }
}
