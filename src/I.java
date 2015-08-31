import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by salla_000 on 24.08.2015.
 */
public class I extends Block {

    public I(Field field) {
        super(field);
        //forming an I-plank in the upper invisible part of the game field
        points.add(new Point(Field.WIDTH / 2, Field.HEIGHT));
        points.add(new Point(Field.WIDTH / 2, Field.HEIGHT + 1));
        points.add(new Point(Field.WIDTH / 2, Field.HEIGHT + 2));
        points.add(new Point(Field.WIDTH / 2, Field.HEIGHT + 3));
    }

    @Override
    protected SortedSet<Point> rotateRightResult() {
        SortedSet<Point> newPoints = new TreeSet<Point>();
        Point[] pointArray = (Point[]) points.toArray();
        assert pointArray.length == 4;
        if (pointArray[0].getY() == pointArray[1].getY()) {
            /*
                 x
                 x
                 x    ->      x x x x
                 x
            */
            int startXpos = pointArray[0].getX() - 2;
            int commonYpos = pointArray[0].getY() - 2;
            int correction;
            if (startXpos < 0) {
                correction = -startXpos;
            } else if(startXpos + 3 >= Field.WIDTH) {
                correction = -1 * (Field.WIDTH - startXpos - 3 + 1);
            } else {
                correction = 0;
            }
            for (int i = 0; i < 4; i++) {
                newPoints.add(new Point(startXpos + correction + i, commonYpos));
            }
        } else {
            /*                         x
                                       x
                 x x x x      ->       x
                                       x
             */
            int commonXpos = pointArray[0].getX() + 2;
            int startYpos = pointArray[0].getY() - 1;
            for (int i = 0; i < 4; i++) {
                newPoints.add(new Point(commonXpos, startYpos + i));
            }

        }
        return newPoints;
    }


    //left rotation is disabled, so here is a plug method
    @Override
    protected SortedSet<Point> rotateLeftResult() {
        return this.points;
    }

}
