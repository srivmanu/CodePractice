package Visa;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Signals {

    public static void main(String[] args) {
        long[] signalOne = {1, -2, 3, 4, 1};
        long[] signalTwo = {5, 4, 3, 4, 1};
        List<Long> s1 = Arrays.stream(signalOne).boxed().collect(Collectors.toList());
        List<Long> s2 = Arrays.stream(signalTwo).boxed().collect(Collectors.toList());
        System.out.println(updateTimes(s1, s2));
    }

    static int updateTimes(List<Long> signalOne, List<Long> signalTwo) {
        int runSize = Math.min(signalOne.size(), signalTwo.size());
        int updated = 0;
        long maxEqual = Integer.MIN_VALUE;
        for (int i = 0; i < runSize; i++) {
            if (signalOne.get(i).equals(signalTwo.get(i)) && signalOne.get(i) > maxEqual) {
                maxEqual = signalOne.get(i);
                updated++;
            }
        }
        return updated;
    }


}
