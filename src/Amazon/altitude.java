package Amazon;

import static java.lang.Integer.min;

import java.util.ArrayList;
import java.util.List;

/**
 * matrix is 2D, has left -> right and top ->  bottom ascending order. i.e top left is min, and bot-right is max.
 * if target element is found, return index.
 *
 * Its supposed to be Amazon.altitude of places, and you're searching for customer's choice of Amazon.altitude.
 */
public class altitude {

    private class PairInt {

        int x;

        int y;

        public PairInt(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        altitude x = new altitude();
        List<List<Integer>> matrix = getMatrix();
        PairInt val = x.locationOfTargetValue(4, 3, matrix, 30);
        System.out.println(val.x + " : " + val.y);
    }

    PairInt locationOfTargetValue(int rowCount, int columnCount, List<List<Integer>> matrix, int targetValue) {
        PairInt pair = new PairInt(-1, -1);
        int consider = 0;
        boolean found = false;
        while (consider < min(rowCount, columnCount)) {
            System.out.println("Going through Row and Column : " + consider);
            for (int i = 0; i < columnCount; i++) {
                //go through rowCount
                if (matrix.get(consider).get(i) > targetValue) {
                    break;
                } else if (matrix.get(consider).get(i) == targetValue) {
                    found = true;
                    pair = new PairInt(consider, i);
                    break;
                }
            }
            for (int i = 0; i < rowCount; i++) {
                //go through columnCount
                if (matrix.get(i).get(consider) > targetValue) {
                    break;
                } else if (matrix.get(i).get(consider) == targetValue) {
                    found = true;
                    pair = new PairInt(i, consider);
                    break;
                }
            }
            consider++;
        }
        if (found == false) {
            System.out.println("Consider :" + consider);
            if (consider < rowCount) {
                for (int i = 0; i < columnCount; i++) {
                    //go through rowCount
                    if (matrix.get(consider).get(i) > targetValue) {
                        break;
                    } else if (matrix.get(consider).get(i) == targetValue) {
                        found = true;
                        pair = new PairInt(consider, i);
                        break;
                    }
                }
            } else if (consider < columnCount) {
                for (int i = 0; i < rowCount; i++) {
                    //go through columnCount
                    System.out.print("GTC  : " + i);
                    if (matrix.get(i).get(consider) > targetValue) {
                        break;
                    } else if (matrix.get(i).get(consider) == targetValue) {
                        found = true;
                        pair = new PairInt(i, consider);
                        break;
                    }
                }
            }
        }
        return pair;
    }

    private static List<List<Integer>> getMatrix() {
        List<List<Integer>> ret = new ArrayList<>();
        int[][] ret_arr = {
                {-3, 1, 31},
                {10, 33, 40},
                {22, 43, 161},
                {29, 46, 165}
        };
        for (int i = 0; i < 4; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                row.add(ret_arr[i][j]);
            }
            ret.add(row);
        }
        printList(ret);
        return ret;
    }

    private static void printList(List<List<Integer>> ret) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(":\t" + ret.get(i).get(j) + "\t:");
            }
            System.out.println();
        }
    }
}
