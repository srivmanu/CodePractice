import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Jimmy owns a garden in which he has planted N trees in a row. After a few years, the trees have grown up and now they have different heights.
 * <p>
 * Jimmy pays much attention to the aesthetics of his garden. He finds his trees aesthetically pleasing if they alternately increase and decrease in height (..., shorter, taller, shorter, taller, ...).
 * <p>
 * These are examples of aesthetically pleasing trees:
 * <p>
 * These are examples of trees that are NOT aesthetically pleasing:
 * <p>
 * Note that two adjacent trees cannot have equal heights. It may turn out that some trees have to be shortened in order to keep the look of the garden aesthetically pleasing. Jimmy is a lazy type, so he wants to put as little energy as possible into obtaining the desired look for his garden. What is the minimum number of trees that should be shortened so that Jimmy would find his garden aesthetically pleasing?
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given an array A consisting of N integers, where A[K] denotes the height of the K-th tree, returns the minimum number of trees that should be shortened so that the garden looks aesthetically pleasing.
 * <p>
 * Examples:
 * <p>
 * 1. Given A = [5, 4, 3, 2, 6] your function should return 1:
 * <p>
 * Jimmy can obtain the desired pattern by decreasing the height of the second tree to 2.
 * <p>
 * 2. Given A = [3, 7, 4, 5] your function should return 0, since the garden already looks aesthetically pleasing.
 * <p>
 * Assumptions:
 * <p>
 * - N is an integer within the range [1... 100,000]
 * <p>
 * - Each element of array A is an integer within the range [2... 1,000]
 */
class TreeSizes {
    public static void main(String args[]) {
        TreeSizes obj = new TreeSizes();
        int A[] = {3, 4, 5, 3, 7};
        int jimmy = obj.solution(A);
        System.out.println("Array: [3, 4, 5, 3, 7]");
        if (jimmy == 0)
            System.out.println("The garden looks aesthetically:" + jimmy);
        else
            System.out.println("The garden not looks aesthetically: " + jimmy);


        //check another array
        int B[] = {3, 7, 4, 5};
        //call function
        jimmy = obj.solution(B);
        System.out.println("\nArray: [3, 7, 4, 5]");
        //print information
        if (jimmy == 0)
            System.out.println("The garden looks aesthetically:" + jimmy);
        else
            System.out.println("The garden not looks aesthetically: " + jimmy);

        //check another array
        int C[] = {5, 4, 3, 2, 6};
        //call function
        jimmy = obj.solution(C);
        System.out.println("\nArray: [5, 4, 3, 2, 6]");
        //print information
        if (jimmy == 0)
            System.out.println("The garden looks aesthetically: " + jimmy);
        else
            System.out.println("The garden not looks aesthetically: " + jimmy);

        //check another array
        int D[] = {1, 2, 3, 4};
        //call function
        jimmy = obj.solution(D);
        System.out.println("\nArray: [1, 2, 3, 4]");
        //print information
        if (jimmy == 0)
            System.out.println("The garden looks aesthetically: " + jimmy);
        else
            System.out.println("The garden not looks aesthetically: " + jimmy);

        //check another array
        int E[] = {1, 3, 1, 2};
        //call function
        jimmy = obj.solution(E);
        System.out.println("\nArray: [1, 3, 1, 2]");
        //print information
        if (jimmy == 0)
            System.out.println("The garden looks aesthetically: " + jimmy);
        else
            System.out.println("The garden not looks aesthetically: " + jimmy);
    }

    public int solution(int[] A) {
        System.out.println(Arrays.toString(A));
        int l = A.length;
        if (l < 4 || l > 200) {
            return -1;
        }
        int rc = 0;
        int[] arr = A;
        int j = 0;
        do {
            int n = arr.length;
            int x = 0;
            for (int i = 0; i < n; i += 2) {
                if ((i == 0 || arr[i] < arr[i - 1]) && (arr[i] < arr[i + 1]))
                    continue;
                else
                    x += 1;
            }
            if (x == 0 && j == 0)
                return x;
            if (x == 0) {
                rc += 1;
            }
            int y = 0;
            for (int i = 0; i < n - 1; i += 2) {
                if ((i == 0 || arr[i] > arr[i - 1]) && (arr[i] > arr[i + 1]))
                    continue;
                else
                    y += 1;
            }
            if (y == 0 && j == 0)
                return y;
            if (y == 0) {
                rc += 1;
            }
            int index = j;
            arr = IntStream.range(0, A.length).filter(i -> i != index).map(i -> A[i]).toArray();
            j += 1;
        } while (j < l - 1);
        if (rc == 0)
            return -1;
        else
            return rc;
    }
}
