import java.util.ArrayList;
import java.util.List;

/**
 * Created by salla_000 on 24.08.2015.
 */
public class Field {
    public static final int WIDTH = 10;
    public static final int HEIGHT = 20;
    private final List<Layer> layers = new ArrayList<Layer>();

    public boolean checkPoints(Iterable<Point> points) {
        for (Point p: points) {
            if (!checkPoint(p)) {
                return false;
            } else {
                continue;
            }
        }
        return true;
    }

    private boolean checkPoint(Point p) {
        if (p.getY() >= layers.size()) {
            return true;
        }
        if (p.getX() < 0 || p.getX() >= Field.WIDTH || p.getY() < 0) {
            return false;
        }
        if (layers.get(p.getY()).checkBrick(p.getX())) {
            return false;
        } else {
            return true;
        }
    }

    private void removeLayer(int index) {
        layers.remove(index);
    }

    private class Layer {
        int brickCount = 0;
        final int index;
        public Layer(int index) {
            this.index = index;
        }
        final boolean[] elems = new boolean[WIDTH];

        public void setBrick(int i) {
            assert elems[i] == false;
            elems[i] = true;
            brickCount++;
        }

        public boolean checkBrick(int i) {
            return elems[i];
        }
    }
}
