package main.java.model;

public abstract class Type {
    protected Integer min;
    protected Integer max;
    protected String symbol;


    public Type(String symbol, Integer min, Integer max){
        this.symbol = symbol;
        this.min = min;
        this.max = max;
    }

    public Integer getMin() {
        return min;
    }

    public Integer getMax() {
        return max;
    }

    public String getSymbol() {
        return symbol;
    }

    @Override
    public abstract String toString();
}
