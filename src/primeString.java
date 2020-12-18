/**
 * Created By srivmanu on 11/15/2019 for CodePractice
 * This will always be a test run.
 * Unless you are compiling to submit on play store.
 * In which case, God help your soul.
 */
class primeString {

    public static void main(String[] args) {
        System.out.println("Check " + solve("Check"));
    }

    static boolean isPrime(int number) {
        System.out.println("N : " + number);
        int sqrt = (int) Math.sqrt(number) + 1;
        for (int i = 2; i < sqrt; i++) {
            if (number % i == 0) {
                // number is perfectly divisible - no prime
                return false;
            }
        }
        return true;
    }

    static String solve(String s) {
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            char n = getNearestPrime(ch[i]);
            ch[i] = n;
        }
        return new String(ch);
    }

    private static char getNearestPrime(char ch) {
        System.out.println("CH : " + ch);
        int i = 0;
        if (isPrime(ch)) {
            return ch;
        } else {
            do {
                char oneless = (char) (ch - i);
                char onemore = (char) (ch + i);
                System.out.println("+- : " + oneless + " : " + onemore);
                if (isPrime(oneless)) {
                    return oneless;
                }
                if (isPrime(onemore)) {
                    return onemore;
                }
                i++;
            } while (true);
        }
    }
}
