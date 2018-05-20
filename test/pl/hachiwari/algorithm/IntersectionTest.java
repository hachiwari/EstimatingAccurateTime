package pl.hachiwari.algorithm;

import org.junit.Before;
import org.junit.Test;
import pl.hachiwari.TimeRange;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class IntersectionTest {

    private static final double DELTA = 0.01;

    private Intersection intersection;

    @Before
    public void setUp() {
        List<TimeRange> timeRanges = createTimeRangeList(
            new TimeRange(2, 5),
            new TimeRange(3, 7),
            new TimeRange(4, 9),
            new TimeRange(6, 12)
        );
        intersection = new Intersection(timeRanges);
    }

    @Test
    public void shouldResultBestStartSameWithExpected() {
        TimeRange expectedResult = new TimeRange(4, 7);
        TimeRange result = intersection.getResult();
        assertEquals(expectedResult.getTimeStart(), result.getTimeStart(), DELTA);
    }

    @Test
    public void shouldResultBestEndtSameWithExpected() {
        TimeRange expectedResult = new TimeRange(4, 7);
        TimeRange result = intersection.getResult();
        assertEquals(expectedResult.getTimeEnd(), result.getTimeEnd(), DELTA);
    }

    private static List<TimeRange> createTimeRangeList(Object ... list) {
        List<TimeRange> timeRanges = new LinkedList<>();
        Arrays.stream(list).forEach(o -> timeRanges.add((TimeRange) o));
        return timeRanges;
    }
}