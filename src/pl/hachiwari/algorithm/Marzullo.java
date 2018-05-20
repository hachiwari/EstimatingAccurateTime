package pl.hachiwari.algorithm;

import pl.hachiwari.TimeRange;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Marzullo implements Algorithm {

    private List<Pair> timePairs;
    private TimeRange result;

    public Marzullo(List<TimeRange> timeRanges) {
        timePairs = new ArrayList<>();
        timeRanges.forEach(timeRange -> {
            timePairs.add(new Pair(timeRange.getTimeStart(), -1));
            timePairs.add(new Pair(timeRange.getTimeEnd(), +1));
        });

        timePairs = timePairs.stream().sorted((Pair::compareTo)).collect(Collectors.toList());
    }

    @Override
    public void run() {
        result = new TimeRange();
        int best = 0, current = 0;

        for(int i = 0; i < timePairs.size(); i++) {
            current = current - timePairs.get(i).getType();

            if (current > best) {
                best = current;
                result.setTimeStart(timePairs.get(i).getOffset());
                result.setTimeEnd(timePairs.get(i+1).getOffset());
            }
        }
    }

    @Override
    public TimeRange getResult() {
        if (result == null) {
            run();
        }

        return result;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        timePairs.forEach(timePair -> result.append(String.format("<%d;%d> ", timePair.getOffset(), timePair.getType())));

        result.append(String.format("\nResult: [%d, %d]", getResult().getTimeStart(), getResult().getTimeEnd()));
        return result.toString();
    }
}
