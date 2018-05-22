package pl.hachiwari.algorithm;

import pl.hachiwari.TimeRange;
import pl.hachiwari.algorithm.model.Pair;

import java.util.ArrayList;
import java.util.List;

public class Marzullo implements Algorithm {

    // https://en.wikipedia.org/wiki/Marzullo%27s_algorithm
    private final List<Pair> timePairs = new ArrayList<>();
    private final TimeRange result = new TimeRange();

    public Marzullo(List<TimeRange> timeRanges) {
        timeRanges.forEach(timeRange -> {
            timePairs.add(new Pair(timeRange.getTimeStart(), -1));
            timePairs.add(new Pair(timeRange.getTimeEnd(), +1));
        });

        timePairs.sort((o1, o2) -> {
            int compare = Double.compare(o1.getOffset(), o2.getOffset());

            if (compare != 0) {
                return compare;
            }

            return Integer.compare(o2.getType(), o1.getType());
        });
    }

    @Override
    public TimeRange getResult() {
        int best = 0, current = 0;
        double bestStart = 0, bestEnd = 0;

        for(int i = 0; i < timePairs.size(); i++) {
            current -= timePairs.get(i).getType();

            if (current > best) {
                best = current;
                bestStart = timePairs.get(i).getOffset();

                if ((i+1) < timePairs.size()) {
                    bestEnd = timePairs.get(i + 1).getOffset();
                }
            }
        }

        result.setTime(bestStart, bestEnd);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder strResult = new StringBuilder();
        strResult.append("<< Algorithm Marzullo >>\n");
        strResult.append("Sorted time pairs: ");
        timePairs.forEach(timePair -> strResult.append(String.format("<%.0f;%d> ", timePair.getOffset(), timePair.getType())));
        strResult.append(String.format("\nResult: [%.0f, %.0f]", getResult().getTimeStart(), getResult().getTimeEnd()));
        return strResult.toString();
    }
}
