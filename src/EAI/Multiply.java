package EAI;

public class Multiply {

    public static void main(String[] args) {
        for (long i = 0; i < 1000; i++) {
            for (long j = 0; j < 1000; j++) {
                String res = getProd(String.valueOf(i), String.valueOf(j));
                if (!verify(i, j, res)) {
                    System.out.println("FALSE : " + i + " : " + j + " : " + i * j + " : " + res);
                }
            }
        }
    }

    static String getProd(String s1, String s2) {
//        System.out.println(s1 + "*" + s2);
        int carry = 0;
        int sum;
        int prod;
        int[][] result = new int[s1.length() + s2.length()][s2.length()];
        String res = "";

        for (int i = s2.length() - 1; i >= 0; i--) {
            int m1 = s2.charAt(i) - '0';
            for (int j = s1.length() - 1; j >= 0; j--) {
                int m2 = s1.charAt(j) - '0';
                prod = m1 * m2;
                result[j + i + 1][i] = result[j + i + 1][i] + (prod % 10);
                result[j + i][i] = result[j + i][i] + (prod / 10);
            }
        }

        for (int i = result.length - 1; i >= 0; i--) {
            sum = carry;
            for (int j = result[i].length - 1; j >= 0; j--) {
                sum = sum + result[i][j];
            }
            if (sum >= 10) {
                carry = sum / 10;
                sum = sum % 10;
            } else {
                carry = 0;
            }
            res = sum + res;
        }
        //remove trailing and ending 0s
//        System.out.println(res);
        return remove0s(res);
    }

    static boolean verify(long n1, long n2, String res) {
        return (res.compareTo(String.valueOf(n1 * n2)) == 0);
    }

    private static String remove0s(String res) {
        int i;
        String s = res;
        for (i = 0; i < res.length(); i++) {
//            System.out.println(res.charAt(i));
            if (res.charAt(i) != '0') {
                res = res.substring(i);
                i--;
                break;
            }
        }
        if (i == s.length()) {
            return "0";
        }
        return res;
    }
}