package cc150.chpt1;

/**
 * 1.3 Given two lines on a Cartesian plane, determine whether the two lines would intersect.
 * Created by zhengxiao on 7/13/14.
 */
public class Q3 {
    public static void main(String[] args) {
        int[] p1 = new int[]{1, 2};
        int[] p2 = new int[]{3, 4};
        int[] p3 = new int[]{2, 5};
        int[] p4 = new int[]{3, 1};

        System.out.println(intersect(p1, p2, p3, p4));
    }

    private static boolean intersect(int[] p1, int[] p2, int[] p3, int[] p4) {
        double epsilon = 0.00001;
        double k1 = (p2[1] - p1[1]) / (p2[0] - p1[0]);
        double k2 = (p4[1] - p3[1]) / (p4[0] - p3[0]);
        return (k1 - k2) < epsilon;
    }
}
