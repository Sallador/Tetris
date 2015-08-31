import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by salla_000 on 25.08.2015.
 */
public class J extends Block {

    public J(Field field) {
        super(field);
        //forming an J-plank in the upper invisible part of the game field
        points.add(new Point(Field.WIDTH / 2 - 1, Field.HEIGHT));
        points.add(new Point(Field.WIDTH / 2, Field.HEIGHT));
        points.add(new Point(Field.WIDTH / 2 + 1, Field.HEIGHT));
        points.add(new Point(Field.WIDTH / 2 - 1, Field.HEIGHT + 1));
    }

    @Override
    protected SortedSet<Point> rotateRightResult() {
        SortedSet<Point> newPoints = new TreeSet<Point>();
        Point[] pointArray = (Point[]) points.toArray();
        assert pointArray.length == 4;
        if (pointArray[0].getY() == pointArray[2].getY()) {
            /*
              x              x x
              x x x   ->     x
                             x
            */
            newPoints.add(new Point(pointArray[1].getX(), pointArray[1].getY() - 1));
            newPoints.add(new Point(pointArray[1].getX(), pointArray[1].getY()));
            newPoints.add(new Point(pointArray[1].getX(), pointArray[1].getY() + 1));
            newPoints.add(new Point(pointArray[1].getX() - 1, pointArray[1].getY() - 1));
        } else if (pointArray[0].getX() == pointArray[2].getX()) {
            /*
                x x
                x    ->    x x x
                x              x
             */
            int correction = (pointArray[0].getX() - 1 >= 0) ? 0 : 1;
            newPoints.add(new Point(pointArray[0].getX() - 1 + correction, pointArray[1].getY()));
            newPoints.add(new Point(pointArray[0].getX() + correction, pointArray[1].getY()));
            newPoints.add(new Point(pointArray[0].getX() + 1 + correction, pointArray[1].getY()));
            newPoints.add(new Point(pointArray[0].getX() + 1 + correction, pointArray[1].getY() - 1));
        } else if (pointArray[1].getY() == pointArray[3].getY()) {
            /*
                x x x           x
                    x    ->     x
                              x x
            */
            newPoints.add(new Point(pointArray[2].getX(), pointArray[2].getY() + 1));
            newPoints.add(new Point(pointArray[2].getX(), pointArray[2].getY()));
            newPoints.add(new Point(pointArray[2].getX(), pointArray[2].getY() - 1));
            newPoints.add(new Point(pointArray[2].getX() - 1, pointArray[2].getY() - 1));
        } else {
            /*
                 x
                 x     ->  x
               x x         x x x
            */
            int correction = (pointArray[2].getX() + 1 < Field.WIDTH) ? 0 : -1;
            newPoints.add(new Point(pointArray[2].getX() + correction, pointArray[2].getY()));
            newPoints.add(new Point(pointArray[2].getX() + 1 + correction, pointArray[2].getY()));
            newPoints.add(new Point(pointArray[2].getX() - 1 + correction, pointArray[2].getY()));
            newPoints.add(new Point(pointArray[2].getX() - 1 + correction, pointArray[2].getY() - 1));
        }
        return newPoints;
    }

    @Override
    protected SortedSet<Point> rotateLeftResult() {
        return this.points;
    }
}
