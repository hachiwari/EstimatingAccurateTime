package pl.hachiwari;

import pl.hachiwari.algorithm.Marzullo;

import java.util.LinkedList;
import java.util.List;

class Main {

    private static List<TimeRange> createTestTimeRanges() {
        List<TimeRange> timeRanges = new LinkedList<>();

        timeRanges.add(new TimeRange(3, 10));
        timeRanges.add(new TimeRange(1, 6));
        timeRanges.add(new TimeRange(4, 8));
        timeRanges.add(new TimeRange(6, 13));
        timeRanges.add(new TimeRange(9, 12));

        return timeRanges;
    }

    public static void main(String[] args) {
        Marzullo marzullo = new Marzullo(createTestTimeRanges());
        System.out.println(marzullo.toString());
    }
}
