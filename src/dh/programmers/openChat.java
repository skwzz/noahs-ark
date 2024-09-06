package dh.programmers;

import java.util.*;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42888
 */
public class openChat {
    public static void main(String[] args) {
        String[] record = new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        System.out.println("result = " + solution(record));
    }

    // stack 사용
    static String[] solution(String[] record)
    {
        final String enter = "님이 들어왔습니다.";
        final String leave = "님이 나갔습니다.";

        List<String> answerList = new ArrayList<>();
        Map<String, String> nicknameMap = new HashMap<>();

        for(String rec : record) {
            String[] values = rec.split(" ");
            String type = values[0];
            String id = values[1];

            if(type.equals("Enter") || type.equals("Change")) {
                String nickname = values[2];
                nicknameMap.put(id, nickname);
            }
        }

        for(String rec : record) {
            String[] values = rec.split(" ");
            String type = values[0];
            String id = values[1];

            if(type.equals("Enter") || type.equals("Leave")) {
                String phrase = type.equals("Enter") ? enter : leave;
                answerList.add(nicknameMap.get(id) + phrase);
            }
        }

        String[] answer = answerList.toArray(new String[0]);
        return answer;
    }
}

