package Visa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Meetup {

    class Person implements Comparable<Person> {

        int arr;

        int dep;

        int id;

        int stay;

        Person(int i, int a, int d) {
            this.id = i;
            this.arr = a;
            this.dep = d;
            this.stay = d - a;
        }


        @Override
        public int compareTo(final Person o) {
            if (this.stay != o.stay) {
                return this.stay - o.stay;
            } else {
                return this.arr - o.arr;
            }
        }

        public void print() {
            System.out.println("\n\nPerson : " + id);
        }
    }

    public static void main(String[] args) {
        Meetup obj = new Meetup();
        List<Integer> arr = obj.getList(new int[]{1, 2, 2, 3, 5});
        List<Integer> dep = obj.getList(new int[]{2, 3, 2, 4, 5});
        System.out.println(obj.activity(arr, dep));
    }

    int activity(List<Integer> arrival, List<Integer> departure) {
        int count = 0;
        int maxDep = getMax(departure);
        int[] time = new int[maxDep + 1];
        for (int t = 0; t <= maxDep; t++) {
            time[t] = -1;
        }
        //Convert to Person List
        List<Person> list = new ArrayList<>();
        for (int i = 0; i < arrival.size(); i++) {
            Person p = new Person(i + 1, arrival.get(i), departure.get(i));
            list.add(p);
        }

        printList(list);
        System.out.println("\nSORTING");
        Collections.sort(list);
        printList(list);

        for (int i = 0; i < list.size(); i++) {
            Person curr = list.get(i);
            curr.print();
            for (int set = curr.arr; set <= curr.dep; set++) {
                if (time[set] == -1) {
                    time[set] = curr.id;
                    break;
                }
            }
            printTime(i, time);
        }
        for (int t : time) {
            if (t != -1) {
                count++;
            }
        }
        return count;
    }

    private List<Integer> getList(final int[] ints) {
        List<Integer> array = new ArrayList<>();
        for (int val : ints) {
            array.add(val - 1);
        }
        return array;
    }

    private int getMax(final List<Integer> departure) {
        int max = -1;
        for (int d : departure) {
            if (d > max) {
                max = d;
            }
        }
        return max;
    }

    private void printList(final List<Person> list) {
        System.out.print("\n ID : ");
        for (Person p : list) {
            System.out.print(p.id + " ");
        }
        System.out.print("\nARR : ");
        for (Person p : list) {
            System.out.print(p.arr + " ");
        }

        System.out.print("\nDEP : ");
        for (Person p : list) {
            System.out.print(p.dep + " ");
        }
        System.out.print("\nSTY : ");
        for (Person p : list) {
            System.out.print(p.stay + " ");
        }
    }

    private void printTime(final int i, final int[] time) {
        System.out.println("\nAt Time : " + i);
        for (int t : time) {
            System.out.print(t + " ");
        }
        System.out.println();
    }
}
