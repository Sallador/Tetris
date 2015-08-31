import java.util.SortedSet;

/**
 * Created by salla_000 on 25.08.2015.
 */
public class O extends Block {
    public O(Field field) {
        super(field);
        // forming an O-block
        points.add(new Point(Field.WIDTH / 2, Field.HEIGHT));
        points.add(new Point(Field.WIDTH / 2 + 1, Field.HEIGHT));
        points.add(new Point(Field.WIDTH / 2 + 1, Field.HEIGHT + 1));
        points.add(new Point(Field.WIDTH / 2, Field.HEIGHT + 1));
    }

    @Override
    protected SortedSet<Point> rotateLeftResult() {
        return this.points;
    }

    @Override
    protected SortedSet<Point> rotateRightResult() {
        return this.points;
    }
}
