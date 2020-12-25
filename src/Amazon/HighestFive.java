package Amazon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;


class HighestFive {

    static class ProductReviewScore {

        int productId;

        Double reviewScore;

        ProductReviewScore(int pI, Double rS) {
            this.productId = pI;
            this.reviewScore = rS;
        }

        public void print() {
            System.out.println(productId + " " + reviewScore);
        }
    }

    static public HashMap<Integer, Double> calculateHighestFive(int scoreCount,
            ArrayList<ProductReviewScore> reviewScoreOfProducts) {
        HashMap<Integer, ArrayList<Double>> data = new HashMap<Integer, ArrayList<Double>>();
        HashMap<Integer, Double> returnMap = new HashMap<Integer, Double>();
        for (ProductReviewScore pRS : reviewScoreOfProducts) {
            ArrayList<Double> dataArr = data.get(pRS.productId);
            if (dataArr == null) {
                dataArr = new ArrayList<Double>();
            }
            dataArr.add(pRS.reviewScore);
            data.put(pRS.productId, dataArr);
        }
        for (int key : data.keySet()) {
            ArrayList<Double> arr = data.get(key);
            Collections.sort(arr);
            Collections.reverse(arr);
            double sum = 0;
            double count = 0;
            for (double elem : arr) {
                if (count < 5) {
                    sum += elem;
                    count++;
                } else if (((sum + elem) / (count + 1)) > (sum / count)) {
                    sum += elem;
                    count++;
                }
            }
            returnMap.put(key, sum / count);
        }
        return returnMap;
    }

    public static void main(String[] args) {
        int sC = 10;
        int[] pI = {
                1, 2, 1,
                2, 2, 3,
                1, 1, 1,
                2, 2, 3,
                3, 2, 3,
                3};
        // 1,1,1,1,1,2,2,2,2,2};
        double[] rS = {
                4.5, 4.5, 6.75,
                5.25, 7.25, 15.5,
                12.5, 19.5, 21.5,
                7.25, 9.75, 3.75,
                9.25, 11.5, 15.5,
                16.5};
        // 9,7,8,4,6,8,3,6,9,10};
        ArrayList<ProductReviewScore> rSOP = getData(pI, rS);
        printMap(calculateHighestFive(sC, rSOP));
    }

    static ArrayList<ProductReviewScore> getData(int[] pI, double[] rS) {
        ArrayList<ProductReviewScore> retList = new ArrayList();
        for (int i = 0; i < pI.length; i++) {
            ProductReviewScore obj = new ProductReviewScore(pI[i], rS[i]);
            retList.add(obj);
        }
        return retList;
    }

    static void printMap(HashMap<Integer, Double> mapData) {
        for (int key : mapData.keySet()) {
            System.out.println(key + " " + mapData.get(key));
        }
    }
}