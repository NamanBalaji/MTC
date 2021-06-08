package CtCi.Recursion_and_Dynamic_Programming.RobotInAGrid;

public class Point {
    public int x;
    public int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object other) { // must take an "Object" as a parameter, not a
                                          // "Point", so that it overrides the .equals method
        if (other == this) {
            return true;
        } else if (other == null || !(other instanceof Point)) {
            return false;
        }
        Point otherPoint = (Point) other;
        return this.x == otherPoint.x && this.y == otherPoint.y;
    }

    @Override
    public int hashCode() {
        return 13 * x + 7 * y;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}
