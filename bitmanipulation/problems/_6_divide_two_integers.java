package bitmanipulation.problems;

public class _6_divide_two_integers {
    public static void main(String[] args) {
        int dividend = 50, divisor = 5;

        int cnt = 0;

        while (dividend>=divisor) {
            int tmp = divisor;
            int multiple = 1;

            while (dividend>=(tmp<<1)) {
                    tmp = tmp<<1;
                    //while tmp total value changes from 10->20->40
                    //multiple also changes from 1->2->4->8
                    multiple = multiple<<1;
            }

            dividend = dividend - tmp;
            cnt = cnt + multiple;
        }

        System.out.println(cnt);
    }
}
