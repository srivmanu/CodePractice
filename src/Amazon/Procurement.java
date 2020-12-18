package Amazon;

import java.util.ArrayList;
import java.util.List;

public class Procurement {

    public static void main(String[] args) {
        List<Integer> test = new ArrayList<>();
        test.add(8);
        test.add(4);
        test.add(6);
        test.add(12);
        int x = checkMine(test);
        System.out.println(x);
    }

    static int heapify(List<Integer> list) {
        int n1 = getMinAndRemove(list);
        int n2 = getMinAndRemove(list);
        list.add(n1 + n2);
        return n1 + n2;
    }

    private static int checkMine(final List<Integer> list) {
        if (list.size() == 0) {
            return -1;
        }
        int sum = 0;
        while (list.size() > 1) {
            sum += heapify(list);
        }
        return sum;
    }

    private static int getMinAndRemove(final List<Integer> list) {
        int min = Integer.MAX_VALUE;
        for (int x : list) {
            if (min > x) {
                min = x;
            }
        }
        list.remove((Integer) min);
        return min;
    }
}
