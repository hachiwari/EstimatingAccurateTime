package pl.hachiwari.algorithm;

import pl.hachiwari.TimeRange;
import pl.hachiwari.algorithm.model.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Intersection implements Algorithm {

    //https://en.wikipedia.org/wiki/Intersection_algorithm
    private List<Pair> timePairs = new ArrayList<>();
    private final TimeRange result = new TimeRange();
    private int f;
    private final int M;

    public Intersection(List<TimeRange> timeRanges) {
        timeRanges.forEach(timeRange -> {
            timePairs.add(new Pair(timeRange.getTimeStart(), -1));
            timePairs.add(new Pair((timeRange.getTimeStart() + timeRange.getTimeEnd()) / 2, 0));
            timePairs.add(new Pair(timeRange.getTimeEnd(), +1));
        });
        M = timePairs.size() / 3;
        timePairs = timePairs.stream().sorted((Pair::compareTo)).collect(Collectors.toList());
    }

    @Override
    public TimeRange getResult() {
        int midcount, endcount;
        double lower = 0, upper = 0;

        // f = 0 assuming all input intervals are valid
        for (f = 0; f < M/2; f++) {
            midcount = 0;
            endcount = 0;

            // find lower endpoint
            for (int i = 0; i < timePairs.size(); i++) {
                endcount -= timePairs.get(i).getType();
                lower = timePairs.get(i).getOffset();

                if (endcount >= (M - f)) { break; }
                if (timePairs.get(i).getType() == 0) {midcount = midcount + 1; }
            }
            endcount = 0;

            // find upper endpoint
            for (int i = timePairs.size() - 1; i >= 0; i--) {
                endcount += timePairs.get(i).getType();
                upper = timePairs.get(i).getOffset();

                if (endcount >= (M - f)) { break; }
                if (timePairs.get(i).getType() == 0) { midcount++; }
            }

            if (midcount <= f) { break; }
        }

        if (lower <= upper) {
            result.setTime(lower, upper);
        }

        return result;
    }

    @Override
    public String toString() {
        StringBuilder strResult = new StringBuilder();
        strResult.append("<< Intersection Algorithm >>\n");
        strResult.append("Sorted time pairs: ");
        timePairs.forEach(timePair -> strResult.append(String.format("<%.1f;%d> ", timePair.getOffset(), timePair.getType())));
        strResult.append(String.format("\nGood/Bad intervals = %d/%d", (M-f), f));

        TimeRange result = getResult();
        if (result.getTimeStart() != result.getTimeEnd()) {
            strResult.append(String.format("\nResult: [%.1f; %.1f]", result.getTimeStart(), result.getTimeEnd()));
        } else {
            strResult.append("\nFailed find right intervals!");
        }

        return strResult.toString();
    }
}
