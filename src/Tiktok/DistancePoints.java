package Tiktok;

import java.util.ArrayList;
import java.util.List;

public class DistancePoints {
    static long distance(List<Integer> x, List<Integer> y){
        long min = Integer.MAX_VALUE;
        for(int i = 0; i < x.size(); i++){
            for(int j = i+1; j < x.size(); j++){
                int x1 = x.get(i);
                int x2 = x.get(j);
                int y1 = y.get(i);
                int y2 = y.get(j);
                System.out.println("Comparing : (" + x1 + " , " + y1 + ") and ("+ x2 + " , " + y2 + ")");
                long dist = ((long) (x2 - x1) * (x2-x1)) + ((long) (y2 - y1) *(y2-y1));
                if(min > dist){
                    min = dist;
                }
                System.out.println(" = " + dist);
            }
            if(min == 0){
                break;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        List<Integer> x = new ArrayList<>();
        List<Integer> y = new ArrayList<>();
        x.add(1);
        x.add(0);
        x.add(2);
        y.add(1);
        y.add(0);
        y.add(4);
        System.out.println(distance(x,y));

    }
}
