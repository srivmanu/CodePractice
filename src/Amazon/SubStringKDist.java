package Amazon;

import java.util.ArrayList;

class SubStringKDist {

    public static void main(String[] args) {
        String input = "democracy"; //democracy
        int size = 5; //5
        printList(subStringLessKDist(input, size));
    }

    static public void printList(ArrayList<String> list) {
        for (String elem : list) {
            System.out.print(elem + " ");
        }
    }

    public static ArrayList<String> subStringLessKDist(String inputString, int k) {
        ArrayList<String> out = new ArrayList<>();
        for (int i = 0; i < (inputString.length() - k + 1); i++) {
            String substr = inputString.substring(i, i + k);
            // System.out.println(substr);
            if (countDistint(substr) == (k - 1)) {
                out.add(substr);
            }
        }
        return out;
    }

    static int countDistint(String substr) {
        int count = 0;
        for (int i = 0; i < substr.length() - 1; i++) {
            for (int j = i + 1; j < substr.length(); j++) {
                if (substr.charAt(i) == substr.charAt(j)) {
                    count++;
                }
            }
        }
        // System.out.println(count + " " + substr);
        return (substr.length() - count);
    }
}