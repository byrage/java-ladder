package ladder.domain;

import java.util.Objects;

public class Point {

    private static final int FIRST = 0;
    private static final int NEXT = 1;
    private static final int PREV = 1;

    private int position;
    private Direction direction;

    private Point(int position, Direction direction) {

        this.position = position;
        this.direction = direction;
    }

    public static Point of(int position, Direction direction) {

        return new Point(position, direction);
    }

    public static Point first(boolean generateValue) {

        return Point.of(FIRST, Direction.first(generateValue));
    }

    public static Point middle(Point before, boolean generateValue) {

        return Point.of(before.position + NEXT, Direction.middle(before.direction, generateValue));
    }

    public static Point last(Point before) {

        return Point.of(before.position + NEXT, Direction.last(before.direction));
    }

    public int move() {

        if (direction == Direction.LEFT) {
            return position - PREV;
        }

        if (direction == Direction.RIGHT) {
            return position + NEXT;
        }

        return position;
    }

    public Direction getDirection() {

        return direction;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return position == point.position &&
                direction == point.direction;
    }

    @Override
    public int hashCode() {

        return Objects.hash(position, direction);
    }

    @Override
    public String toString() {

        return "Point{" +
                "position=" + position +
                ", direction=" + direction +
                '}';
    }
}
