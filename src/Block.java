import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by salla_000 on 24.08.2015.
 */

public abstract class Block {
    protected final Field field;
    protected enum Dirs {
        LEFT_SHIFT, RIGHT_SHIFT, DOWN_SHIFT, LEFT_ROTATION, RIGHT_ROTATION;
    }
    protected SortedSet<Point> points = new TreeSet<Point>();

    public Block(Field field) {
        this.field = field;
    }

    public boolean move(Dirs direction) {
        SortedSet<Point> newPoints = moveResult(direction);
        if (field.checkPoints(newPoints)) {
            points = newPoints;
            return true;
        } else {
            return false;
        }
    }


    private SortedSet<Point> moveResult(Dirs direction) {
        SortedSet<Point> res = new TreeSet<Point>();
        switch (direction) {
            case LEFT_SHIFT:
                for (Point p: points) {
                    res.add(new Point(p.getX() - 1, p.getY()));
                }
                break;
            case RIGHT_SHIFT:
                for (Point p: points) {
                    res.add(new Point(p.getX() + 1, p.getY()));
                }
                break;
            case DOWN_SHIFT:
                for (Point p: points) {
                    res.add(new Point(p.getX(), p.getY() + 1));
                }
                break;
            case LEFT_ROTATION:
                return rotateLeftResult();
            case RIGHT_ROTATION:
                return rotateRightResult();
             default:
                 assert false;
        }
        return res;
    }
    protected abstract SortedSet<Point> rotateLeftResult();
    protected abstract SortedSet<Point> rotateRightResult();
}
