package cc150.chpt1;

/**
 * 1.10Given a two dimensional graph with 6000 points on it, find a line which passes the most number of points.
 * Created by zhengxiao on 7/13/14.
 */
public class Q10 {

    public static class Point {
        public double x;
        public double y;

        @Override
        public String toString() {
            return String.format("(%s,%s)", x, y);
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Point) {
                Point that = (Point) obj;
                return this.x == that.y && this.y == that.y;
            }
            return super.equals(obj);
        }
    }

    public static class Line {
        public static final double epsilon = 0.00001;
        public Point a;
        public Point b;

        public Line(Point point1, Point point2) {
            this.a = point1;
            this.b = point2;
        }

        public boolean passes(Point point) {
            return ((a.y - b.y) / (a.x - b.x) - (point.y - b.y) / (point.x - b.x)) < epsilon;
        }

        @Override
        public String toString() {
            return String.format("Line:{%s,%s}", a, b);
        }
    }

    public static void main(String[] args) {
        // generate 6000 points
        Point[] points = new Point[6000];
        for (int i = 0; i < points.length; i++) {
            Point point = new Point();
            point.x = Math.random() * 100;
            point.y = Math.random() * 100;
            points[i] = point;
        }

        Line mostLine = mostLine(points);
        System.out.println(mostLine);
    }

    private static Line mostLine(Point[] points) {
        int maxPassThrough = 0;
        Line maxLine = null;

        // for each pair of points
        for (Point point1 : points) {
            for (Point point2 : points) {
                if (point1.equals(point2)) continue;
                Line line = new Line(point1, point2);
                int passThrough = calcPassThrough(line, points);
                if (passThrough > maxPassThrough) {
                    maxPassThrough = passThrough;
                    maxLine = line;
                }
            }
        }
        System.out.println("maxPassThrough = " + maxPassThrough);

        return maxLine;
    }

    private static int calcPassThrough(Line line, Point[] points) {
        int passThrough = 0;
        for (Point point : points) {
            if (line.passes(point)) {
                passThrough++;
            }
        }
        return passThrough;
    }
}
