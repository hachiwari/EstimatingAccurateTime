package pl.hachiwari.algorithm.model;

public class Pair implements Comparable<Pair> {

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

    @Override
    public int compareTo(Pair o) {
        if (o == null) {
            return 1;
        }

        int compare = Double.compare(this.getOffset(), o.getOffset());

        if (compare != 0) {
            return compare;
        }

        return Integer.compare(o.getType(), this.getType());
    }
}
