package Tiktok;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LogParsing {
    static float getMin(String log){
        List<Integer> ls = new ArrayList<>();
        List<String> newLogs = new ArrayList<>();
        List<String> batch = new ArrayList<>();
        String[] logs = log.split("batch\n[0-9]*");
        for (String s : logs) {
            if (s.length() > 0) {
                newLogs.add(clean(s));
            }
        }
        for(String str : newLogs){
            List<String> items = Arrays.asList(str.split("\\s*;\\s*"));
            batch.addAll(items);
        }
        for(String bat : batch){
            if(getssafe(bat)){
                ls.add(getE(bat));
            }
        }
        Collections.sort(ls);
        System.out.println(batch);
        System.out.println(ls);

        return getPerc(ls);
    }

    static String clean(String c){
        if(c.indexOf("&&") > 0 ){
            return c.substring(c.indexOf("||") + 2,c.indexOf("&&"));
        }else{
            return c.substring(c.indexOf("||") + 2);
        }
    }
    static int getE(String val){
        val = val.substring(val.indexOf(",E=")+3);
        return Integer.parseInt(val);
    }
    static boolean getssafe(String val){
        val = val.substring(val.indexOf("is_safe:"),val.indexOf(",E"));
        System.out.println("SAFE : " + val);
        return val.equals("is_safe:1");
    }

    static float getPerc(List<Integer> vals){
        if(vals.size() == 0){
            return 0;
        }

        if(vals.size() %2 ==0){
            return (float) ((float) (vals.get(vals.size()/2 - 1) + vals.get((vals.size()/2)))/2.0);
        }
        else
            return vals.get(vals.size() / 2);
    }

    public static void main(String[] args) {
        String log = "batch\n" +
                "0||is_safe:0,E=100;is_safe:1,E=101;&&batch\n" +
                "2||is_safe:0,E=100;is_safe:1,E=102;is_safe:0,E=12";

        System.out.println(getMin(log));
    }
}
