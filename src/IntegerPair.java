public class IntegerPair {

    private Integer first;
    private Integer second;

    public IntegerPair(Integer first, Integer second) {
        this.first = first;
        this.second = second;
    }

    public Integer getFirst() {
        return first;
    }

    public Integer getSecond() {
        return second;
    }

    @Override
    public String toString() {

        return "(" + this.first + ", " + this.second + ")";
    }
}
