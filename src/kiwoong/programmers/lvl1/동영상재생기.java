package kiwoong.programmers.lvl1;

public class 동영상재생기 {
    public static void main(String[] args) {
        System.out.println(solution("34:33", "13:00", "00:55", "02:55", new String[]{"next", "prev"})); // "13:00"
        System.out.println(solution("10:55", "00:05", "00:15", "06:55", new String[]{"prev", "next", "next"})); // "06:55"
        System.out.println(solution("07:22", "04:05", "00:15", "04:07", new String[]{"next"})); // "04:17"
        System.out.println(solution("30:00", "00:08", "00:00", "00:05", new String[]{"prev"})); // "00:05"
    }

    static String solution(String a, String b, String c, String d, String[] commands) {
        int video_len = convertToSeconds(a);
        int pos = convertToSeconds(b);
        int op_start = convertToSeconds(c);
        int op_end = convertToSeconds(d);
        if(op_start <= pos && pos <= op_end){
            pos = op_end;
        }
        for(int i=0; i<commands.length; i++){
            String operator = commands[i];
            if("next".equals(operator)){
                pos += 10;
                if(10 > video_len - pos){
                    pos = video_len;
                }
            }else{
                pos -= 10;
                if(pos < 10){
                    pos = 0;
                }
            }
            if(op_start <= pos && pos <= op_end){
                pos = op_end;
            }
        }
        return convertToMinuteSecond(pos);
    }

    public static int convertToSeconds(String time) {
        String[] parts = time.split(":");
        int minutes = Integer.parseInt(parts[0]);
        int seconds = Integer.parseInt(parts[1]);
        return minutes * 60 + seconds;
    }

    public static String convertToMinuteSecond(int a) {
        String[] parts = new String[2];
        parts[0] = String.valueOf(a / 60);
        parts[1] = String.valueOf(a % 60);
        if(parts[0].length() == 1){
            parts[0] = "0"+parts[0];
        }
        if(parts[1].length() == 1){
            parts[1] = "0"+parts[1];
        }
        return String.join(":", parts);
    }
}
