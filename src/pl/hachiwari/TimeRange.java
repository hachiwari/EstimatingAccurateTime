package pl.hachiwari;

public class TimeRange {

    private int timeStart, timeEnd;

    public TimeRange() {
    }

    public TimeRange(int timeStart, int timeEnd) {
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
    }

    public int getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(int timeStart) {
        this.timeStart = timeStart;
    }

    public int getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(int timeEnd) {
        this.timeEnd = timeEnd;
    }

    @Override
    public String toString() {
        return "TimeRange{" +
                "timeStart=" + timeStart +
                ", timeEnd=" + timeEnd +
                '}';
    }
}
