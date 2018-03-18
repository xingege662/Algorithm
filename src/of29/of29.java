package of29;

import java.util.Comparator;

/**
 * Created by xinchang on 2018/3/18.
 */
public class of29 {

    static class MyComparator implements Comparator<String> {


        @Override
        public int compare(String o1, String o2) {

            if (o1 == null || o2 == null) {
                throw new RuntimeException("入参 出错");
            }

            String s1 = o1 + o2;

            String s2 = o2 + o1;

            return s1.compareTo(s2);
        }
    }


    static String printMinNumber(String[] args) {
        if (args == null || args.length == 0) {
            throw new RuntimeException("入参出错");
        }
        MyComparator comparator = new MyComparator();

        quickSort(args, 0, args.length - 1, comparator);

        StringBuilder stringBuilder = new StringBuilder();

        for (String i : args) {
            stringBuilder.append(i);
        }
        return stringBuilder.toString();
    }

    private static void quickSort(String[] args, int start, int end, MyComparator comparator) {
        if (args != null || args.length != 0) {
            if (start < end) {
                String pivot = args[start];
                int left = start;
                while (start < end) {
                    while (start < end && comparator.compare(args[end], pivot) >= 0) {
                        end--;
                    }

                    args[start] = args[end];


                    while (start < end && comparator.compare(args[start], pivot) <= 0) {
                        start++;
                    }

                    args[end] = args[start];
                }

                args[start] = pivot;

                quickSort(args, left, start - 1, comparator);
                quickSort(args, start + 1, end, comparator);
            }

        }


    }


        public static void main(String[] args) {

            String[] data = {"3", "5", "1", "4", "2"};
            System.out.println(printMinNumber(data));

            String[] data2 = {"3", "32", "321"};
            System.out.println(printMinNumber(data2));

            String[] data3 = {"3", "323", "32123"};
            System.out.println(printMinNumber(data3));

            String[] data4 = {"1", "11", "111"};
            System.out.println(printMinNumber(data4));

            String[] data5 = {"321"};
            System.out.println(printMinNumber(data5));


    }


}
