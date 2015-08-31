/**
 * Created by salla_000 on 24.08.2015.
 */
public class Point implements Comparable<Point> {
    private int x;
    private int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public int compareTo(Point o) {
        return (this.y != o.y) ? (this.y - o.y) : (this.x - o.x);
    }
}
