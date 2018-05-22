package pl.hachiwari;

public class TimeRange {

    private double timeStart, timeEnd;

    public TimeRange() {
    }

    public TimeRange(double timeStart, double timeEnd) {
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
    }

    public double getTimeStart() {
        return timeStart;
    }

    public double getTimeEnd() {
        return timeEnd;
    }

    public void setTime(double timeStart, double timeEnd) {
        this.timeStart = timeStart;
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
