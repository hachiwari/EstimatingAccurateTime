package pl.hachiwari.algorithm;

import org.junit.Before;
import org.junit.Test;
import pl.hachiwari.TimeRange;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class MarzulloTest {

    private static final double DELTA = 0.01;

    private Marzullo marzullo;

    @Before
    public void setUp() {
        List<TimeRange> timeRanges = createTimeRangeList(
                new TimeRange(3, 10),
                new TimeRange(1, 6),
                new TimeRange(4, 8),
                new TimeRange(6, 13),
                new TimeRange(9, 12)
        );
        marzullo = new Marzullo(timeRanges);
    }

    @Test
    public void shouldResultBestStartSameWithExpected() {
        TimeRange expectedResult = new TimeRange(4, 6);
        TimeRange result = marzullo.getResult();
        assertEquals(expectedResult.getTimeStart(), result.getTimeStart(), DELTA);
    }

    @Test
    public void shouldResultBestEndtSameWithExpected() {
        TimeRange expectedResult = new TimeRange(4, 6);
        TimeRange result = marzullo.getResult();
        assertEquals(expectedResult.getTimeEnd(), result.getTimeEnd(), DELTA);
    }

    private static List<TimeRange> createTimeRangeList(Object ... list) {
        List<TimeRange> timeRanges = new LinkedList<>();
        Arrays.stream(list).forEach(o -> timeRanges.add((TimeRange) o));
        return timeRanges;
    }
}