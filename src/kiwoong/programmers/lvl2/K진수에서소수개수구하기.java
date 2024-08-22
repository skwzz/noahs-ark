package kiwoong.programmers.lvl2;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/92335">...</a>
 */
public class K진수에서소수개수구하기 {
    public static void main(String[] args) {
        System.out.println(solution(437674, 3)); // 3
        System.out.println(solution(110011, 10)); // 2
    }

    static int solution(int n, int k){
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        int origin = n;
        while(n > 0){
            sb.insert(0, n%k);
            n /= k;
        }
        StringBuilder checker = new StringBuilder();
        for(int i=0; i<sb.length(); i++){
            if(sb.charAt(i) == '0'){
                if(checker.length() != 0){
                    if(isPrime(Long.parseLong(checker.toString()))){
                        answer++;
                    }
                }
                checker.setLength(0);
            }else{
                checker.append(sb.charAt(i));
            }

            if(i == sb.length()-1 && checker.length() != 0){
                if(isPrime(Long.parseLong(checker.toString()))){
                    answer++;
                }
            }
        }
        return answer;
    }

    static boolean isPrime(long n){
        long stop = (long) Math.ceil(Math.sqrt(n));
        if(n == 0 || n == 1) return false;
        if(n == 2) return true;
        for(long i=2; i<=stop; i++){
            if(n % i == 0) return false;
        }
        return true;
    }
}