package CMT;

import java.util.ArrayList;
import java.util.List;
// for costs of houses with materials, find min cost of
// building neighborhood given 2 consecutive houses
// dont have same material
public class HousesMaterial {

    public static void main (String[] args)
    {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> color = new ArrayList<>();
        color.add(1);color.add(2);color.add(2);color.add(2);
        list.add(color);
        color = new ArrayList<>();
        color.add(1);color.add(2);color.add(2);color.add(2);
        list.add(color);
        color = new ArrayList<>();
        color.add(1);color.add(2);color.add(2);color.add(0);
        list.add(color);

        System.out.println(houses(list));
    }

    static int houses(List<List<Integer>> cost){
        System.out.println(cost);
        int[][] dp = new int[cost.size()][cost.get(0).size()];
        for (int i = 0; i<cost.get(0).size(); i++){
            dp[0][i] = cost.get(0).get(i);
        }
        for(int i = 1; i<cost.size(); i++ ){
            for(int j = 0; j < cost.get(i).size(); j++){
                int min = Integer.MAX_VALUE;
                for(int k = 0; k < cost.get(i).size(); k++){
                    if(k!=j){
                        int val = dp[i - 1][k] + cost.get(i).get(j);
                        if ( val < min)
                            min = val;
                    }
                }
                dp[i][j] = min;
            }
        }
        int n = cost.size();
        int x = getMin(dp[n-1]);
        for (int[] list : dp) {
            for (int anInt : list) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
        return x;
    }

    private static int getMin(final int[] ints) {
        int min = Integer.MAX_VALUE;
        for(int i : ints){
            if(min > i){
                min = i;
            }
        }
        return min;
    }

}
