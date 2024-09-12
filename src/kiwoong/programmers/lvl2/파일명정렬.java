package kiwoong.programmers.lvl2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/17686">...</a>
 */
public class 파일명정렬 {
    public static void main(String[] args) {
        파일명정렬 a = new 파일명정렬();
        System.out.println(Arrays.toString(a.solution(new String[]{"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"})));
        // ["img1.png", "IMG01.GIF", "img02.png", "img2.JPG", "img10.png", "img12.png"]

        System.out.println(Arrays.toString(a.solution(new String[]{"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"})));
        // ["A-10 Thunderbolt II", "B-50 Superfortress", "F-5 Freedom Fighter", "F-14 Tomcat"]

    }

    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        ArrayList<FileName> fileNameList = new ArrayList<>();

        for(int i=0; i<files.length; i++){
            String file = files[i];
            int firstDigitIndex = findFirstDigitIndex(file);
            int firstNonDigitIndexAfterDigit = findFirstNonDigitIndexAfterIndex(file, firstDigitIndex);
            String head = file.substring(0, firstDigitIndex);
            String number;
            String tail;
            if(firstNonDigitIndexAfterDigit == -1){
                number = file.substring(firstDigitIndex);
                tail = "";
            }else{
                number = file.substring(firstDigitIndex, firstNonDigitIndexAfterDigit);
                tail = file.substring(firstNonDigitIndexAfterDigit);
            }
            fileNameList.add(new FileName(head, number, tail, i+1));
        }

        Collections.sort(fileNameList, new Comparator<FileName>() {
            @Override
            public int compare(FileName o1, FileName o2) {
                int h = o1.getHead().toLowerCase().compareTo(o2.getHead().toLowerCase());
                if(h!=0){
                    return h;
                }
                h = Integer.compare(o1.deletedPrefixZero(), o2.deletedPrefixZero());
                if(h!=0){
                    return h;
                }
                h = Integer.compare(o1.originSeq, o2.originSeq);
                return h;
            }
        });

        for(int i=0; i<answer.length; i++){
            answer[i] = fileNameList.get(i).getFullName();
        }
        return answer;
    }
    public static int findFirstDigitIndex(String str) {
        Pattern pattern = Pattern.compile("\\d"); // \\d는 숫자를 의미하는 정규식
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            return matcher.start(); // 첫 번째로 매칭되는 숫자의 인덱스를 반환
        }
        return -1; // 숫자가 없는 경우 -1 반환
    }

    public static int findFirstNonDigitIndexAfterIndex(String str, int index) {
        Pattern pattern = Pattern.compile("\\D"); // \\D는 숫자가 아닌 문자를 의미하는 정규식
        Matcher matcher = pattern.matcher(str);
        if (matcher.find(index)) {
            return matcher.start(); // 첫 번째로 매칭되는 숫자가 아닌 문자의 인덱스를 반환
        }
        return -1; // 숫자가 아닌 문자가 없는 경우 -1 반환
    }

    class FileName{
        private String head;
        private String number;
        private String tail;
        private int originSeq;

        public FileName(String head, String number, String tail, int originSeq) {
            this.head = head;
            this.number = number;
            this.tail = tail;
            this.originSeq = originSeq;
        }

        public String getHead() {
            return head;
        }

        public void setHead(String head) {
            this.head = head;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public String getTail() {
            return tail;
        }

        public void setTail(String tail) {
            this.tail = tail;
        }

        public int getOriginSeq() {
            return originSeq;
        }

        public void setOriginSeq(int originSeq) {
            this.originSeq = originSeq;
        }

        public int deletedPrefixZero(){
            return Integer.parseInt(this.number);
        }

        public String getFullName(){
            return this.head+this.number+this.tail;
        }
    }
}
