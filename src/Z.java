import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by salla_000 on 25.08.2015.
 */
public class Z extends Block {

    public Z(Field field) {
        super(field);
        //forming an Z-plank in the upper invisible part of the game field
        points.add(new Point(Field.WIDTH / 2 + 1, Field.HEIGHT));
        points.add(new Point(Field.WIDTH / 2, Field.HEIGHT ));
        points.add(new Point(Field.WIDTH / 2, Field.HEIGHT + 1));
        points.add(new Point(Field.WIDTH / 2 - 1, Field.HEIGHT + 1));
    }

    @Override
    protected SortedSet<Point> rotateRightResult() {
        SortedSet<Point> newPoints = new TreeSet<Point>();
        Point[] pointArray = (Point[]) points.toArray();
        assert pointArray.length == 4;
        if (pointArray[0].getX() == pointArray[1].getX()) {
            /*
              x x                 x
                x x    ->       x x
                                x
             */
            newPoints.add(new Point(pointArray[0].getX(), pointArray[0].getY()));
            newPoints.add(new Point(pointArray[0].getX() + 1, pointArray[0].getY()));
            newPoints.add(new Point(pointArray[0].getX(), pointArray[0].getY() - 1));
            newPoints.add(new Point(pointArray[0].getX() + 1, pointArray[0].getY() - 1));
        } else {
            /*
                  x        x x
                x x   ->     x x
                x
             */
            newPoints.add(new Point(pointArray[1].getX(), pointArray[1].getY()));
            newPoints.add(new Point(pointArray[1].getX() + 1, pointArray[1].getY()));
            newPoints.add(new Point(pointArray[1].getX(), pointArray[1].getY() + 1));
            newPoints.add(new Point(pointArray[1].getX() - 1, pointArray[1].getY() + 1));
        }
        return newPoints;
    }

    @Override
    protected SortedSet<Point> rotateLeftResult() {
        return this.points;
    }
}
