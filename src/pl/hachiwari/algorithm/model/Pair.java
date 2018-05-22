package pl.hachiwari.algorithm.model;

public class Pair {

    private final double offset;
    private final int type;

    public Pair(double offset, int type) {
        this.offset = offset;
        this.type = type;
    }

    public double getOffset() {
        return offset;
    }

    public int getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "offset=" + offset +
                ", type='" + type + '\'' +
                '}';
    }
}
