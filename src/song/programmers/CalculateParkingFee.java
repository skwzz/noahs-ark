package song.programmers;

import java.time.Duration;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 주차 요금 계산
 * https://school.programmers.co.kr/learn/courses/30/lessons/92341
 */
public class CalculateParkingFee {
    public static void main(String[] args) {
        CalculateParkingFee p = new CalculateParkingFee();

        int[] fees;
        String[] records;
        int[] answer;

        fees = new int[]{180, 5000, 10, 600};
        records = new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        answer = p.solution(fees, records);
        display(answer); // [14600, 34400, 5000]


        fees = new int[]{120, 0, 60, 591};
        records = new String[]{"16:00 3961 IN", "16:00 0202 IN", "18:00 3961 OUT", "18:00 0202 OUT", "23:58 3961 IN"};
        answer = p.solution(fees, records);
        display(answer); // [0, 591]


        fees = new int[]{1, 461, 1, 10};
        records = new String[]{"00:00 1234 IN"};
        answer = p.solution(fees, records);
        display(answer); // [14841]
    }

    private static void display(int[] solution) {
        for (int i = 0; i < solution.length; i++) {
            System.out.print(solution[i] + " ");
        }
        System.out.println();
    }

    public int[] solution(int[] fees, String[] records) {
        ParkingFeeCalculator calculator = new ParkingFeeCalculator(fees);

        for (String record : records){
            String[] splitRecord = record.split(" ");
            if(isEnter(splitRecord[2])){
                calculator.enterParking(splitRecord[0], splitRecord[1]);
            }else {
                calculator.exitParking(splitRecord[0], splitRecord[1]);
            }
        }

        return calculator.generateBillingSummary();
    }

    private boolean isEnter(String s) {
        return "IN".equals(s);
    }

    private class ParkingFeeCalculator {
        private final int baseTime;
        private final int baseFee;
        private final int unitTime;
        private final int unitFee;

        private final Map<String, String> carEnterMap;
        private final Map<String, Integer> carParkingTimeMap;

        public ParkingFeeCalculator(int[] fees) {
            baseTime = fees[0];
            baseFee = fees[1];
            unitTime = fees[2];
            unitFee = fees[3];
            carEnterMap = new HashMap<>();
            carParkingTimeMap = new HashMap<>();
        }

        public void enterParking(String enterDate, String carNumber){
            carEnterMap.put(carNumber, enterDate);
        }

        public void exitParking(String exitDate, String carNumber){
            String enterDate = carEnterMap.get(carNumber);
            carEnterMap.remove(carNumber);
            int parkingTime = calculateParkingTime(enterDate,exitDate);

            if (carParkingTimeMap.containsKey(carNumber)){
                parkingTime += carParkingTimeMap.get(carNumber);
            }
            carParkingTimeMap.put(carNumber, parkingTime);
        }

        private int calculateParkingTime(String enterDate, String exitDate){
            LocalTime startTime = LocalTime.parse(enterDate);
            LocalTime endTime = LocalTime.parse(exitDate);
            return (int) Duration.between(startTime, endTime).toMinutes();
        }

        public int[] generateBillingSummary() {
            this.exitParkingAll();
            return new TreeMap<>(carParkingTimeMap)
                    .values()
                    .stream()
                    .mapToInt(parkingTime -> calculateFee(parkingTime))
                    .toArray();
        }
        private void exitParkingAll() {
            List<String> keyList = carEnterMap.keySet()
                    .stream()
                    .collect(Collectors.toList());
            for (String carNumber: keyList) {
                exitParking("23:59", carNumber);
            }
        }

        private int calculateFee(int parkingTime) {
            if(parkingTime <= baseTime){
                return baseFee;
            }
            return baseFee + (int) Math.ceil((float) (parkingTime - baseTime) / unitTime) * unitFee;
        }
    }
}

/**
 * 정확성  테스트
 * 테스트 1 〉	통과 (12.55ms, 77.5MB)
 * 테스트 2 〉	통과 (10.25ms, 83.5MB)
 * 테스트 3 〉	통과 (15.86ms, 72.2MB)
 * 테스트 4 〉	통과 (20.04ms, 86.4MB)
 * 테스트 5 〉	통과 (12.40ms, 76.8MB)
 * 테스트 6 〉	통과 (14.63ms, 78.9MB)
 * 테스트 7 〉	통과 (32.48ms, 84.7MB)
 * 테스트 8 〉	통과 (26.02ms, 86.2MB)
 * 테스트 9 〉	통과 (17.03ms, 72.5MB)
 * 테스트 10 〉	통과 (44.83ms, 83.9MB)
 * 테스트 11 〉	통과 (36.63ms, 90.8MB)
 * 테스트 12 〉	통과 (36.70ms, 89.8MB)
 * 테스트 13 〉	통과 (12.43ms, 80.8MB)
 * 테스트 14 〉	통과 (7.85ms, 78MB)
 * 테스트 15 〉	통과 (8.09ms, 85.4MB)
 * 테스트 16 〉	통과 (7.44ms, 78.4MB)
 * 채점 결과
 * 정확성: 100.0
 * 합계: 100.0 / 100.0
 */