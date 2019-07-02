package ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private final Lines lines;
    private final int height;

    public Ladder(int width, int height) {

        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("라인 개수 또는 길이가 유효하지 않습니다.");
        }

        this.lines = Lines.of(width, height);
        this.height = height;
    }

    public List<Line> getLines() {

        return lines.getLines();
    }

    public int getHeight() {

        return height;
    }
}
