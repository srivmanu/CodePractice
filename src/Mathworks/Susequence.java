package Mathworks;

/**
 * Leetcode 115
 */

public class Susequence {

    public long numDistinct(String longString, String smallString) {
        long[][] mem = new long[smallString.length() + 1][longString.length() + 1];
        for (int i = 0; i < longString.length(); i++) {
            mem[0][i] = 1;
        }
        for (int i = 0; i < smallString.length(); i++) {
            for (int j = 0; j < longString.length(); j++) {
                if (smallString.charAt(i) == longString.charAt(j)) {
                    mem[i + 1][j + 1] = mem[i][j] + mem[i + 1][j];
                } else {
                    mem[i + 1][j + 1] = mem[i + 1][j];
                }
            }
        }
        return mem[smallString.length()][longString.length()];
    }
}
