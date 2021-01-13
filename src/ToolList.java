import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ToolList {

    static int[] list = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18};

    static List<Integer> s = Arrays.stream(list).boxed().collect(Collectors.toList());

    static int start = 15;

    static int find = 16;

    static int findMoves(List<Integer> tools, int k, int q) {
        int pos = -1;
        int goLeft;
        int goRight;

        goLeft = (k - 1) % (tools.size());
        goRight = (k + 1) % (tools.size());

        Set<Integer> visited = new HashSet<>();
        int i = 1;
        if (checkEqual(tools, k, q)) {

            return k;
        } else {
            do {
//                System.out.println((i++) + " : " + goLeft + " : " + goRight);
                if (checkEqual(tools, goLeft, q)) {
                    pos = i;
                    break;
                } else if (checkEqual(tools, goRight, q)) {
                    pos = i;
                    break;
                }
                if (visited.contains(goLeft) || visited.contains(goRight)) {
                    System.out.println("CHECK");
                    break;
                }
                if (goLeft == goRight) {
                    System.out.println("FULL CIRCLE");
                    break;
                }
                visited.add(goLeft);
                visited.add(goRight);
                goRight = (goRight + 1) % (tools.size());
                goLeft = (goLeft - 1) % (tools.size());

                if (goLeft == -1) {
                    goLeft = tools.size() - 1;
                }
            } while (true);
        }

        return pos;
    }

    private static boolean checkEqual(final List<Integer> tools, final int k, final int q) {
        System.out.println("CHECKED " + k);
        return tools.get(k) == q;
    }

    public static void main(String[] args) {
        System.out.println(findMoves(s, start, find));
    }

}
